package e.e.a;

import e.e.a.v.c;
import e.e.a.v.d;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;

public class n
  extends g
{
  public final String A;
  public c B;
  public a C;
  public final m z;
  
  public n(m paramm, p paramp)
  {
    if (paramm != null)
    {
      z = paramm;
      if (paramp != null)
      {
        x = paramp;
        if ((B.get("b64") != null) && (!((Boolean)B.get("b64")).booleanValue()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(ax);
          localStringBuilder.append('.');
          localStringBuilder.append(paramp.toString());
          A = localStringBuilder.toString();
        }
        else
        {
          A = a(paramm.a(), paramp.a());
        }
        B = null;
        C = a.UNSIGNED;
        return;
      }
      throw new IllegalArgumentException("The payload must not be null");
    }
    throw new IllegalArgumentException("The JWS header must not be null");
  }
  
  public n(c paramc1, c paramc2, c paramc3)
  {
    if (paramc1 != null) {
      try
      {
        z = m.a(paramc1);
        if (paramc2 != null)
        {
          x = new p(paramc2);
          A = a(paramc1, paramc2);
          if (paramc3 != null)
          {
            B = paramc3;
            C = a.SIGNED;
            y = new c[] { paramc1, paramc2, paramc3 };
            return;
          }
          throw new IllegalArgumentException("The third part must not be null");
        }
        throw new IllegalArgumentException("The second part must not be null");
      }
      catch (ParseException paramc2)
      {
        paramc1 = e.a.a.a.a.a("Invalid JWS header: ");
        paramc1.append(paramc2.getMessage());
        throw new ParseException(paramc1.toString(), 0);
      }
    }
    throw new IllegalArgumentException("The first part must not be null");
  }
  
  public static String a(c paramc1, c paramc2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(x);
    localStringBuilder.append('.');
    localStringBuilder.append(x);
    return localStringBuilder.toString();
  }
  
  public final void a(o paramo)
  {
    paramo = (e.e.a.s.b.a)paramo;
    if (a.contains((l)z.x)) {
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("The \"");
    localStringBuilder.append((l)z.x);
    localStringBuilder.append("\" algorithm is not allowed or supported by the JWS signer: Supported algorithms: ");
    localStringBuilder.append(a);
    throw new f(localStringBuilder.toString());
  }
  
  public void b(o paramo)
  {
    label87:
    label99:
    try
    {
      if (C != a.UNSIGNED) {
        break label87;
      }
      a(paramo);
      try
      {
        m localm = z;
        byte[] arrayOfByte = A.getBytes(d.a);
        paramo = (e.e.a.s.a)paramo;
        B = paramo.a(localm, arrayOfByte);
        C = a.SIGNED;
        return;
      }
      catch (Exception localException) {}catch (f paramo) {}
      paramo = new e/e/a/f;
      paramo.<init>(localException.getMessage(), localException);
      throw paramo;
    }
    finally
    {
      break label99;
      paramo = new java/lang/IllegalStateException;
      paramo.<init>("The JWS object must be in an unsigned state");
      throw paramo;
    }
    throw paramo;
  }
  
  public String c()
  {
    Object localObject = C;
    if ((localObject != a.SIGNED) && (localObject != a.VERIFIED)) {
      throw new IllegalStateException("The JWS object must be in a signed or verified state");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(A);
    ((StringBuilder)localObject).append('.');
    ((StringBuilder)localObject).append(B.x);
    return ((StringBuilder)localObject).toString();
  }
  
  public static enum a
  {
    static
    {
      SIGNED = new a("SIGNED", 1);
      a locala = new a("VERIFIED", 2);
      VERIFIED = locala;
      $VALUES = new a[] { UNSIGNED, SIGNED, locala };
    }
    
    public a() {}
  }
}

/* Location:
 * Qualified Name:     e.e.a.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */