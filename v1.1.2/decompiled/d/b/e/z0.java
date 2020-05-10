package d.b.e;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.style;

public class z0
{
  public final Context a;
  public final View b;
  public final TextView c;
  public final WindowManager.LayoutParams d = new WindowManager.LayoutParams();
  public final Rect e = new Rect();
  public final int[] f = new int[2];
  public final int[] g = new int[2];
  
  public z0(Context paramContext)
  {
    a = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.abc_tooltip, null);
    b = paramContext;
    c = ((TextView)paramContext.findViewById(R.id.message));
    d.setTitle(z0.class.getSimpleName());
    d.packageName = a.getPackageName();
    paramContext = d;
    type = 1002;
    width = -2;
    height = -2;
    format = -3;
    windowAnimations = R.style.Animation_AppCompat_Tooltip;
    flags = 24;
  }
  
  public void a()
  {
    int i;
    if (b.getParent() != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    ((WindowManager)a.getSystemService("window")).removeView(b);
  }
}

/* Location:
 * Qualified Name:     d.b.e.z0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */