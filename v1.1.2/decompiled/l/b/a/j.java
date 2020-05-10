package l.b.a;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.SimpleTimeZone;

public class j
  extends t
{
  public byte[] x;
  
  public j(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4)
    {
      x = paramArrayOfByte;
      if ((b(0)) && (b(1)) && (b(2)) && (b(3))) {
        return;
      }
      throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
    }
    throw new IllegalArgumentException("GeneralizedTime string too short");
  }
  
  public static j a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof j)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (j)t.a((byte[])paramObject);
          return (j)paramObject;
        }
        catch (Exception paramObject)
        {
          throw new IllegalArgumentException(e.a.a.a.a.a((Exception)paramObject, e.a.a.a.a.a("encoding error in getInstance: ")));
        }
      }
      throw new IllegalArgumentException(e.a.a.a.a.a(paramObject, e.a.a.a.a.a("illegal object in getInstance: ")));
    }
    return (j)paramObject;
  }
  
  public final String a(int paramInt)
  {
    if (paramInt < 10) {
      return e.a.a.a.a.a("0", paramInt);
    }
    return Integer.toString(paramInt);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 24, x);
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof j)) {
      return false;
    }
    return Arrays.equals(x, x);
  }
  
  public final String b(String paramString)
  {
    Object localObject1 = paramString.substring(14);
    for (int i = 1; i < ((String)localObject1).length(); i++)
    {
      j = ((String)localObject1).charAt(i);
      if ((48 > j) || (j > 57)) {
        break;
      }
    }
    int j = i - 1;
    if (j > 3)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 4));
      ((StringBuilder)localObject2).append(((String)localObject1).substring(i));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
    }
    else if (j == 1)
    {
      localObject2 = new StringBuilder();
      e.a.a.a.a.a((String)localObject1, 0, i, (StringBuilder)localObject2, "00");
      ((StringBuilder)localObject2).append(((String)localObject1).substring(i));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
    }
    else
    {
      localObject2 = paramString;
      if (j != 2) {
        break label241;
      }
      localObject2 = new StringBuilder();
      e.a.a.a.a.a((String)localObject1, 0, i, (StringBuilder)localObject2, "0");
      ((StringBuilder)localObject2).append(((String)localObject1).substring(i));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
    }
    ((StringBuilder)localObject1).append(paramString.substring(0, 14));
    ((StringBuilder)localObject1).append((String)localObject2);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    label241:
    return (String)localObject2;
  }
  
  public final boolean b(int paramInt)
  {
    byte[] arrayOfByte = x;
    boolean bool;
    if ((arrayOfByte.length > paramInt) && (arrayOfByte[paramInt] >= 48) && (arrayOfByte[paramInt] <= 57)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int f()
  {
    int i = x.length;
    return d2.a(i) + 1 + i;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public t h()
  {
    return new v0(x);
  }
  
  public int hashCode()
  {
    return l.b.c.e.a.d(x);
  }
  
  public t i()
  {
    return new v0(x);
  }
  
  public final SimpleDateFormat j()
  {
    SimpleDateFormat localSimpleDateFormat;
    if (k()) {
      localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
    } else if (m()) {
      localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
    } else if (l()) {
      localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmz");
    } else {
      localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHz");
    }
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
    return localSimpleDateFormat;
  }
  
  public boolean k()
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = x;
      if (i == arrayOfByte.length) {
        break;
      }
      if ((arrayOfByte[i] == 46) && (i == 14)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean l()
  {
    boolean bool;
    if ((b(10)) && (b(11))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean m()
  {
    boolean bool;
    if ((b(12)) && (b(13))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     l.b.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */