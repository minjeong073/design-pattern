package decorator;

public abstract class Display {

    public abstract int getColumns();   // 가로 문자 수를 얻음

    public abstract int getRows();  // 세로 행 수를 얻음

    public abstract String getRowText(int row); // row 번 째의 문자열 얻음

    public final void show() {  // 전부 표시
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }

}
