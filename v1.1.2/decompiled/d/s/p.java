package d.s;

import android.os.Bundle;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class p<D extends i>
{
  public abstract D a();
  
  public abstract i a(D paramD, Bundle paramBundle, n paramn, a parama);
  
  public void a(Bundle paramBundle) {}
  
  public Bundle b()
  {
    return null;
  }
  
  public abstract boolean c();
  
  public static abstract interface a {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface b
  {
    String value();
  }
}

/* Location:
 * Qualified Name:     d.s.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */