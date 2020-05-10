package d.s;

import android.os.Bundle;

public final class o$f
  extends o<Long>
{
  public o$f(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (Long)paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith("L")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    if (str.startsWith("0x")) {
      paramString = Long.valueOf(Long.parseLong(str.substring(2), 16));
    } else {
      paramString = Long.valueOf(Long.parseLong(str));
    }
    return paramString;
  }
  
  public String a()
  {
    return "long";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putLong(paramString, ((Long)paramObject).longValue());
  }
}

/* Location:
 * Qualified Name:     base.d.s.o.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */