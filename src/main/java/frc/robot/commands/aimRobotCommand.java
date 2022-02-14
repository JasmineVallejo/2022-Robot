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
  pastTime, ta, td;
  
  public aimRobotCommand(drive driveSub, double targetDistance) {
    drive = driveSub;
    td = targetDistance;
    addRequirements(driveSub);
  }

  @Override
  public void initialize() {
    oldErrorAim = 0;
    integralAim = 0;
    integralDistance = 0;
    pastTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {

  errorAim = -1 * drive.angleOff();
  proportionAim = errorAim * Constants.aimKP;

  errorDistance = td -  drive.currentDistance();
  proptionDistance = errorDistance * Constants.distanceKP;

  double dt = Timer.getFPGATimestamp() - pastTime;
  pastTime = Timer.getFPGATimestamp();

  integralAim += (errorAim * dt) * Constants.aimKI;
  integralDistance=+ (errorDistance * dt) * Constants.distanceKI;

  double dxAim = errorAim - oldErrorAim;//
  double dxDistance = errorDistance - oldErrorDistance;//
  derivativeAim = ( dxAim / dt) * Constants.aimKD;
  derivativeDistance = (dxDistance / dt) * Constants.distanceKD;
  oldErrorAim = errorAim;
  oldErrorDistance = errorDistance;

  speedAim = proportionAim + integralAim + derivativeAim;
  speedDistance = proptionDistance + integralDistance + derivativeDistance;
  drive.move((  speedAim) + speedDistance, -1*speedAim + speedDistance);

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
