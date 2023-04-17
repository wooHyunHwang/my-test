import java.util.Random;

public class Dup {
    public static void main(String[] args) {
        String input = "?5?6?23?2??";
        char[] inputAry = input.toCharArray();

        for (int i = 0; i < inputAry.length; i++) {
            // WildCard Check
            if ('?' == inputAry[i]) {
                if (inputAry.length == 1) {
                    inputAry[i] = getRandom(null, null);
                    break;
                }

                if (i == 0) {
                    // 첫번째일 경우
                    if ('?' != inputAry[i + 1]) {
                        // 다음 글자가 와일드 카드가 아님
                        inputAry[i] = getRandom(Character.getNumericValue(inputAry[i + 1]), null);
                    } else {
                        // 다음 글자가 와일드 카드
                        inputAry[i] = getRandom(null, null);
                    }
                } else if (i == inputAry.length - 1) {
                    // 마지막일 경우
                    if ('?' != inputAry[i - 1]) {
                        // 다음 글자가 와일드 카드가 아님
                        inputAry[i] = getRandom(Character.getNumericValue(inputAry[i - 1]), null);
                    } else {
                        // 다음 글자가 와일드 카드
                        inputAry[i] = getRandom(null, null);
                    }
                } else {
                    // char 추출
                    Integer prefix = null;
                    Integer suffix = null;

                    if ('?' != inputAry[i - 1]) {
                        prefix = Character.getNumericValue(inputAry[i - 1]);
                    }
                    if ('?' != inputAry[i + 1]) {
                        suffix = Character.getNumericValue(inputAry[i + 1]);
                    }

                    inputAry[i] = getRandom(prefix, suffix);
                }
            }
        }

        System.err.println("input : " + input);
        System.err.print("result : ");
        System.err.println(inputAry);
    }

    private static char getRandom(Integer dup1, Integer dup2) {
        Random rd = new Random();

        int result = 0;
        while (true) {
            result = rd.nextInt(10);

            boolean check1 = true;
            boolean check2 = true;

            if (dup1 != null && result == dup1) {
                check1 = false;
            }

            if (dup2 != null && result == dup2) {
                check2 = false;
            }

            if (check1 && check2) {
                break;
            }
        }

        return Character.forDigit(result, 10);
    }
}
