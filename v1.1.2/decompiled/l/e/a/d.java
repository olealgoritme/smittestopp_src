package l.e.a;

public class d
{
  public final byte[] a;
  public final int[] b;
  public final String[] c;
  public final h[] d;
  public final int[] e;
  public final int f;
  public final int g;
  
  public d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    a = paramArrayOfByte;
    if (paramBoolean)
    {
      i = paramInt + 6;
      if (d(i) > 57)
      {
        paramArrayOfByte = e.a.a.a.a.a("Unsupported class file major version ");
        paramArrayOfByte.append(d(i));
        throw new IllegalArgumentException(paramArrayOfByte.toString());
      }
    }
    int j = e(paramInt + 8);
    b = new int[j];
    c = new String[j];
    int k = paramInt + 10;
    int m = 0;
    int i = 1;
    int n = 0;
    paramInt = 0;
    int i1 = 0;
    for (;;)
    {
      int i2 = 4;
      if (i >= j) {
        break;
      }
      localObject = b;
      int i3 = i + 1;
      int i4 = k + 1;
      localObject[i] = i4;
      int i5 = paramInt;
      int i6 = paramInt;
      int i7 = i1;
      int i8 = n;
      i = i2;
      i2 = i3;
      switch (paramArrayOfByte[k])
      {
      case 2: 
      case 13: 
      case 14: 
      default: 
        throw new IllegalArgumentException();
      case 17: 
        i5 = 1;
      case 18: 
        i7 = 1;
        i6 = i5;
        break;
      case 7: 
      case 8: 
      case 16: 
      case 19: 
      case 20: 
        i = 3;
        i2 = i3;
        break;
      case 5: 
      case 6: 
        i = 9;
        i2 = i3 + 1;
        i8 = n;
        break;
      case 3: 
      case 4: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
        i = 5;
        paramInt = i6;
        i1 = i7;
        i2 = i3;
        break;
      case 1: 
        i6 = e(i4) + 3;
        i8 = n;
        i = i6;
        i2 = i3;
        if (i6 > n)
        {
          i8 = i6;
          i2 = i3;
          i = i6;
        }
        break;
      }
      n = i8;
      k += i;
      i = i2;
    }
    f = n;
    g = k;
    Object localObject = null;
    if (paramInt != 0) {
      paramArrayOfByte = new h[j];
    } else {
      paramArrayOfByte = null;
    }
    d = paramArrayOfByte;
    paramArrayOfByte = (byte[])localObject;
    if (i1 != 0)
    {
      paramArrayOfByte = new char[n];
      i = a();
      for (paramInt = e(i - 2); paramInt > 0; paramInt--)
      {
        localObject = e(i, paramArrayOfByte);
        i1 = b(i + 2);
        i += 6;
        if ("BootstrapMethods".equals(localObject))
        {
          i1 = e(i);
          paramArrayOfByte = new int[i1];
          paramInt = i + 2;
          for (i = m; i < i1; i++)
          {
            paramArrayOfByte[i] = paramInt;
            paramInt += e(paramInt + 2) * 2 + 4;
          }
          break label565;
        }
        i += i1;
      }
      throw new IllegalArgumentException();
    }
    label565:
    e = paramArrayOfByte;
  }
  
  public final int a()
  {
    int i = g;
    i = e(i + 6) * 2 + (i + 8);
    int j = e(i);
    i += 2;
    int k;
    while (j > 0)
    {
      k = e(i + 6);
      i += 8;
      while (k > 0)
      {
        i += b(i + 2) + 6;
        k--;
      }
      j--;
    }
    j = e(i);
    i += 2;
    while (j > 0)
    {
      k = e(i + 6);
      i += 8;
      while (k > 0)
      {
        i += b(i + 2) + 6;
        k--;
      }
      j--;
    }
    return i + 2;
  }
  
  public int a(int paramInt)
  {
    return a[paramInt] & 0xFF;
  }
  
  public final int a(int paramInt1, Object[] paramArrayOfObject, int paramInt2, char[] paramArrayOfChar, q[] paramArrayOfq)
  {
    byte[] arrayOfByte = a;
    int i = paramInt1 + 1;
    switch (arrayOfByte[paramInt1] & 0xFF)
    {
    default: 
      throw new IllegalArgumentException();
    case 8: 
      paramArrayOfObject[paramInt2] = b(e(i), paramArrayOfq);
      break;
    case 7: 
      paramArrayOfObject[paramInt2] = a(i, paramArrayOfChar);
      paramInt1 = i + 2;
      break;
    case 6: 
      paramArrayOfObject[paramInt2] = v.g;
      paramInt1 = i;
      break;
    case 5: 
      paramArrayOfObject[paramInt2] = v.f;
      paramInt1 = i;
      break;
    case 4: 
      paramArrayOfObject[paramInt2] = v.e;
      paramInt1 = i;
      break;
    case 3: 
      paramArrayOfObject[paramInt2] = v.d;
      paramInt1 = i;
      break;
    case 2: 
      paramArrayOfObject[paramInt2] = v.c;
      paramInt1 = i;
      break;
    case 1: 
      paramArrayOfObject[paramInt2] = v.b;
      paramInt1 = i;
      break;
    }
    paramArrayOfObject[paramInt2] = v.a;
    paramInt1 = i;
    return paramInt1;
  }
  
  public final int a(a parama, int paramInt, String paramString, char[] paramArrayOfChar)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    if (parama == null)
    {
      i2 = a[paramInt] & 0xFF;
      if (i2 != 64)
      {
        if (i2 != 91)
        {
          if (i2 != 101) {
            return paramInt + 3;
          }
          return paramInt + 5;
        }
        return a(null, paramInt + 1, false, paramArrayOfChar);
      }
      return a(null, paramInt + 3, true, paramArrayOfChar);
    }
    Object localObject = a;
    int i3 = paramInt + 1;
    paramInt = localObject[paramInt] & 0xFF;
    if (paramInt != 64)
    {
      if (paramInt != 70) {
        if (paramInt != 83) {
          if (paramInt != 99) {
            if (paramInt != 101) {
              if (paramInt != 115)
              {
                if ((paramInt == 73) || (paramInt == 74)) {
                  break label1069;
                }
                if (paramInt != 90) {
                  if (paramInt != 91) {
                    switch (paramInt)
                    {
                    default: 
                      throw new IllegalArgumentException();
                    case 67: 
                      parama.a(paramString, Character.valueOf((char)b(b[e(i3)])));
                      break;
                    case 66: 
                      parama.a(paramString, Byte.valueOf((byte)b(b[e(i3)])));
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        paramInt = i3 + 2;
        break;
        int i4 = e(i3);
        paramInt = i3 + 2;
        if (i4 == 0) {
          return a(parama.b(paramString), paramInt - 2, false, paramArrayOfChar);
        }
        i3 = a[paramInt] & 0xFF;
        if (i3 != 70)
        {
          if (i3 != 83)
          {
            if (i3 != 90)
            {
              if (i3 != 73)
              {
                if (i3 != 74) {
                  switch (i3)
                  {
                  default: 
                    paramInt = a(parama.b(paramString), paramInt - 2, false, paramArrayOfChar);
                    break;
                  case 68: 
                    paramArrayOfChar = new double[i4];
                    while (i2 < i4)
                    {
                      paramArrayOfChar[i2] = Double.longBitsToDouble(c(b[e(paramInt + 1)]));
                      paramInt += 3;
                      i2++;
                    }
                    parama.a(paramString, paramArrayOfChar);
                    break;
                  case 67: 
                    paramArrayOfChar = new char[i4];
                    for (i2 = i; i2 < i4; i2++)
                    {
                      paramArrayOfChar[i2] = ((char)(char)b(b[e(paramInt + 1)]));
                      paramInt += 3;
                    }
                    parama.a(paramString, paramArrayOfChar);
                    break;
                  case 66: 
                    paramArrayOfChar = new byte[i4];
                    for (i2 = j; i2 < i4; i2++)
                    {
                      paramArrayOfChar[i2] = ((byte)(byte)b(b[e(paramInt + 1)]));
                      paramInt += 3;
                    }
                    parama.a(paramString, paramArrayOfChar);
                    break;
                  }
                }
                paramArrayOfChar = new long[i4];
                for (i2 = k; i2 < i4; i2++)
                {
                  paramArrayOfChar[i2] = c(b[e(paramInt + 1)]);
                  paramInt += 3;
                }
                parama.a(paramString, paramArrayOfChar);
                break;
              }
              paramArrayOfChar = new int[i4];
              for (i2 = m; i2 < i4; i2++)
              {
                paramArrayOfChar[i2] = b(b[e(paramInt + 1)]);
                paramInt += 3;
              }
              parama.a(paramString, paramArrayOfChar);
              break;
            }
            paramArrayOfChar = new boolean[i4];
            for (i2 = 0; i2 < i4; i2++)
            {
              int i5;
              if (b(b[e(paramInt + 1)]) != 0) {
                i5 = 1;
              } else {
                i5 = 0;
              }
              paramArrayOfChar[i2] = i5;
              paramInt += 3;
            }
            parama.a(paramString, paramArrayOfChar);
            break;
          }
          paramArrayOfChar = new short[i4];
          for (i2 = n; i2 < i4; i2++)
          {
            paramArrayOfChar[i2] = ((short)(short)b(b[e(paramInt + 1)]));
            paramInt += 3;
          }
          parama.a(paramString, paramArrayOfChar);
          break;
        }
        paramArrayOfChar = new float[i4];
        for (i2 = i1; i2 < i4; i2++)
        {
          paramArrayOfChar[i2] = Float.intBitsToFloat(b(b[e(paramInt + 1)]));
          paramInt += 3;
        }
        parama.a(paramString, paramArrayOfChar);
        break;
        if (b(b[e(i3)]) == 0) {
          paramArrayOfChar = Boolean.FALSE;
        } else {
          paramArrayOfChar = Boolean.TRUE;
        }
        parama.a(paramString, paramArrayOfChar);
        continue;
        parama.a(paramString, e(i3, paramArrayOfChar));
        continue;
        localObject = e(i3, paramArrayOfChar);
        paramArrayOfChar = e(i3 + 2, paramArrayOfChar);
        e += 1;
        if (b) {
          c.d(a.c(paramString));
        }
        paramString = c;
        paramString.b(101, a.c((String)localObject));
        paramString.d(a.c(paramArrayOfChar));
        paramInt = i3 + 4;
        break;
        parama.a(paramString, y.e(e(i3, paramArrayOfChar)));
        continue;
        parama.a(paramString, Short.valueOf((short)b(b[e(i3)])));
        continue;
        label1069:
        parama.a(paramString, b(e(i3), paramArrayOfChar));
      }
    }
    localObject = e(i3, paramArrayOfChar);
    e += 1;
    if (b) {
      c.d(a.c(paramString));
    }
    paramString = c;
    paramString.b(64, a.c((String)localObject));
    paramString.d(0);
    paramInt = a(new a(a, true, c, null), i3 + 2, true, paramArrayOfChar);
    return paramInt;
  }
  
  public final int a(a parama, int paramInt, boolean paramBoolean, char[] paramArrayOfChar)
  {
    int i = e(paramInt);
    int j = paramInt + 2;
    int k = i;
    paramInt = j;
    if (paramBoolean)
    {
      paramInt = j;
      for (k = i;; k--)
      {
        i = paramInt;
        if (k <= 0) {
          break;
        }
        paramInt = a(parama, paramInt + 2, e(paramInt, paramArrayOfChar), paramArrayOfChar);
      }
    }
    for (;;)
    {
      i = paramInt;
      if (k <= 0) {
        break;
      }
      paramInt = a(parama, paramInt, null, paramArrayOfChar);
      k--;
    }
    if (parama != null) {
      parama.a();
    }
    return i;
  }
  
  public final int a(i parami, int paramInt)
  {
    int i = b(paramInt);
    int j = i >>> 24;
    if ((j != 0) && (j != 1)) {
      switch (j)
      {
      default: 
        switch (j)
        {
        default: 
          throw new IllegalArgumentException();
        }
      case 19: 
      case 20: 
      case 21: 
        i &= 0xFF000000;
        j = paramInt + 1;
        paramInt = i;
        break label353;
        i &= 0xFF0000FF;
        j = paramInt + 4;
        paramInt = i;
        break label353;
        j = i & 0xFF000000;
        break;
      case 16: 
      case 17: 
      case 18: 
      case 23: 
        j = i & 0xFF00;
        i = paramInt + 3;
        paramInt = j;
        j = i;
        break label353;
        int k = i & 0xFF000000;
        int m = e(paramInt + 1);
        i = paramInt + 3;
        j = new q[m];
        k = new q[m];
        l = new int[m];
        for (int n = 0;; n++)
        {
          paramInt = k;
          j = i;
          if (n >= m) {
            break;
          }
          paramInt = e(i);
          j = e(i + 2);
          int i1 = e(i + 4);
          i += 6;
          j[n] = b(paramInt, g);
          k[n] = b(paramInt + j, g);
          l[n] = i1;
        }
      }
    }
    i &= 0xFFFF0000;
    j = paramInt + 2;
    paramInt = i;
    label353:
    h = paramInt;
    paramInt = a(j);
    z localz;
    if (paramInt == 0) {
      localz = null;
    } else {
      localz = new z(a, j);
    }
    i = localz;
    return paramInt * 2 + (j + 1);
  }
  
  public final int a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt != null) && (paramInt < paramArrayOfInt.length) && (a(paramArrayOfInt[paramInt]) >= 67)) {
      return e(paramArrayOfInt[paramInt] + 1);
    }
    return -1;
  }
  
  public final String a(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    byte[] arrayOfByte = a;
    int i = 0;
    int j = paramInt1;
    if (j < paramInt2 + paramInt1)
    {
      int k = j + 1;
      int m = arrayOfByte[j];
      if ((m & 0x80) == 0)
      {
        j = i + 1;
        paramArrayOfChar[i] = ((char)(char)(m & 0x7F));
      }
      for (i = k;; i = k)
      {
        k = i;
        i = j;
        j = k;
        break;
        if ((m & 0xE0) == 192)
        {
          paramArrayOfChar[i] = ((char)(char)(((m & 0x1F) << 6) + (arrayOfByte[k] & 0x3F)));
          i++;
          j = k + 1;
          break;
        }
        j = i + 1;
        int n = k + 1;
        int i1 = arrayOfByte[k];
        k = n + 1;
        paramArrayOfChar[i] = ((char)(char)(((m & 0xF) << 12) + ((i1 & 0x3F) << 6) + (arrayOfByte[n] & 0x3F)));
      }
    }
    return new String(paramArrayOfChar, 0, i);
  }
  
  public String a(int paramInt, char[] paramArrayOfChar)
  {
    return e(b[e(paramInt)], paramArrayOfChar);
  }
  
  public final b a(b[] paramArrayOfb, String paramString, int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3, q[] paramArrayOfq)
  {
    int i = paramArrayOfb.length;
    for (paramInt3 = 0; paramInt3 < i; paramInt3++)
    {
      paramArrayOfChar = paramArrayOfb[paramInt3];
      if (a.equals(paramString))
      {
        paramString = new b(a);
        paramArrayOfb = new byte[paramInt2];
        b = paramArrayOfb;
        System.arraycopy(a, paramInt1, paramArrayOfb, 0, paramInt2);
        return paramString;
      }
    }
    paramArrayOfb = new b(paramString);
    paramString = new byte[paramInt2];
    b = paramString;
    System.arraycopy(a, paramInt1, paramString, 0, paramInt2);
    return paramArrayOfb;
  }
  
  public final void a(int paramInt, q[] paramArrayOfq)
  {
    if (paramArrayOfq[paramInt] == null)
    {
      if (paramArrayOfq[paramInt] == null) {
        paramArrayOfq[paramInt] = new q();
      }
      paramArrayOfq = paramArrayOfq[paramInt];
      a = ((short)(short)(a | 0x1));
    }
  }
  
  public final void a(s params, i parami, int paramInt)
  {
    Object localObject1 = a;
    char[] arrayOfChar = c;
    int i = e(paramInt);
    int j = e(paramInt + 2);
    int k = b(paramInt + 4);
    int m = paramInt + 8;
    int n = m + k;
    Object localObject2 = new q[k + 1];
    g = ((q[])localObject2);
    int i1 = m;
    while (i1 < n)
    {
      i2 = i1 - m;
      switch (localObject1[i1] & 0xFF)
      {
      default: 
        throw new IllegalArgumentException();
      case 202: 
      case 203: 
      case 204: 
      case 205: 
      case 206: 
      case 207: 
      case 208: 
      case 209: 
      case 210: 
      case 211: 
      case 212: 
      case 213: 
      case 214: 
      case 215: 
      case 216: 
      case 217: 
      case 218: 
      case 219: 
        b(e(i1 + 1) + i2, (q[])localObject2);
        break;
      case 200: 
      case 201: 
      case 220: 
        b(b(i1 + 1) + i2, (q[])localObject2);
        break;
      case 196: 
        i3 = localObject1[(i1 + 1)] & 0xFF;
        if (i3 != 132) {
          if (i3 != 169) {
            switch (i3)
            {
            default: 
              switch (i3)
              {
              default: 
                throw new IllegalArgumentException();
              }
              break;
            }
          }
        }
      case 197: 
        i1 += 4;
        continue;
        i1 += 6;
        break;
      case 185: 
      case 186: 
        i1 += 5;
        break;
      case 171: 
        i1 = 4 - (i2 & 0x3) + i1;
        b(b(i1) + i2, (q[])localObject2);
        i4 = b(i1 + 4);
        i3 = i1 + 8;
        for (;;)
        {
          i1 = i3;
          if (i4 <= 0) {
            break;
          }
          b(b(i3 + 4) + i2, (q[])localObject2);
          i3 += 8;
          i4--;
        }
      case 170: 
        i1 = 4 - (i2 & 0x3) + i1;
        b(b(i1) + i2, (q[])localObject2);
        i4 = b(i1 + 8) - b(i1 + 4) + 1;
        i3 = i1 + 12;
        for (;;)
        {
          i1 = i3;
          if (i4 <= 0) {
            break;
          }
          b(b(i3) + i2, (q[])localObject2);
          i3 += 4;
          i4--;
        }
        break;
      case 153: 
      case 154: 
      case 155: 
      case 156: 
      case 157: 
      case 158: 
      case 159: 
      case 160: 
      case 161: 
      case 162: 
      case 163: 
      case 164: 
      case 165: 
      case 166: 
      case 167: 
      case 168: 
      case 198: 
      case 199: 
        b(d(i1 + 1) + i2, (q[])localObject2);
      case 17: 
      case 19: 
      case 20: 
      case 132: 
      case 178: 
      case 179: 
      case 180: 
      case 181: 
      case 182: 
      case 183: 
      case 184: 
      case 187: 
      case 189: 
      case 192: 
      case 193: 
        i1 += 3;
        break;
      case 16: 
      case 18: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 169: 
      case 188: 
        i1 += 2;
        break;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 59: 
      case 60: 
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
      case 69: 
      case 70: 
      case 71: 
      case 72: 
      case 73: 
      case 74: 
      case 75: 
      case 76: 
      case 77: 
      case 78: 
      case 79: 
      case 80: 
      case 81: 
      case 82: 
      case 83: 
      case 84: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 89: 
      case 90: 
      case 91: 
      case 92: 
      case 93: 
      case 94: 
      case 95: 
      case 96: 
      case 97: 
      case 98: 
      case 99: 
      case 100: 
      case 101: 
      case 102: 
      case 103: 
      case 104: 
      case 105: 
      case 106: 
      case 107: 
      case 108: 
      case 109: 
      case 110: 
      case 111: 
      case 112: 
      case 113: 
      case 114: 
      case 115: 
      case 116: 
      case 117: 
      case 118: 
      case 119: 
      case 120: 
      case 121: 
      case 122: 
      case 123: 
      case 124: 
      case 125: 
      case 126: 
      case 127: 
      case 128: 
      case 129: 
      case 130: 
      case 131: 
      case 133: 
      case 134: 
      case 135: 
      case 136: 
      case 137: 
      case 138: 
      case 139: 
      case 140: 
      case 141: 
      case 142: 
      case 143: 
      case 144: 
      case 145: 
      case 146: 
      case 147: 
      case 148: 
      case 149: 
      case 150: 
      case 151: 
      case 152: 
      case 172: 
      case 173: 
      case 174: 
      case 175: 
      case 176: 
      case 177: 
      case 190: 
      case 191: 
      case 194: 
      case 195: 
        i1++;
      }
    }
    int i3 = e(i1);
    int i4 = i1 + 2;
    i1 = n;
    Object localObject6;
    while (i3 > 0)
    {
      localObject3 = b(e(i4), (q[])localObject2);
      localObject4 = b(e(i4 + 2), (q[])localObject2);
      localObject5 = b(e(i4 + 4), (q[])localObject2);
      localObject6 = e(b[e(i4 + 6)], arrayOfChar);
      n = i4 + 8;
      localObject7 = (t)params;
      if (localObject7 != null)
      {
        if (localObject6 != null) {
          i4 = c.a(7, (String)localObject6).a;
        } else {
          i4 = 0;
        }
        localObject3 = new p((q)localObject3, (q)localObject4, (q)localObject5, i4, (String)localObject6);
        if (l == null) {
          l = ((p)localObject3);
        } else {
          m.f = ((p)localObject3);
        }
        m = ((p)localObject3);
        i3--;
        i4 = n;
      }
      else
      {
        throw null;
      }
    }
    int i5 = e(i4);
    int i6 = i4 + 2;
    Object localObject7 = null;
    Object localObject4 = localObject7;
    Object localObject3 = localObject4;
    int i7 = 1;
    n = 0;
    int i2 = 0;
    i4 = 0;
    i3 = 0;
    int i8 = i1;
    i1 = k;
    k = i6;
    int i9;
    label1788:
    Object localObject8;
    int i12;
    while (i5 > 0)
    {
      localObject6 = e(k, arrayOfChar);
      i9 = b(k + 2);
      i6 = k + 6;
      if ("LocalVariableTable".equals(localObject6))
      {
        localObject6 = localObject7;
        localObject5 = localObject2;
        k = i1;
        if ((b & 0x2) == 0)
        {
          k = e(i6);
          i4 = i6 + 2;
          while (k > 0)
          {
            i10 = e(i4);
            a(i10, (q[])localObject2);
            a(e(i4 + 2) + i10, (q[])localObject2);
            i4 += 10;
            k--;
          }
          i4 = i6;
          break label1788;
        }
      }
      do
      {
        localObject7 = localObject6;
        break;
        if ("LocalVariableTypeTable".equals(localObject6))
        {
          i3 = i6;
          localObject8 = localObject2;
          break label2225;
        }
        if (!"LineNumberTable".equals(localObject6)) {
          break label2028;
        }
        localObject6 = localObject7;
        localObject5 = localObject2;
        k = i1;
      } while ((b & 0x2) != 0);
      i10 = e(i6);
      i11 = i6 + 2;
      for (;;)
      {
        localObject6 = localObject7;
        localObject5 = localObject2;
        k = i1;
        if (i10 <= 0) {
          break;
        }
        i12 = e(i11);
        k = e(i11 + 2);
        i11 += 4;
        a(i12, (q[])localObject2);
        localObject5 = localObject2[i12];
        if (b == 0)
        {
          b = ((short)(short)k);
        }
        else
        {
          if (c == null) {
            c = new int[4];
          }
          localObject8 = c;
          i12 = localObject8[0] + 1;
          localObject8[0] = i12;
          if (i12 >= localObject8.length)
          {
            localObject6 = new int[localObject8.length + 4];
            System.arraycopy(localObject8, 0, localObject6, 0, localObject8.length);
            c = ((int[])localObject6);
          }
          c[i12] = k;
        }
        i10--;
      }
      for (localObject2 = localObject3;; localObject2 = b(params, parami, i6, false))
      {
        localObject6 = localObject7;
        localObject8 = localObject5;
        i1 = k;
        break label2217;
        label2028:
        localObject5 = localObject2;
        k = i1;
        if ("RuntimeVisibleTypeAnnotations".equals(localObject6))
        {
          localObject7 = b(params, parami, i6, true);
          break;
        }
        if (!"RuntimeInvisibleTypeAnnotations".equals(localObject6)) {
          break label2086;
        }
      }
      label2086:
      if ("StackMapTable".equals(localObject6))
      {
        localObject2 = localObject3;
        localObject6 = localObject7;
        localObject8 = localObject5;
        i1 = k;
        if ((b & 0x4) == 0)
        {
          n = i6 + 2;
          i2 = i6 + i9;
          localObject2 = localObject3;
          localObject6 = localObject7;
          localObject8 = localObject5;
          i1 = k;
        }
      }
      else
      {
        if (!"StackMap".equals(localObject6)) {
          break label2232;
        }
        localObject2 = localObject3;
        localObject6 = localObject7;
        localObject8 = localObject5;
        i1 = k;
        if ((b & 0x4) == 0)
        {
          n = i6 + 2;
          i2 = i6 + i9;
          localObject2 = localObject5;
          i1 = k;
          i7 = 0;
          break label2276;
        }
      }
      label2217:
      localObject7 = localObject6;
      localObject3 = localObject2;
      label2225:
      localObject2 = localObject8;
      break label2276;
      label2232:
      localObject8 = a;
      localObject2 = localObject5;
      i1 = k;
      localObject5 = a((b[])localObject8, (String)localObject6, i6, i9, arrayOfChar, paramInt, (q[])localObject2);
      c = ((b)localObject4);
      localObject4 = localObject5;
      label2276:
      k = i6 + i9;
      i5--;
    }
    k = i1;
    if ((b & 0x8) != 0) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    if (n != 0)
    {
      m = -1;
      n = 0;
      o = 0;
      p = 0;
      localObject6 = new Object[j];
      q = ((Object[])localObject6);
      r = 0;
      s = new Object[i];
      if (i6 != 0)
      {
        localObject5 = f;
        if ((d & 0x8) == 0)
        {
          if ("<init>".equals(e)) {
            localObject6[0] = v.g;
          } else {
            localObject6[0] = a(g + 2, c);
          }
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
        }
        i10 = 1;
        for (i5 = paramInt;; i5 = i1)
        {
          i1 = i10 + 1;
          i11 = ((String)localObject5).charAt(i10);
          if (i11 != 70)
          {
            if (i11 != 76)
            {
              if ((i11 != 83) && (i11 != 73))
              {
                if (i11 != 74)
                {
                  if (i11 == 90) {
                    break label2655;
                  }
                  paramInt = i1;
                  if (i11 == 91) {}
                }
                switch (i11)
                {
                default: 
                  o = i5;
                  break;
                case 68: 
                  paramInt = i5 + 1;
                  localObject6[i5] = v.d;
                  break;
                  while (((String)localObject5).charAt(paramInt) == '[') {
                    paramInt++;
                  }
                  i1 = paramInt;
                  if (((String)localObject5).charAt(paramInt) == 'L') {
                    do
                    {
                      paramInt++;
                      i1 = paramInt;
                    } while (((String)localObject5).charAt(paramInt) != ';');
                  }
                  paramInt = i1 + 1;
                  localObject6[i5] = ((String)localObject5).substring(i10, paramInt);
                  i1 = i5 + 1;
                  break label2739;
                  paramInt = i5 + 1;
                  localObject6[i5] = v.e;
                  break;
                }
              }
              label2655:
              paramInt = i5 + 1;
              localObject6[i5] = v.b;
            }
            else
            {
              for (paramInt = i1; ((String)localObject5).charAt(paramInt) != ';'; paramInt++) {}
              localObject6[i5] = ((String)localObject5).substring(i1, paramInt);
              i1 = i5 + 1;
              paramInt++;
              break label2739;
            }
          }
          else
          {
            paramInt = i5 + 1;
            localObject6[i5] = v.c;
          }
          i5 = i1;
          i1 = paramInt;
          paramInt = i5;
          label2739:
          i10 = paramInt;
        }
      }
      paramInt = n;
      for (;;)
      {
        i12 = i2;
        if (paramInt >= i12 - 2) {
          break;
        }
        if (localObject1[paramInt] == 8)
        {
          i1 = e(paramInt + 1);
          if (i1 >= 0) {
            if (i1 < k)
            {
              if ((localObject1[(m + i1)] & 0xFF) == 187) {
                b(i1, (q[])localObject2);
              }
            }
            else {}
          }
        }
        paramInt++;
        i2 = i12;
      }
    }
    else
    {
      i12 = i2;
    }
    if ((i6 != 0) && ((b & 0x100) != 0)) {
      params.a(-1, j, null, 0, null);
    }
    int i10 = a((int[])localObject7, 0);
    i5 = a((int[])localObject3, 0);
    if ((b & 0x100) == 0) {
      i9 = 33;
    } else {
      i9 = 0;
    }
    paramInt = m;
    i1 = n;
    i2 = 0;
    int i11 = 0;
    n = i10;
    int i13 = 0;
    Object localObject5 = localObject2;
    int i14 = i8;
    int i15 = i3;
    i10 = i4;
    i8 = i11;
    i4 = i2;
    i11 = k;
    localObject2 = localObject4;
    k = j;
    i2 = i6;
    i3 = i13;
    while (paramInt < i14)
    {
      int i16 = i14;
      int i17 = paramInt - m;
      localObject6 = localObject5[i17];
      if (localObject6 != null)
      {
        if ((b & 0x2) == 0) {
          i6 = 1;
        } else {
          i6 = 0;
        }
        params.a((q)localObject6);
        if (i6 != 0)
        {
          i6 = b;
          if (i6 != 0)
          {
            params.b(i6 & 0xFFFF, (q)localObject6);
            if (c != null)
            {
              i14 = 1;
              for (;;)
              {
                localObject4 = c;
                i6 = paramInt;
                paramInt = i6;
                if (i14 > localObject4[0]) {
                  break;
                }
                params.b(localObject4[i14], (q)localObject6);
                i14++;
                paramInt = i6;
              }
            }
          }
        }
      }
      i6 = i3;
      i3 = paramInt;
      paramInt = i1;
      i1 = i6;
      while (paramInt != 0)
      {
        i6 = m;
        if ((i6 != i17) && (i6 != -1)) {
          break;
        }
        if (m != -1)
        {
          if ((i7 != 0) && (i2 == 0)) {
            params.a(n, p, q, r, s);
          } else {
            params.a(-1, o, q, r, s);
          }
          i1 = 0;
        }
        if (paramInt < i12)
        {
          localObject4 = c;
          localObject8 = g;
          if (i7 != 0)
          {
            i14 = a[paramInt];
            i6 = paramInt + 1;
            paramInt = i14 & 0xFF;
          }
          else
          {
            m = -1;
            i6 = paramInt;
            paramInt = 255;
          }
          p = 0;
          if (paramInt < 64)
          {
            n = 3;
            r = 0;
          }
          else
          {
            if (paramInt < 128)
            {
              paramInt -= 64;
              i14 = a(i6, s, 0, (char[])localObject4, (q[])localObject8);
              n = 4;
              r = 1;
              i6 = paramInt;
              paramInt = i14;
            }
            int i18;
            for (;;)
            {
              i14 = i6;
              i6 = paramInt;
              paramInt = i14;
              break label3725;
              localObject6 = localObject8;
              if (paramInt < 247) {
                break label3753;
              }
              i18 = e(i6);
              i14 = i6 + 2;
              if (paramInt != 247) {
                break;
              }
              paramInt = a(i14, s, 0, (char[])localObject4, (q[])localObject6);
              n = 4;
              r = 1;
              i6 = i18;
            }
            if ((paramInt >= 248) && (paramInt < 251))
            {
              n = 2;
              paramInt = 251 - paramInt;
              p = paramInt;
              o -= paramInt;
              r = 0;
              paramInt = i14;
            }
            else
            {
              if (paramInt != 251) {
                break label3506;
              }
              n = 3;
              r = 0;
              paramInt = i14;
            }
            for (;;)
            {
              i6 = i18;
              break;
              label3506:
              if (paramInt >= 255) {
                break label3608;
              }
              if (i2 != 0) {
                i6 = o;
              } else {
                i6 = 0;
              }
              j = paramInt - 251;
              i13 = i6;
              i6 = j;
              paramInt = i14;
              while (i6 > 0)
              {
                paramInt = a(paramInt, q, i13, (char[])localObject4, (q[])localObject6);
                i6--;
                i13++;
              }
              n = 1;
              p = j;
              o += j;
              r = 0;
            }
            label3608:
            j = e(i14);
            paramInt = i14 + 2;
            n = 0;
            p = j;
            o = j;
            for (i6 = 0; i6 < j; i6++) {
              paramInt = a(paramInt, q, i6, (char[])localObject4, (q[])localObject6);
            }
            j = e(paramInt);
            i6 = paramInt + 2;
            r = j;
            for (i14 = 0;; i14++)
            {
              paramInt = i6;
              if (i14 >= j) {
                break;
              }
              i6 = a(i6, s, i14, (char[])localObject4, (q[])localObject6);
            }
          }
          label3725:
          paramInt = paramInt + 1 + m;
          m = paramInt;
          b(paramInt, (q[])localObject8);
          paramInt = i6;
          continue;
          label3753:
          throw new IllegalArgumentException();
        }
        else
        {
          paramInt = 0;
        }
      }
      if (i1 != 0)
      {
        if ((b & 0x8) != 0) {
          params.a(256, 0, null, 0, null);
        }
        i1 = 0;
      }
      i14 = localObject1[i3] & 0xFF;
      label5170:
      label5195:
      Object localObject9;
      Object localObject10;
      switch (i14)
      {
      default: 
        throw new AssertionError();
      case 220: 
        params.a(200, localObject5[(b(i3 + 1) + i17)]);
        i1 = i3 + 5;
        i3 = 1;
      case 202: 
      case 203: 
      case 204: 
      case 205: 
      case 206: 
      case 207: 
      case 208: 
      case 209: 
      case 210: 
      case 211: 
      case 212: 
      case 213: 
      case 214: 
      case 215: 
      case 216: 
      case 217: 
      case 218: 
      case 219: 
      case 200: 
      case 201: 
      case 197: 
      case 196: 
      case 187: 
      case 189: 
      case 192: 
      case 193: 
      case 186: 
        for (;;)
        {
          i6 = i2;
          i14 = n;
          n = i3;
          i2 = i1;
          i3 = i14;
          i1 = i6;
          break;
          if (i14 < 218) {
            i6 = i14 - 49;
          } else {
            i6 = i14 - 20;
          }
          localObject4 = localObject5[(e(i3 + 1) + i17)];
          if ((i6 != 167) && (i6 != 168))
          {
            if (i6 < 167) {
              i1 = (i6 + 1 ^ 0x1) - 1;
            } else {
              i1 = i6 ^ 0x1;
            }
            params.a(i1, b(i17 + 3, (q[])localObject5));
            params.a(200, (q)localObject4);
            i1 = 1;
          }
          else
          {
            params.a(i6 + 33, (q)localObject4);
          }
          i6 = i3 + 3;
          i3 = i1;
          i1 = i6;
          break label5537;
          params.a(i14 - i9, localObject5[(b(i3 + 1) + i17)]);
          i3 += 5;
          break label5195;
          localObject6 = a(i3 + 1, arrayOfChar);
          i14 = localObject1[(i3 + 3)] & 0xFF;
          localObject4 = (t)params;
          Z = k.b;
          localObject8 = c.a(7, (String)localObject6);
          localObject6 = k;
          ((c)localObject6).b(197, a);
          ((c)localObject6).b(i14);
          if (Q != null)
          {
            i6 = N;
            if ((i6 != 4) && (i6 != 3)) {
              R = (1 - i14 + R);
            } else {
              Q.j.a(197, i14, (w)localObject8, c);
            }
          }
          break label5170;
          i6 = localObject1[(i3 + 1)] & 0xFF;
          if (i6 == 132)
          {
            params.a(e(i3 + 2), d(i3 + 4));
            i3 += 6;
          }
          else
          {
            params.d(i6, e(i3 + 2));
            i3 += 4;
            break label5195;
            params.a(i14, a(i3 + 1, arrayOfChar));
            i3 += 3;
          }
          break label5525;
          i14 = b[e(i3 + 1)];
          i6 = b[e(i14 + 2)];
          localObject6 = e(i6, arrayOfChar);
          localObject8 = e(i6 + 2, arrayOfChar);
          i6 = e[e(i14)];
          o localo = (o)b(e(i6), arrayOfChar);
          i14 = e(i6 + 2);
          localObject9 = new Object[i14];
          j = i6 + 4;
          for (i6 = 0; i6 < i14; i6++)
          {
            localObject9[i6] = b(e(j), arrayOfChar);
            j += 2;
          }
          localObject4 = (t)params;
          Z = k.b;
          localObject10 = c;
          localObject6 = ((x)localObject10).a(18, (String)localObject6, (String)localObject8, aa);
          k.b(186, a);
          k.d(0);
          if (Q != null)
          {
            i6 = N;
            if ((i6 != 4) && (i6 != 3))
            {
              i6 = ((w)localObject6).a();
              i6 = R + ((i6 & 0x3) - (i6 >> 2) + 1);
              if (i6 > S) {
                S = i6;
              }
              R = i6;
            }
            else
            {
              Q.j.a(186, 0, (w)localObject6, c);
            }
          }
          i3 += 5;
          i6 = i1;
          i1 = i3;
          i3 = i6;
        }
      case 178: 
      case 179: 
      case 180: 
      case 181: 
      case 182: 
      case 183: 
      case 184: 
      case 185: 
        i6 = b[e(i3 + 1)];
        j = b[e(i6 + 2)];
        localObject6 = a(i6, arrayOfChar);
        localObject4 = e(j, arrayOfChar);
        localObject8 = e(j + 2, arrayOfChar);
        if (i14 < 182)
        {
          params.a(i14, (String)localObject6, (String)localObject4, (String)localObject8);
        }
        else
        {
          boolean bool;
          if (localObject1[(i6 - 1)] == 11) {
            bool = true;
          } else {
            bool = false;
          }
          params.a(i14, (String)localObject6, (String)localObject4, (String)localObject8, bool);
        }
        if (i14 == 185) {
          i3 += 5;
        } else {
          i3 += 3;
        }
        break;
      case 171: 
        i3 = 4 - (i17 & 0x3) + i3;
        localObject6 = localObject5[(b(i3) + i17)];
        i14 = b(i3 + 4);
        localObject4 = new int[i14];
        localObject9 = new q[i14];
        i3 += 8;
        for (i6 = 0; i6 < i14; i6++)
        {
          localObject4[i6] = b(i3);
          localObject9[i6] = localObject5[(b(i3 + 4) + i17)];
          i3 += 8;
        }
        localObject10 = (t)params;
        localObject8 = k;
        Z = b;
        ((c)localObject8).b(171);
        ((c)localObject8).a(null, 0, (4 - k.b % 4) % 4);
        ((q)localObject6).a(k, Z, true);
        k.c(i14);
        for (i6 = 0; i6 < i14; i6++)
        {
          k.c(localObject4[i6]);
          localObject9[i6].a(k, Z, true);
        }
        ((t)localObject10).a((q)localObject6, (q[])localObject9);
        break;
      case 170: 
        i3 = 4 - (i17 & 0x3) + i3;
        localObject6 = localObject5[(b(i3) + i17)];
        i14 = b(i3 + 4);
        j = b(i3 + 8);
        i3 += 12;
        i13 = j - i14 + 1;
        localObject4 = new q[i13];
        for (i6 = 0; i6 < i13; i6++)
        {
          localObject4[i6] = localObject5[(b(i3) + i17)];
          i3 += 4;
        }
        params.a(i14, j, (q)localObject6, (q[])localObject4);
        break;
      case 153: 
      case 154: 
      case 155: 
      case 156: 
      case 157: 
      case 158: 
      case 159: 
      case 160: 
      case 161: 
      case 162: 
      case 163: 
      case 164: 
      case 165: 
      case 166: 
      case 167: 
      case 168: 
      case 198: 
      case 199: 
        params.a(i14, localObject5[(d(i3 + 1) + i17)]);
        break;
      case 132: 
        params.a(localObject1[(i3 + 1)] & 0xFF, localObject1[(i3 + 2)]);
        break;
      case 59: 
      case 60: 
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
      case 69: 
      case 70: 
      case 71: 
      case 72: 
      case 73: 
      case 74: 
      case 75: 
      case 76: 
      case 77: 
      case 78: 
        i6 = i14 - 59;
        params.d((i6 >> 2) + 54, 0x3 & i6);
        break;
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
        i6 = i14 - 26;
        params.d((i6 >> 2) + 21, 0x3 & i6);
        i3++;
        break;
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 169: 
        params.d(i14, localObject1[(i3 + 1)] & 0xFF);
        i3 += 2;
        break;
      case 19: 
      case 20: 
        label5525:
        label5537:
        params.a(b(e(i3 + 1), arrayOfChar));
        i3 += 3;
        i6 = i2;
        i2 = i1;
        i1 = i6;
        i6 = n;
        n = i2;
      }
      for (;;)
      {
        i2 = i3;
        i3 = i6;
        break label6311;
        params.a(b(localObject1[(i3 + 1)] & 0xFF, arrayOfChar));
        break label6274;
        params.b(i14, d(i3 + 1));
        i6 = i3 + 3;
        break label6295;
        params.b(i14, localObject1[(i3 + 1)]);
        label6274:
        i6 = i3 + 2;
        break label6295;
        params.a(i14);
        i6 = i3 + 1;
        label6295:
        i3 = n;
        n = i1;
        i1 = i2;
        i2 = i6;
        label6311:
        if ((localObject7 == null) || (i4 >= localObject7.length) || (i3 > i17)) {
          break;
        }
        if (i3 == i17)
        {
          i3 = a(parami, localObject7[i4]);
          localObject4 = e(i3, arrayOfChar);
          a(params.a(h, i, (String)localObject4, true), i3 + 2, true, arrayOfChar);
        }
        i4++;
        i6 = a((int[])localObject7, i4);
        i3 = i2;
      }
      i14 = i8;
      i8 = i5;
      i6 = i17;
      i5 = i14;
      while ((localObject3 != null) && (i5 < localObject3.length) && (i8 <= i6))
      {
        if (i8 == i6)
        {
          i8 = a(parami, localObject3[i5]);
          localObject4 = e(i8, arrayOfChar);
          a(params.a(h, i, (String)localObject4, false), i8 + 2, true, arrayOfChar);
        }
        i5++;
        i8 = a((int[])localObject3, i5);
      }
      i6 = i5;
      i5 = i8;
      i14 = i;
      i = i1;
      i8 = i3;
      i3 = n;
      i1 = paramInt;
      paramInt = i2;
      i2 = i;
      i = i14;
      n = i8;
      i8 = i6;
      i14 = i16;
    }
    if (localObject5[i11] != null) {
      params.a(localObject5[i11]);
    }
    if ((i10 != 0) && ((b & 0x2) == 0))
    {
      if (i15 != 0)
      {
        i1 = e(i15) * 3;
        localObject4 = new int[i1];
        for (paramInt = i15 + 2; i1 > 0; paramInt += 10)
        {
          i1--;
          localObject4[i1] = (paramInt + 6);
          i1--;
          localObject4[i1] = e(paramInt + 8);
          i1--;
          localObject4[i1] = e(paramInt);
        }
      }
      else
      {
        localObject4 = null;
      }
      i1 = e(i10);
      for (paramInt = i10 + 2; i1 > 0; paramInt += 10)
      {
        i2 = e(paramInt);
        n = e(paramInt + 2);
        localObject8 = e(paramInt + 4, arrayOfChar);
        localObject1 = e(paramInt + 6, arrayOfChar);
        i4 = e(paramInt + 8);
        if (localObject4 != null) {
          for (i3 = 0; i3 < localObject4.length; i3 += 3) {
            if ((localObject4[i3] == i2) && (localObject4[(i3 + 1)] == i4))
            {
              localObject6 = e(localObject4[(i3 + 2)], arrayOfChar);
              break label6818;
            }
          }
        }
        localObject6 = null;
        label6818:
        params.a((String)localObject8, (String)localObject1, (String)localObject6, localObject5[i2], localObject5[(i2 + n)], i4);
        i1--;
      }
    }
    localObject5 = localObject2;
    if (localObject7 != null)
    {
      i1 = localObject7.length;
      for (paramInt = 0;; paramInt++)
      {
        localObject5 = localObject2;
        if (paramInt >= i1) {
          break;
        }
        i4 = localObject7[paramInt];
        i3 = a(i4);
        if ((i3 != 64) && (i3 != 65)) {
          continue;
        }
        i3 = a(parami, i4);
        localObject5 = e(i3, arrayOfChar);
        a(params.a(h, i, j, k, l, (String)localObject5, true), i3 + 2, true, arrayOfChar);
      }
    }
    if (localObject3 != null)
    {
      i1 = localObject3.length;
      for (paramInt = 0; paramInt < i1; paramInt++)
      {
        i4 = localObject3[paramInt];
        i3 = a(i4);
        if ((i3 != 64) && (i3 != 65)) {
          continue;
        }
        i3 = a(parami, i4);
        localObject7 = e(i3, arrayOfChar);
        a(params.a(h, i, j, k, l, (String)localObject7, false), i3 + 2, true, arrayOfChar);
      }
    }
    for (parami = (i)localObject5; parami != null; parami = (i)localObject7)
    {
      localObject7 = c;
      c = null;
      localObject2 = (t)params;
      c = M;
      M = parami;
    }
    params.c(i, k);
  }
  
  public final void a(s params, i parami, int paramInt, boolean paramBoolean)
  {
    Object localObject = a;
    int i = paramInt + 1;
    int j = localObject[paramInt] & 0xFF;
    localObject = (t)params;
    if (paramBoolean) {
      D = j;
    } else {
      F = j;
    }
    localObject = c;
    int k = 0;
    paramInt = i;
    while (k < j)
    {
      i = e(paramInt);
      paramInt += 2;
      while (i > 0)
      {
        parami = e(paramInt, (char[])localObject);
        t localt = (t)params;
        a[] arrayOfa;
        if (paramBoolean)
        {
          if (E == null) {
            E = new a[y.a(h).length];
          }
          arrayOfa = E;
          parami = a.a(c, parami, arrayOfa[k]);
          arrayOfa[k] = parami;
        }
        else
        {
          if (G == null) {
            G = new a[y.a(h).length];
          }
          arrayOfa = G;
          parami = a.a(c, parami, arrayOfa[k]);
          arrayOfa[k] = parami;
        }
        paramInt = a(parami, paramInt + 2, true, (char[])localObject);
        i--;
      }
      k++;
    }
  }
  
  public int b(int paramInt)
  {
    byte[] arrayOfByte = a;
    int i = arrayOfByte[paramInt];
    int j = arrayOfByte[(paramInt + 1)];
    int k = arrayOfByte[(paramInt + 2)];
    return arrayOfByte[(paramInt + 3)] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public Object b(int paramInt, char[] paramArrayOfChar)
  {
    Object localObject1 = b;
    int i = localObject1[paramInt];
    int j = a[(i - 1)];
    switch (j)
    {
    default: 
      int k = 0;
      switch (j)
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        localObject2 = d[paramInt];
        if (localObject2 != null)
        {
          paramArrayOfChar = (char[])localObject2;
        }
        else
        {
          j = localObject1[paramInt];
          i = localObject1[e(j + 2)];
          localObject1 = e(i, paramArrayOfChar);
          String str = e(i + 2, paramArrayOfChar);
          i = e[e(j)];
          localObject2 = (o)b(e(i), paramArrayOfChar);
          j = e(i + 2);
          Object[] arrayOfObject = new Object[j];
          i += 4;
          while (k < j)
          {
            arrayOfObject[k] = b(e(i), paramArrayOfChar);
            i += 2;
            k++;
          }
          h[] arrayOfh = d;
          paramArrayOfChar = new h((String)localObject1, str, (o)localObject2, arrayOfObject);
          arrayOfh[paramInt] = paramArrayOfChar;
        }
        return paramArrayOfChar;
      case 16: 
        paramArrayOfChar = e(i, paramArrayOfChar);
        return new y(11, paramArrayOfChar, 0, paramArrayOfChar.length());
      }
      paramInt = a(i);
      k = b[e(i + 1)];
      i = b[e(k + 2)];
      Object localObject2 = a(k, paramArrayOfChar);
      localObject1 = e(i, paramArrayOfChar);
      paramArrayOfChar = e(i + 2, paramArrayOfChar);
      boolean bool;
      if (a[(k - 1)] == 11) {
        bool = true;
      } else {
        bool = false;
      }
      return new o(paramInt, (String)localObject2, (String)localObject1, paramArrayOfChar, bool);
    case 8: 
      return e(i, paramArrayOfChar);
    case 7: 
      return y.c(e(i, paramArrayOfChar));
    case 6: 
      return Double.valueOf(Double.longBitsToDouble(c(i)));
    case 5: 
      return Long.valueOf(c(i));
    case 4: 
      return Float.valueOf(Float.intBitsToFloat(b(i)));
    }
    return Integer.valueOf(b(i));
  }
  
  public final q b(int paramInt, q[] paramArrayOfq)
  {
    if (paramArrayOfq[paramInt] == null) {
      paramArrayOfq[paramInt] = new q();
    }
    paramArrayOfq = paramArrayOfq[paramInt];
    a = ((short)(short)(a & 0xFFFFFFFE));
    return paramArrayOfq;
  }
  
  public final int[] b(s params, i parami, int paramInt, boolean paramBoolean)
  {
    char[] arrayOfChar = c;
    int i = e(paramInt);
    int[] arrayOfInt = new int[i];
    paramInt += 2;
    for (int j = 0; j < i; j++)
    {
      arrayOfInt[j] = paramInt;
      int k = b(paramInt);
      int m = k >>> 24;
      int n;
      if (m != 23) {
        switch (m)
        {
        default: 
          switch (m)
          {
          default: 
            throw new IllegalArgumentException();
          case 71: 
          case 72: 
          case 73: 
          case 74: 
          case 75: 
            n = paramInt + 4;
            break;
          case 64: 
          case 65: 
            int i1 = e(paramInt + 1);
            paramInt += 3;
            for (;;)
            {
              n = paramInt;
              if (i1 <= 0) {
                break;
              }
              int i2 = e(paramInt);
              n = e(paramInt + 2);
              paramInt += 6;
              b(i2, g);
              b(i2 + n, g);
              i1--;
            }
          }
          break;
        }
      } else {
        n = paramInt + 3;
      }
      paramInt = a(n);
      Object localObject = null;
      if (m == 66)
      {
        if (paramInt != 0) {
          localObject = new z(a, n);
        }
        paramInt = paramInt * 2 + 1 + n;
        String str = e(paramInt, arrayOfChar);
        n = k & 0xFF00;
        t localt = (t)params;
        if (paramBoolean)
        {
          localObject = a.a(c, n, (z)localObject, str, v);
          v = ((a)localObject);
        }
        else
        {
          localObject = a.a(c, n, (z)localObject, str, w);
          w = ((a)localObject);
        }
        paramInt = a((a)localObject, paramInt + 2, true, arrayOfChar);
      }
      else
      {
        paramInt = a(null, paramInt * 2 + 3 + n, true, arrayOfChar);
      }
    }
    return arrayOfInt;
  }
  
  public long c(int paramInt)
  {
    return b(paramInt) << 32 | b(paramInt + 4) & 0xFFFFFFFF;
  }
  
  public String c(int paramInt, char[] paramArrayOfChar)
  {
    return e(b[e(paramInt)], paramArrayOfChar);
  }
  
  public String d(int paramInt, char[] paramArrayOfChar)
  {
    return e(b[e(paramInt)], paramArrayOfChar);
  }
  
  public short d(int paramInt)
  {
    byte[] arrayOfByte = a;
    int i = arrayOfByte[paramInt];
    return (short)(arrayOfByte[(paramInt + 1)] & 0xFF | (i & 0xFF) << 8);
  }
  
  public int e(int paramInt)
  {
    byte[] arrayOfByte = a;
    int i = arrayOfByte[paramInt];
    return arrayOfByte[(paramInt + 1)] & 0xFF | (i & 0xFF) << 8;
  }
  
  public String e(int paramInt, char[] paramArrayOfChar)
  {
    int i = e(paramInt);
    if ((paramInt != 0) && (i != 0)) {
      return f(i, paramArrayOfChar);
    }
    return null;
  }
  
  public final String f(int paramInt, char[] paramArrayOfChar)
  {
    String[] arrayOfString = c;
    String str = arrayOfString[paramInt];
    if (str != null) {
      return str;
    }
    int i = b[paramInt];
    paramArrayOfChar = a(i + 2, e(i), paramArrayOfChar);
    arrayOfString[paramInt] = paramArrayOfChar;
    return paramArrayOfChar;
  }
}

/* Location:
 * Qualified Name:     l.e.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */