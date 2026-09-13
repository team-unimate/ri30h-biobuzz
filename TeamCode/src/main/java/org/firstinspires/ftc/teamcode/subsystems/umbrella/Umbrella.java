package org.firstinspires.ftc.teamcode.subsystems.umbrella;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.TauraServo;

import static org.firstinspires.ftc.teamcode.subsystems.umbrella.UmbrellaConstants.*;


public class Umbrella extends SubsystemBase {

    private final TauraServo leftServo;
    private final TauraServo rightServo;
    private final Telemetry telemetry;

    private boolean open = false;

    public Umbrella(HardwareMap hardwareMap) {
        this.telemetry = FtcDashboard.getInstance().getTelemetry();

        leftServo = new TauraServo(hardwareMap.get(Servo.class, HM_UMBRELLA_LEFT));
        rightServo = new TauraServo(hardwareMap.get(Servo.class, HM_UMBRELLA_RIGHT));
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

    public double getLeftPosition() {
        return open ? LEFT_OPEN_POSITION : LEFT_CLOSED_POSITION;
    }

    public double getRightPosition() {
        return open ? RIGHT_OPEN_POSITION : RIGHT_CLOSED_POSITION;
    }

    @Override
    public void periodic() {
        leftServo.setDirection(REVERSE_LEFT ? Servo.Direction.REVERSE : Servo.Direction.FORWARD);
        rightServo.setDirection(REVERSE_RIGHT ? Servo.Direction.REVERSE : Servo.Direction.FORWARD);

        double leftPosition = getLeftPosition();
        double rightPosition = getRightPosition();

        leftServo.setPosition(leftPosition);
        rightServo.setPosition(rightPosition);

        telemetry.addData("[Umbrella] open",           open);
        telemetry.addData("[Umbrella] left position",  leftPosition);
        telemetry.addData("[Umbrella] right position", rightPosition);
        telemetry.update();
    }
}
