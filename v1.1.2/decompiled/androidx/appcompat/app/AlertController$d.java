package androidx.appcompat.app;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AlertController$d
  extends ArrayAdapter<CharSequence>
{
  public AlertController$d(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
  {
    super(paramContext, paramInt1, paramInt2, paramArrayOfCharSequence);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.app.AlertController.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */