package d.i.i;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class c
{
  public static boolean a = false;
  public static Method b;
  public static boolean c = false;
  public static Field d;
  
  public static boolean a(c.a parama, View paramView, Window.Callback paramCallback, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (parama == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 28) {
      return parama.superDispatchKeyEvent(paramKeyEvent);
    }
    boolean bool3 = paramCallback instanceof Activity;
    Method localMethod = null;
    Object localObject = null;
    boolean bool4 = true;
    boolean bool5 = true;
    if (bool3)
    {
      paramView = (Activity)paramCallback;
      paramView.onUserInteraction();
      parama = paramView.getWindow();
      if (parama.hasFeature(8))
      {
        paramCallback = paramView.getActionBar();
        if ((paramKeyEvent.getKeyCode() == 82) && (paramCallback != null) && (a)) {}
      }
    }
    try
    {
      b = paramCallback.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      a = true;
      localMethod = b;
      bool1 = bool2;
      if (localMethod != null) {
        try
        {
          bool1 = ((Boolean)localMethod.invoke(paramCallback, new Object[] { paramKeyEvent })).booleanValue();
        }
        catch (IllegalAccessException|InvocationTargetException paramCallback)
        {
          bool1 = bool2;
        }
      }
      if (bool1)
      {
        bool1 = bool5;
      }
      else if (parama.superDispatchKeyEvent(paramKeyEvent))
      {
        bool1 = bool5;
      }
      else
      {
        paramCallback = parama.getDecorView();
        if (n.a(paramCallback, paramKeyEvent))
        {
          bool1 = bool5;
        }
        else
        {
          parama = (c.a)localObject;
          if (paramCallback != null) {
            parama = paramCallback.getKeyDispatcherState();
          }
          bool1 = paramKeyEvent.dispatch(paramView, parama, paramView);
        }
      }
      return bool1;
      if ((paramCallback instanceof Dialog))
      {
        paramView = (Dialog)paramCallback;
        if (c) {}
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        parama = Dialog.class.getDeclaredField("mOnKeyListener");
        d = parama;
        parama.setAccessible(true);
        c = true;
        parama = d;
        if (parama != null) {}
        try
        {
          parama = (DialogInterface.OnKeyListener)parama.get(paramView);
        }
        catch (IllegalAccessException parama)
        {
          for (;;) {}
        }
        parama = null;
        if ((parama != null) && (parama.onKey(paramView, paramKeyEvent.getKeyCode(), paramKeyEvent)))
        {
          bool1 = bool4;
        }
        else
        {
          parama = paramView.getWindow();
          if (parama.superDispatchKeyEvent(paramKeyEvent))
          {
            bool1 = bool4;
          }
          else
          {
            paramCallback = parama.getDecorView();
            if (n.a(paramCallback, paramKeyEvent))
            {
              bool1 = bool4;
            }
            else
            {
              parama = localMethod;
              if (paramCallback != null) {
                parama = paramCallback.getKeyDispatcherState();
              }
              bool1 = paramKeyEvent.dispatch(paramView, parama, paramView);
            }
          }
        }
        return bool1;
        if (((paramView != null) && (n.a(paramView, paramKeyEvent))) || (parama.superDispatchKeyEvent(paramKeyEvent))) {
          bool1 = true;
        }
        return bool1;
        localNoSuchMethodException = localNoSuchMethodException;
      }
      catch (NoSuchFieldException parama)
      {
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.i.i.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */