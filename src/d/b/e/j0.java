package d.b.e;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class j0
  implements AdapterView.OnItemSelectedListener
{
  public j0(k0 paramk0) {}
  
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
 * Qualified Name:     base.d.b.e.j0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */