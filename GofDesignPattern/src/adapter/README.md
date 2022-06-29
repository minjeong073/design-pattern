## Adapter Pattern

클라이언트의 요구 타입과 반환 타입이 다를 경우
중간에 어댑터를 이용해서 가공하여 둘을 연결지어줌

### 장점
매번 요구사항마다 새로운 알고리즘을 구현할 필요 없이
기존의 알고리즘을 변형해 재활용 할 수 있음


* 예 : 
  - Math.java class : double type 의 값을 받아 double type 으로 반환
  - 요구사항 : Float type 의 값을 받아 Float type 으로 반환
        -> Adapter.java
  - Adapter 의 twiceOf 와 halfOf 만 사용하면 기존에 존재하던
    twoTime, half 메서드를 이용 가능