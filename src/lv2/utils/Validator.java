package lv2.utils;

import lv2.Calculator;
import lv2.operations.AddOperation;
import lv2.operations.DivideOperation;
import lv2.operations.MultiplyOperation;
import lv2.operations.SubstractOperation;

public class Validator {

    private String anyString;
    // final 로 지정하라고 경고가 뜨는데 이해가 안간다.. 물어보기!?
    private AddOperation addOperation = new AddOperation();
    private SubstractOperation substractOperation = new SubstractOperation();
    private MultiplyOperation multiplyOperation = new MultiplyOperation();
    private DivideOperation divideOperation = new DivideOperation();


    public void setAnyString(String anyString) {
        this.anyString = anyString;
    }

    // 정수 판별 함수, Integer.parseInt()를 통해 정상적으로 작동 하면 true
    // 아니면 false와 포맷팅 익셉션
    public boolean isIntValid() {
        try {
            Integer.parseInt(anyString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 연산자를 판별하고 문제 없으면 calculator operation 을 지정
    // 오류에 대해 익셉션을 던져줌
    public void isOperatorValid(Calculator calculator, String operator) {
        switch (operator) {
            case "+":
                calculator.setAbstractOperation(addOperation);
                break;
            case "-":
                calculator.setAbstractOperation(substractOperation);
                break;
            case "*":
                calculator.setAbstractOperation(multiplyOperation);
                break;
            case "/":
                if (calculator.isSecondNumberZero()) {
                    throw new ArithmeticException("나누기 시, 두 번째 숫자가 0이라 연산이 불가합니다. 다른 사칙연산을 입력해주세요");
                }
                calculator.setAbstractOperation(divideOperation);
                break;
            default:
                throw new IllegalArgumentException("제대로 입력하지 않았습니다."); // 예외처리 좀 알아보기
        }
    }

    // 받은 문자열 숫자를 인티저로 반환
    public int stringToIntNumber() {
        return Integer.parseInt(anyString);
    }

}
