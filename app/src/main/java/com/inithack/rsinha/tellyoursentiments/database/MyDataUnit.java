package com.inithack.rsinha.tellyoursentiments.database;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
/**
 * Created by rsinha on 2/11/17.
 */

public class MyDataUnit {
    private String text, positive, negative, neutral;
    private ArrayList<Emotions> emotions;
    private String TAG="database";

    public MyDataUnit(String text){
        emotions=new ArrayList<Emotions>();
        this.text=text;
        getSentiments();
    }

    public void getSentiments(){
        new GetData(true).execute();
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
        public GetData(boolean sentiment){
            if(sentiment)
                link=link+"sentiment";
            else
                link=link+"emotion";
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Client client = ClientBuilder.newClient();
            Entity payload = Entity.json("{  'text': '"+text+"',  'level': 'sentence',  'bias': {    'positive': 3.5,    'neutral': 2.7,    'negative': 18  }}");
            Response response = client.target(link)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .post(payload);

            Log.i(TAG,"status: " + response.getStatus());
            Log.i(TAG,"headers: " + response.getHeaders());
            Log.i(TAG,"body:" + response.readEntity(String.class));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
