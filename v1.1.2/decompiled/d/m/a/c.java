package d.m.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import d.b.a.s;
import d.f.d;
import d.i.a.a.b;
import d.i.a.a.d;
import d.o.e0;
import d.o.f0;
import d.o.g;
import d.o.g.a;
import d.o.g.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class c
  extends ComponentActivity
  implements a.b, a.d
{
  public static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  public static final String FRAGMENTS_TAG = "android:support:fragments";
  public static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  public static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  public static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  public static final String TAG = "FragmentActivity";
  public boolean mCreated;
  public final d.o.m mFragmentLifecycleRegistry;
  public final k mFragments;
  public int mNextCandidateRequestIndex;
  public d.f.i<String> mPendingFragmentActivityResults;
  public boolean mRequestedPermissionsFromFragment;
  public boolean mResumed;
  public boolean mStartedActivityFromFragment;
  public boolean mStartedIntentSenderFromFragment;
  public boolean mStopped;
  
  public c()
  {
    a locala = new a();
    s.a(locala, "callbacks == null");
    mFragments = new k(locala);
    mFragmentLifecycleRegistry = new d.o.m(this);
    mStopped = true;
  }
  
  public c(int paramInt)
  {
    super(paramInt);
    a locala = new a();
    s.a(locala, "callbacks == null");
    mFragments = new k(locala);
    mFragmentLifecycleRegistry = new d.o.m(this);
    mStopped = true;
  }
  
  private int allocateRequestIndex(Fragment paramFragment)
  {
    if (mPendingFragmentActivityResults.b() < 65534)
    {
      for (;;)
      {
        d.f.i locali = mPendingFragmentActivityResults;
        i = mNextCandidateRequestIndex;
        if (x) {
          locali.a();
        }
        if (d.a(y, A, i) < 0) {
          break;
        }
        mNextCandidateRequestIndex = ((mNextCandidateRequestIndex + 1) % 65534);
      }
      int i = mNextCandidateRequestIndex;
      mPendingFragmentActivityResults.c(i, mWho);
      mNextCandidateRequestIndex = ((mNextCandidateRequestIndex + 1) % 65534);
      return i;
    }
    throw new IllegalStateException("Too many pending Fragment activity results.");
  }
  
  public static void checkForValidRequestCode(int paramInt)
  {
    if ((paramInt & 0xFFFF0000) == 0) {
      return;
    }
    throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
  }
  
  private void markFragmentsCreated()
  {
    while (markState(getSupportFragmentManager(), g.b.CREATED)) {}
  }
  
  public static boolean markState(p paramp, g.b paramb)
  {
    paramp = c.c().iterator();
    boolean bool1 = false;
    while (paramp.hasNext())
    {
      Fragment localFragment = (Fragment)paramp.next();
      if (localFragment != null)
      {
        boolean bool2 = bool1;
        if (localFragment.getHost() != null) {
          bool2 = bool1 | markState(localFragment.getChildFragmentManager(), paramb);
        }
        bool1 = bool2;
        if (getLifecycleb.isAtLeast(g.b.STARTED))
        {
          mLifecycleRegistry.a(paramb);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return mFragments.a.A.f.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("  ");
    localObject = ((StringBuilder)localObject).toString();
    paramPrintWriter.print((String)localObject);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(mCreated);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(mStopped);
    if (getApplication() != null) {
      d.p.a.a.a(this).a((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    mFragments.a.A.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public p getSupportFragmentManager()
  {
    return mFragments.a.A;
  }
  
  @Deprecated
  public d.p.a.a getSupportLoaderManager()
  {
    return d.p.a.a.a(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    mFragments.a();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      i--;
      String str = (String)mPendingFragmentActivityResults.a(i);
      mPendingFragmentActivityResults.c(i);
      if (str == null)
      {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      }
      Fragment localFragment = mFragments.a.A.c(str);
      if (localFragment == null)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Activity result no fragment exists for who: ");
        paramIntent.append(str);
        Log.w("FragmentActivity", paramIntent.toString());
      }
      else
      {
        localFragment.onActivityResult(paramInt1 & 0xFFFF, paramInt2, paramIntent);
      }
      return;
    }
    d.i.a.a.a();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    mFragments.a();
    mFragments.a.A.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = mFragments.a;
    A.a((m)localObject1, (i)localObject1, null);
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getParcelable("android:support:fragments");
      Object localObject2 = mFragments.a;
      if ((localObject2 instanceof f0))
      {
        A.a((Parcelable)localObject1);
        if (paramBundle.containsKey("android:support:next_request_index"))
        {
          mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
          localObject1 = paramBundle.getIntArray("android:support:request_indicies");
          localObject2 = paramBundle.getStringArray("android:support:request_fragment_who");
          if ((localObject1 != null) && (localObject2 != null) && (localObject1.length == localObject2.length))
          {
            mPendingFragmentActivityResults = new d.f.i(localObject1.length);
            for (int i = 0; i < localObject1.length; i++) {
              mPendingFragmentActivityResults.c(localObject1[i], localObject2[i]);
            }
          }
          Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
        }
      }
      else
      {
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
      }
    }
    if (mPendingFragmentActivityResults == null)
    {
      mPendingFragmentActivityResults = new d.f.i(10);
      mNextCandidateRequestIndex = 0;
    }
    super.onCreate(paramBundle);
    mFragmentLifecycleRegistry.a(g.a.ON_CREATE);
    mFragments.a.A.b();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
      k localk = mFragments;
      MenuInflater localMenuInflater = getMenuInflater();
      return bool | a.A.a(paramMenu, localMenuInflater);
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    if (localView == null) {
      return super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    if (localView == null) {
      return super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    mFragments.a.A.c();
    mFragmentLifecycleRegistry.a(g.a.ON_DESTROY);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    mFragments.a.A.d();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    if (paramInt != 0)
    {
      if (paramInt != 6) {
        return false;
      }
      return mFragments.a.A.a(paramMenuItem);
    }
    return mFragments.a.A.b(paramMenuItem);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    mFragments.a.A.a(paramBoolean);
  }
  
  public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    mFragments.a();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      mFragments.a.A.a(paramMenu);
    }
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPause()
  {
    super.onPause();
    mResumed = false;
    mFragments.a.A.a(3);
    mFragmentLifecycleRegistry.a(g.a.ON_PAUSE);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    mFragments.a.A.b(paramBoolean);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    onResumeFragments();
  }
  
  @Deprecated
  public boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt == 0) {
      return onPrepareOptionsPanel(paramView, paramMenu) | mFragments.a.A.b(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    mFragments.a();
    int i = paramInt >> 16 & 0xFFFF;
    if (i != 0)
    {
      i--;
      String str = (String)mPendingFragmentActivityResults.a(i);
      mPendingFragmentActivityResults.c(i);
      if (str == null)
      {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      }
      Fragment localFragment = mFragments.a.A.c(str);
      if (localFragment == null)
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Activity result no fragment exists for who: ");
        paramArrayOfString.append(str);
        Log.w("FragmentActivity", paramArrayOfString.toString());
      }
      else
      {
        localFragment.onRequestPermissionsResult(paramInt & 0xFFFF, paramArrayOfString, paramArrayOfInt);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    mResumed = true;
    mFragments.a();
    mFragments.a.A.d(true);
  }
  
  public void onResumeFragments()
  {
    mFragmentLifecycleRegistry.a(g.a.ON_RESUME);
    p localp = mFragments.a.A;
    u = false;
    v = false;
    localp.a(4);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    markFragmentsCreated();
    mFragmentLifecycleRegistry.a(g.a.ON_STOP);
    Object localObject = mFragments.a.A.l();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (mPendingFragmentActivityResults.b() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", mNextCandidateRequestIndex);
      int[] arrayOfInt = new int[mPendingFragmentActivityResults.b()];
      localObject = new String[mPendingFragmentActivityResults.b()];
      for (int i = 0; i < mPendingFragmentActivityResults.b(); i++)
      {
        arrayOfInt[i] = mPendingFragmentActivityResults.b(i);
        localObject[i] = ((String)mPendingFragmentActivityResults.d(i));
      }
      paramBundle.putIntArray("android:support:request_indicies", arrayOfInt);
      paramBundle.putStringArray("android:support:request_fragment_who", (String[])localObject);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    mStopped = false;
    if (!mCreated)
    {
      mCreated = true;
      localp = mFragments.a.A;
      u = false;
      v = false;
      localp.a(2);
    }
    mFragments.a();
    mFragments.a.A.d(true);
    mFragmentLifecycleRegistry.a(g.a.ON_START);
    p localp = mFragments.a.A;
    u = false;
    v = false;
    localp.a(3);
  }
  
  public void onStateNotSaved()
  {
    mFragments.a();
  }
  
  public void onStop()
  {
    super.onStop();
    mStopped = true;
    markFragmentsCreated();
    p localp = mFragments.a.A;
    v = true;
    localp.a(2);
    mFragmentLifecycleRegistry.a(g.a.ON_STOP);
  }
  
  public void requestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt == -1)
    {
      d.i.a.a.a(this, paramArrayOfString, paramInt);
      return;
    }
    checkForValidRequestCode(paramInt);
    try
    {
      mRequestedPermissionsFromFragment = true;
      d.i.a.a.a(this, paramArrayOfString, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt & 0xFFFF));
      return;
    }
    finally
    {
      mRequestedPermissionsFromFragment = false;
    }
  }
  
  public void setEnterSharedElementCallback(d.i.a.i parami)
  {
    d.i.a.a.d(this);
  }
  
  public void setExitSharedElementCallback(d.i.a.i parami)
  {
    d.i.a.a.e(this);
  }
  
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    if ((!mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if ((!mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    mStartedActivityFromFragment = true;
    if (paramInt == -1) {}
    try
    {
      d.i.a.a.a(this, paramIntent, -1, paramBundle);
      return;
    }
    finally
    {
      mStartedActivityFromFragment = false;
    }
    checkForValidRequestCode(paramInt);
    d.i.a.a.a(this, paramIntent, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt & 0xFFFF), paramBundle);
    mStartedActivityFromFragment = false;
  }
  
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if ((!mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startIntentSenderFromFragment(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    mStartedIntentSenderFromFragment = true;
    if (paramInt1 == -1) {}
    try
    {
      d.i.a.a.a(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    finally
    {
      mStartedIntentSenderFromFragment = false;
    }
    checkForValidRequestCode(paramInt1);
    d.i.a.a.a(this, paramIntentSender, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt1 & 0xFFFF), paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    mStartedIntentSenderFromFragment = false;
  }
  
  public void supportFinishAfterTransition()
  {
    d.i.a.a.b(this);
  }
  
  @Deprecated
  public void supportInvalidateOptionsMenu()
  {
    invalidateOptionsMenu();
  }
  
  public void supportPostponeEnterTransition()
  {
    d.i.a.a.c(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    d.i.a.a.f(this);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt)
  {
    if ((!mRequestedPermissionsFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
  }
  
  public class a
    extends m<c>
    implements f0, d.a.c
  {
    public a()
    {
      super();
    }
    
    public View a(int paramInt)
    {
      return findViewById(paramInt);
    }
    
    public boolean a()
    {
      Window localWindow = getWindow();
      boolean bool;
      if ((localWindow != null) && (localWindow.peekDecorView() != null)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public g getLifecycle()
    {
      return mFragmentLifecycleRegistry;
    }
    
    public OnBackPressedDispatcher getOnBackPressedDispatcher()
    {
      return c.this.getOnBackPressedDispatcher();
    }
    
    public e0 getViewModelStore()
    {
      return c.this.getViewModelStore();
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */