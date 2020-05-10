package e.c.a.b.e;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.b;
import d.b.a.r;
import d.i.i.n;
import d.i.i.x.d;
import java.lang.ref.WeakReference;

public class b
  extends r
{
  public boolean A = true;
  public boolean B = true;
  public boolean C;
  public BottomSheetBehavior.b D = new d();
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
        localCoordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new a());
        n.a(paramView, new b());
        paramView.setOnTouchListener(new c());
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
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      paramView = b.this;
      if ((A) && (paramView.isShowing()))
      {
        b localb = b.this;
        if (!C)
        {
          paramView = localb.getContext().obtainStyledAttributes(new int[] { 16843611 });
          B = paramView.getBoolean(0, true);
          paramView.recycle();
          C = true;
        }
        if (B) {
          cancel();
        }
      }
    }
  }
  
  public class b
    extends d.i.i.a
  {
    public b() {}
    
    public void a(View paramView, d paramd)
    {
      a.onInitializeAccessibilityNodeInfo(paramView, a);
      if (A)
      {
        a.addAction(1048576);
        a.setDismissable(true);
      }
      else
      {
        a.setDismissable(false);
      }
    }
    
    public boolean a(View paramView, int paramInt, Bundle paramBundle)
    {
      if (paramInt == 1048576)
      {
        b localb = b.this;
        if (A)
        {
          localb.cancel();
          return true;
        }
      }
      return super.a(paramView, paramInt, paramBundle);
    }
  }
  
  public class c
    implements View.OnTouchListener
  {
    public c() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  public class d
    extends BottomSheetBehavior.b
  {
    public d() {}
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */