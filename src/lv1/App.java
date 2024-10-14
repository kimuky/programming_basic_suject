package lv1;

import java.util.*;

public class App {

    static int[] nums = new int[2]; // 숫자 1,2 배열
    static Scanner sc = new Scanner(System.in); //sc 함수에서 호출하기 위함

    public static void main(String[] args) {
        // 실행
        __init__();
    }

    public static void __init__() {
        // 초기값
        boolean isRunning = true; // exit => false

        while (isRunning) {
            // 숫자 입력 받기
            inputNum();
            // 연산자 입력 받기
            inputOperator();

            // 한 번더 계산할지 물어보기
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String askCalculate = sc.nextLine();
            // exit 을 입력 받으면 종료
            if (askCalculate.equals("exit")) {
                isRunning = false;
            }

        }
    }

    public static void inputNum() {
        // nextLine()로 받을 때, 저장할 변수
        // nextInt() 시, 스페이스로 여러가지 입력이 가능
        // exception 오류를 잡기위함
        String stringNum;

        for (int i = 0; i < nums.length; i++) {
            while (true) {
                System.out.printf(" %d 번째 숫자를 입력해주세요 : ", i + 1);
                stringNum = sc.nextLine();

                // 숫자이면 while 문 break, 숫자가 아니면 무한 루프를 통해 정수형을 입력 받음
                if (isNumber(stringNum)) {
                    nums[i] = Integer.parseInt(stringNum);
                    break;
                } else {
                    System.out.println("잘못된 입력을 하셨습니다. 다시 입력해주세요");
                }
            }

        }
    }

    //Integer.parseInt()가 작동하면 true, 아니면 false 리턴
    public static boolean isNumber(String number) {
        try {
            int intNum = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void inputOperator() {
        String stringOperator;

        // 문자열이 한 글자이면 while 문 break, 아니면 무한 루프를 통해 정해진 연산자만 받도록
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요: ");
            stringOperator = sc.nextLine();
            if (stringOperator.length() > 1) {
                System.out.println("+, -, *, /  중 하나만 입력해주세요 !!!");
            } else {
                printResult(stringOperator);
                break;
            }
        }

    }

    public static void printResult(String stringOperator) {

        switch (stringOperator) {
            case "+":
                System.out.printf("%d + %d = %d 입니다\n", nums[0], nums[1], nums[0] + nums[1]);
                break;
            case "-":
                System.out.printf("%d + %d = %d 입니다\n", nums[0], nums[1], nums[0] - nums[1]);
                break;
            case "*":
                System.out.printf("%d + %d = %d 입니다\n", nums[0], nums[1], nums[0] * nums[1]);
                break;
            case "/":
                if (nums[1] == 0) {
                    System.out.println("두 번째 수에는 0이 들어가면 나누기가 불가능합니다. 수를 다시 입력해주세요!!");
                } else {
                    System.out.printf("%d + %d = %d 입니다\n", nums[0], nums[1], nums[0] / nums[1]);
                }
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
        }

    }

}
