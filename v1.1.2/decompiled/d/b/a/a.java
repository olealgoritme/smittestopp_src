package d.b.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.R.styleable;

public abstract class a
{
  public d.b.d.a a(d.b.d.a.a parama)
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(Configuration paramConfiguration);
  
  public abstract void a(Drawable paramDrawable);
  
  public abstract void a(CharSequence paramCharSequence);
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    return false;
  }
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public abstract void b(CharSequence paramCharSequence);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract void c(boolean paramBoolean);
  
  public abstract Context d();
  
  public abstract void d(boolean paramBoolean);
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
  
  public boolean g()
  {
    return false;
  }
  
  public static class a
    extends ViewGroup.MarginLayoutParams
  {
    public int a = 0;
    
    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      a = 8388627;
    }
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
      a = paramContext.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
      paramContext.recycle();
    }
    
    public a(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public a(a parama)
    {
      super();
      a = a;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }
  
  @Deprecated
  public static abstract class c
  {
    public abstract void a();
  }
}

/* Location:
 * Qualified Name:     d.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */