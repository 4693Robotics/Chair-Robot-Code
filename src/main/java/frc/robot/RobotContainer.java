package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import frc.robot.Commads.DriveCommand;
import frc.robot.Subsystems.DriveSubsystem;

public class RobotContainer {

    private final DriveSubsystem m_robotDrive = new DriveSubsystem();

    private XboxController m_MainController = new XboxController(0);

    private ShuffleboardTab configTab = Shuffleboard.getTab("Cheese");

    private boolean TheNickThing;

    SimpleWidget controllerBoolean = configTab.add("Controler Type Toggle", TheNickThing)
            .withWidget(BuiltInWidgets.kToggleButton);

    
    public RobotContainer() {
        setDefaultCommands();

        setControls();
    }

    public void periodic() {
        TheNickThing = controllerBoolean.getEntry().getBoolean(TheNickThing);
    }

    private void setDefaultCommands() {
        m_robotDrive.setDefaultCommand(new DriveCommand(m_robotDrive, m_MainController));
    }

    private void setControls() {

    }

}
