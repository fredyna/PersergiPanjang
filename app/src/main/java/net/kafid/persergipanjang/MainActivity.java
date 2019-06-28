package net.kafid.persergipanjang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mPanjang;
    EditText mLebar;
    TextView mHasil;
    Button mHitung;
    Spinner mPilihan;

    String pilihan[] = {"Luas", "Keliling"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPanjang = findViewById(R.id.txt_panjang);
        mLebar = findViewById(R.id.txt_lebar);
        mHasil = findViewById(R.id.txt_hasil);
        mHitung = findViewById(R.id.btn_hitung);
        mPilihan = findViewById(R.id.spin_pilihan);

        ArrayAdapter<String> pilihanAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, pilihan);
        pilihanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPilihan.setAdapter(pilihanAdapter);

        mHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double panjang = Double.valueOf(mPanjang.getText().toString());
                double lebar = Double.valueOf(mLebar.getText().toString());

                if (mPilihan.getSelectedItem().toString().equals(pilihan[0])){
                    luas(panjang, lebar);
                } else{
                    keliling(panjang, lebar);
                }
            }
        });

    }

    private void luas(double panjang, double lebar){
        double luas = panjang * lebar;
        mHasil.setText(String.valueOf(luas));
    }

    private void keliling(double panjang, double lebar){
        double keliling = (2 * panjang) + (2 * lebar);
        mHasil.setText(String.valueOf(keliling));
    }
}
