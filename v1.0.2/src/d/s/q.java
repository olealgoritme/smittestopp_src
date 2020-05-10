package d.s;

import android.annotation.SuppressLint;
import e.a.a.a.a;
import java.util.HashMap;

@SuppressLint({"TypeParameterUnusedInFormals"})
public class q
{
  public static final HashMap<Class<?>, String> b = new HashMap();
  public final HashMap<String, p<? extends i>> a = new HashMap();
  
  public static String a(Class<? extends p> paramClass)
  {
    String str = (String)b.get(paramClass);
    Object localObject = str;
    if (str == null)
    {
      localObject = (p.b)paramClass.getAnnotation(p.b.class);
      if (localObject != null) {
        localObject = ((p.b)localObject).value();
      } else {
        localObject = null;
      }
      if (b((String)localObject))
      {
        b.put(paramClass, localObject);
      }
      else
      {
        localObject = a.a("No @Navigator.Name annotation found for ");
        ((StringBuilder)localObject).append(paramClass.getSimpleName());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    return (String)localObject;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final p<? extends i> a(p<? extends i> paramp)
  {
    String str = a(paramp.getClass());
    if (b(str)) {
      return (p)a.put(str, paramp);
    }
    throw new IllegalArgumentException("navigator name cannot be an empty string");
  }
  
  public <T extends p<?>> T a(String paramString)
  {
    if (b(paramString))
    {
      p localp = (p)a.get(paramString);
      if (localp != null) {
        return localp;
      }
      throw new IllegalStateException(a.a("Could not find Navigator with name \"", paramString, "\". You must call NavController.addNavigator() for each navigation type."));
    }
    throw new IllegalArgumentException("navigator name cannot be an empty string");
  }
}

/* Location:
 * Qualified Name:     base.d.s.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */