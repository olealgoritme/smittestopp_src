package i.a.a;

import java.lang.reflect.Method;
import java.util.HashMap;
import k.e.a.q;
import k.e.a.s;
import k.e.a.y;

public class d
{
  public static String i = y.a(c.class);
  public final a[] a;
  public final h b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final HashMap<Class<?>, Method> g = new HashMap();
  public Class<? extends Exception> h = NoSuchFieldException.class;
  
  public d(Class<?> paramClass, a[] paramArrayOfa, h paramh)
  {
    a = paramArrayOfa;
    b = paramh;
    paramClass = paramClass.getName();
    c = paramClass;
    if (paramClass.startsWith("java.")) {
      d = e.a.a.a.a.a(new StringBuilder("net.minidev.asm."), c, "AccAccess");
    } else {
      d = c.concat("AccAccess");
    }
    e = d.replace('.', '/');
    f = c.replace('.', '/');
  }
  
  public final void a(s params, int paramInt1, int paramInt2, q paramq)
  {
    params.d(21, paramInt1);
    if (paramInt2 == 0)
    {
      params.a(154, paramq);
    }
    else if (paramInt2 == 1)
    {
      params.a(4);
      params.a(160, paramq);
    }
    else if (paramInt2 == 2)
    {
      params.a(5);
      params.a(160, paramq);
    }
    else if (paramInt2 == 3)
    {
      params.a(6);
      params.a(160, paramq);
    }
    else if (paramInt2 == 4)
    {
      params.a(7);
      params.a(160, paramq);
    }
    else if (paramInt2 == 5)
    {
      params.a(8);
      params.a(160, paramq);
    }
    else
    {
      if (paramInt2 < 6) {
        break label159;
      }
      params.b(16, paramInt2);
      params.a(160, paramq);
    }
    return;
    label159:
    throw new RuntimeException("non supported negative values");
  }
  
  public final void a(s params, a parama)
  {
    params.d(25, 1);
    params.a(192, f);
    params.d(25, 3);
    y localy = y.b(e);
    Object localObject1 = e;
    String str = y.a((Class)localObject1);
    Object localObject2 = (Method)g.get(localObject1);
    if (localObject2 != null)
    {
      params.b(184, y.a(((Method)localObject2).getDeclaringClass()), ((Method)localObject2).getName(), y.a((Method)localObject2));
    }
    else if (e.isEnum())
    {
      localObject2 = new q();
      params.a(198, (q)localObject2);
      params.d(25, 3);
      params.b(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
      localObject1 = new StringBuilder("(Ljava/lang/String;)L");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(";");
      params.b(184, str, "valueOf", ((StringBuilder)localObject1).toString());
      params.d(58, 3);
      params.a((q)localObject2);
      params.a(3, 0, null, 0, null);
      params.d(25, 1);
      params.a(192, f);
      params.d(25, 3);
      params.a(192, str);
    }
    else if (localObject1.equals(String.class))
    {
      localObject2 = new q();
      params.a(198, (q)localObject2);
      params.d(25, 3);
      params.b(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
      params.d(58, 3);
      params.a((q)localObject2);
      params.a(3, 0, null, 0, null);
      params.d(25, 1);
      params.a(192, f);
      params.d(25, 3);
      params.a(192, str);
    }
    else
    {
      params.a(192, str);
    }
    if (parama.a())
    {
      params.a(181, f, f, localy.a());
    }
    else
    {
      str = y.a(b);
      params.b(182, f, b.getName(), str);
    }
    params.a(177);
  }
  
  public final void a(s params, Class<?> paramClass)
  {
    paramClass = y.a(paramClass);
    params.a(187, paramClass);
    params.a(89);
    StringBuilder localStringBuilder = new StringBuilder("mapping ");
    localStringBuilder.append(c);
    localStringBuilder.append(" failed to map field:");
    params.a(localStringBuilder.toString());
    params.d(21, 2);
    params.b(184, "java/lang/Integer", "toString", "(I)Ljava/lang/String;");
    params.b(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
    params.b(183, paramClass, "<init>", "(Ljava/lang/String;)V");
    params.a(191);
  }
  
  public final void b(s params, Class<?> paramClass)
  {
    String str = y.a(paramClass);
    params.a(187, str);
    params.a(89);
    paramClass = new StringBuilder("mapping ");
    paramClass.append(c);
    paramClass.append(" failed to map field:");
    params.a(paramClass.toString());
    params.d(25, 2);
    params.b(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
    params.b(183, str, "<init>", "(Ljava/lang/String;)V");
    params.a(191);
  }
}

/* Location:
 * Qualified Name:     base.i.a.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */