package e.b.a.a;

import java.io.Serializable;
import java.nio.charset.Charset;

public class g
  implements Serializable
{
  public final int A;
  public final transient Object B;
  public final long x;
  public final long y;
  public final int z;
  
  static
  {
    new g(null, -1L, -1L, -1, -1);
  }
  
  public g(Object paramObject, long paramLong, int paramInt1, int paramInt2)
  {
    B = paramObject;
    x = -1L;
    y = paramLong;
    z = paramInt1;
    A = paramInt2;
  }
  
  public g(Object paramObject, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    B = paramObject;
    x = paramLong1;
    y = paramLong2;
    z = paramInt1;
    A = paramInt2;
  }
  
  public final int a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('"');
    return paramString.length();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof g)) {
      return false;
    }
    paramObject = (g)paramObject;
    Object localObject = B;
    if (localObject == null)
    {
      if (B != null) {
        return false;
      }
    }
    else if (!localObject.equals(B)) {
      return false;
    }
    if ((z != z) || (A != A) || (y != y) || (x != x)) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    Object localObject = B;
    int i;
    if (localObject == null) {
      i = 1;
    } else {
      i = localObject.hashCode();
    }
    return ((i ^ z) + A ^ (int)y) + (int)x;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[Source: ");
    Object localObject1 = B;
    if (localObject1 == null)
    {
      localStringBuilder.append("UNKNOWN");
    }
    else
    {
      if ((localObject1 instanceof Class)) {
        localObject2 = (Class)localObject1;
      } else {
        localObject2 = localObject1.getClass();
      }
      Object localObject3 = ((Class)localObject2).getName();
      if (((String)localObject3).startsWith("java."))
      {
        localObject2 = ((Class)localObject2).getSimpleName();
      }
      else if ((localObject1 instanceof byte[]))
      {
        localObject2 = "byte[]";
      }
      else
      {
        localObject2 = localObject3;
        if ((localObject1 instanceof char[])) {
          localObject2 = "char[]";
        }
      }
      localStringBuilder.append('(');
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(')');
      boolean bool = localObject1 instanceof CharSequence;
      int i = 0;
      Object localObject2 = " chars";
      int j;
      if (bool)
      {
        localObject3 = (CharSequence)localObject1;
        j = ((CharSequence)localObject3).length();
        i = a(localStringBuilder, ((CharSequence)localObject3).subSequence(0, Math.min(j, 500)).toString());
      }
      else
      {
        if (!(localObject1 instanceof char[])) {
          break label265;
        }
        localObject3 = (char[])localObject1;
        j = localObject3.length;
        localObject3 = new String((char[])localObject3, 0, Math.min(j, 500));
        localStringBuilder.append('"');
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append('"');
        i = ((String)localObject3).length();
      }
      i = j - i;
      break label342;
      label265:
      if ((localObject1 instanceof byte[]))
      {
        localObject2 = (byte[])localObject1;
        i = Math.min(localObject2.length, 500);
        localObject3 = new String((byte[])localObject2, 0, i, Charset.forName("UTF-8"));
        localStringBuilder.append('"');
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append('"');
        ((String)localObject3).length();
        i = localObject2.length - i;
        localObject2 = " bytes";
      }
      label342:
      if (i > 0)
      {
        localStringBuilder.append("[truncated ");
        localStringBuilder.append(i);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(']');
      }
    }
    localStringBuilder.append("; line: ");
    localStringBuilder.append(z);
    localStringBuilder.append(", column: ");
    localStringBuilder.append(A);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */