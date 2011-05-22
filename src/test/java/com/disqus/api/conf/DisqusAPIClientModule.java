package com.disqus.api.conf;

/**
 * Created by IntelliJ IDEA.
 * User: <a href="http://www.ilikeplaces.com"> http://www.ilikeplaces.com </a>
 * Date: 12/18/10
 * Time: 9:31 PM
 */
public class DisqusAPIClientModule extends AbstractDisqusAPIClientModule {

    /**
     * Override this method and return yor Disqus App ID
     *
     * @return Disqus App ID
     */
    @Override
    protected String forumShortName() {
        return "ilikeplaces";
    }

    /**
     * Override this method and return yor Disqus App ID
     *
     * @return Disqus App ID
     */
    @Override
    protected String appSecret() {
        return "";
    }
}
