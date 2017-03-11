(ns websocket-example.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [websocket-example.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[websocket-example started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[websocket-example has shut down successfully]=-"))
   :middleware wrap-dev})
