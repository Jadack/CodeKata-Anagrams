package com.anagram;
import com.anagram.AnagramsList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;

class AnagramsConsoleApp {
  static void readFile(String _path) throws FileNotFoundException {
    final File fileName = new File(_path);
    final FileReader inputFile = new FileReader(fileName);
    final BufferedReader reader = new BufferedReader(inputFile);
    final Collection<ArrayList<String>> anagramsInsideFile = AnagramsList.anagramsListInsideFile(reader.lines());
    System.out.println("Lista de Anagramas: ");
    for(ArrayList<String> anagrams : anagramsInsideFile) {
      System.out.println(anagrams);
    }
    System.out.println(" ");
    System.out.println("Número de Contuntos de Anagramas: " + anagramsInsideFile.size());
  }
  public static void main (String [] arg) throws FileNotFoundException {
    System.out.println("Algoritmo Contador de Anagramas");
    System.out.println(" ");
    long startTime = System.nanoTime();
    readFile("resources/wordList.txt");
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println(" ");
    System.out.println( "El algoritmo duró: " + duration / 1000000 + " milisegundos");
  }
}