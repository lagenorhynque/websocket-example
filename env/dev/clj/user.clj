(ns user
  (:require [mount.core :as mount]
            [websocket-example.figwheel :refer [start-fw stop-fw cljs]]
            websocket-example.core))

(defn start []
  (mount/start-without #'websocket-example.core/http-server
                       #'websocket-example.core/repl-server))

(defn stop []
  (mount/stop-except #'websocket-example.core/http-server
                     #'websocket-example.core/repl-server))

(defn restart []
  (stop)
  (start))


