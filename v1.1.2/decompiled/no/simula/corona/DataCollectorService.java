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
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.EventProperties;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import k.b.a.o;
import k.b.a.t;
import k.b.a.u.h;
import k.b.a.u.i;
import m.a.a.b;
import org.greenrobot.eventbus.ThreadMode;

public final class DataCollectorService
  extends Service
  implements h
{
  public boolean A;
  public LocationRequest B;
  public e.c.a.a.e.b C;
  public e.c.a.a.e.a D;
  public long E;
  public final int F;
  public k.b.a.x.a G;
  public Notification H;
  public Notification I;
  public Notification J;
  public k.b.a.v.a K;
  public k.b.a.c L;
  public k.b.a.e M;
  public k.b.a.u.c N;
  public boolean O;
  public k.b.a.u.a P;
  public i Q;
  public k.b.a.u.e R;
  public o x;
  public boolean y;
  public final k.b.a.a z = new k.b.a.a(this);
  
  public DataCollectorService()
  {
    LocationRequest localLocationRequest = new LocationRequest();
    LocationRequest.a(25000L);
    y = 25000L;
    if (!A) {
      z = ((25000L / 6.0D));
    }
    LocationRequest.a(20000L);
    A = true;
    z = 20000L;
    D = 40.0F;
    x = 100;
    B = localLocationRequest;
    E = t.a();
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
    i.k.b.g.a("context");
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
    i.k.b.g.a("context");
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
    d.i.a.e locale = new d.i.a.e(this);
    locale.b(getString(2131886239));
    O.icon = 2131230888;
    locale.a(getString(2131886226));
    l = 1;
    locale.a(2131230889, getString(2131886259), (PendingIntent)localObject1);
    locale.a(2131230884, getString(2131886231), (PendingIntent)localObject2);
    if (Build.VERSION.SDK_INT >= 26) {
      I = "Smittestopp Notification Channel";
    }
    localObject1 = locale.a();
    i.k.b.g.a(localObject1, "builder.build()");
    return (Notification)localObject1;
  }
  
  public final Notification a(int paramInt)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, SplashActivity.class), 0);
    Object localObject = new d.i.a.e(this);
    ((d.i.a.e)localObject).b(getString(paramInt));
    O.icon = 2131230888;
    ((d.i.a.e)localObject).a(getString(2131886246));
    l = 1;
    f = localPendingIntent;
    ((d.i.a.e)localObject).a(true);
    if (Build.VERSION.SDK_INT >= 26) {
      I = "Smittestopp Reminders";
    }
    localObject = ((d.i.a.e)localObject).a();
    i.k.b.g.a(localObject, "notification.build()");
    return (Notification)localObject;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramString != null)
    {
      if (!t.g(this))
      {
        m.a.a.d.a("no consent", new Object[0]);
        return;
      }
      if (!t.h(this))
      {
        m.a.a.d.a("no token", new Object[0]);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("found connection to ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", signal strength ");
      ((StringBuilder)localObject).append(paramInt1);
      localObject = ((StringBuilder)localObject).toString();
      m.a.a.d.c((String)localObject, new Object[0]);
      paramLong /= 'Ϩ';
      localObject = K;
      if (localObject != null)
      {
        ((k.b.a.v.a)localObject).a(new k.b.a.v.g.a(paramLong, paramString, paramInt1, paramInt2, false));
        if (i()) {
          f();
        }
        return;
      }
      i.k.b.g.b("mDatabase");
      throw null;
    }
    i.k.b.g.a("deviceId");
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
    throw new i.e("null cannot be cast to non-null type android.app.NotificationManager");
  }
  
  public final void d()
  {
    int i;
    if ((R != null) && (P != null) && (Q != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      m.a.a.d.a("Initializing bluetooth components", new Object[0]);
      localObject1 = getSystemService("bluetooth");
      if (localObject1 != null)
      {
        localObject1 = (BluetoothManager)localObject1;
        try
        {
          Object localObject2 = ((BluetoothManager)localObject1).getAdapter();
          if ((localObject2 != null) && (((BluetoothAdapter)localObject2).isEnabled() == true))
          {
            localObject2 = ((BluetoothManager)localObject1).getAdapter();
            i.k.b.g.a(localObject2, "bluetoothManager.adapter");
            if (((BluetoothAdapter)localObject2).getBluetoothLeAdvertiser() == null)
            {
              m.a.a.d.d("Le advertiser is not supported on this device", new Object[0]);
              localObject4 = new com/microsoft/appcenter/analytics/EventProperties;
              ((EventProperties)localObject4).<init>();
              ((EventProperties)localObject4).set("what", "Not supported");
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              ((StringBuilder)localObject2).append(Build.MANUFACTURER);
              ((StringBuilder)localObject2).append(' ');
              ((StringBuilder)localObject2).append(Build.MODEL);
              ((EventProperties)localObject4).set("model", ((StringBuilder)localObject2).toString());
              Analytics.trackEvent("LeAdvertise", (EventProperties)localObject4);
            }
            localObject2 = new k/b/a/u/e;
            ((k.b.a.u.e)localObject2).<init>(this, (BluetoothManager)localObject1);
            R = ((k.b.a.u.e)localObject2);
            localObject2 = new k/b/a/u/a;
            localObject1 = ((BluetoothManager)localObject1).getAdapter();
            i.k.b.g.a(localObject1, "bluetoothManager.adapter");
            ((k.b.a.u.a)localObject2).<init>(((BluetoothAdapter)localObject1).getBluetoothLeAdvertiser());
            P = ((k.b.a.u.a)localObject2);
            localObject2 = new k/b/a/u/i;
            localObject1 = getApplication();
            i.k.b.g.a(localObject1, "this.application");
            Object localObject4 = k.a.a.a.a.a.a.a();
            i.k.b.g.a(localObject4, "BluetoothLeScannerCompat.getScanner()");
            ((i)localObject2).<init>((Application)localObject1, this, (k.a.a.a.a.a.a)localObject4);
            Q = ((i)localObject2);
          }
          else
          {
            m.a.a.d.a("Bluetooth adapter is null", new Object[0]);
          }
        }
        catch (Exception localException)
        {
          localObject1 = new LinkedHashMap();
          ((HashMap)localObject1).put("where", "DataCollector::initializeBluetooth");
          Crashes.trackError(localException, (Map)localObject1, null);
        }
      }
      throw new i.e("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }
    Object localObject1 = getSystemService("bluetooth");
    if (localObject1 != null)
    {
      localObject1 = (BluetoothManager)localObject1;
      m.a.a.d.c("Starting bluetooth updates", new Object[0]);
      try
      {
        localObject1 = ((BluetoothManager)localObject1).getAdapter();
        if ((localObject1 != null) && (((BluetoothAdapter)localObject1).isEnabled() == true))
        {
          localObject1 = R;
          if (localObject1 != null)
          {
            localObject3 = new k/b/a/u/d;
            ((k.b.a.u.d)localObject3).<init>((k.b.a.u.e)localObject1);
            localObject3 = e.openGattServer(d, (BluetoothGattServerCallback)localObject3);
            if (localObject3 != null) {
              ((BluetoothGattServer)localObject3).addService(b);
            }
            c = ((BluetoothGattServer)localObject3);
          }
          localObject1 = P;
          if (localObject1 != null)
          {
            localObject3 = d;
            if (localObject3 != null) {
              ((BluetoothLeAdvertiser)localObject3).startAdvertising(b, a, c);
            }
          }
          localObject1 = Q;
          if (localObject1 != null)
          {
            b = true;
            ((i)localObject1).a();
            d.sendEmptyMessageDelayed(3, 35000L);
          }
          O = true;
          Object localObject3 = l.d.a.c.b();
          localObject1 = new k/b/a/w/b;
          ((k.b.a.w.b)localObject1).<init>(true);
          ((l.d.a.c)localObject3).a(localObject1);
          localObject1 = x;
          if (localObject1 != null) {
            ((o)localObject1).h();
          }
        }
        else
        {
          m.a.a.d.b("Bluetooth adaptor is off", new Object[0]);
        }
      }
      catch (SecurityException localSecurityException)
      {
        m.a.a.d.b("Lost bluetooth permissions", new Object[0]);
      }
      return;
    }
    throw new i.e("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
  }
  
  public final void e()
  {
    m.a.a.d.c("Starting location updates", new Object[0]);
    try
    {
      if (!k.b.a.x.a.a(this))
      {
        m.a.a.d.b("Location services are off", new Object[0]);
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
          localObject1 = l.d.a.c.b();
          localObject2 = new k/b/a/w/c;
          ((k.b.a.w.c)localObject2).<init>(true);
          ((l.d.a.c)localObject1).a(localObject2);
          localObject2 = x;
          if (localObject2 != null) {
            ((o)localObject2).b();
          }
        }
        else
        {
          i.k.b.g.b("locationCallback");
          throw null;
        }
      }
      else
      {
        i.k.b.g.b("fusedLocationClient");
        throw null;
      }
    }
    catch (SecurityException localSecurityException)
    {
      m.a.a.d.b("Lost location permissions", new Object[0]);
      Crashes.trackError(localSecurityException);
    }
  }
  
  public final void f()
  {
    Object localObject1 = L;
    if ((localObject1 != null) && (((k.b.a.c)localObject1).a() == true)) {
      return;
    }
    localObject1 = M;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      if (!c)
      {
        ((k.b.a.e)localObject1).a();
        return;
      }
      localObject1 = f;
      Object localObject3 = i.o.g.a("1.1.2", new String[] { "." }, false, 0, 6);
      if (((List)localObject3).size() >= 3)
      {
        int i = Integer.parseInt((String)((List)localObject3).get(0));
        int j = Integer.parseInt((String)((List)localObject3).get(1));
        int k = Integer.parseInt((String)((List)localObject3).get(2));
        localObject3 = i.o.g.a((CharSequence)localObject1, new String[] { "." }, false, 0, 6);
        if (((List)localObject3).size() != 3)
        {
          localObject3 = new EventProperties();
          ((EventProperties)localObject3).set("version", (String)localObject1);
          Analytics.trackEvent("Malformed version string", (EventProperties)localObject3);
        }
        else
        {
          int m = Integer.parseInt((String)((List)localObject3).get(0));
          n = Integer.parseInt((String)((List)localObject3).get(1));
          int i1 = Integer.parseInt((String)((List)localObject3).get(2));
          if ((m > i) || ((m == i) && (n > j)) || ((m == i) && (n == j) && (i1 > k))) {
            break label277;
          }
        }
      }
      int n = 0;
      break label280;
      label277:
      n = 1;
      label280:
      if ((n != 0) && (J == null))
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
        } while (!i.k.b.g.a(activityInfo.applicationInfo.packageName, "com.android.vending"));
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
        localObject2 = new d.i.a.e(this);
        ((d.i.a.e)localObject2).b(getString(2131886222));
        O.icon = 2131230888;
        ((d.i.a.e)localObject2).a(getString(2131886223));
        l = 1;
        f = ((PendingIntent)localObject1);
        ((d.i.a.e)localObject2).a(true);
        if (Build.VERSION.SDK_INT >= 26) {
          I = "Smittestopp Reminders";
        }
        J = ((d.i.a.e)localObject2).a();
        localObject1 = getSystemService("notification");
        if (localObject1 != null) {
          ((NotificationManager)localObject1).notify(16, J);
        } else {
          throw new i.e("null cannot be cast to non-null type android.app.NotificationManager");
        }
      }
      E = t.a();
      localObject1 = new k.b.a.c(this, new c(this));
      L = ((k.b.a.c)localObject1);
      ((AsyncTask)localObject1).execute(new Object[0]);
      return;
    }
    i.k.b.g.b("mDevice");
    throw null;
  }
  
  public final void g()
  {
    if (O)
    {
      m.a.a.d.c("Stopping bluetooth updates", new Object[0]);
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
            localObject1 = l.d.a.c.b();
            Object localObject2 = new k/b/a/w/b;
            ((k.b.a.w.b)localObject2).<init>(false);
            ((l.d.a.c)localObject1).a(localObject2);
          }
          catch (Exception localException)
          {
            m.a.a.d.b(localException);
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
        l.d.a.c.b().a(new k.b.a.w.b(false));
      }
      else
      {
        throw new i.e("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
      }
    }
    else
    {
      m.a.a.d.c("bluetooth is already closed", new Object[0]);
    }
  }
  
  public final void h()
  {
    if (y)
    {
      m.a.a.d.c("Stopping location updates", new Object[0]);
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
            localObject1 = x;
            if (localObject1 != null) {
              ((o)localObject1).d();
            }
            localObject1 = l.d.a.c.b();
            localObject2 = new k/b/a/w/c;
            ((k.b.a.w.c)localObject2).<init>(false);
            ((l.d.a.c)localObject1).a(localObject2);
            y = false;
            return;
          }
          i.k.b.g.b("locationCallback");
          throw null;
        }
        i.k.b.g.b("fusedLocationClient");
        throw null;
      }
      catch (SecurityException localSecurityException)
      {
        m.a.a.d.b(localSecurityException);
        Crashes.trackError(localSecurityException);
      }
    }
    m.a.a.d.c("location services already closed", new Object[0]);
  }
  
  public final boolean i()
  {
    int i = F;
    int j = ThreadLocalRandom.current().nextInt(-10, 10);
    long l1 = t.a();
    long l2 = E;
    long l3 = i * 60 * 60;
    long l4 = j * 60;
    boolean bool = true;
    if (l1 > l2 + l3 + l4) {
      i = 1;
    } else {
      i = 0;
    }
    if (l1 > E + l3) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (!t.k(this)))
    {
      Object localObject1;
      Object localObject2;
      if (!t.i(this))
      {
        localObject1 = CoronaApp.z;
        if (localObject1 != null) {
          localObject1 = Boolean.valueOf(x);
        } else {
          localObject1 = null;
        }
        if (i.k.b.g.a(localObject1, Boolean.valueOf(true)))
        {
          localObject1 = getSystemService("notification");
          if (localObject1 != null)
          {
            localObject1 = (NotificationManager)localObject1;
            localObject2 = CoronaApp.z;
            if ((localObject2 != null) && (!y))
            {
              PendingIntent localPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, SplashActivity.class), 0);
              localObject2 = new d.i.a.e(this);
              ((d.i.a.e)localObject2).b(getString(2131886239));
              O.icon = 2131230888;
              ((d.i.a.e)localObject2).a(getString(2131886274));
              l = 1;
              f = localPendingIntent;
              ((d.i.a.e)localObject2).a(true);
              if (Build.VERSION.SDK_INT >= 26) {
                I = "Smittestopp Notification Channel";
              }
              localObject2 = ((d.i.a.e)localObject2).a();
              i.k.b.g.a(localObject2, "builder.build()");
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
            throw new i.e("null cannot be cast to non-null type android.app.NotificationManager");
          }
        }
      }
      else
      {
        E = t.a();
        localObject2 = t.f(this);
        if ((true ^ i.o.g.b((CharSequence)localObject2)))
        {
          localObject1 = getApplication();
          i.k.b.g.a(localObject1, "this.application");
          new k.b.a.e((Application)localObject1).a((String)localObject2, new k.b.a.d());
        }
      }
      return false;
    }
    if ((j == 0) || (!t.k(this))) {
      bool = false;
    }
    return bool;
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
    m.a.a.d.c("onCreate", new Object[0]);
    K = k.b.a.v.b.a(this);
    Object localObject1 = getApplication();
    i.k.b.g.a(localObject1, "this.application");
    localObject1 = new k.b.a.e((Application)localObject1);
    M = ((k.b.a.e)localObject1);
    ((k.b.a.e)localObject1).a();
    localObject1 = e.c.a.a.e.c.a(this);
    i.k.b.g.a(localObject1, "LocationServices.getFuse…ationProviderClient(this)");
    D = ((e.c.a.a.e.a)localObject1);
    C = new b(this);
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
        throw new i.e("null cannot be cast to non-null type android.app.NotificationManager");
      }
    }
    G = new k.b.a.x.a();
    localObject1 = new IntentFilter("android.location.PROVIDERS_CHANGED");
    registerReceiver(G, (IntentFilter)localObject1);
    N = new k.b.a.u.c();
    localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    ((IntentFilter)localObject1).addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    ((IntentFilter)localObject1).addAction("android.bluetooth.device.action.ACL_CONNECTED");
    ((IntentFilter)localObject1).addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    registerReceiver(N, (IntentFilter)localObject1);
    l.d.a.c.b().b(this);
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
    Object localObject1 = M;
    if (localObject1 != null)
    {
      if (localObject1 != null)
      {
        try
        {
          DeviceClient localDeviceClient = b;
          if (localDeviceClient != null) {
            localDeviceClient.closeNow();
          }
          b = null;
          c = false;
          d = false;
          e = false;
        }
        catch (IOException localIOException)
        {
          localObject1 = new LinkedHashMap();
          ((HashMap)localObject1).put("where", "IoTHubDevice::close");
          Crashes.trackError(localIOException, (Map)localObject1, null);
          m.a.a.d.b(localIOException);
        }
        Object localObject2 = L;
        if ((localObject2 != null) && (((k.b.a.c)localObject2).a() == true)) {
          try
          {
            localObject2 = L;
            if (localObject2 != null) {
              ((AsyncTask)localObject2).cancel(true);
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
        localObject2 = x;
        if (localObject2 != null) {
          ((o)localObject2).f();
        }
        localObject2 = G;
        if (localObject2 != null) {
          unregisterReceiver((BroadcastReceiver)localObject2);
        }
        unregisterReceiver(N);
        l.d.a.c.b().c(this);
        localObject2 = K;
        if (localObject2 != null)
        {
          ((k.b.a.v.a)localObject2).close();
          super.onDestroy();
          return;
        }
        i.k.b.g.b("mDatabase");
        throw null;
      }
      throw null;
    }
    i.k.b.g.b("mDevice");
    throw null;
  }
  
  @l.d.a.m(threadMode=ThreadMode.MAIN)
  public final void onEvent(k.b.a.w.a parama)
  {
    if (parama != null)
    {
      String str = parama.toString();
      int i = 0;
      m.a.a.d.a(str, new Object[0]);
      if (O) {
        g();
      }
      if ((a) && (I == null) && (t.c(this)) && (!A))
      {
        int j = 2131886135;
        if (H != null)
        {
          j = 2131886208;
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
          throw new i.e("null cannot be cast to non-null type android.app.NotificationManager");
        }
      }
      return;
    }
    i.k.b.g.a("event");
    throw null;
  }
  
  @l.d.a.m(threadMode=ThreadMode.MAIN)
  public final void onEvent(k.b.a.w.d paramd)
  {
    if (paramd != null)
    {
      String str = paramd.toString();
      int i = 0;
      m.a.a.d.a(str, new Object[0]);
      if (y) {
        h();
      }
      if ((a) && (H == null) && (t.d(this)) && (!A))
      {
        int j = 2131886209;
        if (I != null)
        {
          j = 2131886208;
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
          throw new i.e("null cannot be cast to non-null type android.app.NotificationManager");
        }
      }
      return;
    }
    i.k.b.g.a("event");
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
    m.a.a.d.c("onStartCommand", new Object[0]);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("from-service", false) == true))
    {
      t.b(this, false);
      t.c(this, false);
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
                  m.a.a.d.c("stop all updates", new Object[0]);
                  h();
                  g();
                  stopSelf();
                }
              }
              else
              {
                m.a.a.d.c("start all updates", new Object[0]);
                if (t.d(this)) {
                  e();
                }
                if (t.c(this)) {
                  d();
                }
                if (paramIntent.getBooleanExtra("auto_start", false)) {
                  startForeground(12, a());
                }
              }
            }
            else
            {
              m.a.a.d.c("stop bt updates", new Object[0]);
              g();
            }
          }
          else
          {
            m.a.a.d.c("start bt updates", new Object[0]);
            d();
          }
        }
        else
        {
          m.a.a.d.c("start location updates", new Object[0]);
          e();
        }
      }
      else
      {
        m.a.a.d.c("stop location updates", new Object[0]);
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
  
  public final class a
    implements IotHubEventCallback
  {
    public final String a;
    public final List<Long> b;
    
    public a(List<Long> paramList) {}
    
    public void execute(IotHubStatusCode paramIotHubStatusCode, Object paramObject)
    {
      if (paramIotHubStatusCode != null)
      {
        int i = paramIotHubStatusCode.ordinal();
        if ((i == 0) || (i == 1)) {
          break label90;
        }
        if (i == 5) {}
      }
      else
      {
        paramObject = e.a.a.a.a.a("Uploaded failed because ");
        if (paramIotHubStatusCode != null)
        {
          paramIotHubStatusCode = paramIotHubStatusCode.name();
          if (paramIotHubStatusCode != null) {}
        }
        else
        {
          paramIotHubStatusCode = "N/A";
        }
        ((StringBuilder)paramObject).append(paramIotHubStatusCode);
        paramIotHubStatusCode = ((StringBuilder)paramObject).toString();
        Analytics.trackEvent(paramIotHubStatusCode);
        m.a.a.d.b(paramIotHubStatusCode, new Object[0]);
        break label131;
      }
      DataCollectorService.a(DataCollectorService.this);
      break label131;
      label90:
      paramIotHubStatusCode = e.a.a.a.a.a(e.a.a.a.a.a("Uploaded "), a, " data, OK, OK_EMPTY");
      m.a.a.d.c(paramIotHubStatusCode, new Object[0]);
      DataCollectorService.a(DataCollectorService.this, a, b);
      label131:
      L = null;
    }
  }
  
  public static final class b
    extends e.c.a.a.e.b
  {
    public void a(LocationResult paramLocationResult)
    {
      if (paramLocationResult == null)
      {
        m.a.a.d.c("Location result is null", new Object[0]);
        return;
      }
      Iterator localIterator = x.iterator();
      while (localIterator.hasNext())
      {
        paramLocationResult = (Location)localIterator.next();
        DataCollectorService localDataCollectorService = a;
        i.k.b.g.a(paramLocationResult, "location");
        DataCollectorService.a(localDataCollectorService, paramLocationResult);
      }
    }
  }
  
  public static final class c
    implements k.b.a.b
  {
    public void a(k.b.a.m paramm)
    {
      if (paramm == null) {
        return;
      }
      DataCollectorService.a(a, "gps", a);
      DataCollectorService.a(a, "bluetooth", b);
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.DataCollectorService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */