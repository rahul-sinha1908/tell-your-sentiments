package com.inithack.rsinha.tellyoursentiments.database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.inithack.rsinha.tellyoursentiments.MainActivity;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsinha on 2/11/17.
 */

public class MyDataUnit {
    private String text, positive, negative, neutral;
    private ArrayList<Emotions> emotions;
    private String TAG="database";
    private Context context;

    public MyDataUnit(String text, Context cont){
        emotions=new ArrayList<Emotions>();
        this.text=text;
        context=cont;
        getSentiments();
    }

    public void getSentiments(){
        new GetData(true, context).execute();
    }

    public void getEmotions(){

    }

    public void updateOnFireBase(){

    }
    public void getEmotionsID(String s){

    }
    public class Emotions{
        String emotions;
        int value;
    }

    public class GetData extends AsyncTask<Void,Void, Void>{
        private String link="https://api.theysay.io/v1/";
        private Context cont;
        public GetData(boolean sentiment, Context context){
            cont=context;
            if(sentiment)
                link=link+"sentiment";
            else
                link=link+"emotion";
        }

        @Override
        protected Void doInBackground(Void... voids) {
//            Client client = ClientBuilder.newClient();
//            Entity payload = Entity.json("{  'text': '"+text+"',  'level': 'sentence',  'bias': {    'positive': 3.5,    'neutral': 2.7,    'negative': 18  }}");
//            Response response = client.target(link)
//                    .request(MediaType.APPLICATION_JSON_TYPE)
//                    .post(payload);
//
//            Log.i(TAG,"status: " + response.getStatus());
//            Log.i(TAG,"headers: " + response.getHeaders());
//            Log.i(TAG,"body:" + response.readEntity(String.class));

//            HttpClient httpClient= new DefaultHttpClient();
//            HttpPost httpGet=new HttpPost(MainActivity.domain+"PHP/getJson.php");
//            publishProgress("Connecting...");
//            List<NameValuePair> ln=new ArrayList<NameValuePair>();
//            ln.add(new BasicNameValuePair("version",VER+""));
//            ln.add(new BasicNameValuePair("table",MainActivity.CollegeYear));
//            ln.add(new BasicNameValuePair("branch", MainActivity.branch));
//            httpGet.setEntity(new UrlEncodedFormEntity(ln));
//            //Log.i("Check", "Connecting...");
//            HttpResponse httpResponse=httpClient.execute(httpGet);
//            //publishProgress("Entity Creating...");
//            //Log.i("Check","Entity Creating..." );
//            HttpEntity httpEntity=httpResponse.getEntity();
//
//            //Log.i("Check","1st Place");
//            String para = EntityUtils.toString(httpEntity);
//            //Log.i("Check",para);
            //JSONArray jsonArray = new JSONArray(para);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
