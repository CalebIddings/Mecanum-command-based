package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

/**
 * TeleDrive
 */
public class TeleDrive extends CommandBase{

    private XboxController controller;
    private DriveTrainSubsystem driveTrainSubsystem;
    public TeleDrive(XboxController controller, DriveTrainSubsystem driveTrainSubsystem) {
        this.controller = controller;
        this.driveTrainSubsystem = driveTrainSubsystem;
        addRequirements(driveTrainSubsystem);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        driveTrainSubsystem.drive(controller.getX(Hand.kLeft), -controller.getY(Hand.kLeft), controller.getX(Hand.kRight));
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
       driveTrainSubsystem.drive(0, 0, 0);
    }
}