MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp ".:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar" MarkdownParseTest.java
	java -cp ".:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java
	
.PHONY: test
test: MarkdownParse.class MarkdownParseTest.class
	java -cp ".:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest