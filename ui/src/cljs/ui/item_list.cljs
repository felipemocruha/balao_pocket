(ns ui.item_list
  (:require
   [re-frame.core :as rf]
   [ui.subs :as subs]))

(def root-style
  {:width "400px"
   :height "450px"
   :border-radius "2px"
   :background-color "transparent"})

(def head-style
  {:width "100%"
   :height "40px"
   :display "flex"
   :justify-content "center"
   :align-items "center"
   :box-shadow "0px 1px"
   :color "#000"
   :background-color "#FFCC80"})

(def content-style
  {:width "100%"
   :height "410px"
   :display "flex"
   :flex-direction "column"
   :justify-content "center"
   :align-items "space-around"
   :box-shadow "0px 1px"
   :color "#000"
   :margin-bottom "50px"
   :overflow-y "auto"
   :background-color "transparent"})

(def line-style
  {:margin-top "3px"
   :display "flex"
   :width "100%"
   :height "40px"
   :min-height "40px"
   :justify-content "space-around"
   :align-items "center"
   :border-radius "2px"
   :box-shadow "0px 1px"
   :cursor "pointer"})

(defn head []
  [:div {:style head-style}
   "Items"])

(defn get-color [flag]
  (cond
    (= flag true) "#FFF3E0"
    (= flag false) "#FFE0B2"))

(defn make-items2 [items]
  (let [flag (atom false)]
    (map
     (fn [item]
       (do (swap! flag not)
           [:div
            {:style (assoc line-style :background-color (get-color @flag))}
            [:input {:type "checkbox"}]
            [:div {:style {:width "50%"}} (:name item)]])) items)))
     
(defn content [items]
  [:div {:style content-style}
   (make-items2 items)])

(defn root [items]
  [:div {:style root-style}
   [head]
   [content items]])
