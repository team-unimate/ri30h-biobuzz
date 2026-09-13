package org.firstinspires.ftc.teamcode.subsystems.shooter;

import com.acmerobotics.dashboard.config.Config;

@Config
public class ShooterConstants {

    public static final String HM_FLYWHEEL = "flywheel";

    public static double MOTOR_TICKS_PER_REV = 28;

    public static double SHOOTER_kP = 0;
    public static double SHOOTER_kI = 0;
    public static double SHOOTER_kD = 0;
    public static double SHOOTER_kF = 0;

    public static double TARGET_RPM = 0;

    public static double VELOCITY_TOLERANCE_RPM = 50;

    private ShooterConstants() {}
}
