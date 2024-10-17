package lv2;

import lv2.utils.InputRequester;
import lv2.utils.PrintError;
import lv2.utils.Validator;

public class App {
    // 사용할 클래스 선언
    Calculator calculator;
    Validator validator;
    InputRequester inputRequester;
    PrintError printError;

    // App 의 생성자
    public App(Calculator calculator, Validator validator, InputRequester inputRequester, PrintError printError) {
        this.calculator = calculator;
        this.validator = validator;
        this.inputRequester = inputRequester;
        this.printError = printError;
    }

    // 메인
    public static void main(String[] args) {
        App app = new App(new Calculator(), new Validator(), new InputRequester(), new PrintError());
        app.start();
    }

    // 실행
    public void start() {
        boolean isRunning = true; // exit => isRunning (false)

        while (isRunning) {
            // 숫자 입력
            // inputNum() :  정수형 배열을 반환
            // calculator.setNumber : Setter 를 통해 반환 값을 할당
            calculator.setNumber(inputNum());

            // 연산자 입력
            // inputOperator : 연산자가 문제 없으면 calculator.setOperation 을 해줌
            inputOperator();
            // 연산
            calculator.calculate();

            // 출력
            calculator.printCalculateResult();

            // 삭제 의사를 물어보고 "네", "yes" 가 나오면 삭제
            if (inputRequester.isRemove(calculator)) {
                calculator.removeCalculateResultFirst();
            }
            // 나갈 의사를 물어보고 "exit"을 입력 시, 프로세스 종료
            if (inputRequester.isExit()) {
                isRunning = false;
            }

        }
    }

    public int[] inputNum() {
        String stringNumber;
        int[] nums = new int[2]; // 첫번째 숫자, 두번째 숫자 배열로 저장하기 위해

        // 배열 길이가 2 -> num[0], nums[1]에 "정수형" 반환하기 위해서
        for (int i = 0; i < nums.length; i++) {
            // while 은 문제가 있는 값을 받아올 시, 해당 인덱스에 다시 값을 지정해주기 위함
            while (true) {
                // scanner 로 받은 값을 stringNumber 에 저장
                stringNumber = inputRequester.requestNthNumber(i);
                // Setter 를 통해 지정
                validator.setAnyString(stringNumber);

                // isIntValid 를 통해 정수형이 반환 되면 while 문 빠져나옴
                if (validator.isIntValid()) {
                    nums[i] = validator.stringToIntNumber();
                    break;
                } else {
                    printError.printInvalidInput();
                }
            }
        }
        // 첫번째 두번째 숫자들이 담긴 배열을 반환
        return nums;
    }

    public void inputOperator() {
        String stringOperator;

        // 연산자가 문제없을 때까지 무한 루프
        while (true) {
            // 연산자를 stringOperator 에 할당
            stringOperator = inputRequester.requestOperator();
            validator.setAnyString(stringOperator);

            // switch case default 를 통해 오류가 생기면 while 무한 루프
            // 문제없을 시, calculator operation 을 지정하고 루프를 빠져나옴
            try {
                calculator.setOperator(stringOperator);
                break;
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
