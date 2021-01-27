(ns ashikaweb2.view.parts
  (:require
    [ashikaweb2.form :as form]
    [hiccup.core :as hc]
    [hiccup.page :as page]))

(defn appbase [content]
  (page/html5
    [:head
      [:meta {:charset "UTF-8"}]
      [:meta {:http-equiv "Content-Type" :content "text/html; charset=UTF-8"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
      [:link {:rel "shortcut icon" :type "image/png" :href "/img/favicon.png"}]
      [:title "Ashikasoft Dictionary"]
      (page/include-css
         "/assets/bootstrap/css/bootstrap.min.css"
         "/css/screen.css")
      (page/include-js
         "/assets/jquery/jquery.min.js"
         "/assets/bootstrap/js/bootstrap.min.js")]
    [:body
      (form/navbar [:a {:href "/"} "Home"])
      [:div#app
        [:div.container
          [:div.three-quarters-loader "Loading… (uses javascript)"]
          (or
            content
            [:noscript
              [:p "This page uses javascript, but it seems to be disabled. Please enable it and reload."]])]]]))
