package shiva.virtualatomobot;

public abstract class LinearOpMode extends OpMode {
  private boolean isStarted = false;
  private boolean opModeActive = false;

  public void runOpMode() {
    // put your init() code here
    waitForStart();
    
    // put your start() code here
    
    while (opModeIsActive()) {
      // put your loop() code here
    }
    
    // put your stop() code here
  }

  public final void start() {
    isStarted = true;
  }
  
  public final void stop() {
    opModeActive = false;
  }

  public void waitForStart() {

  }

  public final boolean opModeIsActive() {
    return opModeActive;
  }
}