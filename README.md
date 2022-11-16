# Levenshtein
Given a word and a set of words, determine how often the word is repeated in the set, and which words are similar (Levenshtein distance is not more than 1).

Input
-----
Word: String - The base word

List of words: String - Words to analyze separated by space

Tolerance (optional): Int - The maximum distance to be considered 

Output
------
Frequency: Int - How many times the word is repeated in the set

Similar: String List - Words with Levenshtein distance <= 1
