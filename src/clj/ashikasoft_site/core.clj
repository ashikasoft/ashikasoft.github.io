(ns ashikasoft-site.core
  (:require [stasis.core :as stasis]))

(defn route []
  {"/" "hello world"})
(def app
  (stasis/serve-pages route))
