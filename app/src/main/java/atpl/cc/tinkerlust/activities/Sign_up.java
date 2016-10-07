package atpl.cc.tinkerlust.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.github.scribejava.core.oauth.OAuthService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.TinkerLustApi;
import atpl.cc.tinkerlust.adapter.ImageAdapter;

public class Sign_up extends AppCompatActivity {

    final String MAGENTO_API_KEY = "7e22dac7dd012503be3070adb25d1161";
    final String MAGENTO_API_SECRET = "0f44fad1c17c528bd0ca1313312749e6";
    final String MAGENTO_REST_API_URL = "http://128.199.211.72/api/rest/customers";

    private static OAuth1RequestToken requestToken;
    private OAuth10aService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ImageView back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

// To override error of execution of network thread on the main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {

            service = new ServiceBuilder()
                    .apiKey(MAGENTO_API_KEY)
                    .apiSecret(MAGENTO_API_SECRET)
                    .debug()
                    .build(TinkerLustApi.instance());

            System.out.println("Magento'srkflow");
            System.out.println();

            // Obtain the Request Token
            System.out.println("FetchingRequest Token...");
            requestToken = service.getRequestToken();
            System.out.println("GotRequest Token!");
            System.out.println();

            System.out.println("FetchingAuthorization URL...");
            String authorizationUrl = service.getAuthorizationUrl(requestToken);
            Log.d("DEBUG", authorizationUrl);
            System.out.println("GotAuthorization URL!");
            System.out.println("Nownd authorize Main here:");
            System.out.println(authorizationUrl);
            System.out.println("Ande the authorization code here");
            System.out.print(">>");

            System.out.println();
            System.out.println("TradingRequest Token for an Access Token...");
            OAuth1AccessToken accessToken = service.getAccessToken(requestToken, "728b18ba7112a3c25743d9138b873f1f");
            System.out.println("GotAccess Token!");
//            System.out.println("(if curious it looks like this: " + accessToken + " )");
            System.out.println();

            OAuthRequest request = new OAuthRequest(Verb.POST, MAGENTO_REST_API_URL ,service);
            service.signRequest(accessToken, request);
            com.github.scribejava.core.model.Response response = request.send();
            System.out.println();
            System.out.println(response.getCode());
            System.out.println(response.getBody());
            System.out.println();


        } catch (Exception e) {
            e.printStackTrace();
        }






    }







    /*public void signUp()
    {
        final String url= "http://128.199.211.72/api/rest/customers";

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest jor = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response","Email Confirmation => \n"+response);

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley","Error"+error);
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("oauth_consumer_key", "7e22dac7dd012503be3070adb25d1161");
                params.put("oauth_consumer_secret", "0f44fad1c17c528bd0ca1313312749e6");
                params.put("oauth_token","50aa1ecb99a8fec45782d6e6c4bd7048");
                params.put("oauth_token_secret","728b18ba7112a3c25743d9138b873f1f");

                return params;
            }
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
            @Override
            public byte[] getBody() throws AuthFailureError {

                String body = getXml("ashish","rana","12345","abc@gmail.com");

                return body.getBytes();
            }
        };

        requestQueue.add(jor);
    }


      String getXml(String firstname,String lastname, String password,String email)
      {
StringBuilder sb=new StringBuilder();
          sb.append("<?xml version=\"1.0\"?>\n" +
                  "<magento_api>\n"+" <firstname>"+firstname+"</firstname>\n" +
                  "    <lastname>"+lastname+"</lastname>\n" +
                  "    <password>"+password+"</password>\n" +
                  "    <email>"+email+"</email>\n" +
                  "    <website_id>1</website_id>\n" +
                  "    <group_id>1</group_id>\n" +
                  "</magento_api>");



      return  sb.toString();
      }
*/
}
