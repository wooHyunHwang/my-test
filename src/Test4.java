import java.math.BigDecimal;
import java.text.ParseException;

public class Test4 {
    public static void main(String[] args) throws ParseException {
        long total = 120000;
        long pageSize = 10000;
        int page = (int) (total / pageSize);

        for (page = (int) (total / pageSize); page > 0; page--) {
            System.err.println(page + "번째 시도");

            System.err.println("LIMIT " + (page * pageSize) + ", " + pageSize);
        }

        if (page * pageSize >= 0) {
            System.err.println("잔여항목 - " + page + "번째 시도");
            System.err.println("LIMIT " + (page * pageSize) + ", " + pageSize);
        }

    }
}
