package k.b.f.a;

public abstract class d
{
  public static final c[] e = new c[0];
  public b a;
  
  public d(b paramb, c paramc1, c paramc2) {}
  
  public d(b paramb, c paramc1, c paramc2, c[] paramArrayOfc)
  {
    a = paramb;
    b = paramc1;
    c = paramc2;
    d = paramArrayOfc;
  }
  
  public int a()
  {
    b localb = a;
    int i;
    if (localb == null) {
      i = 0;
    } else {
      i = d;
    }
    return i;
  }
  
  public c a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = d;
      if (paramInt < localObject.length) {
        return localObject[paramInt];
      }
    }
    Object localObject = null;
    return (c)localObject;
  }
  
  public d a(c paramc)
  {
    int i = a();
    if (i != 1) {
      if ((i != 2) && (i != 3) && (i != 4))
      {
        if (i != 6) {
          throw new IllegalStateException("not a projective coordinate system");
        }
      }
      else
      {
        c localc = paramc.g();
        paramc = localc.c(paramc);
        return a.a(b.c(localc), c.c(paramc));
      }
    }
    return a.a(b.c(paramc), c.c(paramc));
  }
  
  public c b()
  {
    return c;
  }
  
  public boolean c()
  {
    Object localObject = b;
    boolean bool1 = false;
    boolean bool2;
    if ((localObject != null) && (c != null))
    {
      localObject = d;
      bool2 = bool1;
      if (localObject.length > 0)
      {
        bool2 = bool1;
        if (!localObject[0].e()) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public d d()
  {
    if (c()) {
      return this;
    }
    int i = a();
    if ((i != 0) && (i != 5))
    {
      c localc = a(0);
      if (localc.d()) {
        return this;
      }
      return a(localc.c());
    }
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (paramObject == this) {
      return true;
    }
    boolean bool2 = paramObject instanceof d;
    boolean bool3 = false;
    if (!bool2) {
      return false;
    }
    Object localObject1 = (d)paramObject;
    if (localObject1 != null)
    {
      paramObject = a;
      Object localObject2 = a;
      int i;
      if (paramObject == null) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (localObject2 == null) {
        j = 1;
      } else {
        j = 0;
      }
      boolean bool4 = c();
      bool2 = ((d)localObject1).c();
      if ((!bool4) && (!bool2))
      {
        if ((i == 0) || (j == 0))
        {
          if (i != 0) {
            localObject1 = ((d)localObject1).d();
          }
        }
        else
        {
          paramObject = this;
          break label556;
        }
        if (j != 0)
        {
          paramObject = d();
        }
        else
        {
          if (!((b)paramObject).a((b)localObject2)) {
            break label635;
          }
          localObject2 = new d[2];
          localObject2[0] = this;
          localObject2[1] = ((b)paramObject).a((d)localObject1);
          for (i = 0; i < 2; i++)
          {
            localObject1 = localObject2[(0 + i)];
            if ((localObject1 != null) && (paramObject != a)) {
              throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
          }
          i = d;
          if ((i != 0) && (i != 5))
          {
            c[] arrayOfc1 = new c[2];
            localObject1 = new int[2];
            j = 0;
            int m;
            for (i = 0; j < 2; i = m)
            {
              int k = 0 + j;
              paramObject = localObject2[k];
              m = i;
              if (paramObject != null)
              {
                m = ((d)paramObject).a();
                int n;
                if ((m != 0) && (m != 5) && (!((d)paramObject).c()) && (!d[0].d())) {
                  n = 0;
                } else {
                  n = 1;
                }
                m = i;
                if (n == 0)
                {
                  arrayOfc1[i] = ((d)paramObject).a(0);
                  localObject1[i] = k;
                  m = i + 1;
                }
              }
              j++;
            }
            if (i != 0)
            {
              c[] arrayOfc2 = new c[i];
              arrayOfc2[0] = arrayOfc1[0];
              j = 0;
              for (;;)
              {
                j++;
                if (j >= i) {
                  break;
                }
                arrayOfc2[j] = arrayOfc2[(j - 1)].c(arrayOfc1[(0 + j)]);
              }
              j--;
              paramObject = arrayOfc2[j].c();
              while (j > 0)
              {
                m = j - 1;
                j += 0;
                c localc = arrayOfc1[j];
                arrayOfc1[j] = arrayOfc2[m].c((c)paramObject);
                paramObject = ((c)paramObject).c(localc);
                j = m;
              }
              arrayOfc1[0] = paramObject;
              for (j = 0; j < i; j++)
              {
                m = localObject1[j];
                localObject2[m] = localObject2[m].a(arrayOfc1[j]);
              }
            }
          }
          paramObject = localObject2[0];
          localObject1 = localObject2[1];
        }
        label556:
        if ((b.equals(b)) && (((d)paramObject).b().equals(((d)localObject1).b())))
        {
          bool3 = bool1;
          break label635;
        }
      }
      else if ((bool4) && (bool2))
      {
        bool3 = bool1;
        if (i != 0) {
          break label635;
        }
        bool3 = bool1;
        if (j != 0) {
          break label635;
        }
        if (((b)paramObject).a((b)localObject2))
        {
          bool3 = bool1;
          break label635;
        }
      }
      bool3 = false;
    }
    label635:
    return bool3;
  }
  
  public int hashCode()
  {
    Object localObject = a;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((b)localObject).hashCode();
    }
    int j = i;
    if (!c())
    {
      localObject = d();
      j = i ^ b.hashCode() * 17 ^ ((d)localObject).b().hashCode() * 257;
    }
    return j;
  }
  
  public String toString()
  {
    if (c()) {
      return "INF";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('(');
    localStringBuffer.append(b);
    localStringBuffer.append(',');
    localStringBuffer.append(c);
    for (int i = 0; i < d.length; i++)
    {
      localStringBuffer.append(',');
      localStringBuffer.append(d[i]);
    }
    localStringBuffer.append(')');
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */