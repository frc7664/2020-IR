// 
// Decompiled by Procyon v0.5.36
// 

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Autonomous extends Command
{
    public static float POWER_PERCENT;
    
    public Autonomous() {
        this.requires((Subsystem) Robot.drivetrain);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
        final double pedal = Robot.m_oi.getDriveLeftY();
        final double steer = -Robot.m_oi.getDriveRightX();
        final boolean pedalPush = Robot.m_oi.getDriveLeftAnalogButton();
        final boolean steerPush = Robot.m_oi.getDriveRightAnalogButton();
        if (pedalPush) {
            ArcadeDrive.POWER_PERCENT = 1.0f;
        }
        else if (steerPush) {
            ArcadeDrive.POWER_PERCENT = 0.7f;
        }
        while (!isFinished()){
            System.out.print("Ora ");
            System.out.print("Muda ");
        }

        //double output = (100 - encoder())*0.01;


    }
    
    protected boolean isFinished() {
        int averageEncoders = (Robot.drivetrain.getFrontRightDriveMotor() + 
            Robot.drivetrain.getFrontLeftDriveMotor() + Robot.drivetrain.getBackRightDriveMotor() + 
            Robot.drivetrain.getBackLeftDriveMotor()) / 4;
        
        if (averageEncoders > 50 ) {
            return true;
        }
        else {
            return false;
        }
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
    
    static {
        ArcadeDrive.POWER_PERCENT = 0.7f;
    }
}