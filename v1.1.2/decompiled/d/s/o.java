package d.s;

import android.os.Bundle;
import android.os.Parcelable;
import e.a.a.a.a;
import java.io.Serializable;

public abstract class o<T>
{
  public static final o<Integer> b = new c(false);
  public static final o<Integer> c = new d(false);
  public static final o<int[]> d = new e(true);
  public static final o<Long> e = new f(false);
  public static final o<long[]> f = new g(true);
  public static final o<Float> g = new h(false);
  public static final o<float[]> h = new i(true);
  public static final o<Boolean> i = new j(false);
  public static final o<boolean[]> j = new k(true);
  public static final o<String> k = new a(true);
  public static final o<String[]> l = new b(true);
  public final boolean a;
  
  public o(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static o a(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return b;
    }
    if ((paramObject instanceof int[])) {
      return d;
    }
    if ((paramObject instanceof Long)) {
      return e;
    }
    if ((paramObject instanceof long[])) {
      return f;
    }
    if ((paramObject instanceof Float)) {
      return g;
    }
    if ((paramObject instanceof float[])) {
      return h;
    }
    if ((paramObject instanceof Boolean)) {
      return i;
    }
    if ((paramObject instanceof boolean[])) {
      return j;
    }
    if ((!(paramObject instanceof String)) && (paramObject != null))
    {
      if ((paramObject instanceof String[])) {
        return l;
      }
      if ((paramObject.getClass().isArray()) && (Parcelable.class.isAssignableFrom(paramObject.getClass().getComponentType()))) {
        return new m(paramObject.getClass().getComponentType());
      }
      if ((paramObject.getClass().isArray()) && (Serializable.class.isAssignableFrom(paramObject.getClass().getComponentType()))) {
        return new o(paramObject.getClass().getComponentType());
      }
      if ((paramObject instanceof Parcelable)) {
        return new n(paramObject.getClass());
      }
      if ((paramObject instanceof Enum)) {
        return new l(paramObject.getClass());
      }
      if ((paramObject instanceof Serializable)) {
        return new p(paramObject.getClass());
      }
      StringBuilder localStringBuilder = a.a("Object of type ");
      localStringBuilder.append(paramObject.getClass().getName());
      localStringBuilder.append(" is not supported for navigation arguments.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return k;
  }
  
  public abstract T a(Bundle paramBundle, String paramString);
  
  public abstract T a(String paramString);
  
  public abstract String a();
  
  public abstract void a(Bundle paramBundle, String paramString, T paramT);
  
  public String toString()
  {
    return a();
  }
  
  public static final class a
    extends o<String>
  {
    public a(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (String)paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      return paramString;
    }
    
    public String a()
    {
      return "string";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putString(paramString, (String)paramObject);
    }
  }
  
  public static final class b
    extends o<String[]>
  {
    public b(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (String[])paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public String a()
    {
      return "string[]";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putStringArray(paramString, (String[])paramObject);
    }
  }
  
  public static final class c
    extends o<Integer>
  {
    public c(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (Integer)paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      if (paramString.startsWith("0x")) {
        paramString = Integer.valueOf(Integer.parseInt(paramString.substring(2), 16));
      } else {
        paramString = Integer.valueOf(Integer.parseInt(paramString));
      }
      return paramString;
    }
    
    public String a()
    {
      return "integer";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
    }
  }
  
  public static final class d
    extends o<Integer>
  {
    public d(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (Integer)paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      throw new UnsupportedOperationException("References don't support parsing string values.");
    }
    
    public String a()
    {
      return "reference";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
    }
  }
  
  public static final class e
    extends o<int[]>
  {
    public e(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (int[])paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public String a()
    {
      return "integer[]";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putIntArray(paramString, (int[])paramObject);
    }
  }
  
  public static final class f
    extends o<Long>
  {
    public f(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (Long)paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      String str = paramString;
      if (paramString.endsWith("L")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      if (str.startsWith("0x")) {
        paramString = Long.valueOf(Long.parseLong(str.substring(2), 16));
      } else {
        paramString = Long.valueOf(Long.parseLong(str));
      }
      return paramString;
    }
    
    public String a()
    {
      return "long";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
    }
  }
  
  public static final class g
    extends o<long[]>
  {
    public g(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (long[])paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public String a()
    {
      return "long[]";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putLongArray(paramString, (long[])paramObject);
    }
  }
  
  public static final class h
    extends o<Float>
  {
    public h(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (Float)paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      return Float.valueOf(Float.parseFloat(paramString));
    }
    
    public String a()
    {
      return "float";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
    }
  }
  
  public static final class i
    extends o<float[]>
  {
    public i(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (float[])paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public String a()
    {
      return "float[]";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putFloatArray(paramString, (float[])paramObject);
    }
  }
  
  public static final class j
    extends o<Boolean>
  {
    public j(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (Boolean)paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      if ("true".equals(paramString))
      {
        paramString = Boolean.valueOf(true);
      }
      else
      {
        if (!"false".equals(paramString)) {
          break label33;
        }
        paramString = Boolean.valueOf(false);
      }
      return paramString;
      label33:
      throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
    }
    
    public String a()
    {
      return "boolean";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
  }
  
  public static final class k
    extends o<boolean[]>
  {
    public k(boolean paramBoolean)
    {
      super();
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (boolean[])paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public String a()
    {
      return "boolean[]";
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramBundle.putBooleanArray(paramString, (boolean[])paramObject);
    }
  }
  
  public static final class l<D extends Enum>
    extends o.p<D>
  {
    public final Class<D> n;
    
    public l(Class<D> paramClass)
    {
      super(paramClass);
      if (paramClass.isEnum())
      {
        n = paramClass;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" is not an Enum type.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public D a(String paramString)
    {
      for (localObject : (Enum[])n.getEnumConstants()) {
        if (((Enum)localObject).name().equals(paramString)) {
          return (D)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Enum value ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" not found for type ");
      ((StringBuilder)localObject).append(n.getName());
      ((StringBuilder)localObject).append(".");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public String a()
    {
      return n.getName();
    }
  }
  
  public static final class m<D extends Parcelable>
    extends o<D[]>
  {
    public final Class<D[]> m;
    
    public m(Class<D> paramClass)
    {
      super();
      if (Parcelable.class.isAssignableFrom(paramClass)) {
        try
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("[L");
          localStringBuilder.append(paramClass.getName());
          localStringBuilder.append(";");
          paramClass = Class.forName(localStringBuilder.toString());
          m = paramClass;
          return;
        }
        catch (ClassNotFoundException paramClass)
        {
          throw new RuntimeException(paramClass);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Parcelable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (Parcelable[])paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public String a()
    {
      return m.getName();
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramObject = (Parcelable[])paramObject;
      m.cast(paramObject);
      paramBundle.putParcelableArray(paramString, (Parcelable[])paramObject);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (m.class == paramObject.getClass()))
      {
        paramObject = (m)paramObject;
        return m.equals(m);
      }
      return false;
    }
    
    public int hashCode()
    {
      return m.hashCode();
    }
  }
  
  public static final class n<D>
    extends o<D>
  {
    public final Class<D> m;
    
    public n(Class<D> paramClass)
    {
      super();
      if ((!Parcelable.class.isAssignableFrom(paramClass)) && (!Serializable.class.isAssignableFrom(paramClass)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass);
        localStringBuilder.append(" does not implement Parcelable or Serializable.");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      m = paramClass;
    }
    
    public D a(Bundle paramBundle, String paramString)
    {
      return (D)paramBundle.get(paramString);
    }
    
    public D a(String paramString)
    {
      throw new UnsupportedOperationException("Parcelables don't support default values.");
    }
    
    public String a()
    {
      return m.getName();
    }
    
    public void a(Bundle paramBundle, String paramString, D paramD)
    {
      m.cast(paramD);
      if ((paramD != null) && (!(paramD instanceof Parcelable)))
      {
        if ((paramD instanceof Serializable)) {
          paramBundle.putSerializable(paramString, (Serializable)paramD);
        }
      }
      else {
        paramBundle.putParcelable(paramString, (Parcelable)paramD);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (n.class == paramObject.getClass()))
      {
        paramObject = (n)paramObject;
        return m.equals(m);
      }
      return false;
    }
    
    public int hashCode()
    {
      return m.hashCode();
    }
  }
  
  public static final class o<D extends Serializable>
    extends o<D[]>
  {
    public final Class<D[]> m;
    
    public o(Class<D> paramClass)
    {
      super();
      if (Serializable.class.isAssignableFrom(paramClass)) {
        try
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("[L");
          localStringBuilder.append(paramClass.getName());
          localStringBuilder.append(";");
          paramClass = Class.forName(localStringBuilder.toString());
          m = paramClass;
          return;
        }
        catch (ClassNotFoundException paramClass)
        {
          throw new RuntimeException(paramClass);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Serializable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (Serializable[])paramBundle.get(paramString);
    }
    
    public Object a(String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public String a()
    {
      return m.getName();
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramObject = (Serializable[])paramObject;
      m.cast(paramObject);
      paramBundle.putSerializable(paramString, (Serializable)paramObject);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (o.class == paramObject.getClass()))
      {
        paramObject = (o)paramObject;
        return m.equals(m);
      }
      return false;
    }
    
    public int hashCode()
    {
      return m.hashCode();
    }
  }
  
  public static class p<D extends Serializable>
    extends o<D>
  {
    public final Class<D> m;
    
    public p(Class<D> paramClass)
    {
      super();
      if (Serializable.class.isAssignableFrom(paramClass))
      {
        if (!paramClass.isEnum())
        {
          m = paramClass;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass);
        localStringBuilder.append(" is an Enum. You should use EnumType instead.");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Serializable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public p(boolean paramBoolean, Class<D> paramClass)
    {
      super();
      if (Serializable.class.isAssignableFrom(paramClass))
      {
        m = paramClass;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Serializable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public D a(String paramString)
    {
      throw new UnsupportedOperationException("Serializables don't support default values.");
    }
    
    public Object a(Bundle paramBundle, String paramString)
    {
      return (Serializable)paramBundle.get(paramString);
    }
    
    public String a()
    {
      return m.getName();
    }
    
    public void a(Bundle paramBundle, String paramString, Object paramObject)
    {
      paramObject = (Serializable)paramObject;
      m.cast(paramObject);
      paramBundle.putSerializable(paramString, (Serializable)paramObject);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof p)) {
        return false;
      }
      paramObject = (p)paramObject;
      return m.equals(m);
    }
    
    public int hashCode()
    {
      return m.hashCode();
    }
  }
}

/* Location:
 * Qualified Name:     d.s.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */