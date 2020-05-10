package d.j.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

public abstract class a
  extends BaseAdapter
  implements Filterable, b.a
{
  public Context A;
  public int B;
  public a C;
  public DataSetObserver D;
  public b E;
  public boolean x;
  public boolean y;
  public Cursor z;
  
  public a(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    boolean bool = true;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    if ((i & 0x1) == 1)
    {
      i |= 0x2;
      y = true;
    }
    else
    {
      y = false;
    }
    if (paramCursor != null) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    z = paramCursor;
    x = paramBoolean;
    A = paramContext;
    int j;
    if (paramBoolean) {
      j = paramCursor.getColumnIndexOrThrow("_id");
    } else {
      j = -1;
    }
    B = j;
    if ((i & 0x2) == 2)
    {
      C = new a();
      D = new b();
    }
    else
    {
      C = null;
      D = null;
    }
    if (paramBoolean)
    {
      paramContext = C;
      if (paramContext != null) {
        paramCursor.registerContentObserver(paramContext);
      }
      paramContext = D;
      if (paramContext != null) {
        paramCursor.registerDataSetObserver(paramContext);
      }
    }
  }
  
  public abstract View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  public void a(Cursor paramCursor)
  {
    Cursor localCursor = z;
    if (paramCursor == localCursor)
    {
      paramCursor = null;
    }
    else
    {
      Object localObject;
      if (localCursor != null)
      {
        localObject = C;
        if (localObject != null) {
          localCursor.unregisterContentObserver((ContentObserver)localObject);
        }
        localObject = D;
        if (localObject != null) {
          localCursor.unregisterDataSetObserver((DataSetObserver)localObject);
        }
      }
      z = paramCursor;
      if (paramCursor != null)
      {
        localObject = C;
        if (localObject != null) {
          paramCursor.registerContentObserver((ContentObserver)localObject);
        }
        localObject = D;
        if (localObject != null) {
          paramCursor.registerDataSetObserver((DataSetObserver)localObject);
        }
        B = paramCursor.getColumnIndexOrThrow("_id");
        x = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        B = -1;
        x = false;
        notifyDataSetInvalidated();
        paramCursor = localCursor;
      }
    }
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public abstract void a(View paramView, Context paramContext, Cursor paramCursor);
  
  public abstract CharSequence b(Cursor paramCursor);
  
  public int getCount()
  {
    if (x)
    {
      Cursor localCursor = z;
      if (localCursor != null) {
        return localCursor.getCount();
      }
    }
    return 0;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (x)
    {
      z.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null)
      {
        paramView = (c)this;
        localView = H.inflate(G, paramViewGroup, false);
      }
      a(localView, A, z);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (E == null) {
      E = new b(this);
    }
    return E;
  }
  
  public Object getItem(int paramInt)
  {
    if (x)
    {
      Cursor localCursor = z;
      if (localCursor != null)
      {
        localCursor.moveToPosition(paramInt);
        return z;
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (x)
    {
      Cursor localCursor = z;
      if ((localCursor != null) && (localCursor.moveToPosition(paramInt))) {
        return z.getLong(B);
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (x)
    {
      if (z.moveToPosition(paramInt))
      {
        View localView = paramView;
        if (paramView == null) {
          localView = a(A, z, paramViewGroup);
        }
        a(localView, A, z);
        return localView;
      }
      throw new IllegalStateException(e.a.a.a.a.a("couldn't move cursor to position ", paramInt));
    }
    throw new IllegalStateException("this should only be called when the cursor is valid");
  }
  
  public class a
    extends ContentObserver
  {
    public a()
    {
      super();
    }
    
    public boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public void onChange(boolean paramBoolean)
    {
      a locala = a.this;
      if (y)
      {
        Cursor localCursor = z;
        if ((localCursor != null) && (!localCursor.isClosed())) {
          x = z.requery();
        }
      }
    }
  }
  
  public class b
    extends DataSetObserver
  {
    public b() {}
    
    public void onChanged()
    {
      a locala = a.this;
      x = true;
      locala.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      a locala = a.this;
      x = false;
      locala.notifyDataSetInvalidated();
    }
  }
}

/* Location:
 * Qualified Name:     d.j.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */