## Factory Pattern

Factory Pattern 은 크게 Factory Method, Abstract Factory 로 나뉨


### Factory Method Pattern

- 슈퍼 클래스에서 특정 object 를 반환하는 abstract 메서드
    <br>-> 서브 클래스에게 object 의 생성 위임
- DIP(Dependency Inversion Principal)
- concrete 한 클래스들에게 직접 의존하는 것이 아니라
    Object 를 생성하는 역할을 factory method 에게 위임


### Abstract Factory Pattern
- 서로 관련이 있는 Object 들을 생성하는 메서드들을 가진 인터페이스 정의
    <br>-> 이를 구현하는 클래스를 만든 후 Object 를 필요로 하는 클래스에 주입
- 객체의 생성을 인터페이스로 추상화했기 때문에
  런타임에도 자유롭게 factory 를 바꿔 쓸 수 있음

<h4>공통점</h4>
Object 생성을 캡슐화하여 구체적인 구현으로부터 느슨하게 결합되도록 함

<h4>차이점</h4>
Factory Method : inheritance 를 통해 Object 생성
               : 하나의 object 의 생성만을 담당
Abstract Factory : Object composition 을 통해 생성
                 : 서로 관련있는 여러개의 object 생성을 담당


