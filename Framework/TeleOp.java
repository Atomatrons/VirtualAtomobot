package shiva.virtualatomobot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* TeleOp
**  Define the TeleOp annotation, so the OpMode classes can look more real
*/
 
// Make the annotation available at runtime:
@Retention(RetentionPolicy.RUNTIME)
// Allow to use only on types:
@Target(ElementType.TYPE)
public @interface TeleOp 
{ 
    String name();  
    String group() default "Main"; 
}
