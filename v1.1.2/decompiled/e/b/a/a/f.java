package e.b.a.a;

import java.io.Closeable;
import java.io.Flushable;

public abstract class f
  implements Closeable, Flushable
{
  public abstract void a();
  
  public abstract void a(double paramDouble);
  
  public abstract void a(int paramInt);
  
  public abstract void a(a parama, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void close();
  
  public static enum a
  {
    public final boolean _defaultState;
    public final int _mask;
    
    static
    {
      AUTO_CLOSE_JSON_CONTENT = new a("AUTO_CLOSE_JSON_CONTENT", 1, true);
      FLUSH_PASSED_TO_STREAM = new a("FLUSH_PASSED_TO_STREAM", 2, true);
      QUOTE_FIELD_NAMES = new a("QUOTE_FIELD_NAMES", 3, true);
      QUOTE_NON_NUMERIC_NUMBERS = new a("QUOTE_NON_NUMERIC_NUMBERS", 4, true);
      WRITE_NUMBERS_AS_STRINGS = new a("WRITE_NUMBERS_AS_STRINGS", 5, false);
      WRITE_BIGDECIMAL_AS_PLAIN = new a("WRITE_BIGDECIMAL_AS_PLAIN", 6, false);
      ESCAPE_NON_ASCII = new a("ESCAPE_NON_ASCII", 7, false);
      STRICT_DUPLICATE_DETECTION = new a("STRICT_DUPLICATE_DETECTION", 8, false);
      a locala = new a("IGNORE_UNKNOWN", 9, false);
      IGNORE_UNKNOWN = locala;
      $VALUES = new a[] { AUTO_CLOSE_TARGET, AUTO_CLOSE_JSON_CONTENT, FLUSH_PASSED_TO_STREAM, QUOTE_FIELD_NAMES, QUOTE_NON_NUMERIC_NUMBERS, WRITE_NUMBERS_AS_STRINGS, WRITE_BIGDECIMAL_AS_PLAIN, ESCAPE_NON_ASCII, STRICT_DUPLICATE_DETECTION, locala };
    }
    
    public a(boolean paramBoolean)
    {
      _defaultState = paramBoolean;
      _mask = (1 << ordinal());
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
 * Qualified Name:     e.b.a.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */