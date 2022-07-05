package factoryMethod;

public abstract class Factory {

    // Template Method Pattern 사용
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 실제 제품 인스턴스 생성
    protected abstract Product createProduct(String owner);
    // 신분증 소유자 등록 메서든
    protected abstract void registerProduct(Product p);
}
