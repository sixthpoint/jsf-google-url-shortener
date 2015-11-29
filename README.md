# Preface

This project demonstrates how to create a custom JSF composite component using a faces component and renderer. It relies on the google url shortner api.

Installation / Requirements
----------------------------

This project has been tested with JSF 2.X

Begin by including the following 3 files in your project:

- UrlShortenerAPI.java - Creates a oAuth request to the google api to shorten the provided URL
- UrlShortenerComponent.java - Registers a standard faces component and implements the url attribute for passing the url to be shortened
- UrlShortenerRenderer.java - 
- 


In the web.xml


xmlns:six="http://com.sixthpoint.google/urlshortener"


<six:urlshortener id="googleURL" rendered="#{example.url.length() gt 0}" url="#{example.url}" />


