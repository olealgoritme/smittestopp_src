package e.c.c.v;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface e
{
  double value();
}

/* Location:
 * Qualified Name:     base.e.c.c.v.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */