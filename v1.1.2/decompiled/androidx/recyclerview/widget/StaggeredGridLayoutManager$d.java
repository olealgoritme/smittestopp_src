package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import e.a.a.a.a;
import java.util.Arrays;
import java.util.List;

public class StaggeredGridLayoutManager$d
{
  public int[] a;
  public List<a> b;
  
  public a a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject = b;
    if (localObject == null) {
      return null;
    }
    int i = ((List)localObject).size();
    for (int j = 0; j < i; j++)
    {
      localObject = (a)b.get(j);
      int k = x;
      if (k >= paramInt2) {
        return null;
      }
      if ((k >= paramInt1) && ((paramInt3 == 0) || (y == paramInt3) || ((paramBoolean) && (A)))) {
        return (a)localObject;
      }
    }
    return null;
  }
  
  public void a()
  {
    int[] arrayOfInt = a;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, -1);
    }
    b = null;
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt1 = a;
    if (arrayOfInt1 == null)
    {
      arrayOfInt1 = new int[Math.max(paramInt, 10) + 1];
      a = arrayOfInt1;
      Arrays.fill(arrayOfInt1, -1);
    }
    else if (paramInt >= arrayOfInt1.length)
    {
      int i = arrayOfInt1.length;
      while (i <= paramInt) {
        i *= 2;
      }
      int[] arrayOfInt2 = new int[i];
      a = arrayOfInt2;
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
      arrayOfInt2 = a;
      Arrays.fill(arrayOfInt2, arrayOfInt1.length, arrayOfInt2.length, -1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = a;
    if ((localObject != null) && (paramInt1 < localObject.length))
    {
      int i = paramInt1 + paramInt2;
      a(i);
      localObject = a;
      System.arraycopy(localObject, paramInt1, localObject, i, localObject.length - paramInt1 - paramInt2);
      Arrays.fill(a, paramInt1, i, -1);
      localObject = b;
      if (localObject != null) {
        for (i = ((List)localObject).size() - 1; i >= 0; i--)
        {
          localObject = (a)b.get(i);
          int j = x;
          if (j >= paramInt1) {
            x = (j + paramInt2);
          }
        }
      }
    }
  }
  
  public int b(int paramInt)
  {
    List localList = b;
    if (localList != null) {
      for (int i = localList.size() - 1; i >= 0; i--) {
        if (b.get(i)).x >= paramInt) {
          b.remove(i);
        }
      }
    }
    return d(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = a;
    if ((localObject != null) && (paramInt1 < localObject.length))
    {
      int i = paramInt1 + paramInt2;
      a(i);
      localObject = a;
      System.arraycopy(localObject, i, localObject, paramInt1, localObject.length - paramInt1 - paramInt2);
      localObject = a;
      Arrays.fill((int[])localObject, localObject.length - paramInt2, localObject.length, -1);
      localObject = b;
      if (localObject != null) {
        for (int j = ((List)localObject).size() - 1; j >= 0; j--)
        {
          localObject = (a)b.get(j);
          int k = x;
          if (k >= paramInt1) {
            if (k < i) {
              b.remove(j);
            } else {
              x = (k - paramInt2);
            }
          }
        }
      }
    }
  }
  
  public a c(int paramInt)
  {
    Object localObject = b;
    if (localObject == null) {
      return null;
    }
    for (int i = ((List)localObject).size() - 1; i >= 0; i--)
    {
      localObject = (a)b.get(i);
      if (x == paramInt) {
        return (a)localObject;
      }
    }
    return null;
  }
  
  public int d(int paramInt)
  {
    Object localObject = a;
    if (localObject == null) {
      return -1;
    }
    if (paramInt >= localObject.length) {
      return -1;
    }
    if (b == null) {}
    label102:
    do
    {
      i = -1;
      break;
      localObject = c(paramInt);
      if (localObject != null) {
        b.remove(localObject);
      }
      int j = b.size();
      for (i = 0; i < j; i++) {
        if (b.get(i)).x >= paramInt) {
          break label102;
        }
      }
      i = -1;
    } while (i == -1);
    localObject = (a)b.get(i);
    b.remove(i);
    int i = x;
    if (i == -1)
    {
      localObject = a;
      Arrays.fill((int[])localObject, paramInt, localObject.length, -1);
      return a.length;
    }
    localObject = a;
    i++;
    Arrays.fill((int[])localObject, paramInt, i, -1);
    return i;
  }
  
  public static class a
    implements Parcelable
  {
    public static final Parcelable.Creator<a> CREATOR = new a();
    public boolean A;
    public int x;
    public int y;
    public int[] z;
    
    public a() {}
    
    public a(Parcel paramParcel)
    {
      x = paramParcel.readInt();
      y = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      A = bool;
      i = paramParcel.readInt();
      if (i > 0)
      {
        int[] arrayOfInt = new int[i];
        z = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = a.a("FullSpanItem{mPosition=");
      localStringBuilder.append(x);
      localStringBuilder.append(", mGapDir=");
      localStringBuilder.append(y);
      localStringBuilder.append(", mHasUnwantedGapAfter=");
      localStringBuilder.append(A);
      localStringBuilder.append(", mGapPerSpan=");
      localStringBuilder.append(Arrays.toString(z));
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(x);
      paramParcel.writeInt(y);
      paramParcel.writeInt(A);
      int[] arrayOfInt = z;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        paramParcel.writeInt(arrayOfInt.length);
        paramParcel.writeIntArray(z);
      }
      else
      {
        paramParcel.writeInt(0);
      }
    }
    
    public static final class a
      implements Parcelable.Creator<StaggeredGridLayoutManager.d.a>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new StaggeredGridLayoutManager.d.a(paramParcel);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new StaggeredGridLayoutManager.d.a[paramInt];
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */