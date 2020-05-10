package d.s;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

public final class o$n<D>
  extends o<D>
{
  public final Class<D> m;
  
  public o$n(Class<D> paramClass)
  {
    super(true);
    if ((!Parcelable.class.isAssignableFrom(paramClass)) && (!Serializable.class.isAssignableFrom(paramClass)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Parcelable or Serializable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    m = paramClass;
  }
  
  public D a(Bundle paramBundle, String paramString)
  {
    return (D)paramBundle.get(paramString);
  }
  
  public D a(String paramString)
  {
    throw new UnsupportedOperationException("Parcelables don't support default values.");
  }
  
  public String a()
  {
    return m.getName();
  }
  
  public void a(Bundle paramBundle, String paramString, D paramD)
  {
    m.cast(paramD);
    if ((paramD != null) && (!(paramD instanceof Parcelable)))
    {
      if ((paramD instanceof Serializable)) {
        paramBundle.putSerializable(paramString, (Serializable)paramD);
      }
    }
    else {
      paramBundle.putParcelable(paramString, (Parcelable)paramD);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (n.class == paramObject.getClass()))
    {
      paramObject = (n)paramObject;
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
 * Qualified Name:     d.s.o.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */