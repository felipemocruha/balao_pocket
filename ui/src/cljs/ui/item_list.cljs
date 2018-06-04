(ns ui.item_list
  (:require
   [re-frame.core :as rf]
   [ui.subs :as subs]))

(def root-style
  {:width "400px"
   :height "450px"
   :border-radius "2px"
   :background-color "#fff"})

(def head-style
  {:width "100%"
   :height "40px"
   :display "flex"
   :justify-content "center"
   :align-items "center"
   :box-shadow "0px 1px"
   :color "#000"})

(def content-style
  {:position "relative"
   :width "100%"
   :display "flex"
   :flex-direction "column"
   :justify-content "center"
   :align-items "space-around"
   :box-shadow "0px 1px"
   :color "#000"})

(def line-style
  {:display "flex"
   :width "100%"
   :height "50px"
   :justify-content "space-around"
   :align-items "center"
   :box-shadow "0px 1px"})

(defn head []
  [:div {:style head-style}
   "Items"])

(defn make-items [items]
  (for [item items]
    [:div {:style line-style}
     [:input {:type "checkbox"}]
     [:div {:style {:width "50%"}} (:name item)]]))

(defn content [items]
  [:div {:style content-style}
   (make-items items)])

(defn root [items]
  [:div {:style root-style}
   [head]
   [content items]])
