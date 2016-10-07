package atpl.cc.tinkerlust;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;


public class TinkerLustApi extends DefaultApi10a {

    private static class InstanceHolder {
        private static final TinkerLustApi INSTANCE = new TinkerLustApi();
    }

    public static TinkerLustApi instance() {
        return InstanceHolder.INSTANCE;
    }
    @Override
    public String getRequestTokenEndpoint() {
        return null;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return null;
    }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return null;
    }

}
