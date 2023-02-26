(ns fe-10x.pages.auth.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::text-color-normal
 (fn [db _]
   (:browser db)))