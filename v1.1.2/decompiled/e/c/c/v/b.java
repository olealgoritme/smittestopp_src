package e.c.c.v;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD})
public @interface b
{
  boolean nullSafe() default true;
  
  Class<?> value();
}

/* Location:
 * Qualified Name:     e.c.c.v.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */