package org.firstinspires.ftc.teamcode.commands.gate;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.gate.Gate;

public class GateOpenCommand extends CommandBase {

    private final Gate gate;

    public GateOpenCommand(Gate gate) {
        this.gate = gate;
        addRequirements(gate);
    }

    @Override
    public void initialize() {
        gate.open();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
