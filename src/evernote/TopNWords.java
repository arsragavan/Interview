package evernote;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MinHeap {

	public ArrayList<Integer> heapify(ArrayList<Integer> a, int i, int n) {

		if (2 * i + 1 >= n)
			return a;

		if ((2 * i + 2 < n) && (a.get(2 * i + 2) < a.get(2 * i + 1))) {
			Integer temp = a.get(2 * i + 2);
			a.set(2 * i + 2, a.get(i));
			a.set(i, temp);
			return (heapify(a, 2 * i + 2, n));
		} else if (a.get(2 * i + 1) < a.get(i)) {
			Integer temp = a.get(2 * i + 1);
			a.set(2 * i + 1, a.get(i));
			a.set(i, temp);
			return (heapify(a, 2 * i + 1, n));
		}
		return a;
	}

	public static ArrayList<Integer> maxKElements(List<Integer> input, int k) {
		ArrayList<Integer> outputHeap = new ArrayList<>();
		if (input.size() > k) {
			for (int i = 0; i < k; i++) {
				outputHeap.add(i, input.get(i));
			}
			MinHeap minHeap = new MinHeap();
			for (int i = outputHeap.size() / 2; i >= 0; i--)
				outputHeap = minHeap.heapify(outputHeap, i, outputHeap.size());
			for (int i = k; i < input.size(); i++) {
				if (outputHeap.get(0) < input.get(i)) {
					outputHeap.set(0, input.get(i));
					outputHeap = minHeap.heapify(outputHeap, 0,
							outputHeap.size());
				}
			}
		} else
			outputHeap.addAll(input);
		return outputHeap;

	}

}

public class TopNWords {

	public static void main(String[] args) {

		Map<String, Integer> wordList = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		int count = Integer.parseInt(scanner.nextLine());
		while (count > 0) {
			String word = scanner.nextLine();
			Integer wordCount = wordList.get(word);
			if (wordCount == null)
				wordCount = -1;
			wordList.put(word, wordCount + 1);
		}
		int topCount = Integer.parseInt(scanner.nextLine());
		scanner.close();

		if (topCount < count) {
			int minCount = MinHeap.maxKElements(
					new ArrayList<Integer>(wordList.values()), topCount).get(0);
			for (String word : wordList.keySet())
				if (wordList.get(word) < minCount)
					wordList.remove(word);

		}
		/*
		 * TreeMap<String, Integer> wordList = new TreeMap<>( new
		 * Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { return
		 * o2.compareToIgnoreCase(o1); } }); Scanner scanner = new
		 * Scanner(System.in); int count = Integer.parseInt(scanner.nextLine());
		 * while (count > 0) { String word = scanner.nextLine(); if
		 * (wordList.containsKey(word)) wordList.put(word, wordList.get(word) +
		 * 1); else wordList.put(word, 1); count--; } int topCount =
		 * Integer.parseInt(scanner.nextLine()); scanner.close();
		 * ArrayList<Integer> topWordsCount = MinHeap.maxKElements( new
		 * ArrayList<Integer>(wordList.values()), topCount); int i = 0;
		 * TreeMap<Integer, String> possibleWords = new TreeMap<Integer,
		 * String>( new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return
		 * o2.compareTo(o1); } });
		 * 
		 * int totalCount = 0; for (String word : wordList.keySet()) { if
		 * (wordList.get(word) >= topWordsCount.get(0)) {
		 * System.out.println(wordList.get(word) + " " + word);
		 * possibleWords.put(wordList.get(word), word); } }
		 * 
		 * System.out.println(possibleWords.keySet());
		 * 
		 * for (Integer k : possibleWords.keySet()) { if (topCount > 0 &&
		 * totalCount < topCount) { System.out.println(possibleWords.get(k));
		 * totalCount++; } else break; }
		 */

	}
}

class Word implements Comparator<Word> {
	String word;
	Integer count;

	@Override
	public int compare(Word o1, Word o2) {
		if (o1.count > o2.count)
			return -1;
		else if (o1.count < o2.count)
			return 1;
		else
			return o1.word.compareTo(o2.word);
	}
}