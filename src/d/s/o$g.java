package d.s;

import android.os.Bundle;

public final class o$g
  extends o<long[]>
{
  public o$g(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (long[])paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    throw new UnsupportedOperationException("Arrays don't support default values.");
  }
  
  public String a()
  {
    return "long[]";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putLongArray(paramString, (long[])paramObject);
  }
}

/* Location:
 * Qualified Name:     base.d.s.o.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */