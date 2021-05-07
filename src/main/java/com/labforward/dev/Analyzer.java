package com.labforward.dev;

import java.util.ArrayList;

public class Analyzer {
	private int frequency;
	private ArrayList<String> similar;
	
	/**
     * Default constructor.
     * The frequency is set to 0.
     * The similar ArrayList is created empty.
     */
	public Analyzer(){
		this.setFrequency(0);
		this.setSimilar(new ArrayList<String>());
	}
	
	/**
     * Compares the each element of items with word.
     * If the Levenshtein distance is not bigger than the tolerance,
     * the element is added to the similar ArrayList.
     * If the word and the element are equal, the frequency is incremented.
     *
     * @param word  The base word to do the analysis
     * @param items The list of items to compare with the word
     * @param tolerance The maximum distance to consider an element as similar
     */
	public void analyze(String word, String[] items, int tolerance) {
		String item;
		Levenshtein lev = new Levenshtein();
		
		for(int k = 0; k < items.length; k++) {
			item = items[k];
			
			if(word.equals(item)) {
				this.incrementFrecuency();
			}
			else if(Math.abs(word.length() - item.length()) <= tolerance) {
				int distance = lev.levTolerance(word, item, tolerance);
				if(distance <= tolerance) {				
					this.addSimilar(item);
				}
			}
		}
	}
	
	public void addSimilar(String element) {
		this.similar.add(element);
	}
	
	public void incrementFrecuency() {
		this.frequency++;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frecuency) {
		this.frequency = frecuency;
	}

	public ArrayList<String> getSimilar() {
		return similar;
	}

	public void setSimilar(ArrayList<String> similar) {
		this.similar = similar;
	}
	

}
