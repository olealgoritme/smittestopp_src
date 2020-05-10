package e.b.a.a;

public enum i$a
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
  
  public i$a(boolean paramBoolean)
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

/* Location:
 * Qualified Name:     base.e.b.a.a.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */