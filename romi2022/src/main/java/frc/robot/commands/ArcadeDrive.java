// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  private final Drivetrain m_drive;
  private final DoubleSupplier m_xsup, m_ysup;
  public ArcadeDrive(Drivetrain drive, DoubleSupplier xsup, DoubleSupplier ysup) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_xsup = xsup;
    m_ysup = ysup;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.ArcDrive(-m_xsup.getAsDouble(), m_ysup.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
