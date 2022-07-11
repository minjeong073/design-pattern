#05 Singleton Pattern

<h4>특징</h4>
+ private 생성자 -> 상속 X
+ single instance, global access point 제공
+ 멀티스레드 일 때 volatile static 으로 인스터스 변수 선언해야함
  (volatile : CPU 캐시가 아니라 메모리에 저장해서 스레드마다 서로 사용하는 데이터 같게 만듦)


<h4>구현방식</h4>
+ 인스턴스를 담을 static field
+ private default constructor
+ 인스턴스를 리턴할 static method

<hr>

+ 싱글스레드
   + static factory method 에서 null 체크
    -> null 일때만 new 로 static field 초기화한 후 인스턴스 리턴
+ 멀티스레드
   + class 가 로드되는 순간 초기화
     (static 으로 선언된 인스턴스에 new 키워드로 초기화)
   + lock(synchronized static method)
   + double-checked lock(null-check, lock, additional null-check)
+ 기타
    + LazyHolder(static nested class)
    + enum

<hr>

<b>1) classic</b>
   - 가장 기본적인 구현
   - Lazy Initialization 으로 리소스 절얄할 수 있음
   - 단점 : 멀티스레드 환경에서는 여러개의 인스턴스가 만들어질 수 있음


<b>2) locking</b>
   - 처음 instantiation (특정 클래스에 대하여 인스턴스를 만들어내는 것)
     을 할 때에만 lock 을 걸면 됨
   - 단점 : 이후에도 계속 불필요한 lock 으로 성능 저하를 야기

<b>3) double-checked locking</b>
   - static 메서드에 lock 을 걸어 이미 인스턴스를 생성한 뒤에도 
    매번 lock 을 검
   - 단점 : Lazy initialization 과 성능 모두 비슷하나 구현이 복잡
   - (+ 낮은 확률로 둘 이상의 인스턴스가 생성될 수 있다는 반례 O 
     -> 현재는 권고되지 않는 broken idiom)

<b>4) eagerly created</b>
  - 클래스가 로드될 때 초기화
  - 멀티스레드 환경에서도 unique 한 인스턴스 보장
  - 단점 : lazy initialization 이 아님

<b>5) enum</b>
  - 단일 인스턴스를 보장
  - Serialization 등을 기본적으로 지원
  - 단점 : lazy initialization 이 아님
        : 인스턴스 생성시 외부에서 parameter 전달할 수 없음

<b>6) lazyHolder</b>
  - 현재까지 가장 완벽하다고 평가받은 이디엄
  - lazy initialization, 멀티스레드, 성능 모두 완벽