package org.firstinspires.ftc.teamcode.field;

import com.pedropathing.math.Pose;

public class FieldConstants {

    public static final Pose BLUE_TARGET_POSE = new Pose(58, 59, 0);

    public static final Pose RED_TARGET_POSE = new Pose(83, 59, Math.PI);

    public static final Pose GO_TO_POSE_BLUE_TARGET = new Pose(58, 8, Math.toRadians(90));

    public static final double HEADING_TOLERANCE_RAD = Math.toRadians(2.0);

    public static final double MAX_ALIGN_TURN_POWER = 0;
    public static final double ALIGN_kP = 0;
}
