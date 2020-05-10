package d.w.a;

public final class a
  implements e
{
  public final String x;
  public final Object[] y;
  
  public a(String paramString)
  {
    x = paramString;
    y = null;
  }
  
  public String a()
  {
    return x;
  }
  
  public void a(d paramd)
  {
    Object[] arrayOfObject = y;
    if (arrayOfObject != null)
    {
      int i = arrayOfObject.length;
      int j = 0;
      while (j < i)
      {
        Object localObject = arrayOfObject[j];
        j++;
        if (localObject == null)
        {
          paramd.bindNull(j);
        }
        else if ((localObject instanceof byte[]))
        {
          paramd.bindBlob(j, (byte[])localObject);
        }
        else if ((localObject instanceof Float))
        {
          paramd.bindDouble(j, ((Float)localObject).floatValue());
        }
        else if ((localObject instanceof Double))
        {
          paramd.bindDouble(j, ((Double)localObject).doubleValue());
        }
        else if ((localObject instanceof Long))
        {
          paramd.bindLong(j, ((Long)localObject).longValue());
        }
        else if ((localObject instanceof Integer))
        {
          paramd.bindLong(j, ((Integer)localObject).intValue());
        }
        else if ((localObject instanceof Short))
        {
          paramd.bindLong(j, ((Short)localObject).shortValue());
        }
        else if ((localObject instanceof Byte))
        {
          paramd.bindLong(j, ((Byte)localObject).byteValue());
        }
        else if ((localObject instanceof String))
        {
          paramd.bindString(j, (String)localObject);
        }
        else if ((localObject instanceof Boolean))
        {
          long l;
          if (((Boolean)localObject).booleanValue()) {
            l = 1L;
          } else {
            l = 0L;
          }
          paramd.bindLong(j, l);
        }
        else
        {
          paramd = new StringBuilder();
          paramd.append("Cannot bind ");
          paramd.append(localObject);
          paramd.append(" at index ");
          paramd.append(j);
          paramd.append(" Supported types: null, byte[], float, double, long, int, short, byte,");
          paramd.append(" string");
          throw new IllegalArgumentException(paramd.toString());
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.w.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */