package com.nish.Assignment;

public class SentenceFormatterModel {
	String sentence;
	SentenceFormatterModel(String sentence){
		this.sentence = sentence;
	}
	
	public void formatSentence() {
		sentence = sentence.trim();
		sentence = sentence.replaceAll("\\s+", " ");
		sentence = sentence.toLowerCase();
		sentence = sentence.replaceAll("fun", "interesting");
		sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
		String[] words = sentence.split(" ");
		int wordCount = words.length;
		String firstWord = words[0];
		String lastWord = words[wordCount - 1];
		
		System.out.println("Formatted Sentence: " + sentence);
        System.out.println("Total words: " + wordCount);
        System.out.println("First word: " + firstWord);
        System.out.println("Last word: " + lastWord);
	}
}
