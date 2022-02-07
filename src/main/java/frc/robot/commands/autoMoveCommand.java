package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive;

public class autoMoveCommand extends CommandBase {
  drive driveSub;
  double desiredDistance, pastTime, oldError, proportion, integral, derivative;

  public autoMoveCommand(drive drive, double targetDistance) {
    driveSub = drive;
    desiredDistance = targetDistance;
    addRequirements(driveSub);
  }

  @Override
  public void initialize() {
    oldError = 0;
    pastTime = Timer.getFPGATimestamp();
  }

  
  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
