package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

public enum AzureActiveDirectoryPromptBehavior
{
  static
  {
    ALWAYS = new AzureActiveDirectoryPromptBehavior("ALWAYS", 1);
    REFRESH_SESSION = new AzureActiveDirectoryPromptBehavior("REFRESH_SESSION", 2);
    AzureActiveDirectoryPromptBehavior localAzureActiveDirectoryPromptBehavior = new AzureActiveDirectoryPromptBehavior("FORCE_PROMPT", 3);
    FORCE_PROMPT = localAzureActiveDirectoryPromptBehavior;
    $VALUES = new AzureActiveDirectoryPromptBehavior[] { AUTO, ALWAYS, REFRESH_SESSION, localAzureActiveDirectoryPromptBehavior };
  }
  
  public AzureActiveDirectoryPromptBehavior() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryPromptBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */