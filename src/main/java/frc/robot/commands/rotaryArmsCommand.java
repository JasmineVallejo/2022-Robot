// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.rotaryArms;


public class rotaryArmsCommand extends CommandBase {
  rotaryArms rotaryArmsSub;
  double speed;
  public rotaryArmsCommand(rotaryArms rotaryArms, double rotaryArmsSpeed) {
    speed = rotaryArmsSpeed;
    rotaryArmsSub = rotaryArms;
    addRequirements(rotaryArmsSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rotaryArmsSub.rotateArms(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rotaryArmsSub.rotateArms(0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
