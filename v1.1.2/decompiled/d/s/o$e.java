package d.s;

import android.os.Bundle;

public final class o$e
  extends o<int[]>
{
  public o$e(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (int[])paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    throw new UnsupportedOperationException("Arrays don't support default values.");
  }
  
  public String a()
  {
    return "integer[]";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putIntArray(paramString, (int[])paramObject);
  }
}

/* Location:
 * Qualified Name:     d.s.o.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */