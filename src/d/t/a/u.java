package d.t.a;

import android.view.View;
import java.util.ArrayList;

public class u
  implements a.a
{
  public u(s params) {}
  
  public s.x a(int paramInt)
  {
    s locals = a;
    int i = B.b();
    int j = 0;
    Object localObject2;
    Object localObject3;
    for (Object localObject1 = null;; localObject1 = localObject3)
    {
      localObject2 = localObject1;
      if (j >= i) {
        break;
      }
      localObject2 = s.b(B.d(j));
      localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (!((s.x)localObject2).n()) {
          if (c != paramInt) {
            localObject3 = localObject1;
          } else if (B.b(a)) {
            localObject3 = localObject2;
          } else {
            break;
          }
        }
      }
      j++;
    }
    if (localObject2 == null) {
      return null;
    }
    if (a.B.b(a)) {
      return null;
    }
    return (s.x)localObject2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    s locals = a;
    int i = B.b();
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      localObject = s.b(B.d(k));
      if ((localObject != null) && (!((s.x)localObject).u()) && (c >= paramInt1))
      {
        ((s.x)localObject).a(paramInt2, false);
        C0.f = true;
      }
    }
    Object localObject = y;
    i = c.size();
    for (k = j; k < i; k++)
    {
      s.x localx = (s.x)c.get(k);
      if ((localx != null) && (c >= paramInt1)) {
        localx.a(paramInt2, true);
      }
    }
    locals.requestLayout();
    a.F0 = true;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    s locals = a;
    int i = B.b();
    int j = paramInt2 + paramInt1;
    int k;
    for (paramInt2 = 0; paramInt2 < i; paramInt2++)
    {
      View localView = B.d(paramInt2);
      localObject = s.b(localView);
      if ((localObject != null) && (!((s.x)localObject).u()))
      {
        k = c;
        if ((k >= paramInt1) && (k < j))
        {
          ((s.x)localObject).a(2);
          ((s.x)localObject).a(paramObject);
          getLayoutParamsc = true;
        }
      }
    }
    Object localObject = y;
    paramInt2 = c.size();
    for (;;)
    {
      i = paramInt2 - 1;
      if (i < 0) {
        break;
      }
      paramObject = (s.x)c.get(i);
      if (paramObject == null)
      {
        paramInt2 = i;
      }
      else
      {
        k = c;
        paramInt2 = i;
        if (k >= paramInt1)
        {
          paramInt2 = i;
          if (k < j)
          {
            ((s.x)paramObject).a(2);
            ((s.q)localObject).b(i);
            paramInt2 = i;
          }
        }
      }
    }
    a.G0 = true;
  }
  
  public void a(a.b paramb)
  {
    int i = a;
    s locals;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            locals = a;
            I.a(locals, b, d, 1);
          }
        }
        else
        {
          locals = a;
          I.a(locals, b, d, c);
        }
      }
      else
      {
        locals = a;
        I.b(locals, b, d);
      }
    }
    else
    {
      locals = a;
      I.a(locals, b, d);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    s locals = a;
    int i = B.b();
    int j = -1;
    int k;
    int m;
    int n;
    if (paramInt1 < paramInt2)
    {
      k = paramInt1;
      m = paramInt2;
      n = -1;
    }
    else
    {
      m = paramInt1;
      k = paramInt2;
      n = 1;
    }
    s.x localx;
    for (int i1 = 0; i1 < i; i1++)
    {
      localx = s.b(B.d(i1));
      if (localx != null)
      {
        int i2 = c;
        if ((i2 >= k) && (i2 <= m))
        {
          if (i2 == paramInt1) {
            localx.a(paramInt2 - paramInt1, false);
          } else {
            localx.a(n, false);
          }
          C0.f = true;
        }
      }
    }
    s.q localq = y;
    if (paramInt1 < paramInt2)
    {
      k = paramInt1;
      n = paramInt2;
      m = j;
    }
    else
    {
      n = paramInt1;
      k = paramInt2;
      m = 1;
    }
    j = c.size();
    for (i1 = 0; i1 < j; i1++)
    {
      localx = (s.x)c.get(i1);
      if (localx != null)
      {
        i = c;
        if ((i >= k) && (i <= n)) {
          if (i == paramInt1) {
            localx.a(paramInt2 - paramInt1, false);
          } else {
            localx.a(m, false);
          }
        }
      }
    }
    locals.requestLayout();
    a.F0 = true;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */