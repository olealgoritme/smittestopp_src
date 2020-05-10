package j.a.b.m;

public class g
  implements n<short[]>
{
  public g(l paraml) {}
  
  public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
  {
    paramObject = (short[])paramObject;
    if (paramg != null)
    {
      paramAppendable.append('[');
      int i = paramObject.length;
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j >= i)
        {
          paramAppendable.append(']');
          return;
        }
        short s = paramObject[j];
        if (k != 0) {
          paramAppendable.append(',');
        } else {
          k = 1;
        }
        paramAppendable.append(Short.toString(s));
        j++;
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     j.a.b.m.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */