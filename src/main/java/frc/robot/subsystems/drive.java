package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
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
  

  /** Creates a new drive. */

  public void move(double leftSpeed,double rightSpeed){
  drive.tankDrive( -1 *leftSpeed,rightSpeed);

  }
  public drive() {}

  @Override
  public void periodic() {
  }
}
