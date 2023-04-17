import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) throws ParseException {
        List<String> uuids = new ArrayList<>();

        System.err.println(UUID.randomUUID().toString());

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < 50000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }

        System.err.println("생성된 배열 갯수 : " + uuids.size());
        System.err.println("중복 제거 갯수 : " + uuids.stream().distinct().collect(Collectors.toList()).size());
    }
}
