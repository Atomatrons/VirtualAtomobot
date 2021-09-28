package shiva.virtualatomobot;

public abstract class DcMotorSimple implements HardwareDevice {
  private Direction direction;
  
  public static enum Direction {
    FORWARD,
    REVERSE
  }

  public void setDirection(DcMotorSimple.Direction _direction) {
    direction = _direction;
  }

  public Direction getDirection() {
    return direction;
  }
}