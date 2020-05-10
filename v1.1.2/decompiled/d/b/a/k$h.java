package d.b.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import d.b.d.i.f;
import d.b.d.i.h;
import d.b.d.i.o;

public final class k$h
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public ViewGroup g;
  public View h;
  public View i;
  public h j;
  public f k;
  public Context l;
  public boolean m;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  public Bundle s;
  
  public k$h(int paramInt)
  {
    a = paramInt;
    q = false;
  }
  
  public void a(h paramh)
  {
    Object localObject = j;
    if (paramh == localObject) {
      return;
    }
    if (localObject != null) {
      ((h)localObject).a(k);
    }
    j = paramh;
    if (paramh != null)
    {
      localObject = k;
      if (localObject != null) {
        paramh.a((o)localObject, a);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.k.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */