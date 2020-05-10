package androidx.lifecycle;

import d.o.r;

public abstract class LiveData$a
{
  public final r<? super T> x;
  public boolean y;
  public int z;
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == y) {
      return;
    }
    y = paramBoolean;
    int i = A.c;
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    LiveData localLiveData = A;
    int k = c;
    if (!y) {
      j = -1;
    }
    c = (k + j);
    if ((i != 0) && (y)) {
      A.a();
    }
    localLiveData = A;
    if ((c == 0) && (!y)) {
      localLiveData.b();
    }
    if (y) {
      A.b(this);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.lifecycle.LiveData.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */