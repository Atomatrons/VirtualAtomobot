import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class TextInput implements Runnable {
  //create a thread object and check if it's not already created
  static Thread thread;
  // Use Scanner to read user input
  Scanner inputReader = new Scanner(System.in);
  // Use AtomicBoolean to avoid thread issues
  private final AtomicBoolean running = new AtomicBoolean(false);

  //This method gets called from the main
  public void start() {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }

  public void stop() {
    running.set(false);
  }

  @Override
  public void run() {
    running.set(true);
    while (running.get()) {
      readTextFromConsole();
    }
  }

  //check for input all the time - THIS WILL NOT HALT THE PROGRAM
  public void readTextFromConsole() {
    Main.print("command: ", false);
    String userInput = inputReader.nextLine();
    Main.doCommand(userInput);

    // This shouldn't be necessary, but...
    if (userInput.equals("stop")) {
      stop();
    }
  }
}
