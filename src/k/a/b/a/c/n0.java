package k.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class n0
  extends c<String>
{
  public static final r.b<String> c = new n0.a();
  public final n0.d a;
  public final n0.d b;
  
  public n0(x paramx, r paramr)
  {
    a = new n0.b(this, paramx, paramr);
    b = new n0.c(this, paramx, paramr);
    c.put(String.class, this);
    paramr.a(this);
  }
  
  public static int a(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; (j < i) && (paramString.charAt(j) < ''); j++) {}
    int k = i;
    if (j < i)
    {
      for (int m = i; j < i; m = k)
      {
        int n = paramString.charAt(j);
        int i1 = j;
        k = m;
        if ((0xFF80 & n) != 0)
        {
          m++;
          i1 = j;
          k = m;
          if ((0xF800 & n) != 0)
          {
            m++;
            i1 = j;
            k = m;
            if ((n & 0xD800) == 55296)
            {
              i1 = j;
              k = m;
              if (n < 56320)
              {
                i1 = j + 1;
                k = m;
              }
            }
          }
        }
        j = i1 + 1;
      }
      k = m;
    }
    return k;
  }
  
  public Class<String> a()
  {
    return String.class;
  }
  
  public j0 a(Object paramObject)
  {
    String str = (String)paramObject;
    int i = a(str);
    if (i <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    ((n0.d)paramObject).a(str, i);
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    String str = (String)paramObject;
    int i = a(str);
    if (i <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    ((n0.d)paramObject).a(str, i);
    return (r0)paramObject;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<n0.d> i()
  {
    return Arrays.asList(new n0.d[] { b, a });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.n0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */