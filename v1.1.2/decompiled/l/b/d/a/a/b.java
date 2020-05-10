package l.b.d.a.a;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import l.b.j.f;

public class b
  extends BasicPermission
{
  public final String x;
  public final int y;
  
  public b(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    x = paramString2;
    paramString2 = new StringTokenizer(f.b(paramString2), " ,");
    int i = 0;
    while (paramString2.hasMoreTokens())
    {
      paramString1 = paramString2.nextToken();
      if (paramString1.equals("threadlocalecimplicitlyca")) {
        i |= 0x1;
      } else if (paramString1.equals("ecimplicitlyca")) {
        i |= 0x2;
      } else if (paramString1.equals("threadlocaldhdefaultparams")) {
        i |= 0x4;
      } else if (paramString1.equals("dhdefaultparams")) {
        i |= 0x8;
      } else if (paramString1.equals("acceptableeccurves")) {
        i |= 0x10;
      } else if (paramString1.equals("additionalecparameters")) {
        i |= 0x20;
      } else if (paramString1.equals("all")) {
        i |= 0x3F;
      }
    }
    if (i != 0)
    {
      y = i;
      return;
    }
    throw new IllegalArgumentException("unknown permissions passed to mask");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((y != y) || (!getName().equals(((BasicPermission)paramObject).getName()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getActions()
  {
    return x;
  }
  
  public int hashCode()
  {
    return getName().hashCode() + y;
  }
  
  public boolean implies(Permission paramPermission)
  {
    boolean bool1 = paramPermission instanceof b;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (!getName().equals(paramPermission.getName())) {
      return false;
    }
    paramPermission = (b)paramPermission;
    int i = y;
    int j = y;
    if ((i & j) == j) {
      bool2 = true;
    }
    return bool2;
  }
}

/* Location:
 * Qualified Name:     l.b.d.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */