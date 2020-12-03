package com.example.pas;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class AdapterTeam extends RecyclerView.Adapter<AdapterTeam.MyViewHolder> {


    private ArrayList<ModelTeam> dataList;
    private Callback callback;
    View viewku;
    int posku;


    interface Callback{
        void onClick(int position);

        void test();
    }

    public AdapterTeam(ArrayList<ModelTeam> dataList, Callback callback) {
        this.dataList = dataList;
        this.callback = callback;
        Log.d("makanan", "MahasiswaAdapter: "+dataList.size()+"");
    }
    @NonNull
    @Override
    public AdapterTeam.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_adapter_team, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterTeam.MyViewHolder holder, final int position) {
        holder.txtNama.setText(dataList.get(position).getStrTeam());
        holder.txtDate.setText(dataList.get(position).getIntFormedYear());
        holder.txtNpm.setText(dataList.get(position).getStrDesc());
        Log.d("makananku", "onBindViewHolder: "+dataList.get(position).getStrTeamBadge());
        Glide.with(holder.itemView)
                .load(dataList.get(position).getStrTeamBadge())
                .override(Target.SIZE_ORIGINAL)
//                .apply(new RequestOptions().override(600,400))
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivprofile);
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private TextView txtNama, txtNpm, txtDate;
        CardView card;
        ImageView ivprofile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            viewku=itemView;
            card = (CardView) itemView.findViewById(R.id.cardku);
            ivprofile = (ImageView) itemView.findViewById(R.id.ivprofile);
            txtNama = (TextView) itemView.findViewById(R.id.tvname);
            txtNpm = (TextView) itemView.findViewById(R.id.tvdesc);
            txtDate = (TextView)itemView.findViewById(R.id.tvdate);
            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            posku=getAdapterPosition();
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }
    }
    private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case 1:
                    //Do stuff
                    Toast.makeText(viewku.getContext(), ""+posku, Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    //Do stuff


                    break;
            }

            return true;
        }
    };
}
