import java.util.ArrayList;
import java.util.List;

public class Test8 {

    public static class Option {
        private String name;

        protected Option(String name) { this.name = name; }
        public String getName() { return this.name; }
    }

    public static class Composite {
        private String name;

        protected Composite() { this.name = new String(); }
        public String getName() { return this.name; }
        
        public static String deepCopy(Composite composite) {
            return composite.getName();
        }
        public void resetName(String str) { this.name = str; }
        public void addName(String str) { this.name = this.name + str; }
        public void printName() { System.err.println(this.name); }
    }

    public static void main(String[] args) {
        //==================================================
        // Tree
        //==================================================
        int productCount = 1;
        List<List<Option>> tree = new ArrayList<>();

        //==================================================
        // 1Depth N개
        //==================================================
        List<Option> depth1 = new ArrayList<>();
        depth1.add(new Option("[1-1]"));
        depth1.add(new Option("[1-2]"));
        depth1.add(new Option("[1-3]"));
        depth1.add(new Option("[1-4]"));
        depth1.add(new Option("[1-5]"));
        depth1.add(new Option("[1-6]"));
        depth1.add(new Option("[1-7]"));
        depth1.add(new Option("[1-8]"));
        depth1.add(new Option("[1-9]"));
        depth1.add(new Option("[1-10]"));
        productCount *= depth1.size();
        tree.add(depth1);

        //==================================================
        // 2Depth M개
        //==================================================
        List<Option> depth2 = new ArrayList<>();
        depth2.add(new Option("[2-1]"));
        productCount *= depth2.size();
        tree.add(depth2);

        //==================================================
        // 3Depth L개
        //==================================================
        List<Option> depth3 = new ArrayList<>();
        depth3.add(new Option("[3-1]"));
        depth3.add(new Option("[3-2]"));
        depth3.add(new Option("[3-3]"));
        depth3.add(new Option("[3-4]"));
        depth3.add(new Option("[3-5]"));
        depth3.add(new Option("[3-6]"));
        depth3.add(new Option("[3-7]"));
        depth3.add(new Option("[3-8]"));
        depth3.add(new Option("[3-9]"));
        depth3.add(new Option("[3-10]"));
        depth3.add(new Option("[3-11]"));
        depth3.add(new Option("[3-12]"));
        depth3.add(new Option("[3-13]"));
        productCount *= depth3.size();
        tree.add(depth3);
        
        // .. List<Option> 을 원하는 만큼 추가해도 상관없음

        //==================================================
        // 상품 미리 생성 (재귀에서 해도 상관없음)
        //==================================================
        List<Composite> composites = new ArrayList<>();
        for (int i = 0; i < productCount; i++) {
            composites.add(new Composite());
        }

        //==================================================
        // Depth First Search 방식 상품 구성 재귀함수
        //==================================================
        dfs(composites, tree, 0, 0);

        for (Composite composite : composites) {
            composite.printName();
        }
    }

    /**
     * DFS재귀
     *
     * @param composites 상품
     * @param tree List 순서대로) Depth 별 구성 옵션 목록
     * @param depth 현재 depth
     * @param productIndex 이번 회차 상품 인덱스
     */
    private static int dfs(List<Composite> composites, List<List<Option>> tree, int depth, int productIndex) {

        // 끝지점 도달
        if (depth >= tree.size()) {
            System.err.println("마지막 도달 ================ Depth : " + depth + ", 상품 Index 완성 : " + productIndex);
            return productIndex + 1;
        };

        // 현재 Depth 추출
        List<Option> nDepth = tree.get(depth);

        // 추출 항목이 비었을 경우를 방지
        if (nDepth == null || nDepth.size() == 0) {
            System.err.println("마지막 도달 ================ Depth : " + depth + ", 상품 Index 완성 : " + productIndex);
            return productIndex + 1;
        }

        // Depth 별 구성 옵션 반복시
        // 현재 시점의 데이터 복사본 저장
        String copy = composites.get(productIndex).getName();

        for (int i = 0; i < nDepth.size(); i++) {
            System.err.println(productIndex + "IDX를 처리합니다.");

            // 꺼낸 Obj를 현재 시점의 데이터 복사본으로 복사
            composites.get(productIndex).resetName(
                    copy
            );
            
            // 현재 회차에 상품 이름을 더함
            composites.get(productIndex).addName(
                    nDepth.get(i).getName()
            );

            // 다음 Depth까지 진행
            productIndex = dfs(composites, tree, depth + 1, productIndex);

        }
        return productIndex;

    }


}
