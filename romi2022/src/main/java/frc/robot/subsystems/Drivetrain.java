// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final Spark leftMotor;
  private final Spark rightMotor;
  private final Encoder leftEncoder;
  private final Encoder rightEncoder;
  private final DifferentialDrive diff;
  private static final double CPR = 1440.0;
  private static final double wheeldiameter = Units.metersToInches(.07);
  
  public Drivetrain() {
    leftMotor = new Spark(0);
    rightMotor = new Spark(1);
    rightMotor.setInverted(true);
    diff = new DifferentialDrive(leftMotor, rightMotor);
    leftEncoder = new Encoder(4,5);
    rightEncoder = new Encoder(6,7);
    leftEncoder.setDistancePerPulse((Math.PI*wheeldiameter)/CPR);
    rightEncoder.setDistancePerPulse((Math.PI*wheeldiameter)/CPR);
    resetEncoders();
  }

  public void ArcDrive(double x, double y){
    diff.arcadeDrive(x, y);
  }

  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
  }
  
  public double getLeftEncoder(){
    return leftEncoder.getDistance();
  }

  public double getRightEncoder(){
    return rightEncoder.getDistance();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
