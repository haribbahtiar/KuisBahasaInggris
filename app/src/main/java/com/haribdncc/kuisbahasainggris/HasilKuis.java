package com.haribdncc.kuisbahasainggris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Harib on 13/01/2018.
 */

public class HasilKuis extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Correct Answer : "+MainActivity.benar+"\n Wrong Answer : "+MainActivity.salah);
        nilai.setText(""+MainActivity.hasil);
    }

    public void tryagain(View view){
        finish();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
