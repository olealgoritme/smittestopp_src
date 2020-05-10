package e.b.a.a.o;

import e.a.a.a.a;
import e.b.a.a.i;
import e.b.a.a.i.a;
import e.b.a.a.l;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class c
  extends i
{
  public static final BigInteger A;
  public static final BigInteger B;
  public static final BigInteger C;
  public static final BigInteger D;
  public static final byte[] z = new byte[0];
  public l y;
  
  static
  {
    A = BigInteger.valueOf(-2147483648L);
    B = BigInteger.valueOf(2147483647L);
    C = BigInteger.valueOf(Long.MIN_VALUE);
    D = BigInteger.valueOf(Long.MAX_VALUE);
    new BigDecimal(C);
    new BigDecimal(D);
    new BigDecimal(A);
    new BigDecimal(B);
  }
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public static final String b(int paramInt)
  {
    char c = (char)paramInt;
    if (Character.isISOControl(c)) {
      return a.b("(CTRL-CHAR, code ", paramInt, ")");
    }
    if (paramInt > 255)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      localStringBuilder.append(c);
      localStringBuilder.append("' (code ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" / 0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("'");
    localStringBuilder.append(c);
    localStringBuilder.append("' (code ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public char a(char paramChar)
  {
    if (a(i.a.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
      return paramChar;
    }
    if ((paramChar == '\'') && (a(i.a.ALLOW_SINGLE_QUOTES))) {
      return paramChar;
    }
    StringBuilder localStringBuilder = a.a("Unrecognized character escape ");
    localStringBuilder.append(b(paramChar));
    throw a(localStringBuilder.toString());
  }
  
  public void a(int paramInt)
  {
    paramInt = (char)paramInt;
    StringBuilder localStringBuilder = a.a("Illegal character (");
    localStringBuilder.append(b(paramInt));
    localStringBuilder.append("): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    throw a(localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt >= 0)
    {
      String str1 = String.format("Unexpected character (%s)", new Object[] { b(paramInt) });
      String str2 = str1;
      if (paramString != null) {
        str2 = a.a(str1, ": ", paramString);
      }
      throw a(str2);
    }
    h();
    throw null;
  }
  
  public void a(l paraml)
  {
    String str;
    if (paraml != l.VALUE_STRING)
    {
      if ((paraml != l.VALUE_NUMBER_INT) && (paraml != l.VALUE_NUMBER_FLOAT)) {
        str = " in a value";
      } else {
        str = " in a Number value";
      }
    }
    else {
      str = " in a String value";
    }
    a(str, paraml);
    throw null;
  }
  
  public void a(String paramString, l paraml)
  {
    throw new e.b.a.a.p.c(this, paraml, a.b("Unexpected end-of-input", paramString));
  }
  
  public final void a(String paramString, Object paramObject1, Object paramObject2)
  {
    throw a(String.format(paramString, new Object[] { paramObject1, paramObject2 }));
  }
  
  public String b(String paramString)
  {
    l locall = y;
    if (locall == l.VALUE_STRING) {
      return i();
    }
    if (locall == l.FIELD_NAME) {
      return c();
    }
    String str = paramString;
    if (locall != null)
    {
      str = paramString;
      if (locall != l.VALUE_NULL) {
        if (!locall.isScalarValue()) {
          str = paramString;
        } else {
          str = i();
        }
      }
    }
    return str;
  }
  
  public void b(int paramInt, String paramString)
  {
    if ((a(i.a.ALLOW_UNQUOTED_CONTROL_CHARS)) && (paramInt <= 32)) {
      return;
    }
    paramInt = (char)paramInt;
    StringBuilder localStringBuilder = a.a("Illegal unquoted character (");
    localStringBuilder.append(b(paramInt));
    localStringBuilder.append("): has to be escaped using backslash to be included in ");
    localStringBuilder.append(paramString);
    throw a(localStringBuilder.toString());
  }
  
  public void c(int paramInt, String paramString)
  {
    String str1 = String.format("Unexpected character (%s) in numeric value", new Object[] { b(paramInt) });
    String str2 = str1;
    if (paramString != null) {
      str2 = a.a(str1, ": ", paramString);
    }
    throw a(str2);
  }
  
  public boolean e()
  {
    boolean bool;
    if (y != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public l g()
  {
    l locall1 = f();
    l locall2 = locall1;
    if (locall1 == l.FIELD_NAME) {
      locall2 = f();
    }
    return locall2;
  }
  
  public void h()
  {
    StringBuilder localStringBuilder = a.a(" in ");
    localStringBuilder.append(y);
    a(localStringBuilder.toString(), y);
    throw null;
  }
  
  public abstract String i();
}

/* Location:
 * Qualified Name:     e.b.a.a.o.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */