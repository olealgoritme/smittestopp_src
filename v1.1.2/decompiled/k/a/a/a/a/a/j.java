package k.a.a.a.a.a;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import e.a.a.a.a;
import e.c.a.a.b.l.c;
import java.util.Arrays;

public final class j
  implements Parcelable
{
  public static final Parcelable.Creator<j> CREATOR = new a();
  public long A;
  public int B;
  public int C;
  public int D;
  public int E;
  public int F;
  public int G;
  public BluetoothDevice x;
  public i y;
  public int z;
  
  public j(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, i parami, long paramLong)
  {
    x = paramBluetoothDevice;
    B = paramInt1;
    C = paramInt2;
    D = paramInt3;
    E = paramInt4;
    F = paramInt5;
    z = paramInt6;
    G = paramInt7;
    y = parami;
    A = paramLong;
  }
  
  public j(BluetoothDevice paramBluetoothDevice, i parami, int paramInt, long paramLong)
  {
    x = paramBluetoothDevice;
    y = parami;
    z = paramInt;
    A = paramLong;
    B = 17;
    C = 1;
    D = 0;
    E = 255;
    F = 127;
    G = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (j.class == paramObject.getClass()))
    {
      paramObject = (j)paramObject;
      if ((!c.b(x, x)) || (z != z) || (!c.b(y, y)) || (A != A) || (B != B) || (C != C) || (D != D) || (E != E) || (F != F) || (G != G)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { x, Integer.valueOf(z), y, Long.valueOf(A), Integer.valueOf(B), Integer.valueOf(C), Integer.valueOf(D), Integer.valueOf(E), Integer.valueOf(F), Integer.valueOf(G) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("ScanResult{device=");
    localStringBuilder.append(x);
    localStringBuilder.append(", scanRecord=");
    Object localObject = y;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = localObject.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", rssi=");
    localStringBuilder.append(z);
    localStringBuilder.append(", timestampNanos=");
    localStringBuilder.append(A);
    localStringBuilder.append(", eventType=");
    localStringBuilder.append(B);
    localStringBuilder.append(", primaryPhy=");
    localStringBuilder.append(C);
    localStringBuilder.append(", secondaryPhy=");
    localStringBuilder.append(D);
    localStringBuilder.append(", advertisingSid=");
    localStringBuilder.append(E);
    localStringBuilder.append(", txPower=");
    localStringBuilder.append(F);
    localStringBuilder.append(", periodicAdvertisingInterval=");
    localStringBuilder.append(G);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    x.writeToParcel(paramParcel, paramInt);
    if (y != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(y.g);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(z);
    paramParcel.writeLong(A);
    paramParcel.writeInt(B);
    paramParcel.writeInt(C);
    paramParcel.writeInt(D);
    paramParcel.writeInt(E);
    paramParcel.writeInt(F);
    paramParcel.writeInt(G);
  }
  
  public static final class a
    implements Parcelable.Creator<j>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new j(paramParcel, null);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new j[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */