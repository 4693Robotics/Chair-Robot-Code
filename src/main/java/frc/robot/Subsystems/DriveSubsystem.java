package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    
    private final Talon FrontLeft = new Talon(0);
    private final Talon FrontRight = new Talon(1);
    private final Talon RearRight = new Talon(2);
    private final Talon RearLeft = new Talon(3);

    private DifferentialDrive driveChannel = new DifferentialDrive(FrontLeft, FrontRight);

    public DriveSubsystem() {
        FrontLeft.addFollower(RearLeft);
        FrontRight.addFollower(RearRight);

        FrontLeft.setInverted(true);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("speed m", FrontLeft.get());
    }

    public void drive(double xSpeed, double zRotation, boolean turnInPlace) {
        driveChannel.curvatureDrive(xSpeed, zRotation, turnInPlace);
    }
        
}
