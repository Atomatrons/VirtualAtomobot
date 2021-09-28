package shiva.virtualatomobot;

public class Servo implements HardwareDevice {
  public String _name;

  public Servo(String name) {
    _name = name;
  }

  public String name() {
    return _name;
  }
}
