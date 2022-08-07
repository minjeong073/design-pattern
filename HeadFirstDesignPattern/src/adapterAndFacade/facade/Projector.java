package adapterAndFacade.facade;

public class Projector {
    String name;
    DvdPlayer dvdPlayer;

    public Projector(String name) {
        this.name = name;
    }

    public void setInput(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public void on() {
        System.out.println(name + " Projector on");
    }

    public void wideScreenMode() {
        System.out.println(name + " Projector in wide screen mode (16x9 aspect ratio)");
    }

    public void off() {
        System.out.println(name + " Projector off");
    }
}
