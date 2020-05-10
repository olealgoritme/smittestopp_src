package l.e.a;

public final class t
  extends s
{
  public static final int[] c0 = { 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0 };
  public final int A;
  public a B;
  public a C;
  public int D;
  public a[] E;
  public int F;
  public a[] G;
  public a H;
  public a I;
  public c J;
  public int K;
  public c L;
  public b M;
  public final int N;
  public q O;
  public q P;
  public q Q;
  public int R;
  public int S;
  public int T;
  public int U;
  public int[] V;
  public int[] W;
  public boolean X;
  public boolean Y;
  public int Z;
  public int a0;
  public int b0;
  public final x c;
  public final int d;
  public final int e;
  public final String f;
  public final int g;
  public final String h;
  public int i;
  public int j;
  public final c k = new c();
  public p l;
  public p m;
  public int n;
  public c o;
  public int p;
  public c q;
  public int r;
  public c s;
  public int t;
  public c u;
  public a v;
  public a w;
  public b x;
  public final int y;
  public final int[] z;
  
  public t(x paramx, int paramInt1, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt2)
  {
    super(458752);
    c = paramx;
    int i1;
    if ("<init>".equals(paramString1)) {
      i1 = 0x40000 | paramInt1;
    } else {
      i1 = paramInt1;
    }
    d = i1;
    e = paramx.c(paramString1);
    f = paramString1;
    g = paramx.c(paramString2);
    h = paramString2;
    int i2 = 0;
    if (paramString3 == null) {
      i1 = 0;
    } else {
      i1 = paramx.c(paramString3);
    }
    A = i1;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      i1 = paramArrayOfString.length;
      y = i1;
      z = new int[i1];
      i1 = i2;
    }
    while (i1 < y)
    {
      z[i1] = aa;
      i1++;
      continue;
      y = 0;
      z = null;
    }
    N = paramInt2;
    if (paramInt2 != 0)
    {
      i1 = y.b(paramString2) >> 2;
      paramInt2 = i1;
      if ((paramInt1 & 0x8) != 0) {
        paramInt2 = i1 - 1;
      }
      j = paramInt2;
      T = paramInt2;
      paramx = new q();
      O = paramx;
      a(paramx);
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt2 + 3 + paramInt3;
    int[] arrayOfInt = W;
    if ((arrayOfInt == null) || (arrayOfInt.length < i1)) {
      W = new int[i1];
    }
    arrayOfInt = W;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    arrayOfInt[2] = paramInt3;
    return 3;
  }
  
  public a a(int paramInt, z paramz, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramz = a.a(c, paramInt & 0xFF0000FF | Z << 8, paramz, paramString, v);
      v = paramz;
      return paramz;
    }
    paramz = a.a(c, paramInt & 0xFF0000FF | Z << 8, paramz, paramString, w);
    w = paramz;
    return paramz;
  }
  
  public a a(int paramInt, z paramz, q[] paramArrayOfq1, q[] paramArrayOfq2, int[] paramArrayOfInt, String paramString, boolean paramBoolean)
  {
    c localc = new c();
    localc.b(paramInt >>> 24);
    localc.d(paramArrayOfq1.length);
    for (paramInt = 0; paramInt < paramArrayOfq1.length; paramInt++)
    {
      localc.d(d);
      localc.d(d - d);
      localc.d(paramArrayOfInt[paramInt]);
    }
    z.a(paramz, localc);
    localc.d(c.c(paramString));
    localc.d(0);
    if (paramBoolean)
    {
      paramz = new a(c, true, localc, v);
      v = paramz;
      return paramz;
    }
    paramz = new a(c, true, localc, w);
    w = paramz;
    return paramz;
  }
  
  public a a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramString = a.a(c, paramString, B);
      B = paramString;
      return paramString;
    }
    paramString = a.a(c, paramString, C);
    C = paramString;
    return paramString;
  }
  
  public final void a()
  {
    int i1 = N;
    if (i1 == 4)
    {
      q localq = new q();
      j = new n(localq);
      c localc = k;
      localq.a(a, b);
      P.k = localq;
      P = localq;
      Q = null;
    }
    else if (i1 == 1)
    {
      Q.h = ((short)(short)S);
      Q = null;
    }
  }
  
  public void a(int paramInt)
  {
    c localc = k;
    Z = b;
    localc.b(paramInt);
    if (Q != null)
    {
      int i1 = N;
      if ((i1 != 4) && (i1 != 3))
      {
        i1 = R + c0[paramInt];
        if (i1 > S) {
          S = i1;
        }
        R = i1;
      }
      else
      {
        Q.j.a(paramInt, 0, null, null);
      }
      if (((paramInt >= 172) && (paramInt <= 177)) || (paramInt == 191)) {
        a();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c localc = k;
    Z = b;
    if ((paramInt1 <= 255) && (paramInt2 <= 127) && (paramInt2 >= -128))
    {
      localc.b(132);
      localc.a(paramInt1, paramInt2);
    }
    else
    {
      localc = k;
      localc.b(196);
      localc.b(132, paramInt1);
      localc.d(paramInt2);
    }
    if (Q != null)
    {
      paramInt2 = N;
      if ((paramInt2 == 4) || (paramInt2 == 3)) {
        Q.j.a(132, paramInt1, null, null);
      }
    }
    if (N != 0)
    {
      paramInt1++;
      if (paramInt1 > j) {
        j = paramInt1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, q paramq, q... paramVarArgs)
  {
    c localc = k;
    Z = b;
    localc.b(170);
    int i1 = k.b;
    int i2 = 0;
    localc.a(null, 0, (4 - i1 % 4) % 4);
    paramq.a(k, Z, true);
    localc = k;
    localc.c(paramInt1);
    localc.c(paramInt2);
    paramInt2 = paramVarArgs.length;
    for (paramInt1 = i2; paramInt1 < paramInt2; paramInt1++) {
      paramVarArgs[paramInt1].a(k, Z, true);
    }
    a(paramq, paramVarArgs);
  }
  
  public void a(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2)
  {
    int i1 = N;
    if (i1 == 4) {
      return;
    }
    int i2 = 3;
    int i3 = 0;
    Object localObject2;
    if (i1 == 3)
    {
      Object localObject1 = Q;
      localObject2 = j;
      if (localObject2 == null)
      {
        j = new j((q)localObject1);
        Q.j.a(c, d, h, paramInt2);
        Q.j.a(this);
      }
      else
      {
        if (paramInt1 == -1)
        {
          localObject1 = c;
          i1 = 0;
          paramInt1 = 0;
          for (;;)
          {
            i2 = paramInt1;
            if (i1 >= paramInt2) {
              break;
            }
            int[] arrayOfInt = b;
            i2 = paramInt1 + 1;
            arrayOfInt[paramInt1] = n.a((x)localObject1, paramArrayOfObject1[i1]);
            if ((paramArrayOfObject1[i1] != v.e) && (paramArrayOfObject1[i1] != v.d))
            {
              paramInt1 = i2;
            }
            else
            {
              b[i2] = 4194304;
              paramInt1 = i2 + 1;
            }
            i1++;
          }
          for (;;)
          {
            paramArrayOfObject1 = b;
            if (i2 >= paramArrayOfObject1.length) {
              break;
            }
            paramArrayOfObject1[i2] = 4194304;
            i2++;
          }
          paramInt2 = 0;
          for (i1 = 0; paramInt2 < paramInt3; i1 = paramInt1)
          {
            if (paramArrayOfObject2[paramInt2] != v.e)
            {
              paramInt1 = i1;
              if (paramArrayOfObject2[paramInt2] != v.d) {}
            }
            else
            {
              paramInt1 = i1 + 1;
            }
            paramInt2++;
          }
          c = new int[i1 + paramInt3];
          paramInt2 = 0;
          paramInt1 = 0;
          while (paramInt2 < paramInt3)
          {
            paramArrayOfObject1 = c;
            i1 = paramInt1 + 1;
            paramArrayOfObject1[paramInt1] = n.a((x)localObject1, paramArrayOfObject2[paramInt2]);
            if ((paramArrayOfObject2[paramInt2] != v.e) && (paramArrayOfObject2[paramInt2] != v.d))
            {
              paramInt1 = i1;
            }
            else
            {
              c[i1] = 4194304;
              paramInt1 = i1 + 1;
            }
            paramInt2++;
          }
          g = ((short)0);
          h = 0;
        }
        Q.j.a(this);
      }
    }
    else if (paramInt1 == -1)
    {
      if (V == null)
      {
        paramInt1 = y.b(h);
        localObject2 = new n(new q());
        ((n)localObject2).a(c, d, h, paramInt1 >> 2);
        ((n)localObject2).a(this);
      }
      T = paramInt2;
      a(k.b, paramInt2, paramInt3);
      i1 = 0;
      for (paramInt1 = i2; i1 < paramInt2; paramInt1++)
      {
        W[paramInt1] = n.a(c, paramArrayOfObject1[i1]);
        i1++;
      }
      paramInt2 = 0;
      while (paramInt2 < paramInt3)
      {
        W[paramInt1] = n.a(c, paramArrayOfObject2[paramInt2]);
        paramInt2++;
        paramInt1++;
      }
      b();
    }
    else
    {
      if (u == null)
      {
        u = new c();
        i1 = k.b;
      }
      else
      {
        i2 = k.b - U - 1;
        i1 = i2;
        if (i2 < 0)
        {
          if (paramInt1 == 3) {
            return;
          }
          throw new IllegalStateException();
        }
      }
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 == 4)
              {
                if (i1 < 64)
                {
                  u.b(i1 + 64);
                }
                else
                {
                  paramArrayOfObject1 = u;
                  paramArrayOfObject1.b(247);
                  paramArrayOfObject1.d(i1);
                }
                b(paramArrayOfObject2[0]);
              }
              else
              {
                throw new IllegalArgumentException();
              }
            }
            else if (i1 < 64)
            {
              u.b(i1);
            }
            else
            {
              paramArrayOfObject1 = u;
              paramArrayOfObject1.b(251);
              paramArrayOfObject1.d(i1);
            }
          }
          else
          {
            T -= paramInt2;
            paramArrayOfObject1 = u;
            paramArrayOfObject1.b(251 - paramInt2);
            paramArrayOfObject1.d(i1);
          }
        }
        else
        {
          T += paramInt2;
          localObject2 = u;
          ((c)localObject2).b(paramInt2 + 251);
          ((c)localObject2).d(i1);
          for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
            b(paramArrayOfObject1[paramInt1]);
          }
        }
      }
      else
      {
        T = paramInt2;
        localObject2 = u;
        ((c)localObject2).b(255);
        ((c)localObject2).d(i1);
        ((c)localObject2).d(paramInt2);
        for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
          b(paramArrayOfObject1[paramInt1]);
        }
        u.d(paramInt3);
        for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++) {
          b(paramArrayOfObject2[paramInt1]);
        }
      }
      U = k.b;
      t += 1;
    }
    if (N == 2)
    {
      R = paramInt3;
      for (paramInt1 = i3; paramInt1 < paramInt3; paramInt1++) {
        if ((paramArrayOfObject2[paramInt1] == v.e) || (paramArrayOfObject2[paramInt1] == v.d)) {
          R += 1;
        }
      }
      paramInt1 = R;
      if (paramInt1 > S) {
        S = paramInt1;
      }
    }
    i = Math.max(i, paramInt3);
    j = Math.max(j, T);
  }
  
  public void a(int paramInt, String paramString)
  {
    Z = k.b;
    paramString = c.a(7, paramString);
    k.b(paramInt, a);
    if (Q != null)
    {
      int i1 = N;
      if ((i1 != 4) && (i1 != 3))
      {
        if (paramInt == 187)
        {
          paramInt = R + 1;
          if (paramInt > S) {
            S = paramInt;
          }
          R = paramInt;
        }
      }
      else {
        Q.j.a(paramInt, Z, paramString, c);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Z = k.b;
    paramString1 = c.a(9, paramString1, paramString2, paramString3);
    k.b(paramInt, a);
    if (Q != null)
    {
      int i1 = N;
      int i2 = 0;
      if ((i1 != 4) && (i1 != 3))
      {
        int i3 = paramString3.charAt(0);
        i1 = -2;
        int i4 = 1;
        switch (paramInt)
        {
        default: 
          i4 = R;
          if (i3 != 68)
          {
            i2 = i4;
            paramInt = i1;
            if (i3 != 74) {
              break label261;
            }
          }
          break;
        case 180: 
          i1 = R;
          if (i3 != 68)
          {
            paramInt = i2;
            if (i3 != 74) {}
          }
          else
          {
            paramInt = 1;
          }
          paramInt = i1 + paramInt;
          break;
        case 179: 
          i4 = R;
          i2 = i4;
          paramInt = i1;
          if (i3 == 68) {
            break label261;
          }
          if (i3 == 74)
          {
            i2 = i4;
            paramInt = i1;
          }
          else
          {
            paramInt = -1;
            i2 = i4;
          }
          break;
        case 178: 
          i2 = R;
          if (i3 != 68)
          {
            paramInt = i4;
            if (i3 != 74) {}
          }
          else
          {
            paramInt = 2;
          }
          paramInt = i2 + paramInt;
          break;
        }
        paramInt = -3;
        i2 = i4;
        label261:
        paramInt = i2 + paramInt;
        if (paramInt > S) {
          S = paramInt;
        }
        R = paramInt;
      }
      else
      {
        Q.j.a(paramInt, 0, paramString1, c);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Z = k.b;
    x localx = c;
    int i1;
    if (paramBoolean) {
      i1 = 11;
    } else {
      i1 = 10;
    }
    paramString2 = localx.a(i1, paramString1, paramString2, paramString3);
    if (paramInt == 185)
    {
      paramString1 = k;
      paramString1.b(185, a);
      paramString1.a(paramString2.a() >> 2, 0);
    }
    else
    {
      k.b(paramInt, a);
    }
    if (Q != null)
    {
      i1 = N;
      if ((i1 != 4) && (i1 != 3))
      {
        i1 = paramString2.a();
        i1 = (i1 & 0x3) - (i1 >> 2);
        if (paramInt == 184) {
          paramInt = R + i1 + 1;
        } else {
          paramInt = R + i1;
        }
        if (paramInt > S) {
          S = paramInt;
        }
        R = paramInt;
      }
      else
      {
        Q.j.a(paramInt, 0, paramString2, c);
      }
    }
  }
  
  public void a(int paramInt, q paramq)
  {
    Z = k.b;
    int i1;
    if (paramInt >= 200) {
      i1 = paramInt - 33;
    } else {
      i1 = paramInt;
    }
    int i2;
    Object localObject;
    if ((a & 0x4) != 0)
    {
      i2 = d;
      localObject = k;
      if (i2 - b < 32768)
      {
        if (i1 == 167)
        {
          ((c)localObject).b(200);
        }
        else
        {
          if (i1 != 168) {
            break label103;
          }
          ((c)localObject).b(201);
        }
        paramInt = 0;
        break label160;
        label103:
        if (i1 >= 198) {
          paramInt = i1 ^ 0x1;
        } else {
          paramInt = (i1 + 1 ^ 0x1) - 1;
        }
        ((c)localObject).b(paramInt);
        k.d(8);
        k.b(220);
        Y = true;
        paramInt = 1;
        label160:
        localObject = k;
        paramq.a((c)localObject, b - 1, true);
        break label251;
      }
    }
    if (i1 != paramInt)
    {
      k.b(paramInt);
      localObject = k;
      paramq.a((c)localObject, b - 1, true);
    }
    else
    {
      k.b(i1);
      localObject = k;
      paramq.a((c)localObject, b - 1, false);
    }
    paramInt = 0;
    label251:
    q localq = Q;
    if (localq != null)
    {
      i2 = N;
      localObject = null;
      if (i2 == 4)
      {
        j.a(i1, 0, null, null);
        localq = paramq.a();
        a = ((short)(short)(a | 0x2));
        c(0, paramq);
        paramq = (q)localObject;
        if (i1 != 167) {
          paramq = new q();
        }
      }
      else if (i2 == 3)
      {
        j.a(i1, 0, null, null);
        paramq = (q)localObject;
      }
      else if (i2 == 2)
      {
        R += c0[i1];
        paramq = (q)localObject;
      }
      else if (i1 == 168)
      {
        i2 = a;
        if ((i2 & 0x20) == 0)
        {
          a = ((short)(short)(i2 | 0x20));
          X = true;
        }
        localObject = Q;
        a = ((short)(short)(a | 0x10));
        c(R + 1, paramq);
        paramq = new q();
      }
      else
      {
        i2 = R + c0[i1];
        R = i2;
        c(i2, paramq);
        paramq = (q)localObject;
      }
      if (paramq != null)
      {
        if (paramInt != 0) {
          a = ((short)(short)(a | 0x2));
        }
        a(paramq);
      }
      if (i1 == 167) {
        a();
      }
    }
  }
  
  public void a(Object paramObject)
  {
    Z = k.b;
    paramObject = c.a(paramObject);
    int i1 = a;
    int i2 = b;
    int i3 = 1;
    if ((i2 != 5) && (i2 != 6)) {
      if (i2 == 17)
      {
        i2 = e.charAt(0);
        if ((i2 == 74) || (i2 == 68)) {}
      }
      else
      {
        i2 = 0;
        break label81;
      }
    }
    i2 = 1;
    label81:
    if (i2 != 0) {
      k.b(20, i1);
    } else if (i1 >= 256) {
      k.b(19, i1);
    } else {
      k.a(18, i1);
    }
    if (Q != null)
    {
      i1 = N;
      if ((i1 != 4) && (i1 != 3))
      {
        i1 = R;
        if (i2 != 0) {
          i3 = 2;
        }
        i2 = i1 + i3;
        if (i2 > S) {
          S = i2;
        }
        R = i2;
      }
      else
      {
        Q.j.a(18, 0, (w)paramObject, c);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, q paramq1, q paramq2, int paramInt)
  {
    int i1 = 1;
    if (paramString3 != null)
    {
      if (s == null) {
        s = new c();
      }
      r += 1;
      c localc = s;
      localc.d(d);
      localc.d(d - d);
      localc.d(c.c(paramString1));
      localc.d(c.c(paramString3));
      localc.d(paramInt);
    }
    if (q == null) {
      q = new c();
    }
    p += 1;
    paramString3 = q;
    paramString3.d(d);
    paramString3.d(d - d);
    paramString3.d(c.c(paramString1));
    paramString3.d(c.c(paramString2));
    paramString3.d(paramInt);
    if (N != 0)
    {
      int i2 = paramString2.charAt(0);
      if ((i2 == 74) || (i2 == 68)) {
        i1 = 2;
      }
      paramInt += i1;
      if (paramInt > j) {
        j = paramInt;
      }
    }
  }
  
  public void a(q paramq)
  {
    boolean bool = Y;
    Object localObject = k;
    Y = (bool | paramq.a(a, b));
    int i1 = a;
    if ((i1 & 0x1) != 0) {
      return;
    }
    int i2 = N;
    if (i2 == 4)
    {
      localObject = Q;
      if (localObject != null)
      {
        if (d == d)
        {
          a = ((short)(short)(i1 & 0x2 | a));
          j = j;
          return;
        }
        c(0, paramq);
      }
      localObject = P;
      if (localObject != null)
      {
        if (d == d)
        {
          a = ((short)(short)(a | a & 0x2));
          j = j;
          Q = ((q)localObject);
          return;
        }
        k = paramq;
      }
      P = paramq;
      Q = paramq;
      j = new n(paramq);
    }
    else if (i2 == 3)
    {
      localObject = Q;
      if (localObject == null) {
        Q = paramq;
      } else {
        j.a = paramq;
      }
    }
    else if (i2 == 1)
    {
      localObject = Q;
      if (localObject != null)
      {
        h = ((short)(short)S);
        c(R, paramq);
      }
      Q = paramq;
      R = 0;
      S = 0;
      localObject = P;
      if (localObject != null) {
        k = paramq;
      }
      P = paramq;
    }
    else if ((i2 == 2) && (Q == null))
    {
      Q = paramq;
    }
  }
  
  public final void a(q paramq, q[] paramArrayOfq)
  {
    q localq = Q;
    if (localq != null)
    {
      int i1 = N;
      int i2 = 0;
      if (i1 == 4)
      {
        j.a(171, 0, null, null);
        c(0, paramq);
        paramq = paramq.a();
        a = ((short)(short)(a | 0x2));
        i1 = paramArrayOfq.length;
        for (i2 = 0; i2 < i1; i2++)
        {
          paramq = paramArrayOfq[i2];
          c(0, paramq);
          paramq = paramq.a();
          a = ((short)(short)(a | 0x2));
        }
      }
      if (i1 == 1)
      {
        i1 = R - 1;
        R = i1;
        c(i1, paramq);
        i1 = paramArrayOfq.length;
        while (i2 < i1)
        {
          paramq = paramArrayOfq[i2];
          c(R, paramq);
          i2++;
        }
      }
      a();
    }
  }
  
  public a b(int paramInt, z paramz, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramz = a.a(c, paramInt, paramz, paramString, H);
      H = paramz;
      return paramz;
    }
    paramz = a.a(c, paramInt, paramz, paramString, I);
    I = paramz;
    return paramz;
  }
  
  public void b()
  {
    if (V != null)
    {
      if (u == null) {
        u = new c();
      }
      Object localObject = W;
      int i1 = localObject[1];
      int i2 = localObject[2];
      int i3 = c.c;
      int i4 = 0;
      if (i3 < 50)
      {
        c localc = u;
        localc.d(localObject[0]);
        localc.d(i1);
        i3 = i1 + 3;
        e(3, i3);
        u.d(i2);
        e(i3, i2 + i3);
      }
      else
      {
        int i5;
        if (t == 0) {
          i5 = localObject[0];
        } else {
          i5 = localObject[0] - V[0] - 1;
        }
        int i6 = V[1];
        int i7 = i1 - i6;
        if (i2 == 0)
        {
          switch (i7)
          {
          default: 
            break;
          case 1: 
          case 2: 
          case 3: 
            i3 = 252;
            break;
          case 0: 
            if (i5 < 64) {
              i3 = 0;
            } else {
              i3 = 251;
            }
            break;
          case -3: 
          case -2: 
          case -1: 
            i3 = 248;
            break;
          }
        }
        else if ((i7 == 0) && (i2 == 1))
        {
          if (i5 < 63)
          {
            i3 = 64;
            break label281;
          }
          i3 = 247;
          break label281;
        }
        i3 = 255;
        label281:
        int i8 = i3;
        if (i3 != 255)
        {
          int i9 = 3;
          for (;;)
          {
            i8 = i3;
            if (i4 >= i6) {
              break;
            }
            i8 = i3;
            if (i4 >= i1) {
              break;
            }
            if (W[i9] != V[i9])
            {
              i8 = 255;
              break;
            }
            i9++;
            i4++;
          }
        }
        if (i8 != 0)
        {
          if (i8 != 64)
          {
            if (i8 != 247)
            {
              if (i8 != 248)
              {
                if (i8 != 251)
                {
                  if (i8 != 252)
                  {
                    localObject = u;
                    ((c)localObject).b(255);
                    ((c)localObject).d(i5);
                    ((c)localObject).d(i1);
                    i3 = i1 + 3;
                    e(3, i3);
                    u.d(i2);
                    e(i3, i2 + i3);
                  }
                  else
                  {
                    localObject = u;
                    ((c)localObject).b(i7 + 251);
                    ((c)localObject).d(i5);
                    e(i6 + 3, i1 + 3);
                  }
                }
                else
                {
                  localObject = u;
                  ((c)localObject).b(251);
                  ((c)localObject).d(i5);
                }
              }
              else
              {
                localObject = u;
                ((c)localObject).b(i7 + 251);
                ((c)localObject).d(i5);
              }
            }
            else
            {
              localObject = u;
              ((c)localObject).b(247);
              ((c)localObject).d(i5);
              e(i1 + 3, i1 + 4);
            }
          }
          else
          {
            u.b(i5 + 64);
            e(i1 + 3, i1 + 4);
          }
        }
        else {
          u.b(i5);
        }
      }
      t += 1;
    }
    V = W;
    W = null;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c localc = k;
    Z = b;
    if (paramInt1 == 17) {
      localc.b(paramInt1, paramInt2);
    } else {
      localc.a(paramInt1, paramInt2);
    }
    if (Q != null)
    {
      int i1 = N;
      if ((i1 != 4) && (i1 != 3))
      {
        if (paramInt1 != 188)
        {
          paramInt1 = R + 1;
          if (paramInt1 > S) {
            S = paramInt1;
          }
          R = paramInt1;
        }
      }
      else {
        Q.j.a(paramInt1, paramInt2, null, null);
      }
    }
  }
  
  public void b(int paramInt, q paramq)
  {
    if (o == null) {
      o = new c();
    }
    n += 1;
    o.d(d);
    o.d(paramInt);
  }
  
  public final void b(Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      u.b(((Integer)paramObject).intValue());
    }
    else
    {
      c localc;
      if ((paramObject instanceof String))
      {
        localc = u;
        localc.b(7);
        localc.d(c.a((String)paramObject).a);
      }
      else
      {
        localc = u;
        localc.b(8);
        localc.d(d);
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    int i1 = N;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int i2;
    if (i1 == 4)
    {
      for (localObject1 = l;; localObject1 = f)
      {
        localObject2 = "java/lang/Throwable";
        if (localObject1 == null) {
          break;
        }
        localObject3 = e;
        if (localObject3 != null) {
          localObject2 = localObject3;
        }
        paramInt1 = c.d((String)localObject2);
        localObject3 = c.a();
        a = ((short)(short)(a | 0x2));
        localObject2 = a.a();
        localObject4 = b.a();
        while (localObject2 != localObject4)
        {
          l = new k(0x800000 | paramInt1, (q)localObject3, l);
          localObject2 = k;
        }
      }
      localObject1 = O.j;
      ((n)localObject1).a(c, d, h, j);
      ((n)localObject1).a(this);
      localObject2 = O;
      m = q.n;
      paramInt1 = 0;
      while (localObject2 != q.n)
      {
        localObject1 = m;
        m = null;
        a = ((short)(short)(a | 0x8));
        i1 = j.c.length + h;
        paramInt2 = paramInt1;
        if (i1 > paramInt1) {
          paramInt2 = i1;
        }
        localObject3 = l;
        while (localObject3 != null)
        {
          localObject5 = b.a();
          localObject4 = localObject1;
          if (j.a(c, j, a))
          {
            localObject4 = localObject1;
            if (m == null)
            {
              m = ((q)localObject1);
              localObject4 = localObject5;
            }
          }
          localObject3 = c;
          localObject1 = localObject4;
        }
        paramInt1 = paramInt2;
        localObject2 = localObject1;
      }
      localObject1 = O;
      while (localObject1 != null)
      {
        if ((a & 0xA) == 10) {
          j.a(this);
        }
        paramInt2 = paramInt1;
        if ((a & 0x8) == 0)
        {
          localObject2 = k;
          i1 = d;
          if (localObject2 == null) {
            paramInt2 = k.b;
          } else {
            paramInt2 = d;
          }
          i2 = paramInt2 - 1;
          paramInt2 = paramInt1;
          if (i2 >= i1)
          {
            for (paramInt2 = i1; paramInt2 < i2; paramInt2++) {
              k.a[paramInt2] = ((byte)0);
            }
            k.a[i2] = ((byte)-65);
            a(i1, 0, 1);
            W[3] = (c.d("java/lang/Throwable") | 0x800000);
            b();
            l = p.a(l, (q)localObject1, (q)localObject2);
            paramInt2 = Math.max(paramInt1, 1);
          }
        }
        localObject1 = k;
        paramInt1 = paramInt2;
      }
      i = paramInt1;
    }
    else if (i1 == 1)
    {
      for (localObject1 = l; localObject1 != null; localObject1 = f)
      {
        localObject4 = c;
        localObject2 = a;
        localObject3 = b;
        while (localObject2 != localObject3)
        {
          if ((a & 0x10) == 0)
          {
            l = new k(Integer.MAX_VALUE, (q)localObject4, l);
          }
          else
          {
            localObject5 = l.c;
            c = new k(Integer.MAX_VALUE, (q)localObject4, c);
          }
          localObject2 = k;
        }
      }
      if (X)
      {
        O.a((short)1);
        paramInt1 = 1;
        paramInt2 = 1;
        while (paramInt1 <= paramInt2)
        {
          localObject1 = O;
          while (localObject1 != null)
          {
            i1 = paramInt2;
            if ((a & 0x10) != 0)
            {
              i1 = paramInt2;
              if (i == paramInt1)
              {
                localObject2 = l.c.b;
                i1 = paramInt2;
                if (i == 0)
                {
                  int i3 = (short)(paramInt2 + 1);
                  ((q)localObject2).a(i3);
                  i1 = i3;
                }
              }
            }
            localObject1 = k;
            paramInt2 = i1;
          }
          paramInt1 = (short)(paramInt1 + 1);
        }
        for (localObject3 = O; localObject3 != null; localObject3 = k) {
          if ((a & 0x10) != 0)
          {
            localObject1 = l.c.b;
            localObject2 = q.n;
            m = ((q)localObject2);
            for (;;)
            {
              localObject4 = localObject2;
              if (localObject1 == q.n) {
                break;
              }
              localObject4 = m;
              m = ((q)localObject2);
              if (((a & 0x40) != 0) && (i != i)) {
                l = new k(g, l.b, l);
              }
              localObject4 = ((q)localObject1).a((q)localObject4);
              localObject2 = localObject1;
              localObject1 = localObject4;
            }
            while (localObject4 != q.n)
            {
              localObject1 = m;
              m = null;
              localObject4 = localObject1;
            }
          }
        }
      }
      localObject3 = O;
      m = q.n;
      paramInt2 = i;
      if (localObject3 != q.n)
      {
        localObject1 = m;
        i2 = f;
        i1 = h + i2;
        paramInt1 = paramInt2;
        if (i1 > paramInt2) {
          paramInt1 = i1;
        }
        localObject4 = l;
        localObject2 = localObject4;
        if ((a & 0x10) != 0) {
          localObject2 = c;
        }
        for (;;)
        {
          paramInt2 = paramInt1;
          localObject3 = localObject1;
          if (localObject2 == null) {
            break;
          }
          localObject4 = b;
          localObject3 = localObject1;
          if (m == null)
          {
            paramInt2 = a;
            if (paramInt2 == Integer.MAX_VALUE) {
              paramInt2 = 1;
            } else {
              paramInt2 += i2;
            }
            f = ((short)(short)paramInt2);
            m = ((q)localObject1);
            localObject3 = localObject4;
          }
          localObject2 = c;
          localObject1 = localObject3;
        }
      }
      i = paramInt2;
    }
    else if (i1 == 2)
    {
      i = S;
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
    }
  }
  
  public final void c(int paramInt, q paramq)
  {
    q localq = Q;
    l = new k(paramInt, paramq, l);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    Z = k.b;
    int i1;
    if ((paramInt2 < 4) && (paramInt1 != 169))
    {
      if (paramInt1 < 54) {
        i1 = (paramInt1 - 21 << 2) + 26;
      } else {
        i1 = (paramInt1 - 54 << 2) + 59;
      }
      k.b(i1 + paramInt2);
    }
    else if (paramInt2 >= 256)
    {
      localObject = k;
      ((c)localObject).b(196);
      ((c)localObject).b(paramInt1, paramInt2);
    }
    else
    {
      k.a(paramInt1, paramInt2);
    }
    Object localObject = Q;
    if (localObject != null)
    {
      i1 = N;
      if ((i1 != 4) && (i1 != 3))
      {
        if (paramInt1 == 169)
        {
          a = ((short)(short)(a | 0x40));
          g = ((short)(short)R);
          a();
        }
        else
        {
          i1 = R + c0[paramInt1];
          if (i1 > S) {
            S = i1;
          }
          R = i1;
        }
      }
      else {
        Q.j.a(paramInt1, paramInt2, null, null);
      }
    }
    if (N != 0)
    {
      if ((paramInt1 != 22) && (paramInt1 != 24) && (paramInt1 != 55) && (paramInt1 != 57)) {
        paramInt2++;
      } else {
        paramInt2 += 2;
      }
      if (paramInt2 > j) {
        j = paramInt2;
      }
    }
    if ((paramInt1 >= 54) && (N == 4) && (l != null)) {
      a(new q());
    }
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      x localx = c;
      int i1 = W[paramInt1];
      c localc = u;
      int i2 = (0xFC000000 & i1) >> 26;
      if (i2 == 0)
      {
        i2 = i1 & 0xFFFFF;
        i1 &= 0x3C00000;
        if (i1 != 4194304)
        {
          if (i1 != 8388608)
          {
            if (i1 == 12582912)
            {
              localc.b(8);
              localc.d((int)l[i2].f);
            }
            else
            {
              throw new AssertionError();
            }
          }
          else
          {
            localc.b(7);
            localc.d(al[i2].e).a);
          }
        }
        else {
          localc.b(i2);
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        while (i2 > 0)
        {
          localStringBuilder.append('[');
          i2--;
        }
        if ((i1 & 0x3C00000) == 8388608)
        {
          localStringBuilder.append('L');
          localStringBuilder.append(l[(i1 & 0xFFFFF)].e);
          localStringBuilder.append(';');
        }
        else
        {
          i2 = i1 & 0xFFFFF;
          if (i2 != 1)
          {
            if (i2 != 2)
            {
              if (i2 != 3)
              {
                if (i2 != 4) {
                  switch (i2)
                  {
                  default: 
                    throw new AssertionError();
                  case 12: 
                    localStringBuilder.append('S');
                    break;
                  case 11: 
                    localStringBuilder.append('C');
                    break;
                  case 10: 
                    localStringBuilder.append('B');
                    break;
                  case 9: 
                    localStringBuilder.append('Z');
                    break;
                  }
                } else {
                  localStringBuilder.append('J');
                }
              }
              else {
                localStringBuilder.append('D');
              }
            }
            else {
              localStringBuilder.append('F');
            }
          }
          else {
            localStringBuilder.append('I');
          }
        }
        localc.b(7);
        localc.d(atoStringa);
      }
      paramInt1++;
    }
  }
}

/* Location:
 * Qualified Name:     l.e.a.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */