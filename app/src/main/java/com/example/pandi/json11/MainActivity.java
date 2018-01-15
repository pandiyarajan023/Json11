package com.example.pandi.json11;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    EditText name,email,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        number=(EditText) findViewById(R.id.phoneno);
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflatr the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void send(View v)
    {
        new Send().execute();
    }


    class Send extends AsyncTask<String, Void, Long>
    {
        // Under the method automatically create

        @Override
        protected Long doInBackground(String... strings) {

            String Name=name.getText().toString();
            String Email=email.getText().toString();
            String Number=number.getText().toString();

            HttpClient httpClient=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost("https://httpsrajan000webhostappcom.000webhostapp.com/phpcode.php");

            try
            {
                List<NameValuePair> nameValuePairs= new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("Name", Name));
                nameValuePairs.add(new BasicNameValuePair("Email", Email));
                nameValuePairs.add(new BasicNameValuePair("Number", Number));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));


                HttpResponse response=httpClient.execute(httpPost);
            }
            catch(Exception e)
            {

            }
            return null;
        }

    }
}
