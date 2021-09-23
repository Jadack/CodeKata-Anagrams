import com.anagram.AnagramsList;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class AnagramListTest {

  @Test
  public void testIfOneEntryReturnEmptyCollections() {
    final String[] wordList = {"testWord"};
    final Stream<String> wordStream = Arrays.stream(wordList);
    assertEquals(0, AnagramsList.anagramsListInsideFile(wordStream).size());
  }

  @Test
  public void testIfTwoNotAnagramsStringsReturnEmptyCollection() {
    final String[] wordList = {"sinks", "enlist"};
    final Stream<String> wordStream = Arrays.stream(wordList);
    assertEquals(0, AnagramsList.anagramsListInsideFile(wordStream).size());
  }

  @Test
  public void testIfTwoAnagramsStringsReturnOneCollection() {
    final String[] wordList = {"fresher", "refresh"};
    final Stream<String> wordStream = Arrays.stream(wordList);
    assertEquals(1, AnagramsList.anagramsListInsideFile(wordStream).size());
  }

  @Test
  public void testIfReturnAnagramsOfInputFile() throws FileNotFoundException {
    final File fileName = new File("resources/wordList.txt");
    final FileReader inputFile = new FileReader(fileName);
    final BufferedReader reader = new BufferedReader(inputFile);
    final Collection<ArrayList<String>> anagramsInsideFile = AnagramsList.anagramsListInsideFile(reader.lines());
    assertEquals(20683, anagramsInsideFile.size());
  }
}
