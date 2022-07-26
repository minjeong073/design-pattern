#01 Strategy Pattern

###오리 시뮬레이션 게임 구현하기

<hr/>

<h3>예제 1</h3>

+ Duck 이라는 abstract super class
    + quack(), swim() 등의 공통된 행위
    + 오리 종류에 따라 화면에 표시하는 방식이 다름 -> display 라는 추상 메서드
    + 다양한 오리의 클래스들이 Duck 클래스를 상속받아 각자의 기능을 정의
    + 만약 오리에 나는 기능을 추가하기 위해 fly 라는 새로운 행위를 
      메서드로 정의하면 잠재적인 문제 발생
  

+ 일부 서브클래스들은 슈퍼클래스의 일부 또는 전체 행위를 할 수 없어야 하는 경우임
  <b>재사용을 목적으로 상속을 하는 것은 좋지만 maintenance 측면에서는 좋지 않음</b>

<hr>

<h3>예제 2</h3>

+ interface 사용하기
  + display 나 swim 같은 공통된 성질 및 행위는 슈퍼클래스에 두고 상속 받도록
  + fly, quack 등의 optional 한 behavior 는 interface 로 정의하여 
    서브클래스들이 필요한 행위를 implement 하여 스스로 기능을 정의하도록 함
+ 필요한 행위만 골라 쓸 수 있으나 재사용이 불가하기 때문에 코드 중복 발생
+ 만약 fly 행위에 대한 변경사항이 발생하면 이를 구현하고 있는 <b>모든 서브클래스의 코드 모두 변경해야함</b>
+ 예제 1에서의 inheritance 를 사용한 방식의 일부 문제 해결하지만 코드 재사용의 이점을 없앰
+ ### 프로그램은 항상 변한다 ###
  : 변하는 부분을 캡슐화(encapsulation) 해서 변하지 않는 부분으로부터 분리해야함
    그래야 다른 것으로 대체, 확장 되어도 변하지 않는 부분에는 영향을 끼지치 않게 됨

<hr>

<h3>예제 3</h3>

+ < Strategy Pattern >


+ optional 한 행위들을 캡슐화하여 오리 서브클래스를 생성할 때 행위를 정의하도록
  + 행위들을 interface 로 정의하고 이를 implements 하는 구체적인 행위들을 정의한 후
    setter method 를 통해 초기화해줌
  + 행위를 전달받는 오리 클래스에서 행위의 type 을 구체적인 타입이 아니라 인터페이스 타입으로 사용
    --> 오리 클래스는 행위의 구체적인 구현을 알 필요 없어짐
        & 런타임에 행위를 다른 것으로 동적으로 변경해줄 수 있음
+ ### "Program to an interface, not an implementation" 원칙
  + (구현체가 아니라 인터페이스를 사용해서 프로그래밍하라)
  + 만약 행위를 구체적인 타입으로 선언할 경우 변경에 대한 여지가 사라지게됨


* ex

```java
Dog dog = new Dog(); 
d.bark();
```
보다는 
```java
Animal animal = new Dog();
animal.makeSound();
```
로 구현하는 것이 낫고,
```java
a = getAnimal();
a.makeSound();
```
로 구현하는 것이 더 좋음

--> 2번째 코드도 특정 클래스 타입이 등장하기 때문

## 🔅 Strategy Pattern

 - 행위를 delegate(대표)함
 - 기존 오리 서브클래스에 있던 fly 함수 대신 performFly 함수를 선언하고
  내부에서 행위 클래스에 정의된 fly 함수를 호출하게 되면 오리 서브클래스는 behavior 의 디테일을 신경쓰지 않아도 됨
 - IS-A 관계인 inheritance 대신 HAS-A 관계인 composition 을 사용
   <br> <b>"Favor composition over inheritance" 원칙</b>
   - (상속보다 구성을 선호하라) 
   - inheritance subclass 는 superclass 와 강하게 결합되며, 컴파일 타임에 subclass 의 성격이 정해짐
   - composition 을 사용하면 runtime 에 behavior 를 변경할 수 있음 -> 더 유연한 설계 가능

