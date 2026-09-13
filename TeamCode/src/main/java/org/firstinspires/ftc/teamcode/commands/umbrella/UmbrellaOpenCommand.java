package org.firstinspires.ftc.teamcode.commands.umbrella;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.umbrella.Umbrella;

public class UmbrellaOpenCommand extends CommandBase {

    private final Umbrella umbrella;

    public UmbrellaOpenCommand(Umbrella umbrella) {
        this.umbrella = umbrella;
        addRequirements(umbrella);
    }

    @Override
    public void initialize() {
        umbrella.open();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
