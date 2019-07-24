package com.searchBook.support;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import org.springframework.web.util.UriComponentsBuilder;

public final class Util
{
    public static String makeURL(final String url, final String query, final String sort, final String page, final String size, final String target)
    {
        String uriURL = "";
        try
        {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                                                               .queryParam("query", query);

            if ( sort != null )
            {
                builder.queryParam("sort", sort);
            }
            if ( page != null )
            {
                builder.queryParam("page", page);
            }
            if ( size != null )
            {
                builder.queryParam("size", size);
            }
            if ( target != null )
            {
                builder.queryParam("target", target);
            }

            uriURL = URLDecoder.decode(builder.toUriString(), "UTF-8");

        }
        catch ( UnsupportedEncodingException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uriURL;
    }





    public static String makeRandomString()
    {
        Random rnd = new Random();
        return String.valueOf((char) ((rnd.nextInt(26)) + 97));
    }

}
