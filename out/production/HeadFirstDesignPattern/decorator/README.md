#03 Decorator Pattern

### 커피 가격 계산기 만들기

<hr>

+ 방법 1
  + 각 커피 종류에 재료를 더할 수 있는 모든 경우에 대해
      클래스를 만들고, Beverage 라는 super 클래스를 상속
  + 문제점 : 클래스가 너무 많아짐


+ 방법 2
  + 각 재료 추가 여부를 boolean field 로 가지고 있도록 구현
  + 재료들에 대한 추가 비용을 계산하는 cost 메서드를 Beverage 에서 정의
  + 서브 클래스들은 cost 를 override 하고,
    super.cost() 와 자신들의 가격을 더한 값을 반환
  + 문제점 : 가격이 바뀌면 코드 바꿔야함
          : 새로운 재료가 추가되면 슈퍼클래스의 필드 선언부, cost 메서드 코드 변경해야함
          : 기존 재료와 어울리지 않는 음료가 추가될 수 있음
          : 같은 재료를 여러개 필요로 할 수 있음


<h4>Decorator Pattern</h4>

  + Abstract Component, Concrete Components,
    Abstract Decorator, Concrete Decorators 로 구성
  + Object Composition, Delegation 을 총해 기존의 코드 변경 없이
    런타임에 기능 추가 가능
  + inheritance 단점 해결
  + 사용하는 Client 는 내부적으로 decorator 를 사용하는지 알 필요 없음
  + OCP 의 대표적인 예
  + 문제점 : 작은 클래스들이 너무 많아 직관적이지 못할 수도 있음


<h4>Open - Closed Principle (OCP)</h4>

+ Classes should be open for extension, but closed for modification
<br>
  (클래스는 코드의 변경 없이 확장 가능해야 한다)

<h4>상속의 문제점</h4>

+ 컴파일 타임에 behavior 가 고정됨
+ 서브 클래스들도 같은 behavior 들을 상속받아야함
+ composition, delegation 으로 상속 행위 구현 가능
+ 기존의 코드를 바꾸지 않고 responsibility 추가 가능
+ 슈퍼 클래스의 작성자조차 생각하지 못한 것도 가능
+ 기존의 코드를 바꾸지 않으면 코드에서 버그를 발생할 가능성 줄어듬