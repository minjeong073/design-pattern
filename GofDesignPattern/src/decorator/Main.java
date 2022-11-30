package decorator;

public class Main {
    public static void main(String[] args) {
        StringDisplay border1 = new StringDisplay("Hello, world");
        SideBorder border2 = new SideBorder(border1, '#');
        FullBorder border3 = new FullBorder(border2);

        border1.show();
        border2.show();
        border3.show();

        Display border4 = new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("안녕하세요")
                                        ), '*')
                        )
                ), '/');

        border4.show();
    }
}

/*
출력 결과

Hello, world
#Hello, world#
+--------------+
|#Hello, world#|
+--------------+
/+---------------------+/
/|+-------------------+|/
/||*+---------------+*||/
/||*|안녕하세요|*||/
/||*+---------------+*||/
/|+-------------------+|/
/+---------------------+/

 */