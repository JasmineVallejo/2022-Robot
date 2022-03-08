package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter;




public class shooterCommand extends CommandBase 
{

  double speed;
  shooter shooterSub;




  public shooterCommand(shooter shooter, double shooterSpeed) 
  {
    shooterSub = shooter;
    speed = shooterSpeed;
    addRequirements(shooter);
  }



  


  @Override
  public void initialize() 
  {

  }





  @Override
  public void execute() 
  {
    shooterSub.move(speed);
  }






  @Override
  public void end(boolean interrupted) 
  {
    shooterSub.move(0);
  }






  @Override
  public boolean isFinished() 
  {
    return false;
  }



}
