package e.c.c.v;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface a
{
  boolean deserialize() default true;
  
  boolean serialize() default true;
}

/* Location:
 * Qualified Name:     e.c.c.v.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */