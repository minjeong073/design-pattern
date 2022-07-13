#06 Command Pattern

### 만능 리모컨 만들기

<hr>

+ 1 각 소켓마다 on / off 버튼이 있는 리모컨
  + 각 소켓에 디바이스 연결 가능
+ 2 이전 명령 실행 취소 기능 추가
  + Command 인터페이스에 undo() 추가
+ 3 모드가 여러개 있는 디바이스 지원 추가
  + 하나의 소켓에 특정 디바이스의 한가지 모드로 설정할 수 있는 기능 추가
+ 4 매크로 기능 추가
  + Command 의 배열을 가진 또다른 Concrete Command 정의 -> invoker 에 setting
  + execute() 에서 반복문을 통해 들고있는 모든 Command 들의 execute() 호출
  + 실행 취소 기능은 반복문을 통해 들고있는 모든 Command 들의 undo() 호출
+ 5 실행취소(undo)가 여러번 가능한 기능 추가
  + request 의 히스토리 관리
+ 6 redo 도 여러번 가능한 기능 추가


<h4>Command Pattern</h4>

+ Request(Command)를 Object 로 Encapsulate <br>
  -> 해당 Request 를 큐에 넣거나 로깅을 할 수 있게도 하며,
  실행 취소도 가능하게 하는 디자인 패턴
+ Command 라는 인터페이스를 통해 
  실제 액션을 수행하는 클래스와 명령을 내리는 클래스 간의 결합도 낮춤
+ 명령을 내리는 클래스는 실제 액션이 어떻게 동작하는지 모름
+ 런타임에서 Command 를 구현하는 클래스 간의 교체를 통해 
  동적으로 action 을 변경 할 수도 있음
  + 비유 : Client - Customer / User
          Invoker - Waitress / Universal Remote Control
          Command - Order / Device Driver
          Receiver - Chef / Device


<h4>활용 예</h4>

+ Job queue, schedulers, thread pools
+ Logging requests
  + 변경사항이 발생할 때마다 파일 전체를 저장하는 것은 어려움
  -> 매번 해당 변경사항만 따로 store 하고, 프로그램이 죽었다가 다시 살아났을 경우
    저장했던 command 들을 다시 load 하여 복구
  + 해당 기능을 확장해서 transactional 한 기능 구현 가능
