package e.b.a.a;

import e.b.a.a.s.c;
import java.io.Serializable;
import java.util.Arrays;

public final class a
  implements Serializable
{
  public final String A;
  public final transient boolean B;
  public final transient char C;
  public final transient int D;
  public final transient int[] x = new int[''];
  public final transient char[] y = new char[64];
  public final transient byte[] z;
  
  public a(a parama, String paramString, boolean paramBoolean, char paramChar, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    z = arrayOfByte;
    A = paramString;
    paramString = z;
    System.arraycopy(paramString, 0, arrayOfByte, 0, paramString.length);
    paramString = y;
    System.arraycopy(paramString, 0, y, 0, paramString.length);
    parama = x;
    System.arraycopy(parama, 0, x, 0, parama.length);
    B = paramBoolean;
    C = ((char)paramChar);
    D = paramInt;
  }
  
  public a(String paramString1, String paramString2, boolean paramBoolean, char paramChar, int paramInt)
  {
    z = new byte[64];
    A = paramString1;
    B = paramBoolean;
    C = ((char)paramChar);
    D = paramInt;
    int i = paramString2.length();
    if (i == 64)
    {
      paramString1 = y;
      paramInt = 0;
      paramString2.getChars(0, i, paramString1, 0);
      Arrays.fill(x, -1);
      while (paramInt < i)
      {
        int j = y[paramInt];
        z[paramInt] = ((byte)(byte)j);
        x[j] = paramInt;
        paramInt++;
      }
      if (paramBoolean) {
        x[paramChar] = -2;
      }
      return;
    }
    throw new IllegalArgumentException(e.a.a.a.a.b("Base64Alphabet length must be exactly 64 (was ", i, ")"));
  }
  
  public int a(char paramChar)
  {
    if (paramChar <= '') {
      paramChar = x[paramChar];
    } else {
      paramChar = '￿';
    }
    return paramChar;
  }
  
  public int a(int paramInt)
  {
    if (paramInt <= 127) {
      paramInt = x[paramInt];
    } else {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public void a()
  {
    throw new IllegalArgumentException("Unexpected end-of-String in base64 content");
  }
  
  public void a(char paramChar, int paramInt, String paramString)
  {
    Object localObject1;
    if (paramChar <= ' ')
    {
      localObject1 = e.a.a.a.a.a("Illegal white space character (code 0x");
      ((StringBuilder)localObject1).append(Integer.toHexString(paramChar));
      ((StringBuilder)localObject1).append(") as character #");
      ((StringBuilder)localObject1).append(paramInt + 1);
      ((StringBuilder)localObject1).append(" of 4-char base64 unit: can only used between units");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      int i;
      if (paramChar == C) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject1 = e.a.a.a.a.a("Unexpected padding character ('");
        ((StringBuilder)localObject1).append(C);
        ((StringBuilder)localObject1).append("') as character #");
        ((StringBuilder)localObject1).append(paramInt + 1);
        ((StringBuilder)localObject1).append(" of 4-char base64 unit: padding only legal as 3rd or 4th character");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if ((Character.isDefined(paramChar)) && (!Character.isISOControl(paramChar)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Illegal character '");
        ((StringBuilder)localObject1).append(paramChar);
        ((StringBuilder)localObject1).append("' (code 0x");
        ((StringBuilder)localObject1).append(Integer.toHexString(paramChar));
        ((StringBuilder)localObject1).append(") in base64 content");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = e.a.a.a.a.a("Illegal character (code 0x");
        ((StringBuilder)localObject1).append(Integer.toHexString(paramChar));
        ((StringBuilder)localObject1).append(") in base64 content");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    Object localObject2 = localObject1;
    if (paramString != null) {
      localObject2 = e.a.a.a.a.a((String)localObject1, ": ", paramString);
    }
    throw new IllegalArgumentException((String)localObject2);
  }
  
  public void a(String paramString, c paramc)
  {
    int i = paramString.length();
    int j = 0;
    label285:
    label291:
    label361:
    label371:
    label377:
    label387:
    for (;;)
    {
      int m;
      if (j < i)
      {
        k = j + 1;
        c = paramString.charAt(j);
        j = k;
        if (c <= ' ') {
          break label387;
        }
        m = a(c);
        if (m < 0) {
          break label377;
        }
        if (k >= i) {
          break label371;
        }
        j = k + 1;
        c = paramString.charAt(k);
        k = a(c);
        if (k < 0) {
          break label361;
        }
        m = m << 6 | k;
        if (j >= i)
        {
          if (!B)
          {
            paramc.a(m >> 4);
          }
          else
          {
            a();
            throw null;
          }
        }
        else
        {
          k = j + 1;
          c = paramString.charAt(j);
          j = a(c);
          if (j < 0)
          {
            if (j == -2)
            {
              if (k < i)
              {
                j = k + 1;
                c = paramString.charAt(k);
                if (b(c))
                {
                  paramc.a(m >> 4);
                  continue;
                }
                paramString = e.a.a.a.a.a("expected padding character '");
                paramString.append(C);
                paramString.append("'");
                a(c, 3, paramString.toString());
                throw null;
              }
              a();
              throw null;
            }
            a(c, 2, null);
            throw null;
          }
          m = m << 6 | j;
          if (k < i) {
            break label291;
          }
          if (B) {
            break label285;
          }
          paramc.c(m >> 2);
        }
      }
      return;
      a();
      throw null;
      j = k + 1;
      char c = paramString.charAt(k);
      int k = a(c);
      if (k < 0)
      {
        if (k == -2)
        {
          paramc.c(m >> 2);
        }
        else
        {
          a(c, 3, null);
          throw null;
        }
      }
      else
      {
        paramc.b(m << 6 | k);
        break label387;
        a(c, 1, null);
        throw null;
        a();
        throw null;
        a(c, 0, null);
        throw null;
      }
    }
  }
  
  public boolean b(char paramChar)
  {
    boolean bool;
    if (paramChar == C) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return A.hashCode();
  }
  
  public String toString()
  {
    return A;
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */