// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.shooter;

public class autoShooter extends CommandBase {
  shooter shooterSub;
  double error, oldError, proportion, integral, derivative, pastTime;
  public autoShooter(shooter shooter) {
    shooterSub = shooter;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    error = shooterSub.getRPM() - shooterSub.currentRPM();
    proportion = error * Constants.shooterKP;
    double totalVoltage = proportion + shooterSub.aimFeedForward(shooterSub.getRPM());
    shooterSub.voltageMove(totalVoltage);

    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
