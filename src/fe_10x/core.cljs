(ns fe-10x.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [fe-10x.events :as events]
   [fe-10x.routes :as routes]
   [fe-10x.views :as views]
   [fe-10x.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (routes/start!)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
