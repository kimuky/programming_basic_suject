package lv2;

import lv2.operations.*;

import java.util.LinkedList;
import java.util.Queue;
// test2
public class Calculator {
    private final Queue<Integer> calculateResult = new LinkedList<>();
    private int firstNumber;
    private int secondNumber;
    private int result;
    private AbstractOperation abstractOperation;

    public void setAbstractOperation(AbstractOperation abstractOperation) {
        this.abstractOperation = abstractOperation;
    }

    public void setNumber(int[] nums) {
        this.firstNumber = nums[0];
        this.secondNumber = nums[1];
    }

    public boolean isSecondNumberZero() {
        return secondNumber == 0;
    }

    public String getCalculateResultAll() {
        return this.calculateResult.toString();
    }

    public void printCalculateResult() {
        System.out.println("답은 " + result + " 입니다.");
    }

    public void removeCalculateResultFirst() {
        this.calculateResult.poll();
    }

    public void setOperator(String operator) {
        switch (operator) {
            case "+":
                setAbstractOperation(new AddOperation());
                break;
            case "-":
                setAbstractOperation(new SubstractOperation());
                break;
            case "*":
                setAbstractOperation(new MultiplyOperation());
                break;
            case "/":
                if (isSecondNumberZero()) {
                    throw new ArithmeticException("나누기 시, 두 번째 숫자가 0이라 연산이 불가합니다. 다른 사칙연산을 입력해주세요");
                }
                setAbstractOperation(new DivideOperation());
                break;
            default:
                throw new IllegalArgumentException("제대로 입력하지 않았습니다."); // 예외처리 좀 알아보기
        }
    }

    public void calculate() {
        int result = abstractOperation.operate(firstNumber, secondNumber);
        this.result = result;
        this.calculateResult.add(result);
    }

}
