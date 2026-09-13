package org.firstinspires.ftc.teamcode.field;

import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.AtomicPath;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.curves.Line;
import com.pedropathing.paths.interpolator.Interpolator;
import com.seattlesolvers.solverslib.command.SubsystemBase;

public class Field extends SubsystemBase {

    private final Follower follower;

    private boolean active = false;

    public Field(Follower follower) {
        this.follower = follower;
    }

    public void goToPose(Pose target) {
        Pose current = follower.pose();

        Path path = new AtomicPath(new Line(current, target))
                .heading(Interpolator.linear(current.heading(), target.heading()));

        follower.follow(path);
        active = true;
    }

    public void stop() {
        follower.stop();
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public boolean atTarget() {
        return !follower.isBusy();
    }
}
