## Builder Pattern

+ 개요
  + 전체를 구성하는 각 부분을 만들면서 단계를 밟아가며 만들어나감
  + 구조를 가진 인스턴스를 쌓아 올리는 방식의 패턴


+ ex)
  +
  | 클래스 이름      | 해설                                |
  |:------------|:--------------------------------------|
  | Builder     | 문서를 구성하기 위한 메서드를 결정하는 추상 클래스      |
  | Director    | 한 개의 문서를 만드는 클래스                  |
  | TextBuilder | 일반 텍스트(보통의 문자열)를 이용해서 문서를 만드는 클래스 |
  | HTMLBuilder | HTML 파일을 이용해서 문서를 만드는 클래스         |
  | Main | 프로젝트 구동시 인자값으로 주어지는 args 에 따라 plain, html 로 분기|

  + Builder
    + 인스턴스 생성하기 위한 인터페이스(API) 결정
    + 인스턴스의 각 부분을 만들기 위한 메서드가 준비됨
  
  + Director
    + Builder 클래스에 선언되어있는 메서드로 문서 생성 로직을 구현
    + Builder 클래스의 하위 클래스의 인스턴스가 인자 값으로 오게됨
    + ConcreteBuilder 역할과 관계 없이 제대로 기능하도록 Builder 역할의 메서드만 사용
  
  + TextBuilder, HTMLBuilder
    + ConcreteBuilder 역할을 수행
    + Builder 역할의 인터페이스(API)를 구현하는 클래스ㅐ
    + 실제 인스턴스 작성으로 호출되는 메서드가 여기서 정의됨


  + 참고
    + OOP 에서 '누가 무엇을 알고 있을까?'
      + 어떤 클래스가 어떤 메서드를 사용할 수 있을까?
      + Main 클래스 : Builder 클래스의 메서드 모르고, 호출하지도 않음 <br>
        Director 클래스의 constructor() 메서드만 호출
      + Director 클래스 : Builder 클래스 메서드 사용해서 문서 구죽 <br>
        자신이 실제로 이용하는 클래스가 TextBuilder 인지, HTMLBuilder 인지
        또 다른 Builder 의 하위 클래스인지 모름
      + --> Director 클래스가 자신이 이용하고 있는 Builder 클래스의 하위 클래스를 모르기 때문에
        결합도가 낮아 교체가 가능함 = 교환 가능성이 높음
