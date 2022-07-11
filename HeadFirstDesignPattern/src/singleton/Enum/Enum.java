package singleton.Enum;

/*
단일 인스턴스를 보장
Serialization 등을 기본적으로 지원
단점 : lazy initialization 이 아님
    : 인스턴스 생성시 외부에서 parameter 전달할 수 없음
 */

enum Singleton {
    INSTANCE;
}
