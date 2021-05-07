package com.labforward.dev;

public class Levenshtein {

	/**
     * Returns the minimum number between the 3 parameters.
     *
     * @param num1 number to be compared.
     * @param num2 number to be compared.
     * @param num3 number to be compared.
     * 
     * @return the minimum number between the 3 parameters.
     */
	public int min(int num1, int num2, int num3) {
		if (num1 <= num2 && num1 <= num3) {
		    return num1;
		} else if (num2 <= num3 && num2 <= num1) {
			return num2;
		} else {
			return num3;
		}
	}

	/**
     * Returns the Levenshtein distance between the 2 parameters.
     *
     * @param word1 String to be compared.
     * @param word2 String to be compared.
     * 
     * @return the Levenshtein distance between the 2 parameters.
     */
	public int lev(String word1, String word2) {
		if(word1.length() == 0)
			return word2.length();
		if(word2.length() == 0)
			return word1.length();
		if(word1.charAt(0) == word2.charAt(0)) {
			return lev(word1.substring(1), word2.substring(1));
		}
		else {
			return 1 + min(lev(word1.substring(1), word2),  lev(word1, word2.substring(1)),  lev(word1.substring(1), word2.substring(1)));
		}
	}
	

	/**
     * Returns the Levenshtein distance between 2 words 
     * or the minimum distance that is bigger than the tolerance.
     *
     * @param word1 String to be compared.
     * @param word2 String to be compared.
     * 
     * @return the Levenshtein distance between 2 words or the minimum distance that is bigger than the tolerance.
     */
	public int levTolerance(String word1, String word2, int tolerance) {
		int difference = Math.abs(word1.length() - word2.length());
		
		if(difference <= tolerance) {
			if(word1.length() == 0)
				return word2.length();
			if(word2.length() == 0)
				return word1.length();
			if(word1.charAt(0) == word2.charAt(0)) {
				return levTolerance(word1.substring(1), word2.substring(1), tolerance);
			}
			else {
				return 1 + min(	levTolerance(word1.substring(1), word2, tolerance), 
								levTolerance(word1, word2.substring(1), tolerance),  
								levTolerance(word1.substring(1), word2.substring(1), tolerance) );
			}
		}
		else {
			return difference;
		}
	}

}
