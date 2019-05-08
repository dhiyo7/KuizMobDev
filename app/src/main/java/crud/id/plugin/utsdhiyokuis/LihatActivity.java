package crud.id.plugin.utsdhiyokuis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    private List<Mahasiswa> contactsList;
    private ApiInterface apiInterface;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        getSupportActionBar().setTitle("Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    }

    public void fetchData(){
        Call<List<Mahasiswa>> call = apiInterface.getContacts();
        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                progressBar.setVisibility(View.INVISIBLE);
                contactsList = response.body();
                adapter = new Adapter(LihatActivity.this, contactsList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(LihatActivity.this, "Error : "+ t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
