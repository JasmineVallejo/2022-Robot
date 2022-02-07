
package frc.robot;


public final class Constants 
{

public static int 
// -------------------------------------- Controller -------------------------------------- //
jasmine = 0, ish = 1, 
// -------------------------------------- Falcon 500 IDs -------------------------------------- //
rightFront = 10, rightRear = 11, leftFront = 13, leftRear = 12, shooterMotor = 16, cascadeMotor = 18, rotaryArmMotor = 15,



// --------------------------------------   Victor SPX   -------------------------------------- //
indexMotor = 17,

//----------------------------------- Buttons -----------------------------------------------
rotaryForwardButton = 1, rotaryBackwardButton = 2, cascadeDownButton = 3, cascadeUpButton = 4, 
IndexerInButton = 5, IndexerOutButton = 7, shooterButton = 6;


public static double


// ----------------------------------- Vision Tracking -------------------------------------
hubHeight = 8.667, limelightHeight = 2.25, bottomAngle = 15,
// ----------------------------------- PIDS for shooter -------------------------------------
shooterKP = .1, shooterKI = .1, shooterKD = .1,

//----------------------------------- Encoder -----------------------------------------------
kEncoderDistancePerPulse = ((Math.PI * .152)/4096),


 // ----------------------------------- Falcon 500 Speeds ----------------------------------- //
shooterSpeed = -1, cascadeSpeed = .4, driveSpeed =.6, indexerSpeed = .6, rotaryArmSpeed = .3;


}

