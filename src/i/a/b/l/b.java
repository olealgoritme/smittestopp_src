package i.a.b.l;

import i.a.b.n.f;
import java.math.BigDecimal;

public abstract class b
{
  public static boolean[] r;
  public static boolean[] s;
  public static boolean[] t;
  public static boolean[] u;
  public static boolean[] v;
  public char a;
  public String b;
  public final b.a c = new b.a(15);
  public Object d;
  public String e;
  public int f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final boolean j;
  public final boolean k;
  public final boolean l;
  public final boolean m;
  public final boolean n;
  public final boolean o;
  public final boolean p;
  public final boolean q;
  
  static
  {
    boolean[] arrayOfBoolean1 = new boolean[126];
    r = arrayOfBoolean1;
    boolean[] arrayOfBoolean2 = new boolean[126];
    s = arrayOfBoolean2;
    boolean[] arrayOfBoolean3 = new boolean[126];
    t = arrayOfBoolean3;
    boolean[] arrayOfBoolean4 = new boolean[126];
    u = arrayOfBoolean4;
    boolean[] arrayOfBoolean5 = new boolean[126];
    v = arrayOfBoolean5;
    arrayOfBoolean3[26] = true;
    arrayOfBoolean3[58] = true;
    arrayOfBoolean4[26] = true;
    arrayOfBoolean4[125] = true;
    arrayOfBoolean4[44] = true;
    arrayOfBoolean2[26] = true;
    arrayOfBoolean2[93] = true;
    arrayOfBoolean2[44] = true;
    arrayOfBoolean5[26] = true;
    arrayOfBoolean1[58] = true;
    arrayOfBoolean1[44] = true;
    arrayOfBoolean1[26] = true;
    arrayOfBoolean1[125] = true;
    arrayOfBoolean1[93] = true;
  }
  
  public b(int paramInt)
  {
    boolean bool1 = false;
    if ((paramInt & 0x4) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    h = bool2;
    if ((paramInt & 0x2) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    i = bool2;
    if ((paramInt & 0x1) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    j = bool2;
    if ((paramInt & 0x8) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n = bool2;
    if ((paramInt & 0x10) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    p = bool2;
    if ((paramInt & 0x20) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g = bool2;
    if ((paramInt & 0x40) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    k = bool2;
    if ((paramInt & 0x80) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    o = bool2;
    if ((paramInt & 0x300) != 768) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    l = bool2;
    if ((paramInt & 0x200) == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    m = bool2;
    boolean bool2 = bool1;
    if ((paramInt & 0x400) > 0) {
      bool2 = true;
    }
    q = bool2;
  }
  
  public char a(int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    for (;;)
    {
      if (i1 >= paramInt) {
        return (char)i2;
      }
      c();
      int i3 = a;
      if ((i3 <= 57) && (i3 >= 48))
      {
        i3 -= 48;
        i2 = i3 + i2 * 16;
      }
      else
      {
        i3 = a;
        if ((i3 <= 70) && (i3 >= 65)) {
          i3 -= 65;
        }
        for (;;)
        {
          i3 += 10;
          break;
          i3 = a;
          if ((i3 < 97) || (i3 > 102)) {
            break label111;
          }
          i3 -= 97;
        }
      }
      i1++;
    }
    label111:
    if (a == '\032') {
      throw new e(f, 3, "EOF");
    }
    throw new e(f, 4, Character.valueOf(a));
  }
  
  public <T> T a(f<T> paramf)
  {
    Object localObject = paramf.a();
    if (a == '[')
    {
      c();
      if ((a == ',') && (!k)) {
        throw new e(f, 0, Character.valueOf(a));
      }
      int i1 = 0;
      for (;;)
      {
        int i2 = a;
        if ((i2 != 9) && (i2 != 10) && (i2 != 13))
        {
          if (i2 != 26)
          {
            if (i2 == 32) {
              break label268;
            }
            if (i2 != 44)
            {
              if (i2 != 58)
              {
                if (i2 != 93)
                {
                  if (i2 == 125) {
                    break label188;
                  }
                  paramf.a(localObject, a(paramf, s));
                  break;
                }
                if ((i1 != 0) && (!k)) {
                  throw new e(f, 0, Character.valueOf(a));
                }
                c();
                return (T)paramf.a(localObject);
              }
              label188:
              throw new e(f, 0, Character.valueOf(a));
            }
            if ((i1 != 0) && (!k)) {
              throw new e(f, 0, Character.valueOf(a));
            }
            c();
            i1 = 1;
            continue;
          }
          throw new e(f - 1, 3, "EOF");
        }
        label268:
        c();
      }
    }
    throw new RuntimeException("Internal Error");
  }
  
  public Object a(f<?> paramf, boolean[] paramArrayOfBoolean)
  {
    for (;;)
    {
      int i1 = a;
      if ((i1 != 9) && (i1 != 10)) {
        switch (i1)
        {
        default: 
          switch (i1)
          {
          default: 
            paramf = (c)this;
            i1 = f;
            paramf.b(paramArrayOfBoolean);
            paramf.a(i1, f);
            if (i) {
              return e;
            }
            throw new e(f, 1, e);
          }
        case 123: 
          return c(paramf.b(b));
        case 116: 
          paramf = (c)this;
          i1 = f;
          paramf.b(paramArrayOfBoolean);
          paramf.a(i1, f);
          if ("true".equals(e)) {
            return Boolean.TRUE;
          }
          if (i) {
            return e;
          }
          throw new e(f, 1, e);
        case 110: 
          paramf = (c)this;
          i1 = f;
          paramf.b(paramArrayOfBoolean);
          paramf.a(i1, f);
          if ("null".equals(e)) {
            return null;
          }
          if (i) {
            return e;
          }
          throw new e(f, 1, e);
        case 102: 
          paramf = (c)this;
          i1 = f;
          paramf.b(paramArrayOfBoolean);
          paramf.a(i1, f);
          if ("false".equals(e)) {
            return Boolean.FALSE;
          }
          if (i) {
            return e;
          }
          throw new e(f, 1, e);
        case 93: 
        case 125: 
          throw new e(f, 0, Character.valueOf(a));
        case 91: 
          return a(paramf.a(b));
        case 78: 
          paramf = (c)this;
          i1 = f;
          paramf.b(paramArrayOfBoolean);
          paramf.a(i1, f);
          if (h)
          {
            if ("NaN".equals(e)) {
              return Float.valueOf(NaN.0F);
            }
            if (i) {
              return e;
            }
            throw new e(f, 1, e);
          }
          throw new e(f, 1, e);
        case 45: 
          return a(paramArrayOfBoolean);
        case 34: 
        case 39: 
          e();
          return e;
        }
      }
      c();
    }
  }
  
  public abstract Object a(boolean[] paramArrayOfBoolean);
  
  public void a()
  {
    int i1 = e.length();
    if (i1 == 1) {
      return;
    }
    if (i1 == 2)
    {
      if (!e.equals("00")) {
        return;
      }
      throw new e(f, 6, e);
    }
    int i2 = e.charAt(0);
    i1 = e.charAt(1);
    if (i2 == 45)
    {
      i2 = e.charAt(2);
      if ((i1 == 48) && (i2 >= 48) && (i2 <= 57)) {
        throw new e(f, 6, e);
      }
      return;
    }
    if ((i2 == 48) && (i1 >= 48) && (i1 <= 57)) {
      throw new e(f, 6, e);
    }
  }
  
  public Number b()
  {
    if (!g) {
      a();
    }
    if (!o) {
      return Float.valueOf(Float.parseFloat(e));
    }
    if (e.length() > 18) {
      return new BigDecimal(e);
    }
    return Double.valueOf(Double.parseDouble(e));
  }
  
  public <T> T b(f<T> paramf)
  {
    for (;;)
    {
      int i1 = a;
      if ((i1 != 9) && (i1 != 10))
      {
        Object localObject1;
        Object localObject2;
        switch (i1)
        {
        default: 
          switch (i1)
          {
          default: 
            localObject1 = v;
            localObject2 = (c)this;
            i1 = f;
            ((b)localObject2).b((boolean[])localObject1);
            ((c)localObject2).a(i1, f);
            if (i) {
              return (T)paramf.a(e);
            }
            throw new e(f, 1, e);
          }
        case 123: 
          return (T)c(paramf);
        case 116: 
          localObject1 = v;
          localObject2 = (c)this;
          i1 = f;
          ((b)localObject2).b((boolean[])localObject1);
          ((c)localObject2).a(i1, f);
          if ("true".equals(e)) {
            return (T)paramf.a(Boolean.TRUE);
          }
          if (i) {
            return (T)paramf.a(e);
          }
          throw new e(f, 1, e);
        case 110: 
          localObject1 = v;
          localObject2 = (c)this;
          i1 = f;
          ((b)localObject2).b((boolean[])localObject1);
          ((c)localObject2).a(i1, f);
          if ("null".equals(e)) {
            return null;
          }
          if (i) {
            return (T)paramf.a(e);
          }
          throw new e(f, 1, e);
        case 102: 
          localObject2 = v;
          localObject1 = (c)this;
          i1 = f;
          ((b)localObject1).b((boolean[])localObject2);
          ((c)localObject1).a(i1, f);
          if ("false".equals(e)) {
            return (T)paramf.a(Boolean.FALSE);
          }
          if (i) {
            return (T)paramf.a(e);
          }
          throw new e(f, 1, e);
        case 93: 
        case 125: 
          throw new e(f, 0, Character.valueOf(a));
        case 91: 
          return (T)a(paramf);
        case 78: 
          localObject2 = v;
          localObject1 = (c)this;
          i1 = f;
          ((b)localObject1).b((boolean[])localObject2);
          ((c)localObject1).a(i1, f);
          if (h)
          {
            if ("NaN".equals(e)) {
              return (T)paramf.a(Float.valueOf(NaN.0F));
            }
            if (i) {
              return (T)paramf.a(e);
            }
            throw new e(f, 1, e);
          }
          throw new e(f, 1, e);
        case 45: 
          localObject2 = a(v);
          d = localObject2;
          return (T)paramf.a(localObject2);
        case 34: 
        case 39: 
          e();
          return (T)paramf.a(e);
        }
      }
      c();
    }
  }
  
  public void b(boolean[] paramArrayOfBoolean)
  {
    for (;;)
    {
      int i1 = a;
      if ((i1 == 26) || ((i1 >= 0) && (i1 < 126) && (paramArrayOfBoolean[i1] != 0))) {
        break;
      }
      d();
    }
  }
  
  public <T> T c(f<T> paramf)
  {
    if (a == '{')
    {
      Object localObject1 = paramf.b();
      for (int i1 = 0;; i1 = 1)
      {
        int i2;
        do
        {
          c();
          i2 = a;
        } while ((i2 == 9) || (i2 == 10) || (i2 == 13) || (i2 == 32));
        if (i2 != 44)
        {
          if ((i2 != 58) && (i2 != 91) && (i2 != 93) && (i2 != 123))
          {
            if (i2 != 125)
            {
              if ((i2 != 34) && (i2 != 39))
              {
                localObject2 = t;
                localObject3 = (c)this;
                i1 = f;
                ((b)localObject3).b((boolean[])localObject2);
                ((c)localObject3).a(i1, f);
                if (!i) {
                  throw new e(f, 1, e);
                }
              }
              else
              {
                e();
              }
              Object localObject2 = e;
              g();
              i1 = a;
              if (i1 != 58)
              {
                if (i1 == 26) {
                  throw new e(f - 1, 3, null);
                }
                throw new e(f - 1, 0, Character.valueOf(a));
              }
              Object localObject3 = (d)this;
              i1 = f + 1;
              f = i1;
              if (i1 < w)
              {
                a = x.charAt(i1);
                b = ((String)localObject2);
                paramf.a(localObject1, (String)localObject2, a(paramf, u));
                b = null;
                g();
                i1 = a;
                if (i1 == 125)
                {
                  c();
                  return (T)paramf.a(localObject1);
                }
                if (i1 != 26)
                {
                  if (i1 != 44) {
                    throw new e(f - 1, 1, Character.valueOf(a));
                  }
                }
                else {
                  throw new e(f - 1, 3, null);
                }
              }
              else
              {
                a = ((char)26);
                throw new e(f - 1, 3, "EOF");
              }
            }
            else
            {
              if ((i1 != 0) && (!k)) {
                throw new e(f, 0, Character.valueOf(a));
              }
              c();
              return (T)paramf.a(localObject1);
            }
          }
          else {
            throw new e(f, 0, Character.valueOf(a));
          }
        }
        else if ((i1 != 0) && (!k)) {
          throw new e(f, 0, Character.valueOf(a));
        }
      }
    }
    throw new RuntimeException("Internal Error");
  }
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public void f()
  {
    for (;;)
    {
      int i1 = a;
      if ((i1 < 48) || (i1 > 57)) {
        break;
      }
      d();
    }
  }
  
  public void g()
  {
    for (;;)
    {
      int i1 = a;
      if ((i1 > 32) || (i1 == 26)) {
        break;
      }
      d();
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.l.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */