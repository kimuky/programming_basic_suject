package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private final Queue<Integer> calculateResult = new LinkedList<>();
    private int firstNumber;
    private int secondNumber;
    private String operator;

    public void setNumber(int[] nums) {
        this.firstNumber = nums[0];
        this.secondNumber = nums[1];
    }

    public int getFirstNumber() {
        return this.firstNumber;
    }

    public int getSecondNumber() {
        return this.secondNumber;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getCalculateResult() {
        return this.calculateResult.toString();
    }
    public int getCalculateResultSize() {
        return this.calculateResult.size();
    }
    public void removeCalculateResult() {
        this.calculateResult.poll();
    }

    public void calculate(Calculator calculator) {
        switch (operator) {
            case "+":
                System.out.printf("%d + %d = %d 입니다\n", firstNumber, secondNumber, firstNumber + secondNumber);
                this.calculateResult.add(firstNumber + secondNumber);
                break;
            case "-":
                System.out.printf("%d - %d = %d 입니다\n", firstNumber, secondNumber, firstNumber - secondNumber);
                this.calculateResult.add(firstNumber - secondNumber);
                break;
            case "*":
                System.out.printf("%d * %d = %d 입니다\n", firstNumber, secondNumber, firstNumber * secondNumber);
                this.calculateResult.add(firstNumber * secondNumber);
                break;
            case "/":
                System.out.printf("%d / %d = %d 입니다\n", firstNumber, secondNumber, firstNumber / secondNumber);
                this.calculateResult.add(firstNumber / secondNumber);
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
        }
    }

}
