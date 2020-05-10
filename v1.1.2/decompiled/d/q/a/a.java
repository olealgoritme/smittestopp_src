package d.q.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class a
{
  public static final Object f = new Object();
  public static a g;
  public final Context a;
  public final HashMap<BroadcastReceiver, ArrayList<c>> b = new HashMap();
  public final HashMap<String, ArrayList<c>> c = new HashMap();
  public final ArrayList<b> d = new ArrayList();
  public final Handler e;
  
  public a(Context paramContext)
  {
    a = paramContext;
    e = new a(paramContext.getMainLooper());
  }
  
  public static a a(Context paramContext)
  {
    synchronized (f)
    {
      if (g == null)
      {
        a locala = new d/q/a/a;
        locala.<init>(paramContext.getApplicationContext());
        g = locala;
      }
      paramContext = g;
      return paramContext;
    }
  }
  
  public void a()
  {
    synchronized (b)
    {
      int i;
      b[] arrayOfb;
      int j;
      do
      {
        i = d.size();
        if (i <= 0) {
          return;
        }
        arrayOfb = new b[i];
        d.toArray(arrayOfb);
        d.clear();
        j = 0;
      } while (j >= i);
      b localb = arrayOfb[j];
      int k = b.size();
      for (int m = 0; m < k; m++)
      {
        ??? = (c)b.get(m);
        if (!d) {
          b.onReceive(a, a);
        }
      }
      j++;
    }
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver)
  {
    synchronized (b)
    {
      ArrayList localArrayList1 = (ArrayList)b.remove(paramBroadcastReceiver);
      if (localArrayList1 == null) {
        return;
      }
      for (int i = localArrayList1.size() - 1; i >= 0; i--)
      {
        c localc1 = (c)localArrayList1.get(i);
        d = true;
        for (int j = 0; j < a.countActions(); j++)
        {
          String str = a.getAction(j);
          ArrayList localArrayList2 = (ArrayList)c.get(str);
          if (localArrayList2 != null)
          {
            for (int k = localArrayList2.size() - 1; k >= 0; k--)
            {
              c localc2 = (c)localArrayList2.get(k);
              if (b == paramBroadcastReceiver)
              {
                d = true;
                localArrayList2.remove(k);
              }
            }
            if (localArrayList2.size() <= 0) {
              c.remove(str);
            }
          }
        }
      }
      return;
    }
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (b)
    {
      c localc = new d/q/a/a$c;
      localc.<init>(paramIntentFilter, paramBroadcastReceiver);
      Object localObject1 = (ArrayList)b.get(paramBroadcastReceiver);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>(1);
        b.put(paramBroadcastReceiver, localObject2);
      }
      ((ArrayList)localObject2).add(localc);
      for (int i = 0; i < paramIntentFilter.countActions(); i++)
      {
        localObject1 = paramIntentFilter.getAction(i);
        localObject2 = (ArrayList)c.get(localObject1);
        paramBroadcastReceiver = (BroadcastReceiver)localObject2;
        if (localObject2 == null)
        {
          paramBroadcastReceiver = new java/util/ArrayList;
          paramBroadcastReceiver.<init>(1);
          c.put(localObject1, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localc);
      }
      return;
    }
  }
  
  public boolean a(Intent paramIntent)
  {
    synchronized (b)
    {
      String str1 = paramIntent.getAction();
      Object localObject1 = paramIntent.resolveTypeIfNeeded(a.getContentResolver());
      Uri localUri = paramIntent.getData();
      String str2 = paramIntent.getScheme();
      Set localSet = paramIntent.getCategories();
      int i;
      if ((paramIntent.getFlags() & 0x8) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject2;
      if (i != 0)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("Resolving type ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" scheme ");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(" of intent ");
        ((StringBuilder)localObject2).append(paramIntent);
        Log.v("LocalBroadcastManager", ((StringBuilder)localObject2).toString());
      }
      ArrayList localArrayList = (ArrayList)c.get(paramIntent.getAction());
      if (localArrayList != null)
      {
        if (i != 0)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          ((StringBuilder)localObject2).append("Action list: ");
          ((StringBuilder)localObject2).append(localArrayList);
          Log.v("LocalBroadcastManager", ((StringBuilder)localObject2).toString());
        }
        Object localObject3 = null;
        for (int j = 0; j < localArrayList.size(); j++)
        {
          Object localObject4 = (c)localArrayList.get(j);
          if (i != 0)
          {
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            ((StringBuilder)localObject2).append("Matching against filter ");
            ((StringBuilder)localObject2).append(a);
            Log.v("LocalBroadcastManager", ((StringBuilder)localObject2).toString());
          }
          if (c)
          {
            if (i != 0) {
              Log.v("LocalBroadcastManager", "  Filter's target already added");
            }
          }
          else
          {
            IntentFilter localIntentFilter = a;
            localObject2 = localObject3;
            int k = localIntentFilter.match(str1, (String)localObject1, str2, localUri, localSet, "LocalBroadcastManager");
            if (k >= 0)
            {
              if (i != 0)
              {
                localObject3 = new java/lang/StringBuilder;
                ((StringBuilder)localObject3).<init>();
                ((StringBuilder)localObject3).append("  Filter matched!  match=0x");
                ((StringBuilder)localObject3).append(Integer.toHexString(k));
                Log.v("LocalBroadcastManager", ((StringBuilder)localObject3).toString());
              }
              if (localObject2 == null)
              {
                localObject3 = new java/util/ArrayList;
                ((ArrayList)localObject3).<init>();
              }
              else
              {
                localObject3 = localObject2;
              }
              ((ArrayList)localObject3).add(localObject4);
              c = true;
            }
            else if (i != 0)
            {
              if (k != -4)
              {
                if (k != -3)
                {
                  if (k != -2)
                  {
                    if (k != -1) {
                      localObject2 = "unknown reason";
                    } else {
                      localObject2 = "type";
                    }
                  }
                  else {
                    localObject2 = "data";
                  }
                }
                else {
                  localObject2 = "action";
                }
              }
              else {
                localObject2 = "category";
              }
              localObject4 = new java/lang/StringBuilder;
              ((StringBuilder)localObject4).<init>();
              ((StringBuilder)localObject4).append("  Filter did not match: ");
              ((StringBuilder)localObject4).append((String)localObject2);
              Log.v("LocalBroadcastManager", ((StringBuilder)localObject4).toString());
            }
          }
        }
        if (localObject3 != null)
        {
          for (i = 0; i < ((ArrayList)localObject3).size(); i++) {
            getc = false;
          }
          localObject2 = d;
          localObject1 = new d/q/a/a$b;
          ((b)localObject1).<init>(paramIntent, (ArrayList)localObject3);
          ((ArrayList)localObject2).add(localObject1);
          if (!e.hasMessages(1)) {
            e.sendEmptyMessage(1);
          }
          return true;
        }
      }
      return false;
    }
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (what != 1) {
        super.handleMessage(paramMessage);
      } else {
        a();
      }
    }
  }
  
  public static final class b
  {
    public final Intent a;
    public final ArrayList<a.c> b;
    
    public b(Intent paramIntent, ArrayList<a.c> paramArrayList)
    {
      a = paramIntent;
      b = paramArrayList;
    }
  }
  
  public static final class c
  {
    public final IntentFilter a;
    public final BroadcastReceiver b;
    public boolean c;
    public boolean d;
    
    public c(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
    {
      a = paramIntentFilter;
      b = paramBroadcastReceiver;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("Receiver{");
      localStringBuilder.append(b);
      localStringBuilder.append(" filter=");
      localStringBuilder.append(a);
      if (d) {
        localStringBuilder.append(" DEAD");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}

/* Location:
 * Qualified Name:     d.q.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */