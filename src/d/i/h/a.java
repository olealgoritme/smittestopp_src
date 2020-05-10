package d.i.h;

import android.util.Log;
import java.io.Writer;

public class a
  extends Writer
{
  public final String x;
  public StringBuilder y = new StringBuilder(128);
  
  public a(String paramString)
  {
    x = paramString;
  }
  
  public final void a()
  {
    if (y.length() > 0)
    {
      Log.d(x, y.toString());
      StringBuilder localStringBuilder = y;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public void close()
  {
    a();
  }
  
  public void flush()
  {
    a();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    for (int i = 0; i < paramInt2; i++)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        a();
      } else {
        y.append(c);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.i.h.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */