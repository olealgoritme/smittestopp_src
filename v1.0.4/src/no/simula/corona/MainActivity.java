package no.simula.corona;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.microsoft.appcenter.analytics.Analytics;
import d.b.a.k;
import d.b.a.r;
import d.b.a.s;
import d.s.m;
import d.s.s.d;
import d.s.s.e;
import h.k.b.g;
import j.b.a.a0;
import j.b.a.q;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import l.a.a.b;
import no.simula.corona.ui.register.RegisterActivity;

public final class MainActivity
  extends d.b.a.h
  implements j.b.a.e0.b.b, j.b.a.v
{
  public final MainActivity.c A = new MainActivity.c(this);
  public HashMap B;
  public DataCollectorService z;
  
  public void a() {}
  
  public void a(j.b.a.e0.b.a parama) {}
  
  public void a(boolean paramBoolean)
  {
    a0.a(this, paramBoolean);
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
  
  public final void a(boolean paramBoolean, h.k.a.a<h.h> parama)
  {
    l.a.a.d.c("Show rationale", new Object[0]);
    int i;
    if (paramBoolean) {
      i = 2131886115;
    } else {
      i = 2131886201;
    }
    int j;
    if (paramBoolean) {
      j = 2131886188;
    } else {
      j = 2131886189;
    }
    new AlertDialog.Builder(this).setTitle(2131886190).setMessage(j).setPositiveButton(i, new MainActivity.a(0, parama)).setNegativeButton(2131886158, new MainActivity.a(1, this)).create().show();
  }
  
  public Boolean b()
  {
    Object localObject = z;
    if (localObject != null) {
      localObject = Boolean.valueOf(O);
    } else {
      localObject = null;
    }
    return (Boolean)localObject;
  }
  
  public void b(boolean paramBoolean)
  {
    a0.b(this, paramBoolean);
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
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    runOnUiThread(new MainActivity.e(this));
  }
  
  public void g() {}
  
  public void h()
  {
    r.a(this, 2131361985).a(2131361991, null, null);
  }
  
  public Boolean i()
  {
    Object localObject = z;
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
    if (a0.i(this))
    {
      localObject = getSharedPreferences("settings", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("firstland", false);
      ((SharedPreferences.Editor)localObject).apply();
      n();
      return;
    }
    if (a0.g(this))
    {
      localObject = z;
      if ((localObject != null) && (!((DataCollectorService)localObject).b()) && (a0.a(this, "android.permission.ACCESS_FINE_LOCATION")))
      {
        if (a0.c(this)) {
          DataCollectorService.a(this);
        }
        if (a0.d(this)) {
          DataCollectorService.b(this);
        }
      }
    }
  }
  
  public final boolean m()
  {
    if (z == null)
    {
      l.a.a.d.b("Service is null, cannot toggle state", new Object[0]);
      return false;
    }
    if (!a0.g(this))
    {
      localDataCollectorService = z;
      if ((localDataCollectorService != null) && (!localDataCollectorService.b()))
      {
        Toast.makeText(this, "Cannot start location monitoring before consenting", 1).show();
        return false;
      }
    }
    if (!a0.h(this))
    {
      startActivity(new Intent(this, RegisterActivity.class));
      return false;
    }
    DataCollectorService localDataCollectorService = z;
    if ((localDataCollectorService != null) && (!localDataCollectorService.b()) && (!a0.a(this, "android.permission.ACCESS_FINE_LOCATION")))
    {
      n();
      return false;
    }
    return true;
  }
  
  public final void n()
  {
    if (getSharedPreferences("settings", 0).getBoolean("dont-ask-again", false))
    {
      if ((Build.VERSION.SDK_INT >= 23) && (shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")))
      {
        a(true, new MainActivity.b(0, this));
        return;
      }
      a(false, new MainActivity.b(1, this));
      return;
    }
    int i;
    if (Build.VERSION.SDK_INT >= 29)
    {
      i = a0.c;
      d.i.a.a.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION" }, i);
    }
    else
    {
      i = a0.c;
      d.i.a.a.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION" }, i);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558429);
    int i = R.id.toolbar;
    if (B == null) {
      B = new HashMap();
    }
    Object localObject1 = (View)B.get(Integer.valueOf(i));
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      paramBundle = findViewById(i);
      B.put(Integer.valueOf(i), paramBundle);
    }
    Object localObject2 = (Toolbar)paramBundle;
    localObject1 = (k)j();
    if ((z instanceof Activity))
    {
      ((k)localObject1).k();
      paramBundle = E;
      if (!(paramBundle instanceof d.b.a.v))
      {
        F = null;
        if (paramBundle != null) {
          paramBundle.f();
        }
        if (localObject2 != null)
        {
          paramBundle = z;
          if ((paramBundle instanceof Activity)) {
            paramBundle = ((Activity)paramBundle).getTitle();
          } else {
            paramBundle = G;
          }
          paramBundle = new s((Toolbar)localObject2, paramBundle, C);
          E = paramBundle;
          B.setCallback(c);
        }
        else
        {
          E = null;
          B.setCallback(C);
        }
        ((k)localObject1).b();
      }
    }
    else
    {
      paramBundle = findViewById(2131361987);
      g.a(paramBundle, "findViewById(R.id.nav_view)");
      localObject1 = (BottomNavigationView)paramBundle;
      paramBundle = r.a(this, 2131361985);
      LinkedHashSet localLinkedHashSet = new LinkedHashSet(e.c.a.a.b.l.c.b(3));
      for (i = 0; i < 3; i++) {
        localLinkedHashSet.add(new Integer[] { Integer.valueOf(2131361991), Integer.valueOf(2131361989), Integer.valueOf(2131361990) }[i]);
      }
      MainActivity.d locald = MainActivity.d.x;
      localObject2 = new HashSet();
      ((AbstractCollection)localObject2).addAll(localLinkedHashSet);
      localObject2 = new d.s.s.c((Set)localObject2, null, new q(locald), null);
      g.a(localObject2, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
      if (paramBundle != null)
      {
        paramBundle.a(new d.s.s.b(this, (d.s.s.c)localObject2));
        ((BottomNavigationView)localObject1).setOnNavigationItemSelectedListener(new d(paramBundle));
        paramBundle.a(new e(new WeakReference(localObject1), paramBundle));
        if (c == null) {
          c = new m(a, k);
        }
        paramBundle = c.a(2131755008);
        g.a(paramBundle, "navController.navInflate…te(R.navigation.main_nav)");
        G = 2131361989;
        H = null;
        paramBundle = a0.e(this);
        l.a.a.d.b("My device id is: %s", new Object[] { paramBundle });
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
        if (paramInt == a0.c)
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
            a0.c(this, true);
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
    bindService(new Intent(this, DataCollectorService.class), A, 1);
  }
  
  public void onStop()
  {
    if (z != null) {
      unbindService(A);
    }
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.MainActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */