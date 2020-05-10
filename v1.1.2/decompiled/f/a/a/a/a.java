package f.a.a.a;

import android.os.Build;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

public final class a
{
  public static final byte[] a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = Build.FINGERPRINT;
    if (localObject != null) {
      localStringBuilder.append((String)localObject);
    }
    localObject = null;
    try
    {
      String str = (String)Build.class.getField("SERIAL").get(null);
      localObject = str;
    }
    catch (Exception localException) {}
    if (localObject != null) {
      localStringBuilder.append((String)localObject);
    }
    try
    {
      localObject = localStringBuilder.toString().getBytes("UTF-8");
      a = (byte[])localObject;
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 encoding not supported");
    }
  }
  
  public static void a() {}
}

/* Location:
 * Qualified Name:     f.a.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */