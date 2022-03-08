package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.drive;



public class encoderMove extends CommandBase 
{


  drive driveSub;
  double errorDistance, proportionDistance, td, integralDistance, derivativeDistance, oldErrorDistance,
  pastTime, speed;





  public encoderMove(drive drive, double targetDistance) 
  {
    driveSub = drive;
    td= targetDistance;
    addRequirements(driveSub);
  }

  




  @Override
  public void initialize() 
  {
    oldErrorDistance = 0;
    integralDistance = 0;
    pastTime = Timer.getFPGATimestamp();
    driveSub.resetEncoders();
  }






  @Override
  public void execute() 
  {

    errorDistance = (td -  driveSub.encoderCurrentDistance()) * -1;
  proportionDistance = (errorDistance ) * Constants.distanceKP;



  double dt = Timer.getFPGATimestamp() - pastTime;
  pastTime = Timer.getFPGATimestamp();



  integralDistance += (errorDistance * dt) * Constants.distanceKI;
  double dxDistance = errorDistance - oldErrorDistance;
  derivativeDistance = (dxDistance / dt) * Constants.distanceKD;
  oldErrorDistance = errorDistance;




  speed = proportionDistance + integralDistance + derivativeDistance;



  
  SmartDashboard.putNumber("encoderDistance", driveSub.encoderCurrentDistance());
  SmartDashboard.putNumber("encoderSpeed", speed);



  driveSub.move(speed, speed);

  }

  



  @Override
  public void end(boolean interrupted) 
  {
    driveSub.move(0, 0);
  }



 
  @Override
  public boolean isFinished() {
    return false;
  }
}
