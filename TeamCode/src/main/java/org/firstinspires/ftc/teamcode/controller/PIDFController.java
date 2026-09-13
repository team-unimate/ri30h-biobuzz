package org.firstinspires.ftc.teamcode.controller;

import com.qualcomm.robotcore.util.Range;

public class PIDFController {
    private double kP;
    private double kI;
    private double kD;
    private double kF;

    private double setpoint = 0.0;
    private double integralSum = 0.0;
    private double lastError = 0.0;

    private double integralLimit = 1.0;
    private double outputLimit = 1.0;

    private long lastTime = System.nanoTime();

    // Last computed terms, exposed for telemetry/graphing.
    private double lastErrorTerm = 0.0;
    private double lastPTerm = 0.0;
    private double lastITerm = 0.0;
    private double lastDTerm = 0.0;
    private double lastFTerm = 0.0;
    private double lastOutput = 0.0;

    public PIDFController(double kP, double kI, double kD, double kF) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kF = kF;
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public double getSetpoint() {
        return setpoint;
    }

    public void setPID(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public void setF(double kF) {
        this.kF = kF;
    }

    public void setIntegralLimit(double limit) {
        this.integralLimit = Math.abs(limit);
    }

    public void setOutputLimit(double limit) {
        this.outputLimit = Math.abs(limit);
    }

    public void reset() {
        integralSum = 0.0;
        lastError = 0.0;
        lastTime = System.nanoTime();
    }

    public double calculate(double measurement) {
        long now = System.nanoTime();
        double deltaTime = (now - lastTime) / 1e9;
        lastTime = now;

        if (deltaTime <= 0) {
            return lastOutput;
        }

        double error = setpoint - measurement;

        integralSum += error * deltaTime;
        integralSum = Range.clip(integralSum, -integralLimit, integralLimit);

        double derivative = (error - lastError) / deltaTime;
        lastError = error;

        lastErrorTerm = error;
        lastPTerm = kP * error;
        lastITerm = kI * integralSum;
        lastDTerm = kD * derivative;
        lastFTerm = kF * setpoint;

        double output = lastPTerm + lastITerm + lastDTerm + lastFTerm;
        lastOutput = Range.clip(output, -outputLimit, outputLimit);

        return lastOutput;
    }

    public double getLastError() {
        return lastErrorTerm;
    }

    public double getLastPTerm() {
        return lastPTerm;
    }

    public double getLastITerm() {
        return lastITerm;
    }

    public double getLastDTerm() {
        return lastDTerm;
    }

    public double getLastFTerm() {
        return lastFTerm;
    }

    public double getLastOutput() {
        return lastOutput;
    }
}