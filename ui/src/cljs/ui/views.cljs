(ns ui.views
  (:require
   [re-frame.core :as rf]
   [ui.subs :as subs]
   [ui.calendar :as calendar]
   [ui.item_list :as items]))

(def home-style
  {:display "flex"
   :color "#fff"
   :justify-content "space-around"
   :align-items "center"
   :font-size "1.3em"})

(defn home-panel []
  (let [name (rf/subscribe [::subs/name])
        item-list (rf/subscribe [::subs/items])]
    [:div {:style home-style}
     [calendar/root]
     [items/root item-list]]))

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
