package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.NeutralMode;


public class cascade extends SubsystemBase 
{

  WPI_TalonFX motor = new WPI_TalonFX(Constants.cascadeMotor);
  DigitalInput limitSwitch = new DigitalInput(0);




  public void cascadeMove(double speed)
  {
    motor.set(speed);
  }






  public cascade() 
  {
    
    motor.setNeutralMode(NeutralMode.Brake);

  }

  



  public void cascadeLimit(boolean limitSwitchCheck)
  {

    if(limitSwitch.get())
    {
      motor.setNeutralMode(NeutralMode.Brake);
    }
    else
    {
      motor.set(.2);
    }


  }




public boolean limitSwitch()
  {
    return limitSwitch.get();
  }





  @Override
  public void periodic() 
  {
    SmartDashboard.putBoolean("Limit Switch", limitSwitch());
  }


}
