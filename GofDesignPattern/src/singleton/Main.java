package singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("instance1 과 instance2 동일성 비교 :: "
            + (instance1 == instance2));
        System.out.println("end");
    }
}
/*
결과

start
created Singleton
instance1 과 instance2 동일성 비교 :: true
end

static 메서드 -> 동일한 인스턴스 반환
 */