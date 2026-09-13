package org.firstinspires.ftc.teamcode.subsystems.gate;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import static org.firstinspires.ftc.teamcode.subsystems.gate.GateConstants.*;

public class Gate extends SubsystemBase {

    private final Servo servo;

    private boolean open = false;

    public Gate(HardwareMap hardwareMap) {
        servo = hardwareMap.get(Servo.class, HM_GATE);
    }
    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public double getPosition() {
        return open ? OPEN_POSITION : CLOSED_POSITION;
    }

    @Override
    public void periodic() {
        servo.setDirection(REVERSE_GATE ? Servo.Direction.REVERSE : Servo.Direction.FORWARD);
        servo.setPosition(getPosition());
    }
}
