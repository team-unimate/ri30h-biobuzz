package org.firstinspires.ftc.teamcode.commands.umbrella;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.umbrella.Umbrella;

public class UmbrellaCloseCommand extends CommandBase {

    private final Umbrella umbrella;

    public UmbrellaCloseCommand(Umbrella umbrella) {
        this.umbrella = umbrella;
        addRequirements(umbrella);
    }

    @Override
    public void initialize() {
        umbrella.close();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
