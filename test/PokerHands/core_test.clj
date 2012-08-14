(ns PokerHands.core-test
  (:use clojure.test
        PokerHands.core))

(deftest rank-test
  (testing "rank should return rank of a card"
    (is (= 2 (rank [2 :H]))))
  (testing "rank of face card should return integer value"
    (is (= 14 (rank [:A :H])))))

(deftest highestcard-test
   (testing "should return :A"
   	 (is (= 14 (highest-card [ [5 :H] [2 :S] [:A :H] ]))))
   (testing "should return 10"
   	 (is (= 10 (highest-card [ [5 :H] [10 :S] [2 :H] ] )))))


(let [
	ten-high-hand [ [5 :H] [10 :S] [2 :H] ]
	jack-high-hand [ [6 :H] [:J :S] [3 :H] ]
	jack-high-hand2 [ [6 :D] [:J :D] [3 :S] ]
	jack-pair-hand [ [:J :C] [3 :D] [:J :S] ]
	ten-pair-hand [ [10 :C] [3 :D] [10 :S] ]
	three-3-hand [ [3 :C] [3 :D] [3 :S] [:A :D] [5 :H] ]	
	]
(deftest compare-hands-test
	(testing "should return the second hand"
		(is (= 
			[jack-high-hand]
			(bestest-hand ten-high-hand jack-high-hand ))))
	(testing "should return the first hand"
		(is (= 
			[jack-high-hand] 
			(bestest-hand jack-high-hand ten-high-hand ))))
	(testing "should return the second hand"
		(is (= 
			[]
			(bestest-hand jack-high-hand jack-high-hand2 ))))
	(testing "should return the second hand"
		(is (= 
			[ten-pair-hand]
			(bestest-hand jack-high-hand ten-pair-hand )))))

(deftest pairs-testing
	
	(testing "pears should return all pairs"
		(is (= 
			[11]
			(pairs jack-pair-hand)
			 )))
	(testing "pears should return []"
		(is (= 
			[]
			(pairs ten-high-hand)
			 )))
	(testing "pears should return all pairs"
		(is (= 
			[10]
			(pairs ten-pair-hand)
			 ))))

(deftest three-3-hand-test
	(testing "returns 3"
		))

)