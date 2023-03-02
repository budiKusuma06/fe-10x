(ns fe-10x.pages.auth.view
  (:require [re-frame.core :as re-frame]
            [fe-10x.pages.auth.subs :as subs]
            [fe-10x.routes :as routes]
            [reagent.core :as r]
            [fe-10x.components.button.label :as btn-label]
            [fe-10x.components.button.label-lt :as btn-lt]
            [fe-10x.components.input.label :as input-label]
            [fe-10x.components.checkbox.template :as checkbox]))

(def text-color-normal (re-frame/subscribe [::subs/text-color-normal]))

(defn signin [_]
 (let [show-password? (r/atom false)
       set-show-password #(swap! show-password? not)]
   (fn [{:keys [email set-email password set-password set-signin]}]
     [:div {:style {:width "320px"}}
      ;; header
      [:div {:class "slds-col slds-text-heading_medium"
             :style {:color @text-color-normal}}
       "Sign in"]
      ;; form
      [:div {:class "slds-col slds-p-top_medium"}
       [input-label/label 
        "Email"
        @email 
        "text" 
        false 
        false 
        {:error? false :mesg "ada yang salah nih"} 
        set-email]]
      [:div {:class "slds-col slds-p-top_x-small"}
       [input-label/label 
        "Password" 
        @password 
        (if @show-password? "text" "password") 
        false 
        false 
        {:error? false :mesg "ada yang salah nih"} 
        set-password]]
      ;; checkbox
      [:div {:class "slds-col slds-p-top_medium"}
       [checkbox/base 
        {:labl "Show password" :evnt set-show-password}]]
      ;; note
      [:div {:class "slds-col slds-p-top_medium"
             :style {:color @text-color-normal}}
       [:div {:class "slds-p-horizontal_x-small"} 
        "Not your device? Use a Private Window to sign in."]]
      ;; button
      [:div {:class "slds-col slds-p-top_medium"}
       [:div {:class "slds-grid slds-gutters"
              :style {:display "flex"}}
        [:div {:class "slds-col"
               :style {:display "flex"
                       :justify-content "flex-start"}}
         [:div {:on-click set-signin}
          [btn-label/base 
           "Forgot password" 
           false]]]
        [:div {:class "slds-col"
               :style {:display "flex"
                       :justify-content "flex-end"}}
         [:div
          [btn-label/primary 
           "Sign in" 
           false]]]]]])))

(defn forget-password [_]
  (let []
    (fn [{:keys [email set-email set-signin]}]
      [:div {:style {:width "320px"}}
       ;; header
       [:div {:class "slds-col slds-text-heading_medium"
              :style {:color @text-color-normal}}
        "Forget password"]
       ;; form
       [:div {:class "slds-col slds-p-top_medium"}
        [input-label/label 
         "Email" 
         @email 
         "text" 
         false 
         false 
         {:error? false :mesg "ada yang salah nih"} 
         set-email]]
       ;; button
       [:div {:class "slds-col slds-p-top_large"}
        [:div {:class "slds-grid slds-gutters"
               :style {:display "flex"}}
         [:div {:class "slds-col"
                :style {:display "flex"
                        :justify-content "flex-start"}}
          [:div {:on-click set-signin}
           [btn-lt/base 
            "Cancel" 
            "back" 
            false]]]
         [:div {:class "slds-col"
                :style {:display "flex"
                        :justify-content "flex-end"}}
          [:div
           [btn-label/primary 
            "Send" 
            false]]]]]])))

(defn auth []
  (let [email (r/atom "")
        set-email #(reset! email (-> % .-target .-value))

        password (r/atom "")
        set-password #(reset! password (-> % .-target .-value)) 

        signin? (r/atom true)

        set-signin (fn []
                     (swap! signin? not))] 
    (fn [] 
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
         (if @signin?
           [signin {:email email 
                    :set-email set-email 
                    :password password 
                    :set-password set-password 
                    :set-signin set-signin}]
           [forget-password {:email email 
                             :set-email set-email 
                             :set-signin set-signin}]) 
         ]]
       [:div {:class "slds-col slds-size_1-of-12"}]])))

(defmethod routes/panels :auth-panel [] [auth])