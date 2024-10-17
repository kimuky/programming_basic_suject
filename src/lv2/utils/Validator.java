package lv2.utils;

public class Validator {

    private String anyString;
    // final 로 지정하라고 경고가 뜨는데 이해가 안간다.. 물어보기!?

    public void setAnyString(String anyString) {
        this.anyString = anyString;
    }

    // 정수 판별 함수, Integer.parseInt()를 통해 정상적으로 작동 하면 true
    // 아니면 false 와 포맷팅 익셉션
    public boolean isIntValid() {
        try {
            Integer.parseInt(anyString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 받은 문자열 숫자를 인티저로 반환
    public int stringToIntNumber() {
        return Integer.parseInt(anyString);
    }

}
