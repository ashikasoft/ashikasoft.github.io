(defproject ashikasoft-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://www.ashikasoft.com/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :min-lein-version "2.7.1"
  :dependencies
  [[org.clojure/clojure "1.10.1"]
   [org.clojure/clojurescript "1.10.773"]
   [reagent "1.0.0" ]
   [ring "1.8.2"]
   [org.eclipse.jetty/jetty-server "9.4.31.v20200723"]
   [org.eclipse.jetty.websocket/websocket-server "9.4.31.v20200723"]
   [org.eclipse.jetty.websocket/websocket-servlet "9.4.31.v20200723"]
   [stasis "2.5.0"]]
  :source-paths ["src/clj"]
  :plugins
  [[lein-cljsbuild "1.1.8"]
   [lein-ring "0.12.5"]] 
  :ring {:handler ashikasoft-site.core/app}
  :cljsbuild {:builds
              [{:source-paths ["src/cljs"]
                :compiler {:output-to "target/ashikadict.js"
                           :optimizations :advanced}}]}
  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
            "fig:test"  ["run" "-m" "figwheel.main" "-co" "test.cljs.edn" "-m" "ashikasoft-site.test-runner"]}

  :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.2.12"]
                                  [com.bhauman/rebel-readline-cljs "0.1.4"]]
                   
                   :resource-paths ["target" "resources"]
                   :clean-targets ^{:protect false} ["target" "resources/public/cljs-out"]}})
