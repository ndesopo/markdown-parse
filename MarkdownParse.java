// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<String>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBackticks = markdown.indexOf("```", currentIndex);
            int closeBackticks  = markdown.indexOf("```", openBackticks + 1);
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            //Components of a link must be present (already in order by default)
            if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1) break;

            //Link is invalid if space between closeBracket and openParen
            if(openParen != closeBracket + 1) {
                currentIndex = openParen + 1;
                continue;
            }

            //Check for image using "!" marker
            if(openBracket >= 1 && markdown.charAt(openBracket-1) == '!') {
                currentIndex = openBracket + 1;
                continue;
            }

            //If both backticks are present and they "interrupt" the brackets or "surround" the link, link is invalid
            if(openBackticks != -1 && closeBackticks != -1) {
                System.out.println(openBackticks + "   " + closeBackticks);
                if((openBackticks < openBracket && closeParen < closeBackticks) || 
                (openBackticks < openBracket && openBracket < closeBackticks && closeBackticks < closeBracket) ||
                (openBracket < openBackticks && openBackticks < closeBracket && closeParen < closeBackticks)) {
                    currentIndex = closeBackticks + 3;
                    continue;
                }
            }

            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        //Map<String, List<String>> links = getLinks(fileName.toFile());
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}

//unsolved [big google](https://www.google.com/search?q=do+any+links+have+a+()+in+it&rlz=1C1UEAD_enUS960US960&oq=do+any+links+have+a+()+in+it&aqs=chrome..69i57j33i22i29i30l4.5022j0j9&sourceid=chrome&ie=UTF-8)