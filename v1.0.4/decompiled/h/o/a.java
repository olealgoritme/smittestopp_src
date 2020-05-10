package h.o;

import h.k.b.g;
import java.nio.charset.Charset;

public final class a
{
  public static final Charset a;
  
  static
  {
    g.a(Charset.forName("UTF-8"), "Charset.forName(\"UTF-8\")");
    g.a(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
    g.a(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
    g.a(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
    Charset localCharset = Charset.forName("US-ASCII");
    g.a(localCharset, "Charset.forName(\"US-ASCII\")");
    a = localCharset;
    g.a(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
  }
}

/* Location:
 * Qualified Name:     base.h.o.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */