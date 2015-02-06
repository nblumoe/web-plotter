
(defproject web-plotter "0.1.0-SNAPSHOT"
  :description "plotting with Incanter and NVD3"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [compojure "1.3.1"]]
  :plugins [[lein-ring "0.9.1"]]
  :ring {:handler web-plotter.server/app})
