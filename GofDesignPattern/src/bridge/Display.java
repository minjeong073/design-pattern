package bridge;

// '기능의 클래스 계층' 최상위 클래스로,
// '구현의 최상위 계층' 인 DisplayImpl 을 인자로 받아 기능 구현 부분을 호출해 동작
public class Display {
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
