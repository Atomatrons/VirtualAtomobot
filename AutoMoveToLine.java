package shiva.virtualatomobot;

// import com.qualcomm.robotcore.eventloop.opmode.OpMode;
// import com.qualcomm.robotcore.hardware.DcMotorEx;
// import com.qualcomm.robotcore.hardware.CRServo;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;

/*  AutoMoveToLine
**  This is an Autonomous OpMode.
**  We move the robot forward a certain number of rotations, so that the robot will be parked on the Launch Line
*/

@Autonomous(name="Auto Move To Line", group="Coach Ken")
public class AutoMoveToLine extends LinearOpMode {
  Hardware hardware = new Hardware();

  private Boolean resetArm = false;
  private Boolean armIsBusy = false;
  private Boolean emergency = false;

  public void runOpMode() {

    // Initialize hardware
    hardware.init(hardwareMap);

    // Turn off all wheels and set position to 0
    // front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    // front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    // back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    // back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    // // hardware.wheels.forEach(wheel -> {
    // //   wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    // // });
    for (int index = 0; index < hardware.wheels.length; index++) {
      DcMotor wheel = hardware.wheels[index];
      wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    waitForStart();
    
    // put your start() code here
    
    driveToLine();

    // put your stop() code here

  }

  private void driveToLine() {
    // Guess how many revolutions of the wheel gets us to the line.
    //  The line is 80 inches from the back wall, so we need to travel 80 - (18/2) inches = 71 inches.
    //  The wheels have a circumferences of 4*pi inches = 12.6 inches
    //  So the wheels need to turn 5.6 times
    int targetPosition = (int) Math.round(hardware.MOTOR_TICKS_PER_360 * 5.6);

    // front_left.setTargetPosition(newTargetPosition);
    // front_left.setPower(0.9);
    // front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    // // hardware.wheels.forEach(wheel -> {
    // //   wheel.setTargetPosition(targetPosition);
    // //   wheel.setPower(0.9f);
    // //   wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    // // });
    for (int index = 0; index < hardware.wheels.length; index++) {
      DcMotor wheel = hardware.wheels[index];
      wheel.setTargetPosition(targetPosition);
      wheel.setPower(0.9f);
      wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
  }
}
