(ns ashikaweb2.controller.main
  (:require
    [ring.util.http-response :refer [content-type ok]]
    [ashikaweb2.view.main :as view.main]))

(defn render []
  (->(ok (view.main/render))
     (content-type "text/html; charset=utf-8")))
