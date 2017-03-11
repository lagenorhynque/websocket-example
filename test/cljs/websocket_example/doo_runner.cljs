(ns websocket-example.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [websocket-example.core-test]))

(doo-tests 'websocket-example.core-test)

