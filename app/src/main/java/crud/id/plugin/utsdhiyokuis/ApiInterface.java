package crud.id.plugin.utsdhiyokuis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("api/readcontacts.php")
    Call<List<Mahasiswa>> getContacts();

    @FormUrlEncoded
    @POST("api/addcontact.php")
    public Call<Mahasiswa> insertUser(
            @Field("nim") String nim,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("hp") String hp,
            @Field("keterangan") String keterangan);
}
