package d.s;

import android.os.Bundle;

public final class o$d
  extends o<Integer>
{
  public o$d(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (Integer)paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    throw new UnsupportedOperationException("References don't support parsing string values.");
  }
  
  public String a()
  {
    return "reference";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
  }
}

/* Location:
 * Qualified Name:     base.d.s.o.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */