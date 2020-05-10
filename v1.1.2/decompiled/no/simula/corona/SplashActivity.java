package no.simula.corona;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.scottyab.rootbeer.RootBeerNative;
import d.b.a.h;
import e.f.a.b;
import i.e;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import k.b.a.r;
import k.b.a.s;
import k.b.a.t;

public final class SplashActivity
  extends k.b.a.z.a
{
  public final int A = 1;
  public final int B = 2;
  
  public final void a(int paramInt)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(2131886124);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("This app cannot run on this system. Error code: ");
    localStringBuilder.append(paramInt);
    localBuilder.setMessage(localStringBuilder.toString());
    localBuilder.setPositiveButton(2131886227, new b(this, paramInt));
    localBuilder.setOnDismissListener(new c(this, paramInt));
    localBuilder.create();
    localBuilder.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558433);
    paramBundle = Build.FINGERPRINT;
    i.k.b.g.a(paramBundle, "Build.FINGERPRINT");
    if (i.o.g.a(paramBundle, "generic", false, 2))
    {
      k.b.a.y.a.a("fingerprint generic");
    }
    else
    {
      paramBundle = Build.FINGERPRINT;
      i.k.b.g.a(paramBundle, "Build.FINGERPRINT");
      if (i.o.g.a(paramBundle, "unknown", false, 2))
      {
        k.b.a.y.a.a("fingerprint unknown");
      }
      else
      {
        paramBundle = Build.MODEL;
        i.k.b.g.a(paramBundle, "Build.MODEL");
        if (i.o.g.a(paramBundle, "google_sdk", false, 2))
        {
          k.b.a.y.a.a("model contain google_sdk");
        }
        else
        {
          paramBundle = Build.MODEL;
          i.k.b.g.a(paramBundle, "Build.MODEL");
          if (i.o.g.a(paramBundle, "Emulator", false, 2))
          {
            k.b.a.y.a.a("model contains Emulator");
          }
          else
          {
            paramBundle = Build.MODEL;
            i.k.b.g.a(paramBundle, "Build.MODEL");
            if (i.o.g.a(paramBundle, "Android SDK built for x86", false, 2))
            {
              k.b.a.y.a.a("model contains Android SDK built for x86");
            }
            else
            {
              paramBundle = Build.MANUFACTURER;
              i.k.b.g.a(paramBundle, "Build.MANUFACTURER");
              if (i.o.g.a(paramBundle, "Genymotion", false, 2))
              {
                k.b.a.y.a.a("manufacturer contains Genymotion");
              }
              else
              {
                if (!i.k.b.g.a("google_sdk", Build.PRODUCT)) {
                  break label206;
                }
                k.b.a.y.a.a("product is google_sdk");
              }
            }
          }
        }
      }
    }
    int i = 1;
    break label208;
    label206:
    i = 0;
    label208:
    if (i != 0)
    {
      a(A);
      return;
    }
    Object localObject1 = new b(this);
    Object localObject2 = new ArrayList(Arrays.asList(e.f.a.a.a));
    paramBundle = a.getPackageManager();
    localObject2 = ((ArrayList)localObject2).iterator();
    i = 0;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      try
      {
        paramBundle.getPackageInfo(str1, 0);
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>();
        ((StringBuilder)localObject4).append(str1);
        ((StringBuilder)localObject4).append(" ROOT management app detected!");
        e.f.a.c.a.a(((StringBuilder)localObject4).toString());
        i = 1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
    if (i != 0)
    {
      k.b.a.y.a.b("root:detectRootManagementApps failed");
    }
    else if (((b)localObject1).a("su"))
    {
      k.b.a.y.a.b("root:checkForBinarySu fialed");
    }
    else
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("ro.debuggable", "1");
      ((HashMap)localObject2).put("ro.secure", "0");
      Object localObject3;
      try
      {
        localObject3 = Runtime.getRuntime().exec("getprop").getInputStream();
        if (localObject3 == null) {
          break label463;
        }
        paramBundle = new java/util/Scanner;
        paramBundle.<init>((InputStream)localObject3);
        paramBundle = paramBundle.useDelimiter("\\A").next().split("\n");
      }
      catch (NoSuchElementException paramBundle) {}catch (IOException paramBundle) {}
      paramBundle.printStackTrace();
      label463:
      paramBundle = null;
      int j;
      int k;
      Object localObject5;
      String str2;
      StringBuilder localStringBuilder;
      if (paramBundle == null)
      {
        i = 0;
      }
      else
      {
        j = paramBundle.length;
        k = 0;
        i = 0;
        while (k < j)
        {
          localObject3 = paramBundle[k];
          localObject4 = ((HashMap)localObject2).keySet().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            if (((String)localObject3).contains((CharSequence)localObject5))
            {
              str2 = e.a.a.a.a.a("[", (String)((HashMap)localObject2).get(localObject5), "]");
              if (((String)localObject3).contains(str2))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append((String)localObject5);
                localStringBuilder.append(" = ");
                localStringBuilder.append(str2);
                localStringBuilder.append(" detected!");
                e.f.a.c.a.b(localStringBuilder.toString());
                i = 1;
              }
            }
          }
          k++;
        }
      }
      if (i != 0)
      {
        k.b.a.y.a.b("root:checkForDangerousProps failed");
      }
      else
      {
        try
        {
          localObject2 = Runtime.getRuntime().exec("mount").getInputStream();
          if (localObject2 == null) {
            break label707;
          }
          paramBundle = new java/util/Scanner;
          paramBundle.<init>((InputStream)localObject2);
          paramBundle = paramBundle.useDelimiter("\\A").next().split("\n");
        }
        catch (NoSuchElementException paramBundle) {}catch (IOException paramBundle) {}
        paramBundle.printStackTrace();
        label707:
        paramBundle = null;
        if (paramBundle == null)
        {
          i = 0;
        }
        else
        {
          k = paramBundle.length;
          int m = 0;
          i = 0;
          while (m < k)
          {
            localObject2 = paramBundle[m];
            localObject4 = ((String)localObject2).split(" ");
            if (localObject4.length < 4)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Error formatting mount line: ");
              ((StringBuilder)localObject3).append((String)localObject2);
              e.f.a.c.a.a(((StringBuilder)localObject3).toString());
            }
            else
            {
              localObject3 = localObject4[1];
              localStringBuilder = localObject4[3];
              localObject4 = e.f.a.a.c;
              int n = localObject4.length;
              int i1 = 0;
              while (i1 < n)
              {
                str2 = localObject4[i1];
                if (((String)localObject3).equalsIgnoreCase(str2))
                {
                  localObject5 = localStringBuilder.split(",");
                  int i2 = localObject5.length;
                  int i3 = 0;
                  j = i;
                  i = k;
                  for (;;)
                  {
                    i4 = j;
                    k = i;
                    if (i3 >= i2) {
                      break;
                    }
                    if (localObject5[i3].equalsIgnoreCase("rw"))
                    {
                      localObject5 = new StringBuilder();
                      ((StringBuilder)localObject5).append(str2);
                      ((StringBuilder)localObject5).append(" path is mounted with rw permissions! ");
                      ((StringBuilder)localObject5).append((String)localObject2);
                      e.f.a.c.a.b(((StringBuilder)localObject5).toString());
                      j = 1;
                      break label959;
                    }
                    i3++;
                  }
                }
                int i4 = i;
                j = i4;
                i = k;
                label959:
                i1++;
                k = i;
                i = j;
              }
            }
            m++;
          }
        }
        if (i != 0)
        {
          k.b.a.y.a.b("root:checkForRWPaths failed");
        }
        else
        {
          paramBundle = new com/scottyab/rootbeer/RootBeerNative;
          if (!RootBeerNative.a)
          {
            e.f.a.c.a.a("We could not load the native library to test for root");
          }
          else
          {
            localObject2 = e.f.a.a.a();
            k = localObject2.length;
            paramBundle = new String[k];
            for (i = 0; i < k; i++) {
              paramBundle[i] = e.a.a.a.a.a(new StringBuilder(), localObject2[i], "su");
            }
            localObject2 = new RootBeerNative();
          }
        }
      }
    }
    try
    {
      ((RootBeerNative)localObject2).setLogDebugMessages(b);
      i = ((RootBeerNative)localObject2).checkForRoot(paramBundle);
      if (i > 0) {
        i = 1;
      }
    }
    catch (UnsatisfiedLinkError paramBundle)
    {
      long l;
      for (;;) {}
    }
    i = 0;
    if (i != 0)
    {
      k.b.a.y.a.b("root:checkForRootNative failed");
    }
    else
    {
      if (!((b)localObject1).a("magisk")) {
        break label1130;
      }
      k.b.a.y.a.b("root:checkForMagiskBinary failed");
    }
    i = 1;
    break label1132;
    label1130:
    i = 0;
    label1132:
    if (i != 0)
    {
      a(B);
      return;
    }
    paramBundle = getSystemService("notification");
    if (paramBundle != null)
    {
      paramBundle = (NotificationManager)paramBundle;
      localObject1 = CoronaApp.z;
      if (localObject1 != null) {
        y = false;
      }
      paramBundle.cancel(13);
      if (getIntent().getBooleanExtra("remote-delete", false))
      {
        paramBundle = new AlertDialog.Builder(this);
        paramBundle.setTitle(2131886124);
        paramBundle.setMessage(2131886172);
        paramBundle.setPositiveButton(17039370, new r(this));
        paramBundle.setOnDismissListener(new s(this));
        paramBundle.create();
        paramBundle.show();
        return;
      }
      paramBundle = new a(this);
      if (t.j(this)) {
        l = 2000L;
      } else {
        l = 1000L;
      }
      paramBundle.sendEmptyMessageDelayed(0, l);
      return;
    }
    throw new e("null cannot be cast to non-null type android.app.NotificationManager");
  }
  
  @SuppressLint({"HandlerLeak"})
  public static final class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage != null)
      {
        super.handleMessage(paramMessage);
        if (!a.isFinishing()) {
          SplashActivity.b(a);
        }
        return;
      }
      i.k.b.g.a("msg");
      throw null;
    }
  }
  
  public static final class b
    implements DialogInterface.OnClickListener
  {
    public b(SplashActivity paramSplashActivity, int paramInt) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      x.finishAffinity();
    }
  }
  
  public static final class c
    implements DialogInterface.OnDismissListener
  {
    public c(SplashActivity paramSplashActivity, int paramInt) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      x.finishAffinity();
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.SplashActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */