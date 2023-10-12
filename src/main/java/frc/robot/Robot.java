// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {
  // define a xbox controller
  public XboxController drivingController = new XboxController(0);

  // define four motors leftFront= 2, leftBack= 1, rightFront= 3, rightBack= 4
  public CANSparkMax leftFrontMotor = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax leftBackMotor = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax rightFrontMotor = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax rightBackMotor = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

  // create two motor controll groups, one for left group and one for right group
  public MotorControllerGroup leftGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  public MotorControllerGroup rightGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);

  public DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);
  // whatever is in this block of code runs right after u hit the power on button
  @Override
  public void robotInit() {
    rightGroup.setInverted(true);
  }

  // whatever is in this block of code runs as long as the robot is running
  @Override
  public void robotPeriodic() {}

  // whatever is in this block of code runs after the driver turns on auto
  @Override
  public void autonomousInit() {}

  // whatever is in this block of code runs as long as the auto is turned on
  @Override
  public void autonomousPeriodic() {}

  // whatever is in this block of code runs after the driver turns on the manual control mode
  @Override
  public void teleopInit() {}

  // whatever is in this block of code runs as long as the driver is controlling the robot
  @Override
  public void teleopPeriodic() {
    double forwardPower = -drivingController.getRawAxis(1);
    double turningPower = -drivingController.getRawAxis(4);

    drive.arcadeDrive(forwardPower, turningPower);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

}
