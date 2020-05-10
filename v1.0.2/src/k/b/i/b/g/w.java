package k.b.i.b.g;

import java.util.Map;
import k.b.a.o;

public final class w
{
  public final v a;
  public final int b;
  public final int c;
  public final o d;
  public final int e;
  public final String f;
  public final int g;
  public final m h;
  
  public w(int paramInt, k.b.c.a parama)
  {
    if (paramInt >= 2)
    {
      if (parama != null)
      {
        b = paramInt;
        for (int i = 2;; i++)
        {
          int j = b;
          if (i > j) {
            break;
          }
          if ((j - i) % 2 == 0)
          {
            c = i;
            f = parama.a();
            parama = parama.a();
            o localo = (o)f.a.get(parama);
            if (localo != null)
            {
              d = localo;
              parama = new m(localo);
              h = parama;
              i = b;
              g = i;
              j = c;
              e = j;
              a = e.b(f, i, j, d, paramInt);
              return;
            }
            throw new IllegalArgumentException(e.a.a.a.a.b("unrecognized digest name: ", parama));
          }
        }
        throw new IllegalStateException("should never happen...");
      }
      throw new NullPointerException("digest == null");
    }
    throw new IllegalArgumentException("height must be >= 2");
  }
  
  public k a()
  {
    return new k(h);
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */