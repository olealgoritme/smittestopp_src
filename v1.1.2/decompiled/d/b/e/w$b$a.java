package d.b.e;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.Spinner;

public class w$b$a
  implements AdapterView.OnItemClickListener
{
  public w$b$a(w.b paramb, w paramw) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    x.f0.setSelection(paramInt);
    if (x.f0.getOnItemClickListener() != null)
    {
      paramAdapterView = x;
      f0.performItemClick(paramView, paramInt, d0.getItemId(paramInt));
    }
    x.dismiss();
  }
}

/* Location:
 * Qualified Name:     d.b.e.w.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */