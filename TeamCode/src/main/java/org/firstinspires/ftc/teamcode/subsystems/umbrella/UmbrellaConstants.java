package org.firstinspires.ftc.teamcode.subsystems.umbrella;

import com.acmerobotics.dashboard.config.Config;

@Config
public class UmbrellaConstants {

    public static final String HM_UMBRELLA_LEFT = "umbrellaLeft";
    public static final String HM_UMBRELLA_RIGHT = "umbrellaRight";

    public static double LEFT_OPEN_POSITION = 0.7;
    public static double LEFT_CLOSED_POSITION = 0;

    public static double RIGHT_OPEN_POSITION = 0;
    public static double RIGHT_CLOSED_POSITION = 0.7;

    public static boolean REVERSE_LEFT = true;
    public static boolean REVERSE_RIGHT = true;

    private UmbrellaConstants() {}
}
