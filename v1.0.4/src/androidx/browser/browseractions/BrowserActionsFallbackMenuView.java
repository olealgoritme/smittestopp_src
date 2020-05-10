package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import androidx.browser.R.dimen;

public class BrowserActionsFallbackMenuView
  extends LinearLayout
{
  public final int x = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);
  public final int y = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);
  
  public BrowserActionsFallbackMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResourcesgetDisplayMetricswidthPixels - x * 2, y), 1073741824), paramInt2);
  }
}

/* Location:
 * Qualified Name:     base.androidx.browser.browseractions.BrowserActionsFallbackMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */