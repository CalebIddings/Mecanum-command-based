package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * DriveTrainSubsystem
 */
public class DriveTrainSubsystem extends SubsystemBase {
    private final WPI_TalonSRX leftFront = new WPI_TalonSRX(0);
    private final WPI_TalonSRX leftBack= new WPI_TalonSRX(0);
    private final WPI_TalonSRX rightFront = new WPI_TalonSRX(0);
    private final WPI_TalonSRX rightBack = new WPI_TalonSRX(0);
    
    private final MecanumDrive driveTrain = new MecanumDrive(leftFront, leftBack, rightFront, rightBack);
    public DriveTrainSubsystem() {
        leftFront.configFactoryDefault();
        leftBack.configFactoryDefault();
        rightFront.configFactoryDefault();
        rightBack.configFactoryDefault();
        leftFront.setNeutralMode(NeutralMode.Brake);
        leftBack.setNeutralMode(NeutralMode.Brake);
        rightFront.setNeutralMode(NeutralMode.Brake);
        rightBack.setNeutralMode(NeutralMode.Brake);
    }

    public void drive(double strafe, double speed, double rotation) {
        driveTrain.driveCartesian(strafe, speed, rotation);
    }

    
}