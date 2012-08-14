(ns PokerHands.core
  (:gen-class))

(def ranks {:J 11 :Q 12 :K 13 :A 14})

(defn rank [card]
	(let [cardrank (first card)]
		(if (contains? ranks cardrank)
			(ranks cardrank)
			cardrank)))

(defn highest-card [hand]
	(->> (sort-by rank hand) 
		last 
		rank))

(defn bestest-hand [hand1 hand2]
	(let [highest-1 (highest-card hand1)
		  highest-2 (highest-card hand2)]
	(if (= highest-1 highest-2) [] 
		(if (> highest-1 highest-2)
			[hand1]
			[hand2]))
		))

(defn pairs [hand]
	(->> hand
		(group-by rank)
		(map second)
		(filter #(= (count %) 2))
		(map first)
		(map rank)
		))

