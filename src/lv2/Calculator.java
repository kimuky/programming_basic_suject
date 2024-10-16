package lv2;

import lv2.operations.AbstractOperation;

import java.util.LinkedList;
import java.util.Queue;

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

    public int getFirstNumber() {
        return this.firstNumber;
    }

    public int getSecondNumber() {
        return this.secondNumber;
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

    public void calculate() {
        int result = abstractOperation.operate(firstNumber, secondNumber);
        this.result = result;
        this.calculateResult.add(result);
    }

}
