package d.s;

import android.os.Bundle;

public final class o$b
  extends o<String[]>
{
  public o$b(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (String[])paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    throw new UnsupportedOperationException("Arrays don't support default values.");
  }
  
  public String a()
  {
    return "string[]";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putStringArray(paramString, (String[])paramObject);
  }
}

/* Location:
 * Qualified Name:     d.s.o.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */