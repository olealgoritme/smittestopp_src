package e.b.a.a;

public enum d$a
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
  
  public d$a(boolean paramBoolean)
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

/* Location:
 * Qualified Name:     e.b.a.a.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */