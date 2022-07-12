# design-pattern

### Head First Design Pattern


 No | Chapter                       | Done               |
:-- | :-----------------------------| :------------------|
| 1 | Strategy Pattern              | :white_check_mark:  |
| 2 | Observer Pattern              | :white_check_mark:  |
| 3 | Decorator Pattern             | :white_check_mark:  |
| 4 | Factory Pattern               | :white_check_mark:  |
| 5 | Singleton Pattern             | :white_check_mark:  |
| 6 | Command  Pattern              | :black_square_button: |
| 7 | Adapter & Facade Patterns     | :black_square_button: |
| 8 | Template Method Pattern       | :black_square_button: |
| 9 | Iterator & Composite Patterns | :black_square_button: |
| 10 | State Pattern                | :black_square_button: |
| 11 | Proxy Pattern                | :black_square_button: |
| 12 | Compound Patterns            | :black_square_button: |
| 13 | Leftover Pattern             | :black_square_button: |

### Gof Design Pattern


 No | Chapter                       | Done               |
:-- | :-----------------------------| :------------------|
| 1 | Strategy Pattern              | :white_check_mark:  |
| 2 | Adapter Pattern               | :white_check_mark:  |
| 3 | Template Method Pattern       | :white_check_mark:  |
| 4 | Factory Method Pattern        | :white_check_mark:  |
| 5 | Singleton Pattern             | :white_check_mark:  |
| 6 | Prototype  Pattern            | :white_check_mark:  |
| 7 | Builder Patterns              | :black_square_button: |
| 8 | Abstract Factory Pattern      | :black_square_button: |
| 9 | Bridge Patterns               | :black_square_button: |
| 10 | Composite Pattern            | :black_square_button: |
| 11 | Proxy Pattern                | :black_square_button: |
| 12 | Compound Patterns            | :black_square_button: |
| 13 | Leftover Pattern             | :black_square_button: |

<hr>

## Design Pattern

:low_brightness:
디자인 패턴 : 모듈의 세분화된 역할이나 모듈들 간의 인터페이스 구현 방식 등을 
            설계할 때 참조할 수 있는 전형적인 해결 방식<br>
          : GoF 디자인 패턴 - 생성 패턴 5개, 구조 패턴 7개, 행위 패턴 11개

### GoF 디자인 패턴

- 목적에 따라 분류 
  - 생성 : 객체의 생성 과정에 관여
  - 구조 : 객체의 합성에 관여
  - 행동 : 객체가 상호작용하는 방법이나 관심사 분리하는 방법에 관여

- 범위에 따라 분류 
  - 클래스 : 클래스와 서브클래스 간의 관련성(주로 상속)<br>
          : 컴파일 타임에 정적으로 결정
  - 객체 : 객체 간의 관련성 / 런타임에 변경될 수 있는 동적인 성격

<hr>
<b> 1. 생성 패턴</b>

- 객체의 인스턴스 과정을 추상화 하는 방법
- 객체의 생성과 참조 과정을 캡슐화 
 -> 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 받지 않도록 함


- 생성 클래스 패턴
  - 객체를 생성하는 일부를 서브 클래스가 담당
- 생성 객체 패턴
  - 객체 생성을 다른 객체에게 위임
  
| 이름               | 의도                                               |
|:-----------------|:-------------------------------------------------|
| Abstract Factory | 구체적인 클래스를 지정하지 않고 인터페이스를 통해 서로 연관되는 객체들을 그룹으로 표현 |
 | Builder          | 복합 객체의 생성과 표현을 분리하여 동일한 생성 절차에도 다른 표현 결과 만들어냄    |
 | Factory Method   | 객체 생성을 서브 클래스로 위임하여 캡슐화                          |
| Prototype        | 원본 객체를 복사함으로써 객체를 생성                             |
| Singleton        | 어떤 클래스의 인스턴스는 하나임을 보장하고 어디서든 참조할 수 있도록 함         |


<hr>
<b> 2. 구조 패턴</b>

- 클래스나 객체들을 조합해 더 큰 구조로 만들 수 있게 해줌



- 구조 클래스 패턴
  - 상속을 통해 클래스나 인터페이스 합성
- 구조 객체 패턴
  - 객체를 합성하는 방법을 정의

| 이름        | 의도                                                     |
|:----------|:-------------------------------------------------------|
| Adapter   | 클래스의 인터페이스를 다른 인터페이스로 변환하여 다른 클래스가 이용할 수 있도록 함         |
| Bridge    | 구현부에서 추상층 분리 -> 각자 독립적으로 확장할 수 있도록 함                   |
| Composite | 객체들의 관계를 트리 구조로 구성 -> 복합 객체, 단일 객체를 구분 없이 다룸           |
| Decorator | 주어진 상황 및 용도에 따라 어떤 객체에 다른 객체를 덧붙임                      |
| Facade    | 서브 시스텝에 있는 인터페이스 집합에 대해 하나의 통합된 인터페이스 (Wrapper) 제공     |
| Flyweight | 크기가 작은 여러개의 객체를 매번 생성하지 않고, 가능한 한 공유할 수 있도록 -> 메모리 절약  |
| Proxy     | 접근이 어려운 객체로의 접근을 제어하기 위해 객체의 Surrogate, Placeholder 제공 |


<hr>
<b>행위 패턴</b>

- 클래스나 객체들이 서로 상호작용하는 방법, 어떤 알고리즘을 어떤 객체에 할당하는 것이 좋을지 정의
- 하나의 객체로 수행할 수 없는 작업을 여러 객체로 분배 -> 결합도 최소화


- 행위 클래스 패턴
  - 상속을 통해 알고리즘과 제어 흐름을 기술
- 행위 객체 패턴
  - 작업을 수행하기 위해 객체 집합이 어떻게 협력하는지 기술

| 이름                      | 의도                                                         |
|:------------------------|:-----------------------------------------------------------|
| Chain of Responsibility | 요청 받는 객체를 연쇄적으로 묶어 요청을 처리하는 객체를 만날때까지 객체 Chain 을 따라 요청을 전달 |
| Command                 | 요청을 객체의 형태로 캡슐화 <br> -> 재사용하거나 취소할 수 있도록 저장                |
| Interpreter             | 특정 언어의 문법 표현을 정의함                                          |
| Iterator                | 내부를 노출하지 않고 접근이 잦은 어떤 객체의 원소를 순차적으로 접근할 수 있는 동일한 인터페이스 제공  |
| Mediator                | 한 집합에 속해있는 객체들의 상호작용을 캡슐화하여 새로운 객체로 정의                     |
| Memento                 | 객체가 특정 상태로 다시 돌아올 수 있도록 내부 상태를 실체화                         |
| Observer                | 객체 상태가 변할 때 관련 객체들이 그 변화를 통지받고 자동으로 갱신                     |
| State                   | 객체의 상태에 따라 동일한 동작을 다르게 처리해야할 때 사용                          |
| Strategy                | 동일 계열의 알고리즘 군을 정의, 캡슐화하여 상호교환이 가능하도록 함                     |
| Template Method         | 상위 클래스는 알고리즘의 골격만을 작성, 구체적인 처리는 서브 클래스로 위임                 |
| Visitor                 | 객체의 원소에 대해 수행할 연산을 분리하여 별도의 클래스로 구성                        |

