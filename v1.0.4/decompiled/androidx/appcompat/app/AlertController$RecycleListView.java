package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.appcompat.R.styleable;

public class AlertController$RecycleListView
  extends ListView
{
  public final int x;
  public final int y;
  
  public AlertController$RecycleListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlertController$RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecycleListView);
    y = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
    x = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.app.AlertController.RecycleListView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */