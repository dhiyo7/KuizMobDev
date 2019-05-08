package crud.id.plugin.utsdhiyokuis;

import com.google.gson.annotations.SerializedName;

class Mahasiswa {
    @SerializedName("id")
    private String id;
    @SerializedName("nim")
    private String nim;
    @SerializedName("nama")
    private String nama;
    @SerializedName("hp")
    private String hp;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("keterangan")
    private String keterangan;
    @SerializedName("value")
    private String value;
    @SerializedName("message")
    private String massage;

    public String getId() {
        return id;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getHp() {
        return hp;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getValue() {
        return value;
    }

    public String getMassage() {
        return massage;
    }

    public String getAlamat() {
        return alamat;
    }
}
