package d.j.a;

import android.database.Cursor;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import d.b.e.r0;

public class b
  extends Filter
{
  public b.a a;
  
  public b(b.a parama)
  {
    a = parama;
  }
  
  public CharSequence convertResultToString(Object paramObject)
  {
    b.a locala = a;
    paramObject = (Cursor)paramObject;
    return ((r0)locala).b((Cursor)paramObject);
  }
  
  public Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Object localObject = (r0)a;
    if (localObject != null)
    {
      if (paramCharSequence == null) {
        paramCharSequence = "";
      } else {
        paramCharSequence = paramCharSequence.toString();
      }
      if ((I.getVisibility() == 0) && (I.getWindowVisibility() == 0)) {
        try
        {
          paramCharSequence = ((r0)localObject).a(J, paramCharSequence, 50);
          if (paramCharSequence != null) {
            paramCharSequence.getCount();
          }
        }
        catch (RuntimeException paramCharSequence)
        {
          Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", paramCharSequence);
        }
      }
      paramCharSequence = null;
      localObject = new Filter.FilterResults();
      if (paramCharSequence != null)
      {
        count = paramCharSequence.getCount();
        values = paramCharSequence;
      }
      else
      {
        count = 0;
        values = null;
      }
      return (Filter.FilterResults)localObject;
    }
    throw null;
  }
  
  public void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = a;
    Cursor localCursor = z;
    paramFilterResults = values;
    if ((paramFilterResults != null) && (paramFilterResults != localCursor))
    {
      paramFilterResults = (Cursor)paramFilterResults;
      ((r0)paramCharSequence).a(paramFilterResults);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.j.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */