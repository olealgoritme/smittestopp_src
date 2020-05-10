package d.m.a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class b
  implements Parcelable
{
  public static final Parcelable.Creator<b> CREATOR = new b.a();
  public final int[] A;
  public final int B;
  public final String C;
  public final int D;
  public final int E;
  public final CharSequence F;
  public final int G;
  public final CharSequence H;
  public final ArrayList<String> I;
  public final ArrayList<String> J;
  public final boolean K;
  public final int[] x;
  public final ArrayList<String> y;
  public final int[] z;
  
  public b(Parcel paramParcel)
  {
    x = paramParcel.createIntArray();
    y = paramParcel.createStringArrayList();
    z = paramParcel.createIntArray();
    A = paramParcel.createIntArray();
    B = paramParcel.readInt();
    C = paramParcel.readString();
    D = paramParcel.readInt();
    E = paramParcel.readInt();
    F = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    G = paramParcel.readInt();
    H = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    I = paramParcel.createStringArrayList();
    J = paramParcel.createStringArrayList();
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    K = bool;
  }
  
  public b(a parama)
  {
    int i = a.size();
    x = new int[i * 5];
    if (g)
    {
      y = new ArrayList(i);
      z = new int[i];
      A = new int[i];
      int j = 0;
      for (int k = 0; j < i; k++)
      {
        y.a locala = (y.a)a.get(j);
        Object localObject = x;
        int m = k + 1;
        localObject[k] = a;
        ArrayList localArrayList = y;
        localObject = b;
        if (localObject != null) {
          localObject = mWho;
        } else {
          localObject = null;
        }
        localArrayList.add(localObject);
        localObject = x;
        k = m + 1;
        localObject[m] = c;
        m = k + 1;
        localObject[k] = d;
        k = m + 1;
        localObject[m] = e;
        localObject[k] = f;
        z[j] = g.ordinal();
        A[j] = h.ordinal();
        j++;
      }
      B = f;
      C = i;
      D = t;
      E = j;
      F = k;
      G = l;
      H = m;
      I = n;
      J = o;
      K = p;
      return;
    }
    throw new IllegalStateException("Not on back stack");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(x);
    paramParcel.writeStringList(y);
    paramParcel.writeIntArray(z);
    paramParcel.writeIntArray(A);
    paramParcel.writeInt(B);
    paramParcel.writeString(C);
    paramParcel.writeInt(D);
    paramParcel.writeInt(E);
    TextUtils.writeToParcel(F, paramParcel, 0);
    paramParcel.writeInt(G);
    TextUtils.writeToParcel(H, paramParcel, 0);
    paramParcel.writeStringList(I);
    paramParcel.writeStringList(J);
    paramParcel.writeInt(K);
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */