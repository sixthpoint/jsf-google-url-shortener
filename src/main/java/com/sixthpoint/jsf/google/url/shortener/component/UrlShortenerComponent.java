package com.sixthpoint.jsf.google.url.shortener.component;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent(UrlShortenerComponent.COMPONENT_TYPE)
public class UrlShortenerComponent extends UIComponentBase {

    /**
     * * Component family of {@link UrlShortenerComponent}.
     */
    public static final String COMPONENT_FAMILY = "UrlShortener";

    /**
     * * Component type of {@link UrlShortenerComponent}.
     */
    public static final String COMPONENT_TYPE = "UrlShortener";

    /**
     * Attribute name constant for url.
     */
    private static final String URL_TAG = "url";

    /**
     * Default value for the url attribute.
     */
    private static final String URL_DEFAULT = "http://www.sixthpoint.com/";

    /**
     * Set the component tree family name
     *
     * @return
     */
    @Override
    public String getFamily() {
        return UrlShortenerComponent.COMPONENT_FAMILY;
    }

    /**
     * Perform API call
     *
     * @param component
     * @return
     * @throws IOException
     */
    public String getGoogleURL(UIComponent component) throws IOException {

        UrlShortenerAPI api = new UrlShortenerAPI();
        return api.getGoogleURL(getUrl());
    }

    /**
     * Get the tag value from the state helper
     *
     * @return
     */
    public String getUrl() {
        return (String) getStateHelper().eval(URL_TAG, URL_DEFAULT);
    }

    /**
     * Set the tag value to the state helper
     *
     * @param url
     */
    public void setUrl(String url) {
        getStateHelper().put(URL_TAG, url);
    }

}
