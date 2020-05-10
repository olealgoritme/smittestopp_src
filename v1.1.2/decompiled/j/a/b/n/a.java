package j.a.b.n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a<T>
  extends f<T>
{
  public static f<int[]> b = new h(null);
  public static f<Integer[]> c = new i(null);
  public static f<byte[]> d = new l(null);
  public static f<Byte[]> e = new m(null);
  public static f<char[]> f = new n(null);
  public static f<Character[]> g = new o(null);
  public static f<long[]> h = new p(null);
  public static f<Long[]> i = new a(null);
  public static f<float[]> j = new b(null);
  public static f<Float[]> k = new c(null);
  public static f<double[]> l = new d(null);
  public static f<Double[]> m = new e(null);
  public static f<boolean[]> n = new f(null);
  public static f<Boolean[]> o = new g(null);
  
  static
  {
    new j(null);
    new k(null);
  }
  
  public a(e parame)
  {
    super(parame);
  }
  
  public Object a()
  {
    return new ArrayList();
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    ((List)paramObject1).add(paramObject2);
  }
  
  public class a
    extends a<Long[]>
  {
    public a()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject1 = (List)paramObject;
      paramObject = new Long[((List)localObject1).size()];
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          return paramObject;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if ((localObject2 instanceof Float)) {
            paramObject[i] = ((Long)localObject2);
          } else {
            paramObject[i] = Long.valueOf(((Number)localObject2).longValue());
          }
          i++;
        }
      }
    }
  }
  
  public class b
    extends a<float[]>
  {
    public b()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new float[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (int i = 0;; i++)
      {
        if (!((Iterator)localObject).hasNext()) {
          return paramObject;
        }
        paramObject[i] = ((Number)((Iterator)localObject).next()).floatValue();
      }
    }
  }
  
  public class c
    extends a<Float[]>
  {
    public c()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject1 = (List)paramObject;
      paramObject = new Float[((List)localObject1).size()];
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          return paramObject;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if ((localObject2 instanceof Float)) {
            paramObject[i] = ((Float)localObject2);
          } else {
            paramObject[i] = Float.valueOf(((Number)localObject2).floatValue());
          }
          i++;
        }
      }
    }
  }
  
  public class d
    extends a<double[]>
  {
    public d()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new double[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (int i = 0;; i++)
      {
        if (!((Iterator)localObject).hasNext()) {
          return paramObject;
        }
        paramObject[i] = ((Number)((Iterator)localObject).next()).doubleValue();
      }
    }
  }
  
  public class e
    extends a<Double[]>
  {
    public e()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject1 = (List)paramObject;
      paramObject = new Double[((List)localObject1).size()];
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          return paramObject;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if ((localObject2 instanceof Double)) {
            paramObject[i] = ((Double)localObject2);
          } else {
            paramObject[i] = Double.valueOf(((Number)localObject2).doubleValue());
          }
          i++;
        }
      }
    }
  }
  
  public class f
    extends a<boolean[]>
  {
    public f()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new boolean[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (int i = 0;; i++)
      {
        if (!((Iterator)localObject).hasNext()) {
          return paramObject;
        }
        paramObject[i] = ((Boolean)((Iterator)localObject).next()).booleanValue();
      }
    }
  }
  
  public class g
    extends a<Boolean[]>
  {
    public g()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new Boolean[((List)localObject).size()];
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return paramObject;
        }
        localObject = localIterator.next();
        if (localObject != null)
        {
          if ((localObject instanceof Boolean))
          {
            paramObject[i] = Boolean.valueOf(((Boolean)localObject).booleanValue());
          }
          else
          {
            if (!(localObject instanceof Number)) {
              break;
            }
            boolean bool;
            if (((Number)localObject).intValue() != 0) {
              bool = true;
            } else {
              bool = false;
            }
            paramObject[i] = Boolean.valueOf(bool);
          }
          i++;
        }
      }
      paramObject = new StringBuilder("can not convert ");
      ((StringBuilder)paramObject).append(localObject);
      ((StringBuilder)paramObject).append(" toBoolean");
      throw new RuntimeException(((StringBuilder)paramObject).toString());
    }
  }
  
  public class h
    extends a<int[]>
  {
    public h()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new int[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (int i = 0;; i++)
      {
        if (!((Iterator)localObject).hasNext()) {
          return paramObject;
        }
        paramObject[i] = ((Number)((Iterator)localObject).next()).intValue();
      }
    }
  }
  
  public class i
    extends a<Integer[]>
  {
    public i()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new Integer[((List)localObject).size()];
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return paramObject;
        }
        localObject = localIterator.next();
        if (localObject != null)
        {
          if ((localObject instanceof Integer)) {
            paramObject[i] = ((Integer)localObject);
          } else {
            paramObject[i] = Integer.valueOf(((Number)localObject).intValue());
          }
          i++;
        }
      }
    }
  }
  
  public class j
    extends a<short[]>
  {
    public j()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new short[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (int i = 0;; i++)
      {
        if (!((Iterator)localObject).hasNext()) {
          return paramObject;
        }
        paramObject[i] = ((Number)((Iterator)localObject).next()).shortValue();
      }
    }
  }
  
  public class k
    extends a<Short[]>
  {
    public k()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new Short[((List)localObject).size()];
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return paramObject;
        }
        localObject = localIterator.next();
        if (localObject != null)
        {
          if ((localObject instanceof Short)) {
            paramObject[i] = ((Short)localObject);
          } else {
            paramObject[i] = Short.valueOf(((Number)localObject).shortValue());
          }
          i++;
        }
      }
    }
  }
  
  public class l
    extends a<byte[]>
  {
    public l()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new byte[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (int i = 0;; i++)
      {
        if (!((Iterator)localObject).hasNext()) {
          return paramObject;
        }
        paramObject[i] = ((Number)((Iterator)localObject).next()).byteValue();
      }
    }
  }
  
  public class m
    extends a<Byte[]>
  {
    public m()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new Byte[((List)localObject).size()];
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return paramObject;
        }
        localObject = localIterator.next();
        if (localObject != null)
        {
          if ((localObject instanceof Byte)) {
            paramObject[i] = ((Byte)localObject);
          } else {
            paramObject[i] = Byte.valueOf(((Number)localObject).byteValue());
          }
          i++;
        }
      }
    }
  }
  
  public class n
    extends a<char[]>
  {
    public n()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new char[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (int i = 0;; i++)
      {
        if (!((Iterator)localObject).hasNext()) {
          return paramObject;
        }
        paramObject[i] = ((Iterator)localObject).next().toString().charAt(0);
      }
    }
  }
  
  public class o
    extends a<Character[]>
  {
    public o()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new Character[((List)localObject).size()];
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return paramObject;
        }
        localObject = localIterator.next();
        if (localObject != null)
        {
          paramObject[i] = Character.valueOf(localObject.toString().charAt(0));
          i++;
        }
      }
    }
  }
  
  public class p
    extends a<long[]>
  {
    public p()
    {
      super();
    }
    
    public Object a(Object paramObject)
    {
      Object localObject = (List)paramObject;
      paramObject = new long[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (int i = 0;; i++)
      {
        if (!((Iterator)localObject).hasNext()) {
          return paramObject;
        }
        paramObject[i] = ((Number)((Iterator)localObject).next()).intValue();
      }
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */