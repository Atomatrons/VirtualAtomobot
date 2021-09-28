package shiva.virtualatomobot;

public abstract class OpMode {
  protected volatile GamePad gamepad1 = new GamePad("One");
  protected volatile GamePad gamepad2 = new GamePad("Two");
  protected HardwareMap hardwareMap = new HardwareMap();

  // This method is to allow the Main command handler to access the GamePads and simulate user activity
  public GamePad getGamePad(String id) {
    if (id.equals("1")) return gamepad1;
    if (id.equals("2")) return gamepad2;
    return null;
  }

  // The user presses the INIT button
  public void init() {
    System.out.println("init");
  }

  // The user presses the START (arrow) button
  public void start() {
    System.out.println("start");
  }

  // Once start completes, this method is called repeatedly, as fast as possible
  public void loop() {
    System.out.println("loop");
  }

  // The user presses the STOP (square) button
  public void stop() {
    System.out.println("stop");
  }
}