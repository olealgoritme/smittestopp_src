package e.b.a.a;

import java.io.Closeable;

public abstract class i
  implements Closeable
{
  public int x;
  
  public i() {}
  
  public i(int paramInt)
  {
    x = paramInt;
  }
  
  public h a(String paramString)
  {
    paramString = new h(this, paramString);
    z = null;
    return paramString;
  }
  
  public boolean a(a parama)
  {
    return parama.enabledIn(x);
  }
  
  public byte[] a()
  {
    return a(b.b);
  }
  
  public abstract byte[] a(a parama);
  
  public abstract g b();
  
  public abstract String b(String paramString);
  
  public abstract String c();
  
  public abstract void close();
  
  public String d()
  {
    return b(null);
  }
  
  public abstract boolean e();
  
  public abstract l f();
  
  public abstract l g();
  
  public static enum a
  {
    public final boolean _defaultState;
    public final int _mask = 1 << ordinal();
    
    static
    {
      ALLOW_COMMENTS = new a("ALLOW_COMMENTS", 1, false);
      ALLOW_YAML_COMMENTS = new a("ALLOW_YAML_COMMENTS", 2, false);
      ALLOW_UNQUOTED_FIELD_NAMES = new a("ALLOW_UNQUOTED_FIELD_NAMES", 3, false);
      ALLOW_SINGLE_QUOTES = new a("ALLOW_SINGLE_QUOTES", 4, false);
      ALLOW_UNQUOTED_CONTROL_CHARS = new a("ALLOW_UNQUOTED_CONTROL_CHARS", 5, false);
      ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER = new a("ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER", 6, false);
      ALLOW_NUMERIC_LEADING_ZEROS = new a("ALLOW_NUMERIC_LEADING_ZEROS", 7, false);
      ALLOW_NON_NUMERIC_NUMBERS = new a("ALLOW_NON_NUMERIC_NUMBERS", 8, false);
      ALLOW_MISSING_VALUES = new a("ALLOW_MISSING_VALUES", 9, false);
      ALLOW_TRAILING_COMMA = new a("ALLOW_TRAILING_COMMA", 10, false);
      STRICT_DUPLICATE_DETECTION = new a("STRICT_DUPLICATE_DETECTION", 11, false);
      IGNORE_UNDEFINED = new a("IGNORE_UNDEFINED", 12, false);
      a locala = new a("INCLUDE_SOURCE_IN_LOCATION", 13, true);
      INCLUDE_SOURCE_IN_LOCATION = locala;
      $VALUES = new a[] { AUTO_CLOSE_SOURCE, ALLOW_COMMENTS, ALLOW_YAML_COMMENTS, ALLOW_UNQUOTED_FIELD_NAMES, ALLOW_SINGLE_QUOTES, ALLOW_UNQUOTED_CONTROL_CHARS, ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, ALLOW_NUMERIC_LEADING_ZEROS, ALLOW_NON_NUMERIC_NUMBERS, ALLOW_MISSING_VALUES, ALLOW_TRAILING_COMMA, STRICT_DUPLICATE_DETECTION, IGNORE_UNDEFINED, locala };
    }
    
    public a(boolean paramBoolean)
    {
      _defaultState = paramBoolean;
    }
    
    public static int collectDefaults()
    {
      a[] arrayOfa = values();
      int i = arrayOfa.length;
      int j = 0;
      int m;
      for (int k = 0; j < i; k = m)
      {
        a locala = arrayOfa[j];
        m = k;
        if (locala.enabledByDefault()) {
          m = k | locala.getMask();
        }
        j++;
      }
      return k;
    }
    
    public boolean enabledByDefault()
    {
      return _defaultState;
    }
    
    public boolean enabledIn(int paramInt)
    {
      boolean bool;
      if ((paramInt & _mask) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int getMask()
    {
      return _mask;
    }
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */