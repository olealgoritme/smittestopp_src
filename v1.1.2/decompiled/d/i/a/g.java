package d.i.a;

import android.os.Bundle;

public class g
{
  public static final Object a = new Object();
  
  public static Bundle a(c paramc)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("icon", i);
    localBundle1.putCharSequence("title", j);
    localBundle1.putParcelable("actionIntent", k);
    Bundle localBundle2;
    if (a != null) {
      localBundle2 = new Bundle(a);
    } else {
      localBundle2 = new Bundle();
    }
    localBundle2.putBoolean("android.support.allowGeneratedReplies", e);
    localBundle1.putBundle("extras", localBundle2);
    localBundle1.putParcelableArray("remoteInputs", a(c));
    localBundle1.putBoolean("showsUserInterface", f);
    localBundle1.putInt("semanticAction", g);
    return localBundle1;
  }
  
  public static Bundle[] a(h[] paramArrayOfh)
  {
    if (paramArrayOfh == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfh.length];
    if (paramArrayOfh.length <= 0) {
      return arrayOfBundle;
    }
    paramArrayOfh = paramArrayOfh[0];
    new Bundle();
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.i.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */