package d.c.a.b;

import java.util.HashMap;

public class a<K, V>
  extends b<K, V>
{
  public HashMap<K, b.c<K, V>> B = new HashMap();
  
  public b.c<K, V> a(K paramK)
  {
    return (b.c)B.get(paramK);
  }
  
  public V b(K paramK, V paramV)
  {
    b.c localc = (b.c)B.get(paramK);
    if (localc != null) {
      return (V)y;
    }
    B.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public boolean contains(K paramK)
  {
    return B.containsKey(paramK);
  }
  
  public V remove(K paramK)
  {
    Object localObject = super.remove(paramK);
    B.remove(paramK);
    return (V)localObject;
  }
}

/* Location:
 * Qualified Name:     d.c.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */