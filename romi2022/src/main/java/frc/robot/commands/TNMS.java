// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.sql.Driver;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TNMS extends CommandBase {
  /** Creates a new TNMS. */
  private final Drivetrain m_drive;
  public TNMS(Drivetrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.ArcDrive(0.5, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double leftEncoder = m_drive.getLeftEncoder();
    double rightEncoder = m_drive.getRightEncoder();
    double average = (leftEncoder + rightEncoder)/2;
    if (average > 6.0) { 
      return true;
    } else {
      return false;
    }
  }
}
