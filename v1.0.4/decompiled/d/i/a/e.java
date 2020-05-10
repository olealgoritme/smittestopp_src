package d.i.a;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class e
{
  public final Bundle a;
  public IconCompat b;
  public final j[] c;
  public final j[] d;
  public boolean e;
  public boolean f = true;
  public final int g;
  public final boolean h;
  @Deprecated
  public int i;
  public CharSequence j;
  public PendingIntent k;
  
  public e(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    b = localIconCompat;
    if (localIconCompat != null)
    {
      int m = a;
      paramInt = -1;
      if (m == -1)
      {
        m = Build.VERSION.SDK_INT;
        if (m >= 23)
        {
          Icon localIcon = (Icon)b;
          if (m >= 28)
          {
            paramInt = localIcon.getType();
            break label273;
          }
          try
          {
            m = ((Integer)localIcon.getClass().getMethod("getType", new Class[0]).invoke(localIcon, new Object[0])).intValue();
            paramInt = m;
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unable to get icon type ");
            localStringBuilder.append(localIcon);
            Log.e("IconCompat", localStringBuilder.toString(), localNoSuchMethodException);
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unable to get icon type ");
            localStringBuilder.append(localIcon);
            Log.e("IconCompat", localStringBuilder.toString(), localInvocationTargetException);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unable to get icon type ");
            localStringBuilder.append(localIcon);
            Log.e("IconCompat", localStringBuilder.toString(), localIllegalAccessException);
          }
        }
      }
      paramInt = a;
      label273:
      if (paramInt == 2) {
        i = localIconCompat.a();
      }
    }
    j = g.c(paramCharSequence);
    k = paramPendingIntent;
    a = localBundle;
    c = null;
    d = null;
    e = true;
    g = 0;
    f = true;
    h = false;
  }
}

/* Location:
 * Qualified Name:     base.d.i.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */