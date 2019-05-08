package crud.id.plugin.utsdhiyokuis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;

    private EditText etNim, etNama, etAlamat, etHp, etDes;
    private Button btnTambah, btnLihat;

    String extr_id;
    String extr_nim;
    String extr_nama;
    String extr_alamat;
    String extr_hp;
    String extr_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        extr_id = i.getStringExtra("id");
        extr_nim = i.getStringExtra("nim");
        extr_nama = i.getStringExtra("nama");
        extr_alamat = i.getStringExtra("alamat");
        extr_hp = i.getStringExtra("hp");
        extr_des = i.getStringExtra("deskripsi");

        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etHp = findViewById(R.id.etHp);
        etDes = findViewById(R.id.etDes);

        btnTambah = findViewById(R.id.btnTambah);
        btnLihat = findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LihatActivity.class);
                startActivity(intent);
            }
        });

        kondisi(extr_id);
    }

    private void insertUser() {

//        boolean snim = etNim.getText().toString().length()==0;
//        etNim.setError("Email diperlukan!");

        String snim = etNim.getText().toString();
        String snama = etNama.getText().toString();
        String salamat = etAlamat.getText().toString();
        String shp = etHp.getText().toString();
        String sdes = etDes.getText().toString();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Mahasiswa> call = apiInterface.insertUser(snim, snama, salamat, shp, sdes);
        call.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                if (value.equals("1")) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Jaringan Error! " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void kondisi(String kond) {

        if (kond == null) {

            btnTambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    insertUser();
                }
            });

        }
    }
}
