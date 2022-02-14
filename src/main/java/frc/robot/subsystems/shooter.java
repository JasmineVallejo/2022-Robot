package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shooter extends SubsystemBase {
  WPI_TalonFX motor = new WPI_TalonFX(Constants.shooterMotor);
  SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(0.4366, 0.11648, 0.014644);
  double conversionToRPM = .29296875, distanceToTarget, m = 0, b = 0;

  public void move(double speed){
    motor.set(speed);
  }

  public shooter() {
    motor.setNeutralMode(NeutralMode.Coast);
  }

  public double currentRPM(){
    return (motor.getSelectedSensorVelocity() * conversionToRPM);
  }


  public double aimFeedForward(double targetVelocity){
    return feedforward.calculate(targetVelocity / conversionToRPM);
  }

  @Override
  public void periodic() {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry ty = table.getEntry("ty");
  double y = ty.getDouble(0.0);
  double heightFromTarget = Constants.hubHeight - Constants.limelightHeight;
  double theta = Math.toRadians(Constants.bottomAngle + y);
  distanceToTarget = heightFromTarget / (Math.tan(theta));
  SmartDashboard.putNumber("currentRPM",currentRPM());
  }

  public double getRPM(){
    return (m  * distanceToTarget + b);
  } 

  public void voltageMove(double voltage){
    motor.setVoltage(voltage);
  }
}
