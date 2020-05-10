package e.e.a.u;

import e.a.a.a.a;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public enum e
{
  public final String identifier;
  
  static
  {
    ENCRYPT = new e("ENCRYPT", 2, "encrypt");
    DECRYPT = new e("DECRYPT", 3, "decrypt");
    WRAP_KEY = new e("WRAP_KEY", 4, "wrapKey");
    UNWRAP_KEY = new e("UNWRAP_KEY", 5, "unwrapKey");
    DERIVE_KEY = new e("DERIVE_KEY", 6, "deriveKey");
    e locale = new e("DERIVE_BITS", 7, "deriveBits");
    DERIVE_BITS = locale;
    $VALUES = new e[] { SIGN, VERIFY, ENCRYPT, DECRYPT, WRAP_KEY, UNWRAP_KEY, DERIVE_KEY, locale };
  }
  
  public e(String paramString)
  {
    if (paramString != null)
    {
      identifier = paramString;
      return;
    }
    throw new IllegalArgumentException("The key operation identifier must not be null");
  }
  
  public static Set<e> parse(List<String> paramList)
  {
    if (paramList == null) {
      return null;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str != null)
      {
        for (paramList : values()) {
          if (str.equals(paramList.identifier())) {
            break label95;
          }
        }
        paramList = null;
        label95:
        if (paramList != null) {
          localLinkedHashSet.add(paramList);
        } else {
          throw new ParseException(a.b("Invalid JWK operation: ", str), 0);
        }
      }
    }
    return localLinkedHashSet;
  }
  
  public String identifier()
  {
    return identifier;
  }
  
  public String toString()
  {
    return identifier();
  }
}

/* Location:
 * Qualified Name:     e.e.a.u.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */