(ns web-plotter.core)

(defn ^:export hello [world]
  (js/alert (str "Hello " world)))
