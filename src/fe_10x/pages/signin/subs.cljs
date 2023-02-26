(ns fe-10x.pages.signin.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::form-signin
 (fn [db _]
   (:browser db)))

(re-frame/reg-sub
 ::text-color-normal
 (fn [db _]
   (:browser db)))