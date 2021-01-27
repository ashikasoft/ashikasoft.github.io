(ns ashikaweb2.view.main
  (:require
    [ashikaweb2.view.parts :as parts]
    [hiccup.page :as page]))

(defn render []
  (parts/appbase
    (list
      (page/include-js "/js/app.js")
      [:script
        {:type "text/javascript"}
        "ashikaweb2.client.main.init();"])))


