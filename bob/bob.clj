(ns bob)

(defn- has-question? [question]
  (<= 1 (count (filter #(= "?" %) (clojure.string/split question #"")))))

   
(defn response-for [question]
  (cond
    (has-question? question) "Sure."
    :else "Whatever."))

