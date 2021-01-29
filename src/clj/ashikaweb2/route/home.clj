(ns ashikaweb2.route.home
  (:require
    [ashikaweb2.controller.main :as main]
    [ashikasoft.webstack.middleware :as middleware]))

(defn- applyfn
  "A short form of (fn [_]( ... )).
  This returns a function that calls the given function with its arguments.
  The returned function is arity-1, but ignores its argument.
  We use this when we want to supply a handler (which must have arity-1)
  to the route definition, but we don't actually need the argument."
  ([f] (fn [_] (f)))
  ([f & args] (fn [_] (f))))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" (applyfn main/render)]])

