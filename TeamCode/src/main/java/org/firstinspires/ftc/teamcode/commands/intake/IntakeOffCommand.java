package org.firstinspires.ftc.teamcode.commands.intake;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;

public class IntakeOffCommand extends CommandBase {

    private final Intake intake;

    public IntakeOffCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.off();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
