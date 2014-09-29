package com.sixthpoint.jsf.google.url.shortener.component;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

/**
 * Simple API for obtaining a Google short URL from an online REST service.
 */
public class UrlShortenerAPI {

    /**
     * URL to the REST service.
     */
    private static final String API_URL = "https://www.googleapis.com/urlshortener/v1/url";

    /**
     * Property in the JSON output to be extracted.
     */
    private static final String PROPERTY_CONTAINING_OUTPUT = "id";

    /**
     * Gets the shortened URL from Google.
     *
     * @param url
     * @return String
     * @throws IOException
     */
    public String getGoogleURL(String url) throws IOException {

        OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, API_URL);

        // Set header content
        oAuthRequest.addHeader("Content-Type", "application/json");

        // Payload
        oAuthRequest.addPayload("{\"longUrl\": \"" + url + "\"}");

        // Send the request
        Response r = oAuthRequest.send();

        // Determine generic map type
        Type typeOfMap = new TypeToken<Map<String, String>>() {
        }.getType();

        // Json -> Map
        Map<String, String> responseMap = new GsonBuilder().create().fromJson(r.getBody(), typeOfMap);

        return responseMap.get(PROPERTY_CONTAINING_OUTPUT);

    }
}
