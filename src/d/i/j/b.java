package d.i.j;

import android.os.Build.VERSION;

public abstract interface b
{
  public static final boolean a;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 27) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
}

/* Location:
 * Qualified Name:     base.d.i.j.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */