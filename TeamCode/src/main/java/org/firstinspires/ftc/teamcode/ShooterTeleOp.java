package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.gate.GateCloseCommand;
import org.firstinspires.ftc.teamcode.commands.gate.GateOpenCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeOffCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeOnCommand;
import org.firstinspires.ftc.teamcode.commands.umbrella.UmbrellaCloseCommand;
import org.firstinspires.ftc.teamcode.commands.umbrella.UmbrellaOpenCommand;
import org.firstinspires.ftc.teamcode.subsystems.gate.Gate;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.shooter.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.umbrella.Umbrella;


@TeleOp(name = "Shooter Test")
public class ShooterTeleOp extends CommandOpMode {

    private Shooter shooter;
    private Intake intake;
    private Umbrella umbrella;
    private Gate gate;
    private GamepadEx gamepadEx1;

    @Override
    public void initialize() {
        shooter = new Shooter(hardwareMap);
        intake = new Intake(hardwareMap);
        umbrella = new Umbrella(hardwareMap);
        gate = new Gate(hardwareMap);
        gamepadEx1 = new GamepadEx(gamepad1);

        gamepadEx1.getGamepadButton(GamepadKeys.Button.A)
                .whenActive(new IntakeOnCommand(intake))
                .whenInactive(new IntakeOffCommand(intake));

        gamepadEx1.getGamepadButton(GamepadKeys.Button.B)
                .whenActive(new UmbrellaOpenCommand(umbrella))
                .whenInactive(new UmbrellaCloseCommand(umbrella));

        gamepadEx1.getGamepadButton(GamepadKeys.Button.X)
                .whenActive(new GateOpenCommand(gate))
                .whenInactive(new GateCloseCommand(gate));

        register(shooter, intake, umbrella, gate);
    }

    @Override
    public void run() {
        super.run();
    }
}
