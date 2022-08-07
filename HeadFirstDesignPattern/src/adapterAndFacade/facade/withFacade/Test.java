package adapterAndFacade.facade.withFacade;

import adapterAndFacade.facade.Amplifier;
import adapterAndFacade.facade.CdPlayer;
import adapterAndFacade.facade.DvdPlayer;
import adapterAndFacade.facade.PopcornPopper;
import adapterAndFacade.facade.Projector;
import adapterAndFacade.facade.Screen;
import adapterAndFacade.facade.TheaterLights;
import adapterAndFacade.facade.Tuner;

public class Test {
    public static void main(String[] args) {

        String movie = "Raiders of the Lost Ark";

        PopcornPopper popper = new PopcornPopper();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        Amplifier amp = new Amplifier("Top-O-Line");
        DvdPlayer dvd = new DvdPlayer("Top-O-Line");
        Projector projector = new Projector("Top-O-Line");
        Tuner tuner = new Tuner(amp);
        CdPlayer cd = new CdPlayer(amp);
        dvd.setAmplifier(amp);
        amp.setCdPlayer(cd);
        amp.setTuner(tuner);

        HomeTheaterFacade homeTheater =
            new HomeTheaterFacade(amp, tuner, dvd, cd, projector,
                lights, screen, popper);

        homeTheater.watchMovie(movie);
        homeTheater.endMovie();
    }
}
