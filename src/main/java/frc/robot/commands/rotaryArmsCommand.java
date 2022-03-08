package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.rotaryArms;





public class rotaryArmsCommand extends CommandBase 
{



  rotaryArms rotaryArmsSub;
  double speed;





  public rotaryArmsCommand(rotaryArms rotaryArms, double rotaryArmsSpeed) 
  {

    speed = rotaryArmsSpeed;
    rotaryArmsSub = rotaryArms;
    addRequirements(rotaryArmsSub);

  }





  @Override
  public void initialize() 
  {

  }

  




  @Override
  public void execute() 
  {
    rotaryArmsSub.rotateArms(speed);
  }

  



  @Override
  public void end(boolean interrupted) 
  {
    rotaryArmsSub.rotateArms(0);
  }

  


  @Override
  public boolean isFinished() 
  {
    return false;
  }

  
}
