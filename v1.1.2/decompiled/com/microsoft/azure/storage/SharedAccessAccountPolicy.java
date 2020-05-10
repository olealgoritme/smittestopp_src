package com.microsoft.azure.storage;

import java.util.EnumSet;

public final class SharedAccessAccountPolicy
  extends SharedAccessPolicy
{
  public EnumSet<SharedAccessAccountPermissions> permissions;
  public SharedAccessProtocols protocols;
  public IPRange range;
  public EnumSet<SharedAccessAccountResourceType> resourceTypes;
  public EnumSet<SharedAccessAccountService> services;
  
  public EnumSet<SharedAccessAccountPermissions> getPermissions()
  {
    return permissions;
  }
  
  public SharedAccessProtocols getProtocols()
  {
    return protocols;
  }
  
  public IPRange getRange()
  {
    return range;
  }
  
  public EnumSet<SharedAccessAccountResourceType> getResourceTypes()
  {
    return resourceTypes;
  }
  
  public EnumSet<SharedAccessAccountService> getServices()
  {
    return services;
  }
  
  public String permissionsToString()
  {
    return SharedAccessAccountPermissions.permissionsToString(getPermissions());
  }
  
  public String resourceTypesToString()
  {
    return SharedAccessAccountResourceType.resourceTypesToString(getResourceTypes());
  }
  
  public String servicesToString()
  {
    return SharedAccessAccountService.servicesToString(getServices());
  }
  
  public void setPermissions(EnumSet<SharedAccessAccountPermissions> paramEnumSet)
  {
    permissions = paramEnumSet;
  }
  
  public void setPermissionsFromString(String paramString)
  {
    setPermissions(SharedAccessAccountPermissions.permissionsFromString(paramString));
  }
  
  public void setProtocols(SharedAccessProtocols paramSharedAccessProtocols)
  {
    protocols = paramSharedAccessProtocols;
  }
  
  public void setRange(IPRange paramIPRange)
  {
    range = paramIPRange;
  }
  
  public void setResourceTypeFromString(String paramString)
  {
    setResourceTypes(SharedAccessAccountResourceType.resourceTypesFromString(paramString));
  }
  
  public void setResourceTypes(EnumSet<SharedAccessAccountResourceType> paramEnumSet)
  {
    resourceTypes = paramEnumSet;
  }
  
  public void setServiceFromString(String paramString)
  {
    setServices(SharedAccessAccountService.servicesFromString(paramString));
  }
  
  public void setServices(EnumSet<SharedAccessAccountService> paramEnumSet)
  {
    services = paramEnumSet;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.SharedAccessAccountPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */