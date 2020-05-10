package d.b.e;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class h0
  implements AdapterView.OnItemSelectedListener
{
  public h0(i0 parami0) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt != -1)
    {
      paramAdapterView = x.z;
      if (paramAdapterView != null) {
        paramAdapterView.setListSelectionHidden(false);
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}

/* Location:
 * Qualified Name:     d.b.e.h0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */