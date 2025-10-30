import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test10 {
    public static class Asd {
        public String str;

        public Asd(String str) {
            this.str = str;
        }

        public String getStr() {
            return this.str;
        }
    }
    public static void main(String[] args) {

        List<Asd> list = new ArrayList<>();

        list.add(new Asd(null));
        list.add(new Asd(null));
        list.add(new Asd(null));

        List<String> distinct = list.stream().map(Asd::getStr).distinct().collect(Collectors.toCollection(ArrayList::new));

        System.out.println(distinct);
        System.out.println(distinct.size());

        String testStr1 = "1312312,456457,568456";
        String testStr2 = "1312312~456457";
        String testStr3 = "1312312, 456457 , 568456";
        String testStr4 = "1312312  ~    456457";

        splitValid(testStr1);
        splitValid(testStr2);
        splitValid(testStr3);
        splitValid(testStr4);

        multiSplitProcess1(testStr1);
        multiSplitProcess1(testStr3);

        rangeSplitProcess2(testStr2);
        rangeSplitProcess2(testStr4);
    }

    private static void splitValid(String s) {
        if (s.indexOf(',') != -1 &&
                (s.indexOf('~') != -1 || s.indexOf('-') != -1)) {
            System.out.println("multi, range 상태를 같이 쓰고있음 : [" + s + "]");
        }
    }

    private static void multiSplitProcess1(String s) {
        String[] sl = s.split(",");
        for (int i = 0; i < sl.length; i++) {
            sl[i] = sl[i].trim();
        }
        System.out.println(Arrays.toString(sl));
    }

    private static void rangeSplitProcess2(String s) {
        String[] sl = s.replaceAll("~", "-").split("-");
        for (int i = 0; i < sl.length; i++) {
            sl[i] = sl[i].trim();
        }
        System.out.println(Arrays.toString(sl));
    }
}
