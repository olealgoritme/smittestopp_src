package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import d.z.a;
import d.z.b;
import d.z.c;

public class RemoteActionCompatParcelizer
{
  public static RemoteActionCompat read(a parama)
  {
    RemoteActionCompat localRemoteActionCompat = new RemoteActionCompat();
    Object localObject = a;
    if (parama.a(1)) {
      localObject = parama.c();
    }
    a = ((IconCompat)localObject);
    b = parama.a(b, 2);
    c = parama.a(c, 3);
    d = ((PendingIntent)parama.a(d, 4));
    e = parama.a(e, 5);
    f = parama.a(f, 6);
    return localRemoteActionCompat;
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, a parama)
  {
    if (parama != null)
    {
      Object localObject = a;
      parama.b(1);
      parama.a((c)localObject);
      CharSequence localCharSequence = b;
      parama.b(2);
      localObject = (b)parama;
      TextUtils.writeToParcel(localCharSequence, e, 0);
      localCharSequence = c;
      parama.b(3);
      TextUtils.writeToParcel(localCharSequence, e, 0);
      parama.b(d, 4);
      int i = e;
      parama.b(5);
      e.writeInt(i);
      int j = f;
      parama.b(6);
      e.writeInt(j);
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     androidx.core.app.RemoteActionCompatParcelizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */