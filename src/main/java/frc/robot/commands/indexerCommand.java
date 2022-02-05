

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.indexer;

public class indexerCommand extends CommandBase {
  double speed;
  indexer indexerSub;
  public indexerCommand(indexer indexer, double indexerSpeed) {
    speed = indexerSpeed;
    indexerSub = indexer;
    addRequirements(indexerSub);
   
  }

  
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    indexerSub.move(speed);
  }

  
  @Override
  public void end(boolean interrupted) {
    indexerSub.move(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
