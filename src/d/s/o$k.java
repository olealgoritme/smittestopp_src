package d.s;

import android.os.Bundle;

public final class o$k
  extends o<boolean[]>
{
  public o$k(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (boolean[])paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    throw new UnsupportedOperationException("Arrays don't support default values.");
  }
  
  public String a()
  {
    return "boolean[]";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putBooleanArray(paramString, (boolean[])paramObject);
  }
}

/* Location:
 * Qualified Name:     base.d.s.o.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */