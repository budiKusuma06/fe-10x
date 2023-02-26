(ns fe-10x.components.checkbox.template)

(defn rand-str [len]
  (apply str (take len (repeatedly #(char (+ (rand 26) 65))))))

(defn base [{:keys [labl evnt]}]
  (let [rand (rand-str 10)]
    (fn []
      [:div {:class "slds-form-element"}
       [:div {:class "slds-form-element__control"}
        [:div {:class "slds-checkbox"}
         [:input {:type "checkbox"
                  :id rand}]
         [:label {:class "slds-checkbox__label"
                  :for rand
                  :on-click evnt}
          [:span {:class "slds-checkbox_faux"}]
          [:span {:class "slds-form-element__label"}
           labl]]]]])))