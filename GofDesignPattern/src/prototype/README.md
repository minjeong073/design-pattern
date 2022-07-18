## Prototype Pattern

+ 개요
  + new 명령얼 특정 객체의 인스턴스를 만들 때 클래스 이름을 지정해야함
  + But 클래스 이름을 지정하지 않고 인스턴스 생성할 때도 있음
  + cloneable 인터페이스, clone 메서드 사용



+ clone : 자신을 복제하여 새로운 인스턴스 생성
  - shallow copy : 원본과 복제본이 같은 객체 공유
                         : 참조하는 주소값이 같기 때문에 원본 변경하면 복사본도 변경됨
  - deep copy : 원본이 참조하고 있는 객체까지 복제
                      : 서로 다른 주소값을 가리키기 때문에 원본 변경이 복사본에 영향 미치지 않음

ex)
```java
class Circle implements Cloneable {
    Point p;    // 원점
    double r;   // 반지름
  
    Circle(Point p, double r) {
        this.p = p;
        this.r = r;
    }
}

class Point {
    int x, y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


1) shallow copy

public Circle shallowCopy() {
        Object obj = null;
        try {
        obj = super.clone();
        } catch (CloneNotSupportedException e) {}
        return (Circle) obj;
        }

2) deep copy

public Circle deepCopy() {
    Object obj = null;
    try {
        obj = super.clone();        
    } catch (CloneNotSupportedException e) {}
    Circle c = (Circle) obj;
    c.p = new Point(this.p.x, this.p.y);
    return c;
}
```

+ 사용하는 경우
  + 종류가 너무 많아 클래스로 정리되지 않는 경우
    + 취급하는 오브젝트 종류가 너무 많아서 각각을 별도의 클래스로 만들어 
      다수의 소스파일을 작성해야 하는 경우
  + 클래스로부터 인스턴스 생성이 어려운 경우
    + 생성하고자 하는 인스턴스가 복잡한 작업을 거쳐 만들어질 경우
      등록된 인스턴스를 복사해서 새 인스턴스 생성
  + framework 와 생성할 인스턴스를 분리하고 싶은 경우
    + 인스턴스를 생성할 때 framework 를 특정 클래스에 의존하지 않도록 만들 경우
    + 이미 모형이 되는 인스턴스를 등록해두고, 인스턴스를 복사해서 새 인스턴스 생성


+ 예
  + Product(framework package) 
    + 추상 메서드 use, createClone 이 선언된 인터페이스
    + 이 인터페이스를 구현하고 있는 클래스라면 인스턴스 복제 가능
  + Manager(framework package)
    + createClone 을 사용해서 인스턴스 복제하는 클래스
    + 구체적으로 어느 클래스의 인스턴스를 복제하는지는 관여하지 않음
  + MassageBox(Anonymous package)
    + 문자열을 테두리로 표시하는 클래스
    + use, createClone 구현
  + UnderlinePen(Anonymous package)
    + 문자열에 밑줄을 표시하는 클래스
    + use, createClone 구현
  

+ Prototype Pattern 필요성
  + 많은 종류의 인스턴스가 생성될 경우 각각의 클래스로 관리하기에는 용이성 떨어짐
  + 예를 들어 게임 캐릭터를 생성할 때 다양한 스킬이 다 설정된 스킬 세팅 인스턴스를
    매번 프로그래밍해서 만드는 것은 번거로움 -> 인스턴스를 복사해서 만들면 간단


+ 참고
  + 특정 클래스명이 소스코드 안에 있을 경우 소스코드와 클래스를 분리해서 재사용 할 수 없음
  + 소스를 고쳐서 클래스 이름을 변경하는 것은 중요하지 않음
    소스파일(.java)이 없어도 재사용 할 수 있는지가 중요함
  + 부품으로써 모듈화 해야하는 클래스명이 소스 안에서 사용되는 것은 문제 될 수 있음