package d.j.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c
  extends a
{
  public int F;
  public int G;
  public LayoutInflater H;
  
  @Deprecated
  public c(Context paramContext, int paramInt, Cursor paramCursor, boolean paramBoolean)
  {
    super(paramContext, paramCursor, paramBoolean);
    G = paramInt;
    F = paramInt;
    H = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return H.inflate(F, paramViewGroup, false);
  }
}

/* Location:
 * Qualified Name:     base.d.j.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */