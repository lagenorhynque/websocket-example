(ns websocket-example.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[websocket-example started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[websocket-example has shut down successfully]=-"))
   :middleware identity})
