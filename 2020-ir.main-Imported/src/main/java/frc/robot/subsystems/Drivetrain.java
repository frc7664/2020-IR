// 
// Decompiled by Procyon v0.5.36
// 

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;;

public class Drivetrain extends Subsystem
{
    TalonFX FRONT_RIGHT_DRIVE_MOTOR;
    TalonFX FRONT_LEFT_DRIVE_MOTOR;
    TalonFX BACK_RIGHT_DRIVE_MOTOR;
    TalonFX BACK_LEFT_DRIVE_MOTOR;

    SpeedControllerGroup rightDrive;
    SpeedControllerGroup leftDrive;

    TalonFX drivetrain;
    TalonFXControlMode controlMode = TalonFXControlMode.PercentOutput;

    public Drivetrain() {
        this.BACK_LEFT_DRIVE_MOTOR = new TalonFX(1);
        this.BACK_RIGHT_DRIVE_MOTOR = new TalonFX(3);
        this.FRONT_LEFT_DRIVE_MOTOR = new TalonFX(0);
        this.FRONT_RIGHT_DRIVE_MOTOR = new TalonFX(2);

        //FRONT_RIGHT_DRIVE_MOTOR.getSelectedSensorPosition();
    }
    public void runRightDrive (final double output){
        this.BACK_RIGHT_DRIVE_MOTOR.set(controlMode, -output);
        this.FRONT_RIGHT_DRIVE_MOTOR.set(controlMode, -output);
    }
    public void runLeftDrive (final double output){
        this.BACK_LEFT_DRIVE_MOTOR.set(controlMode, output);
        this.FRONT_LEFT_DRIVE_MOTOR.set(controlMode, output);
    }
    public void initDefaultCommand() {
        this.setDefaultCommand((Command)new ArcadeDrive());
    }

    public int getFrontRightDriveMotor(){
        return(this.FRONT_RIGHT_DRIVE_MOTOR.getSelectedSensorPosition());
    }
    public int getFrontLeftDriveMotor(){
        return(this.FRONT_LEFT_DRIVE_MOTOR.getSelectedSensorPosition());
    }
    public int getBackRightDriveMotor(){
        return(this.BACK_RIGHT_DRIVE_MOTOR.getSelectedSensorPosition());
    }
    public int getBackLeftDriveMotor(){
        return(this.BACK_LEFT_DRIVE_MOTOR.getSelectedSensorPosition());
    }
}