package shiva.virtualatomobot;

import java.lang.reflect.*;

public class HardwareMap extends java.lang.Object implements java.lang.Iterable<HardwareDevice> {

  public java.util.Iterator<HardwareDevice> iterator() {
    return null;
  }

  public <HardwareDevice> HardwareDevice get(java.lang.Class<? extends HardwareDevice> classOrInterface, java.lang.String deviceName) {
    try {
      Constructor ctor = classOrInterface.getConstructor(String.class);
      HardwareDevice result = (HardwareDevice) ctor.newInstance(deviceName);
      return result;
    } catch (NoSuchMethodException nsmex) {
      System.err.println(nsmex);
    } catch (InvocationTargetException itex) {
      System.err.println(itex);
    } catch (InstantiationException iex) {
      // We try to instantiate an interface
      // or an object that does not have a 
      // default constructor
      System.err.println(iex);
    } catch (IllegalAccessException iaex) {
      // The class is not public
      System.err.println(iaex);
    }
    return null;
  }
}