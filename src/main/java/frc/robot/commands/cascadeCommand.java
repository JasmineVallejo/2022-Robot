// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.cascade;

public class cascadeCommand extends CommandBase {
  cascade cascadeSub;
  double speed;

  public cascadeCommand(cascade cascade, double cascadeSpeed) {
    cascadeSub = cascade;
    speed = cascadeSpeed;
    addRequirements(cascadeSub);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    cascadeSub.cascadeMove(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    cascadeSub.cascadeMove(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
