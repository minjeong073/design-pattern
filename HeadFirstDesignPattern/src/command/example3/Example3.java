package command.example3;

/*
    7개의 소켓을 가진 만능 리모컨
    - 각 소켓마다 on / off 버튼
    - global undo 버튼
    + 모드가 여러개 있는 디바이스 지원 (e.g. 선풍기 강풍/약풍/미풍/중지)
 */

interface Command {
    void execute();
    void undo();
}

class NoCommand implements Command {
    @Override
    public void execute() {}

    @Override
    public void undo() {}
}

class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {     // ++
        undoCommand.undo();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "         " + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
        return stringBuff.toString();
    }
}

class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    public void high() {
        System.out.println(location + " fan to high");
        speed = HIGH;
    }

    public void medium() {
        System.out.println(location + " fan to medium");
        speed = MEDIUM;
    }

    public void low() {
        System.out.println(location + " fan to low");
        speed = LOW;
    }

    public void off() {
        System.out.println(location + " fan off");
        speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }

}

class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed = CeilingFan.OFF;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}

class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed = CeilingFan.OFF;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}

public class Example3 {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        CeilingFan ceilingFan = new CeilingFan("Living Room");
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);

        remoteControl.setCommand(0, ceilingFanHigh, ceilingFanOff);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }
}

/*
결과

Living Room fan to high
Living Room fan off

------ Remote Control ------
[slot 0] command.example3.CeilingFanHighCommand         command.example3.CeilingFanOffCommand
[slot 1] command.example3.NoCommand         command.example3.NoCommand
[slot 2] command.example3.NoCommand         command.example3.NoCommand
[slot 3] command.example3.NoCommand         command.example3.NoCommand
[slot 4] command.example3.NoCommand         command.example3.NoCommand
[slot 5] command.example3.NoCommand         command.example3.NoCommand
[slot 6] command.example3.NoCommand         command.example3.NoCommand
[undo] command.example3.CeilingFanOffCommand

Living Room fan to high
 */
