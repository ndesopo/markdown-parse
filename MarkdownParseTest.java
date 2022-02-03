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
    public void testGetLinks(String error_message, List<String> list_of_links, String test_file) throws IOException {
        Path fileName = Path.of(test_file);
        String contents = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(contents);
        assertEquals(error_message, list_of_links, results);
    }
    @Test
    public void testFile() throws IOException {
        testGetLinks("test-file.md links didn't extract correctly", List.of("https://something.com", "some-page.html"), "test-file.md");
    }
    @Test
    public void testFile2() throws IOException {
        testGetLinks("test-file2.md links didn't extract correctly", List.of("https://www.poptropica.com","not-even-real.html","https://www.netflix.com"), "test-file2.md");
    }
    @Test
    public void testFile3() throws IOException {
        testGetLinks("test-file3.md was supposed to have no links", List.of(), "test-file3.md");
    }
    @Test
    public void testFile4() throws IOException {
        testGetLinks("test-file4.md was supposed to have no links", List.of(), "test-file4.md");
    }
    @Test
    public void testFile5() throws IOException {
        testGetLinks("test-file5.md was supposed to have no links", List.of(), "test-file5.md");
    }
    @Test
    public void testFile6() throws IOException {
        testGetLinks("test-file6.md was supposed to have no links", List.of(), "test-file6.md");
    }
    @Test
    public void testFile7() throws IOException {
        testGetLinks("test-file7.md was supposed to have no links", List.of(), "test-file7.md");
    }
    @Test
    public void testFile8() throws IOException {
        testGetLinks("test-file8.md should have one link", List.of("a link on the first line"), "test-file8.md");
    }
}