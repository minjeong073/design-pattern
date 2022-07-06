package prototype;

public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print("");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
    /*
    clone() 메서드는 자신의 클래스나 하위 클래스에서만 호출할 수 있기 때문에
    Manager 클래스에서 바로 복제하는 것이 아닌
    createClone() 같은 다른 메서드를 이용해 clone 을 구현할 필요가 있음
     */
}
