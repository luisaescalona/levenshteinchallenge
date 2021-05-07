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

Development process
-------------------
The function (about 30 min)
------------
First, I searched for the Levenshtein distance, understanding the algorithm, and coded it. 

Then, because the distance is an important factor, I coded a function considering the distance to decide to proceed or not with the recursive calls.

If the words are equal, increment the frequency.

Else, if the difference in the words’ length is bigger than the tolerance, there is no point in calculating the distance, the word is discarded.

Else, calculate the distance. The new function receives the tolerance param and evaluates the difference in the two words’ length. If it’s not bigger than the tolerance, do the calculation, calling recursively if necessary. 

This approach saves time and memory, avoiding unnecessary recursive calls because we don’t need to know the exact difference between the words, we only need to know if the difference is within the tolerance.

The API (about 1 hour)
-------
I created a new Spring Boot Project and added the classes to do the calculation.
To handle the request, I first tested with GetMapping that sends an object with the frequency and the similars’ array. It always worked fine and return the expected value. 
Then, I changed to a PostMapping that receives and sends JSON. And also, I modified the Cors registry to accept requests from anywhere.

NOTE: In all my years of experience, I’ve never used Spring before. It took me a little to know the syntaxes. I’m used to changing platforms and languages, so it was no problem.

The Client (about 30 min) 
----------
To test the API, I developed a simple web form containing the fields Word, List of words and Tolerance. The form makes a submit of the data to the server and receives a JSON, that is shown on the page as the result.
A copy of the client html file is in the "client" folder.

Live testing
------------
A working client web page, developed with VueJS, is available at http://lescalona.de-fra1.cloudjiffy.net.

A working API is available at http://node66308-lescalona.de-fra1.cloudjiffy.net:11101.
