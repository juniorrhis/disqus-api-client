package com.disqus.api.client;

import com.disqus.api.conf.DisqusAPIClientModule;
import com.disqus.api.impl.Client;
import com.disqus.api.impl.ClientFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by IntelliJ IDEA.
 * User: <a href="http://www.ilikeplaces.com"> http://www.ilikeplaces.com </a>
 * Date: 12/18/10
 * Time: 9:33 PM
 */
public class DisqusAPIClient {

     public static void main(final String[] args) throws JSONException {
        final Injector injector = Guice.createInjector(new DisqusAPIClientModule());
        final ClientFactory clientFactory = injector.getInstance(ClientFactory.class);
        final Client threads = clientFactory.getInstance("http://disqus.com/api/3.0/threads/");
        final Client posts = clientFactory.getInstance("http://disqus.com/api/3.0/posts/");

         final Map<String, String> threadParams = new HashMap<String,String>();
         threadParams.put("thread", "link:http://www.ilikeplaces.com/page/Antananarivo_of_Madagascar?WOEID=2346150");
         final JSONObject threadJsonObject = threads.get("list", threadParams);
         System.out.println(threadJsonObject);
         System.out.println(threadJsonObject.getJSONArray("response").getJSONObject(0).get("id"));

         final Map<String, String> postParams = new HashMap<String,String>();
         postParams.put("thread", threadJsonObject.getJSONArray("response").getJSONObject(0).get("id").toString());
         final JSONObject postJsonObject = posts.get("list", postParams);
         System.out.println(postJsonObject);
         System.out.println(postJsonObject.getJSONArray("response").getJSONObject(0));
         System.out.println(postJsonObject.getJSONArray("response").getJSONObject(0).get("raw_message"));
     }
}
