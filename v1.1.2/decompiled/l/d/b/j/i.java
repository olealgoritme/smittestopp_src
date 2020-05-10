package l.d.b.j;

import java.util.Date;
import java.util.List;
import l.d.b.f;

public abstract interface i
{
  public abstract void a(StringBuilder paramStringBuilder, String paramString);
  
  public abstract void a(List<Object> paramList);
  
  public static abstract class a
    implements i
  {
    public final boolean a;
    public final Object b;
    public final Object[] c;
    
    public a(Object paramObject)
    {
      b = paramObject;
      a = true;
      c = null;
    }
    
    public a(Object[] paramArrayOfObject)
    {
      b = null;
      a = false;
      c = paramArrayOfObject;
    }
    
    public void a(List<Object> paramList)
    {
      if (a)
      {
        paramList.add(b);
      }
      else
      {
        Object[] arrayOfObject = c;
        if (arrayOfObject != null)
        {
          int i = arrayOfObject.length;
          for (int j = 0; j < i; j++) {
            paramList.add(arrayOfObject[j]);
          }
        }
      }
    }
  }
  
  public static class b
    extends i.a
  {
    public final f d;
    public final String e;
    
    public b(f paramf, String paramString, Object paramObject)
    {
      super();
      d = paramf;
      e = paramString;
    }
    
    public b(f paramf, String paramString, Object[] paramArrayOfObject)
    {
      super();
      d = paramf;
      e = paramString;
    }
    
    public static Object a(f paramf, Object paramObject)
    {
      if ((paramObject != null) && (paramObject.getClass().isArray())) {
        throw new l.d.b.d("Illegal value: found array, but simple object required");
      }
      paramf = b;
      if (paramf == Date.class)
      {
        if ((paramObject instanceof Date)) {
          return Long.valueOf(((Date)paramObject).getTime());
        }
        if ((paramObject instanceof Long)) {
          return paramObject;
        }
        paramf = new StringBuilder();
        paramf.append("Illegal date value: expected java.util.Date or Long for value ");
        paramf.append(paramObject);
        throw new l.d.b.d(paramf.toString());
      }
      if ((paramf == Boolean.TYPE) || (paramf == Boolean.class))
      {
        if ((paramObject instanceof Boolean)) {
          return Integer.valueOf(((Boolean)paramObject).booleanValue());
        }
        if ((paramObject instanceof Number))
        {
          int i = ((Number)paramObject).intValue();
          if ((i != 0) && (i != 1))
          {
            paramf = new StringBuilder();
            paramf.append("Illegal boolean value: numbers must be 0 or 1, but was ");
            paramf.append(paramObject);
            throw new l.d.b.d(paramf.toString());
          }
        }
        else if ((paramObject instanceof String))
        {
          paramf = (String)paramObject;
          if ("TRUE".equalsIgnoreCase(paramf)) {
            return Integer.valueOf(1);
          }
          if ("FALSE".equalsIgnoreCase(paramf)) {
            return Integer.valueOf(0);
          }
          paramf = new StringBuilder();
          paramf.append("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was ");
          paramf.append(paramObject);
          throw new l.d.b.d(paramf.toString());
        }
      }
      return paramObject;
    }
    
    public void a(StringBuilder paramStringBuilder, String paramString)
    {
      l.d.b.i.d.a(paramStringBuilder, paramString, d);
      paramStringBuilder.append(e);
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.j.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */