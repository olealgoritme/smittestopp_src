package k.e.a;

public class g
  extends f
{
  public b A;
  public int B;
  public int a;
  public final x b = new x(this);
  public int c;
  public int d;
  public int e;
  public int f;
  public int[] g;
  public m h;
  public m i;
  public t j;
  public t k;
  public int l;
  public c m;
  public int n;
  public int o;
  public int p;
  public int q;
  public c r;
  public a s;
  public a t;
  public a u;
  public a v;
  public u w;
  public int x;
  public int y;
  public c z;
  
  public g(int paramInt)
  {
    super(458752);
    if ((paramInt & 0x2) != 0) {
      B = 4;
    } else if ((paramInt & 0x1) != 0) {
      B = 1;
    } else {
      B = 0;
    }
  }
  
  public final a a(int paramInt, z paramz, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramz = a.a(b, paramInt, paramz, paramString, u);
      u = paramz;
      return paramz;
    }
    paramz = a.a(b, paramInt, paramz, paramString, v);
    v = paramz;
    return paramz;
  }
  
  public final a a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramString = a.a(b, paramString, s);
      s = paramString;
      return paramString;
    }
    paramString = a.a(b, paramString, t);
    t = paramString;
    return paramString;
  }
  
  public final s a(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    paramString1 = new t(b, paramInt, paramString1, paramString2, paramString3, paramArrayOfString, B);
    if (j == null) {
      j = paramString1;
    } else {
      k.b = paramString1;
    }
    k = paramString1;
    return paramString1;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    a = paramInt1;
    c = paramInt2;
    x localx = b;
    int i1 = paramInt1 & 0xFFFF;
    c = i1;
    d = paramString1;
    d = a7a;
    if (paramString2 != null) {
      p = b.c(paramString2);
    }
    paramInt2 = 0;
    if (paramString3 == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = b.a(7, paramString3).a;
    }
    e = paramInt1;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      paramInt1 = paramArrayOfString.length;
      f = paramInt1;
      g = new int[paramInt1];
      for (paramInt1 = paramInt2; paramInt1 < f; paramInt1++) {
        g[paramInt1] = b.a(paramArrayOfString[paramInt1]).a;
      }
    }
    if ((B == 1) && (i1 >= 51)) {
      B = 2;
    }
  }
  
  public byte[] a()
  {
    int i1 = f * 2 + 24;
    Object localObject1 = h;
    int i2 = 0;
    for (;;)
    {
      localObject2 = "ConstantValue";
      if (localObject1 == null) {
        break;
      }
      i2++;
      if (g != 0)
      {
        b.c("ConstantValue");
        i3 = 16;
      }
      else
      {
        i3 = 8;
      }
      i4 = b.a(b, c, f);
      i4 = a.a(h, i, j, k) + (i4 + i3);
      localObject2 = l;
      i3 = i4;
      if (localObject2 != null) {
        i3 = i4 + ((b)localObject2).a(b);
      }
      i1 += i3;
      localObject1 = (m)a;
    }
    Object localObject3 = j;
    int i5 = 0;
    localObject1 = localObject2;
    Object localObject4;
    Object localObject5;
    for (Object localObject2 = localObject3;; localObject2 = (t)b)
    {
      localObject4 = "RuntimeInvisibleParameterAnnotations";
      localObject5 = "RuntimeVisibleParameterAnnotations";
      i4 = 1;
      if (localObject2 == null) {
        break;
      }
      i5++;
      if (a0 != 0)
      {
        i4 = b0 + 6;
      }
      else
      {
        i3 = k.b;
        if (i3 > 0)
        {
          if (i3 <= 65535)
          {
            c.c("Code");
            i7 = k.b;
            localObject3 = l;
            i3 = 0;
            while (localObject3 != null)
            {
              i3++;
              localObject3 = f;
            }
            i7 = i3 * 8 + 2 + (i7 + 16) + 8;
            if (u != null)
            {
              if (c.c >= 50) {
                i3 = i4;
              } else {
                i3 = 0;
              }
              localObject6 = c;
              if (i3 != 0) {
                localObject3 = "StackMapTable";
              } else {
                localObject3 = "StackMap";
              }
              ((x)localObject6).c((String)localObject3);
              i4 = i7 + (u.b + 8);
            }
            else
            {
              i4 = i7;
            }
            i3 = i4;
            if (o != null)
            {
              c.c("LineNumberTable");
              i3 = i4 + (o.b + 8);
            }
            i4 = i3;
            if (q != null)
            {
              c.c("LocalVariableTable");
              i4 = i3 + (q.b + 8);
            }
            i3 = i4;
            if (s != null)
            {
              c.c("LocalVariableTypeTable");
              i3 = i4 + (s.b + 8);
            }
            localObject3 = v;
            i4 = i3;
            if (localObject3 != null) {
              i4 = i3 + ((a)localObject3).a("RuntimeVisibleTypeAnnotations");
            }
            localObject3 = w;
            if (localObject3 != null) {
              i4 = ((a)localObject3).a("RuntimeInvisibleTypeAnnotations") + i4;
            }
            localObject5 = x;
            i3 = i4;
            if (localObject5 != null)
            {
              localObject6 = c;
              localObject3 = k;
              i3 = i4 + ((b)localObject5).a((x)localObject6, a, b, i, j);
            }
          }
          else
          {
            throw new r(c.d, f, h, k.b);
          }
        }
        else {
          i3 = 8;
        }
        i4 = i3;
        if (y > 0)
        {
          c.c("Exceptions");
          i4 = i3 + (y * 2 + 8);
        }
        i3 = b.a(c, d, A);
        i4 = a.a(B, C, H, I) + (i3 + i4);
        localObject3 = E;
        i3 = i4;
        if (localObject3 != null)
        {
          i7 = D;
          i3 = i7;
          if (i7 == 0) {
            i3 = localObject3.length;
          }
          i3 = i4 + a.a("RuntimeVisibleParameterAnnotations", (a[])localObject3, i3);
        }
        localObject3 = G;
        i4 = i3;
        if (localObject3 != null)
        {
          i7 = F;
          i4 = i7;
          if (i7 == 0) {
            i4 = localObject3.length;
          }
          i4 = i3 + a.a("RuntimeInvisibleParameterAnnotations", (a[])localObject3, i4);
        }
        i7 = i4;
        if (J != null)
        {
          c.c("AnnotationDefault");
          i7 = i4 + (J.b + 6);
        }
        i3 = i7;
        if (L != null)
        {
          c.c("MethodParameters");
          i3 = i7 + (L.b + 7);
        }
        localObject3 = M;
        i4 = i3;
        if (localObject3 != null) {
          i4 = i3 + ((b)localObject3).a(c);
        }
      }
      i1 += i4;
    }
    localObject2 = m;
    if (localObject2 != null)
    {
      i4 = i1 + (b + 8);
      b.c("InnerClasses");
      i7 = 1;
    }
    else
    {
      i7 = 0;
      i4 = i1;
    }
    int i8 = n;
    Object localObject7 = "MethodParameters";
    i1 = i4;
    int i3 = i7;
    if (i8 != 0)
    {
      i3 = i7 + 1;
      i1 = i4 + 10;
      b.c("EnclosingMethod");
    }
    i8 = c;
    Object localObject6 = "AnnotationDefault";
    int i7 = i1;
    int i4 = i3;
    if ((i8 & 0x1000) != 0)
    {
      i7 = i1;
      i4 = i3;
      if ((a & 0xFFFF) < 49)
      {
        i4 = i3 + 1;
        i7 = i1 + 6;
        b.c("Synthetic");
      }
    }
    i8 = i7;
    i3 = i4;
    if (p != 0)
    {
      i3 = i4 + 1;
      i8 = i7 + 8;
      b.c("Signature");
    }
    i7 = i8;
    i1 = i3;
    if (q != 0)
    {
      i1 = i3 + 1;
      i7 = i8 + 8;
      b.c("SourceFile");
    }
    localObject2 = r;
    i4 = i7;
    i3 = i1;
    if (localObject2 != null)
    {
      i3 = i1 + 1;
      i4 = i7 + (b + 6);
      b.c("SourceDebugExtension");
    }
    i8 = i4;
    i1 = i3;
    if ((c & 0x20000) != 0)
    {
      i1 = i3 + 1;
      i8 = i4 + 6;
      b.c("Deprecated");
    }
    localObject2 = s;
    i7 = i8;
    i3 = i1;
    if (localObject2 != null)
    {
      i7 = i8 + ((a)localObject2).a("RuntimeVisibleAnnotations");
      i3 = i1 + 1;
    }
    localObject2 = t;
    i1 = i7;
    i4 = i3;
    if (localObject2 != null)
    {
      i1 = i7 + ((a)localObject2).a("RuntimeInvisibleAnnotations");
      i4 = i3 + 1;
    }
    localObject2 = u;
    i3 = i1;
    i8 = i4;
    if (localObject2 != null)
    {
      i8 = i4 + 1;
      i3 = i1 + ((a)localObject2).a("RuntimeVisibleTypeAnnotations");
    }
    localObject2 = v;
    i4 = i3;
    i7 = i8;
    if (localObject2 != null)
    {
      i7 = i8 + 1;
      i4 = i3 + ((a)localObject2).a("RuntimeInvisibleTypeAnnotations");
    }
    localObject2 = b;
    if (j != null)
    {
      ((x)localObject2).c("BootstrapMethods");
      i8 = j.b + 8;
    }
    else
    {
      i8 = 0;
    }
    i1 = i4;
    i3 = i7;
    if (i8 > 0)
    {
      i1 = i7 + 1;
      localObject2 = b;
      if (j != null)
      {
        ((x)localObject2).c("BootstrapMethods");
        i3 = j.b + 8;
      }
      else
      {
        i3 = 0;
      }
      i4 += i3;
      i3 = i1;
      i1 = i4;
    }
    localObject2 = w;
    if (localObject2 != null)
    {
      if (o > 0) {
        i7 = 1;
      } else {
        i7 = 0;
      }
      if (q > 0) {
        i8 = 1;
      } else {
        i8 = 0;
      }
      localObject2 = w;
      a.c("Module");
      i4 = f.b + 22 + h.b + j.b + l.b + n.b;
      if (o > 0)
      {
        a.c("ModulePackages");
        i4 += p.b + 8;
      }
      int i9 = i4;
      if (q > 0)
      {
        a.c("ModuleMainClass");
        i9 = i4 + 8;
      }
      i1 += i9;
      i4 = i3 + (i7 + 1 + i8);
    }
    else
    {
      i4 = i3;
    }
    i7 = i1;
    i3 = i4;
    if (x != 0)
    {
      i3 = i4 + 1;
      i7 = i1 + 8;
      b.c("NestHost");
    }
    localObject2 = z;
    i4 = i7;
    i1 = i3;
    if (localObject2 != null)
    {
      i1 = i3 + 1;
      i4 = i7 + (b + 8);
      b.c("NestMembers");
    }
    localObject2 = A;
    i7 = i4;
    i3 = i1;
    if (localObject2 != null)
    {
      i3 = i1 + ((b)localObject2).a();
      i7 = i4 + A.a(b);
    }
    localObject2 = b;
    i1 = h.b;
    i4 = g;
    if (i4 <= 65535)
    {
      c localc = new c(i7 + i1);
      localc.c(-889275714);
      localc.c(a);
      localObject2 = b;
      localc.d(g);
      localObject2 = h;
      localc.a(a, 0, b);
      if ((a & 0xFFFF) < 49) {
        i1 = 4096;
      } else {
        i1 = 0;
      }
      localc.d(i1 & c);
      localc.d(d);
      localc.d(e);
      localc.d(f);
      for (i1 = 0; i1 < f; i1++) {
        localc.d(g[i1]);
      }
      localc.d(i2);
      localObject2 = h;
      localObject3 = localObject1;
      localObject1 = localObject4;
      i2 = i3;
      Object localObject8;
      while (localObject2 != null)
      {
        if (b.c < 49) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if (i4 != 0) {
          i3 = 4096;
        } else {
          i3 = 0;
        }
        localc.d(i3 & c);
        localc.d(d);
        localc.d(e);
        if (g != 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        i3 = i1;
        if ((c & 0x1000) != 0)
        {
          i3 = i1;
          if (i4 != 0) {
            i3 = i1 + 1;
          }
        }
        i1 = i3;
        if (f != 0) {
          i1 = i3 + 1;
        }
        i4 = i1;
        if ((c & 0x20000) != 0) {
          i4 = i1 + 1;
        }
        i3 = i4;
        if (h != null) {
          i3 = i4 + 1;
        }
        i1 = i3;
        if (i != null) {
          i1 = i3 + 1;
        }
        i3 = i1;
        if (j != null) {
          i3 = i1 + 1;
        }
        i1 = i3;
        if (k != null) {
          i1 = i3 + 1;
        }
        localObject4 = l;
        i3 = i1;
        if (localObject4 != null) {
          i3 = i1 + ((b)localObject4).a();
        }
        localc.d(i3);
        if (g != 0)
        {
          localc.d(b.c((String)localObject3));
          localc.c(2);
          localc.d(g);
        }
        b.a(b, c, f, localc);
        localObject4 = b;
        localObject8 = h;
        a locala = i;
        a.a((x)localObject4, (a)localObject8, locala, j, k, localc);
        localObject4 = l;
        if (localObject4 != null) {
          ((b)localObject4).a(b, localc);
        }
        localObject2 = (m)a;
      }
      localc.d(i5);
      localObject4 = j;
      i3 = 0;
      int i10 = 0;
      localObject3 = localObject1;
      localObject2 = localObject7;
      localObject1 = localObject5;
      localObject5 = localObject4;
      while (localObject5 != null)
      {
        if (t > 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        i10 |= i1;
        int i6 = i3 | Y;
        if (c.c < 49) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if (i4 != 0) {
          i3 = 4096;
        } else {
          i3 = 0;
        }
        localc.d(i3 & d);
        localc.d(e);
        localc.d(g);
        i3 = a0;
        if (i3 != 0)
        {
          localc.a(c.b.a, i3, b0);
        }
        else
        {
          if (k.b > 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          i3 = i1;
          if (y > 0) {
            i3 = i1 + 1;
          }
          i1 = i3;
          if ((d & 0x1000) != 0)
          {
            i1 = i3;
            if (i4 != 0) {
              i1 = i3 + 1;
            }
          }
          i3 = i1;
          if (A != 0) {
            i3 = i1 + 1;
          }
          i1 = i3;
          if ((d & 0x20000) != 0) {
            i1 = i3 + 1;
          }
          i3 = i1;
          if (B != null) {
            i3 = i1 + 1;
          }
          i1 = i3;
          if (C != null) {
            i1 = i3 + 1;
          }
          i3 = i1;
          if (E != null) {
            i3 = i1 + 1;
          }
          i4 = i3;
          if (G != null) {
            i4 = i3 + 1;
          }
          i1 = i4;
          if (H != null) {
            i1 = i4 + 1;
          }
          i3 = i1;
          if (I != null) {
            i3 = i1 + 1;
          }
          i1 = i3;
          if (J != null) {
            i1 = i3 + 1;
          }
          i3 = i1;
          if (L != null) {
            i3 = i1 + 1;
          }
          localObject7 = M;
          i1 = i3;
          if (localObject7 != null) {
            i1 = i3 + ((b)localObject7).a();
          }
          localc.d(i1);
          i1 = k.b;
          if (i1 > 0)
          {
            localObject7 = l;
            i3 = 0;
            while (localObject7 != null)
            {
              i3++;
              localObject7 = f;
            }
            i4 = i3 * 8 + 2 + (i1 + 10);
            localObject7 = u;
            if (localObject7 != null)
            {
              i4 += b + 8;
              i1 = 1;
            }
            else
            {
              i1 = 0;
            }
            localObject7 = o;
            i7 = i1;
            i3 = i4;
            if (localObject7 != null)
            {
              i3 = i4 + (b + 8);
              i7 = i1 + 1;
            }
            localObject7 = q;
            i1 = i7;
            i4 = i3;
            if (localObject7 != null)
            {
              i4 = i3 + (b + 8);
              i1 = i7 + 1;
            }
            localObject7 = s;
            i8 = i1;
            i7 = i4;
            if (localObject7 != null)
            {
              i7 = i4 + (b + 8);
              i8 = i1 + 1;
            }
            localObject7 = v;
            i3 = i8;
            i1 = i7;
            if (localObject7 != null)
            {
              i1 = i7 + ((a)localObject7).a("RuntimeVisibleTypeAnnotations");
              i3 = i8 + 1;
            }
            localObject7 = w;
            i4 = i3;
            i7 = i1;
            if (localObject7 != null)
            {
              i7 = i1 + ((a)localObject7).a("RuntimeInvisibleTypeAnnotations");
              i4 = i3 + 1;
            }
            localObject4 = x;
            if (localObject4 != null)
            {
              localObject7 = c;
              localObject8 = k;
              i7 += ((b)localObject4).a((x)localObject7, a, b, i, j);
              i4 += x.a();
            }
            localc.d(c.c("Code"));
            localc.c(i7);
            localc.d(i);
            localc.d(j);
            localc.c(k.b);
            localObject7 = k;
            localc.a(a, 0, b);
            localObject7 = l;
            localObject4 = localObject7;
            i3 = 0;
            while (localObject4 != null)
            {
              i3++;
              localObject4 = f;
            }
            localc.d(i3);
            while (localObject7 != null)
            {
              localc.d(a.d);
              localc.d(b.d);
              localc.d(c.d);
              localc.d(d);
              localObject7 = f;
            }
            localc.d(i4);
            if (u != null)
            {
              if (c.c >= 50) {
                i3 = 1;
              } else {
                i3 = 0;
              }
              localObject4 = c;
              if (i3 != 0) {
                localObject7 = "StackMapTable";
              } else {
                localObject7 = "StackMap";
              }
              localc.d(((x)localObject4).c((String)localObject7));
              localc.c(u.b + 2);
              localc.d(t);
              localObject7 = u;
              localc.a(a, 0, b);
            }
            if (o != null)
            {
              localc.d(c.c("LineNumberTable"));
              localc.c(o.b + 2);
              localc.d(n);
              localObject7 = o;
              localc.a(a, 0, b);
            }
            if (q != null)
            {
              localc.d(c.c("LocalVariableTable"));
              localc.c(q.b + 2);
              localc.d(p);
              localObject7 = q;
              localc.a(a, 0, b);
            }
            if (s != null)
            {
              localc.d(c.c("LocalVariableTypeTable"));
              localc.c(s.b + 2);
              localc.d(r);
              localObject7 = s;
              localc.a(a, 0, b);
            }
            localObject7 = v;
            if (localObject7 != null) {
              ((a)localObject7).a(c.c("RuntimeVisibleTypeAnnotations"), localc);
            }
            localObject7 = w;
            if (localObject7 != null) {
              ((a)localObject7).a(c.c("RuntimeInvisibleTypeAnnotations"), localc);
            }
            localObject4 = x;
            if (localObject4 != null)
            {
              localObject7 = c;
              localObject8 = k;
              ((b)localObject4).a((x)localObject7, a, b, i, j, localc);
            }
          }
          if (y > 0)
          {
            localc.d(c.c("Exceptions"));
            localc.c(y * 2 + 2);
            localc.d(y);
            localObject7 = z;
            i1 = localObject7.length;
            for (i3 = 0; i3 < i1; i3++) {
              localc.d(localObject7[i3]);
            }
          }
          b.a(c, d, A, localc);
          a.a(c, B, C, H, I, localc);
          if (E != null)
          {
            i4 = c.c((String)localObject1);
            localObject7 = E;
            i1 = D;
            i3 = i1;
            if (i1 == 0) {
              i3 = localObject7.length;
            }
            a.a(i4, (a[])localObject7, i3, localc);
          }
          localObject7 = localObject1;
          if (G != null)
          {
            i4 = c.c((String)localObject3);
            localObject1 = G;
            i1 = F;
            i3 = i1;
            if (i1 == 0) {
              i3 = localObject1.length;
            }
            a.a(i4, (a[])localObject1, i3, localc);
          }
          if (J != null)
          {
            localc.d(c.c((String)localObject6));
            localc.c(J.b);
            localObject1 = J;
            localc.a(a, 0, b);
          }
          if (L != null)
          {
            localc.d(c.c((String)localObject2));
            localc.c(L.b + 1);
            localc.b(K);
            localObject1 = L;
            localc.a(a, 0, b);
          }
          localObject4 = M;
          localObject1 = localObject7;
          if (localObject4 != null)
          {
            ((b)localObject4).a(c, localc);
            localObject1 = localObject7;
          }
        }
        localObject5 = (t)b;
        i3 = i6;
      }
      localc.d(i2);
      if (m != null)
      {
        localc.d(b.c("InnerClasses"));
        localc.c(m.b + 2);
        localc.d(l);
        localObject1 = m;
        localc.a(a, 0, b);
      }
      if (n != 0)
      {
        localc.d(b.c("EnclosingMethod"));
        localc.c(4);
        localc.d(n);
        localc.d(o);
      }
      if (((c & 0x1000) != 0) && ((a & 0xFFFF) < 49))
      {
        localc.d(b.c("Synthetic"));
        localc.c(0);
      }
      if (p != 0)
      {
        localc.d(b.c("Signature"));
        localc.c(2);
        localc.d(p);
      }
      if (q != 0)
      {
        localc.d(b.c("SourceFile"));
        localc.c(2);
        localc.d(q);
      }
      localObject1 = r;
      if (localObject1 != null)
      {
        i1 = b;
        localc.d(b.c("SourceDebugExtension"));
        localc.c(i1);
        localc.a(r.a, 0, i1);
      }
      if ((c & 0x20000) != 0)
      {
        localc.d(b.c("Deprecated"));
        localc.c(0);
      }
      a.a(b, s, t, u, v, localc);
      localObject1 = b;
      if (j != null)
      {
        localc.d(((x)localObject1).c("BootstrapMethods"));
        localc.c(j.b + 2);
        localc.d(i);
        localObject1 = j;
        localc.a(a, 0, b);
      }
      localObject1 = w;
      if (localObject1 != null)
      {
        i1 = f.b;
        i7 = h.b;
        i8 = j.b;
        i2 = l.b;
        i4 = n.b;
        localc.d(a.c("Module"));
        localc.c(i1 + 16 + i7 + i8 + i2 + i4);
        localc.d(b);
        localc.d(c);
        localc.d(d);
        localc.d(e);
        localObject2 = f;
        localc.a(a, 0, b);
        localc.d(g);
        localObject2 = h;
        localc.a(a, 0, b);
        localc.d(i);
        localObject2 = j;
        localc.a(a, 0, b);
        localc.d(k);
        localObject2 = l;
        localc.a(a, 0, b);
        localc.d(m);
        localObject2 = n;
        localc.a(a, 0, b);
        if (o > 0)
        {
          localc.d(a.c("ModulePackages"));
          localc.c(p.b + 2);
          localc.d(o);
          localObject2 = p;
          localc.a(a, 0, b);
        }
        if (q > 0)
        {
          localc.d(a.c("ModuleMainClass"));
          localc.c(2);
          localc.d(q);
        }
      }
      if (x != 0)
      {
        localc.d(b.c("NestHost"));
        localc.c(2);
        localc.d(x);
      }
      if (z != null)
      {
        localc.d(b.c("NestMembers"));
        localc.c(z.b + 2);
        localc.d(y);
        localObject1 = z;
        localc.a(a, 0, b);
      }
      localObject1 = A;
      if (localObject1 != null) {
        ((b)localObject1).a(b, localc);
      }
      if (i3 != 0) {
        return a(a, i10);
      }
      return a;
    }
    throw new e(b.d, i4);
  }
  
  public final byte[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).a(A);
    for (Object localObject2 = h; localObject2 != null; localObject2 = (m)a) {
      ((b.a)localObject1).a(l);
    }
    for (localObject2 = j; localObject2 != null; localObject2 = (t)b)
    {
      ((b.a)localObject1).a(M);
      ((b.a)localObject1).a(x);
    }
    int i1 = a;
    Object localObject3 = new b[i1];
    System.arraycopy(b, 0, localObject3, 0, i1);
    h = null;
    i = null;
    j = null;
    k = null;
    s = null;
    t = null;
    u = null;
    v = null;
    w = null;
    x = 0;
    y = 0;
    z = null;
    A = null;
    if (paramBoolean) {
      i1 = 3;
    } else {
      i1 = 0;
    }
    B = i1;
    Object localObject4 = new d(paramArrayOfByte, 0, false);
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    int i2 = i1 | 0x100;
    Object localObject5 = new i();
    a = ((b[])localObject3);
    b = i2;
    Object localObject6 = new char[f];
    c = ((char[])localObject6);
    i1 = g;
    int i3 = ((d)localObject4).e(i1);
    Object localObject7 = ((d)localObject4).a(i1 + 2, (char[])localObject6);
    Object localObject8 = ((d)localObject4).a(i1 + 4, (char[])localObject6);
    int i4 = ((d)localObject4).e(i1 + 6);
    Object localObject9 = new String[i4];
    i1 += 8;
    for (int i5 = 0; i5 < i4; i5++)
    {
      localObject9[i5] = ((d)localObject4).a(i1, (char[])localObject6);
      i1 += 2;
    }
    int i6 = ((d)localObject4).a();
    int i7 = ((d)localObject4).e(i6 - 2);
    Object localObject10 = null;
    Object localObject11 = localObject10;
    localObject1 = localObject11;
    localObject2 = localObject1;
    paramArrayOfByte = (byte[])localObject2;
    i5 = i3;
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    int i11 = 0;
    int i12 = 0;
    int i13 = 0;
    int i14 = 0;
    i4 = 0;
    i3 = 0;
    Object localObject12 = paramArrayOfByte;
    int i15 = i1;
    for (;;)
    {
      localObject13 = "Synthetic";
      localObject14 = "Deprecated";
      if (i7 <= 0) {
        break;
      }
      localObject15 = ((d)localObject4).e(i6, (char[])localObject6);
      i16 = ((d)localObject4).b(i6 + 2);
      i1 = i6 + 6;
      if ("SourceFile".equals(localObject15))
      {
        localObject10 = ((d)localObject4).e(i1, (char[])localObject6);
      }
      else
      {
        if ("InnerClasses".equals(localObject15))
        {
          i3 = i1;
        }
        else if ("EnclosingMethod".equals(localObject15))
        {
          i10 = i1;
        }
        else
        {
          if (!"NestHost".equals(localObject15)) {
            break label572;
          }
          paramArrayOfByte = ((d)localObject4).a(i1, (char[])localObject6);
        }
        for (;;)
        {
          break;
          label572:
          if ("NestMembers".equals(localObject15))
          {
            i4 = i1;
          }
          else if ("Signature".equals(localObject15))
          {
            localObject1 = ((d)localObject4).e(i1, (char[])localObject6);
          }
          else if ("RuntimeVisibleAnnotations".equals(localObject15))
          {
            i11 = i1;
          }
          else if ("RuntimeVisibleTypeAnnotations".equals(localObject15))
          {
            i13 = i1;
          }
          else if ("Deprecated".equals(localObject15))
          {
            i5 |= 0x20000;
          }
          else if ("Synthetic".equals(localObject15))
          {
            i5 |= 0x1000;
          }
          else if ("SourceDebugExtension".equals(localObject15))
          {
            localObject12 = ((d)localObject4).a(i1, i16, new char[i16]);
          }
          else
          {
            if ("RuntimeInvisibleAnnotations".equals(localObject15))
            {
              i12 = i1;
              continue;
            }
            if ("RuntimeInvisibleTypeAnnotations".equals(localObject15))
            {
              i14 = i1;
              continue;
            }
            if ("Module".equals(localObject15))
            {
              i8 = i1;
            }
            else
            {
              if ("ModuleMainClass".equals(localObject15))
              {
                localObject2 = ((d)localObject4).a(i1, (char[])localObject6);
                continue;
              }
              if (!"ModulePackages".equals(localObject15)) {
                break label821;
              }
              i9 = i1;
            }
          }
        }
      }
      break label865;
      label821:
      if (!"BootstrapMethods".equals(localObject15))
      {
        localObject15 = ((d)localObject4).a((b[])localObject3, (String)localObject15, i1, i16, (char[])localObject6, -1, null);
        c = ((b)localObject11);
        localObject11 = localObject15;
      }
      label865:
      i6 = i1 + i16;
      i7--;
    }
    i1 = ((d)localObject4).b(b[1] - 7);
    Object localObject16 = "RuntimeInvisibleTypeAnnotations";
    localObject3 = "RuntimeInvisibleAnnotations";
    Object localObject17 = "Signature";
    Object localObject15 = "RuntimeVisibleTypeAnnotations";
    a(i1, i5, (String)localObject7, (String)localObject1, (String)localObject8, (String[])localObject9);
    if (((i2 & 0x2) != 0) || ((localObject10 == null) && (localObject12 == null))) {
      break label1003;
    }
    localObject1 = this;
    if (localObject10 != null) {
      q = b.c((String)localObject10);
    }
    if (localObject12 != null)
    {
      localObject10 = new c();
      ((c)localObject10).a((String)localObject12, 0, Integer.MAX_VALUE);
      r = ((c)localObject10);
    }
    label1003:
    localObject8 = this;
    localObject1 = "RuntimeVisibleAnnotations";
    if (i8 != 0)
    {
      localObject12 = c;
      localObject7 = ((d)localObject4).e(b[localObject4.e(i8)], (char[])localObject12);
      i5 = ((d)localObject4).e(i8 + 2);
      localObject9 = ((d)localObject4).e(i8 + 4, (char[])localObject12);
      i8 += 6;
      localObject10 = b;
      i7 = a19a;
      if (localObject9 == null) {
        i1 = 0;
      } else {
        i1 = b.c((String)localObject9);
      }
      localObject9 = new u((x)localObject10, i7, i5, i1);
      w = ((u)localObject9);
      if (localObject2 != null) {
        q = a.a(7, (String)localObject2).a;
      }
      if (i9 != 0)
      {
        i1 = ((d)localObject4).e(i9);
        i5 = i9 + 2;
        while (i1 > 0)
        {
          localObject2 = ((d)localObject4).d(i5, (char[])localObject12);
          p.d(a.a(20, (String)localObject2).a);
          o += 1;
          i5 += 2;
          i1--;
        }
      }
      i1 = ((d)localObject4).e(i8);
      i5 = i8 + 2;
      localObject2 = localObject1;
      while (i1 > 0)
      {
        localObject10 = ((d)localObject4).c(i5, (char[])localObject12);
        i8 = ((d)localObject4).e(i5 + 2);
        localObject7 = ((d)localObject4).e(i5 + 4, (char[])localObject12);
        i9 = i5 + 6;
        localObject1 = f;
        ((c)localObject1).d(a.a(19, (String)localObject10).a);
        ((c)localObject1).d(i8);
        if (localObject7 == null) {
          i5 = 0;
        } else {
          i5 = a.c((String)localObject7);
        }
        ((c)localObject1).d(i5);
        e += 1;
        i1--;
        i5 = i9;
      }
      localObject1 = localObject2;
      i9 = ((d)localObject4).e(i5);
      i1 = i5 + 2;
      while (i9 > 0)
      {
        localObject7 = ((d)localObject4).d(i1, (char[])localObject12);
        i7 = ((d)localObject4).e(i1 + 2);
        i6 = ((d)localObject4).e(i1 + 4);
        i1 += 6;
        if (i6 != 0)
        {
          localObject10 = new String[i6];
          i8 = 0;
          i5 = i1;
          for (;;)
          {
            i1 = i5;
            localObject2 = localObject10;
            if (i8 >= i6) {
              break;
            }
            localObject10[i8] = ((d)localObject4).c(i5, (char[])localObject12);
            i5 += 2;
            i8++;
          }
        }
        localObject2 = null;
        localObject10 = h;
        ((c)localObject10).d(a.a(20, (String)localObject7).a);
        ((c)localObject10).d(i7);
        if (localObject2 == null)
        {
          h.d(0);
        }
        else
        {
          h.d(localObject2.length);
          i8 = localObject2.length;
          for (i5 = 0; i5 < i8; i5++)
          {
            localObject10 = localObject2[i5];
            h.d(a.b((String)localObject10).a);
          }
        }
        g += 1;
        i9--;
      }
      i5 = ((d)localObject4).e(i1);
      i1 += 2;
      while (i5 > 0)
      {
        localObject10 = ((d)localObject4).d(i1, (char[])localObject12);
        i8 = ((d)localObject4).e(i1 + 2);
        i7 = ((d)localObject4).e(i1 + 4);
        i1 += 6;
        if (i7 != 0)
        {
          localObject2 = new String[i7];
          for (i9 = 0; i9 < i7; i9++)
          {
            localObject2[i9] = ((d)localObject4).c(i1, (char[])localObject12);
            i1 += 2;
          }
        }
        else
        {
          localObject2 = null;
        }
        localObject7 = j;
        ((c)localObject7).d(a.a(20, (String)localObject10).a);
        ((c)localObject7).d(i8);
        if (localObject2 == null)
        {
          j.d(0);
        }
        else
        {
          j.d(localObject2.length);
          i8 = localObject2.length;
          for (i9 = 0; i9 < i8; i9++)
          {
            localObject10 = localObject2[i9];
            j.d(a.b((String)localObject10).a);
          }
        }
        i += 1;
        i5--;
      }
      i5 = ((d)localObject4).e(i1);
      i1 += 2;
      while (i5 > 0)
      {
        localObject2 = ((d)localObject4).a(i1, (char[])localObject12);
        l.d(a.a(7, (String)localObject2).a);
        k += 1;
        i1 += 2;
        i5--;
      }
      i5 = ((d)localObject4).e(i1);
      i1 += 2;
      for (;;)
      {
        localObject2 = localObject1;
        if (i5 <= 0) {
          break;
        }
        localObject10 = ((d)localObject4).a(i1, (char[])localObject12);
        i8 = ((d)localObject4).e(i1 + 2);
        i1 += 4;
        localObject2 = new String[i8];
        for (i9 = 0; i9 < i8; i9++)
        {
          localObject2[i9] = ((d)localObject4).a(i1, (char[])localObject12);
          i1 += 2;
        }
        n.d(a.a(7, (String)localObject10).a);
        n.d(i8);
        for (i9 = 0; i9 < i8; i9++)
        {
          localObject10 = localObject2[i9];
          n.d(a.a((String)localObject10).a);
        }
        m += 1;
        i5--;
      }
    }
    localObject2 = "RuntimeVisibleAnnotations";
    if (paramArrayOfByte != null) {
      x = b.a(7, paramArrayOfByte).a;
    }
    if (i10 != 0)
    {
      localObject12 = ((d)localObject4).a(i10, (char[])localObject6);
      i1 = ((d)localObject4).e(i10 + 2);
      if (i1 == 0) {
        paramArrayOfByte = null;
      } else {
        paramArrayOfByte = ((d)localObject4).e(b[i1], (char[])localObject6);
      }
      if (i1 == 0) {
        localObject1 = null;
      } else {
        localObject1 = ((d)localObject4).e(b[i1] + 2, (char[])localObject6);
      }
      n = b.a(7, (String)localObject12).a;
      if ((paramArrayOfByte != null) && (localObject1 != null)) {
        o = b.a(paramArrayOfByte, (String)localObject1);
      }
    }
    if (i11 != 0)
    {
      i1 = ((d)localObject4).e(i11);
      i5 = i11 + 2;
      while (i1 > 0)
      {
        i5 = ((d)localObject4).a(((f)localObject8).a(((d)localObject4).e(i5, (char[])localObject6), true), i5 + 2, true, (char[])localObject6);
        i1--;
      }
    }
    if (i12 != 0)
    {
      i1 = ((d)localObject4).e(i12);
      i5 = i12 + 2;
      while (i1 > 0)
      {
        i5 = ((d)localObject4).a(((f)localObject8).a(((d)localObject4).e(i5, (char[])localObject6), false), i5 + 2, true, (char[])localObject6);
        i1--;
      }
    }
    if (i13 != 0)
    {
      i1 = ((d)localObject4).e(i13);
      i5 = i13 + 2;
      while (i1 > 0)
      {
        i5 = ((d)localObject4).a((i)localObject5, i5);
        paramArrayOfByte = ((d)localObject4).e(i5, (char[])localObject6);
        i5 = ((d)localObject4).a(((f)localObject8).a(h, i, paramArrayOfByte, true), i5 + 2, true, (char[])localObject6);
        i1--;
      }
    }
    if (i14 != 0)
    {
      i1 = ((d)localObject4).e(i14);
      i5 = i14 + 2;
      while (i1 > 0)
      {
        i5 = ((d)localObject4).a((i)localObject5, i5);
        paramArrayOfByte = ((d)localObject4).e(i5, (char[])localObject6);
        i5 = ((d)localObject4).a(((f)localObject8).a(h, i, paramArrayOfByte, false), i5 + 2, true, (char[])localObject6);
        i1--;
      }
    }
    for (paramArrayOfByte = (byte[])localObject11; paramArrayOfByte != null; paramArrayOfByte = (byte[])localObject1)
    {
      localObject1 = c;
      c = null;
      c = A;
      A = paramArrayOfByte;
    }
    if (i4 != 0)
    {
      i1 = ((d)localObject4).e(i4);
      i5 = i4 + 2;
      while (i1 > 0)
      {
        paramArrayOfByte = ((d)localObject4).a(i5, (char[])localObject6);
        if (z == null) {
          z = new c();
        }
        y += 1;
        z.d(b.a(7, paramArrayOfByte).a);
        i5 += 2;
        i1--;
      }
    }
    if (i3 != 0)
    {
      i1 = ((d)localObject4).e(i3);
      i5 = i3 + 2;
      while (i1 > 0)
      {
        localObject11 = ((d)localObject4).a(i5, (char[])localObject6);
        localObject1 = ((d)localObject4).a(i5 + 2, (char[])localObject6);
        paramArrayOfByte = ((d)localObject4).e(i5 + 4, (char[])localObject6);
        i4 = ((d)localObject4).e(i5 + 6);
        if (m == null) {
          m = new c();
        }
        localObject11 = b.a(7, (String)localObject11);
        if (g == 0)
        {
          l += 1;
          m.d(a);
          localObject12 = m;
          if (localObject1 == null) {
            i3 = 0;
          } else {
            i3 = b.a(7, (String)localObject1).a;
          }
          ((c)localObject12).d(i3);
          localObject1 = m;
          if (paramArrayOfByte == null) {
            i3 = 0;
          } else {
            i3 = b.c(paramArrayOfByte);
          }
          ((c)localObject1).d(i3);
          m.d(i4);
          g = l;
        }
        i5 += 8;
        i1--;
      }
    }
    i1 = ((d)localObject4).e(i15);
    i14 = i15 + 2;
    localObject1 = localObject16;
    localObject10 = localObject17;
    localObject11 = localObject2;
    paramArrayOfByte = (byte[])localObject3;
    localObject2 = localObject15;
    localObject15 = localObject5;
    localObject6 = localObject13;
    localObject9 = localObject14;
    for (;;)
    {
      i12 = i1 - 1;
      if (i1 <= 0) {
        break;
      }
      localObject7 = c;
      i1 = ((d)localObject4).e(i14);
      String str1 = ((d)localObject4).e(i14 + 2, (char[])localObject7);
      String str2 = ((d)localObject4).e(i14 + 4, (char[])localObject7);
      i5 = i14 + 6;
      i11 = ((d)localObject4).e(i5);
      i14 = i5 + 2;
      i10 = 0;
      localObject14 = null;
      i3 = 0;
      i5 = 0;
      i4 = 0;
      localObject5 = null;
      localObject12 = null;
      while (i11 > 0)
      {
        String str3 = ((d)localObject4).e(i14, (char[])localObject7);
        i9 = ((d)localObject4).b(i14 + 2);
        i14 += 6;
        if ("ConstantValue".equals(str3))
        {
          i13 = ((d)localObject4).e(i14);
          if (i13 == 0) {
            localObject12 = null;
          } else {
            localObject12 = ((d)localObject4).b(i13, (char[])localObject7);
          }
        }
        else
        {
          localObject16 = localObject10;
          if (((String)localObject16).equals(str3))
          {
            localObject5 = ((d)localObject4).e(i14, (char[])localObject7);
          }
          else
          {
            if (((String)localObject9).equals(str3)) {
              i1 |= 0x20000;
            }
            for (;;)
            {
              break;
              if (!((String)localObject6).equals(str3)) {
                break label3252;
              }
              i1 |= 0x1000;
            }
          }
        }
        break label3370;
        label3252:
        i13 = i4;
        localObject13 = localObject11;
        if (((String)localObject13).equals(str3))
        {
          localObject3 = localObject1;
          i10 = i14;
          localObject1 = localObject16;
          i4 = i13;
          localObject10 = localObject2;
          localObject11 = paramArrayOfByte;
          paramArrayOfByte = (byte[])localObject3;
          localObject2 = localObject13;
        }
        else
        {
          if (((String)localObject2).equals(str3))
          {
            i4 = i14;
          }
          else
          {
            localObject3 = localObject2;
            localObject17 = paramArrayOfByte;
            if (!((String)localObject17).equals(str3)) {
              break label3346;
            }
            i4 = i13;
            i3 = i14;
          }
          break label3370;
          label3346:
          paramArrayOfByte = (byte[])localObject17;
          localObject2 = localObject1;
          if (((String)localObject2).equals(str3))
          {
            i5 = i14;
            localObject2 = localObject3;
            label3370:
            localObject13 = localObject1;
            localObject1 = localObject10;
            localObject3 = localObject11;
            localObject10 = localObject2;
            localObject11 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject13;
            localObject2 = localObject3;
          }
          else
          {
            localObject17 = a;
            localObject1 = localObject16;
            localObject10 = localObject3;
            localObject11 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject2;
            localObject2 = localObject13;
            localObject13 = ((d)localObject4).a((b[])localObject17, str3, i14, i9, (char[])localObject7, -1, null);
            c = ((b)localObject14);
            i4 = i13;
            localObject14 = localObject13;
          }
        }
        i14 += i9;
        i11--;
        localObject13 = paramArrayOfByte;
        localObject3 = localObject2;
        localObject2 = localObject10;
        paramArrayOfByte = (byte[])localObject11;
        localObject11 = localObject3;
        localObject10 = localObject1;
        localObject1 = localObject13;
      }
      localObject13 = new m(b, i1, str1, str2, (String)localObject5, localObject12);
      if (h == null) {
        h = ((m)localObject13);
      } else {
        i.a = ((l)localObject13);
      }
      i = ((m)localObject13);
      if (i10 != 0)
      {
        i1 = ((d)localObject4).e(i10);
        i13 = i10 + 2;
        while (i1 > 0)
        {
          i13 = ((d)localObject4).a(((l)localObject13).a(((d)localObject4).e(i13, (char[])localObject7), true), i13 + 2, true, (char[])localObject7);
          i1--;
        }
      }
      if (i3 != 0)
      {
        i1 = ((d)localObject4).e(i3);
        i3 += 2;
        while (i1 > 0)
        {
          i3 = ((d)localObject4).a(((l)localObject13).a(((d)localObject4).e(i3, (char[])localObject7), false), i3 + 2, true, (char[])localObject7);
          i1--;
        }
      }
      if (i4 != 0)
      {
        i1 = ((d)localObject4).e(i4);
        i3 = i4 + 2;
        while (i1 > 0)
        {
          i3 = ((d)localObject4).a((i)localObject15, i3);
          localObject12 = ((d)localObject4).e(i3, (char[])localObject7);
          i3 = ((d)localObject4).a(((l)localObject13).a(h, i, (String)localObject12, true), i3 + 2, true, (char[])localObject7);
          i1--;
        }
      }
      localObject12 = localObject14;
      if (i5 != 0)
      {
        i1 = ((d)localObject4).e(i5);
        i5 += 2;
        for (;;)
        {
          localObject12 = localObject14;
          if (i1 <= 0) {
            break;
          }
          i5 = ((d)localObject4).a((i)localObject15, i5);
          localObject12 = ((d)localObject4).e(i5, (char[])localObject7);
          i5 = ((d)localObject4).a(((l)localObject13).a(h, i, (String)localObject12, false), i5 + 2, true, (char[])localObject7);
          i1--;
        }
      }
      while (localObject12 != null)
      {
        localObject5 = c;
        c = null;
        c = l;
        l = ((b)localObject12);
        localObject12 = localObject5;
      }
      i1 = i12;
    }
    Object localObject13 = null;
    localObject5 = localObject6;
    i2 = ((d)localObject4).e(i14);
    int i16 = i14 + 2;
    localObject12 = localObject11;
    localObject11 = localObject1;
    localObject1 = localObject2;
    localObject6 = localObject10;
    localObject10 = localObject9;
    localObject2 = localObject5;
    Object localObject14 = localObject4;
    localObject9 = localObject13;
    while (i2 > 0)
    {
      localObject16 = c;
      d = ((d)localObject14).e(i16);
      e = ((d)localObject14).e(i16 + 2, (char[])localObject16);
      int i17 = i16 + 4;
      f = ((d)localObject14).e(i17, (char[])localObject16);
      i10 = i16 + 6;
      int i18 = ((d)localObject14).e(i10);
      i1 = i10 + 2;
      localObject5 = localObject9;
      i9 = 0;
      i5 = 0;
      i4 = 0;
      i3 = 0;
      i13 = 0;
      int i19 = 0;
      i11 = 0;
      i14 = 0;
      i7 = 0;
      i15 = 0;
      i8 = 0;
      i12 = 0;
      while (i18 > 0)
      {
        localObject17 = ((d)localObject14).e(i1, (char[])localObject16);
        int i20 = ((d)localObject14).b(i1 + 2);
        i1 += 6;
        if ("Code".equals(localObject17))
        {
          if ((b & 0x1) == 0) {
            i12 = i1;
          }
        }
        else
        {
          if ("Exceptions".equals(localObject17))
          {
            int i21 = ((d)localObject14).e(i1);
            localObject5 = new String[i21];
            i6 = i1 + 2;
            for (i4 = 0; i4 < i21; i4++)
            {
              localObject5[i4] = ((d)localObject14).a(i6, (char[])localObject16);
              i6 += 2;
            }
            i4 = i1;
            break label4273;
          }
          if (((String)localObject6).equals(localObject17))
          {
            i3 = ((d)localObject14).e(i1);
          }
          else
          {
            localObject4 = localObject10;
            if (!((String)localObject4).equals(localObject17)) {
              break label4251;
            }
            d |= 0x20000;
          }
        }
        break label4450;
        label4251:
        i6 = i10;
        localObject13 = localObject12;
        if (((String)localObject13).equals(localObject17))
        {
          i13 = i1;
        }
        else
        {
          label4273:
          localObject12 = localObject13;
          if (((String)localObject1).equals(localObject17))
          {
            i14 = i1;
          }
          else
          {
            if (!"AnnotationDefault".equals(localObject17)) {
              break label4314;
            }
            i5 = i1;
          }
        }
        for (;;)
        {
          break;
          label4314:
          if (((String)localObject2).equals(localObject17))
          {
            d |= 0x1000;
            i10 = i6;
            localObject10 = localObject4;
            localObject4 = localObject1;
            localObject1 = localObject12;
            i19 = 1;
            localObject12 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject4;
            break label4527;
          }
          if (paramArrayOfByte.equals(localObject17))
          {
            i11 = i1;
          }
          else
          {
            localObject13 = localObject11;
            if (((String)localObject13).equals(localObject17))
            {
              i7 = i1;
            }
            else if ("RuntimeVisibleParameterAnnotations".equals(localObject17))
            {
              i15 = i1;
            }
            else if ("RuntimeInvisibleParameterAnnotations".equals(localObject17))
            {
              i8 = i1;
            }
            else
            {
              if (!"MethodParameters".equals(localObject17)) {
                break label4465;
              }
              i9 = i1;
            }
          }
        }
        label4450:
        localObject4 = localObject12;
        localObject12 = paramArrayOfByte;
        paramArrayOfByte = (byte[])localObject1;
        localObject1 = localObject4;
        break label4527;
        label4465:
        localObject8 = a;
        localObject10 = localObject4;
        i10 = i6;
        localObject4 = localObject12;
        localObject3 = localObject1;
        localObject12 = paramArrayOfByte;
        localObject11 = localObject13;
        paramArrayOfByte = ((d)localObject14).a((b[])localObject8, (String)localObject17, i1, i20, (char[])localObject16, -1, null);
        c = ((b)localObject9);
        localObject9 = paramArrayOfByte;
        localObject1 = localObject4;
        paramArrayOfByte = (byte[])localObject3;
        label4527:
        i1 += i20;
        i18--;
        localObject4 = localObject12;
        localObject12 = localObject1;
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = (byte[])localObject4;
      }
      i18 = d;
      localObject13 = e;
      localObject3 = f;
      if (i3 == 0) {
        localObject4 = null;
      } else {
        localObject4 = ((d)localObject14).f(i3, (char[])localObject16);
      }
      i6 = i5;
      localObject4 = a(i18, (String)localObject13, (String)localObject3, (String)localObject4, (String[])localObject5);
      localObject13 = (t)localObject4;
      if ((d & 0x20000) != 0) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      i18 = ((d)localObject14).e(i17);
      if ((localObject14 == c.b) && (i18 == g) && (i3 == A))
      {
        if ((d & 0x20000) != 0) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        if (i5 == i3)
        {
          if ((c.c < 49) && ((d & 0x1000) != 0)) {
            i5 = 1;
          } else {
            i5 = 0;
          }
          if (i19 == i5)
          {
            if (i4 == 0)
            {
              if (y != 0) {
                break label4846;
              }
            }
            else if (((d)localObject14).e(i4) == y)
            {
              i5 = i4 + 2;
              for (i3 = 0; i3 < y; i3++)
              {
                if (((d)localObject14).e(i5) != z[i3]) {
                  break label4846;
                }
                i5 += 2;
              }
            }
            i5 = 1;
            break label4849;
          }
        }
      }
      label4846:
      i5 = 0;
      label4849:
      if (i5 != 0)
      {
        a0 = i10;
        b0 = (i1 - i16 - 6);
      }
      else
      {
        if (i9 != 0)
        {
          i5 = ((d)localObject14).a(i9);
          i3 = i9 + 1;
          while (i5 > 0)
          {
            localObject3 = ((d)localObject14).e(i3, (char[])localObject16);
            i10 = ((d)localObject14).e(i3 + 2);
            if (L == null) {
              L = new c();
            }
            K += 1;
            localObject5 = L;
            if (localObject3 == null) {
              i4 = 0;
            } else {
              i4 = c.c((String)localObject3);
            }
            ((c)localObject5).d(i4);
            ((c)localObject5).d(i10);
            i3 += 4;
            i5--;
          }
        }
        if (i6 != 0)
        {
          localObject5 = new c();
          J = ((c)localObject5);
          localObject5 = new a(c, false, (c)localObject5, null);
          ((d)localObject14).a((a)localObject5, i6, null, (char[])localObject16);
          ((a)localObject5).a();
        }
        if (i13 != 0)
        {
          i5 = ((d)localObject14).e(i13);
          i3 = i13 + 2;
          while (i5 > 0)
          {
            i3 = ((d)localObject14).a(((s)localObject4).a(((d)localObject14).e(i3, (char[])localObject16), true), i3 + 2, true, (char[])localObject16);
            i5--;
          }
        }
        if (i11 != 0)
        {
          i5 = ((d)localObject14).e(i11);
          i3 = i11 + 2;
          while (i5 > 0)
          {
            i3 = ((d)localObject14).a(((s)localObject4).a(((d)localObject14).e(i3, (char[])localObject16), false), i3 + 2, true, (char[])localObject16);
            i5--;
          }
        }
        if (i14 != 0)
        {
          i5 = ((d)localObject14).e(i14);
          i3 = i14 + 2;
          while (i5 > 0)
          {
            i3 = ((d)localObject14).a((i)localObject15, i3);
            localObject5 = ((d)localObject14).e(i3, (char[])localObject16);
            i3 = ((d)localObject14).a(((s)localObject4).b(h, i, (String)localObject5, true), i3 + 2, true, (char[])localObject16);
            i5--;
          }
        }
        if (i7 != 0)
        {
          i5 = ((d)localObject14).e(i7);
          i3 = i7 + 2;
          while (i5 > 0)
          {
            i3 = ((d)localObject14).a((i)localObject15, i3);
            localObject5 = ((d)localObject14).e(i3, (char[])localObject16);
            i3 = ((d)localObject14).a(((s)localObject4).b(h, i, (String)localObject5, false), i3 + 2, true, (char[])localObject16);
            i5--;
          }
        }
        if (i15 != 0) {
          ((d)localObject14).a((s)localObject4, (i)localObject15, i15, true);
        }
        if (i8 != 0) {
          ((d)localObject14).a((s)localObject4, (i)localObject15, i8, false);
        }
        for (localObject5 = localObject9; localObject5 != null; localObject5 = localObject9)
        {
          localObject9 = c;
          c = null;
          c = M;
          M = ((b)localObject5);
        }
        if (i12 != 0) {
          ((d)localObject14).a((s)localObject4, (i)localObject15, i12);
        }
      }
      localObject9 = null;
      i2--;
      i16 = i1;
    }
    return a();
  }
}

/* Location:
 * Qualified Name:     base.k.e.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */