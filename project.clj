(defproject ashikasoft-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies
  [[org.clojure/clojure "1.10.1"]
   [ring "1.8.2"]
   [stasis "2.5.0"]]
  :plugins [[lein-ring "0.12.5"]] 
  :repl-options {:init-ns ashikasoft-site.core}
  :ring {:handler ashikasoft-site.core/app})
