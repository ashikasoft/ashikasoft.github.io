(ns ashikaweb2.app
  (:require
    [ashikaweb2.client.main :as main]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))
