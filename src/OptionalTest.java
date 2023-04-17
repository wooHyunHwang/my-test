import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) throws Exception {

        /**
         *****************************************************
         * https://homoefficio.github.io/2019/10/03/Java-Optional-%EB%B0%94%EB%A5%B4%EA%B2%8C-%EC%93%B0%EA%B8%B0/
         *****************************************************
         */

        System.err.println("=============================================");
        System.err.println("널체크");
        Optional<TestObejct> opGet = Optional.ofNullable(getObject(true));
        opGet.ifPresent(testObejct -> {
            System.err.println(testObejct.toString());
        });
        System.err.println("이와 같은 단순 null 체크만 한다면 Optional 사용은 지양한다, Optional은 비용이 비싸다. != null 을 사용하자");

        System.err.println("=============================================");

        
        
        System.err.println("=============================================");
        System.err.println("[orElseThrow] 널체크 + 예외처리");
        TestObejct elseThrow = Optional.ofNullable(getObject(true))
                .orElseThrow(Exception::new);
        System.err.println("=============================================");



        System.err.println("=============================================");
        System.err.println("[orElse] 있든 없는 실행, 만약 값이 있는데 orElse 사용 시 안에 함수는 동작하지만 생성된 값은 무시된다 (의미 없는 동작이 된다)");
        TestObejct aleadyCreate = new TestObejct();
        Optional<TestObejct> proceed = Optional.ofNullable(getObject(true));

        System.err.println("따라서 아래와 같이 없을 경우 \"이미 생성된 값\"을 부여하고 싶을때! 사용한다");
        if (proceed.isPresent()) {
            System.err.println(proceed.orElse(aleadyCreate).toString());
        }
        System.err.println("=============================================");

        
        
        System.err.println("=============================================");
        System.err.println("[orElseGet] 널체크, 없을경우 생성, 값이 준비되어 있지 않은 경우");
        TestObejct ifNullCreate = Optional.ofNullable(getObject(true))
                .orElseGet(TestObejct::new);
        System.err.println("=============================================");

        
        
        System.err.println("=============================================");
        System.err.println("널체크, 없을경우 생성");
        Optional<TestObejct> create = Optional.empty();
        System.err.println("=============================================");






        System.err.println(
                elseThrow.toString() +
                ifNullCreate.toString() +
                        create.toString()
        );
    }

    private static TestObejct getObject(boolean get) {
        if (get) {
            return new TestObejct();
        } else {
            return null;
        }
    }

    private static List<TestObejct> getObjectArray(boolean get) {
        if (get) {
            return new ArrayList<>();
        } else {
            return null;
        }

    }

    public static class TestObejct {

        private String asd;

        public String getAsd() { return this.asd; }
        public void setAsd(String asd) { this.asd = asd; }
    }
}
