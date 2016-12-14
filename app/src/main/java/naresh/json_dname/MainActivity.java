package naresh.json_dname;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity
{

    String text;
    int len;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lv);
    }
    public void data(View v)
    {
        text="";
        Mytask my = new Mytask();
        my.execute();

    }

    public class Mytask extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog pd;
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Please wait...");
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... voids)
        {

            try {
                URL ref = new URL("https://api.myjson.com/bins/ff1pp");
                URLConnection urlcon = ref.openConnection();
                HttpURLConnection http = (HttpURLConnection)urlcon;
                http.connect();

                InputStream is = http.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String JSON_STRING = br.readLine();

                JSONObject js = new JSONObject(JSON_STRING);
                JSONArray ja = js.getJSONArray("sampleJson");
                len = ja.length();

                for (int i=0;i<len;i++)
                {
                    JSONObject json = ja.getJSONObject(i);

                    String name = json.getString("name");

                    text = text +name+" "+"\n";
                }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            pd.dismiss();
        }
    }
}
