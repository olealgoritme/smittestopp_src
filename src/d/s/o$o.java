package d.s;

import android.os.Bundle;
import java.io.Serializable;

public final class o$o<D extends Serializable>
  extends o<D[]>
{
  public final Class<D[]> m;
  
  public o$o(Class<D> paramClass)
  {
    super(true);
    if (Serializable.class.isAssignableFrom(paramClass)) {
      try
      {
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("[L");
        localStringBuilder.append(paramClass.getName());
        localStringBuilder.append(";");
        paramClass = Class.forName(localStringBuilder.toString());
        m = paramClass;
        return;
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new RuntimeException(paramClass);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass);
    localStringBuilder.append(" does not implement Serializable.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (Serializable[])paramBundle.get(paramString);
  }
  
  public Object a(String paramString)
  {
    throw new UnsupportedOperationException("Arrays don't support default values.");
  }
  
  public String a()
  {
    return m.getName();
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramObject = (Serializable[])paramObject;
    m.cast(paramObject);
    paramBundle.putSerializable(paramString, (Serializable)paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (o.class == paramObject.getClass()))
    {
      paramObject = (o)paramObject;
      return m.equals(m);
    }
    return false;
  }
  
  public int hashCode()
  {
    return m.hashCode();
  }
}

/* Location:
 * Qualified Name:     base.d.s.o.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */