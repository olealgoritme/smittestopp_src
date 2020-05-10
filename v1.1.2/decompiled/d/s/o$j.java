package d.s;

import android.os.Bundle;

public final class o$j
  extends o<Boolean>
{
  public o$j(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (Boolean)paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    if ("true".equals(paramString))
    {
      paramString = Boolean.valueOf(true);
    }
    else
    {
      if (!"false".equals(paramString)) {
        break label33;
      }
      paramString = Boolean.valueOf(false);
    }
    return paramString;
    label33:
    throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
  }
  
  public String a()
  {
    return "boolean";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
  }
}

/* Location:
 * Qualified Name:     d.s.o.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */