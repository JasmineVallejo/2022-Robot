
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.aimRobotCommand;
import frc.robot.commands.cascadeCommand;
import frc.robot.commands.encoderMove;
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
  private final shooterCommand shooter90 = new shooterCommand(shooterSub, .9 *Constants.shooterSpeed);
  private final shooterCommand shooter80 = new shooterCommand(shooterSub, .8 *Constants.shooterSpeed);
  private final shooterCommand shooter70 = new shooterCommand(shooterSub, .7 *Constants.shooterSpeed);
  private final shooterCommand shooter60 = new shooterCommand(shooterSub, .5 *Constants.shooterSpeed);



  private final cascadeCommand cascadeMoveUp = new cascadeCommand( cascadeSub, Constants.cascadeSpeed);
  private final cascadeCommand cascadeMoveDown = new cascadeCommand(cascadeSub, -1 * Constants.cascadeSpeed);
  private final indexerCommand indexerIn = new indexerCommand(indexerSub, Constants.indexerSpeed);
  private final indexerCommand indexerOut = new indexerCommand(indexerSub, -.5 * Constants.indexerSpeed);
  private final rotaryArmsCommand rotateForward = new rotaryArmsCommand(rotarySub, Constants.rotaryArmSpeed);
  private final rotaryArmsCommand rotateBackward = new rotaryArmsCommand(rotarySub, -1 * Constants.rotaryArmSpeed);

  private final aimRobotCommand aimRobot = new aimRobotCommand(driveSub, Constants.targetDistance);
  private final encoderMove encoderMove = new encoderMove(driveSub, 3);

  Joystick jasmine = new Joystick(Constants.jasmine);
  Joystick ish = new Joystick(Constants.ish);


  RunCommand move2 = new RunCommand(() -> driveSub.move(Constants.driveSpeed*ish.getRawAxis(1),
  Constants.driveSpeed*ish.getRawAxis(5)),driveSub);

 RunCommand move = new RunCommand(() -> driveSub.move(Constants.driveSpeed*jasmine.getRawAxis(Constants.leftDriveAxis),
  Constants.driveSpeed*jasmine.getRawAxis(Constants.rightDriveAxis)),driveSub);

  /*
  RunCommand moverotateFoward = new RunCommand(() -> rotarySub.rotateArms(Constants.rotaryArmSpeed*jasmine.getRawAxis(3)));
  RunCommand moverotateBackward = new RunCommand(() -> rotarySub.rotateArms(-1 * Constants.rotaryArmSpeed*jasmine.getRawAxis(2)));*/

  public RobotContainer() 
  {
   // driveSub.setDefaultCommand(move);
    driveSub.setDefaultCommand(move2);
    
    JoystickButton shooter = new JoystickButton(jasmine, Constants.shooterButton);
    shooter.whileHeld(shooterMove);
    /*JoystickButton shooter2 = new JoystickButton(ish, Constants.shooterButton2);
    shooter2.whileHeld(shooterMove);*/

    /*JoystickButton shooter9 = new JoystickButton(ish, Constants.shooter9);
    shooter9.whileHeld(shooter90);

    JoystickButton shooter8 = new JoystickButton(ish, Constants.shooter8);
    shooter8.whileHeld(shooter80);

    JoystickButton shooter7 = new JoystickButton(ish, Constants.shooter7);
    shooter7.whileHeld(shooter70);

    JoystickButton shooter6 = new JoystickButton(ish, Constants.shooter6);
    shooter6.whileHeld(shooter60);
*/

    JoystickButton cascadeUp = new JoystickButton(jasmine, Constants.cascadeUpButton);
    cascadeUp.whileHeld(cascadeMoveUp);
    JoystickButton cascadeUp2 = new JoystickButton(ish, Constants.cascadeUpButton2);
    cascadeUp2.whileHeld(cascadeMoveUp);



    JoystickButton cascadeDown = new JoystickButton(jasmine,Constants.cascadeDownButton);
    cascadeDown.whileHeld(cascadeMoveDown);
    JoystickButton cascadeDown2 = new JoystickButton(ish,Constants.cascadeDownButton2);
   // cascadeDown2.whileHeld(cascadeMoveDown);



    JoystickButton indexerI = new JoystickButton(jasmine, Constants.IndexerInButton);
    indexerI.whileHeld(indexerIn);
    JoystickButton indexerI2 = new JoystickButton(ish, Constants.IndexerInButton);
    indexerI2.whileHeld(indexerIn);

    
    JoystickButton indexerO = new JoystickButton(jasmine, Constants.IndexerOutButton);
    indexerO.whileHeld(indexerOut);
    JoystickButton indexer2O = new JoystickButton(ish, Constants.IndexerOut2Button);
    indexer2O.whileHeld(indexerOut);
    

    JoystickButton rotaryForward = new JoystickButton(jasmine, Constants.rotaryForwardButton);
    rotaryForward.whileHeld(rotateForward);
    JoystickButton rotaryForward2 = new JoystickButton(ish, Constants.rotaryForwardButton2);
    rotaryForward2.whileHeld(rotateForward);


    JoystickButton rotaryBackward = new JoystickButton(jasmine, Constants.rotaryBackwardButton);
    rotaryBackward.whileHeld(rotateBackward);
    JoystickButton rotaryBackward2 = new JoystickButton(ish, Constants.rotaryBackwardButton2);
    rotaryBackward2.whileHeld(rotateBackward);


    JoystickButton aimingRobot = new JoystickButton(jasmine, Constants.aimRobotButton);
    aimingRobot.whileHeld(aimRobot);
    JoystickButton aimingRobot2 = new JoystickButton(ish, Constants.aimRobotButton2);
    aimingRobot2.whileHeld(aimRobot);  


    configureButtonBindings();

  }

 
  private void configureButtonBindings() {}

 
  public Command getAutonomousCommand() {
    return encoderMove;
  }
}
