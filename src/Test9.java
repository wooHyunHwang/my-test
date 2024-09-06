import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test9 {
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

    }
}
