(ns websocket-example.routes.websockets
  (:require [compojure.core :refer [GET defroutes wrap-routes]]
            [clojure.tools.logging :as log]
            [immutant.web.async :as async]))

(defonce channels (atom #{}))

(defn connect! [channel]
  (log/info "channel opne")
  (swap! channels conj channel))

(defn disconnect! [channel {:keys [code reason]}]
  (log/info "close code: " code " reason: " reason)
  (swap! channels #(remove #{channel} %)))

(defn notify-clients! [channel msg]
  (doseq [channel @channels]
    (async/send! channel msg)))

(def websocket-callbacks
  "WebSocket callback functions"
  {:on-open connect!
   :on-close disconnect!
   :on-message notify-clients!})

(defn ws-handler [req]
  (async/as-channel req websocket-callbacks))

(defroutes websocket-routes
  (GET "/ws" [] ws-handler))
