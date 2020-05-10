package l.d.b.i;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import l.d.b.f;
import l.d.b.h.b;
import l.d.b.h.c;

public final class a
  implements Cloneable
{
  public final String[] A;
  public final String[] B;
  public final String[] C;
  public final f D;
  public final boolean E;
  public final e F;
  public l.d.b.h.a<?, ?> G;
  public final l.d.b.g.a x;
  public final String y;
  public final f[] z;
  
  public a(l.d.b.g.a parama, Class<? extends l.d.b.a<?, ?>> paramClass)
  {
    x = parama;
    try
    {
      Object localObject = paramClass.getField("TABLENAME");
      Class<? extends l.d.b.a<?, ?>> localClass = null;
      y = ((String)((Field)localObject).get(null));
      f[] arrayOff = a(paramClass);
      z = arrayOff;
      A = new String[arrayOff.length];
      ArrayList localArrayList1 = new java/util/ArrayList;
      localArrayList1.<init>();
      ArrayList localArrayList2 = new java/util/ArrayList;
      localArrayList2.<init>();
      boolean bool = false;
      paramClass = null;
      for (int i = 0; i < arrayOff.length; i++)
      {
        localObject = arrayOff[i];
        String str = e;
        A[i] = str;
        if (d)
        {
          localArrayList1.add(str);
          paramClass = (Class<? extends l.d.b.a<?, ?>>)localObject;
        }
        else
        {
          localArrayList2.add(str);
        }
      }
      C = ((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
      localObject = (String[])localArrayList1.toArray(new String[localArrayList1.size()]);
      B = ((String[])localObject);
      if (localObject.length == 1) {
        localClass = paramClass;
      }
      D = localClass;
      paramClass = new l/d/b/i/e;
      paramClass.<init>(parama, y, A, B);
      F = paramClass;
      if (D != null)
      {
        parama = D.b;
        if ((parama.equals(Long.TYPE)) || (parama.equals(Long.class)) || (parama.equals(Integer.TYPE)) || (parama.equals(Integer.class)) || (parama.equals(Short.TYPE)) || (parama.equals(Short.class)) || (parama.equals(Byte.TYPE)) || (parama.equals(Byte.class))) {
          bool = true;
        }
        E = bool;
      }
      else
      {
        E = false;
      }
      return;
    }
    catch (Exception parama)
    {
      throw new l.d.b.d("Could not init DAOConfig", parama);
    }
  }
  
  public a(a parama)
  {
    x = x;
    y = y;
    z = z;
    A = A;
    B = B;
    C = C;
    D = D;
    F = F;
    E = E;
  }
  
  public static f[] a(Class<? extends l.d.b.a<?, ?>> paramClass)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramClass.getName());
    ((StringBuilder)localObject1).append("$Properties");
    localObject1 = Class.forName(((StringBuilder)localObject1).toString()).getDeclaredFields();
    paramClass = new ArrayList();
    int i = localObject1.length;
    for (int j = 0; j < i; j++)
    {
      localObject2 = localObject1[j];
      if ((((Field)localObject2).getModifiers() & 0x9) == 9)
      {
        localObject2 = ((Field)localObject2).get(null);
        if ((localObject2 instanceof f)) {
          paramClass.add((f)localObject2);
        }
      }
    }
    localObject1 = new f[paramClass.size()];
    Object localObject2 = paramClass.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramClass = (f)((Iterator)localObject2).next();
      j = a;
      if (localObject1[j] == null) {
        localObject1[j] = paramClass;
      } else {
        throw new l.d.b.d("Duplicate property ordinals");
      }
    }
    return (f[])localObject1;
  }
  
  public void a(l.d.b.h.d paramd)
  {
    if (paramd == l.d.b.h.d.None)
    {
      G = null;
    }
    else
    {
      if (paramd != l.d.b.h.d.Session) {
        break label55;
      }
      if (E) {
        G = new b();
      } else {
        G = new c();
      }
    }
    return;
    label55:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported type: ");
    localStringBuilder.append(paramd);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Object clone()
  {
    return new a(this);
  }
}

/* Location:
 * Qualified Name:     l.d.b.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */