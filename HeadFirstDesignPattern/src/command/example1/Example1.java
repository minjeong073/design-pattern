package command.example1;

/*
    7개의 소켓을 가진 만능 리모컨
    - 각 소켓마다 on / off 버튼
 */

import java.util.Arrays;

interface Command {
    void execute();
}

class NoCommand implements Command {
    @Override
    public void execute() {}
}

class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "         " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}

class Light {
    String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light on");
    }

    public void off() {
        System.out.println(location + " light off");
    }
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

public class Example1 {
    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.onButtonWasPushed(0);

        System.out.println(remoteControl);
        remoteControl.offButtonWasPushed(0);
    }
}

/*
결과

Living Room light on

------ Remote Control ------
[slot 0] command.example1.LightOnCommand         command.example1.LightOffCommand
[slot 1] command.example1.NoCommand         command.example1.NoCommand
[slot 2] command.example1.NoCommand         command.example1.NoCommand
[slot 3] command.example1.NoCommand         command.example1.NoCommand
[slot 4] command.example1.NoCommand         command.example1.NoCommand
[slot 5] command.example1.NoCommand         command.example1.NoCommand
[slot 6] command.example1.NoCommand         command.example1.NoCommand

Living Room light off
 */



