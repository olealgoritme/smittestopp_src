package androidx.recyclerview.widget;

import d.t.a.r;
import e.a.a.a.a;

public class LinearLayoutManager$a
{
  public r a;
  public int b;
  public int c;
  public boolean d;
  public boolean e;
  
  public LinearLayoutManager$a()
  {
    a();
  }
  
  public void a()
  {
    b = -1;
    c = Integer.MIN_VALUE;
    d = false;
    e = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("AnchorInfo{mPosition=");
    localStringBuilder.append(b);
    localStringBuilder.append(", mCoordinate=");
    localStringBuilder.append(c);
    localStringBuilder.append(", mLayoutFromEnd=");
    localStringBuilder.append(d);
    localStringBuilder.append(", mValid=");
    localStringBuilder.append(e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.androidx.recyclerview.widget.LinearLayoutManager.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */