import java.util.*;

public class Test5 {
    public static void main(String[] args) {

        int[] vals = {1,1,1};
        int[][] edges = {{0,1},{1,2}};

        long startTime1 = System.currentTimeMillis();

        numberOfGoodPaths(vals, edges);

        long timeTaken1 = System.currentTimeMillis() - startTime1;
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("time : " + timeTaken1);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        long startTime2 = System.currentTimeMillis();

        numberOfGoodPaths2(vals, edges);

        long timeTaken2 = System.currentTimeMillis() - startTime1;
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("time : " + timeTaken2);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

    }

    // 전체 탐색 방식, 느림
    public static int numberOfGoodPaths(int[] vals, int[][] edges) {

        if(vals.length == 0) return 0;
        if(vals.length == 1) return 1;

        // 노드 별 모든 탐색을 실행하는거 부터...
        List<Integer>[] paths = new ArrayList[vals.length];

        for(int i = 0; i < paths.length; ++i) paths[i] = new ArrayList();
        for(int i = 0; i < edges.length; ++i) {
            paths[edges[i][0]].add(edges[i][1]);
            paths[edges[i][1]].add(edges[i][0]);
        }

        int result = exposeGoodPath(vals, paths);


        return result;
    }

    public static int exposeGoodPath(int[] vals, List<Integer>[] paths) {

        //System.out.println("탐색...");

        // 비교용 리스트
        List<Integer> vlist = new ArrayList<>();
        for(int i = 0; i < vals.length; ++i) {
            vlist.add(vals[i]);
        }

        // 자기 자신 경로
        int goodPath = 0;

        for(int i = 0; i < vals.length; ++i) {
            //System.out.println("=======================");

            // 1건밖에 없는 경우 skip
            //System.out.println("반복 건수 체크...");
            if(Collections.frequency(vlist, vals[i]) <= 1) continue;

            HashSet<Integer> visited = new HashSet<>();

            visited.add(i);

            //System.out.println("반복 시작...");
            goodPath += findGood(i, vals[i], vals, paths, visited);
            //System.out.println("찾은 경로 : ");

            //System.out.println("=======================");
        }

        goodPath = (goodPath / 2) + vals.length;


        //System.out.println("탐색... 끝");

        return goodPath;
    }

    public static int findGood(int startNode, int startVal, int[] vals, List<Integer>[] paths, HashSet<Integer> visited) {

        int findPath = 0;

        for(int endNode : paths[startNode]) {

            if (visited.contains(endNode)) {
                continue;
            } else {
                visited.add(endNode);
            }

            int endVal = vals[endNode];

            if (startVal == endVal) {
                // 목적지 도착 ++
                findPath++;
                findPath += findGood(endNode, startVal, vals, paths, visited);
            } else if (startVal >= endVal) {
                // 다음 목적지 시작
                findPath += findGood(endNode, startVal, vals, paths, visited);
            } else {
                // 경로가 아님
                continue;
            }
        }

        return findPath;
    }



    /* solution2 */
    static int[] parent;
    static int[] count;
    static int res;
    public static int numberOfGoodPaths2(int[] vals, int[][] edges) {
        // Sorting the edges in increasing order of the corresponding nodes
        // 좌표 정렬
        Arrays.sort(edges, (o1, o2) -> Integer.compare(Math.max(vals[o1[0]], vals[o1[1]]), Math.max(vals[o2[0]], vals[o2[1]])));

        // 노드 수
        int n = vals.length;

        // Minimum number of good paths is equal to the number of nodes
        // 자기 자신 수 기본값으로 설정
        res = n;

        // Parent array for union
        parent = new int[n];

        // Count array to keep track of number of nodes less than or equal to a given node
        count = new int[n];

        // Initially each node will have just itself in the union component
        // Count 1로 초기화
        Arrays.fill(count, 1);

        // 부모 좌표 초기화
        for(int i = 0; i < n; i++) parent[i] = i;

        // Processing each edge and connecting adjacent nodes into one component
        for(int[] edge: edges) {
            // System.out.println("================================================== " + edge[0] + " -> " + edge[1]);
            union(edge[0], edge[1], vals);
            // System.out.println("==================================================");
        }

        return res;
    }

    private static void union(int x, int y, int[] vals) {
        int parx = find(x);
        int pary = find(y);
        // System.out.println("부모 좌표 x : " + parx + " / y : " + pary);
        // System.out.println("부모 노드 값 x : " + vals[parx] + " / y : " + vals[pary]);

        // parentCountLog();

        if(parx == pary) {
            // System.out.println("!!!!!!! 좌표 같아영 !!!!!!!");
            return;
        }

        //If two adjacent node have same value, they will increase the number of good paths corresponding to the number of nodes in their component
        if(vals[parx] == vals[pary]) {
            // System.out.println("!!!!!!! 노드값이 같아영 !!!!!!!");
            res += count[parx]*count[pary];
            count[parx] += count[pary];
            parent[pary] = parx;
        }

        // If two nodes have different values, join the smaller one to the larger one
        else if(vals[parx] > vals[pary]) {
            // System.out.println("!!!!!!! X 노드값이 큼 !!!!!!!");
            parent[pary] = parx;
        } else {
            // System.out.println("!!!!!!! Y 노드값이 큼 !!!!!!!");
            parent[parx] = pary;
        }

        // parentCountLog();
    }

    private static int find(int x) {
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    private static void parentCountLog() {
        // parent
        System.out.print("parent : [ ");
        for (int t : parent) {
            System.out.print(t + ", ");
        }
        System.out.println("]");

        // count
        System.out.print("count : [");
        for (int t : count) {
            System.out.print(t + ", ");
        }
        System.out.println("]");
    }
}
