
package frc.robot;


public final class Constants 
{

public static int 




///////////////////////////////         Controllers         /////////////////////////////////////////////////

nathan = 0, gio = 1, daniel = 2,                               // controller ports

leftDriveAxis = 1, rightDriveAxis = 5,                      // controller axis 







///////////////////////////////         Falcon Id's        /////////////////////////////////////////////////

rightFront = 10, rightRear = 11, leftFront = 13, leftRear = 12,      // drive ID's

shooterMotor = 16, cascadeMotor = 18,                                // cascade ID's

rotaryArmMotor = 15,                                                 // rotary arm ID

////////////////////////////////        Talon SRX       //////////////////////////////////////////////

indexMotor = 20,                                                     // indexer ID







///////////////////////////////           Controller Buttons        ////////////////////////////////////////






                    /////////////           Nathan Controls              ///////////////

rotaryForwardButton = 8, rotaryBackwardButton = 6,              // rotary arms buttons 

cascadeDownButton = 5, cascadeUpButton = 7,                     // cascade buttons







                    ////////////        Gio Controls            //////////////////

IndexerOutGio = 6, IndexerInGio = 5,                    // indexer buttons
IndexerInMaxGio = 9,

shooterMax = 10, shooterClose = 7, shooterMid = 8,              // shooter controls
shooterFar = 4, shooterRev = 6,                                 // shooter controls 

aimRobotButton2 = 7,                                            // aiming button    













///////////////////////////             Auto                ////////////////////////////////////

tarmacDistance = -5;




public static double





////////////////////////                 Vision Tracking                /////////////////////////////////

hubHeight = 8.667, limelightHeight = 2.25, bottomAngle = 25, targetDistance = 10,







////////////////////////                  PIDS for drive                ////////////////////////////////

aimKP = 0.05, aimKI = 0, aimKD = 0, distanceKP = 0.18, distanceKI = 0.09, distanceKD = 0.07, 

//aimKP = .09, aimKI = 0.0001, aimKD = 0, distanceKP = .1 distanceKD 0.01, dKP = .13





////////////////////////                 PIDS for shooter               ////////////////////////////////

shooterKP = .001,





////////////////////////                     Encoder                    ////////////////////////////////

kEncoderDistancePerPulse = ((Math.PI * 5.75)/(24576 * 9.375)),






/////////////////////////////                Subsystem Speeds                ///////////////////////////////////

shooterMaxSpeed = 1, shooterCloseSpeed = .5, shooterMidSpeed = .6, 
shooterFarSpeed = .7, shooterRevSpeed = .4,                                 

cascadeUpSpeed = -.6, 
cascadeDownSpeed = -.6,

driveSpeed =.7, 

indexerSpeedMax = .8, indexerInSpeed = .5, indexerOutSpeed = -.5,

rotaryArmFowardSpeed = .5, rotaryArmBackwardSpeed = -.5;


}

