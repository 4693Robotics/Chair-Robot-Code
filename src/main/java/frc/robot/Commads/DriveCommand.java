package frc.robot.Commads;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveSubsystem;

public class DriveCommand extends Command {

    private DriveSubsystem drive;

    private XboxController controller; 

    private double Thang;
    
    public DriveCommand(DriveSubsystem robotDrive, XboxController driveController) {
        this.drive = robotDrive;

        this.controller = driveController;

        addRequirements(robotDrive);
    }

    @Override
    public void initialize() {
        drive.drive(0, 0, false);

        Thang = 0.4;
    }

    @Override
    public void execute() {

        if (controller.getRawButton(6)) {
            Thang = 1;
        } else {
            Thang = 0.4;
        }

        SmartDashboard.putNumber("the number", Thang);

        drive.drive((controller.getLeftY()) * Thang, controller.getRawAxis(2), false);
    }

    @Override
    public void end(boolean interrupted) {
        drive.drive(0, 0, false);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
