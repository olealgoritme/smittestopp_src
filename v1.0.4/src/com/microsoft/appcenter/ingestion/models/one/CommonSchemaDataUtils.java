package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import e.a.a.a.a;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonSchemaDataUtils
{
  public static final int DATA_TYPE_DATETIME = 9;
  public static final int DATA_TYPE_DOUBLE = 6;
  public static final int DATA_TYPE_INT64 = 4;
  public static final String METADATA_FIELDS = "f";
  
  public static void addCommonSchemaData(List<TypedProperty> paramList, CommonSchemaLog paramCommonSchemaLog)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      Data localData = new com/microsoft/appcenter/ingestion/models/one/Data;
      localData.<init>();
      paramCommonSchemaLog.setData(localData);
      MetadataExtension localMetadataExtension = new com/microsoft/appcenter/ingestion/models/one/MetadataExtension;
      localMetadataExtension.<init>();
      paramList = paramList.iterator();
      for (;;)
      {
        boolean bool = paramList.hasNext();
        if (!bool) {
          break;
        }
        Object localObject1 = (TypedProperty)paramList.next();
        try
        {
          Object localObject2 = validateProperty((TypedProperty)localObject1);
          Integer localInteger = getMetadataType((TypedProperty)localObject1);
          Object localObject3 = ((TypedProperty)localObject1).getName().split("\\.", -1);
          int i = localObject3.length - 1;
          localObject1 = localData.getProperties();
          localJSONObject = localMetadataExtension.getMetadata();
          Object localObject4;
          for (int j = 0; j < i; j++)
          {
            String str2 = localObject3[j];
            localObject4 = ((JSONObject)localObject1).optJSONObject(str2);
            if (localObject4 == null)
            {
              if (((JSONObject)localObject1).has(str2))
              {
                localObject4 = new java/lang/StringBuilder;
                ((StringBuilder)localObject4).<init>();
                ((StringBuilder)localObject4).append("Property key '");
                ((StringBuilder)localObject4).append(str2);
                ((StringBuilder)localObject4).append("' already has a value, the old value will be overridden.");
                AppCenterLog.warn("AppCenter", ((StringBuilder)localObject4).toString());
              }
              localObject4 = new org/json/JSONObject;
              ((JSONObject)localObject4).<init>();
              ((JSONObject)localObject1).put(str2, localObject4);
              localObject1 = localObject4;
            }
            else
            {
              localObject1 = localObject4;
            }
            localJSONObject = addIntermediateMetadata(localJSONObject, str2);
          }
          localObject3 = localObject3[i];
          if (((JSONObject)localObject1).has((String)localObject3))
          {
            localObject4 = new java/lang/StringBuilder;
            ((StringBuilder)localObject4).<init>();
            ((StringBuilder)localObject4).append("Property key '");
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("' already has a value, the old value will be overridden.");
            AppCenterLog.warn("AppCenter", ((StringBuilder)localObject4).toString());
          }
          ((JSONObject)localObject1).put((String)localObject3, localObject2);
          addLeafMetadata(localInteger, localJSONObject, (String)localObject3);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          AppCenterLog.warn("AppCenter", localIllegalArgumentException.getMessage());
        }
      }
      paramList = localData.getProperties();
      String str1 = paramList.optString("baseType", null);
      JSONObject localJSONObject = paramList.optJSONObject("baseData");
      if ((str1 == null) && (localJSONObject != null))
      {
        AppCenterLog.warn("AppCenter", "baseData was set but baseType is missing.");
        paramList.remove("baseData");
        localMetadataExtension.getMetadata().optJSONObject("f").remove("baseData");
      }
      if ((str1 != null) && (localJSONObject == null))
      {
        AppCenterLog.warn("AppCenter", "baseType was set but baseData is missing.");
        paramList.remove("baseType");
      }
      if (!cleanUpEmptyObjectsInMetadata(localMetadataExtension.getMetadata()))
      {
        if (paramCommonSchemaLog.getExt() == null)
        {
          paramList = new com/microsoft/appcenter/ingestion/models/one/Extensions;
          paramList.<init>();
          paramCommonSchemaLog.setExt(paramList);
        }
        paramCommonSchemaLog.getExt().setMetadata(localMetadataExtension);
      }
      return;
    }
    catch (JSONException paramList)
    {
      for (;;) {}
    }
  }
  
  public static JSONObject addIntermediateMetadata(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("f");
    JSONObject localJSONObject2 = localJSONObject1;
    if (localJSONObject1 == null)
    {
      localJSONObject2 = new JSONObject();
      paramJSONObject.put("f", localJSONObject2);
    }
    localJSONObject1 = localJSONObject2.optJSONObject(paramString);
    paramJSONObject = localJSONObject1;
    if (localJSONObject1 == null)
    {
      paramJSONObject = new JSONObject();
      localJSONObject2.put(paramString, paramJSONObject);
    }
    return paramJSONObject;
  }
  
  public static void addLeafMetadata(Integer paramInteger, JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("f");
    if (paramInteger != null)
    {
      JSONObject localJSONObject2 = localJSONObject1;
      if (localJSONObject1 == null)
      {
        localJSONObject2 = new JSONObject();
        paramJSONObject.put("f", localJSONObject2);
      }
      localJSONObject2.put(paramString, paramInteger);
    }
    else if (localJSONObject1 != null)
    {
      localJSONObject1.remove(paramString);
    }
  }
  
  public static boolean cleanUpEmptyObjectsInMetadata(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject((String)localIterator.next());
      if ((localJSONObject != null) && (cleanUpEmptyObjectsInMetadata(localJSONObject))) {
        localIterator.remove();
      }
    }
    boolean bool;
    if (paramJSONObject.length() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static Integer getMetadataType(TypedProperty paramTypedProperty)
  {
    if ((paramTypedProperty instanceof LongTypedProperty)) {
      return Integer.valueOf(4);
    }
    if ((paramTypedProperty instanceof DoubleTypedProperty)) {
      return Integer.valueOf(6);
    }
    if ((paramTypedProperty instanceof DateTimeTypedProperty)) {
      return Integer.valueOf(9);
    }
    return null;
  }
  
  public static Object validateProperty(TypedProperty paramTypedProperty)
  {
    Object localObject = paramTypedProperty.getName();
    if (localObject != null)
    {
      if ((((String)localObject).equals("baseType")) && (!(paramTypedProperty instanceof StringTypedProperty))) {
        throw new IllegalArgumentException("baseType must be a string.");
      }
      if (!((String)localObject).startsWith("baseType."))
      {
        if (!((String)localObject).equals("baseData"))
        {
          if ((paramTypedProperty instanceof StringTypedProperty))
          {
            paramTypedProperty = ((StringTypedProperty)paramTypedProperty).getValue();
          }
          else if ((paramTypedProperty instanceof LongTypedProperty))
          {
            paramTypedProperty = Long.valueOf(((LongTypedProperty)paramTypedProperty).getValue());
          }
          else if ((paramTypedProperty instanceof DoubleTypedProperty))
          {
            paramTypedProperty = Double.valueOf(((DoubleTypedProperty)paramTypedProperty).getValue());
          }
          else if ((paramTypedProperty instanceof DateTimeTypedProperty))
          {
            paramTypedProperty = JSONDateUtils.toString(((DateTimeTypedProperty)paramTypedProperty).getValue());
          }
          else
          {
            if (!(paramTypedProperty instanceof BooleanTypedProperty)) {
              break label177;
            }
            paramTypedProperty = Boolean.valueOf(((BooleanTypedProperty)paramTypedProperty).getValue());
          }
          if (paramTypedProperty != null) {
            return paramTypedProperty;
          }
          throw new IllegalArgumentException(a.a("Value of property with key '", (String)localObject, "' cannot be null."));
          label177:
          localObject = a.a("Unsupported property type: ");
          ((StringBuilder)localObject).append(paramTypedProperty.getType());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        throw new IllegalArgumentException("baseData must be an object.");
      }
      throw new IllegalArgumentException("baseType must be a string.");
    }
    throw new IllegalArgumentException("Property key cannot be null.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.one.CommonSchemaDataUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */