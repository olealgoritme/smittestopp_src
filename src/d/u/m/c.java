package d.u.m;

public class c
{
  public static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      paramStringBuilder.append("?");
      if (i < paramInt - 1) {
        paramStringBuilder.append(",");
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.u.m.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */