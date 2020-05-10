package e.c.a.b.e;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.b;
import d.b.a.q;
import d.i.i.n;
import java.lang.ref.WeakReference;

public class b
  extends q
{
  public boolean A = true;
  public boolean B = true;
  public boolean C;
  public BottomSheetBehavior.b D = new b.d(this);
  public BottomSheetBehavior<FrameLayout> z;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    a(1);
  }
  
  public final View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = (FrameLayout)View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localFrameLayout.findViewById(R.id.coordinator);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)localCoordinatorLayout.findViewById(R.id.design_bottom_sheet);
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof CoordinatorLayout.f))
    {
      localObject = a;
      if ((localObject instanceof BottomSheetBehavior))
      {
        localObject = (BottomSheetBehavior)localObject;
        z = ((BottomSheetBehavior)localObject);
        t = D;
        j = A;
        if (paramLayoutParams == null) {
          paramView.addView(localView);
        } else {
          paramView.addView(localView, paramLayoutParams);
        }
        localCoordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new b.a(this));
        n.a(paramView, new b.b(this));
        paramView.setOnTouchListener(new b.c(this));
        return localFrameLayout;
      }
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.clearFlags(67108864);
      paramBundle.addFlags(Integer.MIN_VALUE);
      paramBundle.setLayout(-1, -1);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    BottomSheetBehavior localBottomSheetBehavior = z;
    if (localBottomSheetBehavior != null)
    {
      int i = l;
      if ((i == 5) && (4 != i))
      {
        Object localObject = r;
        if (localObject == null)
        {
          l = 4;
        }
        else
        {
          View localView = (View)((WeakReference)localObject).get();
          if (localView != null)
          {
            localObject = localView.getParent();
            if ((localObject != null) && (((ViewParent)localObject).isLayoutRequested()) && (n.s(localView))) {
              localView.post(new a(localBottomSheetBehavior, localView, 4));
            } else {
              localBottomSheetBehavior.a(localView, 4);
            }
          }
        }
      }
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (A != paramBoolean)
    {
      A = paramBoolean;
      BottomSheetBehavior localBottomSheetBehavior = z;
      if (localBottomSheetBehavior != null) {
        j = paramBoolean;
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!A)) {
      A = true;
    }
    B = paramBoolean;
    C = true;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(a(paramInt, null, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(a(0, paramView, null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(a(0, paramView, paramLayoutParams));
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */