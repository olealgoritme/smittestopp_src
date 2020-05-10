package e.c.c.w.a0;

import e.c.c.k;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class c
  extends b
{
  public static Class d;
  public final Object b;
  public final Field c;
  
  public c()
  {
    Object localObject1 = null;
    Field localField;
    try
    {
      Object localObject2 = Class.forName("sun.misc.Unsafe");
      d = (Class)localObject2;
      localObject2 = ((Class)localObject2).getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
    }
    catch (Exception localException)
    {
      localField = null;
    }
    b = localField;
    try
    {
      localField = AccessibleObject.class.getDeclaredField("override");
      c = localField;
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
  }
  
  public void a(AccessibleObject paramAccessibleObject)
  {
    Object localObject = b;
    i = 0;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (c == null) {}
    }
    try
    {
      long l = ((Long)d.getMethod("objectFieldOffset", new Class[] { Field.class }).invoke(b, new Object[] { c })).longValue();
      d.getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE }).invoke(b, new Object[] { paramAccessibleObject, Long.valueOf(l), Boolean.valueOf(true) });
      j = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        j = i;
      }
    }
    if (j == 0) {
      try
      {
        paramAccessibleObject.setAccessible(true);
      }
      catch (SecurityException localSecurityException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Gson couldn't modify fields for ");
        localStringBuilder.append(paramAccessibleObject);
        localStringBuilder.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
        throw new k(localStringBuilder.toString(), localSecurityException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.a0.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */