#01 Observer Pattern

### 날씨 앱 만들기

<hr/>

<h4>초기버전</h4>

```java
class WeatherData {
    public void measurementsChanged() {
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();

        currentConditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
    }
}
```
+ 문제점
  + display 가 추가될 때마다 코드를 변경해야함
  + display 를 런타임에 추가 삭제할 수 없음
  + 인터페이스를 사용하지 않고 구체적인 구현을 함
  + 변하는 부분 캡슐화 하지 않음

<h4>Observer pattern 적용</h4>
    
+ 데이터를 관리하는 단 하나의 클래스 Subject
  -> 변경 시에만 동기화 하여 observer 들이 공유하도록 함
+ 모든 대상이 데이터를 관리하지 않음
<br><br>
+ 장점
  + Observer 인터페이스를 구현하기만 하면 
    어떤 클래스던 상관 없이 데이터 변경 시 알림을 받을 수 있음
  + Subject 는 각 observer 클래스들과 관계 없이
    일관된 인터페이스로 데이터 변경 알림을 줄 수 있음
  + 새로운 Observer 를 추가할 경우 Subject 코드 변경 없이 데이터 관리 가능
<br>

<h4>Design Principal</h4>

+ Strive for loosely coupled designs between objects that interact
<br>
  (느슨하게 결합된 설계는 더 유연한 코드를 만든다)

<h4>일반적인 observer pattern</h4>

+ Subject 와 Observer 로 이루어짐
+ push 방식 ( Subject 만 Observer 에게 데이터 전송 가능)

<h4>Java built-in observer pattern</h4>

+ 특징
  + Observer 와 Observable 로 이루어짐
  + Subject 가 인터페이스였던 것과 다르게 Observable 은 클래스

+ 장점
  + push 방식과 pull 방식(Observer 가 직접 데이터를 가져감) 모두 지원
  + 주요 메서드를 상속받기 때문에 직접 구현할 필요 없음
  

<h4>push 방식 vs pull 방식</h4>

push
+ 장점
  + 데이터 변경 시에만 알림을 받을 수 있음
+ 단점
  + 모든 Observer 에게 일관된 방식으로 데이터를 전송해야함
    -> 필요하지 않은 데이터도 모두 받게됨
  + Subject 가 관리하는 새로운 데이터가 추가될 경우
    Observer 들에게 변경된 데이터를 notify 하는 코드 변경이 불가피함
  
pull
+ 장점
  + 각 Observer 들은 필요한 데이터만 getter 메서드를 통해 받아올 수 있음
  + Subject 가 관리하는 새로운 데이터가 추가되어도 
    notify 하는 코드 변경 없이 getter 사용
+ 단점
  + 데이터가 변경되지 않았을 때에도 getter 로 데이터를 직접 가져가야함 