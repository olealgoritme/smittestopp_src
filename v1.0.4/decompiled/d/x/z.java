package d.x;

import android.graphics.Matrix;
import android.view.View;
import androidx.transition.R.id;

public class z
{
  public void a(View paramView)
  {
    throw null;
  }
  
  public void a(View paramView, float paramFloat)
  {
    throw null;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setLeft(paramInt1);
    paramView.setTop(paramInt2);
    paramView.setRight(paramInt3);
    paramView.setBottom(paramInt4);
  }
  
  public void a(View paramView, Matrix paramMatrix)
  {
    throw null;
  }
  
  public float b(View paramView)
  {
    Float localFloat = (Float)paramView.getTag(R.id.save_non_transition_alpha);
    if (localFloat != null) {
      return paramView.getAlpha() / localFloat.floatValue();
    }
    return paramView.getAlpha();
  }
  
  public void b(View paramView, Matrix paramMatrix)
  {
    throw null;
  }
  
  public void c(View paramView)
  {
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.x.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */