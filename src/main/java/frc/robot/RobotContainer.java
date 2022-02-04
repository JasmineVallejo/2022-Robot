
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.cascadeCommand;
import frc.robot.commands.indexerCommand;
import frc.robot.commands.rotaryArmsCommand;
import frc.robot.commands.shooterCommand;
import frc.robot.subsystems.cascade;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.indexer;
import frc.robot.subsystems.rotaryArms;
import frc.robot.subsystems.shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final shooter shooterSub = new shooter();
  private final drive driveSub = new drive();
  private final cascade cascadeSub = new cascade();
  private final indexer indexerSub = new indexer();
  private final rotaryArms rotarySub = new rotaryArms();

  private final shooterCommand shooterMove = new shooterCommand(shooterSub, Constants.shooterSpeed);
  private final cascadeCommand cascadeMoveUp = new cascadeCommand( cascadeSub, Constants.cascadeSpeed);
  private final cascadeCommand cascadeMoveDown = new cascadeCommand(cascadeSub, -1 * Constants.cascadeSpeed);
  private final indexerCommand indexerMove = new indexerCommand(indexerSub, Constants.indexerSpeed);
  private final rotaryArmsCommand rotateForward = new rotaryArmsCommand(rotarySub, Constants.rotaryArmSpeed);
  private final rotaryArmsCommand rotateBackward = new rotaryArmsCommand(rotarySub, -1 * Constants.rotaryArmSpeed);

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

    JoystickButton indexer = new JoystickButton(jasmine, 4);
    indexer.whenPressed(indexerMove);

    JoystickButton rotaryForward = new JoystickButton(jasmine, 5);
    rotaryForward.whenPressed(rotateForward);

    JoystickButton rotaryBackward = new JoystickButton(jasmine, 6);
    rotaryBackward.whenPressed(rotateBackward);
    configureButtonBindings();

  }

 
  private void configureButtonBindings() {}

 
  public Command getAutonomousCommand() {
    return null;
  }
}
