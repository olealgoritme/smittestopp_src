package d.u;

import android.annotation.SuppressLint;
import android.content.Context;
import d.w.a.c;
import d.w.a.c.a;
import d.w.a.c.b;
import d.w.a.c.c;
import d.w.a.f.d;
import j.b.a.u;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import no.simula.corona.MeasurementDatabase_Impl;

public class g$a<T extends g>
{
  public final Class<T> a;
  public final String b;
  public final Context c;
  public Executor d;
  public Executor e;
  public c.c f;
  public boolean g;
  public g.c h;
  public boolean i;
  public boolean j;
  public final g.d k;
  
  public g$a(Context paramContext, Class<T> paramClass, String paramString)
  {
    c = paramContext;
    a = paramClass;
    b = paramString;
    h = g.c.AUTOMATIC;
    i = true;
    k = new g.d();
  }
  
  @SuppressLint({"RestrictedApi"})
  public T a()
  {
    if (c != null)
    {
      if (a != null)
      {
        if ((d == null) && (e == null))
        {
          localObject1 = d.c.a.a.a.d;
          e = ((Executor)localObject1);
          d = ((Executor)localObject1);
        }
        else
        {
          localObject1 = d;
          if ((localObject1 != null) && (e == null))
          {
            e = ((Executor)localObject1);
          }
          else if (d == null)
          {
            localObject1 = e;
            if (localObject1 != null) {
              d = ((Executor)localObject1);
            }
          }
        }
        if (f == null) {
          f = new d();
        }
        Object localObject1 = c;
        a locala = new a((Context)localObject1, b, f, k, null, g, h.resolve((Context)localObject1), d, e, false, i, j, null, null, null);
        Object localObject2 = a;
        Object localObject3 = ((Class)localObject2).getPackage().getName();
        localObject1 = ((Class)localObject2).getCanonicalName();
        boolean bool1 = ((String)localObject3).isEmpty();
        boolean bool2 = true;
        if (!bool1) {
          localObject1 = ((String)localObject1).substring(((String)localObject3).length() + 1);
        }
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((String)localObject1).replace('.', '_'));
        ((StringBuilder)localObject4).append("_Impl");
        localObject4 = ((StringBuilder)localObject4).toString();
        try
        {
          if (((String)localObject3).isEmpty())
          {
            localObject1 = localObject4;
          }
          else
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            ((StringBuilder)localObject1).append((String)localObject3);
            ((StringBuilder)localObject1).append(".");
            ((StringBuilder)localObject1).append((String)localObject4);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject1 = Class.forName((String)localObject1).newInstance();
          localObject1 = (g)localObject1;
          if (localObject1 != null)
          {
            localObject2 = new h(locala, new u((MeasurementDatabase_Impl)localObject1, 7), "8260d2f713a01361d6ce911d0c7159cc", "d0c844f687e96ba35d4d3a97249d2973");
            localObject3 = b;
            localObject4 = c;
            if (localObject3 != null)
            {
              localObject4 = new c.b((Context)localObject3, (String)localObject4, (c.a)localObject2);
              localObject4 = a.a((c.b)localObject4);
              c = ((c)localObject4);
              if ((localObject4 instanceof j)) {
                f = locala;
              }
              if (g != g.c.WRITE_AHEAD_LOGGING) {
                bool2 = false;
              }
              c.a(bool2);
              g = e;
              b = h;
              new ArrayDeque();
              e = f;
              f = bool2;
              if (j)
              {
                localObject4 = d;
                new f(b, c, (e)localObject4, d.b);
              }
              return (T)localObject1;
            }
            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
          }
          throw null;
        }
        catch (InstantiationException localInstantiationException)
        {
          StringBuilder localStringBuilder1 = e.a.a.a.a.a("Failed to create an instance of ");
          localStringBuilder1.append(((Class)localObject2).getCanonicalName());
          throw new RuntimeException(localStringBuilder1.toString());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          StringBuilder localStringBuilder2 = e.a.a.a.a.a("Cannot access the constructor");
          localStringBuilder2.append(((Class)localObject2).getCanonicalName());
          throw new RuntimeException(localStringBuilder2.toString());
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          StringBuilder localStringBuilder3 = e.a.a.a.a.a("cannot find implementation for ");
          localStringBuilder3.append(((Class)localObject2).getCanonicalName());
          localStringBuilder3.append(". ");
          localStringBuilder3.append((String)localObject4);
          localStringBuilder3.append(" does not exist");
          throw new RuntimeException(localStringBuilder3.toString());
        }
      }
      throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
    }
    throw new IllegalArgumentException("Cannot provide null context for the database.");
  }
}

/* Location:
 * Qualified Name:     base.d.u.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */