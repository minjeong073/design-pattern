package singleton.eagerlyCreated;

/*
Class 가 로드될 때 초기화
-> 멀티스레드 환경에서도 unique 한 인스턴스는 보장
단점 : Lazy initialization 아님
*/

class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
