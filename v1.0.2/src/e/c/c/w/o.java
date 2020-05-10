package e.c.c.w;

public final class o
{
  public static final int a;
  
  static
  {
    String str = System.getProperty("java.version");
    int i = 0;
    try
    {
      String[] arrayOfString = str.split("[._]");
      j = Integer.parseInt(arrayOfString[0]);
      k = j;
      if (j == 1)
      {
        k = j;
        if (arrayOfString.length > 1) {
          k = Integer.parseInt(arrayOfString[1]);
        }
      }
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      k = -1;
    }
    int j = k;
    if (k == -1) {
      try
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        for (k = i; k < str.length(); k++)
        {
          char c = str.charAt(k);
          if (!Character.isDigit(c)) {
            break;
          }
          localStringBuilder.append(c);
        }
        j = Integer.parseInt(localStringBuilder.toString());
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        j = -1;
      }
    }
    int k = j;
    if (j == -1) {
      k = 6;
    }
    a = k;
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */