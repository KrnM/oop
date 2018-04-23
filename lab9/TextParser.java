package ua.lpnuai.oop.boksho09;

final class TextParser {

	/**
	 * Container.
	 */
	static Container container = new Container();

	/**
	 * Private constructor.
	 */
	private TextParser() {
	}

	/**
	 * @param text text to parse
	 */
	public static void parser(final String text) {
		int size = countSentences(text); // i?a?aooiie e?eueino? ?a?aiu
		int number = 0; // ?ao?aiee aey noai?aiiy aeaiaio?a ianeao
		char dot = '.'; // aey ii??aiyiiy

		StringBuilder[] sentences = new StringBuilder[size]; // ianea ?a?aiu
		StringBuilder buffer = new StringBuilder(); // oei?aniaee aooa?
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != dot) {
				buffer.append(text.charAt(i)); // caianaiiy ai aooa?o, yeui neiaie - ia e?aiea
			}
			if (text.charAt(i) == dot) {
				sentences[number] = buffer; // noai?aiiy aeaiaioo ianeao
				buffer = new StringBuilder(); // iaioeaiiy aooa?o
				number++; // ca?euoaiiy ?ao?aieea
			}
		}
		splitter(sentences); // aeeeee iaoiao ?icaeooy ?a?aiu ia neiaa
	}

	/**
	 * @param sentences array of sentences
	 */
	public static void splitter(final StringBuilder[] sentences) {
		StringBuilder[][] words = new StringBuilder[sentences.length][]; // ianea ne?a
		StringBuilder buffer = new StringBuilder(); // noai?aiiy aooa?o

		for (int i = 0; i < sentences.length; i++) {
			int numOfWords = 0; // ci?iia-?ao?aiee
			int size = countWords(sentences[i]); // i?a?aooiie e?eueino? ne?a aey ?a?aiiy
			words[i] = new StringBuilder[size]; // caaaiiy ?ici???a ianeao
			for (int j = 0; j < sentences[i].length(); j++) {
				if (sentences[i].charAt(j) != ' ') {
					buffer.append(sentences[i].charAt(j)); // aiaaiiy ai aooa?o, yeui ia i?ia?euiee neiaie
				}
				if (sentences[i].charAt(j) == ' ' ) {
					words[i][numOfWords] = buffer; // caianaiiy aaieo ai ianeao
					int index = words[i][numOfWords].length() - 1; // ?iaaen inoaiiuiai neiaieo neiaa
					if (words[i][numOfWords].charAt(0) == words[i][numOfWords].charAt(index)) {
						container.add(words[i][numOfWords].toString());
					}
					buffer = new StringBuilder(); // iaioeaiiy aooa?o
					numOfWords++; // ca?euoaiiy ?ao?aieea
				}
			}
		}
	}

	/**
	 * @param text count sentences in text
	 * @return number of sentences
	 */
	public static int countSentences(final String text) {
		int numOfSentences = 0;
		char dot = '.';
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == dot) {
				numOfSentences++;
			}
		}
		return numOfSentences;
	}

	/**
	 * @param text your sentence
	 * @return number of words
	 */
	public static int countWords(final StringBuilder text) {
		int numOfWords = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				numOfWords++;
			}
		}
		return numOfWords;
	}

	/**
	 * empty result buffer.
	 */
	public static void emptyBuff() {
		container = new Container();
	}

	/**
	 * Print results on the screen.
	 */
	public static void showResults() {
		for (String item : container) {
			System.out.println(item);
		}
	}
}