import static org.junit.Assert.*; //imports the assert commands from the junit library
import java.beans.Transient;
import org.junit.*; //imports junit library
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest { //class header
    @Test //tells java that junit is going to run a test
    public void addition() { //method header for junit test
        assertEquals(2, 1 + 1); //tests if 2 is equivalent to 1 + 1
    }
    @Test
    public void testFile() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("test-file.md links didn't extract correctly", List.of("https://something.com", "some-page.html"), results);
    }
    @Test
    public void testFile2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("test-file2.md links didn't extract correctly", List.of("https://www.poptropica.com","not-even-real.html","https://www.netflix.com"), results);
    }
    @Test
    public void testFile3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("test-file3.md links didn't extract correctly", List.of(), results);
    }
    @Test
    public void testFile4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("test-file4.md links didn't extract correctly", List.of(), results);
    }
    @Test
    public void testFile5() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("test-file5.md links didn't extract correctly", List.of("https://something.com", "some-page.html", "http://google.com"), results);
    }
    @Test
    public void testFile6() throws IOException {
        Path fileName = Path.of("test-file6.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("test-file6.md links didn't extract correctly", List.of(), results);
    }
    @Test
    public void testFile7() throws IOException {
        Path fileName = Path.of("test-file7.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("test-file7.md links didn't extract correctly", List.of(), results);
    }
    @Test
    public void testFile8() throws IOException {
        Path fileName = Path.of("test-file8.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("test-file8.md links didn't extract correctly", List.of("a link on the first line"), results);
    }
    @Test
    public void testLabReport4Test1() throws IOException {
        Path fileName = Path.of("labReport4test1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("labReport4test1.md links didn't extract correctly", List.of("another link", "cod[e", "code]"), results);
    }
    @Test
    public void testLabReport4Test2() throws IOException {
        Path fileName = Path.of("labReport4test2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("labReport4test2.md links didn't extract correctly", List.of("nested link", "a nested parenthesized url", "some escaped [ brackets ]"), results);
    }
    @Test
    public void testLabReport4Test3() throws IOException {
        Path fileName = Path.of("labReport4test3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals("labReport4test3.md links didn't extract correctly", List.of("https://www.twitter.com", "this title text is really long and takes up more than one line", "https://cse.ucsd.edu/"), results);
    }
}