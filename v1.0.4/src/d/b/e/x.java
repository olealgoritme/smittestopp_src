package d.b.e;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

public final class x
{
  public TextView a;
  public TextClassifier b;
  
  public x(TextView paramTextView)
  {
    if (paramTextView != null)
    {
      a = paramTextView;
      return;
    }
    throw null;
  }
  
  public TextClassifier a()
  {
    TextClassifier localTextClassifier = b;
    Object localObject = localTextClassifier;
    if (localTextClassifier == null)
    {
      localObject = (TextClassificationManager)a.getContext().getSystemService(TextClassificationManager.class);
      if (localObject != null) {
        return ((TextClassificationManager)localObject).getTextClassifier();
      }
      localObject = TextClassifier.NO_OP;
    }
    return (TextClassifier)localObject;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */