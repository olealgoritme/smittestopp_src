package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.core.widget.NestedScrollView;
import d.b.a.q;

public class AlertController
{
  public NestedScrollView A;
  public int B = 0;
  public Drawable C;
  public ImageView D;
  public TextView E;
  public TextView F;
  public View G;
  public ListAdapter H;
  public int I = -1;
  public int J;
  public int K;
  public int L;
  public int M;
  public int N;
  public int O;
  public boolean P;
  public int Q = 0;
  public Handler R;
  public final View.OnClickListener S = new AlertController.a(this);
  public final Context a;
  public final q b;
  public final Window c;
  public final int d;
  public CharSequence e;
  public CharSequence f;
  public ListView g;
  public View h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public boolean n = false;
  public Button o;
  public CharSequence p;
  public Message q;
  public Drawable r;
  public Button s;
  public CharSequence t;
  public Message u;
  public Drawable v;
  public Button w;
  public CharSequence x;
  public Message y;
  public Drawable z;
  
  public AlertController(Context paramContext, q paramq, Window paramWindow)
  {
    a = paramContext;
    b = paramq;
    c = paramWindow;
    R = new AlertController.c(paramq);
    paramContext = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    J = paramContext.getResourceId(R.styleable.AlertDialog_android_layout, 0);
    K = paramContext.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
    L = paramContext.getResourceId(R.styleable.AlertDialog_listLayout, 0);
    M = paramContext.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
    N = paramContext.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
    O = paramContext.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
    P = paramContext.getBoolean(R.styleable.AlertDialog_showTitle, true);
    d = paramContext.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
    paramContext.recycle();
    paramq.a(1);
  }
  
  public static void a(View paramView1, View paramView2, View paramView3)
  {
    int i1 = 0;
    int i2;
    if (paramView2 != null)
    {
      if (paramView1.canScrollVertically(-1)) {
        i2 = 0;
      } else {
        i2 = 4;
      }
      paramView2.setVisibility(i2);
    }
    if (paramView3 != null)
    {
      if (paramView1.canScrollVertically(1)) {
        i2 = i1;
      } else {
        i2 = 4;
      }
      paramView3.setVisibility(i2);
    }
  }
  
  public static boolean a(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i1 = paramView.getChildCount();
    while (i1 > 0)
    {
      int i2 = i1 - 1;
      i1 = i2;
      if (a(paramView.getChildAt(i2))) {
        return true;
      }
    }
    return false;
  }
  
  public final ViewGroup a(View paramView1, View paramView2)
  {
    if (paramView1 == null)
    {
      paramView1 = paramView2;
      if ((paramView2 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView2).inflate();
      }
      return (ViewGroup)paramView1;
    }
    if (paramView2 != null)
    {
      ViewParent localViewParent = paramView2.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView2);
      }
    }
    paramView2 = paramView1;
    if ((paramView1 instanceof ViewStub)) {
      paramView2 = ((ViewStub)paramView1).inflate();
    }
    return (ViewGroup)paramView2;
  }
  
  public void a(int paramInt)
  {
    C = null;
    B = paramInt;
    ImageView localImageView = D;
    if (localImageView != null) {
      if (paramInt != 0)
      {
        localImageView.setVisibility(0);
        D.setImageResource(B);
      }
      else
      {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public final void a(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    gravity = 1;
    weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.app.AlertController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */