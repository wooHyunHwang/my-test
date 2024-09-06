public class ComparativeOperationPerformance {

    // 비교 연산자 1억번 실행시 속도 비교
    public static void main(String[] args) {

        int[] array = new int[(int) (Math.pow(10, 5) + 1)];

        for (int i = 0; i < array.length; ++i) {
            array[i] = i;
        }

        lessThan(array);
        lessThanOrEqual(array);
        equal(array);
        notEqual(array);

    }

    // 공통 함수
    private static long startTimer(String test, String symbol) {
        System.out.println(
                String.format("================== %s 테스트 (%s)", test, symbol)
        );
        return System.currentTimeMillis();
    }
    private static void endTimer(long startTime) {
        System.out.println(
                String.format("================== 종료 시간 : %d (ms)", System.currentTimeMillis() - startTime)
        );
    }

    // 작다
    private static void lessThan(int[] array) {
        int routineMax = (int) Math.pow(10, 5);
        int lastIdx = array.length - 1;
        long startTime = startTimer("작다", "<");

        for (int routine1 = 0; routine1 < routineMax; ++routine1) {
            for (int routine2 = 0; routine2 < routineMax; ++routine2) {
                for (int i = 0; i < lastIdx; ++i) {
                    if (array[i] < array[i + 1]) {
                        // just if check
                    }
                }
            }
        }

        endTimer(startTime);
    }

    // 작거나 같다
    private static void lessThanOrEqual(int[] array) {
        int routineMax = (int) Math.pow(10, 5);
        int lastIdx = array.length - 1;
        long startTime = startTimer("작거나 같다", "<=");

        for (int routine1 = 0; routine1 < routineMax; ++routine1) {
            for (int routine2 = 0; routine2 < routineMax; ++routine2) {
                for (int i = 0; i < lastIdx; ++i) {
                    if (array[i] <= array[i + 1]) {
                        // just if check
                    }
                }
            }
        }

        endTimer(startTime);
    }

    // 같다
    private static void equal(int[] array) {
        int routineMax = (int) Math.pow(10, 5);
        int lastIdx = array.length - 1;
        long startTime = startTimer("같다", "==");

        for (int routine1 = 0; routine1 < routineMax; ++routine1) {
            for (int routine2 = 0; routine2 < routineMax; ++routine2) {
                for (int i = 0; i < lastIdx; ++i) {
                    if (array[i] == array[i + 1]) {
                        // just if check
                    }
                }
            }
        }

        endTimer(startTime);
    }

    // 같지 않다
    private static void notEqual(int[] array) {
        int routineMax = (int) Math.pow(10, 5);
        int lastIdx = array.length - 1;
        long startTime = startTimer("같지 않다", "!=");

        for (int routine1 = 0; routine1 < routineMax; ++routine1) {
            for (int routine2 = 0; routine2 < routineMax; ++routine2) {
                for (int i = 0; i < lastIdx; ++i) {
                    if (array[i] != array[i + 1]) {
                        // just if check
                    }
                }
            }
        }

        endTimer(startTime);
    }

}
