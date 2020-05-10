package d.t.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

public abstract class r
{
  public final RecyclerView.LayoutManager a;
  public int b;
  public final Rect c;
  
  public static r a(RecyclerView.LayoutManager paramLayoutManager, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return new q(paramLayoutManager);
      }
      throw new IllegalArgumentException("invalid orientation");
    }
    return new p(paramLayoutManager);
  }
  
  public abstract int a();
  
  public abstract int a(View paramView);
  
  public abstract int b();
  
  public abstract int b(View paramView);
  
  public abstract int c();
}

/* Location:
 * Qualified Name:     d.t.a.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */