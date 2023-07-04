package utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");
    private StringUtils() {
        ;
    }
    public static void appendNewLine(StringBuilder sb) {
        sb.append(NEWLINE);
    }
}
