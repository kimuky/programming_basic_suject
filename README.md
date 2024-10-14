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
