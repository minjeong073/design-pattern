package prototype;

public interface Product extends Cloneable {
    // java.lang.Cloneable -> 복제가 가능하게 함
    public abstract void use(String s);
    public abstract Product createClone();
}
