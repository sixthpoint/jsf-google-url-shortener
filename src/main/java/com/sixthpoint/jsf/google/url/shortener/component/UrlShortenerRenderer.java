package com.sixthpoint.jsf.google.url.shortener.component;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = UrlShortenerComponent.COMPONENT_FAMILY, rendererType = UrlShortenerRenderer.RENDERER_TYPE)
public class UrlShortenerRenderer extends Renderer {

    /**
     * * Renderer type of {@link UrlShortenerRenderer}.
     */
    public static final String RENDERER_TYPE = "com.sixthpoint.jsf.google.url.shortener.components.UrlShortenerRenderer";

    private static final Logger LOG = Logger.getLogger(UrlShortenerRenderer.class.getName());

    @Override
    public void encodeEnd(FacesContext context, UIComponent uicomponent) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        UrlShortenerComponent component = (UrlShortenerComponent) uicomponent;
        try {
            writer.startElement("a", component);
            writer.writeAttribute("id", component.getClientId(), "id");

            try {

                String url = component.getGoogleURL(component);
                writer.writeAttribute("href", url, "href");

                String style = (String) component.getAttributes().get("style");
                if (style != null) {
                    writer.writeAttribute("style", style, null);
                }

                writer.write(url);

            } catch (IOException ex) {
                writer.write(ex.getMessage());
                LOG.log(Level.SEVERE, "Could not generate Google short URL", ex);
            }

            writer.endElement("a");
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error generating markup", ex);
        }
    }
}
