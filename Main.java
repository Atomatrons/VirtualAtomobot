import shiva.virtualatomobot.*;
import java.util.*;

public class Main {
  private static boolean stopPressed = false;
  private static OpMode virtualOpMode = null;

  public static void main(String[] args) {
    print("Virtual Atomobot v2.1", true);
    
    OpModeMenuItem item = selectOpModeMenuItem();
    if (item == null) {
      return;
    }
    virtualOpMode = item.object();

    if (item.isLinearOpMode()) {
      runLinearOpMode();
    } else {
      runOpMode();
    }
  }

  public static void print(String message, boolean newLine) {
    if (newLine) {
      System.out.println(message);
    } else {
      System.out.print(message);
    }
  }

  public static void doCommand(String command) {
    if (command.startsWith("1 ") || command.startsWith("2 ")) {
      String[] tokens = command.split("\\s+");

      if (tokens.length != 3) {
        print("Command Error: commands are of the form <gamepad> <control name> <value>", true);
        return;
      }

      // tokens[0] ==> <gamepad>
      // tokens[1] ==> <control name>
      // tokens[2] ==> value
      GamePad gamepad = virtualOpMode.getGamePad(tokens[0]);
      if (gamepad != null) {
        gamepad.setValue(tokens[1], tokens[2]);
      } else {
        print("Invalid gamepad '" + tokens[0] + "'", true);
      }
    } else if (command.equals("stop")) {
      stopPressed = true;
    } else {
      print("Unrecognized command '" + command + "'", true);
    }
  }

  // Instantiate OpMode selected by the user
  private static OpModeMenuItem selectOpModeMenuItem() {
    // Get list of all available op modes
    OpModeFinder finder = new OpModeFinder();
    List<OpModeMenuItem> availableOpModes = finder.getOpModes("shiva.virtualatomobot");

    // Ask user which one they want
    print("Select an OpMode by typing its ID", true);
    for (int index = 0; index < availableOpModes.size(); index++) {
      OpModeMenuItem item = availableOpModes.get(index);
      print("    " + index + ": " + item.info(), true);
    }
    String command = echo("Type ID (0 - " + (availableOpModes.size() - 1) + "): ");
    int index = Integer.parseInt(command);
    if (index >= 0 && index < availableOpModes.size()) {
      return availableOpModes.get(index);
    }
    return null;
  }
  
  private static String echo(String prompt) {
    print(prompt + " ", false);
    String command = System.console().readLine();
    return command.trim();
  }

  private static void runLinearOpMode() {
    LinearOpMode lom = (LinearOpMode) virtualOpMode;
    lom.runOpMode();
  }

  private static void runOpMode() {
        // Init immediately
    virtualOpMode.init();

    // Wait for user to say to start
    String command = "";
    while (!command.equals("init")) {
      command = echo("Type init, to start, stop to end:");
      if (command.equals("stop")) {
        virtualOpMode.stop();
        return;
      }
    }
    virtualOpMode.start();

    // Print instructions to user
    print("Simulate using the GamePad Controllers by entering commands.", true);
    print("Type stop to end", true);
    print("", true);
    print("Commands are of the form <gamepad> <control name> <value>:", true);
    print("For example: 1 left_trigger 0.5", true);
    print("", true);
    print("<gamepad> is either 1 or 2, to indicate that you are pressing a button on gamepad 1 or 2", true);
    print("", true);
    print("<control name> is one of the following:", true);
    print("start          back            guide", true);
    print("right_trigger  right_bumper", true);
    print("a              b               x             y", true);
    print("right_stick_x  right_stick_y   right_stick_button", true);
    print("left_stick_x   left_stick_y    left_stick_button", true);
    print("dpad_left      dpad_down       dpad_right    dpad_up", true);
    print("left_trigger   left_bumper", true);
    print("", true);
    print("<value> is the value of the button. Use values like -1, 0, 0.5 for float valued-controls. Use true or false for boolean controls", true);
    print("For more information on the Controller, see the diagram on page two here: https://docs.google.com/presentation/d/1iAJM23aqQ_EDcYrlwJbYuyU7Jd9sFejd1AF2yKo27Cw/edit#slide=id.ga9967abe4c_0_3", true);
    print("", true);
    print("", true);

    // Launch thread to read commands from user without blocking loop
    TextInput inputThread = new TextInput();
    inputThread.start();

    // Loop until user says to stop
    while (!stopPressed) {
      virtualOpMode.loop();
    }
    inputThread.stop();

    // Stop
    virtualOpMode.stop();
  }
}
