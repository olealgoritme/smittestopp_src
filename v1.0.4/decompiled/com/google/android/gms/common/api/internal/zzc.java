package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import d.f.a;
import e.c.a.a.b.i.k.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzc
  extends Fragment
  implements e
{
  public Map<String, LifecycleCallback> x = new a();
  
  static
  {
    new WeakHashMap();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramString = x.values().iterator();
    while (paramString.hasNext()) {
      if ((LifecycleCallback)paramString.next() == null) {
        throw null;
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = x.values().iterator();
    while (paramIntent.hasNext()) {
      if ((LifecycleCallback)paramIntent.next() == null) {
        throw null;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Iterator localIterator = x.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      LifecycleCallback localLifecycleCallback = (LifecycleCallback)localEntry.getValue();
      if (paramBundle != null) {
        paramBundle.getBundle((String)localEntry.getKey());
      }
      if (localLifecycleCallback == null) {
        throw null;
      }
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = x.values().iterator();
    while (localIterator.hasNext()) {
      if ((LifecycleCallback)localIterator.next() == null) {
        throw null;
      }
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    Iterator localIterator = x.values().iterator();
    while (localIterator.hasNext()) {
      if ((LifecycleCallback)localIterator.next() == null) {
        throw null;
      }
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    Iterator localIterator = x.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Bundle localBundle = new Bundle();
      if ((LifecycleCallback)localEntry.getValue() != null) {
        paramBundle.putBundle((String)localEntry.getKey(), localBundle);
      } else {
        throw null;
      }
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    Iterator localIterator = x.values().iterator();
    while (localIterator.hasNext()) {
      if ((LifecycleCallback)localIterator.next() == null) {
        throw null;
      }
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    Iterator localIterator = x.values().iterator();
    while (localIterator.hasNext()) {
      if ((LifecycleCallback)localIterator.next() == null) {
        throw null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.common.api.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */