package d.s;

import android.os.Bundle;
import java.io.Serializable;

public class o$p<D extends Serializable>
  extends o<D>
{
  public final Class<D> m;
  
  public o$p(Class<D> paramClass)
  {
    super(true);
    if (Serializable.class.isAssignableFrom(paramClass))
    {
      if (!paramClass.isEnum())
      {
        m = paramClass;
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" is an Enum. You should use EnumType instead.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass);
    localStringBuilder.append(" does not implement Serializable.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public o$p(boolean paramBoolean, Class<D> paramClass)
  {
    super(paramBoolean);
    if (Serializable.class.isAssignableFrom(paramClass))
    {
      m = paramClass;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass);
    localStringBuilder.append(" does not implement Serializable.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public D a(String paramString)
  {
    throw new UnsupportedOperationException("Serializables don't support default values.");
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (Serializable)paramBundle.get(paramString);
  }
  
  public String a()
  {
    return m.getName();
  }
  
  public void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramObject = (Serializable)paramObject;
    m.cast(paramObject);
    paramBundle.putSerializable(paramString, (Serializable)paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof p)) {
      return false;
    }
    paramObject = (p)paramObject;
    return m.equals(m);
  }
  
  public int hashCode()
  {
    return m.hashCode();
  }
}

/* Location:
 * Qualified Name:     base.d.s.o.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */