package singleton.doubleCheckedLocking;

/*
static 메서드에 lock 을 걸어 이미 인스턴스를 생성한 뒤에도 매번 lock 을 검
단점 : Lazy initialization 과 성능 모두 비슷하나 구현이 복잡
(+ 낮은 확률로 둘 이상의 인스턴스가 생성될 수 있다는 반례 O
-> 현재는 권고되지 않는 broken idiom)
 */

class Singleton {
    private volatile static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}