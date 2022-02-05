
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

public class RobotContainer 
{

  private final shooter shooterSub = new shooter();
  private final drive driveSub = new drive();
  private final cascade cascadeSub = new cascade();
  private final indexer indexerSub = new indexer();
  private final rotaryArms rotarySub = new rotaryArms();

  private final shooterCommand shooterMove = new shooterCommand(shooterSub, Constants.shooterSpeed);
  private final cascadeCommand cascadeMoveUp = new cascadeCommand( cascadeSub, Constants.cascadeSpeed);
  private final cascadeCommand cascadeMoveDown = new cascadeCommand(cascadeSub, -1 * Constants.cascadeSpeed);
  private final indexerCommand indexerIn = new indexerCommand(indexerSub, Constants.indexerSpeed);
  private final indexerCommand indexerOut = new indexerCommand(indexerSub, -1 * Constants.indexerSpeed);
  private final rotaryArmsCommand rotateForward = new rotaryArmsCommand(rotarySub, Constants.rotaryArmSpeed);
  private final rotaryArmsCommand rotateBackward = new rotaryArmsCommand(rotarySub, -1 * Constants.rotaryArmSpeed);

  Joystick jasmine = new Joystick(0);

  RunCommand move = new RunCommand(() -> driveSub.move(Constants.driveSpeed*jasmine.getRawAxis(1),
  Constants.driveSpeed*jasmine.getRawAxis(5)),driveSub);
  
  /*
  RunCommand moverotateFoward = new RunCommand(() -> rotarySub.rotateArms(Constants.rotaryArmSpeed*jasmine.getRawAxis(3)));
  RunCommand moverotateBackward = new RunCommand(() -> rotarySub.rotateArms(-1 * Constants.rotaryArmSpeed*jasmine.getRawAxis(2)));*/

  public RobotContainer() 
  {
    driveSub.setDefaultCommand(move);

    JoystickButton shooter = new JoystickButton(jasmine, 6);
    shooter.whileHeld(shooterMove);

    JoystickButton cascadeUp = new JoystickButton(jasmine, 4);
    cascadeUp.whileHeld(cascadeMoveUp);
    JoystickButton cascadeDown = new JoystickButton(jasmine,3);
    cascadeDown.whileHeld(cascadeMoveDown);

    JoystickButton indexerI = new JoystickButton(jasmine, 5);
    indexerI.whileHeld(indexerIn);
    JoystickButton indexerO = new JoystickButton(jasmine, 7);
    indexerO.whileHeld(indexerOut);
    

    JoystickButton rotaryForward = new JoystickButton(jasmine, 1);
    rotaryForward.whileHeld(rotateForward);

    JoystickButton rotaryBackward = new JoystickButton(jasmine, 2);
    rotaryBackward.whileHeld(rotateBackward);
    configureButtonBindings();

  }

 
  private void configureButtonBindings() {}

 
  public Command getAutonomousCommand() {
    return null;
  }
}
