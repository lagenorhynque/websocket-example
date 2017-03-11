(ns websocket-example.app
  (:require [websocket-example.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
