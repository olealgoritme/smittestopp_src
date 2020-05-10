package l.e.a;

public class n
{
  public q a;
  public int[] b;
  public int[] c;
  public int[] d;
  public int[] e;
  public short f;
  public short g;
  public int h;
  public int[] i;
  
  public n(q paramq)
  {
    a = paramq;
  }
  
  public static int a(x paramx, Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return 0x400000 | ((Integer)paramObject).intValue();
    }
    if ((paramObject instanceof String)) {
      return a(paramx, y.c((String)paramObject).a(), 0);
    }
    return paramx.a("", d) | 0xC00000;
  }
  
  public static int a(x paramx, String paramString, int paramInt)
  {
    int j = paramString.charAt(paramInt);
    int k = 4194306;
    if (j != 70)
    {
      if (j != 76)
      {
        if (j != 83)
        {
          if (j != 86)
          {
            if (j == 73) {
              break label286;
            }
            if (j != 74)
            {
              if (j == 90) {
                break label286;
              }
              if (j == 91) {}
            }
          }
          switch (j)
          {
          default: 
            throw new IllegalArgumentException();
          case 68: 
            return 4194307;
            for (j = paramInt + 1; paramString.charAt(j) == '['; j++) {}
            int m = paramString.charAt(j);
            if (m != 70) {
              if (m != 76)
              {
                if (m != 83)
                {
                  if (m != 90)
                  {
                    if (m != 73)
                    {
                      if (m != 74) {
                        switch (m)
                        {
                        default: 
                          throw new IllegalArgumentException();
                        case 68: 
                          k = 4194307;
                          break;
                        case 67: 
                          k = 4194315;
                          break;
                        case 66: 
                          k = 4194314;
                          break;
                        }
                      } else {
                        k = 4194308;
                      }
                    }
                    else {
                      k = 4194305;
                    }
                  }
                  else {
                    k = 4194313;
                  }
                }
                else {
                  k = 4194316;
                }
              }
              else {
                k = paramx.d(paramString.substring(j + 1, paramString.length() - 1)) | 0x800000;
              }
            }
            return j - paramInt << 26 | k;
            return 4194308;
            return 0;
          }
        }
        label286:
        return 4194305;
      }
      return paramx.d(paramString.substring(paramInt + 1, paramString.length() - 1)) | 0x800000;
    }
    return 4194306;
  }
  
  public static boolean a(x paramx, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int j = paramArrayOfInt[paramInt2];
    if (j == paramInt1) {
      return false;
    }
    int k = paramInt1;
    if ((0x3FFFFFF & paramInt1) == 4194309)
    {
      if (j == 4194309) {
        return false;
      }
      k = 4194309;
    }
    if (j == 0)
    {
      paramArrayOfInt[paramInt2] = k;
      return true;
    }
    int m = j & 0xFC000000;
    paramInt1 = 4194304;
    if ((m == 0) && ((j & 0x3C00000) != 8388608))
    {
      if (j == 4194309)
      {
        paramInt1 = k;
        if ((k & 0xFC000000) == 0) {
          if ((k & 0x3C00000) == 8388608) {
            paramInt1 = k;
          } else {
            paramInt1 = 4194304;
          }
        }
      }
    }
    else
    {
      if (k == 4194309) {
        return false;
      }
      Object localObject1 = "java/lang/Object";
      int n;
      if ((k & 0xFFC00000) == (0xFFC00000 & j))
      {
        if ((j & 0x3C00000) == 8388608)
        {
          n = k & 0xFFFFF;
          paramInt1 = 0xFFFFF & j;
          long l1;
          long l2;
          if (n < paramInt1)
          {
            l1 = n;
            l2 = paramInt1;
          }
          else
          {
            l1 = paramInt1;
            l2 = n;
          }
          l1 |= l2 << 32;
          m = x.b(130, n + paramInt1);
          for (Object localObject2 = paramx.b(m); localObject2 != null; localObject2 = i) {
            if ((b == 130) && (h == m) && (f == l1))
            {
              paramInt1 = g;
              break label489;
            }
          }
          Object localObject3 = l;
          localObject2 = e;
          String str = e;
          if (a != null)
          {
            Object localObject4 = g.class.getClassLoader();
            try
            {
              localObject3 = Class.forName(((String)localObject2).replace('/', '.'), false, (ClassLoader)localObject4);
              try
              {
                localObject4 = Class.forName(str.replace('/', '.'), false, (ClassLoader)localObject4);
                if (!((Class)localObject3).isAssignableFrom((Class)localObject4)) {
                  if (((Class)localObject4).isAssignableFrom((Class)localObject3))
                  {
                    localObject2 = str;
                  }
                  else
                  {
                    localObject2 = localObject1;
                    if (!((Class)localObject3).isInterface())
                    {
                      localObject2 = localObject3;
                      if (((Class)localObject4).isInterface())
                      {
                        localObject2 = localObject1;
                      }
                      else
                      {
                        do
                        {
                          localObject1 = ((Class)localObject2).getSuperclass();
                          localObject2 = localObject1;
                        } while (!((Class)localObject1).isAssignableFrom((Class)localObject4));
                        localObject2 = ((Class)localObject1).getName().replace('.', '/');
                      }
                    }
                  }
                }
                paramInt1 = paramx.d((String)localObject2);
                localObject2 = new x.a(paramx.k, 130, l1, m);
                paramx.b((x.a)localObject2);
                g = paramInt1;
                label489:
                paramInt1 = k & 0xFC000000 | 0x800000 | paramInt1;
              }
              catch (ClassNotFoundException paramx)
              {
                throw new TypeNotPresentException(str, paramx);
              }
              throw null;
            }
            catch (ClassNotFoundException paramx)
            {
              throw new TypeNotPresentException((String)localObject2, paramx);
            }
          }
        }
        k = (k & 0xFC000000) - 67108864 | 0x800000;
      }
      for (paramInt1 = paramx.d("java/lang/Object");; paramInt1 = paramx.d("java/lang/Object"))
      {
        paramInt1 = k | paramInt1;
        break;
        n = k & 0xFC000000;
        if ((n == 0) && ((k & 0x3C00000) != 8388608)) {
          break;
        }
        paramInt1 = n;
        if (n != 0)
        {
          paramInt1 = n;
          if ((k & 0x3C00000) != 8388608) {
            paramInt1 = n - 67108864;
          }
        }
        k = m;
        if (m != 0)
        {
          k = m;
          if ((j & 0x3C00000) != 8388608) {
            k = m - 67108864;
          }
        }
        k = Math.min(paramInt1, k) | 0x800000;
      }
    }
    if (paramInt1 != j)
    {
      paramArrayOfInt[paramInt2] = paramInt1;
      return true;
    }
    return false;
  }
  
  public final int a()
  {
    int j = g;
    if (j > 0)
    {
      int[] arrayOfInt = e;
      j = (short)(j - 1);
      g = ((short)j);
      return arrayOfInt[j];
    }
    j = (short)(f - 1);
    f = ((short)j);
    return 0x1400000 | -j;
  }
  
  public final int a(int paramInt)
  {
    int[] arrayOfInt = d;
    if ((arrayOfInt != null) && (paramInt < arrayOfInt.length))
    {
      int j = arrayOfInt[paramInt];
      int k = j;
      if (j == 0)
      {
        k = paramInt | 0x1000000;
        arrayOfInt[paramInt] = k;
      }
      return k;
    }
    return paramInt | 0x1000000;
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    int j = 0xFC000000 & paramInt1;
    int k = 0x3C00000 & paramInt1;
    int m = 4194304;
    if (k == 16777216)
    {
      paramInt2 = j + b[(paramInt1 & 0xFFFFF)];
      if ((paramInt1 & 0x100000) != 0)
      {
        paramInt1 = m;
        if (paramInt2 == 4194308) {
          break label64;
        }
        if (paramInt2 == 4194307)
        {
          paramInt1 = m;
          break label64;
        }
      }
      paramInt1 = paramInt2;
      label64:
      return paramInt1;
    }
    if (k == 20971520)
    {
      paramInt2 = j + c[(paramInt2 - (0xFFFFF & paramInt1))];
      if ((paramInt1 & 0x100000) != 0)
      {
        paramInt1 = m;
        if (paramInt2 == 4194308) {
          break label117;
        }
        if (paramInt2 == 4194307)
        {
          paramInt1 = m;
          break label117;
        }
      }
      paramInt1 = paramInt2;
      label117:
      return paramInt1;
    }
    return paramInt1;
  }
  
  public final int a(x paramx, int paramInt)
  {
    if ((paramInt == 4194310) || ((0xFFC00000 & paramInt) == 12582912)) {
      for (int j = 0; j < h; j++)
      {
        int k = i[j];
        int m = 0x3C00000 & k;
        int n = k & 0xFFFFF;
        if (m == 16777216) {}
        int[] arrayOfInt;
        for (int i1 = b[n];; i1 = arrayOfInt[(arrayOfInt.length - n)])
        {
          i1 += (0xFC000000 & k);
          break;
          i1 = k;
          if (m != 20971520) {
            break;
          }
          arrayOfInt = c;
        }
        if (paramInt == i1)
        {
          if (paramInt == 4194310) {}
          for (paramInt = paramx.d(d);; paramInt = paramx.d(l[(paramInt & 0xFFFFF)].e)) {
            return paramInt | 0x800000;
          }
        }
      }
    }
    return paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, w paramw, x paramx)
  {
    switch (paramInt1)
    {
    default: 
      switch (paramInt1)
      {
      default: 
        int j;
        switch (paramInt1)
        {
        default: 
          Object localObject;
          switch (paramInt1)
          {
          default: 
            switch (paramInt1)
            {
            default: 
              throw new IllegalArgumentException();
            case 197: 
              b(paramInt2);
              a(paramx, e);
            }
            break;
          case 192: 
            paramw = e;
            a();
            if (paramw.charAt(0) == '[') {
              a(paramx, paramw);
            } else {
              c(paramx.d(paramw) | 0x800000);
            }
            break;
          case 189: 
            localObject = e;
            a();
            if (((String)localObject).charAt(0) == '[')
            {
              paramw = new StringBuilder();
              paramw.append('[');
              paramw.append((String)localObject);
              a(paramx, paramw.toString());
            }
            else
            {
              c(paramx.d((String)localObject) | 0x4800000);
            }
            break;
          case 188: 
            a();
            switch (paramInt2)
            {
            default: 
              throw new IllegalArgumentException();
            case 11: 
              c(71303172);
              break;
            case 10: 
              c(71303169);
              break;
            case 9: 
              c(71303180);
              break;
            case 8: 
              c(71303178);
              break;
            case 7: 
              c(71303171);
              break;
            case 6: 
              c(71303170);
              break;
            case 5: 
              c(71303179);
              break;
            case 4: 
              c(71303177);
            }
            break;
          case 187: 
            c(0xC00000 | paramx.a(e, paramInt2));
            break;
          case 186: 
            a(e);
            a(paramx, e);
            break;
          case 182: 
          case 183: 
          case 184: 
          case 185: 
            a(e);
            if (paramInt1 != 184)
            {
              paramInt2 = a();
              if ((paramInt1 == 183) && (d.charAt(0) == '<'))
              {
                if (i == null) {
                  i = new int[2];
                }
                j = i.length;
                paramInt1 = h;
                if (paramInt1 >= j)
                {
                  localObject = new int[Math.max(paramInt1 + 1, j * 2)];
                  System.arraycopy(i, 0, localObject, 0, j);
                  i = ((int[])localObject);
                }
                localObject = i;
                paramInt1 = h;
                h = (paramInt1 + 1);
                localObject[paramInt1] = paramInt2;
              }
            }
            a(paramx, e);
            break;
          case 181: 
            a(e);
            a();
            break;
          case 180: 
            b(1);
            a(paramx, e);
            break;
          case 179: 
            a(e);
            break;
          case 178: 
            a(paramx, e);
            break;
          case 168: 
          case 169: 
            throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
          case 148: 
          case 151: 
          case 152: 
            b(4);
            c(4194305);
            break;
          case 139: 
          case 190: 
          case 193: 
            b(1);
            c(4194305);
            break;
          case 135: 
          case 141: 
            b(1);
            c(4194307);
            c(4194304);
            break;
          case 134: 
            b(1);
            c(4194306);
            break;
          case 133: 
          case 140: 
            b(1);
            c(4194308);
            c(4194304);
            break;
          case 132: 
            b(paramInt2, 4194305);
            break;
          case 121: 
          case 123: 
          case 125: 
            b(3);
            c(4194308);
            c(4194304);
            break;
          case 99: 
          case 103: 
          case 107: 
          case 111: 
          case 115: 
            b(4);
            c(4194307);
            c(4194304);
            break;
          case 97: 
          case 101: 
          case 105: 
          case 109: 
          case 113: 
          case 127: 
          case 129: 
          case 131: 
            b(4);
            c(4194308);
            c(4194304);
            break;
          case 95: 
            paramInt2 = a();
            paramInt1 = a();
            c(paramInt2);
            c(paramInt1);
            break;
          case 94: 
            paramInt1 = a();
            paramInt2 = a();
            int k = a();
            j = a();
            c(paramInt2);
            c(paramInt1);
            c(j);
            c(k);
            c(paramInt2);
            c(paramInt1);
            break;
          case 93: 
            j = a();
            paramInt2 = a();
            paramInt1 = a();
            c(paramInt2);
            c(j);
            c(paramInt1);
            c(paramInt2);
            c(j);
            break;
          case 92: 
            paramInt2 = a();
            paramInt1 = a();
            c(paramInt1);
            c(paramInt2);
            c(paramInt1);
            c(paramInt2);
            break;
          case 91: 
            paramInt2 = a();
            paramInt1 = a();
            j = a();
            c(paramInt2);
            c(j);
            c(paramInt1);
            c(paramInt2);
            break;
          case 90: 
            paramInt1 = a();
            paramInt2 = a();
            c(paramInt1);
            c(paramInt2);
            c(paramInt1);
            break;
          case 89: 
            paramInt1 = a();
            c(paramInt1);
            c(paramInt1);
            break;
          case 88: 
          case 159: 
          case 160: 
          case 161: 
          case 162: 
          case 163: 
          case 164: 
          case 165: 
          case 166: 
          case 173: 
          case 175: 
            b(2);
            break;
          case 87: 
          case 153: 
          case 154: 
          case 155: 
          case 156: 
          case 157: 
          case 158: 
          case 170: 
          case 171: 
          case 172: 
          case 174: 
          case 176: 
          case 191: 
          case 194: 
          case 195: 
            b(1);
            break;
          case 80: 
          case 82: 
            b(4);
            break;
          case 79: 
          case 81: 
          case 83: 
          case 84: 
          case 85: 
          case 86: 
            b(3);
          }
          break;
        case 55: 
        case 57: 
          b(1);
          b(paramInt2, a());
          b(paramInt2 + 1, 4194304);
          if (paramInt2 > 0)
          {
            paramInt2--;
            paramInt1 = a(paramInt2);
            if ((paramInt1 != 4194308) && (paramInt1 != 4194307))
            {
              j = paramInt1 & 0x3C00000;
              if ((j == 16777216) || (j == 20971520)) {
                b(paramInt2, paramInt1 | 0x100000);
              }
            }
            else
            {
              b(paramInt2, 4194304);
            }
          }
          break;
        case 54: 
        case 56: 
        case 58: 
          b(paramInt2, a());
          if (paramInt2 > 0)
          {
            paramInt2--;
            paramInt1 = a(paramInt2);
            if ((paramInt1 != 4194308) && (paramInt1 != 4194307))
            {
              j = paramInt1 & 0x3C00000;
              if ((j == 16777216) || (j == 20971520)) {
                b(paramInt2, paramInt1 | 0x100000);
              }
            }
            else
            {
              b(paramInt2, 4194304);
            }
          }
          break;
        case 50: 
          b(1);
          paramInt1 = a();
          if (paramInt1 != 4194309) {
            paramInt1 -= 67108864;
          }
          c(paramInt1);
          break;
        case 49: 
          b(2);
          c(4194307);
          c(4194304);
          break;
        case 48: 
          b(2);
          c(4194306);
          break;
        case 47: 
          b(2);
          c(4194308);
          c(4194304);
          break;
        case 46: 
        case 51: 
        case 52: 
        case 53: 
          b(2);
          c(4194305);
        }
        break;
      case 25: 
        c(a(paramInt2));
      }
      break;
    case 18: 
      paramInt1 = b;
      switch (paramInt1)
      {
      default: 
        switch (paramInt1)
        {
        default: 
          throw new AssertionError();
        case 17: 
          a(paramx, e);
          break;
        case 16: 
          c(paramx.d("java/lang/invoke/MethodType") | 0x800000);
          break;
        case 15: 
          c(paramx.d("java/lang/invoke/MethodHandle") | 0x800000);
        }
        break;
      case 8: 
        c(paramx.d("java/lang/String") | 0x800000);
        break;
      case 7: 
        c(paramx.d("java/lang/Class") | 0x800000);
        break;
      case 6: 
        c(4194307);
        c(4194304);
        break;
      case 5: 
        c(4194308);
        c(4194304);
        break;
      case 4: 
        c(4194306);
        break;
      case 3: 
        c(4194305);
      }
      break;
    case 14: 
    case 15: 
      c(4194307);
      c(4194304);
      break;
    case 11: 
    case 12: 
    case 13: 
      c(4194306);
      break;
    case 9: 
    case 10: 
      c(4194308);
      c(4194304);
      break;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 16: 
    case 17: 
      c(4194305);
      break;
    case 1: 
      c(4194309);
    }
  }
  
  public final void a(String paramString)
  {
    int j = paramString.charAt(0);
    if (j == 40) {
      b((y.b(paramString) >> 2) - 1);
    } else if ((j != 74) && (j != 68)) {
      b(1);
    } else {
      b(2);
    }
  }
  
  public final void a(t paramt)
  {
    int[] arrayOfInt1 = b;
    int j = 0;
    int k = 0;
    int m = 0;
    int i2;
    int i3;
    for (;;)
    {
      n = 0;
      do
      {
        i1 = arrayOfInt1.length;
        i2 = 2;
        if (k >= i1) {
          break;
        }
        i3 = arrayOfInt1[k];
        i1 = i2;
        if (i3 != 4194308) {
          if (i3 == 4194307) {
            i1 = i2;
          } else {
            i1 = 1;
          }
        }
        k += i1;
        n++;
      } while (i3 == 4194304);
      m += n;
    }
    int[] arrayOfInt2 = c;
    int n = 0;
    for (k = 0; n < arrayOfInt2.length; k++)
    {
      i1 = arrayOfInt2[n];
      if ((i1 != 4194308) && (i1 != 4194307)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      n += i1;
    }
    paramt.a(a.d, m, k);
    n = 3;
    int i1 = 0;
    int i4 = m;
    for (;;)
    {
      i3 = j;
      i2 = n;
      m = k;
      if (i4 <= 0) {
        break;
      }
      i2 = arrayOfInt1[i1];
      if ((i2 != 4194308) && (i2 != 4194307)) {
        m = 1;
      } else {
        m = 2;
      }
      i1 += m;
      W[n] = i2;
      i4--;
      n++;
    }
    while (m > 0)
    {
      n = arrayOfInt2[i3];
      if ((n != 4194308) && (n != 4194307)) {
        k = 1;
      } else {
        k = 2;
      }
      i3 += k;
      W[i2] = n;
      i2++;
      m--;
    }
    paramt.b();
  }
  
  public final void a(x paramx, int paramInt1, String paramString, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt2];
    b = arrayOfInt;
    c = new int[0];
    int j = 1;
    if ((paramInt1 & 0x8) == 0)
    {
      if ((paramInt1 & 0x40000) == 0)
      {
        arrayOfInt[0] = (0x800000 | paramx.d(d));
        paramInt1 = j;
      }
      else
      {
        arrayOfInt[0] = 4194310;
        paramInt1 = j;
      }
    }
    else {
      paramInt1 = 0;
    }
    paramString = y.a(paramString);
    int k = paramString.length;
    int m;
    for (j = 0;; j++)
    {
      m = paramInt1;
      if (j >= k) {
        break;
      }
      int n = a(paramx, paramString[j].a(), 0);
      arrayOfInt = b;
      m = paramInt1 + 1;
      arrayOfInt[paramInt1] = n;
      if ((n != 4194308) && (n != 4194307))
      {
        paramInt1 = m;
      }
      else
      {
        b[m] = 4194304;
        paramInt1 = m + 1;
      }
    }
    while (m < paramInt2)
    {
      b[m] = 4194304;
      m++;
    }
  }
  
  public final void a(x paramx, String paramString)
  {
    int j = 0;
    if (paramString.charAt(0) == '(') {
      j = y.d(paramString);
    }
    j = a(paramx, paramString, j);
    if (j != 0)
    {
      c(j);
      if ((j == 4194308) || (j == 4194307)) {
        c(4194304);
      }
    }
  }
  
  public final boolean a(x paramx, n paramn, int paramInt)
  {
    int j = b.length;
    int k = c.length;
    int[] arrayOfInt = b;
    int m = 0;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3;
    if (arrayOfInt == null)
    {
      b = new int[j];
      bool3 = true;
    }
    else
    {
      bool3 = false;
    }
    for (int n = 0; n < j; n++)
    {
      arrayOfInt = d;
      if ((arrayOfInt != null) && (n < arrayOfInt.length))
      {
        i1 = arrayOfInt[n];
        if (i1 == 0) {
          i1 = b[n];
        } else {
          i1 = a(i1, k);
        }
      }
      else
      {
        i1 = b[n];
      }
      i2 = i1;
      if (i != null) {
        i2 = a(paramx, i1);
      }
      bool3 |= a(paramx, i2, b, n);
    }
    if (paramInt > 0)
    {
      for (i1 = 0; i1 < j; i1++) {
        bool3 |= a(paramx, b[i1], b, i1);
      }
      if (c == null)
      {
        c = new int[1];
        bool3 = bool2;
      }
      return a(paramx, paramInt, c, 0) | bool3;
    }
    int i2 = c.length + f;
    if (c == null)
    {
      c = new int[g + i2];
      bool3 = bool1;
    }
    for (int i1 = 0;; i1++)
    {
      paramInt = m;
      bool2 = bool3;
      if (i1 >= i2) {
        break;
      }
      n = c[i1];
      paramInt = n;
      if (i != null) {
        paramInt = a(paramx, n);
      }
      bool3 |= a(paramx, paramInt, c, i1);
    }
    while (paramInt < g)
    {
      n = a(e[paramInt], k);
      i1 = n;
      if (i != null) {
        i1 = a(paramx, n);
      }
      bool2 |= a(paramx, i1, c, i2 + paramInt);
      paramInt++;
    }
    return bool2;
  }
  
  public final void b(int paramInt)
  {
    int j = g;
    if (j >= paramInt)
    {
      g = ((short)(short)(j - paramInt));
    }
    else
    {
      f = ((short)(short)(f - (paramInt - j)));
      g = ((short)0);
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    if (d == null) {
      d = new int[10];
    }
    int j = d.length;
    if (paramInt1 >= j)
    {
      int[] arrayOfInt = new int[Math.max(paramInt1 + 1, j * 2)];
      System.arraycopy(d, 0, arrayOfInt, 0, j);
      d = arrayOfInt;
    }
    d[paramInt1] = paramInt2;
  }
  
  public final void c(int paramInt)
  {
    if (e == null) {
      e = new int[10];
    }
    int j = e.length;
    int k = g;
    if (k >= j)
    {
      localObject = new int[Math.max(k + 1, j * 2)];
      System.arraycopy(e, 0, localObject, 0, j);
      e = ((int[])localObject);
    }
    Object localObject = e;
    j = g;
    k = (short)(j + 1);
    g = ((short)k);
    localObject[j] = paramInt;
    paramInt = (short)(f + k);
    localObject = a;
    if (paramInt > h) {
      h = ((short)paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     l.e.a.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */