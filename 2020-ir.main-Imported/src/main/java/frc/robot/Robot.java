// 
// Decompiled by Procyon v0.5.36
// 

package frc.robot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot
{
    public static final Pneumatics pneumatic;
    public static Drivetrain drivetrain;
    public static OI m_oi;
    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser;
    
    public Robot() {
        this.m_chooser = (SendableChooser<Command>)new SendableChooser();
    }
    
    public void robotInit() {
        Robot.m_oi = new OI();
        SmartDashboard.putData("Auto mode", (Sendable)this.m_chooser);
    }
    
    public void robotPeriodic() {
        Robot.m_oi.printDpad();
    }
    
    public void disabledInit() {
    }
    
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void autonomousInit() {
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void teleopInit() {
        if (this.m_autonomousCommand != null) {
            this.m_autonomousCommand.cancel();
        }
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
    }
    
    static {
        pneumatic = new Pneumatics();
        Robot.drivetrain = new Drivetrain();
    }
}
