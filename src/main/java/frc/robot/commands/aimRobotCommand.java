package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.drive;

public class aimRobotCommand extends CommandBase {
  drive drive;
  double proportionAim, integralAim, derivativeAim, errorAim, oldErrorAim, speedAim,
  proptionDistance, integralDistance, derivativeDistance, errorDistance, oldErrorDistance, speedDistance,
  pastTime;
  
  public aimRobotCommand(drive driveSub) {
    drive = driveSub;
    addRequirements(driveSub);
  }

  @Override
  public void initialize() {
    oldErrorAim = 0;
    pastTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {
  errorAim = -1 * drive.angleOff();
  proportionAim = errorAim * Constants.shooterKP;
  double dx = errorAim - oldErrorAim;
  double dt = Timer.getFPGATimestamp() - pastTime;
  pastTime = Timer.getFPGATimestamp();
  integralAim =+ (errorAim * dt) * Constants.shooterKI;
  oldErrorAim = errorAim;
  derivativeAim = ( dx / dt) * Constants.shooterKD;
  speedAim = proportionAim + integralAim + derivativeAim;
  speedDistance = proptionDistance + integralDistance + derivativeDistance;
  drive.move((-1 * speedAim) + speedDistance, speedAim + speedDistance);
  SmartDashboard.putNumber("Aim Error", errorAim);
  SmartDashboard.putNumber("Aim speed", speedAim);
  SmartDashboard.putNumber("Distance Error", errorDistance);
  SmartDashboard.putNumber("Distance Speed", speedDistance);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.move(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
