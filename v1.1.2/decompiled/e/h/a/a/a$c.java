package e.h.a.a;

import android.util.Base64;
import javax.crypto.SecretKey;

public class a$c
{
  public SecretKey a;
  public SecretKey b;
  
  public a$c(SecretKey paramSecretKey1, SecretKey paramSecretKey2)
  {
    a = paramSecretKey1;
    b = paramSecretKey2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (c.class != paramObject.getClass()) {
      return false;
    }
    paramObject = (c)paramObject;
    if (!b.equals(b)) {
      return false;
    }
    return a.equals(a);
  }
  
  public int hashCode()
  {
    int i = a.hashCode();
    return b.hashCode() + (i + 31) * 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Base64.encodeToString(a.getEncoded(), 2));
    localStringBuilder.append(":");
    localStringBuilder.append(Base64.encodeToString(b.getEncoded(), 2));
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     e.h.a.a.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */