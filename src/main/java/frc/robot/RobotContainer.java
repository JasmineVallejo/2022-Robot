
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
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;




public class RobotContainer 
{

  private final shooter shooterSub = new shooter();
  private final drive driveSub = new drive();
  private final cascade cascadeSub = new cascade();
  private final indexer indexerSub = new indexer();
  private final rotaryArms rotarySub = new rotaryArms();

  //DigitalInput limitSwitch  = new DigitalInput(0);



  private final shooterCommand shooterMax = new shooterCommand(shooterSub, Constants.shooterMaxSpeed);
  private final shooterCommand shooterReverse = new shooterCommand(shooterSub, Constants.shooterRevSpeed);
  private final shooterCommand shooterFar = new shooterCommand(shooterSub, Constants.shooterFarSpeed);
  private final shooterCommand shooterMid = new shooterCommand(shooterSub, Constants.shooterMidSpeed);
  private final shooterCommand shooterClose = new shooterCommand(shooterSub, Constants.shooterCloseSpeed);


  
  private final cascadeCommand cascadeMoveUp = new cascadeCommand( cascadeSub, Constants.cascadeUpSpeed);
  private final cascadeCommand cascadeMoveDown = new cascadeCommand(cascadeSub, Constants.cascadeDownSpeed);



  private final indexerCommand indexerInMax = new indexerCommand(indexerSub, Constants.indexerSpeedMax);
  private final indexerCommand indexerIn = new indexerCommand(indexerSub, Constants.indexerInSpeed);
  private final indexerCommand indexerOut = new indexerCommand(indexerSub, Constants.indexerOutSpeed);


  private final rotaryArmsCommand rotateForward = new rotaryArmsCommand(rotarySub, Constants.rotaryArmFowardSpeed);
  private final rotaryArmsCommand rotateBackward = new rotaryArmsCommand(rotarySub, Constants.rotaryArmBackwardSpeed);


  //private final aimRobotCommand aimRobot = new aimRobotCommand(driveSub, Constants.targetDistance);





  Joystick nathan = new Joystick(Constants.nathan);
  Joystick gio = new Joystick(Constants.gio);




  RunCommand gioMove = new RunCommand(() -> driveSub.move
  (Constants.driveSpeed*gio.getRawAxis(1),
  Constants.driveSpeed*gio.getRawAxis(5)),driveSub);



  /*RunCommand nathanMove = new RunCommand(() -> driveSub.move
  (Constants.driveSpeed*nathan.getRawAxis(Constants.leftDriveAxis),
  Constants.driveSpeed*nathan.getRawAxis(Constants.rightDriveAxis)),driveSub);
  */


  public RobotContainer() 
  {

    
                          ////////////    Drive Controls      ///////////////

    //driveSub.setDefaultCommand(nathanMove);




                        //////////////     Cascade Controls    ////////////////

    JoystickButton cascadeUp = new JoystickButton(nathan, Constants.cascadeUpButton);
    cascadeUp.whileHeld(cascadeMoveUp);
   
    JoystickButton cascadeDown = new JoystickButton(nathan,Constants.cascadeDownButton);
    cascadeDown.whileHeld(cascadeMoveDown);



    


                        //////////////      Rotary Arms Controls    /////////////////

    JoystickButton rotaryForward = new JoystickButton(nathan, Constants.rotaryForwardButton);
    rotaryForward.whileHeld(rotateForward);

    JoystickButton rotaryBackward = new JoystickButton(nathan, Constants.rotaryBackwardButton);
    rotaryBackward.whileHeld(rotateBackward);
    
    






    ////////////////////////////////////////////////   Gio Controls     ////////////////////////////////////////////////////////



                                  /////////////////    Drive Controls      /////////////////////
                                  
    driveSub.setDefaultCommand(gioMove);
    
   
    

                                  ////////////////    Shooter Controls      ////////////////////

    JoystickButton shooterRev2 = new JoystickButton(gio, Constants.shooterRev);
    shooterRev2.whileHeld(shooterReverse);
    
    JoystickButton shooterMaxGio = new JoystickButton(gio, Constants.shooterMax);
    shooterMaxGio.whileHeld(shooterMax);

    JoystickButton shooterFarGio = new JoystickButton(gio, Constants.shooterFar);
    shooterFarGio.whileHeld(shooterFar);

    JoystickButton shooterMidGio = new JoystickButton(gio, Constants.shooterMid);
    shooterMidGio.whileHeld(shooterMid);

    JoystickButton shooterCloseGio = new JoystickButton(gio, Constants.shooterClose);
    shooterCloseGio.whileHeld(shooterClose);


    
    
                                //////////////      Indexer  Controls     ///////////////////////

    JoystickButton indexerInGio = new JoystickButton(gio, Constants.IndexerInGio);
    indexerInGio.whileHeld(indexerIn);

    JoystickButton indexerMaxGio = new JoystickButton(gio, Constants.IndexerInMaxGio);
    indexerMaxGio.whileHeld(indexerInMax);

    JoystickButton indexerOutGio = new JoystickButton(gio, Constants.IndexerOutGio);
    indexerOutGio.whileHeld(indexerOut);
    

    configureButtonBindings();

  }

 
  private void configureButtonBindings() 
  {
    
  }

 
  public Command getAutonomousCommand() 
  {

    ParallelCommandGroup flywheel = new ParallelCommandGroup(new shooterCommand(shooterSub, -.5).withTimeout(2),
    new indexerCommand(indexerSub, Constants.indexerInSpeed).withTimeout(2));


    SequentialCommandGroup shooting = new SequentialCommandGroup(new shooterCommand(shooterSub, -.5).withTimeout(1.5), flywheel.withTimeout(3));
    
    SequentialCommandGroup auto = new SequentialCommandGroup(shooting, new WaitCommand(.1), new encoderMove(driveSub, (Constants.tarmacDistance+.15)));
    return auto;


  }
}
