package d.b.e;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.Spinner;

public class w$d$a
  implements AdapterView.OnItemClickListener
{
  public w$d$a(w.d paramd, w paramw) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    x.g0.setSelection(paramInt);
    if (x.g0.getOnItemClickListener() != null)
    {
      paramAdapterView = x;
      g0.performItemClick(paramView, paramInt, d0.getItemId(paramInt));
    }
    x.dismiss();
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.w.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */