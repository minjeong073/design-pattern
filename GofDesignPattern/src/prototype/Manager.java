package prototype;

import java.util.HashMap;

public class Manager {
    private final HashMap<String, Product> showcase = new HashMap<>();
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }

    public Product create(String protoname) {
        Product p = showcase.get(protoname);
        return p.createClone();
    }
    // Product 라는 인터페이스 이름만 가지고 사용하고 있기 때문에
    // 실제 구현 클래스와 관계 맺지 않음
}
