package l.e.a;

import java.util.Arrays;

public final class h
{
  public final String a;
  public final String b;
  public final o c;
  public final Object[] d;
  
  public h(String paramString1, String paramString2, o paramo, Object... paramVarArgs)
  {
    a = paramString1;
    b = paramString2;
    c = paramo;
    d = paramVarArgs;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      return false;
    }
    paramObject = (h)paramObject;
    if ((!a.equals(a)) || (!b.equals(b)) || (!c.equals(c)) || (!Arrays.equals(d, d))) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return a.hashCode() ^ Integer.rotateLeft(b.hashCode(), 8) ^ Integer.rotateLeft(c.hashCode(), 16) ^ Integer.rotateLeft(Arrays.hashCode(d), 24);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(" : ");
    localStringBuilder.append(b);
    localStringBuilder.append(' ');
    localStringBuilder.append(c);
    localStringBuilder.append(' ');
    localStringBuilder.append(Arrays.toString(d));
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.e.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */