package k.b.a.z;

import android.app.Activity;
import android.content.Intent;
import d.b.a.h;
import m.a.a.b;
import no.simula.corona.MainActivity;

public class a
  extends h
{
  public final void l()
  {
    if (isFinishing()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getName());
    ((StringBuilder)localObject).append("gotoMainScreen");
    localObject = ((StringBuilder)localObject).toString();
    m.a.a.d.a((String)localObject, new Object[0]);
    localObject = new Intent(this, MainActivity.class);
    ((Intent)localObject).setFlags(268468224);
    startActivity((Intent)localObject);
    overridePendingTransition(0, 0);
    finish();
  }
}

/* Location:
 * Qualified Name:     k.b.a.z.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */