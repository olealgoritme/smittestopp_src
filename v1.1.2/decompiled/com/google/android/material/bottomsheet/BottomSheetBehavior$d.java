package com.google.android.material.bottomsheet;

import android.view.View;
import d.i.i.n;
import d.k.b.a;

public class BottomSheetBehavior$d
  implements Runnable
{
  public final View x;
  public final int y;
  
  public BottomSheetBehavior$d(BottomSheetBehavior paramBottomSheetBehavior, View paramView, int paramInt)
  {
    x = paramView;
    y = paramInt;
  }
  
  public void run()
  {
    a locala = z.m;
    if ((locala != null) && (locala.a(true))) {
      n.a(x, this);
    } else {
      z.c(y);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */