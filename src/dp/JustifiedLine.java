package dp;

import java.util.ArrayList;
import java.util.List;

public class JustifiedLine {

	public static int justify(List<String> wordList, int lineLimit) {
		if (wordList.size() <= 1)
			return 0;
		int wordLen = 0;
		wordLen += wordList.remove(0).length();
		while (wordList.size() > 0
				&& wordLen + 1 + wordList.get(0).length() <= lineLimit) {
			wordLen += 1 + wordList.remove(0).length();
		}
		if (wordList.size() == 0)
			return 0;
		else
			return lineLimit - wordLen + justify(wordList, lineLimit);

	}
	public static void main(String[] args) {
		List<String> wordList = new ArrayList<>();
		wordList.add("geeks");
		wordList.add("for");
		wordList.add("geeks");
		wordList.add("presents");
		wordList.add("word");
		wordList.add("wrap");
		wordList.add("problem");

		System.out.println(justify(wordList, 15));

	}

}
