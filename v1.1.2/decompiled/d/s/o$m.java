package d.s;

import android.os.Bundle;
import android.os.Parcelable;

public final class o$m<D extends Parcelable>
  extends o<D[]>
{
  public final Class<D[]> m;
  
  public o$m(Class<D> paramClass)
  {
    super(true);
    if (Parcelable.class.isAssignableFrom(paramClass)) {
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
    localStringBuilder.append(" does not implement Parcelable.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Object a(Bundle paramBundle, String paramString)
  {
    return (Parcelable[])paramBundle.get(paramString);
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
    paramObject = (Parcelable[])paramObject;
    m.cast(paramObject);
    paramBundle.putParcelableArray(paramString, (Parcelable[])paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (m.class == paramObject.getClass()))
    {
      paramObject = (m)paramObject;
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
 * Qualified Name:     d.s.o.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */