package g.e;

import java.net.SocketOption;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class i$a
{
  public static final Set<SocketOption<?>> a;
  
  static
  {
    HashSet localHashSet = new HashSet(5);
    localHashSet.add(j.a);
    localHashSet.add(j.b);
    localHashSet.add(j.c);
    localHashSet.add(j.d);
    localHashSet.add(j.f);
    localHashSet.add(j.e);
    localHashSet.add(j.g);
    a = Collections.unmodifiableSet(localHashSet);
  }
}

/* Location:
 * Qualified Name:     base.g.e.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */