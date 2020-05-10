package g.c.l;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

public final class g
  implements h
{
  public g(Map<Class, Object<?, ?>> paramMap1, Map<Class, Object<?, ?>> paramMap2)
  {
    Collections.unmodifiableMap(new IdentityHashMap(paramMap1));
    Collections.unmodifiableMap(new IdentityHashMap(paramMap2));
  }
}

/* Location:
 * Qualified Name:     base.g.c.l.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */