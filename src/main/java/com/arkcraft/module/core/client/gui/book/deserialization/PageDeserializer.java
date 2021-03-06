package com.arkcraft.module.core.client.gui.book.deserialization;

import com.arkcraft.lib.LogHelper;
import com.arkcraft.module.core.client.gui.book.pages.Page;
import com.arkcraft.module.core.client.gui.book.pages.PageData;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

/**
 * @author Vastatio
 */
public class PageDeserializer implements JsonDeserializer<Page>
{
    @Override
    public Page deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context)
    {
        JsonObject jObject = json.getAsJsonObject();
        try
        {
            LogHelper.info("Deserializing Objects! PageDeserializer.deserialize() called!");
            Class<? extends Page> pageClass = PageData.getPageClass(jObject.get("type").getAsString());
            LogHelper.info("Reached after pageClass.");

            LogHelper.info(jObject.get("type") == null ? "JObject is null!" : "JObject is not null.");
            LogHelper.info(pageClass == null ? "Page Class is null!" : "Page class is not null.");
            return context.deserialize(jObject, pageClass);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
