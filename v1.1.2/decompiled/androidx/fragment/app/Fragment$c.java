package androidx.fragment.app;

import android.view.View;
import d.m.a.i;

public class Fragment$c
  extends i
{
  public Fragment$c(Fragment paramFragment) {}
  
  public View a(int paramInt)
  {
    Object localObject = a.mView;
    if (localObject != null) {
      return ((View)localObject).findViewById(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" does not have a view");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public boolean a()
  {
    boolean bool;
    if (a.mView != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     androidx.fragment.app.Fragment.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */