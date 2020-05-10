package e.c.c.w.z.d;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class a
{
  public static final TimeZone a = TimeZone.getTimeZone("UTC");
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 <= paramString.length()) && (paramInt1 <= paramInt2))
    {
      int i;
      int j;
      StringBuilder localStringBuilder;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1 + 1;
        j = Character.digit(paramString.charAt(paramInt1), 10);
        if (j >= 0)
        {
          j = -j;
        }
        else
        {
          localStringBuilder = e.a.a.a.a.a("Invalid number: ");
          localStringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(localStringBuilder.toString());
        }
      }
      else
      {
        j = 0;
        i = paramInt1;
      }
      while (i < paramInt2)
      {
        int k = Character.digit(paramString.charAt(i), 10);
        if (k >= 0)
        {
          j = j * 10 - k;
          i++;
        }
        else
        {
          localStringBuilder = e.a.a.a.a.a("Invalid number: ");
          localStringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(localStringBuilder.toString());
        }
      }
      return -j;
    }
    throw new NumberFormatException(paramString);
  }
  
  public static Date a(String paramString, ParsePosition paramParsePosition)
  {
    label331:
    label453:
    Object localObject2;
    try
    {
      int i = paramParsePosition.getIndex();
      int j = i + 4;
      int k = a(paramString, i, j);
      i = j;
      if (a(paramString, j, '-')) {
        i = j + 1;
      }
      j = i + 2;
      int m = a(paramString, i, j);
      i = j;
      if (a(paramString, j, '-')) {
        i = j + 1;
      }
      int n = i + 2;
      int i1 = a(paramString, i, n);
      boolean bool = a(paramString, n, 'T');
      if ((!bool) && (paramString.length() <= n))
      {
        localObject1 = new java/util/GregorianCalendar;
        ((GregorianCalendar)localObject1).<init>(k, m - 1, i1);
        paramParsePosition.setIndex(n);
        return ((Calendar)localObject1).getTime();
      }
      if (bool)
      {
        i = n + 1;
        j = i + 2;
        i2 = a(paramString, i, j);
        i = j;
        if (a(paramString, j, ':')) {
          i = j + 1;
        }
        j = i + 2;
        n = a(paramString, i, j);
        i = j;
        if (a(paramString, j, ':')) {
          i = j + 1;
        }
        if (paramString.length() > i)
        {
          j = paramString.charAt(i);
          if ((j != 90) && (j != 43) && (j != 45))
          {
            i3 = i + 2;
            i = a(paramString, i, i3);
            j = i;
            if (i > 59)
            {
              j = i;
              if (i < 63) {
                j = 59;
              }
            }
            if (a(paramString, i3, '.'))
            {
              i4 = i3 + 1;
              for (i = i4 + 1; i < paramString.length(); i++)
              {
                i5 = paramString.charAt(i);
                i3 = i;
                if (i5 < 48) {
                  break label331;
                }
                if (i5 > 57)
                {
                  i3 = i;
                  break label331;
                }
              }
              i3 = paramString.length();
              int i5 = Math.min(i3, i4 + 3);
              i = a(paramString, i4, i5);
              i4 = i5 - i4;
              if (i4 != 1)
              {
                if (i4 == 2) {
                  i *= 10;
                }
              }
              else {
                i *= 100;
              }
              i4 = i2;
              i2 = n;
              n = j;
              break label453;
            }
            i = 0;
            i4 = i2;
            i2 = n;
            n = j;
            break label453;
          }
        }
        i3 = i2;
        j = n;
      }
      else
      {
        i3 = 0;
        j = 0;
        i = n;
      }
      int i2 = 0;
      n = 0;
      int i4 = i3;
      int i3 = i;
      i = i2;
      i2 = j;
      if (paramString.length() > i3)
      {
        char c = paramString.charAt(i3);
        if (c == 'Z')
        {
          localObject1 = a;
          j = i3 + 1;
        }
        else
        {
          if ((c != '+') && (c != '-'))
          {
            localObject2 = new java/lang/IndexOutOfBoundsException;
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            ((StringBuilder)localObject1).append("Invalid time zone indicator '");
            ((StringBuilder)localObject1).append(c);
            ((StringBuilder)localObject1).append("'");
            ((IndexOutOfBoundsException)localObject2).<init>(((StringBuilder)localObject1).toString());
            throw ((Throwable)localObject2);
          }
          localObject1 = paramString.substring(i3);
          if (((String)localObject1).length() < 5)
          {
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("00");
            localObject1 = ((StringBuilder)localObject2).toString();
          }
          j = i3 + ((String)localObject1).length();
          if ((!"+0000".equals(localObject1)) && (!"+00:00".equals(localObject1)))
          {
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            ((StringBuilder)localObject2).append("GMT");
            ((StringBuilder)localObject2).append((String)localObject1);
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject1 = TimeZone.getTimeZone((String)localObject2);
            localObject3 = ((TimeZone)localObject1).getID();
            if ((!((String)localObject3).equals(localObject2)) && (!((String)localObject3).replace(":", "").equals(localObject2)))
            {
              IndexOutOfBoundsException localIndexOutOfBoundsException2 = new java/lang/IndexOutOfBoundsException;
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>();
              ((StringBuilder)localObject3).append("Mismatching time zone indicator: ");
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append(" given, resolves to ");
              ((StringBuilder)localObject3).append(((TimeZone)localObject1).getID());
              localIndexOutOfBoundsException2.<init>(((StringBuilder)localObject3).toString());
              throw localIndexOutOfBoundsException2;
            }
          }
          else
          {
            localObject1 = a;
          }
        }
        localObject2 = new java/util/GregorianCalendar;
        ((GregorianCalendar)localObject2).<init>((TimeZone)localObject1);
        ((Calendar)localObject2).setLenient(false);
        ((Calendar)localObject2).set(1, k);
        ((Calendar)localObject2).set(2, m - 1);
        ((Calendar)localObject2).set(5, i1);
        ((Calendar)localObject2).set(11, i4);
        ((Calendar)localObject2).set(12, i2);
        ((Calendar)localObject2).set(13, n);
        ((Calendar)localObject2).set(14, i);
        paramParsePosition.setIndex(j);
        return ((Calendar)localObject2).getTime();
      }
      Object localObject1 = new java/lang/IllegalArgumentException;
      ((IllegalArgumentException)localObject1).<init>("No time zone indicator");
      throw ((Throwable)localObject1);
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}catch (NumberFormatException localNumberFormatException) {}catch (IndexOutOfBoundsException localIndexOutOfBoundsException1) {}
    if (paramString == null)
    {
      paramString = null;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append('"');
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append('"');
      paramString = ((StringBuilder)localObject2).toString();
    }
    Object localObject3 = localIndexOutOfBoundsException1.getMessage();
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (!((String)localObject3).isEmpty()) {}
    }
    else
    {
      localObject2 = e.a.a.a.a.a("(");
      ((StringBuilder)localObject2).append(localIndexOutOfBoundsException1.getClass().getName());
      ((StringBuilder)localObject2).append(")");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Failed to parse date [");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("]: ");
    ((StringBuilder)localObject3).append((String)localObject2);
    paramString = new ParseException(((StringBuilder)localObject3).toString(), paramParsePosition.getIndex());
    paramString.initCause(localIndexOutOfBoundsException1);
    throw paramString;
  }
  
  public static boolean a(String paramString, int paramInt, char paramChar)
  {
    boolean bool;
    if ((paramInt < paramString.length()) && (paramString.charAt(paramInt) == paramChar)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.z.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */