Vu Nguyen (ID: 42182872)
Yang Jiao (ID: 82222745)

In our IndexDocument.pdf:

- All terms alphabetically in ascending order
- Format:

aisle           (df:1)	(idf: 2.447158)
	 19795 :1 :13	(tf: 0.076923)	(tf-idf weight: 0.031434)
 
Explain: 

19795 :1 :13	is PoemID :FrequencyOfTermWithinPoem :Position

- Break page when the term starts with a different letter.
- Calculation:
	term frequency: the number of the terms appears in a poem divides by the total number of terms in a poem
	inverted document frequency: log base 10 of the total number of document in corpus divides by the number of document that contains the term
