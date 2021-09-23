import com.anagram.AnagramList;
import org.junit.Test;

public class AnagramListTest {

  @Test
  public void testIfOneEntryReturnEmptyCollections() {
    final String[] wordList = {"testWord"};
    final Stream<String> wordStream = Arrays.Stream(wordList);
    assertEquals(0, AnagramList.anagramsListInsideFile(wordStream).size());
  }

  @Test
  public void testIfTwoNotAnagramsStringsReturnEmptyCollection() {
    final String[] wordList = {"sinks", "enlist"};
    final Stream<String> wordStream = Arrays.Stream(wordList);
    assertEquals(0, AnagramList.anagramsListInsideFile(wordStream).size());
  }

  @Test
  public void testIfTwoAnagramsStringsReturnOneCollection() {
    final String[] wordList = {"fresher", "refresh"};
    final Stream<String> wordStream = Arrays.Stream(wordList);
    assertEquals(1, AnagramList.anagramsListInsideFile(wordStream).size());
  }

  @Test
  public void testIfReturnAnagramsOfInputFile() {
    final File fileName = new File("resources/wordList.txt");
    final FileReader inputFile = new FileReader(fileName);
    final BufferReader reader = new BufferReader(inputFile);
    final Collection<Array<String>> anagramsInsideFile = AnagramList.anagramsInsideFile(reader.lines());
    assertEquals(20683, anagramsInsideFile.size());
  }
}
