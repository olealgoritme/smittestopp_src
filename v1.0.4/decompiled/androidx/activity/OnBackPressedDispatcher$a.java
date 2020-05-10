package androidx.activity;

import d.a.a;
import d.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class OnBackPressedDispatcher$a
  implements a
{
  public final b x;
  
  public OnBackPressedDispatcher$a(OnBackPressedDispatcher paramOnBackPressedDispatcher, b paramb)
  {
    x = paramb;
  }
  
  public void cancel()
  {
    y.b.remove(x);
    x.b.remove(this);
  }
}

/* Location:
 * Qualified Name:     base.androidx.activity.OnBackPressedDispatcher.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */