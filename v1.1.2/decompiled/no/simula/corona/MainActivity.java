package no.simula.corona;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.microsoft.appcenter.analytics.Analytics;
import d.b.a.k;
import d.b.a.s;
import d.b.a.w;
import d.s.m;
import d.s.s.e;
import i.k.b.g;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import k.b.a.n;
import k.b.a.o;
import no.simula.corona.ui.register.RegisterActivity;

public final class MainActivity
  extends d.b.a.h
  implements k.b.a.z.b.b, o
{
  public DataCollectorService A;
  public final c B = new c(this);
  public HashMap C;
  
  public Boolean a()
  {
    Object localObject = A;
    if (localObject != null) {
      localObject = Boolean.valueOf(O);
    } else {
      localObject = null;
    }
    return (Boolean)localObject;
  }
  
  public void a(k.b.a.z.b.a parama) {}
  
  public void a(boolean paramBoolean)
  {
    k.b.a.t.b(this, paramBoolean);
    if (m()) {
      if (paramBoolean)
      {
        DataCollectorService.a(this);
      }
      else
      {
        Intent localIntent = new Intent(this, DataCollectorService.class);
        localIntent.putExtra("service-command", 3);
        startService(localIntent);
      }
    }
  }
  
  public final void a(boolean paramBoolean, final i.k.a.a<i.h> parama)
  {
    m.a.a.d.c("Show rationale", new Object[0]);
    int i;
    if (paramBoolean) {
      i = 2131886129;
    } else {
      i = 2131886232;
    }
    int j;
    if (paramBoolean) {
      j = 2131886219;
    } else {
      j = 2131886220;
    }
    new AlertDialog.Builder(this).setTitle(2131886221).setMessage(j).setPositiveButton(i, new a(0, parama)).setNegativeButton(2131886179, new a(1, this)).create().show();
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    k.b.a.t.c(this, paramBoolean);
    if (m()) {
      if (paramBoolean)
      {
        DataCollectorService.b(this);
      }
      else
      {
        Intent localIntent = new Intent(this, DataCollectorService.class);
        localIntent.putExtra("service-command", 0);
        startService(localIntent);
      }
    }
  }
  
  public void c()
  {
    runOnUiThread(new e(this));
  }
  
  public void d() {}
  
  public void e()
  {
    s.a(this, 2131361987).a(2131361993, null, null);
  }
  
  public void f() {}
  
  public void h() {}
  
  public Boolean i()
  {
    Object localObject = A;
    if (localObject != null) {
      localObject = Boolean.valueOf(y);
    } else {
      localObject = null;
    }
    return (Boolean)localObject;
  }
  
  public final void l()
  {
    Object localObject;
    if (k.b.a.t.j(this))
    {
      localObject = (e.g.a.b)((e.g.a)((k.b.a.v.c)k.b.a.t.a).a(this)).edit();
      ((e.g.a.b)localObject).putBoolean("firstland", false);
      a.apply();
      n();
      return;
    }
    if (k.b.a.t.g(this))
    {
      localObject = A;
      if ((localObject != null) && (!((DataCollectorService)localObject).b()) && (k.b.a.t.a(this, "android.permission.ACCESS_FINE_LOCATION")))
      {
        if (k.b.a.t.c(this)) {
          DataCollectorService.a(this);
        }
        if (k.b.a.t.d(this)) {
          DataCollectorService.b(this);
        }
      }
    }
  }
  
  public final boolean m()
  {
    if (A == null)
    {
      m.a.a.d.b("Service is null, cannot toggle state", new Object[0]);
      return false;
    }
    if (!k.b.a.t.g(this))
    {
      localDataCollectorService = A;
      if ((localDataCollectorService != null) && (!localDataCollectorService.b()))
      {
        Toast.makeText(this, "Cannot start location monitoring before consenting", 1).show();
        return false;
      }
    }
    if (!k.b.a.t.i(this))
    {
      startActivity(new Intent(this, RegisterActivity.class));
      return false;
    }
    DataCollectorService localDataCollectorService = A;
    if ((localDataCollectorService != null) && (!localDataCollectorService.b()) && (!k.b.a.t.a(this, "android.permission.ACCESS_FINE_LOCATION")))
    {
      n();
      return false;
    }
    return true;
  }
  
  public final void n()
  {
    k.b.a.v.c localc = (k.b.a.v.c)k.b.a.t.a;
    if (getSharedPreferences(a, 0).getBoolean(d, false))
    {
      if ((Build.VERSION.SDK_INT >= 23) && (shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")))
      {
        a(true, new b(0, this));
        return;
      }
      a(false, new b(1, this));
      return;
    }
    int i;
    if (Build.VERSION.SDK_INT >= 29)
    {
      i = k.b.a.t.d;
      d.i.a.a.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION" }, i);
    }
    else
    {
      i = k.b.a.t.d;
      d.i.a.a.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION" }, i);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558429);
    int i = R.id.toolbar;
    if (C == null) {
      C = new HashMap();
    }
    Object localObject1 = (View)C.get(Integer.valueOf(i));
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      paramBundle = findViewById(i);
      C.put(Integer.valueOf(i), paramBundle);
    }
    Object localObject2 = (Toolbar)paramBundle;
    paramBundle = (k)j();
    if ((z instanceof Activity))
    {
      paramBundle.i();
      localObject1 = C;
      if (!(localObject1 instanceof w))
      {
        D = null;
        if (localObject1 != null) {
          ((d.b.a.a)localObject1).f();
        }
        if (localObject2 != null)
        {
          localObject1 = new d.b.a.t((Toolbar)localObject2, ((Activity)z).getTitle(), A);
          C = ((d.b.a.a)localObject1);
          y.setCallback(c);
        }
        else
        {
          C = null;
          y.setCallback(A);
        }
        paramBundle.c();
      }
    }
    else
    {
      paramBundle = findViewById(2131361989);
      g.a(paramBundle, "findViewById(R.id.nav_view)");
      paramBundle = (BottomNavigationView)paramBundle;
      localObject1 = s.a(this, 2131361987);
      LinkedHashSet localLinkedHashSet = new LinkedHashSet(e.c.a.a.b.l.c.b(3));
      for (i = 0; i < 3; i++) {
        localLinkedHashSet.add(new Integer[] { Integer.valueOf(2131361993), Integer.valueOf(2131361991), Integer.valueOf(2131361992) }[i]);
      }
      d locald = d.x;
      localObject2 = new HashSet();
      ((AbstractCollection)localObject2).addAll(localLinkedHashSet);
      localObject2 = new d.s.s.c((Set)localObject2, null, new n(locald), null);
      g.a(localObject2, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
      if (localObject1 != null)
      {
        ((NavController)localObject1).a(new d.s.s.b(this, (d.s.s.c)localObject2));
        paramBundle.setOnNavigationItemSelectedListener(new d.s.s.d((NavController)localObject1));
        ((NavController)localObject1).a(new e(new WeakReference(paramBundle), (NavController)localObject1));
        if (c == null) {
          c = new m(a, k);
        }
        paramBundle = c.a(2131755008);
        g.a(paramBundle, "navController.navInflate…te(R.navigation.main_nav)");
        G = 2131361991;
        H = null;
        paramBundle = k.b.a.t.e(this);
        m.a.a.d.b("My device id is: %s", new Object[] { paramBundle });
        return;
      }
      g.a("navController");
      throw null;
    }
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfInt != null)
      {
        if (paramInt == k.b.a.t.d)
        {
          LinkedHashMap localLinkedHashMap = new LinkedHashMap();
          paramInt = paramArrayOfString.length;
          StringBuilder localStringBuilder;
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              localLinkedHashMap.put("permissions", "none");
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramArrayOfString[0]);
              localStringBuilder.append(", ");
              localStringBuilder.append(paramArrayOfString[1]);
              localLinkedHashMap.put("permissions", localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramArrayOfInt[0]);
              localStringBuilder.append(", ");
              localStringBuilder.append(paramArrayOfInt[1]);
              localLinkedHashMap.put("granted", localStringBuilder.toString());
            }
          }
          else
          {
            localLinkedHashMap.put("permissions", paramArrayOfString[0]);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramArrayOfInt[0]);
            localStringBuilder.append('}');
            localLinkedHashMap.put("granted", localStringBuilder.toString());
          }
          if ((localLinkedHashMap.isEmpty() ^ true)) {
            Analytics.trackEvent("Permission Response", localLinkedHashMap);
          }
          paramInt = e.c.a.a.b.l.c.a(paramArrayOfString, "android.permission.ACCESS_FINE_LOCATION");
          if ((paramInt >= 0) && (paramArrayOfInt[paramInt] == 0)) {
            l();
          } else {
            k.b.a.t.d(this, true);
          }
        }
        return;
      }
      g.a("grantResults");
      throw null;
    }
    g.a("permissions");
    throw null;
  }
  
  public void onStart()
  {
    super.onStart();
    bindService(new Intent(this, DataCollectorService.class), B, 1);
  }
  
  public void onStop()
  {
    if (A != null) {
      unbindService(B);
    }
    super.onStop();
  }
  
  public static final class a
    implements DialogInterface.OnClickListener
  {
    public a(int paramInt, Object paramObject) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramInt = x;
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          k.b.a.t.d((MainActivity)parama, true);
          return;
        }
        throw null;
      }
      ((i.k.a.a)parama).invoke();
    }
  }
  
  public static final class b
    extends i.k.b.h
    implements i.k.a.a<i.h>
  {
    public b(int paramInt, Object paramObject)
    {
      super();
    }
    
    public final Object invoke()
    {
      int i = x;
      if (i != 0)
      {
        if (i == 1)
        {
          Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
          localIntent.setData(Uri.fromParts("package", ((MainActivity)jdField_this).getPackageName(), null));
          ((MainActivity)jdField_this).startActivity(localIntent);
          return i.h.a;
        }
        throw null;
      }
      k.b.a.t.d((MainActivity)jdField_this, false);
      MainActivity.b((MainActivity)jdField_this);
      return i.h.a;
    }
  }
  
  public static final class c
    implements ServiceConnection
  {
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (paramIBinder != null)
      {
        paramIBinder = (k.b.a.a)paramIBinder;
        paramComponentName = a;
        paramIBinder = a;
        A = paramIBinder;
        if (paramIBinder != null) {
          x = paramComponentName;
        }
        if (!a.isFinishing()) {
          a.l();
        }
      }
      MainActivity.c(a);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      paramComponentName = a.A;
      if (paramComponentName != null) {
        x = null;
      }
      paramComponentName = a;
      A = null;
      MainActivity.c(paramComponentName);
    }
  }
  
  public static final class d
    extends i.k.b.h
    implements i.k.a.a<Boolean>
  {
    public static final d x = new d();
    
    public d()
    {
      super();
    }
    
    public Object invoke()
    {
      return Boolean.valueOf(false);
    }
  }
  
  public static final class e
    implements Runnable
  {
    public e(MainActivity paramMainActivity) {}
    
    public final void run()
    {
      if (!x.isFinishing())
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(x);
        localBuilder.setTitle(2131886124);
        localBuilder.setMessage(2131886172);
        localBuilder.setPositiveButton(17039370, new a(this));
        localBuilder.setOnDismissListener(new b(this));
        localBuilder.create();
        localBuilder.show();
      }
    }
    
    public static final class a
      implements DialogInterface.OnClickListener
    {
      public a(MainActivity.e parame) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        MainActivity.a(x.x);
      }
    }
    
    public static final class b
      implements DialogInterface.OnDismissListener
    {
      public b(MainActivity.e parame) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        MainActivity.a(x.x);
      }
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.MainActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */