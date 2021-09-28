package shiva.virtualatomobot;

public class Range {
  public static double clip(double value, double min, double max) {
    if (value < min) return min;
    if (value > max) return max;
    return value;
  }
}