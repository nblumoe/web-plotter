(ns web-plotter.server
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [clojure.string :as str])
  (:use compojure.core
        ring.adapter.jetty
        [ring.middleware.content-type :only (wrap-content-type)]
        [ring.middleware.file :only (wrap-file)]
        [ring.middleware.file-info :only (wrap-file-info)]
        [ring.middleware.stacktrace :only (wrap-stacktrace)]
        [ring.util.response :only (redirect)]
        [hiccup core element page]
        [hiccup.middleware :only (wrap-base-url)]))

(defn index-page []
  (html5
    [:head
     [:title "Web Plotter"]]
    [:body
     [:h1 {:id "web-plotter"} "Web Plotter"]
     [:ol
      [:li [:a {:href "/data.json"} "Some example data"]]]
     (include-js "js/main.js")
     (javascript-tag "web_plotter.core.hello('from me ');")]))

(defroutes
  site-routes
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site site-routes)
    (wrap-file "resources")
    (wrap-file-info)
    (wrap-content-type)))
