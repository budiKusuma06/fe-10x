(ns fe-10x.pages.signin.view
  (:require [re-frame.core :as re-frame]
            [fe-10x.pages.signin.subs :as subs]
            [fe-10x.routes :as routes]
            [reagent.core :as r]
            [fe-10x.components.button.label :as btn-label]
            [fe-10x.components.input.label :as input-label]
            [fe-10x.components.checkbox.template :as checkbox]))

(defn signin []
  (let [form-signin (re-frame/subscribe [::subs/form-signin])
        text-color-normal (re-frame/subscribe [::subs/text-color-normal])
        password? (r/atom false)
        set-password #(swap! password? not)] 
    (fn []
      (println (if @password? "text" "password"))
      [:div {:class "slds-grid slds-gutters"
             :style {:width "100vw"
                     :height "100vh"}}
       [:div {:class "slds-col slds-size_1-of-12"}]
       [:div {:class "slds-col slds-size_10-of-12"
              :style {:display "flex"
                      :justify-content "center"
                      :align-items "center"}}
        [:div {:class "slds-p-horizontal_small slds-p-vertical_xx-large"
               :style {:border "1px solid #c5c5c5"
                       :border-radius "4px"
                       :background-color "#fff"}}
       ;; header
         [:div {:class "slds-col slds-text-heading_large"
                :style {:color @text-color-normal}}
          "Sign in"]
         [:div {:class "slds-col slds-text-heading_small slds-p-top_small"
                :style {:color @text-color-normal}}
          "Please sign in"]
       ;; form
         [:div {:class "slds-col slds-p-top_medium"}
          [input-label/label "Email" "text"]]
         [:div {:class "slds-col slds-p-top_x-small"}
          [input-label/label "password" (if @password? "text" "password")]]
         
       ;; test
         [:div {:class "slds-form-element"}
          [:label {:class "slds-form-element__label"
                   :for rand}
           "test"]
          [:div {:class "slds-form-element__control slds-p-top_xx-small"}
           [:input (merge {:class "slds-input"}
                          {:id rand}
                          {:type (if @password? "text" "password")}
                          {:placeholder "test"})]]]
         
       ;; checkbox
         [:div {:class "slds-col slds-p-top_medium"}
          [checkbox/base {:labl "Show password" :evnt set-password}]]
       ;; note
         [:div {:class "slds-col slds-p-top_medium"
                :style {:color @text-color-normal}}
          [:div {:class "slds-p-horizontal_x-small"
                 :style {:display "flex"
                         :align-items "center"}}
           [:div
            [:svg {:class "slds-button__icon"
                   :aria-hidden true}
             [:use {:xlink-href (str "/assets/icons/utility-sprite/svg/symbols.svg#warning")}]]]
           [:div {:class "slds-p-left_x-small"} "Not your computer? Use a Private Window to sign in."]]]
       ;; button
         [:div {:class "slds-col slds-p-top_large"}
          [:div {:class "slds-grid slds-gutters"
                 :style {:display "flex"}}
           [:div {:class "slds-col"
                  :style {:display "flex"
                          :justify-content "flex-start"}}
            [btn-label/base "Forgot password" false]]
           [:div {:class "slds-col"
                  :style {:display "flex"
                          :justify-content "flex-end"}}
            [btn-label/primary "Sign in" false]]]]]]
       [:div {:class "slds-col slds-size_1-of-12"}]])))

(defmethod routes/panels :signin-panel [] [signin])