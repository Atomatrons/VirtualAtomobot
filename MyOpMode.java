package shiva.virtualatomobot;

@TeleOp(name="MyOpMode", group="Programming Challenge")
public class MyOpMode extends OpMode {
  private Light light;
  private DcMotor motor;

  public void init() {
    light = new Light("Test");
    motor = new DcMotor("Arm");
  }

  public void loop() {
    if (gamepad1.a == true && light.isOn == false) {
      light.turnOn();
    } else if (gamepad1.a == false && light.isOn == true) {
      light.turnOff();
    }

    if (gamepad2.left_trigger > 0) {
      motor.setPower(gamepad2.left_trigger);
    }

    // Display debug info if this button is pressed
    if (gamepad2.a) {
      light.display();
    }
  }
}