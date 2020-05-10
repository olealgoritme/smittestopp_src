package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.core.widget.NestedScrollView;
import d.b.a.r;
import java.lang.ref.WeakReference;

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
  public final View.OnClickListener S = new a();
  public final Context a;
  public final r b;
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
  
  public AlertController(Context paramContext, r paramr, Window paramWindow)
  {
    a = paramContext;
    b = paramr;
    c = paramWindow;
    R = new c(paramr);
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
    paramr.a(1);
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
  
  public static class RecycleListView
    extends ListView
  {
    public final int x;
    public final int y;
    
    public RecycleListView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecycleListView);
      y = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
      x = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
    }
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      Object localObject = AlertController.this;
      if (paramView == o)
      {
        localObject = q;
        if (localObject != null)
        {
          paramView = Message.obtain((Message)localObject);
          break label92;
        }
      }
      localObject = AlertController.this;
      if (paramView == s)
      {
        localObject = u;
        if (localObject != null)
        {
          paramView = Message.obtain((Message)localObject);
          break label92;
        }
      }
      localObject = AlertController.this;
      if (paramView == w)
      {
        paramView = y;
        if (paramView != null)
        {
          paramView = Message.obtain(paramView);
          break label92;
        }
      }
      paramView = null;
      label92:
      if (paramView != null) {
        paramView.sendToTarget();
      }
      paramView = AlertController.this;
      R.obtainMessage(1, b).sendToTarget();
    }
  }
  
  public static class b
  {
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public boolean h;
    public DialogInterface.OnKeyListener i;
    public ListAdapter j;
    public DialogInterface.OnClickListener k;
    public boolean l = false;
    public boolean m;
    public int n = -1;
    
    public b(Context paramContext)
    {
      a = paramContext;
      h = true;
      b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
  }
  
  public static final class c
    extends Handler
  {
    public WeakReference<DialogInterface> a;
    
    public c(DialogInterface paramDialogInterface)
    {
      a = new WeakReference(paramDialogInterface);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = what;
      if ((i != -3) && (i != -2) && (i != -1))
      {
        if (i == 1) {
          ((DialogInterface)obj).dismiss();
        }
      }
      else {
        ((DialogInterface.OnClickListener)obj).onClick((DialogInterface)a.get(), what);
      }
    }
  }
  
  public static class d
    extends ArrayAdapter<CharSequence>
  {
    public d(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt1, paramInt2, paramArrayOfCharSequence);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.app.AlertController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */