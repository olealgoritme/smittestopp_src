package j.a.a.a.a.a;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  public final int a;
  public final List<ParcelUuid> b;
  public final SparseArray<byte[]> c;
  public final Map<ParcelUuid, byte[]> d;
  public final int e;
  public final String f;
  public final byte[] g;
  
  public i(List<ParcelUuid> paramList, SparseArray<byte[]> paramSparseArray, Map<ParcelUuid, byte[]> paramMap, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    b = paramList;
    c = paramSparseArray;
    d = paramMap;
    f = paramString;
    a = paramInt1;
    e = paramInt2;
    g = paramArrayOfByte;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, List<ParcelUuid> paramList)
  {
    while (paramInt2 > 0)
    {
      paramList.add(e.a(a(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    return paramInt1;
  }
  
  public static i a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    int j = -1;
    int k = Integer.MIN_VALUE;
    try
    {
      while (i < paramArrayOfByte.length)
      {
        int m = i + 1;
        i = paramArrayOfByte[i] & 0xFF;
        if (i == 0) {
          break;
        }
        int n = i - 1;
        int i1 = m + 1;
        m = paramArrayOfByte[m] & 0xFF;
        i = 16;
        if (m != 22) {
          if (m != 255)
          {
            if ((m != 32) && (m != 33)) {
              switch (m)
              {
              default: 
                break;
              case 10: 
                k = paramArrayOfByte[i1];
                break;
              case 8: 
              case 9: 
                localObject4 = new String(a(paramArrayOfByte, i1, n));
                break;
              case 6: 
              case 7: 
                localObject5 = localObject1;
                if (localObject1 == null)
                {
                  localObject5 = new java/util/ArrayList;
                  ((ArrayList)localObject5).<init>();
                }
                a(paramArrayOfByte, i1, n, 16, (List)localObject5);
                localObject1 = localObject5;
                break;
              case 4: 
              case 5: 
                localObject5 = localObject1;
                if (localObject1 == null)
                {
                  localObject5 = new java/util/ArrayList;
                  ((ArrayList)localObject5).<init>();
                }
                a(paramArrayOfByte, i1, n, 4, (List)localObject5);
                localObject1 = localObject5;
                break;
              case 2: 
              case 3: 
                localObject5 = localObject1;
                if (localObject1 == null)
                {
                  localObject5 = new java/util/ArrayList;
                  ((ArrayList)localObject5).<init>();
                }
                a(paramArrayOfByte, i1, n, 2, (List)localObject5);
                localObject1 = localObject5;
                break;
              case 1: 
                j = paramArrayOfByte[i1] & 0xFF;
                break;
              }
            }
          }
          else
          {
            i = paramArrayOfByte[(i1 + 1)];
            m = paramArrayOfByte[i1];
            localObject6 = a(paramArrayOfByte, i1 + 2, n - 2);
            localObject5 = localObject2;
            if (localObject2 == null)
            {
              localObject5 = new android/util/SparseArray;
              ((SparseArray)localObject5).<init>();
            }
            ((SparseArray)localObject5).put(((i & 0xFF) << 8) + (0xFF & m), localObject6);
            localObject2 = localObject5;
            break label468;
          }
        }
        if (m == 32) {
          i = 4;
        } else if (m != 33) {
          i = 2;
        }
        Object localObject6 = e.a(a(paramArrayOfByte, i1, i));
        byte[] arrayOfByte = a(paramArrayOfByte, i1 + i, n - i);
        Object localObject5 = localObject3;
        if (localObject3 == null)
        {
          localObject5 = new java/util/HashMap;
          ((HashMap)localObject5).<init>();
        }
        ((Map)localObject5).put(localObject6, arrayOfByte);
        localObject3 = localObject5;
        label468:
        i = n + i1;
      }
      localObject1 = new i((List)localObject1, (SparseArray)localObject2, (Map)localObject3, j, k, (String)localObject4, paramArrayOfByte);
      return (i)localObject1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = a.a("unable to parse scan record: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfByte));
      Log.e("ScanRecord", localStringBuilder.toString());
    }
    return new i(null, null, null, -1, Integer.MIN_VALUE, null, paramArrayOfByte);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (i.class == paramObject.getClass()))
    {
      paramObject = (i)paramObject;
      return Arrays.equals(g, g);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = a.a("ScanRecord [advertiseFlags=");
    localStringBuilder1.append(a);
    localStringBuilder1.append(", serviceUuids=");
    localStringBuilder1.append(b);
    localStringBuilder1.append(", manufacturerSpecificData=");
    Object localObject1 = c;
    Object localObject2 = "{}";
    if (localObject1 == null)
    {
      localObject3 = "null";
    }
    else if (((SparseArray)localObject1).size() == 0)
    {
      localObject3 = "{}";
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append('{');
      for (int i = 0; i < ((SparseArray)localObject1).size(); i++)
      {
        ((StringBuilder)localObject3).append(((SparseArray)localObject1).keyAt(i));
        ((StringBuilder)localObject3).append("=");
        ((StringBuilder)localObject3).append(Arrays.toString((byte[])((SparseArray)localObject1).valueAt(i)));
      }
      ((StringBuilder)localObject3).append('}');
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    localStringBuilder1.append((String)localObject3);
    localStringBuilder1.append(", serviceData=");
    Object localObject3 = d;
    if (localObject3 == null)
    {
      localObject3 = "null";
    }
    else if (((Map)localObject3).isEmpty())
    {
      localObject3 = localObject2;
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append('{');
      localObject1 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Map.Entry)((Iterator)localObject1).next()).getKey();
        localStringBuilder2.append(localObject2);
        localStringBuilder2.append("=");
        localStringBuilder2.append(Arrays.toString((byte[])((Map)localObject3).get(localObject2)));
        if (((Iterator)localObject1).hasNext()) {
          localStringBuilder2.append(", ");
        }
      }
      localStringBuilder2.append('}');
      localObject3 = localStringBuilder2.toString();
    }
    localStringBuilder1.append((String)localObject3);
    localStringBuilder1.append(", txPowerLevel=");
    localStringBuilder1.append(e);
    localStringBuilder1.append(", deviceName=");
    return a.a(localStringBuilder1, f, "]");
  }
}

/* Location:
 * Qualified Name:     base.j.a.a.a.a.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */