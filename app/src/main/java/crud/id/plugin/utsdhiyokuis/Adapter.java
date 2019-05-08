package crud.id.plugin.utsdhiyokuis;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Mahasiswa> contacts;
    Context context;

    public Adapter(Context context, List<Mahasiswa> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtnama.setText(contacts.get(position).getNama());
        holder.txtnim.setText(contacts.get(position).getNim());
        holder.txtalamat.setText(contacts.get(position).getAlamat());
        holder.txthp.setText(contacts.get(position).getHp());
        holder.txtdes.setText(contacts.get(position).getKeterangan());


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtnama, txtnim, txtalamat, txthp, txtdes;
        public MyViewHolder(View itemView) {
            super(itemView);

            txtnama = itemView.findViewById(R.id.txtnama);
            txtnim = itemView.findViewById(R.id.txtnim);
            txtalamat = itemView.findViewById(R.id.txtalamat);
            txthp = itemView.findViewById(R.id.txthp);
            txtdes = itemView.findViewById(R.id.txtdes);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Intent i = new Intent(context, EditorActivity.class);
//            i.putExtra("id", contacts.get(getAdapterPosition()).getId());
//            i.putExtra("name", contacts.get(getAdapterPosition()).getName());
//            i.putExtra("email", contacts.get(getAdapterPosition()).getEmail());
//            context.startActivity(i);
        }
    }
}