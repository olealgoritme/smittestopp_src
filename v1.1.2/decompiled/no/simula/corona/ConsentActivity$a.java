package no.simula.corona;

import android.view.View;
import android.view.View.OnClickListener;

public final class ConsentActivity$a
  implements View.OnClickListener
{
  public ConsentActivity$a(int paramInt, Object paramObject) {}
  
  public final void onClick(View paramView)
  {
    int i = x;
    if (i != 0)
    {
      if (i == 1)
      {
        ConsentActivity.b((ConsentActivity)y);
        return;
      }
      throw null;
    }
    ConsentActivity.a((ConsentActivity)y);
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ConsentActivity.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */