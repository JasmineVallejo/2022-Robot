
package frc.robot;


public final class Constants 
{

public static int 
// -------------------------------------- Controller -------------------------------------- //
jasmine = 0, ish = 1, 
// -------------------------------------- Falcon 500 IDs -------------------------------------- //
rightFront = 10, rightRear = 11, leftFront = 13, leftRear = 12, shooterMotor = 16, cascadeMotor = 18, rotaryArmMotor = 15,



// --------------------------------------   Talon SRX   -------------------------------------- //
indexMotor = 20,

//----------------------------------- Buttons -----------------------------------------------
IndexerOut2Button = 6, 
shooter9 = 4, shooter8 = 2, shooter7 = 1, shooter6 = 3,

rotaryForwardButton = 1, rotaryBackwardButton = 2, cascadeDownButton = 3, cascadeUpButton = 4, 
IndexerInButton = 5, IndexerOutButton = 7, shooterButton = 6, leftDriveAxis = 1, rightDriveAxis = 5, aimRobotButton = 14;


public static double


// ----------------------------------- Vision Tracking -------------------------------------
hubHeight = 8.667, limelightHeight = 2.25, bottomAngle = 15, targetDistance = 10,
// ----------------------------------- PIDS for shooter -------------------------------------
aimKP = .01, aimKI = 0, aimKD = 0, distanceKP = .01, distanceKI = 0, distanceKD = 0, 

//----------------------------------- Encoder -----------------------------------------------
kEncoderDistancePerPulse = ((Math.PI * 6)/24576),


 // ----------------------------------- Falcon 500 Speeds ----------------------------------- //
shooterSpeed = -1, cascadeSpeed = .4, driveSpeed =.6, indexerSpeed = .7, rotaryArmSpeed = .3;


}

