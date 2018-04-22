package ua.lpnuai.oop.boksho08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public final class Text {
	
	public static final String WORDS_SEPARATORS = "`1234567890?/,. ";
	public static final String SENTENCES_SEPARATORS = ".?!";

	private Text() {

	}

	public static Iterable<String> extractAllSentences(String text) {
		return extractElementsFromText(text, SENTENCES_SEPARATORS);
	}

	public static Iterable<String> findLongestWordsInLines(Iterable<String> lines) {
		List<String> longestWords = new ArrayList<String>();
		for (String sentence : lines) {
			longestWords.add(findLongestWordtInText(sentence));
		}
		return longestWords;
	}

	public static Iterable<String> findShortestWordsInLines(Iterable<String> lines) {
		List<String> shortestWords = new ArrayList<String>();
		for (String sentence : lines) {
			shortestWords.add(findShortestWordInText(sentence));
		}
		return shortestWords;
	}

	private static String findWordInText(String text, Comparator<String> comparator) {
		List<String> words = (List<String>) extractWordsFromText(text);
		Collections.sort(words, comparator);
		return words.get(0);
	}

	public static String findLongestWordtInText(String text) {
		return findWordInText(text, new Comparator<String>() {
			@Override
			public int compare(String leftWord, String rightWord) {
				if (leftWord.length() > rightWord.length()) {
					return -1;
				} else if (leftWord.length() < rightWord.length()) {
					return 1;
				}
				return 0;
			}
		});
	}

	public static String findShortestWordInText(String text) {
		return findWordInText(text, new Comparator<String>() {

			@Override
			public int compare(String leftWord, String rightWord) {
				if (leftWord.length() < rightWord.length()) {
					return -1;
				} else if (leftWord.length() > rightWord.length()) {
					return 1;
				}
				return 0;
			}
		});
	}

	public static Iterable<String> extractElementsFromText(String text, String separators) {
		List<String> elements = new ArrayList<String>();

		StringTokenizer elementExtractor = new StringTokenizer(text, separators);
		while (elementExtractor.hasMoreTokens()) {
			elements.add(((String) elementExtractor.nextElement()).trim());
		}

		return elements;
	}

	
	public static Iterable<String> extractWordsFromText(String text) {
		return extractElementsFromText(text, WORDS_SEPARATORS);
	}
}  