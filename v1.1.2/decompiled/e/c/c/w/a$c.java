package e.c.c.w;

import e.c.a.a.b.l.c;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class a$c
  implements WildcardType, Serializable
{
  public final Type x;
  public final Type y;
  
  public a$c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
  {
    int i = paramArrayOfType2.length;
    boolean bool1 = true;
    boolean bool2;
    if (i <= 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    c.a(bool2);
    if (paramArrayOfType1.length == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    c.a(bool2);
    if (paramArrayOfType2.length == 1)
    {
      c.a(paramArrayOfType2[0]);
      a.b(paramArrayOfType2[0]);
      if (paramArrayOfType1[0] == Object.class) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      c.a(bool2);
      y = a.a(paramArrayOfType2[0]);
      x = Object.class;
    }
    else
    {
      c.a(paramArrayOfType1[0]);
      a.b(paramArrayOfType1[0]);
      y = null;
      x = a.a(paramArrayOfType1[0]);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof WildcardType)) && (a.a(this, (WildcardType)paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Type[] getLowerBounds()
  {
    Type localType = y;
    Type[] arrayOfType;
    if (localType != null)
    {
      arrayOfType = new Type[1];
      arrayOfType[0] = localType;
    }
    else
    {
      arrayOfType = a.a;
    }
    return arrayOfType;
  }
  
  public Type[] getUpperBounds()
  {
    return new Type[] { x };
  }
  
  public int hashCode()
  {
    Type localType = y;
    int i;
    if (localType != null) {
      i = localType.hashCode() + 31;
    } else {
      i = 1;
    }
    return i ^ x.hashCode() + 31;
  }
  
  public String toString()
  {
    if (y != null)
    {
      localStringBuilder = e.a.a.a.a.a("? super ");
      localStringBuilder.append(a.d(y));
      return localStringBuilder.toString();
    }
    if (x == Object.class) {
      return "?";
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("? extends ");
    localStringBuilder.append(a.d(x));
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */