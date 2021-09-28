package shiva.virtualatomobot;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.net.*;
import java.io.*;
import java.util.*;

/* OpModeFinder
**  This class returns a list of all the Subclasses of OpMode that are in the system,
**  other than OpMode and LinearOpMode
**  See: https://www.infoworld.com/article/2077477/java-tip-113--identify-subclasses-at-runtime.html
*/

public class OpModeFinder {

  @SuppressWarnings("unchecked")
  public List<OpModeMenuItem> getOpModes(String pckgname) {
    List<OpModeMenuItem> result = new ArrayList<OpModeMenuItem>();

    // Translate the package name into an absolute path
    String name = new String(pckgname);
    if (!name.startsWith("/")) {
      name = "/" + name;
    }        
    name = name.replace('.','/');
    //System.out.println("package folder: '" + name + "'");

    // Get a File object for the package
    URL url = OpModeFinder.class.getResource(name);
    File directory = new File(url.getFile());

    // Scan the files in the folder for ones that we want
    if (directory.exists()) {
      // Get the list of the files contained in the package
      String [] files = directory.list();
      for (int index = 0; index < files.length; index++) {
        String fileName = files[index];
        //System.out.println("file name: " + fileName);

        // we are only interested in .class files
        if (fileName.endsWith(".class")) {
          // removes the .class extension
          String classname = fileName.substring(0, fileName.length()-6);
          try {
            // Try to create an instance of the object
            //System.out.println("class name: " + pckgname + "." + classname);
            Class aClass = Class.forName(pckgname + "." + classname);
            Constructor ctor = aClass.getConstructor();
            Object anObject = ctor.newInstance();
            if (anObject instanceof OpMode) {
              //System.out.println("anObject is an OpMode");
              Annotation[] annotations = aClass.getAnnotations();
              if (annotations != null && annotations.length > 0) {
                //System.out.println("we have " + annotations.length + " annotations");
                OpModeMenuItem item = new OpModeMenuItem(annotations[0], (OpMode) anObject);
                result.add(item);
              }
            }
          } catch (NoSuchMethodException nsmex) {
            //System.err.println(nsmex);
          } catch (InvocationTargetException itex) {
            System.err.println(itex);
          } catch (ClassNotFoundException cnfex) {
            System.err.println(cnfex);
          } catch (InstantiationException iex) {
            // We try to instantiate an interface
            // or an object that does not have a 
            // default constructor
          } catch (IllegalAccessException iaex) {
            // The class is not public
          }
        }
      }
    }

    // Debug
    // result.forEach(item -> {
    //   Main.print("an item: " + item.info(), true);
    // });

    return result;
  }
}