import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String str = "1    개월";

        List<String> searchKeyword = Arrays.asList(str.split("\\s+").clone());


        for (String text : searchKeyword) {
            System.err.println(text);
        }

        String str2 = "as";
        StringBuilder sb = new StringBuilder();

        Calendar now = new GregorianCalendar();

        if (str2.length() >= 4) {
            sb.append(str2.substring(0, 4));
            sb.append("**");
        } else if (str2.length() == 3) {
            sb.append(str2.substring(0, 1));
            sb.append("**");
        } else if (str2.length() <= 2) {
            sb.append("**");
        }

        System.err.println(sb.toString());
    }
}
