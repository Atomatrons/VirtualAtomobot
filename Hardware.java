package shiva.virtualatomobot;

// import com.qualcomm.robotcore.eventloop.opmode.OpMode;
// import com.qualcomm.robotcore.hardware.DcMotorEx;
// import com.qualcomm.robotcore.hardware.CRServo;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.*;

/*  Hardware
**  This class provides the constants and variables that define the hardware on our robot.
*/

public class Hardware {
    // Motor Constants
    public final int MOTOR_TICKS_PER_360 = 1120;

    // Wheels
    public DcMotor front_left  = null;
    public DcMotor front_right = null;
    public DcMotor back_left   = null;
    public DcMotor back_right  = null;
    //public List<DcMotor> wheels;
    public DcMotor[] wheels;

    // Robot Arm
    public DcMotorEx wobble_arm  = null;
    public Servo servo_wobble = null;
    public final double ARM_GEAR_RATIO = 40 / 15.0;
    public final double ARM_TICKS_PER_360 = MOTOR_TICKS_PER_360 * ARM_GEAR_RATIO;

    public void init(HardwareMap hardwareMap) {
      front_left   = hardwareMap.get(DcMotor.class, "front_left");
      front_right  = hardwareMap.get(DcMotor.class, "front_right");
      back_left    = hardwareMap.get(DcMotor.class, "back_left");
      back_right   = hardwareMap.get(DcMotor.class, "back_right");

      //wheels = List.of(front_left, front_right, back_left, back_right);
      wheels = new DcMotor[] {front_left, front_right, back_left, back_right};
      
      wobble_arm   = hardwareMap.get(DcMotorEx.class, "wobble_arm");
      wobble_arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      wobble_arm.setTargetPosition(wobble_arm.getCurrentPosition());
      
      servo_wobble = hardwareMap.get(Servo.class, "servo_wobble");
    }
}
