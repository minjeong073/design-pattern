#07 Adapter and Facade Pattern

<h4>특징</h4>
+ 두 패턴 모두 기존의 인터페이스를 다른 인터페이스로 대체하여 Client 와 
    이들이 사용하는 시스템과의 커플링을 낮추는 것을 목적으로 함

| 패턴        | 목적                  |
|:----------|:--------------------|
| Decorator | 인터페이스 변경 없이 책임을 추가  |
| Adapter   | 인터페이스를 다른 인터페이스로 변경 |
| Facade    | 인터페이스를 단순하게 만듦      |


## Adapter Pattern
어떤 소프트웨어를 만들었을 때 기존의 벤더에 맞게 만들었기 때문에 지금까진 잘 동작했지만,
새로운 벤더의 모듈과는 맞지 않을 경우 어댑터라는 중간 매체를 만들어서 둘을 연결
(기존의 코드나 벤더의 코드 변경 없이)

### 오리 시뮬레이션 게임

오리 객체가 부족하여 칠면조 객체를 오리 객체로서 사용하고 싶을 경우

```java
public class Test {
    public static void main(String[] args) {
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        ...
    }
}

public class TurkeyAdapter implements Duck {
    Turkey turkey;
    
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    
    public void quack() {
        turkey.gobble();
    }
    
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
```

## Facade Pattern

- Adapter 는 incompatible 한 인터페이스 간의 변환을 위한 것인 반면,
  Facde 는 기존의 복잡하 인터페이스를 단순화 하기 위해 인터페이스를 교체하는 것
- Client 는 단 하나의 Facade 만을 통해서 subsystem 을 조작
- Facade 가 관리하는 subsystem 은 Principle of Least Knowledge(Law of Demeter) 를 지키도록 해야함


[Law of Demeter] <br> 
+ 객체는 내부적으로 보유하고 있거나 메시지를 통해 확보한 정보만 가지고 의사 결정을 내려야 함 <br>
+ 다른 객체를 탐색해 뭔가를 일어나게 해서는 안됨 <br>
+ 한 객체가 알아야 하는 다른 객체를 최소한으로 유지하라 (Principle of lease knowledge)


- 호출해도 되는 메서드
  - 자신이 가진 메서드
  - 메서드의 파라미터로 전달되는 객체가 가진 메서드
  - 메서드가 생성하거나 인스턴스화 하는 객체의 메서드
  - 멤버 변수의 메서드
- 호출하지 말아야 하는 메서드
  - 다른 메서드가 return 한 객체의 메서드
  

ex) 
```java
public class Car {
    Engine engine;
    
    public Car() {
        // initialize ...
    }
    
    public void start(Key key) {
        Doors doors = new Doors();
        
        boolean authorized = key.turns();   // 파라미터로 넘어온 객체의 메서드 -> 호출 가능
        
        if (authorized) {
            engine.start(); // 인스턴스 변수의 메서드 -> 호출 가능
            updateDashboardDisplay();   // 객체 내의 다른 메서드 -> 호출 가능
            doors.lock();   // 직접 생성했거나 인스턴스화한 객체의 메서드 -> 호출 가능
        }
    }
    
    public void updateDashboardDisplay() {
        // update display
    }
}
```
<br>

ex) Principle of Least Knowledge 를 적용하지 않은 코드
```java
public float getTemp() {
    Thermometer thermometer = station.getThermometer();
    return thermometer.getTemperature();
    }
```

```java
public class House {
    WeatherStation station;
    
    public float getTemp() {
        return station.getThermometer().getTemperature();
    }
}
```

ex) Principle of Least Knowledge 를 적용한 코드
```java
public float getTemp() {
    return station.getTemperature();
    }
```

```java
public class House {
    WeatherStation station;
    
    public float getTemp() {
        Thermometer thermometer = station.getThermometer();
        return getTempHelper(thermometer);
    }

    public float getTempHelper(Thermometer thermometer) {
        return thermometer.getTemperature();
    }
}
```
