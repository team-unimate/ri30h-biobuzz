package org.firstinspires.ftc.teamcode.subsystems.shooter;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.controller.PIDFController;

import static org.firstinspires.ftc.teamcode.subsystems.shooter.ShooterConstants.*;

public class Shooter extends SubsystemBase {

    private final DcMotorEx flywheel;
    private final PIDFController pidf;
    private final Telemetry telemetry;

    public Shooter(HardwareMap hardwareMap) {
        this.telemetry = FtcDashboard.getInstance().getTelemetry();

        flywheel = hardwareMap.get(DcMotorEx.class, HM_FLYWHEEL);
        flywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        flywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        pidf = new PIDFController(SHOOTER_kP, SHOOTER_kI, SHOOTER_kD, SHOOTER_kF);
        pidf.setOutputLimit(1.0);
    }

    public double getRPM() {
        return (flywheel.getVelocity() / MOTOR_TICKS_PER_REV) * 60.0;
    }

    public void stop() {
        flywheel.setPower(0.0);
        pidf.reset();
    }

    public boolean atTargetRPM() {
        return Math.abs(getRPM() - TARGET_RPM) < VELOCITY_TOLERANCE_RPM;
    }

    @Override
    public void periodic() {
        pidf.setPID(SHOOTER_kP, SHOOTER_kI, SHOOTER_kD);
        pidf.setF(SHOOTER_kF);
        pidf.setSetpoint(TARGET_RPM);

        double power = pidf.calculate(getRPM());
        flywheel.setPower(power);

        telemetry.addData("[Shooter] target (rpm)",  TARGET_RPM);
        telemetry.addData("[Shooter] current (rpm)", getRPM());
        telemetry.addData("[Shooter] error (rpm)",   pidf.getLastError());
        telemetry.addData("[Shooter] at target",     atTargetRPM());
        telemetry.addData("[Shooter] output power",  power);
        telemetry.addData("[Shooter] P term",        pidf.getLastPTerm());
        telemetry.addData("[Shooter] I term",        pidf.getLastITerm());
        telemetry.addData("[Shooter] D term",        pidf.getLastDTerm());
        telemetry.addData("[Shooter] F term",        pidf.getLastFTerm());
        telemetry.update();
    }
}
