package d.i.f;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.CancellationSignal;
import android.os.Handler;
import d.b.a.r;
import d.f.f;
import d.f.h;
import d.i.b.b.g;
import d.i.c.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
{
  public static final f<String, Typeface> a = new f(16);
  public static final c b = new c("fonts", 10, 10000);
  public static final Object c = new Object();
  public static final h<String, ArrayList<c.c<b.g>>> d = new h();
  public static final Comparator<byte[]> e = new b.d();
  
  public static Typeface a(Context paramContext, a parama, g arg2, Handler paramHandler, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    Typeface localTypeface = (Typeface)a.a(localObject);
    if (localTypeface != null)
    {
      if (??? != null) {
        ???.a(localTypeface);
      }
      return localTypeface;
    }
    if ((paramBoolean) && (paramInt1 == -1))
    {
      paramContext = a(paramContext, parama, paramInt2);
      if (??? != null)
      {
        paramInt1 = b;
        if (paramInt1 == 0) {
          ???.a(a, paramHandler);
        } else {
          ???.a(paramInt1, paramHandler);
        }
      }
      return a;
    }
    parama = new b.a(paramContext, parama, paramInt2, (String)localObject);
    paramContext = null;
    if (paramBoolean) {}
    try
    {
      parama = baa;
      paramContext = parama;
    }
    catch (InterruptedException parama)
    {
      for (;;) {}
    }
    return paramContext;
    if (??? == null) {
      paramContext = null;
    } else {
      paramContext = new b.b(???, paramHandler);
    }
    synchronized (c)
    {
      paramHandler = (ArrayList)d.getOrDefault(localObject, null);
      if (paramHandler != null)
      {
        if (paramContext != null) {
          paramHandler.add(paramContext);
        }
        return null;
      }
      if (paramContext != null)
      {
        paramHandler = new java/util/ArrayList;
        paramHandler.<init>();
        paramHandler.add(paramContext);
        d.put(localObject, paramHandler);
      }
      paramContext = b;
      ??? = new b.c((String)localObject);
      if (paramContext != null)
      {
        paramContext.b(new d(paramContext, parama, new Handler(), ???));
        return null;
      }
      throw null;
    }
  }
  
  public static b.e a(Context paramContext, CancellationSignal paramCancellationSignal, a parama)
  {
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = paramContext.getResources();
    Object localObject3 = a;
    Object localObject4 = ((PackageManager)localObject1).resolveContentProvider((String)localObject3, 0);
    if (localObject4 != null)
    {
      if (packageName.equals(b))
      {
        localObject3 = getPackageInfopackageName, 64).signatures;
        localObject1 = new ArrayList();
        for (int i = 0; i < localObject3.length; i++) {
          ((ArrayList)localObject1).add(localObject3[i].toByteArray());
        }
        Collections.sort((List)localObject1, e);
        localObject3 = d;
        if (localObject3 == null) {
          localObject3 = r.a((Resources)localObject2, e);
        }
        int j;
        for (i = 0;; i++)
        {
          j = ((List)localObject3).size();
          localObject2 = null;
          if (i >= j) {
            break;
          }
          localObject5 = new ArrayList((Collection)((List)localObject3).get(i));
          Collections.sort((List)localObject5, e);
          if (((ArrayList)localObject1).size() == ((ArrayList)localObject5).size()) {}
          for (j = 0; j < ((ArrayList)localObject1).size(); j++) {
            if (!Arrays.equals((byte[])((ArrayList)localObject1).get(j), (byte[])((ArrayList)localObject5).get(j)))
            {
              j = 0;
              break label250;
            }
          }
          j = 1;
          label250:
          if (j != 0)
          {
            localObject3 = localObject4;
            break label271;
          }
        }
        localObject3 = null;
        label271:
        if (localObject3 == null) {
          return new b.e(1, null);
        }
        localObject3 = authority;
        localObject4 = new ArrayList();
        localObject1 = new Uri.Builder().scheme("content").authority((String)localObject3).build();
        Object localObject5 = new Uri.Builder().scheme("content").authority((String)localObject3).appendPath("file").build();
        localObject3 = localObject2;
        try
        {
          paramContext = paramContext.getContentResolver();
          localObject3 = localObject2;
          parama = c;
          localObject3 = localObject2;
          paramCancellationSignal = paramContext.query((Uri)localObject1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { parama }, null, paramCancellationSignal);
          paramContext = (Context)localObject4;
          if (paramCancellationSignal != null)
          {
            paramContext = (Context)localObject4;
            localObject3 = paramCancellationSignal;
            if (paramCancellationSignal.getCount() > 0)
            {
              localObject3 = paramCancellationSignal;
              int k = paramCancellationSignal.getColumnIndex("result_code");
              localObject3 = paramCancellationSignal;
              parama = new java/util/ArrayList;
              localObject3 = paramCancellationSignal;
              parama.<init>();
              localObject3 = paramCancellationSignal;
              int m = paramCancellationSignal.getColumnIndex("_id");
              localObject3 = paramCancellationSignal;
              int n = paramCancellationSignal.getColumnIndex("file_id");
              localObject3 = paramCancellationSignal;
              int i1 = paramCancellationSignal.getColumnIndex("font_ttc_index");
              localObject3 = paramCancellationSignal;
              int i2 = paramCancellationSignal.getColumnIndex("font_weight");
              localObject3 = paramCancellationSignal;
              int i3 = paramCancellationSignal.getColumnIndex("font_italic");
              for (;;)
              {
                paramContext = parama;
                localObject3 = paramCancellationSignal;
                if (!paramCancellationSignal.moveToNext()) {
                  break;
                }
                if (k != -1)
                {
                  localObject3 = paramCancellationSignal;
                  i = paramCancellationSignal.getInt(k);
                }
                else
                {
                  i = 0;
                }
                if (i1 != -1)
                {
                  localObject3 = paramCancellationSignal;
                  j = paramCancellationSignal.getInt(i1);
                }
                else
                {
                  j = 0;
                }
                if (n == -1)
                {
                  localObject3 = paramCancellationSignal;
                  paramContext = ContentUris.withAppendedId((Uri)localObject1, paramCancellationSignal.getLong(m));
                }
                else
                {
                  localObject3 = paramCancellationSignal;
                  paramContext = ContentUris.withAppendedId((Uri)localObject5, paramCancellationSignal.getLong(n));
                }
                int i4;
                if (i2 != -1)
                {
                  localObject3 = paramCancellationSignal;
                  i4 = paramCancellationSignal.getInt(i2);
                }
                else
                {
                  i4 = 400;
                }
                if (i3 != -1)
                {
                  localObject3 = paramCancellationSignal;
                  if (paramCancellationSignal.getInt(i3) == 1)
                  {
                    bool = true;
                    break label723;
                  }
                }
                boolean bool = false;
                label723:
                localObject3 = paramCancellationSignal;
                localObject2 = new d/i/f/b$f;
                localObject3 = paramCancellationSignal;
                ((b.f)localObject2).<init>(paramContext, j, i4, bool, i);
                localObject3 = paramCancellationSignal;
                parama.add(localObject2);
              }
            }
          }
          if (paramCancellationSignal != null) {
            paramCancellationSignal.close();
          }
          return new b.e(0, (b.f[])paramContext.toArray(new b.f[0]));
        }
        finally
        {
          if (localObject3 != null) {
            ((Cursor)localObject3).close();
          }
        }
      }
      paramContext = new StringBuilder();
      paramContext.append("Found content provider ");
      paramContext.append((String)localObject3);
      paramContext.append(", but package was not ");
      paramContext.append(b);
      throw new PackageManager.NameNotFoundException(paramContext.toString());
    }
    throw new PackageManager.NameNotFoundException(e.a.a.a.a.b("No package found for authority: ", (String)localObject3));
  }
  
  public static b.g a(Context paramContext, a parama, int paramInt)
  {
    try
    {
      parama = a(paramContext, null, parama);
      int i = a;
      int j = -3;
      if (i == 0)
      {
        parama = b;
        paramContext = d.i.c.c.a.a(paramContext, null, parama, paramInt);
        if (paramContext != null) {
          j = 0;
        }
        return new b.g(paramContext, j);
      }
      if (i == 1) {
        j = -2;
      }
      return new b.g(null, j);
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return new b.g(null, -1);
  }
  
  public static Map<Uri, ByteBuffer> a(Context paramContext, b.f[] paramArrayOff, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int i = paramArrayOff.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOff[j];
      if (e == 0)
      {
        localObject = a;
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, r.a(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
    }
    return Collections.unmodifiableMap(localHashMap);
  }
}

/* Location:
 * Qualified Name:     base.d.i.f.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */