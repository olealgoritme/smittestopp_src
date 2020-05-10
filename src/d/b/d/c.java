package d.b.d;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;

import androidx.appcompat.R.style;

public class c
  extends ContextWrapper
{
  public int a;
  public Resources.Theme b;
  public LayoutInflater c;
  public Resources d;
  
  public c()
  {
    super(null);
  }
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    a = paramInt;
  }
  
  public final void a()
  {
    int i;
    if (b == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      b = getResources().newTheme();
      Resources.Theme localTheme = getBaseContext().getTheme();
      if (localTheme != null) {
        b.setTo(localTheme);
      }
    }
    b.applyStyle(a, true);
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public AssetManager getAssets()
  {
    return getResources().getAssets();
  }
  
  public Resources getResources()
  {
    if (d == null) {
      d = super.getResources();
    }
    return d;
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (c == null) {
        c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return c;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    Resources.Theme localTheme = b;
    if (localTheme != null) {
      return localTheme;
    }
    if (a == 0) {
      a = R.style.Theme_AppCompat_Light;
    }
    a();
    return b;
  }
  
  public void setTheme(int paramInt)
  {
    if (a != paramInt)
    {
      a = paramInt;
      a();
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */