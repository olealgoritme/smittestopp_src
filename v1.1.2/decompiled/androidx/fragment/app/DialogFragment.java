package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import d.m.a.m;
import d.m.a.p;
import d.m.a.p.f;
import d.m.a.x;

public class DialogFragment
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  public DialogInterface.OnDismissListener A = new c();
  public int B = 0;
  public int C = 0;
  public boolean D = true;
  public boolean E = true;
  public int F = -1;
  public Dialog G;
  public boolean H;
  public boolean I;
  public boolean J;
  public Handler x;
  public Runnable y = new a();
  public DialogInterface.OnCancelListener z = new b();
  
  public Dialog a(Bundle paramBundle)
  {
    return new Dialog(requireContext(), C);
  }
  
  public void a(Dialog paramDialog, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt == 3) {
        paramDialog.getWindow().addFlags(24);
      }
    }
    else {
      paramDialog.requestWindowFeature(1);
    }
  }
  
  public void a(p paramp, String paramString)
  {
    I = false;
    J = true;
    if (paramp != null)
    {
      paramp = new d.m.a.a(paramp);
      paramp.a(0, this, paramString, 1);
      paramp.a();
      return;
    }
    throw null;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (I) {
      return;
    }
    I = true;
    J = false;
    Object localObject = G;
    if (localObject != null)
    {
      ((Dialog)localObject).setOnDismissListener(null);
      G.dismiss();
      if (!paramBoolean2) {
        if (Looper.myLooper() == x.getLooper()) {
          onDismiss(G);
        } else {
          x.post(y);
        }
      }
    }
    H = true;
    if (F >= 0)
    {
      localObject = getParentFragmentManager();
      int i = F;
      if (localObject != null)
      {
        if (i >= 0)
        {
          ((p)localObject).a(new p.f((p)localObject, null, i, 1), false);
          F = -1;
        }
        else
        {
          throw new IllegalArgumentException(e.a.a.a.a.a("Bad id: ", i));
        }
      }
      else {
        throw null;
      }
    }
    else
    {
      localObject = getParentFragmentManager();
      if (localObject == null) {
        break label196;
      }
      localObject = new d.m.a.a((p)localObject);
      ((x)localObject).a(this);
      if (paramBoolean1) {
        ((d.m.a.a)localObject).a(true);
      } else {
        ((x)localObject).a();
      }
    }
    return;
    label196:
    throw null;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!E) {
      return;
    }
    Object localObject = getView();
    if (localObject != null) {
      if (((View)localObject).getParent() == null) {
        G.setContentView((View)localObject);
      } else {
        throw new IllegalStateException("DialogFragment can not be attached to a container view");
      }
    }
    localObject = getActivity();
    if (localObject != null) {
      G.setOwnerActivity((Activity)localObject);
    }
    G.setCancelable(D);
    G.setOnCancelListener(z);
    G.setOnDismissListener(A);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("android:savedDialogState");
      if (paramBundle != null) {
        G.onRestoreInstanceState(paramBundle);
      }
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (!J) {
      I = false;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    x = new Handler();
    boolean bool;
    if (mContainerId == 0) {
      bool = true;
    } else {
      bool = false;
    }
    E = bool;
    if (paramBundle != null)
    {
      B = paramBundle.getInt("android:style", 0);
      C = paramBundle.getInt("android:theme", 0);
      D = paramBundle.getBoolean("android:cancelable", true);
      E = paramBundle.getBoolean("android:showsDialog", E);
      F = paramBundle.getInt("android:backStackId", -1);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Dialog localDialog = G;
    if (localDialog != null)
    {
      H = true;
      localDialog.setOnDismissListener(null);
      G.dismiss();
      if (!I) {
        onDismiss(G);
      }
      G = null;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if ((!J) && (!I)) {
      I = true;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!H) {
      a(true, true);
    }
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    if (!E) {
      return super.onGetLayoutInflater(paramBundle);
    }
    paramBundle = a(paramBundle);
    G = paramBundle;
    if (paramBundle != null)
    {
      a(paramBundle, B);
      return (LayoutInflater)G.getContext().getSystemService("layout_inflater");
    }
    return (LayoutInflater)mHost.y.getSystemService("layout_inflater");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject = G;
    if (localObject != null)
    {
      localObject = ((Dialog)localObject).onSaveInstanceState();
      if (localObject != null) {
        paramBundle.putBundle("android:savedDialogState", (Bundle)localObject);
      }
    }
    int i = B;
    if (i != 0) {
      paramBundle.putInt("android:style", i);
    }
    i = C;
    if (i != 0) {
      paramBundle.putInt("android:theme", i);
    }
    boolean bool = D;
    if (!bool) {
      paramBundle.putBoolean("android:cancelable", bool);
    }
    bool = E;
    if (!bool) {
      paramBundle.putBoolean("android:showsDialog", bool);
    }
    i = F;
    if (i != -1) {
      paramBundle.putInt("android:backStackId", i);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Dialog localDialog = G;
    if (localDialog != null)
    {
      H = false;
      localDialog.show();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Dialog localDialog = G;
    if (localDialog != null) {
      localDialog.hide();
    }
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      DialogFragment localDialogFragment = DialogFragment.this;
      A.onDismiss(G);
    }
  }
  
  public class b
    implements DialogInterface.OnCancelListener
  {
    public b() {}
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      DialogFragment localDialogFragment = DialogFragment.this;
      paramDialogInterface = G;
      if (paramDialogInterface != null) {
        localDialogFragment.onCancel(paramDialogInterface);
      }
    }
  }
  
  public class c
    implements DialogInterface.OnDismissListener
  {
    public c() {}
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      paramDialogInterface = DialogFragment.this;
      Dialog localDialog = G;
      if (localDialog != null) {
        paramDialogInterface.onDismiss(localDialog);
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.fragment.app.DialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */