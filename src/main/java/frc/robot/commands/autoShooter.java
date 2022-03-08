package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.shooter;




public class autoShooter extends CommandBase 
{



  shooter shooterSub;
  double error, oldError, proportion, integral, derivative, pastTime;



  public autoShooter(shooter shooter) 
  {
    shooterSub = shooter;
  }

  





  @Override
  public void initialize() 
  {

  }

  



  @Override
  public void execute() 
  {

    error = shooterSub.getRPM() - shooterSub.currentRPM();
    proportion = error * Constants.shooterKP;
    double totalVoltage = proportion + shooterSub.aimFeedForward(shooterSub.getRPM());
    shooterSub.voltageMove(totalVoltage);    

  }

  

  @Override
  public void end(boolean interrupted) 
  {

  }

  




  @Override
  public boolean isFinished() 
  {
    return false;
  }



}
