package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

/**
 * DriveForwardCommand
 */
public class DriveForwardCommand extends CommandBase {

private double speed;
private int timeSeconds;
private Timer timer = new Timer();
private DriveTrainSubsystem driveTrainSubsystem;
public DriveForwardCommand(double speed, int timeSeconds, DriveTrainSubsystem driveTrainSubsystem) {
    this.speed = speed;
    this.timeSeconds = timeSeconds;
    addRequirements(driveTrainSubsystem);
}
    
    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        driveTrainSubsystem.drive(0, speed, 0);
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= timeSeconds;
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
        timer.reset();
        driveTrainSubsystem.drive(0, 0, 0);
    }
}