package com.haribdncc.kuisbahasainggris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //Pertanyaan Kuis
    String[] pertanyaan_kuis = new String[]{
            "1. What number is the head part?",
            "2. What number are showed leg and foot?",
            "3. Number 11 is part of?",
            "4. Numbers 5 and 6 are part?",
            "5. What number is showed ear?",
    };

    //Pilihan Jawaban
    String[] pilihan_jawaban = new String[]{
            "Number 1","Number 2","Number 4","Number 13",
            "Number 2 and 3","Number 4 and 5","Number 6 and 7","Number 8 and 9",
            "Hair","Eye","Ear","Mouth",
            "Eye and Eyebrows","Neck and Stomach","Arm and Hand","Leg and Foot",
            "Number 2","Number 4","Number 3","Number 12",
    };

    //Jawaban Yang Benar
    String[] jawaban_benar = new String[]{
            "Number 1",
            "Number 6 and 7",
            "Mouth",
            "Arm and Hand",
            "Number 4",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton)findViewById(R.id.pilihanA);
        PilihanB = (RadioButton)findViewById(R.id.pilihanB);
        PilihanC = (RadioButton)findViewById(R.id.pilihanC);
        PilihanD = (RadioButton)findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar=0;
        salah=0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this, "Choose The Answer", Toast.LENGTH_SHORT).show();
        }
    }
}
