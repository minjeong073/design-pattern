## Composite Pattern

+ 개요
  + 전체와 부분(복합 개체와 단일 개체)을 동일시해서 재귀적인 구조를 만들기 위한 디자인 패턴
  + 예 ) 
    + 컴퓨터 파일 시스템의 'Directory' 는 내부에 또 다른 Directory 가 있을 수도 있고, File 이 있을 수도 있는 재귀적인 구조를 만들어냄
    + 하나의 Directory 를 가지고 내부에 무엇이 있는지 조사할 경우, Directory 와 File 두 종류를 하나의 'Directory Entry' 로 취급해 차례대로 조사할 수 있음
    
<br>

+ 역할
  + Leaf
    + '내용물' 을 표시하는 역할을 하며, 내부에는 다른 것을 넣을 수 없음
    + 예제의 File
  + Composite
    + '그릇' 을 나타내는 역할을 하며, Directory Entry (Leaf 또는 Composite) 를 넣을 수 있음
    + 예제의 Directory
  + Component
    + Directory Entry 역할을 하며, Leaf 가 될 수도 있고, Composite 가 될 수도 있음
    + 예제의 Entry

<br>

+ 예

| 클래스       | 설명                                                                                                                                                                                                                                                                  |
|-----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Entry     | 추상 클래스로서 Directory 와 File 을 하나로 합친 클래스 <br> `add` 메서드로 Directory 안에 Directory 또는 File 을 넣음 <br> printList 메서드는 오버로드로 구현, 인자값이 있는 printList 메서드는 protected 접근제어자에 의해 Entry 의 하위 클래스에서만 사용                                                                            |
| Directory | 크기를 동적으로 계산하기 때문에 size 필드가 없음 <br> Directory 내부에 Entry 가 포함될 수 있기 때문에 ArrayList 타입의 directory 필드를 가짐 <br> getSize 메서드를 수행하면 iterator 반복문이 동작하면서 directory 내부의 Entry 를 각각 꺼내어 getSize() 호출함 <br> -> Directory, File 에 상관 없이 getSize() 메서드가 동작함 ==> Composite Pattern |