package e.b.a.a;

import e.b.a.a.q.f;
import java.io.Reader;
import java.io.Serializable;
import java.lang.ref.SoftReference;

public class d
  implements Serializable
{
  public static final int E = ;
  public static final int F = i.a.collectDefaults();
  public static final int G = f.a.collectDefaults();
  public static final n H = e.b.a.a.s.d.x;
  public int A;
  public int B;
  public int C;
  public n D;
  public final transient e.b.a.a.r.b x;
  public final transient e.b.a.a.r.a y;
  public m z;
  
  public d()
  {
    long l = System.currentTimeMillis();
    x = new e.b.a.a.r.b((int)l + (int)(l >>> 32) | 0x1);
    l = System.currentTimeMillis();
    y = new e.b.a.a.r.a(64, true, (int)l + (int)(l >>> 32) | 0x1, true);
    A = E;
    B = F;
    C = G;
    D = H;
    z = null;
  }
  
  public i a(Reader paramReader)
  {
    return new f(a(paramReader, false), B, paramReader, x.b(A));
  }
  
  public e.b.a.a.p.b a(Object paramObject, boolean paramBoolean)
  {
    Object localObject;
    if (a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.enabledIn(A))
    {
      localObject = (SoftReference)e.b.a.a.s.b.a.get();
      e.b.a.a.s.a locala;
      if (localObject == null) {
        locala = null;
      } else {
        locala = (e.b.a.a.s.a)((SoftReference)localObject).get();
      }
      localObject = locala;
      if (locala == null)
      {
        localObject = new e.b.a.a.s.a();
        e.b.a.a.s.b.a.set(new SoftReference(localObject));
      }
    }
    else
    {
      localObject = new e.b.a.a.s.a();
    }
    return new e.b.a.a.p.b((e.b.a.a.s.a)localObject, paramObject, paramBoolean);
  }
  
  public static enum a
  {
    public final boolean _defaultState;
    
    static
    {
      CANONICALIZE_FIELD_NAMES = new a("CANONICALIZE_FIELD_NAMES", 1, true);
      FAIL_ON_SYMBOL_HASH_OVERFLOW = new a("FAIL_ON_SYMBOL_HASH_OVERFLOW", 2, true);
      a locala = new a("USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING", 3, true);
      USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING = locala;
      $VALUES = new a[] { INTERN_FIELD_NAMES, CANONICALIZE_FIELD_NAMES, FAIL_ON_SYMBOL_HASH_OVERFLOW, locala };
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
      if ((paramInt & getMask()) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int getMask()
    {
      return 1 << ordinal();
    }
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */