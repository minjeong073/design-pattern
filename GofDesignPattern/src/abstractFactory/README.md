## Abstract Factory Pattern

+ 개요
  + Abstract Factory 즉, 추상적인 공장에서는 추상적인 제품을 만들 것
  + 객체 지향에서 abstract 는 구현부에 신경쓰지 않고 API(인터페이스)만 생각하는 것
  + 따라서 Abstract Factory Pattern 은 구현부에 신경쓰지 않고 인터페이스에 집중하여 
    인터페이스만을 사용해 부품을 조립하고 제품으로 완성하는 방법


+ Abstract Factory Pattern

| 클래스             | 역할                                               |
|:----------------|:-------------------------------------------------|
| AbstractProduct | AbstractFactory 역할에 의해 만들어지는 추상적인 부품이나 제품의 인터페이스 |
| AbstractFactory | AbstractProduct 역할의 인스턴스를 만들어내기 위한 인터페이스 결정      |
| ConcreteProduct | AbstractProduct 역할에서 명세되어있는 인터페이스를 구현            |
| ConcreteFactory | AbstractFactory 역할에서 명세된 인터페이스 구현                |


+ ex)
  + 계층형 구조의 HTML 파일을 구성하는 Factory, List, Tray, Page 구현


+ 참고
  + 구체적인 공장을 추가하는 것은 간단하지만, 부품 추가는 곤란하다
    + 어떤 클래스를 만들고, 어떤 메서드를 구현하면 좋을지는 명확
    + 아무리 공장을 추가해도 Abstract Factory 부분이나 main 부분을 수정할 필요 없음
    + 단지 구현되는 새로운 구체적인 공장 부분만 변경하면 됨
    + 하지만, 새로운 부품이 추가된다면 기존 부품과 로직으로 구현된 공장들은
      모두 새로 추가된 부품에 대해 대응되는 수정을 해야하기 때문에 작업이 복잡해짐

