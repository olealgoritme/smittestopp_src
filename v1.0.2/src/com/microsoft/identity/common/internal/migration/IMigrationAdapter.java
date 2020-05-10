package com.microsoft.identity.common.internal.migration;

import android.util.Pair;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import java.util.List;
import java.util.Map;

public abstract interface IMigrationAdapter<T extends BaseAccount, U extends RefreshToken>
{
  public abstract List<Pair<T, U>> adapt(Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.migration.IMigrationAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */