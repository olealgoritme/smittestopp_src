package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Extensions
  implements Model
{
  public static final String APP = "app";
  public static final String DEVICE = "device";
  public static final String LOC = "loc";
  public static final String METADATA = "metadata";
  public static final String NET = "net";
  public static final String OS = "os";
  public static final String PROTOCOL = "protocol";
  public static final String SDK = "sdk";
  public static final String USER = "user";
  public AppExtension app;
  public DeviceExtension device;
  public LocExtension loc;
  public MetadataExtension metadata;
  public NetExtension net;
  public OsExtension os;
  public ProtocolExtension protocol;
  public SdkExtension sdk;
  public UserExtension user;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (Extensions.class == paramObject.getClass()))
    {
      paramObject = (Extensions)paramObject;
      Object localObject = metadata;
      if (localObject != null ? !((MetadataExtension)localObject).equals(metadata) : metadata != null) {
        return false;
      }
      localObject = protocol;
      if (localObject != null ? !((ProtocolExtension)localObject).equals(protocol) : protocol != null) {
        return false;
      }
      localObject = user;
      if (localObject != null ? !((UserExtension)localObject).equals(user) : user != null) {
        return false;
      }
      localObject = device;
      if (localObject != null ? !((DeviceExtension)localObject).equals(device) : device != null) {
        return false;
      }
      localObject = os;
      if (localObject != null ? !((OsExtension)localObject).equals(os) : os != null) {
        return false;
      }
      localObject = app;
      if (localObject != null ? !((AppExtension)localObject).equals(app) : app != null) {
        return false;
      }
      localObject = net;
      if (localObject != null ? !((NetExtension)localObject).equals(net) : net != null) {
        return false;
      }
      localObject = sdk;
      if (localObject != null ? !((SdkExtension)localObject).equals(sdk) : sdk != null) {
        return false;
      }
      localObject = loc;
      paramObject = loc;
      if (localObject != null) {
        bool = ((LocExtension)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public AppExtension getApp()
  {
    return app;
  }
  
  public DeviceExtension getDevice()
  {
    return device;
  }
  
  public LocExtension getLoc()
  {
    return loc;
  }
  
  public MetadataExtension getMetadata()
  {
    return metadata;
  }
  
  public NetExtension getNet()
  {
    return net;
  }
  
  public OsExtension getOs()
  {
    return os;
  }
  
  public ProtocolExtension getProtocol()
  {
    return protocol;
  }
  
  public SdkExtension getSdk()
  {
    return sdk;
  }
  
  public UserExtension getUser()
  {
    return user;
  }
  
  public int hashCode()
  {
    Object localObject = metadata;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((MetadataExtension)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = protocol;
    int k;
    if (localObject != null) {
      k = ((ProtocolExtension)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = user;
    int m;
    if (localObject != null) {
      m = ((UserExtension)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = device;
    int n;
    if (localObject != null) {
      n = ((DeviceExtension)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = os;
    int i1;
    if (localObject != null) {
      i1 = ((OsExtension)localObject).hashCode();
    } else {
      i1 = 0;
    }
    localObject = app;
    int i2;
    if (localObject != null) {
      i2 = ((AppExtension)localObject).hashCode();
    } else {
      i2 = 0;
    }
    localObject = net;
    int i3;
    if (localObject != null) {
      i3 = ((NetExtension)localObject).hashCode();
    } else {
      i3 = 0;
    }
    localObject = sdk;
    int i4;
    if (localObject != null) {
      i4 = ((SdkExtension)localObject).hashCode();
    } else {
      i4 = 0;
    }
    localObject = loc;
    if (localObject != null) {
      i = ((LocExtension)localObject).hashCode();
    }
    return (((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject.has("metadata"))
    {
      localObject = new MetadataExtension();
      ((MetadataExtension)localObject).read(paramJSONObject.getJSONObject("metadata"));
      setMetadata((MetadataExtension)localObject);
    }
    if (paramJSONObject.has("protocol"))
    {
      localObject = new ProtocolExtension();
      ((ProtocolExtension)localObject).read(paramJSONObject.getJSONObject("protocol"));
      setProtocol((ProtocolExtension)localObject);
    }
    if (paramJSONObject.has("user"))
    {
      localObject = new UserExtension();
      ((UserExtension)localObject).read(paramJSONObject.getJSONObject("user"));
      setUser((UserExtension)localObject);
    }
    if (paramJSONObject.has("device"))
    {
      localObject = new DeviceExtension();
      ((DeviceExtension)localObject).read(paramJSONObject.getJSONObject("device"));
      setDevice((DeviceExtension)localObject);
    }
    if (paramJSONObject.has("os"))
    {
      localObject = new OsExtension();
      ((OsExtension)localObject).read(paramJSONObject.getJSONObject("os"));
      setOs((OsExtension)localObject);
    }
    if (paramJSONObject.has("app"))
    {
      localObject = new AppExtension();
      ((AppExtension)localObject).read(paramJSONObject.getJSONObject("app"));
      setApp((AppExtension)localObject);
    }
    if (paramJSONObject.has("net"))
    {
      localObject = new NetExtension();
      ((NetExtension)localObject).read(paramJSONObject.getJSONObject("net"));
      setNet((NetExtension)localObject);
    }
    if (paramJSONObject.has("sdk"))
    {
      localObject = new SdkExtension();
      ((SdkExtension)localObject).read(paramJSONObject.getJSONObject("sdk"));
      setSdk((SdkExtension)localObject);
    }
    if (paramJSONObject.has("loc"))
    {
      localObject = new LocExtension();
      ((LocExtension)localObject).read(paramJSONObject.getJSONObject("loc"));
      setLoc((LocExtension)localObject);
    }
  }
  
  public void setApp(AppExtension paramAppExtension)
  {
    app = paramAppExtension;
  }
  
  public void setDevice(DeviceExtension paramDeviceExtension)
  {
    device = paramDeviceExtension;
  }
  
  public void setLoc(LocExtension paramLocExtension)
  {
    loc = paramLocExtension;
  }
  
  public void setMetadata(MetadataExtension paramMetadataExtension)
  {
    metadata = paramMetadataExtension;
  }
  
  public void setNet(NetExtension paramNetExtension)
  {
    net = paramNetExtension;
  }
  
  public void setOs(OsExtension paramOsExtension)
  {
    os = paramOsExtension;
  }
  
  public void setProtocol(ProtocolExtension paramProtocolExtension)
  {
    protocol = paramProtocolExtension;
  }
  
  public void setSdk(SdkExtension paramSdkExtension)
  {
    sdk = paramSdkExtension;
  }
  
  public void setUser(UserExtension paramUserExtension)
  {
    user = paramUserExtension;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    if (getMetadata() != null)
    {
      paramJSONStringer.key("metadata").object();
      getMetadata().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getProtocol() != null)
    {
      paramJSONStringer.key("protocol").object();
      getProtocol().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getUser() != null)
    {
      paramJSONStringer.key("user").object();
      getUser().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getDevice() != null)
    {
      paramJSONStringer.key("device").object();
      getDevice().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getOs() != null)
    {
      paramJSONStringer.key("os").object();
      getOs().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getApp() != null)
    {
      paramJSONStringer.key("app").object();
      getApp().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getNet() != null)
    {
      paramJSONStringer.key("net").object();
      getNet().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getSdk() != null)
    {
      paramJSONStringer.key("sdk").object();
      getSdk().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getLoc() != null)
    {
      paramJSONStringer.key("loc").object();
      getLoc().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.one.Extensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */