package e.e.a;

import e.e.a.v.c;
import java.text.ParseException;

public class k
  extends g
{
  public c A;
  public c B;
  public c C;
  public c D;
  public a E;
  public j z;
  
  public k(c paramc1, c paramc2, c paramc3, c paramc4, c paramc5)
  {
    if (paramc1 != null) {
      try
      {
        z = j.a(paramc1);
        if ((paramc2 != null) && (!x.isEmpty())) {
          A = paramc2;
        } else {
          A = null;
        }
        if ((paramc3 != null) && (!x.isEmpty())) {
          B = paramc3;
        } else {
          B = null;
        }
        if (paramc4 != null)
        {
          C = paramc4;
          if ((paramc5 != null) && (!x.isEmpty())) {
            D = paramc5;
          } else {
            D = null;
          }
          E = a.ENCRYPTED;
          y = new c[] { paramc1, paramc2, paramc3, paramc4, paramc5 };
          return;
        }
        throw new IllegalArgumentException("The fourth part must not be null");
      }
      catch (ParseException paramc2)
      {
        paramc1 = e.a.a.a.a.a("Invalid JWE header: ");
        paramc1.append(paramc2.getMessage());
        throw new ParseException(paramc1.toString(), 0);
      }
    }
    throw new IllegalArgumentException("The first part must not be null");
  }
  
  public static enum a
  {
    static
    {
      ENCRYPTED = new a("ENCRYPTED", 1);
      a locala = new a("DECRYPTED", 2);
      DECRYPTED = locala;
      $VALUES = new a[] { UNENCRYPTED, ENCRYPTED, locala };
    }
    
    public a() {}
  }
}

/* Location:
 * Qualified Name:     e.e.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */