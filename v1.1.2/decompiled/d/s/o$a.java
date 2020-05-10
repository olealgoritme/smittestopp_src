package d.s;

import android.os.Bundle;

public final class o$a
  extends o<String>
{
  public o$a(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (String)paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    return paramString;
  }
  
  public String a()
  {
    return "string";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putString(paramString, (String)paramObject);
  }
}

/* Location:
 * Qualified Name:     d.s.o.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */