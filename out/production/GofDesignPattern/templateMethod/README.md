## Template Method Pattern

알고리즘의 구조를 메서드에 정의하고 
하위 클래스에서 알고리즘 구조의 변경 없이 알고리즘을 재정의하는 패턴

+ 참고) Gof 디자인 패턴에서 정의하는 template method pattern 목적
  + 알고리즘의 골격을 정의하고 일부 단계를 하위 클래스로 연기
  + 하위 클래스에서 전체 구조를 변경하지 않고 알고리즘의 특정 단계를 재정의 가능 

일정한 프로세스를 가진 요구사항을 template method pattern 을 이용하여 구현 할 수 있음
(ex Spring Security 의 인증 및 인과 과정, annotation 프로세서의 라운드 구조,
 로직의 완성까지 로직이 순차적인 일정 단계가 있는 경우 등)


* 예 :
    - 요구사항 : 시민들을 징집해서 병사로 만들기
      - 1 시민들 중 마린이 될 수 있는 조건의 시민을 징집하기
        conscriptionCitizen():Citizen
      - 2 징집된 군인들을 훈련하기
        training(Citizen):void
      - 3 보직을 시민에서 병사로 변경하기
        changeOfPosition(Citizen citizen):Soldier
      - 4 장비를 보급하기
        supplyEquipment(Solder soldier);

    - 장점 : 
      - 상세 요구사항을 모듈화 했기 때문에 재사용성 높아짐
      - SoldierConscriptionHelperImpl 구현체의 메서드 내용만 변경하면됨
      - Template Method Pattern : 일정한 프로세스를 가진 요구사항을 정의할 때 
        알고리즘의 구조를 메서드에 정의한 후 하위 클래스에서 알고리즘 구조의 변경 없이
        알고리즘을 재정의 하는 패턴