package no.simula.corona;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.location.LocationRequest;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.EventProperties;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.azure.sdk.iot.device.DeviceClient;
import j.b.a.a0;
import j.b.a.b0.i;
import j.b.a.f;
import j.b.a.v;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.d.a.m;
import l.a.a.b;
import org.greenrobot.eventbus.ThreadMode;

public final class DataCollectorService
  extends Service
  implements j.b.a.b0.h
{
  public boolean A;
  public LocationRequest B;
  public e.c.a.a.e.b C;
  public e.c.a.a.e.a D;
  public long E;
  public final int F;
  public j.b.a.d0.a G;
  public Notification H;
  public Notification I;
  public Notification J;
  public MeasurementDatabase K;
  public f L;
  public j.b.a.h M;
  public j.b.a.b0.c N;
  public boolean O;
  public j.b.a.b0.a P;
  public i Q;
  public j.b.a.b0.e R;
  public v x;
  public boolean y;
  public final j.b.a.d z = new j.b.a.d(this);

  public DataCollectorService()
  {
    LocationRequest localLocationRequest = new LocationRequest();
    LocationRequest.a(12000L);
    y = 12000L;
    if (!A) {
      z = ((12000L / 6.0D));
    }
    LocationRequest.a(10000L);
    A = true;
    z = 10000L;
    x = 100;
    B = localLocationRequest;
    E = a0.a();
    F = 1;
  }

  public static final void a(Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramContext, DataCollectorService.class);
      localIntent.putExtra("service-command", 2);
      paramContext.startService(localIntent);
      return;
    }
    h.k.b.g.a("context");
    throw null;
  }

  public static final void b(Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramContext, DataCollectorService.class);
      localIntent.putExtra("service-command", 1);
      paramContext.startService(localIntent);
      return;
    }
    h.k.b.g.a("context");
    throw null;
  }

  public final Notification a()
  {
    Object localObject1 = new Intent(this, DataCollectorService.class);
    ((Intent)localObject1).putExtra("from-service", true);
    localObject1 = PendingIntent.getService(this, 0, (Intent)localObject1, 134217728);
    Object localObject2 = new Intent(this, MainActivity.class);
    ((Intent)localObject2).setFlags(268468224);
    localObject2 = PendingIntent.getActivity(this, 0, (Intent)localObject2, 0);
    d.i.a.g localg = new d.i.a.g(this);
    localg.b(getString(2131886208));
    O.icon = 2131230888;
    localg.a(getString(2131886195));
    l = 1;
    localg.a(2131230889, getString(2131886227), (PendingIntent)localObject1);
    localg.a(2131230884, getString(2131886200), (PendingIntent)localObject2);
    if (Build.VERSION.SDK_INT >= 26) {
      I = "Smittestopp Notification Channel";
    }
    localObject1 = localg.a();
    h.k.b.g.a(localObject1, "builder.build()");
    return (Notification)localObject1;
  }

  public final Notification a(int paramInt)
  {
    Object localObject = PendingIntent.getActivity(this, 0, new Intent(this, SplashActivity.class), 0);
    d.i.a.g localg = new d.i.a.g(this);
    localg.b(getString(paramInt));
    O.icon = 2131230888;
    localg.a(getString(2131886215));
    l = 1;
    f = ((PendingIntent)localObject);
    localg.a(true);
    if (Build.VERSION.SDK_INT >= 26) {
      I = "Smittestopp Reminders";
    }
    localObject = localg.a();
    h.k.b.g.a(localObject, "notification.build()");
    return (Notification)localObject;
  }

  /*
   *  Database insert BluetoothContact object
   */
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramString != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("found connection to ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", signal strength ");
      ((StringBuilder)localObject).append(paramInt1);
      localObject = ((StringBuilder)localObject).toString();
      l.a.a.d.c((String)localObject, new Object[0]);
      paramLong /= 'Ϩ';
      localObject = K;
      if (localObject != null)
      {
        localObject = ((MeasurementDatabase)localObject).h();
        paramString = new j.b.a.a(paramLong, paramString, paramInt1, paramInt2, false);
        localObject = (j.b.a.c)localObject;
        a.b();
        a.c();
        try
        {
          b.a(new j.b.a.a[] { paramString });
          a.g();
          a.d();
          if (i()) {
            f();
          }
          return;
        }
        finally
        {
          a.d();
        }
      }
      h.k.b.g.b("mDatabase");
      throw null;
    }
    h.k.b.g.a("deviceId");
    throw null;
  }

  public final boolean b()
  {
    boolean bool;
    if ((!y) && (!O)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }

  public final void c()
  {
    H = null;
    I = null;
    Object localObject = getSystemService("notification");
    if (localObject != null)
    {
      localObject = (NotificationManager)localObject;
      ((NotificationManager)localObject).cancel(14);
      ((NotificationManager)localObject).cancel(15);
      return;
    }
    throw new h.e("null cannot be cast to non-null type android.app.NotificationManager");
  }

  public final void d()
  {
    int i;
    if ((R != null) && (P != null) && (Q != null)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject3;
    if (i == 0)
    {
      l.a.a.d.a("Initializing bluetooth components", new Object[0]);
      Object localObject1 = getSystemService("bluetooth");
      if (localObject1 != null)
      {
        localObject1 = (BluetoothManager)localObject1;
        try
        {
          localObject3 = ((BluetoothManager)localObject1).getAdapter();
          if ((localObject3 != null) && (((BluetoothAdapter)localObject3).isEnabled() == true))
          {
            localObject3 = ((BluetoothManager)localObject1).getAdapter();
            h.k.b.g.a(localObject3, "bluetoothManager.adapter");
            if (((BluetoothAdapter)localObject3).getBluetoothLeAdvertiser() == null)
            {
              l.a.a.d.d("Le advertiser is not supported on this device", new Object[0]);
              localObject3 = new com/microsoft/appcenter/analytics/EventProperties;
              ((EventProperties)localObject3).<init>();
              ((EventProperties)localObject3).set("what", "Not supported");
              localObject4 = new java/lang/StringBuilder;
              ((StringBuilder)localObject4).<init>();
              ((StringBuilder)localObject4).append(Build.MANUFACTURER);
              ((StringBuilder)localObject4).append(' ');
              ((StringBuilder)localObject4).append(Build.MODEL);
              ((EventProperties)localObject3).set("model", ((StringBuilder)localObject4).toString());
              Analytics.trackEvent("LeAdvertise", (EventProperties)localObject3);
            }
            localObject3 = new j/b/a/b0/e;
            ((j.b.a.b0.e)localObject3).<init>(this, (BluetoothManager)localObject1);
            R = ((j.b.a.b0.e)localObject3);
            localObject3 = new j/b/a/b0/a;
            localObject1 = ((BluetoothManager)localObject1).getAdapter();
            h.k.b.g.a(localObject1, "bluetoothManager.adapter");
            ((j.b.a.b0.a)localObject3).<init>(((BluetoothAdapter)localObject1).getBluetoothLeAdvertiser());
            P = ((j.b.a.b0.a)localObject3);
            Object localObject4 = new j/b/a/b0/i;
            localObject1 = getApplication();
            h.k.b.g.a(localObject1, "this.application");
            localObject3 = j.a.a.a.a.a.a.a();
            h.k.b.g.a(localObject3, "BluetoothLeScannerCompat.getScanner()");
            ((i)localObject4).<init>((Application)localObject1, this, (j.a.a.a.a.a.a)localObject3);
            Q = ((i)localObject4);
          }
          else
          {
            l.a.a.d.a("Bluetooth adapter is null", new Object[0]);
          }
        }
        catch (Exception localException)
        {
          localObject3 = new LinkedHashMap();
          ((HashMap)localObject3).put("where", "DataCollector::initializeBluetooth");
          Crashes.trackError(localException, (Map)localObject3, null);
        }
      }
      throw new h.e("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }
    Object localObject2 = getSystemService("bluetooth");
    if (localObject2 != null)
    {
      localObject2 = (BluetoothManager)localObject2;
      l.a.a.d.c("Starting bluetooth updates", new Object[0]);
      try
      {
        localObject2 = ((BluetoothManager)localObject2).getAdapter();
        if ((localObject2 != null) && (((BluetoothAdapter)localObject2).isEnabled() == true))
        {
          localObject2 = R;
          if (localObject2 != null)
          {
            localObject3 = new j/b/a/b0/d;
            ((j.b.a.b0.d)localObject3).<init>((j.b.a.b0.e)localObject2);
            localObject3 = e.openGattServer(d, (BluetoothGattServerCallback)localObject3);
            if (localObject3 != null) {
              ((BluetoothGattServer)localObject3).addService(b);
            }
            c = ((BluetoothGattServer)localObject3);
          }
          localObject3 = P;
          if (localObject3 != null)
          {
            localObject2 = d;
            if (localObject2 != null) {
              ((BluetoothLeAdvertiser)localObject2).startAdvertising(b, a, c);
            }
          }
          localObject2 = Q;
          if (localObject2 != null)
          {
            b = true;
            ((i)localObject2).a();
            d.sendEmptyMessageDelayed(3, 35000L);
          }
          O = true;
          localObject2 = k.d.a.c.b();
          localObject3 = new j/b/a/c0/b;
          ((j.b.a.c0.b)localObject3).<init>(true);
          ((k.d.a.c)localObject2).a(localObject3);
          localObject2 = x;
          if (localObject2 != null) {
            ((v)localObject2).e();
          }
        }
        else
        {
          l.a.a.d.b("Bluetooth adaptor is off", new Object[0]);
        }
      }
      catch (SecurityException localSecurityException)
      {
        l.a.a.d.b("Lost bluetooth permissions", new Object[0]);
      }
      return;
    }
    throw new h.e("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
  }

  public final void e()
  {
    l.a.a.d.c("Starting location updates", new Object[0]);
    try
    {
      if (!j.b.a.d0.a.a(this))
      {
        l.a.a.d.b("Location services are off", new Object[0]);
        return;
      }
      Object localObject1 = D;
      if (localObject1 != null)
      {
        Object localObject2 = B;
        e.c.a.a.e.b localb = C;
        if (localb != null)
        {
          ((e.c.a.a.e.a)localObject1).a((LocationRequest)localObject2, localb, Looper.myLooper());
          y = true;
          localObject1 = k.d.a.c.b();
          localObject2 = new j/b/a/c0/c;
          ((j.b.a.c0.c)localObject2).<init>(true);
          ((k.d.a.c)localObject1).a(localObject2);
          localObject2 = x;
          if (localObject2 != null) {
            ((v)localObject2).d();
          }
        }
        else
        {
          h.k.b.g.b("locationCallback");
          throw null;
        }
      }
      else
      {
        h.k.b.g.b("fusedLocationClient");
        throw null;
      }
    }
    catch (SecurityException localSecurityException)
    {
      l.a.a.d.b("Lost location permissions", new Object[0]);
      Crashes.trackError(localSecurityException);
    }
  }

  public final void f()
  {
    Object localObject1 = L;
    if ((localObject1 != null) && (((f)localObject1).a() == true)) {
      return;
    }
    localObject1 = M;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      if (!c)
      {
        ((j.b.a.h)localObject1).a();
        return;
      }
      localObject1 = f;
      Object localObject3 = h.o.g.a("1.0.2", new String[] { "." }, false, 0, 6);
      if (((List)localObject3).size() >= 3)
      {
        int i = Integer.parseInt((String)((List)localObject3).get(0));
        int j = Integer.parseInt((String)((List)localObject3).get(1));
        int k = Integer.parseInt((String)((List)localObject3).get(2));
        localObject3 = h.o.g.a((CharSequence)localObject1, new String[] { "." }, false, 0, 6);
        if (((List)localObject3).size() != 3)
        {
          localObject3 = new EventProperties();
          ((EventProperties)localObject3).set("version", (String)localObject1);
          Analytics.trackEvent("Malformed version string", (EventProperties)localObject3);
        }
        else
        {
          m = Integer.parseInt((String)((List)localObject3).get(0));
          int n = Integer.parseInt((String)((List)localObject3).get(1));
          int i1 = Integer.parseInt((String)((List)localObject3).get(2));
          if ((m > i) || ((m == i) && (n > j)) || ((m == i) && (n == j) && (i1 > k))) {
            break label277;
          }
        }
      }
      int m = 0;
      break label280;
      label277:
      m = 1;
      label280:
      if ((m != 0) && (J == null))
      {
        localObject1 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=no.simula.smittestopp"));
        localObject3 = getPackageManager().queryIntentActivities((Intent)localObject1, 0).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (ResolveInfo)((Iterator)localObject3).next();
        } while (!h.k.b.g.a(activityInfo.applicationInfo.packageName, "com.android.vending"));
        localObject1 = activityInfo;
        localObject2 = new ComponentName(applicationInfo.packageName, name);
        localObject1 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=no.simula.smittestopp"));
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).addFlags(2097152);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).setComponent((ComponentName)localObject2);
        if (localObject1 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://play.google.com/store/apps/details?id=");
          ((StringBuilder)localObject1).append("no.simula.smittestopp");
          localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject1).toString()));
        }
        localObject1 = PendingIntent.getActivity(this, 0, (Intent)localObject1, 0);
        localObject2 = new d.i.a.g(this);
        ((d.i.a.g)localObject2).b(getString(2131886191));
        O.icon = 2131230888;
        ((d.i.a.g)localObject2).a(getString(2131886192));
        l = 1;
        f = ((PendingIntent)localObject1);
        ((d.i.a.g)localObject2).a(true);
        if (Build.VERSION.SDK_INT >= 26) {
          I = "Smittestopp Reminders";
        }
        J = ((d.i.a.g)localObject2).a();
        localObject1 = getSystemService("notification");
        if (localObject1 != null) {
          ((NotificationManager)localObject1).notify(16, J);
        } else {
          throw new h.e("null cannot be cast to non-null type android.app.NotificationManager");
        }
      }
      E = a0.a();
      localObject1 = new f(this, new DataCollectorService.c(this));
      L = ((f)localObject1);
      ((AsyncTask)localObject1).execute(new Object[0]);
      return;
    }
    h.k.b.g.b("mDevice");
    throw null;
  }

  public final void g()
  {
    if (O)
    {
      l.a.a.d.c("Stopping bluetooth updates", new Object[0]);
      Object localObject1 = getSystemService("bluetooth");
      if (localObject1 != null)
      {
        localObject1 = ((BluetoothManager)localObject1).getAdapter();
        if ((localObject1 != null) && (((BluetoothAdapter)localObject1).isEnabled() == true)) {
          try
          {
            localObject1 = R;
            if (localObject1 != null)
            {
              localObject1 = c;
              if (localObject1 != null) {
                ((BluetoothGattServer)localObject1).close();
              }
            }
            localObject1 = Q;
            if (localObject1 != null)
            {
              b = false;
              d.removeMessages(4);
              ((i)localObject1).b();
            }
            localObject1 = P;
            if (localObject1 != null)
            {
              localObject2 = d;
              if (localObject2 != null) {
                ((BluetoothLeAdvertiser)localObject2).stopAdvertising(c);
              }
            }
            O = false;
            localObject1 = k.d.a.c.b();
            Object localObject2 = new j/b/a/c0/b;
            ((j.b.a.c0.b)localObject2).<init>(false);
            ((k.d.a.c)localObject1).a(localObject2);
          }
          catch (Exception localException)
          {
            l.a.a.d.a(localException);
            localObject1 = new LinkedHashMap();
            ((HashMap)localObject1).put("where", "DataCollector::stopBluetoothUpdates");
            Crashes.trackError(localException, (Map)localObject1, null);
          }
        }
        localObject1 = Q;
        if (localObject1 != null)
        {
          b = false;
          d.removeMessages(4);
          ((i)localObject1).b();
        }
        O = false;
        k.d.a.c.b().a(new j.b.a.c0.b(false));
      }
      else
      {
        throw new h.e("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
      }
    }
    else
    {
      l.a.a.d.c("bluetooth is already closed", new Object[0]);
    }
  }

  public final void h()
  {
    if (y)
    {
      l.a.a.d.c("Stopping location updates", new Object[0]);
      try
      {
        Object localObject1 = D;
        if (localObject1 != null)
        {
          Object localObject2 = C;
          if (localObject2 != null)
          {
            ((e.c.a.a.e.a)localObject1).a((e.c.a.a.e.b)localObject2);
            y = false;
            localObject2 = x;
            if (localObject2 != null) {
              ((v)localObject2).g();
            }
            localObject2 = k.d.a.c.b();
            localObject1 = new j/b/a/c0/c;
            ((j.b.a.c0.c)localObject1).<init>(false);
            ((k.d.a.c)localObject2).a(localObject1);
            y = false;
            return;
          }
          h.k.b.g.b("locationCallback");
          throw null;
        }
        h.k.b.g.b("fusedLocationClient");
        throw null;
      }
      catch (SecurityException localSecurityException)
      {
        l.a.a.d.a(localSecurityException);
        Crashes.trackError(localSecurityException);
      }
    }
    l.a.a.d.c("location services already closed", new Object[0]);
  }

  public final boolean i()
  {
    boolean bool1 = a0.j(this);
    boolean bool2 = false;
    if (!bool1)
    {
      Object localObject1;
      Object localObject2;
      if (!a0.h(this))
      {
        localObject1 = CoronaApp.z;
        if (localObject1 != null) {
          localObject1 = Boolean.valueOf(x);
        } else {
          localObject1 = null;
        }
        if (h.k.b.g.a(localObject1, Boolean.valueOf(true)))
        {
          localObject1 = getSystemService("notification");
          if (localObject1 != null)
          {
            localObject1 = (NotificationManager)localObject1;
            localObject2 = CoronaApp.z;
            if ((localObject2 != null) && (!y))
            {
              localObject2 = PendingIntent.getActivity(this, 0, new Intent(this, SplashActivity.class), 0);
              d.i.a.g localg = new d.i.a.g(this);
              localg.b(getString(2131886208));
              O.icon = 2131230888;
              localg.a(getString(2131886242));
              l = 1;
              f = ((PendingIntent)localObject2);
              localg.a(true);
              if (Build.VERSION.SDK_INT >= 26) {
                I = "Smittestopp Notification Channel";
              }
              localObject2 = localg.a();
              h.k.b.g.a(localObject2, "builder.build()");
              ((NotificationManager)localObject1).notify(13, (Notification)localObject2);
              localObject1 = CoronaApp.z;
              if (localObject1 != null) {
                y = true;
              }
            }
            h();
            g();
            stopSelf();
          }
          else
          {
            throw new h.e("null cannot be cast to non-null type android.app.NotificationManager");
          }
        }
      }
      else
      {
        localObject1 = a0.f(this);
        if ((true ^ h.o.g.b((CharSequence)localObject1)))
        {
          localObject2 = getApplication();
          h.k.b.g.a(localObject2, "this.application");
          new j.b.a.h((Application)localObject2).a((String)localObject1, new j.b.a.g());
        }
      }
      return false;
    }
    int i = F;
    if (a0.a() > E + i * 60 * 60) {
      bool2 = true;
    }
    return bool2;
  }

  public IBinder onBind(Intent paramIntent)
  {
    A = true;
    c();
    stopForeground(true);
    return z;
  }

  public void onCreate()
  {
    l.a.a.d.c("onCreate", new Object[0]);
    K = MeasurementDatabase.k.a(this);
    Object localObject1 = getApplication();
    h.k.b.g.a(localObject1, "this.application");
    localObject1 = new j.b.a.h((Application)localObject1);
    M = ((j.b.a.h)localObject1);
    if (localObject1 != null)
    {
      ((j.b.a.h)localObject1).a();
      localObject1 = e.c.a.a.e.c.a(this);
      h.k.b.g.a(localObject1, "LocationServices.getFuse…ationProviderClient(this)");
      D = ((e.c.a.a.e.a)localObject1);
      C = new DataCollectorService.b(this);
      if (Build.VERSION.SDK_INT >= 26)
      {
        NotificationChannel localNotificationChannel = new NotificationChannel("Smittestopp Notification Channel", "Smittestopp", 3);
        localObject1 = new NotificationChannel("Smittestopp Reminders", "Smittestopp Reminders", 3);
        Object localObject2 = getSystemService("notification");
        if (localObject2 != null)
        {
          localObject2 = (NotificationManager)localObject2;
          ((NotificationManager)localObject2).createNotificationChannel(localNotificationChannel);
          ((NotificationManager)localObject2).createNotificationChannel((NotificationChannel)localObject1);
        }
        else
        {
          throw new h.e("null cannot be cast to non-null type android.app.NotificationManager");
        }
      }
      G = new j.b.a.d0.a();
      localObject1 = new IntentFilter("android.location.PROVIDERS_CHANGED");
      registerReceiver(G, (IntentFilter)localObject1);
      N = new j.b.a.b0.c();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      ((IntentFilter)localObject1).addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
      ((IntentFilter)localObject1).addAction("android.bluetooth.device.action.ACL_CONNECTED");
      ((IntentFilter)localObject1).addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
      registerReceiver(N, (IntentFilter)localObject1);
      k.d.a.c.b().b(this);
      return;
    }
    h.k.b.g.b("mDevice");
    throw null;
  }

  public void onDestroy()
  {
    stopForeground(true);
    if (y) {
      h();
    }
    if (O) {
      g();
    }
    J = null;
    j.b.a.h localh = M;
    if (localh != null)
    {
      if (localh != null)
      {
        Object localObject2;
        try
        {
          localObject2 = b;
          if (localObject2 != null) {
            ((DeviceClient)localObject2).closeNow();
          }
          b = null;
          c = false;
          d = false;
          e = false;
        }
        catch (IOException localIOException)
        {
          localObject2 = new LinkedHashMap();
          ((HashMap)localObject2).put("where", "IoTHubDevice::close");
          Crashes.trackError(localIOException, (Map)localObject2, null);
          l.a.a.d.a(localIOException);
        }
        f localf = L;
        if ((localf != null) && (localf.a() == true)) {
          try
          {
            localf = L;
            if (localf != null) {
              localf.cancel(true);
            }
          }
          catch (Exception localException)
          {
            localObject2 = new LinkedHashMap();
            ((Map)localObject2).put("where", "DataCollector::onDestroy");
            Crashes.trackError(localException, (Map)localObject2, null);
          }
        }
        L = null;
        Object localObject1 = x;
        if (localObject1 != null) {
          ((v)localObject1).a();
        }
        localObject1 = G;
        if (localObject1 != null) {
          unregisterReceiver((BroadcastReceiver)localObject1);
        }
        unregisterReceiver(N);
        k.d.a.c.b().c(this);
        super.onDestroy();
        return;
      }
      throw null;
    }
    h.k.b.g.b("mDevice");
    throw null;
  }

  @m(threadMode=ThreadMode.MAIN)
  public final void onEvent(j.b.a.c0.a parama)
  {
    if (parama != null)
    {
      String str = parama.toString();
      int i = 0;
      l.a.a.d.a(str, new Object[0]);
      if (O) {
        g();
      }
      if ((a) && (I == null) && (a0.c(this)) && (!A))
      {
        int j = 2131886120;
        if (H != null)
        {
          j = 2131886180;
          i = 1;
          c();
        }
        parama = a(j);
        I = parama;
        if (i != 0) {
          H = parama;
        }
        parama = getSystemService("notification");
        if (parama != null) {
          ((NotificationManager)parama).notify(15, I);
        } else {
          throw new h.e("null cannot be cast to non-null type android.app.NotificationManager");
        }
      }
      return;
    }
    h.k.b.g.a("event");
    throw null;
  }

  @m(threadMode=ThreadMode.MAIN)
  public final void onEvent(j.b.a.c0.d paramd)
  {
    if (paramd != null)
    {
      String str = paramd.toString();
      int i = 0;
      l.a.a.d.a(str, new Object[0]);
      if (y) {
        h();
      }
      if ((a) && (H == null) && (a0.d(this)) && (!A))
      {
        int j = 2131886181;
        if (I != null)
        {
          j = 2131886180;
          i = 1;
          c();
        }
        paramd = a(j);
        H = paramd;
        if (i != 0) {
          I = paramd;
        }
        paramd = getSystemService("notification");
        if (paramd != null) {
          ((NotificationManager)paramd).notify(14, H);
        } else {
          throw new h.e("null cannot be cast to non-null type android.app.NotificationManager");
        }
      }
      return;
    }
    h.k.b.g.a("event");
    throw null;
  }

  public void onRebind(Intent paramIntent)
  {
    A = true;
    c();
    stopForeground(true);
    super.onRebind(paramIntent);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    l.a.a.d.c("onStartCommand", new Object[0]);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("from-service", false) == true))
    {
      a0.a(this, false);
      a0.b(this, false);
      h();
      g();
      stopSelf();
    }
    if ((paramIntent != null) && (paramIntent.hasExtra("service-command") == true))
    {
      paramInt1 = paramIntent.getIntExtra("service-command", -1);
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 4)
              {
                if (paramInt1 == 5)
                {
                  l.a.a.d.c("stop all updates", new Object[0]);
                  h();
                  g();
                  stopSelf();
                }
              }
              else
              {
                l.a.a.d.c("start all updates", new Object[0]);
                if (a0.d(this)) {
                  e();
                }
                if (a0.c(this)) {
                  d();
                }
                if (paramIntent.getBooleanExtra("auto_start", false)) {
                  startForeground(12, a());
                }
              }
            }
            else
            {
              l.a.a.d.c("stop bt updates", new Object[0]);
              g();
            }
          }
          else
          {
            l.a.a.d.c("start bt updates", new Object[0]);
            d();
          }
        }
        else
        {
          l.a.a.d.c("start location updates", new Object[0]);
          e();
        }
      }
      else
      {
        l.a.a.d.c("stop location updates", new Object[0]);
        h();
      }
    }
    return 2;
  }

  public boolean onUnbind(Intent paramIntent)
  {
    A = false;
    if (b()) {
      startForeground(12, a());
    }
    return true;
  }
}