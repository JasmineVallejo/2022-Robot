package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class cascade extends SubsystemBase {
  WPI_TalonFX motor = new WPI_TalonFX(Constants.cascadeMotor);

  public void cascadeMove(double speed){
    motor.set(speed);
  }
  public cascade() {}

  @Override
  public void periodic() {}
}
