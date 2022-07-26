## Factory Method Pattern

- 개요
  - 객체를 만들어내는 부분을 서브 클래스에 위임하는 패턴
  new 키워드를 호출해 객체를 생성하는 역할을 서브 클래스에 위임
  --> 객체를 만들어내는 공장을 만드는 패턴

  - 인스턴스 만드는 방법(framework)은 상위 클래스에서 결정
  - 구체적인 내용은 하위 클래스에서 수행

- 예
  - 신분증을 만드는 공장
    - framework : Product, Factory
    - 구체적인 구현 클래스 : IDCard, IDCardFactory
    - Factory 에서 제품 생성 : create
    -> create 함수 내부는 일련의 과정의 알고리즘이기 때문에
        template method pattern
    - 실제 제품 인스턴스 생성 메서드 : createProduct
    - 신분증 소유자 등록 메서드 : registerProduct
    - Product 에서 제품 사용 : use

  - 각 클래스 역할
    - Product(제품)
      - framework 에 포함
      - 생성되는 인스턴스가 가져야 할 인터페이스(API)
        결정하는 것 = 추상 클래스
    - Creator(Factory)(작성자)
      - Product 역할,
      인스턴스 생성의 메서드를 호출하면 Product 가 생성됨
      -> new 를 사용해서 실제 인스턴스를 생성하는 대신에
        인스턴스 생성을 위한 메서드를 호출해서 구체적인 클래스 이름에 대한
        속박에서 상위 클래스를 자유롭게 만듦
    - ConcreteProduct(구체적인 제품)
      - 구체적인 제품을 결정
    - ConcreteCreator(구체적인 작성자)
      - 구체적인 제품을 만드는 클래스 결정
- 인스턴스 생성 - 메서드 구현 방법
  - 추상 메서드로 구현 : 하위 클래스에서 무조건 오버라이딩해서 구현
                    : 구현하지 않을 경우 컴파일 시점에서 검출됨
```java
protected abstract Product createProduct(String owner); 
```
- 디폴트의 구현을 준비 : 하위 클래스에서 구현하지 않을 경우 대비
                      : 직접 new 를 이용하기 때문에 상위 클래스를 추상 클래스로 둘 수 없음
```java
protected Product createProduct(String name) {
    return new Product(name);
}
```
- 에러 이용 : 디폴트의 구현 내용을 에러로 처리해서 구현하지 않았을 경우 실행할 때 에러 발생
```java
protected Product createProduct(String name) {
    throw new Exception(...);
}
```



