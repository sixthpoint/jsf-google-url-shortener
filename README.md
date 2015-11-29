# Preface

This project demonstrates how to create a custom JSF composite component using a faces component and renderer. It relies on the google url shortner api.

Installation / Requirements
----------------------------

This project has been tested with JSF 2.X

Begin by including the following 3 files in your project:

- UrlShortenerAPI.java - Creates a oAuth request to the google api to shorten the provided URL
- UrlShortenerComponent.java - Creates a standard faces component and implements the url attribute for passing the url to be shortened
- UrlShortenerRenderer.java - Generates a link based on the url passed into the custom component to be rendered to the screen

In the web.xml register a new taglib
```xml
<context-param>
   <param-name>javax.faces.FACELETS_LIBRARIES</param-name>
   <param-value>/WEB-INF/googleurlshortener.taglib.xml</param-value>
</context-param>
```
    
Now in the new taglib you need to register the UrlShortener and attribute that will be passed to it. Create the new file in /webapp/WEB-INF/googleurlshortener.taglib.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<facelet-taglib
    xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facelettaglibrary_2_0.xsd"
    version="2.0">
    <namespace>http://com.sixthpoint.google/urlshortener</namespace>
    <tlib-version>1.0</tlib-version>
    <jsp-version>2.2</jsp-version>
    <short-name>googleurlshortener</short-name>
    <uri>http://www.sixthpoint.com/</uri>
    <tag>
        <tag-name>urlshortener</tag-name>
        <component>
            <component-type>UrlShortener</component-type>
            <renderer-type>com.sixthpoint.jsf.google.url.shortener.components.UrlShortenerRenderer</renderer-type>
        </component>
        <attribute>
            <name>url</name>
            <type>java.lang.String</type>
            <description>The url that is to be shortened.</description>
        </attribute>
    </tag>
</facelet-taglib>
```

In each xhtml page you want to use this new component, place the following the namespaces

```xml
xmlns:six="http://com.sixthpoint.google/urlshortener"
```

Now you can use the new component as many times as you want on the page. This is a simple example:

```xml
<six:urlshortener id="googleURL" rendered="#{example.url.length() gt 0}" url="#{example.url}" />
```

A more in depth article can be read here: http://blog.sixthpoint.com/creating-a-simple-jsf-component-google-url-shortener/


