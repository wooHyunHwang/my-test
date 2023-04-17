import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Test2 {
    public static void main(String[] args) throws ParseException {
        BigDecimal pre = new BigDecimal("0");
        BigDecimal dnmnt = new BigDecimal("1");

        System.err.println(pre.divide(dnmnt));
    }
}
