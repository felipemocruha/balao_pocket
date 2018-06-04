(ns ui.calendar
  (:require
   [re-frame.core :as rf]
   [ui.subs :as subs]))

(def root-style
  {:width "550px"
   :height "550px"
   :border-radius "2px"
   :background-color "#fff"})

(def nav-style
  {:width "100%"
   :height "40px"
   :display "flex"
   :justify-content "space-around"
   :color "#000"
   :align-items "center"
   :box-shadow "0px 1px"})

(def head-style {})

(def line-style {})

(def cell-style {})

(defn nav [month year]
  [:div {:style nav-style}
   [:button "<"]
   [:div (str month " | " year)]
   [:button ">"]])

(defn head [])

(defn line [])

(defn cell [])

(defn root []
  [:div {:style root-style}
   [nav "June" "2018"]])

