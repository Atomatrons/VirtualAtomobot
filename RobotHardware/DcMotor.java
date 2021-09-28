package shiva.virtualatomobot;

public class DcMotor extends DcMotorSimple {
  public String _name;
  public float power;
  public int position;
  private int targetPosition;
  
  public static enum RunMode {
    RUN_TO_POSITION,
    RUN_USING_ENCODER,
    RUN_WITHOUT_ENCODER,
    STOP_AND_RESET_ENCODER
  }

  public DcMotor(String name) {
    _name = name;
    power = 0;
    position = 0;
    targetPosition = 0;
  }

  public String name() {
    return _name;
  }

  public void setMode(DcMotor.RunMode mode) {
    if (mode == RunMode.STOP_AND_RESET_ENCODER) {
      power = 0;
      position = 0;
      targetPosition = 0;
    } else if (mode == RunMode.RUN_TO_POSITION) {
      if (power > 0) {
        position = targetPosition;
        power = 0;
        display();
      }
    }
  }

  public int getCurrentPosition() {
    return position;
  }

  public void setTargetPosition(int newTarget) {
    targetPosition = newTarget;
  }

  public void setPower(float value) {
    power = value;
    display();
  }

  public void display() {
    System.out.println("DcMotor " + _name + " is at position: " + position + ", power " + power);
  }
}