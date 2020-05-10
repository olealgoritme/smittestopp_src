package d.t.a;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.p;
import d.i.i.a;
import d.i.i.x.d;

public class u
  extends a
{
  public final RecyclerView d;
  public final a e;
  
  public u(RecyclerView paramRecyclerView)
  {
    d = paramRecyclerView;
    e = new a(this);
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!a()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().a(paramAccessibilityEvent);
      }
    }
  }
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
    paramView = RecyclerView.class.getName();
    a.setClassName(paramView);
    if ((!a()) && (d.getLayoutManager() != null))
    {
      RecyclerView.LayoutManager localLayoutManager = d.getLayoutManager();
      RecyclerView localRecyclerView = b;
      RecyclerView.p localp = y;
      paramView = C0;
      if ((localRecyclerView.canScrollVertically(-1)) || (b.canScrollHorizontally(-1)))
      {
        a.addAction(8192);
        a.setScrollable(true);
      }
      if ((b.canScrollVertically(1)) || (b.canScrollHorizontally(1)))
      {
        a.addAction(4096);
        a.setScrollable(true);
      }
      paramView = AccessibilityNodeInfo.CollectionInfo.obtain(localLayoutManager.b(localp, paramView), localLayoutManager.a(localp, paramView), false, 0);
      a.setCollectionInfo(paramView);
    }
  }
  
  public boolean a()
  {
    return d.i();
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool1 = super.a(paramView, paramInt, paramBundle);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    if ((!a()) && (d.getLayoutManager() != null))
    {
      paramView = d.getLayoutManager();
      RecyclerView localRecyclerView = b;
      paramBundle = y;
      int j;
      if (paramInt != 4096)
      {
        if (paramInt != 8192)
        {
          i = 0;
          paramInt = 0;
          break label210;
        }
        if (localRecyclerView.canScrollVertically(-1)) {
          paramInt = -(p - paramView.i() - paramView.f());
        } else {
          paramInt = 0;
        }
        j = paramInt;
        if (b.canScrollHorizontally(-1))
        {
          i = -(o - paramView.g() - paramView.h());
          break label210;
        }
      }
      else
      {
        if (localRecyclerView.canScrollVertically(1)) {
          paramInt = p - paramView.i() - paramView.f();
        } else {
          paramInt = 0;
        }
        j = paramInt;
        if (b.canScrollHorizontally(1))
        {
          i = o - paramView.g() - paramView.h();
          break label210;
        }
      }
      int i = 0;
      paramInt = j;
      label210:
      if ((paramInt == 0) && (i == 0)) {
        bool2 = false;
      } else {
        b.c(i, paramInt);
      }
      return bool2;
    }
    return false;
  }
  
  public static class a
    extends a
  {
    public final u d;
    
    public a(u paramu)
    {
      d = paramu;
    }
    
    public void a(View paramView, d paramd)
    {
      a.onInitializeAccessibilityNodeInfo(paramView, a);
      if ((!d.a()) && (d.d.getLayoutManager() != null)) {
        d.d.getLayoutManager().a(paramView, paramd);
      }
    }
    
    public boolean a(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.a(paramView, paramInt, paramBundle)) {
        return true;
      }
      if ((!d.a()) && (d.d.getLayoutManager() != null)) {
        paramView = d.d.getLayoutManager().b.y;
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     d.t.a.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */