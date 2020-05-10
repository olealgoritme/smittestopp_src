package d.i.a;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

public class g
{
  public String A;
  public Bundle B;
  public int C = 0;
  public int D = 0;
  public Notification E;
  public RemoteViews F;
  public RemoteViews G;
  public RemoteViews H;
  public String I;
  public int J = 0;
  public String K;
  public long L;
  public int M = 0;
  public boolean N;
  public Notification O;
  @Deprecated
  public ArrayList<String> P;
  public Context a;
  public ArrayList<e> b = new ArrayList();
  public ArrayList<e> c = new ArrayList();
  public CharSequence d;
  public CharSequence e;
  public PendingIntent f;
  public PendingIntent g;
  public RemoteViews h;
  public Bitmap i;
  public CharSequence j;
  public int k;
  public int l;
  public boolean m = true;
  public boolean n;
  public h o;
  public CharSequence p;
  public CharSequence[] q;
  public int r;
  public int s;
  public boolean t;
  public String u;
  public boolean v;
  public String w;
  public boolean x = false;
  public boolean y;
  public boolean z;
  
  @Deprecated
  public g(Context paramContext)
  {
    Notification localNotification = new Notification();
    O = localNotification;
    a = paramContext;
    I = null;
    when = System.currentTimeMillis();
    O.audioStreamType = -1;
    l = 0;
    P = new ArrayList();
    N = true;
  }
  
  public static CharSequence c(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return paramCharSequence;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() > 5120) {
      localCharSequence = paramCharSequence.subSequence(0, 5120);
    }
    return localCharSequence;
  }
  
  public Notification a()
  {
    new ArrayList();
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 26) {
      localObject1 = new Notification.Builder(a, I);
    } else {
      localObject1 = new Notification.Builder(a);
    }
    Object localObject2 = O;
    Object localObject3 = ((Notification.Builder)localObject1).setWhen(when).setSmallIcon(icon, iconLevel).setContent(contentView).setTicker(tickerText, h).setVibrate(vibrate).setLights(ledARGB, ledOnMS, ledOffMS);
    boolean bool;
    if ((flags & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject3 = ((Notification.Builder)localObject3).setOngoing(bool);
    if ((flags & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject3 = ((Notification.Builder)localObject3).setOnlyAlertOnce(bool);
    if ((flags & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject3 = ((Notification.Builder)localObject3).setAutoCancel(bool).setDefaults(defaults).setContentTitle(d).setContentText(e).setContentInfo(j).setContentIntent(f).setDeleteIntent(deleteIntent);
    Object localObject4 = g;
    if ((flags & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((Notification.Builder)localObject3).setFullScreenIntent((PendingIntent)localObject4, bool).setLargeIcon(i).setNumber(k).setProgress(r, s, t);
    ((Notification.Builder)localObject1).setSubText(p).setUsesChronometer(n).setPriority(l);
    Object localObject5 = b.iterator();
    Object localObject7;
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (e)((Iterator)localObject5).next();
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (b == null)
        {
          i1 = i;
          if (i1 != 0) {
            b = IconCompat.a(null, "", i1);
          }
        }
        localObject3 = b;
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((IconCompat)localObject3).c();
        }
        localObject3 = new Notification.Action.Builder((Icon)localObject3, j, k);
      }
      else
      {
        localObject3 = new Notification.Action.Builder(i, j, k);
      }
      localObject4 = c;
      if (localObject4 != null)
      {
        localObject7 = new RemoteInput[localObject4.length];
        if (localObject4.length <= 0)
        {
          i2 = localObject7.length;
          for (i1 = 0; i1 < i2; i1++) {
            ((Notification.Action.Builder)localObject3).addRemoteInput(localObject7[i1]);
          }
        }
        localObject1 = localObject4[0];
        localObject1 = new android/app/RemoteInput$Builder;
        throw null;
      }
      if (a != null) {
        localObject4 = new Bundle(a);
      } else {
        localObject4 = new Bundle();
      }
      ((Bundle)localObject4).putBoolean("android.support.allowGeneratedReplies", e);
      if (Build.VERSION.SDK_INT >= 24) {
        ((Notification.Action.Builder)localObject3).setAllowGeneratedReplies(e);
      }
      ((Bundle)localObject4).putInt("android.support.action.semanticAction", g);
      if (Build.VERSION.SDK_INT >= 28) {
        ((Notification.Action.Builder)localObject3).setSemanticAction(g);
      }
      if (Build.VERSION.SDK_INT >= 29) {
        ((Notification.Action.Builder)localObject3).setContextual(h);
      }
      ((Bundle)localObject4).putBoolean("android.support.action.showsUserInterface", f);
      ((Notification.Action.Builder)localObject3).addExtras((Bundle)localObject4);
      ((Notification.Builder)localObject1).addAction(((Notification.Action.Builder)localObject3).build());
    }
    localObject3 = B;
    if (localObject3 != null) {
      localBundle.putAll((Bundle)localObject3);
    }
    localObject5 = F;
    Object localObject6 = G;
    ((Notification.Builder)localObject1).setShowWhen(m);
    ((Notification.Builder)localObject1).setLocalOnly(x).setGroup(u).setGroupSummary(v).setSortKey(w);
    int i2 = M;
    ((Notification.Builder)localObject1).setCategory(A).setColor(C).setVisibility(D).setPublicVersion(E).setSound(sound, audioAttributes);
    localObject3 = P.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Notification.Builder)localObject1).addPerson((String)((Iterator)localObject3).next());
    }
    localObject2 = H;
    if (c.size() > 0)
    {
      if (B == null) {
        B = new Bundle();
      }
      localObject4 = B.getBundle("android.car.EXTENSIONS");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new Bundle();
      }
      localObject4 = new Bundle();
      for (i1 = 0; i1 < c.size(); i1++) {
        ((Bundle)localObject4).putBundle(Integer.toString(i1), i.a((e)c.get(i1)));
      }
      ((Bundle)localObject3).putBundle("invisible_actions", (Bundle)localObject4);
      if (B == null) {
        B = new Bundle();
      }
      B.putBundle("android.car.EXTENSIONS", (Bundle)localObject3);
      localBundle.putBundle("android.car.EXTENSIONS", (Bundle)localObject3);
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      ((Notification.Builder)localObject1).setExtras(B).setRemoteInputHistory(q);
      localObject3 = F;
      if (localObject3 != null) {
        ((Notification.Builder)localObject1).setCustomContentView((RemoteViews)localObject3);
      }
      localObject3 = G;
      if (localObject3 != null) {
        ((Notification.Builder)localObject1).setCustomBigContentView((RemoteViews)localObject3);
      }
      localObject3 = H;
      if (localObject3 != null) {
        ((Notification.Builder)localObject1).setCustomHeadsUpContentView((RemoteViews)localObject3);
      }
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      ((Notification.Builder)localObject1).setBadgeIconType(J).setShortcutId(K).setTimeoutAfter(L).setGroupAlertBehavior(M);
      if (z) {
        ((Notification.Builder)localObject1).setColorized(y);
      }
      if (!TextUtils.isEmpty(I)) {
        ((Notification.Builder)localObject1).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      ((Notification.Builder)localObject1).setAllowSystemGeneratedContextualActions(N);
      ((Notification.Builder)localObject1).setBubbleMetadata(null);
    }
    localObject4 = o;
    if (localObject4 != null)
    {
      localObject7 = (f)localObject4;
      localObject3 = new Notification.BigTextStyle((Notification.Builder)localObject1).setBigContentTitle(null).bigText(c);
      if (b) {
        ((Notification.BigTextStyle)localObject3).setSummaryText(null);
      }
    }
    int i1 = Build.VERSION.SDK_INT;
    if (i1 >= 26)
    {
      localObject1 = ((Notification.Builder)localObject1).build();
    }
    else if (i1 >= 24)
    {
      localObject3 = ((Notification.Builder)localObject1).build();
      localObject1 = localObject3;
      if (i2 != 0)
      {
        if ((((Notification)localObject3).getGroup() != null) && ((flags & 0x200) != 0) && (i2 == 2))
        {
          sound = null;
          vibrate = null;
          i1 = defaults & 0xFFFFFFFE;
          defaults = i1;
          defaults = (i1 & 0xFFFFFFFD);
        }
        localObject1 = localObject3;
        if (((Notification)localObject3).getGroup() != null)
        {
          localObject1 = localObject3;
          if ((flags & 0x200) == 0)
          {
            localObject1 = localObject3;
            if (i2 == 1)
            {
              sound = null;
              vibrate = null;
              i1 = defaults & 0xFFFFFFFE;
              defaults = i1;
              defaults = (i1 & 0xFFFFFFFD);
              localObject1 = localObject3;
            }
          }
        }
      }
    }
    else
    {
      ((Notification.Builder)localObject1).setExtras(localBundle);
      localObject3 = ((Notification.Builder)localObject1).build();
      if (localObject5 != null) {
        contentView = ((RemoteViews)localObject5);
      }
      if (localObject6 != null) {
        bigContentView = ((RemoteViews)localObject6);
      }
      if (localObject2 != null) {
        headsUpContentView = ((RemoteViews)localObject2);
      }
      localObject1 = localObject3;
      if (i2 != 0)
      {
        if ((((Notification)localObject3).getGroup() != null) && ((flags & 0x200) != 0) && (i2 == 2))
        {
          sound = null;
          vibrate = null;
          i1 = defaults & 0xFFFFFFFE;
          defaults = i1;
          defaults = (i1 & 0xFFFFFFFD);
        }
        localObject1 = localObject3;
        if (((Notification)localObject3).getGroup() != null)
        {
          localObject1 = localObject3;
          if ((flags & 0x200) == 0)
          {
            localObject1 = localObject3;
            if (i2 == 1)
            {
              sound = null;
              vibrate = null;
              i1 = defaults & 0xFFFFFFFE;
              defaults = i1;
              defaults = (i1 & 0xFFFFFFFD);
              localObject1 = localObject3;
            }
          }
        }
      }
    }
    localObject3 = F;
    if (localObject3 != null) {
      contentView = ((RemoteViews)localObject3);
    }
    if ((localObject4 != null) && (o == null)) {
      throw null;
    }
    if (localObject4 != null) {
      localObject3 = extras;
    }
    return (Notification)localObject1;
  }
  
  public g a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    b.add(new e(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }
  
  public g a(h paramh)
  {
    if (o != paramh)
    {
      o = paramh;
      if ((paramh != null) && (a != this))
      {
        a = this;
        a(paramh);
      }
    }
    return this;
  }
  
  public g a(CharSequence paramCharSequence)
  {
    e = c(paramCharSequence);
    return this;
  }
  
  public g a(boolean paramBoolean)
  {
    Notification localNotification;
    if (paramBoolean)
    {
      localNotification = O;
      flags |= 0x10;
    }
    else
    {
      localNotification = O;
      flags &= 0xFFFFFFEF;
    }
    return this;
  }
  
  public g b(CharSequence paramCharSequence)
  {
    d = c(paramCharSequence);
    return this;
  }
}

/* Location:
 * Qualified Name:     base.d.i.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */