
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.cascadeCommand;
import frc.robot.commands.shooterCommand;
import frc.robot.subsystems.cascade;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final shooter shooterSub = new shooter();
  private final drive driveSub = new drive();
  private final cascade cascadeSub = new cascade();

  private final shooterCommand shooterMove = new shooterCommand(shooterSub, Constants.shooterSpeed);
  private final cascadeCommand cascadeMoveUp = new cascadeCommand( cascadeSub, Constants.cascadeSpeed);
  private final cascadeCommand cascadeMoveDown = new cascadeCommand(cascadeSub, -1 * Constants.cascadeSpeed);

  Joystick jasmine = new Joystick(0);

  RunCommand move = new RunCommand(() -> driveSub.move(Constants.driveSpeed*jasmine.getRawAxis(1),
  Constants.driveSpeed*jasmine.getRawAxis(5)),driveSub);

  public RobotContainer() {

    JoystickButton shooter = new JoystickButton(jasmine, 1);
    shooter.whenPressed(shooterMove);

    JoystickButton cascadeUp = new JoystickButton(jasmine, 2);
    cascadeUp.whenPressed(cascadeMoveUp);
    JoystickButton cascadeDown = new JoystickButton(jasmine,3);
    cascadeDown.whenPressed(cascadeMoveDown);
    configureButtonBindings();
  }

 
  private void configureButtonBindings() {}

 
  public Command getAutonomousCommand() {
    return null;
  }
}
