package d.b.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController.RecycleListView;
import androidx.core.widget.NestedScrollView;

import d.b.e.i0.a;
import d.i.i.n;

public class g
  extends q
  implements DialogInterface
{
  public final AlertController z = new AlertController(getContext(), this, getWindow());
  
  public g(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) >= 1) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogTheme, localTypedValue, true);
    return resourceId;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertController localAlertController = z;
    int i = K;
    if (i == 0) {
      i = J;
    } else if (Q != 1) {
      i = J;
    }
    b.setContentView(i);
    paramBundle = c.findViewById(R.id.parentPanel);
    Object localObject1 = paramBundle.findViewById(R.id.topPanel);
    Object localObject2 = paramBundle.findViewById(R.id.contentPanel);
    Object localObject3 = paramBundle.findViewById(R.id.buttonPanel);
    Object localObject4 = (ViewGroup)paramBundle.findViewById(R.id.customPanel);
    paramBundle = h;
    Object localObject5 = null;
    int j = 0;
    if (paramBundle == null) {
      if (i != 0) {
        paramBundle = LayoutInflater.from(a).inflate(i, (ViewGroup)localObject4, false);
      } else {
        paramBundle = null;
      }
    }
    if (paramBundle != null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) || (!AlertController.a(paramBundle))) {
      c.setFlags(131072, 131072);
    }
    if (i != 0)
    {
      localObject6 = (FrameLayout)c.findViewById(R.id.custom);
      ((FrameLayout)localObject6).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (n) {
        ((FrameLayout)localObject6).setPadding(j, k, l, m);
      }
      if (g != null) {
        getLayoutParamsa = 0.0F;
      }
    }
    else
    {
      ((ViewGroup)localObject4).setVisibility(8);
    }
    paramBundle = ((ViewGroup)localObject4).findViewById(R.id.topPanel);
    View localView = ((ViewGroup)localObject4).findViewById(R.id.contentPanel);
    Object localObject6 = ((ViewGroup)localObject4).findViewById(R.id.buttonPanel);
    paramBundle = localAlertController.a(paramBundle, (View)localObject1);
    localObject2 = localAlertController.a(localView, (View)localObject2);
    localObject3 = localAlertController.a((View)localObject6, (View)localObject3);
    localObject1 = (NestedScrollView)c.findViewById(R.id.scrollView);
    A = ((NestedScrollView)localObject1);
    ((FrameLayout)localObject1).setFocusable(false);
    A.setNestedScrollingEnabled(false);
    localObject1 = (TextView)((ViewGroup)localObject2).findViewById(16908299);
    F = ((TextView)localObject1);
    if (localObject1 != null)
    {
      localObject6 = f;
      if (localObject6 != null)
      {
        ((TextView)localObject1).setText((CharSequence)localObject6);
      }
      else
      {
        ((TextView)localObject1).setVisibility(8);
        A.removeView(F);
        if (g != null)
        {
          localObject1 = (ViewGroup)A.getParent();
          i = ((ViewGroup)localObject1).indexOfChild(A);
          ((ViewGroup)localObject1).removeViewAt(i);
          ((ViewGroup)localObject1).addView(g, i, new ViewGroup.LayoutParams(-1, -1));
        }
        else
        {
          ((ViewGroup)localObject2).setVisibility(8);
        }
      }
    }
    localObject1 = (Button)((ViewGroup)localObject3).findViewById(16908313);
    o = ((Button)localObject1);
    ((Button)localObject1).setOnClickListener(S);
    if ((TextUtils.isEmpty(p)) && (r == null))
    {
      o.setVisibility(8);
      i = 0;
    }
    else
    {
      o.setText(p);
      localObject1 = r;
      if (localObject1 != null)
      {
        i = d;
        ((Drawable)localObject1).setBounds(0, 0, i, i);
        o.setCompoundDrawables(r, null, null, null);
      }
      o.setVisibility(0);
      i = 1;
    }
    localObject1 = (Button)((ViewGroup)localObject3).findViewById(16908314);
    s = ((Button)localObject1);
    ((Button)localObject1).setOnClickListener(S);
    int k;
    if ((TextUtils.isEmpty(t)) && (v == null))
    {
      s.setVisibility(8);
    }
    else
    {
      s.setText(t);
      localObject1 = v;
      if (localObject1 != null)
      {
        k = d;
        ((Drawable)localObject1).setBounds(0, 0, k, k);
        s.setCompoundDrawables(v, null, null, null);
      }
      s.setVisibility(0);
      i |= 0x2;
    }
    localObject1 = (Button)((ViewGroup)localObject3).findViewById(16908315);
    w = ((Button)localObject1);
    ((Button)localObject1).setOnClickListener(S);
    if ((TextUtils.isEmpty(x)) && (z == null))
    {
      w.setVisibility(8);
    }
    else
    {
      w.setText(x);
      localObject1 = r;
      if (localObject1 != null)
      {
        k = d;
        ((Drawable)localObject1).setBounds(0, 0, k, k);
        o.setCompoundDrawables(r, null, null, null);
      }
      w.setVisibility(0);
      i |= 0x4;
    }
    localObject1 = a;
    localObject6 = new TypedValue();
    ((Context)localObject1).getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, (TypedValue)localObject6, true);
    if (data != 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      if (i == 1) {
        localAlertController.a(o);
      } else if (i == 2) {
        localAlertController.a(s);
      } else if (i == 4) {
        localAlertController.a(w);
      }
    }
    if (i != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      ((ViewGroup)localObject3).setVisibility(8);
    }
    if (G != null)
    {
      localObject1 = new ViewGroup.LayoutParams(-1, -2);
      paramBundle.addView(G, 0, (ViewGroup.LayoutParams)localObject1);
      c.findViewById(R.id.title_template).setVisibility(8);
    }
    else
    {
      D = ((ImageView)c.findViewById(16908294));
      if (((TextUtils.isEmpty(e) ^ true)) && (P))
      {
        localObject1 = (TextView)c.findViewById(R.id.alertTitle);
        E = ((TextView)localObject1);
        ((TextView)localObject1).setText(e);
        i = B;
        if (i != 0)
        {
          D.setImageResource(i);
        }
        else
        {
          localObject1 = C;
          if (localObject1 != null)
          {
            D.setImageDrawable((Drawable)localObject1);
          }
          else
          {
            E.setPadding(D.getPaddingLeft(), D.getPaddingTop(), D.getPaddingRight(), D.getPaddingBottom());
            D.setVisibility(8);
          }
        }
      }
      else
      {
        c.findViewById(R.id.title_template).setVisibility(8);
        D.setVisibility(8);
        paramBundle.setVisibility(8);
      }
    }
    if (((ViewGroup)localObject4).getVisibility() != 8) {
      k = 1;
    } else {
      k = 0;
    }
    if ((paramBundle != null) && (paramBundle.getVisibility() != 8)) {
      i = 1;
    } else {
      i = 0;
    }
    int m;
    if (((ViewGroup)localObject3).getVisibility() != 8) {
      m = 1;
    } else {
      m = 0;
    }
    if (m == 0)
    {
      localObject4 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoButtons);
      if (localObject4 != null) {
        ((View)localObject4).setVisibility(0);
      }
    }
    if (i != 0)
    {
      localObject4 = A;
      if (localObject4 != null) {
        ((FrameLayout)localObject4).setClipToPadding(true);
      }
      if ((f == null) && (g == null)) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.findViewById(R.id.titleDividerNoCustom);
      }
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    else
    {
      paramBundle = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoTitle);
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    paramBundle = g;
    if ((paramBundle instanceof AlertController.RecycleListView))
    {
      paramBundle = (AlertController.RecycleListView)paramBundle;
      if (paramBundle != null)
      {
        if ((m == 0) || (i == 0))
        {
          int n = paramBundle.getPaddingLeft();
          int i1;
          if (i != 0) {
            i1 = paramBundle.getPaddingTop();
          } else {
            i1 = x;
          }
          int i2 = paramBundle.getPaddingRight();
          int i3;
          if (m != 0) {
            i3 = paramBundle.getPaddingBottom();
          } else {
            i3 = y;
          }
          paramBundle.setPadding(n, i1, i2, i3);
        }
      }
      else {
        throw null;
      }
    }
    if (k == 0)
    {
      paramBundle = g;
      if (paramBundle == null) {
        paramBundle = A;
      }
      if (paramBundle != null)
      {
        k = j;
        if (m != 0) {
          k = 2;
        }
        i |= k;
        localObject3 = c.findViewById(R.id.scrollIndicatorUp);
        localObject4 = c.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23)
        {
          n.a(paramBundle, i, 3);
          if (localObject3 != null) {
            ((ViewGroup)localObject2).removeView((View)localObject3);
          }
          if (localObject4 != null) {
            ((ViewGroup)localObject2).removeView((View)localObject4);
          }
        }
        else
        {
          paramBundle = (Bundle)localObject3;
          if (localObject3 != null)
          {
            paramBundle = (Bundle)localObject3;
            if ((i & 0x1) == 0)
            {
              ((ViewGroup)localObject2).removeView((View)localObject3);
              paramBundle = null;
            }
          }
          if ((localObject4 != null) && ((i & 0x2) == 0)) {
            ((ViewGroup)localObject2).removeView((View)localObject4);
          } else {
            localObject5 = localObject4;
          }
          if ((paramBundle != null) || (localObject5 != null)) {
            if (f != null)
            {
              A.setOnScrollChangeListener(new b(localAlertController, paramBundle, (View)localObject5));
              A.post(new c(localAlertController, paramBundle, (View)localObject5));
            }
            else
            {
              localObject4 = g;
              if (localObject4 != null)
              {
                ((ListView)localObject4).setOnScrollListener(new d(localAlertController, paramBundle, (View)localObject5));
                g.post(new e(localAlertController, paramBundle, (View)localObject5));
              }
              else
              {
                if (paramBundle != null) {
                  ((ViewGroup)localObject2).removeView(paramBundle);
                }
                if (localObject5 != null) {
                  ((ViewGroup)localObject2).removeView((View)localObject5);
                }
              }
            }
          }
        }
      }
    }
    paramBundle = g;
    if (paramBundle != null)
    {
      localObject5 = H;
      if (localObject5 != null)
      {
        paramBundle.setAdapter((ListAdapter)localObject5);
        i = I;
        if (i > -1)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = z.A;
    int i;
    if ((localNestedScrollView != null) && (localNestedScrollView.a(paramKeyEvent))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = z.A;
    int i;
    if ((localNestedScrollView != null) && (localNestedScrollView.a(paramKeyEvent))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    Object localObject = z;
    e = paramCharSequence;
    localObject = E;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */