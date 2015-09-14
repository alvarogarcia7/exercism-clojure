(ns bob)

(defn- has-question? [question]
  (<= 1 (count (filter #(= "?" %) (clojure.string/split question #"")))))

(defn- is-shouting? [question]
  (not (re-matches #".*[a-z]+.*" question)))

   
(defn response-for [question]
  (cond
    (is-shouting? question) "Whoa, chill out!"
    (has-question? question) "Sure."
    :else "Whatever."))

