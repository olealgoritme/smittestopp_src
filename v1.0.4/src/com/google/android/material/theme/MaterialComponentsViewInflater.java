package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatViewInflater;
import d.b.e.f;
import e.c.a.b.f.a;

@Keep
public class MaterialComponentsViewInflater
  extends AppCompatViewInflater
{
  public f createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new a(paramContext, paramAttributeSet);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.theme.MaterialComponentsViewInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */