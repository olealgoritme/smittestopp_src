package e.c.a.b.j;

import android.widget.ImageButton;

public class f
  extends ImageButton
{
  public int x;
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    super.setVisibility(paramInt);
    if (paramBoolean) {
      x = paramInt;
    }
  }
  
  public final int getUserSetVisibility()
  {
    return x;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    x = paramInt;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.j.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */