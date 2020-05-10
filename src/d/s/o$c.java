package d.s;

import android.os.Bundle;

public final class o$c
  extends o<Integer>
{
  public o$c(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (Integer)paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    if (paramString.startsWith("0x")) {
      paramString = Integer.valueOf(Integer.parseInt(paramString.substring(2), 16));
    } else {
      paramString = Integer.valueOf(Integer.parseInt(paramString));
    }
    return paramString;
  }
  
  public String a()
  {
    return "integer";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
  }
}

/* Location:
 * Qualified Name:     base.d.s.o.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */