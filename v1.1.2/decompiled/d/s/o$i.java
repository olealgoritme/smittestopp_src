package d.s;

import android.os.Bundle;

public final class o$i
  extends o<float[]>
{
  public o$i(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (float[])paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    throw new UnsupportedOperationException("Arrays don't support default values.");
  }
  
  public String a()
  {
    return "float[]";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putFloatArray(paramString, (float[])paramObject);
  }
}

/* Location:
 * Qualified Name:     d.s.o.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */