package shiva.virtualatomobot;

import java.lang.annotation.*;

public class OpModeMenuItem {
  private String name;
  private String group;
  private OpMode opModeObject;
  private Boolean _isLinearOpMode;
  private Boolean isTeleOpMode;

  OpModeMenuItem(Annotation annotation, OpMode object) {
    if (annotation instanceof Autonomous) {
      Autonomous auto = (Autonomous) annotation;
      name = auto.name();
      group = auto.group();
      _isLinearOpMode = object instanceof LinearOpMode;
      isTeleOpMode = false;
    } else {
      TeleOp auto = (TeleOp) annotation;
      name = auto.name();
      group = auto.group();
      _isLinearOpMode = object instanceof LinearOpMode;
      isTeleOpMode = true;
    }

    opModeObject = object;
  }

  public String info() {
    return "Mode: " + (isTeleOpMode ? "TeleOp" : "Autonomous") + "   Name: " + name + "   Group: " + group;
  }

  public OpMode object() {
    return opModeObject;
  }

  public boolean isLinearOpMode() {
    return _isLinearOpMode;
  }
}
