package d.s;

import android.os.Bundle;

public final class o$h
  extends o<Float>
{
  public o$h(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (Float)paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    return Float.valueOf(Float.parseFloat(paramString));
  }
  
  public String a()
  {
    return "float";
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
  }
}

/* Location:
 * Qualified Name:     d.s.o.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */