package lv2.utils;

import lv2.Calculator;

import java.util.Scanner;

public class InputRequester {
    Scanner sc = new Scanner(System.in); //sc 함수에서 호출하기 위함

    public String requestNthNumber(int nth) {
        System.out.printf(" %d 번째 숫자를 입력해주세요 : ", nth + 1);
        return sc.nextLine();
    }

    public String requestOperator() {
        System.out.print("사칙연산 기호를 입력하세요: ");
        return sc.nextLine();
    }

    public boolean isExit() {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료) : ");
        String ContinueConfirmation = sc.nextLine();

        return ContinueConfirmation.equals("exit");
    }

    public boolean isRemove(Calculator calculator) {
        System.out.println(calculator.getCalculateResultAll());
        System.out.println("제일 처음에 계산했던 결과를 지우시겠습니까 (yes, 네 입력 시  삭제");
        String removeConfirmation = sc.nextLine();
        return removeConfirmation.equals("네") || removeConfirmation.equals("yes");
    }

}
