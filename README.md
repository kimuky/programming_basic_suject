## Trouble Shooting ( LV.1 )

### 1. 개요
CH 2 프로그래밍 기초 개인 과제 lv.1 단계 구현 중 입력을 받아오는 과정에서 Scanner 오류를 해결한 케이스에 대해서 설명

### 2. 트러블 슈팅


  **2.1 배경**
   
  ```
  System.out.print("두 번째 숫자를 입력하세요: ");
  secondNum = sc.nextInt();
  System.out.print("사칙연산 기호를 입력하세요: ");
  operator = sc.nextLine();
  ```
  
  **2.2 발단**

  nextInt()와 nextLine()을 같이 사용 시, 입력을 받기도 전에 프로세스가 종료
  
![image](https://github.com/user-attachments/assets/2f6b6d21-5144-4ac9-ae9e-077e53fdd45f)
  
  **2.3 전개**

```
System.out.print("두 번째 숫자를 입력하세요: ");
secondNum = sc.nextInt();
System.out.print("사칙연산 기호를 입력하세요: ");
sc.nextLine();
operator = sc.nextLine();
```

이를 통해 해결 가능

![image](https://github.com/user-attachments/assets/c08e6f82-02d6-4c8e-a96e-4ab77d7957ff)


  **2.4 위기**

  ```
System.out.print("두 번째 숫자를 입력하세요: ");
secondNum = sc.nextInt();
System.out.print("사칙연산 기호를 입력하세요: ");
// 코드 가독성을 해침
sc.nextLine();
operator = sc.nextLine();
```

입력에 대해 해결은 했으나 코드 가독성을 해침

  **2.5 절정**
  
  확인해보니 nextLine()는 공백문자 개행문자를 포함시킨다. 그렇다보니 \n 가져오고 종료

  next()는 개행문자를 무시하고 입력을 받음, nextLine()은 한 줄 단위 입력을 받아 개행문자를 포함

  nextLine() -> next()

```
System.out.print("두 번째 숫자를 입력하세요: ");
secondNum = sc.nextInt();
System.out.print("사칙연산 기호를 입력하세요: ");
operator = sc.next();
```
  
  **2.6 결말**

Scanner를 쓸 때, nextLine(), next()에 대해서 어떻게 데이터를 읽는지 잘 파악해보아야 할 것
  
### 3. 마무리

(1) nextInt() 와 nextLine() 같이 사용 시, 입력을 받기도 전에 프로세스가 종료

(2) 문제는 Scanner에서 읽어오는 과정에서 개행문자에 따른 nextLine() 문제

(3) nextLine()을 연속으로 2개를 써서 해결

(4) 하지만 코드 가독성을 해침

(5) next()를 써서 해결

---

## Trouble Shooting ( LV.2 ) - 1

### 1. 개요
사용자에게 Scanner를 통해 입력을 받을 때, 내가 의도하지 않은 값들을 주입했을 경우에 대한 처리

### 2. 문제 상황
사용자가 만약 정수값이 아닌 문자열, 엔터, 스페이스 등을 입력할 때, 입력을 계속 다시 받아야하는데 어떻게 처리할 것이냐
단순히 그 함수를 재호출해 사용할려고 했지만, 재귀적으로 호출되어 문제가 발생

```
public int[] inputNum() {
        String stringNumber;
        int[] nums = new int[2]; // 첫번째 숫자, 두번째 숫자 배열로 저장하기 위해

        // 배열 길이가 2 -> num[0], nums[1]에 "정수형" 반환하기 위해서
        for (int i = 0; i < nums.length; i++) {
            // while 은 문제가 있는 값을 받아올 시, 해당 인덱스에 다시 값을 지정해주기 위함
                // scanner 로 받은 값을 stringNumber 에 저장
                stringNumber = inputRequester.requestNthNumber(i);
                // Setter 를 통해 지정
                validator.setAnyString(stringNumber);

                // isIntValid 를 통해 정수형이 반환 되면 while 문 빠져나옴
                if (validator.isIntValid()) {
                    nums[i] = validator.stringToIntNumber();
                    break;
                } else {
                    inputNum();
                }
        }
        // 첫번째 두번째 숫자들이 담긴 배열을 반환
        return nums;
    }
```
  
### 3. 해결

- 단순히 호출을 통해 재입력 받게 하는 것이 아닌 해당 입력 받는 부분에 대해 루프를 하나 더 생성 for or while
- for는 범위를 지정해줘야하기 때문에 무한 루프를 돌릴 수 있는 while을 선택

```
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
```

### 3. 결론
- 이중 반복문을 지양해야하는 것은 맞지만 입력값을 문제없이 받을려면 활용해볼 것

---

## Trouble Shooting ( LV.2 ) - 2

### 1. 개요
메인 메소드에서 함수 호출 시, 함수에 static을 붙여줘야 하지만 static을 안 쓰고 돌릴 수 없을까에 대한 고찰

### 2. 문제 상황
App에는 init() + while문 코드 가 존재, 이것을 static을 지정해주지 않고 프로그램을 돌릴 수 있는 방법을 찾고자 한다.

```
 public static void main(String[] args) {
        boolean isRunning = true; // exit => isRunning (false)
        init();
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
```
  
### 3. 해결

- 그럼 App 내에 start() 함수를 만들어서 App을 다시 인스턴스화 한 다음 app.start()로 돌리게 되면 static을 쓰지 않아도 된다.

```
public static void main(String[] args) {
        App app = new App(new Calculator(), new Validator(), new InputRequester(), new PrintError());
        app.start();
    }

    // 실행
    public void start() {
        boolean isRunning = true; // exit => isRunning (false)
        init();
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
```

### 3. 결론
- 클래스 인스턴스 메인메소드에 대한 이해가 부족했던 것 같다. 이러한 부분에 대해서 다시 공부해야 할 것이며, 메인 메소드 내 에서 함수는 최소한으로만 작성하자

---

## Trouble Shooting ( LV.2 ) - 3

### 1. 개요
계산기를 만들던 도중 정수형만 값이 저장이 되어야하는데, 사용자는 무엇이든 개발자가 의도하지 않은 값들을 넣엇을 때에 대한 대처

### 2. 문제 상황
사용자가 입력하는데 그 입력값에 대해 정수값인지 판단하고, 아니라면 다시 사용자에게 입력을 받아야하는데
- 정수 값은 어떻게 판별할 것이며
- 여러 가지 입력에 대한 대처는 어떻게 할 것이냐

  
### 3. 해결

- Integer.ParseInt()를 통해 강제 형변환을 try 문으로 실행하고 형변환이 되지 않는다면 false 를 리턴해 판별

```
if (validator.isIntValid()) {
    nums[i] = validator.stringToIntNumber();
    break;
} else {
    printError.printInvalidInput();
}
```

```
public boolean isIntValid() {
        try {
            Integer.parseInt(anyString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
```

### 3. 결론
- 여러 가지 경우를 생각해보고, if else로 나누어지지 않는다면 try catch 와 Exception을 활용해 처리해볼 것
