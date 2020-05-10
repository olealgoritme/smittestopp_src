package e.c.c.y;

import e.a.a.a.a;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class c
  implements Closeable, Flushable
{
  public static final String[] G = new String[''];
  public static final String[] H;
  public String A;
  public String B;
  public boolean C;
  public boolean D;
  public String E;
  public boolean F;
  public final Writer x;
  public int[] y = new int[32];
  public int z = 0;
  
  static
  {
    for (int i = 0; i <= 31; i++) {
      G[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
    }
    String[] arrayOfString = G;
    arrayOfString[34] = "\\\"";
    arrayOfString[92] = "\\\\";
    arrayOfString[9] = "\\t";
    arrayOfString[8] = "\\b";
    arrayOfString[10] = "\\n";
    arrayOfString[13] = "\\r";
    arrayOfString[12] = "\\f";
    arrayOfString = (String[])arrayOfString.clone();
    H = arrayOfString;
    arrayOfString[60] = "\\u003c";
    arrayOfString[62] = "\\u003e";
    arrayOfString[38] = "\\u0026";
    arrayOfString[61] = "\\u003d";
    arrayOfString[39] = "\\u0027";
  }
  
  public c(Writer paramWriter)
  {
    a(6);
    B = ":";
    F = true;
    if (paramWriter != null)
    {
      x = paramWriter;
      return;
    }
    throw new NullPointerException("out == null");
  }
  
  public final c a(int paramInt1, int paramInt2, String paramString)
  {
    int i = h();
    if ((i != paramInt2) && (i != paramInt1)) {
      throw new IllegalStateException("Nesting problem.");
    }
    if (E == null)
    {
      z -= 1;
      if (i == paramInt2) {
        f();
      }
      x.write(paramString);
      return this;
    }
    paramString = a.a("Dangling name: ");
    paramString.append(E);
    throw new IllegalStateException(paramString.toString());
  }
  
  public c a(long paramLong)
  {
    i();
    a();
    x.write(Long.toString(paramLong));
    return this;
  }
  
  public c a(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return g();
    }
    i();
    a();
    Writer localWriter = x;
    if (paramBoolean.booleanValue()) {
      paramBoolean = "true";
    } else {
      paramBoolean = "false";
    }
    localWriter.write(paramBoolean);
    return this;
  }
  
  public c a(Number paramNumber)
  {
    if (paramNumber == null) {
      return g();
    }
    i();
    Object localObject = paramNumber.toString();
    if ((!C) && ((((String)localObject).equals("-Infinity")) || (((String)localObject).equals("Infinity")) || (((String)localObject).equals("NaN"))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Numeric values must be finite, but was ");
      ((StringBuilder)localObject).append(paramNumber);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    a();
    x.append((CharSequence)localObject);
    return this;
  }
  
  public c a(String paramString)
  {
    if (paramString != null)
    {
      if (E == null)
      {
        if (z != 0)
        {
          E = paramString;
          return this;
        }
        throw new IllegalStateException("JsonWriter is closed.");
      }
      throw new IllegalStateException();
    }
    throw new NullPointerException("name == null");
  }
  
  public c a(boolean paramBoolean)
  {
    i();
    a();
    Writer localWriter = x;
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    localWriter.write(str);
    return this;
  }
  
  public final void a()
  {
    int i = h();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6) {
            if (i == 7)
            {
              if (!C) {
                throw new IllegalStateException("JSON must have only one top-level value.");
              }
            }
            else {
              throw new IllegalStateException("Nesting problem.");
            }
          }
          b(7);
        }
        else
        {
          x.append(B);
          b(5);
        }
      }
      else
      {
        x.append(',');
        f();
      }
    }
    else
    {
      b(2);
      f();
    }
  }
  
  public final void a(int paramInt)
  {
    int i = z;
    int[] arrayOfInt1 = y;
    if (i == arrayOfInt1.length)
    {
      arrayOfInt2 = new int[i * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      y = arrayOfInt2;
    }
    int[] arrayOfInt2 = y;
    i = z;
    z = (i + 1);
    arrayOfInt2[i] = paramInt;
  }
  
  public c b()
  {
    i();
    a();
    a(1);
    x.write("[");
    return this;
  }
  
  public final void b(int paramInt)
  {
    y[(z - 1)] = paramInt;
  }
  
  public final void b(String paramString)
  {
    String[] arrayOfString;
    if (D) {
      arrayOfString = H;
    } else {
      arrayOfString = G;
    }
    x.write("\"");
    int i = paramString.length();
    int j = 0;
    int n;
    for (int k = 0; j < i; k = n)
    {
      int m = paramString.charAt(j);
      String str2;
      if (m < 128)
      {
        String str1 = arrayOfString[m];
        str2 = str1;
        if (str1 == null)
        {
          n = k;
          break label150;
        }
      }
      else if (m == 8232)
      {
        str2 = "\\u2028";
      }
      else
      {
        n = k;
        if (m != 8233) {
          break label150;
        }
        str2 = "\\u2029";
      }
      if (k < j) {
        x.write(paramString, k, j - k);
      }
      x.write(str2);
      n = j + 1;
      label150:
      j++;
    }
    if (k < i) {
      x.write(paramString, k, i - k);
    }
    x.write("\"");
  }
  
  public c c()
  {
    i();
    a();
    a(3);
    x.write("{");
    return this;
  }
  
  public c c(String paramString)
  {
    if (paramString == null) {
      return g();
    }
    i();
    a();
    b(paramString);
    return this;
  }
  
  public void close()
  {
    x.close();
    int i = z;
    if ((i <= 1) && ((i != 1) || (y[(i - 1)] == 7)))
    {
      z = 0;
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public c d()
  {
    a(1, 2, "]");
    return this;
  }
  
  public c e()
  {
    a(3, 5, "}");
    return this;
  }
  
  public final void f()
  {
    if (A == null) {
      return;
    }
    x.write("\n");
    int i = z;
    for (int j = 1; j < i; j++) {
      x.write(A);
    }
  }
  
  public void flush()
  {
    if (z != 0)
    {
      x.flush();
      return;
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
  
  public c g()
  {
    if (E != null) {
      if (F)
      {
        i();
      }
      else
      {
        E = null;
        return this;
      }
    }
    a();
    x.write("null");
    return this;
  }
  
  public final int h()
  {
    int i = z;
    if (i != 0) {
      return y[(i - 1)];
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
  
  public final void i()
  {
    if (E != null)
    {
      int i = h();
      if (i == 5) {
        x.write(44);
      } else {
        if (i != 3) {
          break label59;
        }
      }
      f();
      b(4);
      b(E);
      E = null;
      return;
      label59:
      throw new IllegalStateException("Nesting problem.");
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.y.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */