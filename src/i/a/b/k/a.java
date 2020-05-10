package i.a.b.k;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.FIELD})
public @interface a
{
  boolean value() default true;
}

/* Location:
 * Qualified Name:     base.i.a.b.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */