package no.simula.corona;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import d.b.a.h;
import h.k.b.g;
import java.util.HashMap;

public final class ConsentActivity
  extends h
{
  public HashMap z;
  
  public View a(int paramInt)
  {
    if (z == null) {
      z = new HashMap();
    }
    View localView1 = (View)z.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      z.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void onBackPressed()
  {
    finishAffinity();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558428);
    TextView localTextView = (TextView)a(R.id.privacy_policy);
    g.a(localTextView, "privacy_policy");
    if (Build.VERSION.SDK_INT >= 24) {
      paramBundle = Html.fromHtml(getString(2131886210), 0);
    } else {
      paramBundle = Html.fromHtml(getString(2131886210));
    }
    localTextView.setText(paramBundle);
    paramBundle = (TextView)a(R.id.privacy_policy);
    g.a(paramBundle, "privacy_policy");
    paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    ((Button)a(R.id.confirmConsent)).setOnClickListener(new ConsentActivity.a(0, this));
    ((Button)a(R.id.denyConsent)).setOnClickListener(new ConsentActivity.a(1, this));
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ConsentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */