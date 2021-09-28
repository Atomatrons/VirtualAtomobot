package shiva.virtualatomobot;

import java.util.*;

public class GamePad {
  private String name;

  public float left_stick_x;
  public float left_stick_y;
  public boolean left_stick_button;

  public float right_stick_x;
  public float right_stick_y;
  public boolean right_stick_button;

  public boolean a;
  public boolean b;
  public boolean x;
  public boolean y;

  public boolean right_bumper;
  public float right_trigger;

  public boolean start;
  public boolean back;
  public boolean guide;

  public boolean left_bumper;
  public float left_trigger;

  public boolean dpad_left;
  public boolean dpad_down;
  public boolean dpad_right;
  public boolean dpad_up;

  public GamePad(String _name) {
    name = _name;
  }

  // FOr the command interpreter
  public void setValue(String controlName, String value) {
    switch (controlName) {
      case "left_stick_x":
        left_stick_x = valueAsFloat(value);
        break;
      case "left_stick_y":
        left_stick_y = valueAsFloat(value);
        break;
      case "left_stick_button":
        left_stick_button = valueAsBoolean(value);
        break;
      case "right_stick_x":
        right_stick_x = valueAsFloat(value);
        break;
      case "right_stick_y":
        right_stick_y = valueAsFloat(value);
        break;
      case "right_stick_button":
        right_stick_button = valueAsBoolean(value);
        break;
      case "a":
        a = valueAsBoolean(value);
        break;
      case "b":
        b = valueAsBoolean(value);
        break;
      case "x":
        x = valueAsBoolean(value);
        break;
      case "y":
        y = valueAsBoolean(value);
        break;
      case "right_bumper":
        right_bumper = valueAsBoolean(value);
        break;
      case "right_trigger":
        right_trigger = valueAsFloat(value);
        break;
      case "start":
        start = valueAsBoolean(value);
        break;
      case "back":
        back = valueAsBoolean(value);
        break;
      case "guide":
        guide = valueAsBoolean(value);
        break;
      case "left_bumper":
        left_bumper = valueAsBoolean(value);
        break;
      case "left_trigger":
        left_trigger = valueAsFloat(value);
        break;
      case "dpad_left":
        dpad_left = valueAsBoolean(value);
        break;
      case "dpad_down":
        dpad_down = valueAsBoolean(value);
        break;
      case "dpad_right":
        dpad_right = valueAsBoolean(value);
        break;
      case "dpad_up":
        dpad_up = valueAsBoolean(value);
        break;
      default:
        System.out.println("Unrecognized control '" + controlName + "'");
    }
  }

  private boolean valueAsBoolean(String value) {
    var result = Boolean.parseBoolean(value);
    return result;
  }

  private float valueAsFloat(String value) {
    var result = Float.parseFloat(value);
    return result;
  }
}