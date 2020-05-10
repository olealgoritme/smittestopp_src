package d.s;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.navigation.common.R.styleable;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i
{
  public String A;
  public CharSequence B;
  public ArrayList<h> C;
  public d.f.i<c> D;
  public HashMap<String, d> E;
  public final String x;
  public j y;
  public int z;
  
  static
  {
    new HashMap();
  }
  
  public i(p<? extends i> paramp)
  {
    x = paramp;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramInt <= 16777215) {
      return Integer.toString(paramInt);
    }
    try
    {
      paramContext = paramContext.getResources().getResourceName(paramInt);
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext) {}
    return Integer.toString(paramInt);
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      localObject1 = E;
      if ((localObject1 == null) || (((HashMap)localObject1).isEmpty())) {
        return null;
      }
    }
    Object localObject1 = new Bundle();
    Object localObject2 = E;
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      localObject2 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = (d)((Map.Entry)localObject3).getValue();
        localObject3 = (String)((Map.Entry)localObject3).getKey();
        if (c) {
          a.a((Bundle)localObject1, (String)localObject3, d);
        }
      }
    }
    if (paramBundle != null)
    {
      ((Bundle)localObject1).putAll(paramBundle);
      localObject2 = E;
      if (localObject2 != null)
      {
        localObject4 = ((HashMap)localObject2).entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject4).next();
          d locald = (d)((Map.Entry)localObject2).getValue();
          localObject3 = (String)((Map.Entry)localObject2).getKey();
          boolean bool = b;
          int i = 0;
          if ((bool) || (!paramBundle.containsKey((String)localObject3)) || (paramBundle.get((String)localObject3) != null)) {
            try
            {
              a.a(paramBundle, (String)localObject3);
              i = 1;
            }
            catch (ClassCastException localClassCastException) {}
          }
          if (i == 0)
          {
            paramBundle = a.a("Wrong argument type for '");
            paramBundle.append((String)((Map.Entry)localObject2).getKey());
            paramBundle.append("' in argument bundle. ");
            paramBundle.append(getValuea.a());
            paramBundle.append(" expected.");
            throw new IllegalArgumentException(paramBundle.toString());
          }
        }
      }
    }
    return (Bundle)localObject1;
  }
  
  public final c a(int paramInt)
  {
    Object localObject1 = D;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (c)((d.f.i)localObject1).b(paramInt, null);
    }
    if (localObject1 == null)
    {
      j localj = y;
      localObject1 = localObject2;
      if (localj != null) {
        localObject1 = localj.a(paramInt);
      }
    }
    return (c)localObject1;
  }
  
  public a a(Uri paramUri)
  {
    Object localObject1 = C;
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    Object localObject3;
    for (Object localObject2 = null;; localObject2 = localObject3)
    {
      localObject1 = null;
      localObject3 = null;
      if (!localIterator.hasNext()) {
        break;
      }
      h localh = (h)localIterator.next();
      Object localObject4 = E;
      if (localObject4 == null) {
        localObject4 = Collections.emptyMap();
      } else {
        localObject4 = Collections.unmodifiableMap((Map)localObject4);
      }
      Object localObject5 = b.matcher(paramUri.toString());
      if (!((Matcher)localObject5).matches()) {
        localObject1 = localObject3;
      }
      for (;;)
      {
        break label476;
        Bundle localBundle = new Bundle();
        int i = a.size();
        int j = 0;
        Object localObject6;
        for (;;)
        {
          if (j < i)
          {
            localObject6 = (String)a.get(j);
            int k = j + 1;
            j = k;
            if (localh.a(localBundle, (String)localObject6, Uri.decode(((Matcher)localObject5).group(k)), (d)((Map)localObject4).get(localObject6))) {
              break;
            }
          }
        }
        if (d)
        {
          localObject5 = e.keySet().iterator();
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (String)((Iterator)localObject5).next();
            h.a locala = (h.a)e.get(localObject3);
            localObject3 = paramUri.getQueryParameter((String)localObject3);
            if (localObject3 != null)
            {
              localObject3 = Pattern.compile(a).matcher((CharSequence)localObject3);
              localObject6 = localObject3;
              if (((Matcher)localObject3).matches()) {}
            }
            else
            {
              localObject6 = localObject1;
            }
            j = 0;
            for (localObject3 = localObject1;; localObject3 = null)
            {
              localObject1 = localObject3;
              if (j >= b.size()) {
                break;
              }
              if (localObject6 != null) {
                localObject1 = Uri.decode(((Matcher)localObject6).group(j + 1));
              } else {
                localObject1 = localObject3;
              }
              String str = (String)b.get(j);
              d locald = (d)((Map)localObject4).get(str);
              localObject3 = localObject1;
              if (locald != null) {
                if (localObject1 != null)
                {
                  localObject3 = localObject1;
                  if (!((String)localObject1).replaceAll("[{}]", "").equals(str)) {}
                }
                else
                {
                  localObject3 = d;
                  if (localObject3 != null)
                  {
                    localObject3 = localObject3.toString();
                  }
                  else
                  {
                    localObject3 = localObject1;
                    if (b) {
                      localObject3 = null;
                    }
                  }
                }
              }
              if (localh.a(localBundle, str, (String)localObject3, locald))
              {
                localObject1 = null;
                break label476;
              }
              j++;
            }
          }
        }
        localObject1 = localBundle;
      }
      label476:
      localObject3 = localObject2;
      if (localObject1 != null)
      {
        localObject1 = new a(this, (Bundle)localObject1, c);
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          if (((a)localObject1).a((a)localObject2) <= 0) {}
        }
        else
        {
          localObject3 = localObject1;
        }
      }
    }
    return (a)localObject2;
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.Navigator);
    int i = paramAttributeSet.getResourceId(R.styleable.Navigator_android_id, 0);
    z = i;
    A = null;
    A = a(paramContext, i);
    B = paramAttributeSet.getText(R.styleable.Navigator_android_label);
    paramAttributeSet.recycle();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("(");
    String str = A;
    if (str == null)
    {
      localStringBuilder.append("0x");
      localStringBuilder.append(Integer.toHexString(z));
    }
    else
    {
      localStringBuilder.append(str);
    }
    localStringBuilder.append(")");
    if (B != null)
    {
      localStringBuilder.append(" label=");
      localStringBuilder.append(B);
    }
    return localStringBuilder.toString();
  }
  
  public static class a
    implements Comparable<a>
  {
    public final i x;
    public final Bundle y;
    public final boolean z;
    
    public a(i parami, Bundle paramBundle, boolean paramBoolean)
    {
      x = parami;
      y = paramBundle;
      z = paramBoolean;
    }
    
    public int a(a parama)
    {
      if ((z) && (!z)) {
        return 1;
      }
      if ((!z) && (z)) {
        return -1;
      }
      return y.size() - y.size();
    }
  }
}

/* Location:
 * Qualified Name:     d.s.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */