package adapterAndFacade.facade.withFacade;

import adapterAndFacade.facade.Amplifier;
import adapterAndFacade.facade.CdPlayer;
import adapterAndFacade.facade.DvdPlayer;
import adapterAndFacade.facade.PopcornPopper;
import adapterAndFacade.facade.Projector;
import adapterAndFacade.facade.Screen;
import adapterAndFacade.facade.TheaterLights;
import adapterAndFacade.facade.Tuner;

public class HomeTheaterFacade {

    Amplifier amp;
    Tuner tuner;
    DvdPlayer dvd;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlayer dvd,
                             CdPlayer cd, Projector projector,
                             TheaterLights lights, Screen screen,
                             PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvdPlayer(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);

    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();

    }

}
