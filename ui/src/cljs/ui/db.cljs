(ns ui.db)

(def default-db
  {:name "balao_pocket"
   :items (mock-items)
   :calendar (mock-calendar)})


(defn mock-items []
  [{:name "Remdeeeuiooo"}
   {:name "Livro"}
   {:name "Carregador"}])

(defn mock-calendar []
  {})
