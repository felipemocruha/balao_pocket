(ns ui.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as rf]
   [ui.events :as events]
   [ui.routes :as routes]
   [ui.views :as views]
   [ui.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (rf/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
