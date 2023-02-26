(ns fe-10x.components.button.label-lt
  (:require [fe-10x.components.button.template :as btn]))

(defn base [labl icon disb]
  [btn/label-lt {:labl labl :icns {:icon icon} :dis? disb}])

(defn neutral [labl icon disb]
  [btn/label-lt {:labl labl :vart "neutral" :icns {:icon icon} :dis? disb}])