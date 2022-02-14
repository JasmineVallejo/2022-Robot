package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class drive extends SubsystemBase {

  WPI_TalonFX rightFront = new WPI_TalonFX(Constants.rightFront);
  WPI_TalonFX rightRear = new WPI_TalonFX(Constants.rightRear);
  WPI_TalonFX leftFront = new WPI_TalonFX(Constants.leftFront);
  WPI_TalonFX leftRear = new WPI_TalonFX(Constants.leftRear);


  MotorControllerGroup rightDrive = new MotorControllerGroup(rightFront, rightRear);
  MotorControllerGroup leftDrive = new MotorControllerGroup(leftFront, leftRear);

  DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);

  public void move(double leftSpeed,double rightSpeed){
    drive.tankDrive( -1 *leftSpeed,rightSpeed);
  
    }

  
  
  double x, y, a, distanceToTarget;
  double leftPosition, rightPosition, leftEncoderInFeet, rightEncoderInFeet;

  public drive() {
  leftPosition = leftFront.getSelectedSensorPosition(0);
  rightPosition = rightFront.getSelectedSensorPosition(0);
  rightFront.setNeutralMode(NeutralMode.Brake);
  rightRear.setNeutralMode(NeutralMode.Brake);
  leftFront.setNeutralMode(NeutralMode.Brake);
  leftRear.setNeutralMode(NeutralMode.Brake);
  }


  @Override
  public void periodic() {
    leftEncoderInFeet = leftPosition * Constants.kEncoderDistancePerPulse;
    rightEncoderInFeet = rightPosition * Constants.kEncoderDistancePerPulse;

  
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  x = tx.getDouble(0.0);
  y = ty.getDouble(0.0);
  a = ta.getDouble(0.0);

  SmartDashboard.putNumber("LimelightX", x);
  SmartDashboard.putNumber("LimelightY", y);
  SmartDashboard.putNumber("LimelightArea", a);

  double heightFromTarget = Constants.hubHeight - Constants.limelightHeight;
  double theta = Math.toRadians(Constants.bottomAngle + y);
  distanceToTarget = heightFromTarget / (Math.tan(theta));
  SmartDashboard.putNumber("distanceToTarget", distanceToTarget);

  }
  public double angleOff(){
    return x;
  }

  public double verticalOffset(){
    return y;
  }

  public double targetArea(){
    return a;
  }

  public double currentDistance(){
    return distanceToTarget;
  }

  


  }
