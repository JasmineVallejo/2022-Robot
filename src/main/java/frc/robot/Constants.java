
package frc.robot;


public final class Constants {

public static int 
//-------------------------------------- Falcon 500 IDs --------------------------------------
rightFront = 10, rightRear = 11, leftFront = 13, leftRear = 12, shooterMotor = 16, cascadeMotor = 18, rotaryArmMotor = 15,
//--------------------------------------   Victor SPX   --------------------------------------
indexMotor = 17;


public static double
 // ----------------------------------- Falcon 500 Speeds -----------------------------------
shooterSpeed = -.2, cascadeSpeed = .2, driveSpeed =.4, indexerSpeed = .2, rotaryArmSpeed = .2,
// ----------------------------------- Vision Tracking -------------------------------------
hubHeight = 8.667, limelightHeight = 2.25, bottomAngle = 15,
// ----------------------------------- PIDS for shooter -------------------------------------
shooterKP = .1, shooterKI = .1, shooterKD = .1,
//----------------------------------- Buttons -----------------------------------------------

//----------------------------------- Encoder -----------------------------------------------
kEncoderDistancePerPulse = ((Math.PI * .152)/4096);
}