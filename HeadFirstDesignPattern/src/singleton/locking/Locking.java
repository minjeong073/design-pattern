package singleton.locking;

/*
처음 instantiation (특정 클래스에 대하여 인스턴스를 만들어내는 것)
을 할 때에만 lock 을 걸면 됨
단점 : 이후에도 계속 불필요한 lock 으로 성능 저하를 야기
 */

class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
