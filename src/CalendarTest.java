import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarTest {
    public static void main(String[] args) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Calendar now = new GregorianCalendar(); // 오늘

            Calendar oneYear = new GregorianCalendar(); // 1년 후
            oneYear.add(Calendar.DATE, 365 - 1);
            Calendar twoYear = new GregorianCalendar(); // 2년 후
            twoYear.add(Calendar.DATE, 365 * 2 - 1);

            Calendar oneYear2 = new GregorianCalendar(); // 1년 후 2
            oneYear2.add(Calendar.YEAR, 1);
            oneYear2.add(Calendar.DATE, -1);
            Calendar twoYear2 = new GregorianCalendar(); // 2년 후 2
            twoYear2.add(Calendar.YEAR, 2);
            twoYear2.add(Calendar.DATE, -1);

            Date oneYearDate = dateFormat.parse(dateFormat.format(oneYear.getTime()));
            Date twoYearDate = dateFormat.parse(dateFormat.format(twoYear.getTime()));

            Date oneYearDate2 = dateFormat.parse(dateFormat.format(oneYear2.getTime()));
            Date twoYearDate2 = dateFormat.parse(dateFormat.format(twoYear2.getTime()));

            System.err.println("1 : " + dateFormat.format(oneYearDate));
            System.err.println("1 : " + dateFormat.format(twoYearDate));
            System.err.println("2 : " + dateFormat.format(oneYearDate2));
            System.err.println("2 : " + dateFormat.format(twoYearDate2));

        } catch (Exception e) {
            System.err.println("에러났음...");
            System.err.println(e.toString());
        }

    }
}
