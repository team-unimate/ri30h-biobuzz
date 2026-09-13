package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import static org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants.*;

public class Intake extends SubsystemBase {

    private final DcMotor motor;

    private boolean running = false;

    public Intake(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, HM_INTAKE);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void on() {
        running = true;
        motor.setPower(INTAKE_POWER);
    }

    public void off() {
        running = false;
        motor.setPower(0.0);
    }

    public boolean isRunning() {
        return running;
    }
}
