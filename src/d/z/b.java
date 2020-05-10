package d.z;

import android.os.Parcel;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

public class b
  extends a
{
  public final SparseIntArray d = new SparseIntArray();
  public final Parcel e;
  public final int f;
  public final int g;
  public final String h;
  public int i = -1;
  public int j = 0;
  public int k = -1;
  
  public b(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "", new d.f.a(), new d.f.a(), new d.f.a());
  }
  
  public b(Parcel paramParcel, int paramInt1, int paramInt2, String paramString, d.f.a<String, Method> parama1, d.f.a<String, Method> parama2, d.f.a<String, Class> parama)
  {
    super(parama1, parama2, parama);
    e = paramParcel;
    f = paramInt1;
    g = paramInt2;
    j = paramInt1;
    h = paramString;
  }
  
  public void a()
  {
    int m = i;
    if (m >= 0)
    {
      int n = d.get(m);
      m = e.dataPosition();
      e.setDataPosition(n);
      e.writeInt(m - n);
      e.setDataPosition(m);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool;
    for (;;)
    {
      int m = j;
      int n = g;
      bool = true;
      if (m >= n) {
        break;
      }
      m = k;
      if (m == paramInt) {
        return true;
      }
      if (String.valueOf(m).compareTo(String.valueOf(paramInt)) > 0) {
        return false;
      }
      e.setDataPosition(j);
      m = e.readInt();
      k = e.readInt();
      j += m;
    }
    if (k != paramInt) {
      bool = false;
    }
    return bool;
  }
  
  public a b()
  {
    Parcel localParcel = e;
    int m = localParcel.dataPosition();
    int n = j;
    int i1 = n;
    if (n == f) {
      i1 = g;
    }
    return new b(localParcel, m, i1, e.a.a.a.a.a(new StringBuilder(), h, "  "), a, b, c);
  }
  
  public void b(int paramInt)
  {
    a();
    i = paramInt;
    d.put(paramInt, e.dataPosition());
    e.writeInt(0);
    e.writeInt(paramInt);
  }
}

/* Location:
 * Qualified Name:     base.d.z.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */