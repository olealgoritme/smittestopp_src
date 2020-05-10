package k.b.a.l2;

import e.a.a.a.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import k.b.a.d;
import k.b.a.d0;
import k.b.a.j;
import k.b.a.n;
import k.b.a.t;
import k.b.j.f;

public class v
  extends n
  implements d
{
  public t x;
  
  public v(t paramt)
  {
    if ((!(paramt instanceof d0)) && (!(paramt instanceof j))) {
      throw new IllegalArgumentException("unknown object passed to Time");
    }
    x = paramt;
  }
  
  public static v a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof v)))
    {
      if ((paramObject instanceof d0)) {
        return new v((d0)paramObject);
      }
      if ((paramObject instanceof j)) {
        return new v((j)paramObject);
      }
      throw new IllegalArgumentException(a.a(paramObject, a.a("unknown object in factory: ")));
    }
    return (v)paramObject;
  }
  
  public t c()
  {
    return x;
  }
  
  public String toString()
  {
    Object localObject1 = x;
    boolean bool = localObject1 instanceof d0;
    Object localObject3 = "GMT+00:00";
    Object localObject4;
    int i;
    int j;
    Object localObject2;
    if (bool)
    {
      localObject4 = f.a(x);
      if ((((String)localObject4).indexOf('-') < 0) && (((String)localObject4).indexOf('+') < 0))
      {
        if (((String)localObject4).length() == 11)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((String)localObject4).substring(0, 10));
          localObject4 = "00GMT+00:00";
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((String)localObject4).substring(0, 12));
          localObject4 = localObject3;
        }
      }
      else
      {
        i = ((String)localObject4).indexOf('-');
        j = i;
        if (i < 0) {
          j = ((String)localObject4).indexOf('+');
        }
        localObject1 = localObject4;
        if (j == ((String)localObject4).length() - 3) {
          localObject1 = a.b((String)localObject4, "00");
        }
        if (j == 10)
        {
          localObject4 = new StringBuilder();
          a.a((String)localObject1, 0, 10, (StringBuilder)localObject4, "00GMT");
          a.a((String)localObject1, 10, 13, (StringBuilder)localObject4, ":");
          localObject3 = ((String)localObject1).substring(13, 15);
          localObject1 = localObject4;
          localObject4 = localObject3;
        }
        else
        {
          localObject3 = new StringBuilder();
          a.a((String)localObject1, 0, 12, (StringBuilder)localObject3, "GMT");
          a.a((String)localObject1, 12, 15, (StringBuilder)localObject3, ":");
          localObject4 = ((String)localObject1).substring(15, 17);
          localObject1 = localObject3;
        }
      }
      ((StringBuilder)localObject1).append((String)localObject4);
      localObject3 = ((StringBuilder)localObject1).toString();
      if (((String)localObject3).charAt(0) < '5')
      {
        localObject4 = new StringBuilder();
        localObject1 = "20";
      }
      else
      {
        localObject4 = new StringBuilder();
        localObject1 = "19";
      }
      localObject1 = a.a((StringBuilder)localObject4, (String)localObject1, (String)localObject3);
    }
    else
    {
      j localj = (j)localObject1;
      localObject1 = f.a(x);
      j = ((String)localObject1).length();
      i = 1;
      if (((String)localObject1).charAt(j - 1) == 'Z')
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((String)localObject1).substring(0, ((String)localObject1).length() - 1));
        ((StringBuilder)localObject4).append("GMT+00:00");
        localObject1 = localObject4;
      }
      else
      {
        int k = ((String)localObject1).length() - 6;
        j = ((String)localObject1).charAt(k);
        if (((j == 45) || (j == 43)) && (((String)localObject1).indexOf("GMT") == k - 3)) {
          return localObject1;
        }
        j = ((String)localObject1).length() - 5;
        k = ((String)localObject1).charAt(j);
        if ((k != 45) && (k != 43))
        {
          k = ((String)localObject1).length() - 3;
          j = ((String)localObject1).charAt(k);
          if ((j != 45) && (j != 43))
          {
            StringBuilder localStringBuilder = a.a((String)localObject1);
            TimeZone localTimeZone = TimeZone.getDefault();
            j = localTimeZone.getRawOffset();
            if (j < 0)
            {
              j = -j;
              localObject4 = "-";
            }
            else
            {
              localObject4 = "+";
            }
            k = j / 3600000;
            int m = (j - k * 60 * 60 * 1000) / 60000;
            j = k;
            try
            {
              if (localTimeZone.useDaylightTime())
              {
                localObject3 = localObject1;
                if (localj.k()) {
                  localObject3 = localj.b((String)localObject1);
                }
                SimpleDateFormat localSimpleDateFormat = localj.j();
                localObject1 = new java/lang/StringBuilder;
                ((StringBuilder)localObject1).<init>();
                ((StringBuilder)localObject1).append((String)localObject3);
                ((StringBuilder)localObject1).append("GMT");
                ((StringBuilder)localObject1).append((String)localObject4);
                ((StringBuilder)localObject1).append(localj.a(k));
                ((StringBuilder)localObject1).append(":");
                ((StringBuilder)localObject1).append(localj.a(m));
                j = k;
                if (localTimeZone.inDaylightTime(localSimpleDateFormat.parse(((StringBuilder)localObject1).toString())))
                {
                  bool = ((String)localObject4).equals("+");
                  if (bool) {
                    j = i;
                  } else {
                    j = -1;
                  }
                  j = k + j;
                }
              }
            }
            catch (ParseException localParseException)
            {
              localParseException.printStackTrace();
              j = k;
            }
            localObject2 = a.a("GMT", (String)localObject4);
            ((StringBuilder)localObject2).append(localj.a(j));
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(localj.a(m));
            localStringBuilder.append(((StringBuilder)localObject2).toString());
            return localStringBuilder.toString();
          }
          localObject3 = new StringBuilder();
          a.a((String)localObject2, 0, k, (StringBuilder)localObject3, "GMT");
          ((StringBuilder)localObject3).append(((String)localObject2).substring(k));
          localObject4 = ":00";
          localObject2 = localObject3;
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((String)localObject2).substring(0, j));
          ((StringBuilder)localObject3).append("GMT");
          i = j + 3;
          a.a((String)localObject2, j, i, (StringBuilder)localObject3, ":");
          localObject4 = ((String)localObject2).substring(i);
          localObject2 = localObject3;
        }
        ((StringBuilder)localObject2).append((String)localObject4);
      }
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */