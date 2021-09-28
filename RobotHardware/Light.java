package shiva.virtualatomobot;

public class Light implements HardwareDevice {
  private String _name;
  public boolean isOn;

  public Light(String name) {
    _name = name;
    isOn = false;
  }

  public String name() {
    return _name;
  }

  public void turnOn() {
    isOn = true;
    display();
  }

  public void turnOff() {
    isOn = false;
    display();
  }

  public void display() {
    System.out.println("Light " + _name + " is " + (isOn ? "ON" : "OFF"));
  }
}
