package com.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class AnagramsList {
  public static Collection<ArrayList<String>> anagramsListInsideFile(Stream<String> wordStream) {
    ConcurrentHashMap<String, ArrayList<String>> anagramsHash = new ConcurrentHashMap<>();

    wordStream.parallel().forEach(word -> {
      char[] charWord = word.toLowerCase().toCharArray();
      Arrays.sort(charWord);
      String sortedWord = new String(charWord);

      anagramsHash.putIfAbsent(sortedWord, new ArrayList<>());
      anagramsHash.computeIfPresent(sortedWord, (k, list) -> {
        list.add(k);
        return list;
      });
    });

    Collection<ArrayList<String>> anagramList = anagramsHash.values();
    anagramList.removeIf(l -> l.size() == 1);
    return anagramList;
  }
}