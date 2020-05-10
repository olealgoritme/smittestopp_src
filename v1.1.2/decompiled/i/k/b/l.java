package i.k.b;

public class l
{
  public static final m a;
  
  static
  {
    Object localObject = null;
    try
    {
      m localm = (m)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
      localObject = localm;
    }
    catch (ClassCastException|ClassNotFoundException|InstantiationException|IllegalAccessException localClassCastException) {}
    if (localObject == null) {
      localObject = new m();
    }
    a = (m)localObject;
  }
}

/* Location:
 * Qualified Name:     i.k.b.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */