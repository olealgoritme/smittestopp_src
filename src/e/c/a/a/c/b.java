package e.c.a.a.c;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;

public final class b<T>
  extends a.a
{
  public final T a;
  
  public b(T paramT)
  {
    a = paramT;
  }
  
  public static <T> T a(a parama)
  {
    if ((parama instanceof b)) {
      return (T)a;
    }
    IBinder localIBinder = parama.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    parama = null;
    int i = arrayOfField.length;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      Field localField = arrayOfField[j];
      m = k;
      if (!localField.isSynthetic())
      {
        m = k + 1;
        parama = localField;
      }
      j++;
    }
    if (k == 1)
    {
      if (!parama.isAccessible())
      {
        parama.setAccessible(true);
        try
        {
          parama = parama.get(localIBinder);
          return parama;
        }
        catch (IllegalAccessException parama)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", parama);
        }
        catch (NullPointerException parama)
        {
          throw new IllegalArgumentException("Binder object is null.", parama);
        }
      }
      throw new IllegalArgumentException("IObjectWrapper declared field not private!");
    }
    j = arrayOfField.length;
    parama = new StringBuilder(64);
    parama.append("Unexpected number of IObjectWrapper declared fields: ");
    parama.append(j);
    throw new IllegalArgumentException(parama.toString());
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */