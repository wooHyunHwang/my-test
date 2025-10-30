import java.math.BigDecimal;
import java.text.ParseException;

public class Test12 {

    public static void main(String[] args) throws ParseException {
        BigDecimal case1 = new BigDecimal("0");
        BigDecimal case2 = new BigDecimal("1");
        BigDecimal case3 = new BigDecimal("-1");
        BigDecimal case4 = new BigDecimal("-0.99");
        BigDecimal case5 = new BigDecimal("0.1");

        System.err.println(
                "CASE 1 : " +
                        BigDecimal.ZERO.compareTo(case1)
        );
        System.err.println(
                "CASE 2 : " +
                        BigDecimal.ZERO.compareTo(case2)
        );
        System.err.println(
                "CASE 3 : " +
                        BigDecimal.ZERO.compareTo(case3)
        );
        System.err.println(
                "CASE 4 : " +
                        BigDecimal.ZERO.compareTo(case4)
        );
        System.err.println(
                "CASE 5 : " +
                        BigDecimal.ZERO.compareTo(case5)
        );

        try {
            String as = null;
            as.length();
        } catch (Exception e) {
            System.err.println("############################");
            System.err.println(e.getMessage());
            System.err.println("############################");
            e.printStackTrace();
        }
    }
}
