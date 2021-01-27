(ns ashikaweb2.client.main
  (:require
    [clojure.string :as string]
    [ashikasoft.jdict :as jdict]
    [reagent.core :as r]
    [reagent.dom :as rdom]
    [ashikaweb2.client.ui :as ui]
    [ajax.core :refer [GET POST]]))

(defonce state (r/atom {}))

(defn home-page []
  (let [{:keys [search dict results]} @state
        loaded? (not (nil? dict))
        lookup-fn #(when (and loaded? (not (string/blank? search)))
                     (.preventDefault %)
                     (.stopPropagation %)
                     (jdict/async-lookup state dict (string/trim search))
                     false)]
    [:div.container
     [:h1 "Japanese Dictionary 2"]
     [:form.inline
      {:on-submit lookup-fn}
      [:label.mr-1 "Search:"]
      [:input.mr-1
       {:type :text
        :value search
        :size 50
        :on-change #(swap! state assoc :search (ui/target-value %))}]
      [:input
       {:type :button
        :value (if (not loaded?) "Loading dictionary..." "Go")
        :enabled loaded?
        :on-click lookup-fn}]]
     
     [:div
      (when (seq results)
        (map-indexed
         (fn [idx entry]
           ^{:key idx}
           [:p (str entry)])
         results))]]))

(defn mount-components []
  (rdom/render [home-page] (.getElementById js/document "app")))

(defn init-state! []
  (jdict/async-create-dict state "/data"))

(defn ^:export init []
  (mount-components)
  (init-state!))

