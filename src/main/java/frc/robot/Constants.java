
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

rotaryForwardButton = 1, rotaryBackwardButton = 2, rotaryForwardButton2 = 4, rotaryBackwardButton2 = 1,

cascadeDownButton = 3, cascadeUpButton = 4, cascadeDownButton2 = 7, cascadeUpButton2 = 8, 

IndexerInButton = 5, IndexerOutButton = 7, 

shooterButton = 6, shooterButton2 = 8, 

leftDriveAxis = 1, rightDriveAxis = 5, 

aimRobotButton = 14,  aimRobotButton2 = 7;


public static double


// ----------------------------------- Vision Tracking -------------------------------------
hubHeight = 8.667, limelightHeight = 2.25, bottomAngle = 25, targetDistance = 10,
// ----------------------------------- PIDS for drive -------------------------------------
aimKP = 0.05, aimKI = 0, aimKD = 0, distanceKP = 0.1, distanceKI = 0.00, distanceKD = 0.01, 
//aimKP = .09, aimKI = 0.0001, aimKD = 0,
// ----------------------------------- PIDS for shooter -------------------------------------
shooterKP = .001,

//----------------------------------- Encoder -----------------------------------------------
kEncoderDistancePerPulse = ((Math.PI * 6)/24576),


 // ----------------------------------- Falcon 500 Speeds ----------------------------------- //
shooterSpeed = -1, cascadeSpeed = .6, driveSpeed =.5, indexerSpeed = .7, rotaryArmSpeed = .5;


}

