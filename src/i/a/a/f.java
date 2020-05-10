package i.a.a;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;

public class f
{
  public static TreeMap<String, Integer> a = new TreeMap(new f.a());
  public static TreeMap<String, Integer> b = new TreeMap(new f.a());
  public static HashSet<String> c = new HashSet();
  public static TreeMap<String, TimeZone> d = new TreeMap();
  
  static
  {
    c.add("MEZ");
    c.add("Uhr");
    c.add("h");
    c.add("pm");
    c.add("PM");
    c.add("AM");
    c.add("o'clock");
    Object localObject1 = TimeZone.getAvailableIDs();
    int i = localObject1.length;
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        arrayOfLocale = DateFormatSymbols.getAvailableLocales();
        int k = arrayOfLocale.length;
        j = 0;
        if (j >= k) {
          return;
        }
        localObject1 = arrayOfLocale[j];
        String[] arrayOfString;
        if ((!"ja".equals(((Locale)localObject1).getLanguage())) && (!"ko".equals(((Locale)localObject1).getLanguage())) && (!"zh".equals(((Locale)localObject1).getLanguage())))
        {
          localObject1 = DateFormatSymbols.getInstance((Locale)localObject1);
          arrayOfString = ((DateFormatSymbols)localObject1).getMonths();
        }
        for (i = 0;; i++)
        {
          if (i >= arrayOfString.length)
          {
            arrayOfString = ((DateFormatSymbols)localObject1).getShortMonths();
            for (i = 0;; i++)
            {
              if (i >= arrayOfString.length)
              {
                localObject2 = ((DateFormatSymbols)localObject1).getWeekdays();
                for (i = 0;; i++)
                {
                  if (i >= localObject2.length)
                  {
                    localObject1 = ((DateFormatSymbols)localObject1).getShortWeekdays();
                    for (i = 0;; i++)
                    {
                      if (i >= localObject1.length)
                      {
                        j++;
                        break;
                      }
                      arrayOfString = localObject1[i];
                      if (arrayOfString.length() != 0)
                      {
                        a(b, arrayOfString, Integer.valueOf(i));
                        a(b, arrayOfString.replace(".", ""), Integer.valueOf(i));
                      }
                    }
                  }
                  arrayOfString = localObject2[i];
                  if (arrayOfString.length() != 0)
                  {
                    a(b, arrayOfString, Integer.valueOf(i));
                    a(b, arrayOfString.replace(".", ""), Integer.valueOf(i));
                  }
                }
              }
              Object localObject2 = arrayOfString[i];
              if ((((String)localObject2).length() != 0) && (!Character.isDigit(((String)localObject2).charAt(((String)localObject2).length() - 1))))
              {
                a(a, arrayOfString[i], Integer.valueOf(i));
                a(a, arrayOfString[i].replace(".", ""), Integer.valueOf(i));
              }
            }
          }
          if (arrayOfString[i].length() != 0) {
            a(a, arrayOfString[i], Integer.valueOf(i));
          }
        }
      }
      Locale[] arrayOfLocale = localObject1[j];
      d.put(arrayOfLocale, TimeZone.getTimeZone(arrayOfLocale));
    }
  }
  
  public static int a(String paramString)
  {
    int i = Integer.parseInt(paramString);
    int j = i;
    if (i < 100) {
      if (i > 23) {
        j = i + 2000;
      } else {
        j = i + 1900;
      }
    }
    return j;
  }
  
  public static String a(StringTokenizer paramStringTokenizer, String paramString, Calendar paramCalendar)
  {
    for (;;)
    {
      TimeZone localTimeZone = (TimeZone)d.get(paramString);
      if (localTimeZone != null)
      {
        paramCalendar.setTimeZone(localTimeZone);
        if (!paramStringTokenizer.hasMoreTokens()) {
          return null;
        }
        paramString = paramStringTokenizer.nextToken();
      }
      else
      {
        if (!c.contains(paramString)) {
          break;
        }
        if (paramString.equalsIgnoreCase("pm")) {
          paramCalendar.add(9, 1);
        }
        if (paramString.equalsIgnoreCase("am")) {
          paramCalendar.add(9, 0);
        }
        if (!paramStringTokenizer.hasMoreTokens()) {
          return null;
        }
        paramString = paramStringTokenizer.nextToken();
      }
    }
    return paramString;
  }
  
  public static Date a(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Date)) {
      return (Date)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return new Date(((Number)paramObject).longValue());
    }
    if ((paramObject instanceof String))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer((String)paramObject, " -/:,.+");
      if (!localStringTokenizer.hasMoreTokens()) {
        return null;
      }
      Object localObject3 = localStringTokenizer.nextToken();
      if ((((String)localObject3).length() == 4) && (Character.isDigit(((String)localObject3).charAt(0))))
      {
        paramObject = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
        ((GregorianCalendar)paramObject).setTimeInMillis(0L);
        ((GregorianCalendar)paramObject).set(1, Integer.parseInt((String)localObject3));
        if (!localStringTokenizer.hasMoreTokens())
        {
          paramObject = ((GregorianCalendar)paramObject).getTime();
        }
        else
        {
          ((GregorianCalendar)paramObject).set(2, b(localStringTokenizer.nextToken()).intValue());
          if (!localStringTokenizer.hasMoreTokens())
          {
            paramObject = ((GregorianCalendar)paramObject).getTime();
          }
          else
          {
            localObject2 = localStringTokenizer.nextToken();
            if (Character.isDigit(((String)localObject2).charAt(0)))
            {
              if ((((String)localObject2).length() == 5) && (((String)localObject2).charAt(2) == 'T'))
              {
                ((GregorianCalendar)paramObject).set(5, Integer.parseInt(((String)localObject2).substring(0, 2)));
                paramObject = a(localStringTokenizer, (Calendar)paramObject, ((String)localObject2).substring(3));
              }
              else
              {
                ((GregorianCalendar)paramObject).set(5, Integer.parseInt((String)localObject2));
                paramObject = a(localStringTokenizer, (Calendar)paramObject, null);
              }
            }
            else {
              paramObject = ((GregorianCalendar)paramObject).getTime();
            }
          }
        }
        return (Date)paramObject;
      }
      paramObject = localObject3;
      if (b.containsKey(localObject3))
      {
        if (!localStringTokenizer.hasMoreTokens()) {
          return null;
        }
        paramObject = localStringTokenizer.nextToken();
      }
      if (a.containsKey(paramObject))
      {
        localObject3 = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
        localObject1 = (Integer)a.get(paramObject);
        if (localObject1 != null)
        {
          ((GregorianCalendar)localObject3).set(2, ((Integer)localObject1).intValue());
          if (!localStringTokenizer.hasMoreTokens())
          {
            paramObject = localObject2;
          }
          else
          {
            ((GregorianCalendar)localObject3).set(5, Integer.parseInt(localStringTokenizer.nextToken()));
            if (!localStringTokenizer.hasMoreTokens())
            {
              paramObject = localObject2;
            }
            else
            {
              localObject1 = localStringTokenizer.nextToken();
              paramObject = localObject1;
              if (Character.isLetter(((String)localObject1).charAt(0)))
              {
                if (!localStringTokenizer.hasMoreTokens()) {
                  paramObject = localObject2;
                } else {
                  paramObject = localStringTokenizer.nextToken();
                }
              }
              else
              {
                if (((String)paramObject).length() == 4)
                {
                  ((GregorianCalendar)localObject3).set(1, a((String)paramObject));
                }
                else if (((String)paramObject).length() == 2)
                {
                  paramObject = b(localStringTokenizer, (Calendar)localObject3, (String)paramObject);
                  break label465;
                }
                paramObject = a(localStringTokenizer, (Calendar)localObject3, null);
              }
            }
          }
          label465:
          return (Date)paramObject;
        }
        localObject2 = new StringBuilder("can not parse ");
        ((StringBuilder)localObject2).append((String)paramObject);
        ((StringBuilder)localObject2).append(" as month");
        throw new NullPointerException(((StringBuilder)localObject2).toString());
      }
      localObject2 = localObject1;
      if (Character.isDigit(((String)paramObject).charAt(0)))
      {
        localObject2 = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
        ((GregorianCalendar)localObject2).set(5, Integer.parseInt((String)paramObject));
        if (!localStringTokenizer.hasMoreTokens())
        {
          localObject2 = localObject1;
        }
        else
        {
          ((GregorianCalendar)localObject2).set(2, b(localStringTokenizer.nextToken()).intValue());
          if (!localStringTokenizer.hasMoreTokens())
          {
            localObject2 = localObject1;
          }
          else
          {
            ((GregorianCalendar)localObject2).set(1, a(localStringTokenizer.nextToken()));
            localObject2 = a(localStringTokenizer, (Calendar)localObject2, null);
          }
        }
      }
      return (Date)localObject2;
    }
    localObject2 = new StringBuilder("Primitive: Can not convert ");
    ((StringBuilder)localObject2).append(paramObject.getClass().getName());
    ((StringBuilder)localObject2).append(" to int");
    throw new RuntimeException(((StringBuilder)localObject2).toString());
  }
  
  public static Date a(StringTokenizer paramStringTokenizer, Calendar paramCalendar, String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      if (!paramStringTokenizer.hasMoreTokens()) {
        return paramCalendar.getTime();
      }
      str = paramStringTokenizer.nextToken();
    }
    return b(paramStringTokenizer, paramCalendar, str);
  }
  
  public static void a(TreeMap<String, Integer> paramTreeMap, String paramString, Integer paramInteger)
  {
    paramTreeMap.put(paramString, paramInteger);
    paramTreeMap.put(paramString.replace("é", "e").replace("û", "u"), paramInteger);
  }
  
  public static Integer b(String paramString)
  {
    if (Character.isDigit(paramString.charAt(0))) {
      return Integer.valueOf(Integer.parseInt(paramString) - 1);
    }
    Object localObject = (Integer)a.get(paramString);
    if (localObject != null) {
      return Integer.valueOf(((Integer)localObject).intValue());
    }
    localObject = new StringBuilder("can not parse ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" as month");
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  public static Date b(StringTokenizer paramStringTokenizer, Calendar paramCalendar, String paramString)
  {
    paramCalendar.set(11, Integer.parseInt(paramString));
    if (!paramStringTokenizer.hasMoreTokens()) {
      return paramCalendar.getTime();
    }
    paramString = a(paramStringTokenizer, paramStringTokenizer.nextToken(), paramCalendar);
    if (paramString == null) {
      return paramCalendar.getTime();
    }
    paramCalendar.set(12, Integer.parseInt(paramString));
    if (!paramStringTokenizer.hasMoreTokens()) {
      return paramCalendar.getTime();
    }
    paramString = a(paramStringTokenizer, paramStringTokenizer.nextToken(), paramCalendar);
    if (paramString == null) {
      return paramCalendar.getTime();
    }
    paramCalendar.set(13, Integer.parseInt(paramString));
    if (!paramStringTokenizer.hasMoreTokens()) {
      return paramCalendar.getTime();
    }
    paramString = a(paramStringTokenizer, paramStringTokenizer.nextToken(), paramCalendar);
    if (paramString == null) {
      return paramCalendar.getTime();
    }
    paramStringTokenizer = a(paramStringTokenizer, paramString, paramCalendar);
    if ((paramStringTokenizer.length() == 4) && (Character.isDigit(paramStringTokenizer.charAt(0)))) {
      paramCalendar.set(1, a(paramStringTokenizer));
    }
    return paramCalendar.getTime();
  }
}

/* Location:
 * Qualified Name:     base.i.a.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */