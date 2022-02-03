package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class indexer extends SubsystemBase {
  WPI_VictorSPX motor = new WPI_VictorSPX(Constants.indexMotor);
  

  public indexer() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
