package org.firstinspires.ftc.teamcode.subsystems.umbrella;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import static org.firstinspires.ftc.teamcode.subsystems.umbrella.UmbrellaConstants.*;

public class Umbrella extends SubsystemBase {

    private final Servo leftServo;
    private final Servo rightServo;

    private boolean open = false;

    public Umbrella(HardwareMap hardwareMap) {
        leftServo = hardwareMap.get(Servo.class, HM_UMBRELLA_LEFT);
        rightServo = hardwareMap.get(Servo.class, HM_UMBRELLA_RIGHT);
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
        leftServo.setDirection(REVERSE_LEFT ? Servo.Direction.REVERSE : Servo.Direction.FORWARD);
        rightServo.setDirection(REVERSE_RIGHT ? Servo.Direction.REVERSE : Servo.Direction.FORWARD);

        double position = getPosition();
        leftServo.setPosition(position);
        rightServo.setPosition(position);
    }
}
