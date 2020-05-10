package l.a.b.a.d.g0;

import java.nio.ByteBuffer;
import l.a.b.a.c.i;

public class u
{
  public t a;
  public a b = a.HEADER0;
  public int c;
  public ByteBuffer d;
  public final i e;
  public int f;
  public a0 g;
  
  public u(t paramt, i parami, int paramInt, a0 parama0)
  {
    a = paramt;
    e = parami;
    f = paramInt;
    g = parama0;
  }
  
  public static enum a
  {
    static
    {
      PRE_PARSE = new a("PRE_PARSE", 12);
      BUFFERING = new a("BUFFERING", 13);
      PARSING = new a("PARSING", 14);
      a locala = new a("ERROR", 15);
      ERROR = locala;
      $VALUES = new a[] { HEADER0, HEADER1, HEADER2, HEADER3, HEADER4, HEADER5, HEADER6, HEADER7, SIZE_0, SIZE_1, SIZE_2, SIZE_3, PRE_PARSE, BUFFERING, PARSING, locala };
    }
    
    public a() {}
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */