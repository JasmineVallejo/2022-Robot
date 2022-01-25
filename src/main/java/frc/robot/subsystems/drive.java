// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drive extends SubsystemBase {
  WPI_VictorSPX rightFront = new WPI_VictorSPX(14);
  WPI_VictorSPX rightRear = new WPI_VictorSPX(15);
  WPI_VictorSPX leftFront = new WPI_VictorSPX(17);
  WPI_VictorSPX leftRear = new WPI_VictorSPX(21);

  MotorControllerGroup rightDrive = new MotorControllerGroup(rightFront, rightRear);
  MotorControllerGroup leftDrive = new MotorControllerGroup(leftFront, leftRear);
  DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);
  /** Creates a new drive. */
  public drive() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
