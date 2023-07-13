package utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String START = "start";
    public static final String MOVE = "move";
    public static final String END = "end";
    public static final String SCORE = "score";

    private StringUtils() {
    }

    public static String appendNewLine(String string) {
        return string.concat(NEWLINE);
    }
}
