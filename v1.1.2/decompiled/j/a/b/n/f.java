package j.a.b.n;

public abstract class f<T>
{
  public final e a;
  
  public f(e parame)
  {
    a = parame;
  }
  
  public f<?> a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf("Invalid or non Implemented status"));
    localStringBuilder.append(" startArray in ");
    localStringBuilder.append(getClass());
    localStringBuilder.append(" key=");
    localStringBuilder.append(paramString);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public abstract Object a();
  
  public T a(Object paramObject)
  {
    return (T)paramObject;
  }
  
  public abstract void a(Object paramObject1, Object paramObject2);
  
  public void a(Object paramObject1, String paramString, Object paramObject2)
  {
    paramObject1 = new StringBuilder(String.valueOf("Invalid or non Implemented status"));
    ((StringBuilder)paramObject1).append(" setValue in ");
    ((StringBuilder)paramObject1).append(getClass());
    ((StringBuilder)paramObject1).append(" key=");
    ((StringBuilder)paramObject1).append(paramString);
    throw new RuntimeException(((StringBuilder)paramObject1).toString());
  }
  
  public f<?> b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf("Invalid or non Implemented status"));
    localStringBuilder.append(" startObject(String key) in ");
    localStringBuilder.append(getClass());
    localStringBuilder.append(" key=");
    localStringBuilder.append(paramString);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public Object b()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf("Invalid or non Implemented status"));
    localStringBuilder.append(" createObject() in ");
    localStringBuilder.append(getClass());
    throw new RuntimeException(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */