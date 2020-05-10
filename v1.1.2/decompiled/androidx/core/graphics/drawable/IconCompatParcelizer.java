package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Parcel;
import android.os.Parcelable;
import d.z.a;
import d.z.b;
import java.nio.charset.Charset;

public class IconCompatParcelizer
{
  public static IconCompat read(a parama)
  {
    IconCompat localIconCompat = new IconCompat();
    a = parama.a(a, 1);
    Object localObject = c;
    if (parama.a(2))
    {
      b localb = (b)parama;
      i = e.readInt();
      if (i < 0)
      {
        localObject = null;
      }
      else
      {
        localObject = new byte[i];
        e.readByteArray((byte[])localObject);
      }
    }
    c = ((byte[])localObject);
    d = parama.a(d, 3);
    e = parama.a(e, 4);
    f = parama.a(f, 5);
    g = ((ColorStateList)parama.a(g, 6));
    localObject = i;
    if (!parama.a(7)) {
      parama = (a)localObject;
    } else {
      parama = e.readString();
    }
    i = parama;
    h = PorterDuff.Mode.valueOf(parama);
    int i = a;
    if (i != -1)
    {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5) {
                break label257;
              }
              break label317;
            }
          }
          else
          {
            b = c;
            break label317;
          }
        }
        b = new String(c, Charset.forName("UTF-16"));
        break label317;
      }
      label257:
      parama = d;
      if (parama != null)
      {
        b = parama;
      }
      else
      {
        parama = c;
        b = parama;
        a = 3;
        e = 0;
        f = parama.length;
      }
    }
    else
    {
      parama = d;
      if (parama == null) {
        break label319;
      }
      b = parama;
    }
    label317:
    return localIconCompat;
    label319:
    throw new IllegalArgumentException("Invalid icon");
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    if (parama != null)
    {
      paramIconCompat.i = h.name();
      int i = a;
      if (i != -1)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  break label136;
                }
              }
              else
              {
                c = b.toString().getBytes(Charset.forName("UTF-16"));
                break label136;
              }
            }
            else
            {
              c = ((byte[])b);
              break label136;
            }
          }
          else
          {
            c = ((String)b).getBytes(Charset.forName("UTF-16"));
            break label136;
          }
        }
        d = ((Parcelable)b);
      }
      else
      {
        d = ((Parcelable)b);
      }
      label136:
      i = a;
      if (-1 != i) {
        parama.b(i, 1);
      }
      byte[] arrayOfByte = c;
      if (arrayOfByte != null)
      {
        parama.b(2);
        localObject = (b)parama;
        e.writeInt(arrayOfByte.length);
        e.writeByteArray(arrayOfByte);
      }
      Object localObject = d;
      if (localObject != null)
      {
        parama.b(3);
        e.writeParcelable((Parcelable)localObject, 0);
      }
      i = e;
      if (i != 0) {
        parama.b(i, 4);
      }
      i = f;
      if (i != 0) {
        parama.b(i, 5);
      }
      localObject = g;
      if (localObject != null)
      {
        parama.b(6);
        e.writeParcelable((Parcelable)localObject, 0);
      }
      paramIconCompat = paramIconCompat.i;
      if (paramIconCompat != null)
      {
        parama.b(7);
        e.writeString(paramIconCompat);
      }
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */