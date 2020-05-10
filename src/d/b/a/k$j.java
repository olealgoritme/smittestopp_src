package d.b.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import d.b.d.i.e;
import d.b.d.i.g;
import d.b.d.i.m;

public final class k$j
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
  public g j;
  public e k;
  public Context l;
  public boolean m;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  public Bundle s;
  
  public k$j(int paramInt)
  {
    a = paramInt;
    q = false;
  }
  
  public void a(g paramg)
  {
    Object localObject = j;
    if (paramg == localObject) {
      return;
    }
    if (localObject != null) {
      ((g)localObject).a(k);
    }
    j = paramg;
    if (paramg != null)
    {
      localObject = k;
      if (localObject != null) {
        paramg.a((m)localObject, a);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */