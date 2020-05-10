package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.color;
import androidx.appcompat.R.drawable;

public final class j$a
  implements n0.e
{
  public final int[] a = { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
  public final int[] b = { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
  public final int[] c = { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light };
  public final int[] d = { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
  public final int[] e = { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
  public final int[] f = { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim };
  
  public final ColorStateList a(Context paramContext, int paramInt)
  {
    int i = s0.b(paramContext, R.attr.colorControlHighlight);
    int j = s0.a(paramContext, R.attr.colorButtonNormal);
    int[] arrayOfInt1 = s0.b;
    int[] arrayOfInt2 = s0.d;
    int k = d.i.c.a.a(i, paramInt);
    paramContext = s0.c;
    i = d.i.c.a.a(i, paramInt);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, paramContext, s0.f }, new int[] { j, k, i, paramInt });
  }
  
  public final void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (e0.a(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = j.b;
    }
    localDrawable.setColorFilter(j.a(paramInt, paramDrawable));
  }
  
  public final boolean a(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++) {
      if (paramArrayOfInt[j] == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public ColorStateList b(Context paramContext, int paramInt)
  {
    if (paramInt == R.drawable.abc_edit_text_material) {
      return d.b.b.a.a.b(paramContext, R.color.abc_tint_edittext);
    }
    if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
      return d.b.b.a.a.b(paramContext, R.color.abc_tint_switch_track);
    }
    if (paramInt == R.drawable.abc_switch_thumb_material)
    {
      int[][] arrayOfInt = new int[3][];
      int[] arrayOfInt1 = new int[3];
      ColorStateList localColorStateList = s0.c(paramContext, R.attr.colorSwitchThumbNormal);
      if ((localColorStateList != null) && (localColorStateList.isStateful()))
      {
        arrayOfInt[0] = s0.b;
        arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
        arrayOfInt[1] = s0.e;
        arrayOfInt1[1] = s0.b(paramContext, R.attr.colorControlActivated);
        arrayOfInt[2] = s0.f;
        arrayOfInt1[2] = localColorStateList.getDefaultColor();
      }
      else
      {
        arrayOfInt[0] = s0.b;
        arrayOfInt1[0] = s0.a(paramContext, R.attr.colorSwitchThumbNormal);
        arrayOfInt[1] = s0.e;
        arrayOfInt1[1] = s0.b(paramContext, R.attr.colorControlActivated);
        arrayOfInt[2] = s0.f;
        arrayOfInt1[2] = s0.b(paramContext, R.attr.colorSwitchThumbNormal);
      }
      return new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
      return a(paramContext, s0.b(paramContext, R.attr.colorButtonNormal));
    }
    if (paramInt == R.drawable.abc_btn_borderless_material) {
      return a(paramContext, 0);
    }
    if (paramInt == R.drawable.abc_btn_colored_material) {
      return a(paramContext, s0.b(paramContext, R.attr.colorAccent));
    }
    if ((paramInt != R.drawable.abc_spinner_mtrl_am_alpha) && (paramInt != R.drawable.abc_spinner_textfield_background_material))
    {
      if (a(b, paramInt)) {
        return s0.c(paramContext, R.attr.colorControlNormal);
      }
      if (a(e, paramInt)) {
        return d.b.b.a.a.b(paramContext, R.color.abc_tint_default);
      }
      if (a(f, paramInt)) {
        return d.b.b.a.a.b(paramContext, R.color.abc_tint_btn_checkable);
      }
      if (paramInt == R.drawable.abc_seekbar_thumb_material) {
        return d.b.b.a.a.b(paramContext, R.color.abc_tint_seek_thumb);
      }
      return null;
    }
    return d.b.b.a.a.b(paramContext, R.color.abc_tint_spinner);
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */