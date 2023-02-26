(ns fe-10x.components.button.label
  (:require [fe-10x.components.button.template :as btn]))


(defn base [labl disb]
  [btn/label {:labl labl :dis? disb}])

(defn neutral [labl disb]
  [btn/label {:labl labl :vart "neutral" :dis? disb}])

(defn primary [labl disb]
  [btn/label {:labl labl :vart "brand" :dis? disb}])
(defn primary-alt [labl disb]
  [btn/label {:labl labl :vart "outline-brand" :dis? disb}])

(defn success [labl disb]
  [btn/label {:labl labl :vart "success" :dis? disb}])

(defn warning [labl disb]
  [btn/label {:labl labl :vart "destructive" :dis? disb}])
(defn warning-alt [labl disb]
  [btn/label {:labl labl :vart "text-destructive" :dis? disb}])

(defn inverse [labl disb]
  [btn/label {:labl labl :vart "inverse" :dis? disb}])