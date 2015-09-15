package com.arkcraft.mod.core.book;

import java.lang.reflect.Type;

import com.arkcraft.mod.core.lib.LogHelper;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class BookDeserializer implements JsonDeserializer<BookDocument> {

	@Override
	public BookDocument deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		LogHelper.info("BookDeserializer Constructor called!");
		final JsonObject jObject = json.getAsJsonObject();
		
		Page[] pages = context.deserialize(jObject.get("entries"), Page[].class);
		BookDocument doc = new BookDocument();
		doc.setEntries(pages);
		
		return doc;
	}

	
}