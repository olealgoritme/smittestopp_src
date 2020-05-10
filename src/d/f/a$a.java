package d.f;

import java.util.Map;

public class a$a
  extends g<K, V>
{
  public a$a(a parama) {}
  
  public int a(Object paramObject)
  {
    return d.a(paramObject);
  }
  
  public Object a(int paramInt1, int paramInt2)
  {
    return d.y[((paramInt1 << 1) + paramInt2)];
  }
  
  public V a(int paramInt, V paramV)
  {
    Object localObject = d;
    paramInt = (paramInt << 1) + 1;
    localObject = y;
    V ? = localObject[paramInt];
    localObject[paramInt] = paramV;
    return ?;
  }
  
  public void a()
  {
    d.clear();
  }
  
  public void a(int paramInt)
  {
    d.d(paramInt);
  }
  
  public void a(K paramK, V paramV)
  {
    d.put(paramK, paramV);
  }
  
  public int b(Object paramObject)
  {
    return d.b(paramObject);
  }
  
  public Map<K, V> b()
  {
    return d;
  }
  
  public int c()
  {
    return d.z;
  }
}

/* Location:
 * Qualified Name:     base.d.f.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */