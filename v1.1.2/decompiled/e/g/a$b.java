package e.g;

import android.annotation.TargetApi;
import android.content.SharedPreferences.Editor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a$b
  implements SharedPreferences.Editor
{
  public SharedPreferences.Editor a;
  
  @TargetApi(9)
  public void apply()
  {
    a.apply();
  }
  
  public SharedPreferences.Editor clear()
  {
    a.clear();
    return this;
  }
  
  public boolean commit()
  {
    return a.commit();
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    a.putString(a.b(paramString), a.a(b, Boolean.toString(paramBoolean)));
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    a.putString(a.b(paramString), a.a(b, Float.toString(paramFloat)));
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    a.putString(a.b(paramString), a.a(b, Integer.toString(paramInt)));
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    a.putString(a.b(paramString), a.a(b, Long.toString(paramLong)));
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    a.putString(a.b(paramString1), a.a(b, paramString2));
    return this;
  }
  
  @TargetApi(11)
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      localHashSet.add(a.a(b, str));
    }
    a.putStringSet(a.b(paramString), localHashSet);
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    a.remove(a.b(paramString));
    return this;
  }
}

/* Location:
 * Qualified Name:     e.g.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */