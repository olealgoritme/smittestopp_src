package e.f.a;

import android.content.Context;
import java.io.File;

public class b
{
  public final Context a;
  public boolean b = true;
  
  public b(Context paramContext)
  {
    a = paramContext;
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = a.a();
    int i = arrayOfString.length;
    int j = 0;
    boolean bool = false;
    while (j < i)
    {
      Object localObject = arrayOfString[j];
      String str = e.a.a.a.a.b((String)localObject, paramString);
      if (new File((String)localObject, paramString).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" binary detected!");
        e.f.a.c.a.b(((StringBuilder)localObject).toString());
        bool = true;
      }
      j++;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     e.f.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */