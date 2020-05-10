package androidx.appcompat.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

public class SearchView$k
{
  public Method a;
  public Method b;
  public Method c;
  
  public SearchView$k()
  {
    try
    {
      localMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      a = localMethod;
      localMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      try
      {
        localMethod = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        b = localMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          for (;;)
          {
            Method localMethod = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            c = localMethod;
            localMethod.setAccessible(true);
            return;
            localNoSuchMethodException1 = localNoSuchMethodException1;
            continue;
            localNoSuchMethodException2 = localNoSuchMethodException2;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          for (;;) {}
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.SearchView.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */