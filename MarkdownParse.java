// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            //Check if text is close to being a link but not a link
            if(openParen != nextCloseBracket + 1) {
                currentIndex = nextOpenBracket + 1;
                continue;
            }
            int closeParen = markdown.indexOf(")", openParen);

            //Check if another link is in the rest of the text
            if(nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1){
                break;
            }

            //Check for image using "!" marker
            if(nextOpenBracket >= 1 && markdown.charAt(nextOpenBracket-1) == '!') {
                currentIndex = closeParen + 1;
                continue;
            }

            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}

//unsolved [big google](https://www.google.com/search?q=do+any+links+have+a+()+in+it&rlz=1C1UEAD_enUS960US960&oq=do+any+links+have+a+()+in+it&aqs=chrome..69i57j33i22i29i30l4.5022j0j9&sourceid=chrome&ie=UTF-8)