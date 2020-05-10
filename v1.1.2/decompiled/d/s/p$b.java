package d.s;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface p$b
{
  String value();
}

/* Location:
 * Qualified Name:     d.s.p.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */