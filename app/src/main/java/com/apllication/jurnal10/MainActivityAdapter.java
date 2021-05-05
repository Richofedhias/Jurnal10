package com.apllication.jurnal10;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.myViewHolder> {
    private Context context;
    private ActionMode mActionMode;
    private ListItemClickListener mOnClickListener;
    ArrayList<ListData> isiData;

    public MainActivityAdapter(Context context, ArrayList<ListData> isiData) {
        this.context = context;
        this.isiData = isiData;
    }

    @NonNull
    @Override
    public MainActivityAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        myViewHolder viewHolder = new myViewHolder(view);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MainActivityAdapter.myViewHolder holder, int position) {
        LocalDateTime localDateTime = isiData.get(position).getDatetime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        holder.datetime.setText(formatter.format(localDateTime));
        if (isiData.get(position).isStarred() == false)
            holder.image.setImageResource(R.drawable.notstarred);
        else
            holder.image.setImageResource(R.drawable.starred);

        holder.sender.setText(isiData.get(position).getSender());
        holder.subject.setText(isiData.get(position).getSubject());
        holder.contents.setText(isiData.get(position).getContent());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                View dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.dialog_custom, null);
                TextView detail;
                detail = dialogView.findViewById(R.id.isi_detail);
                detail.setText(isiData.get(position).getContent());
                builder.setView(dialogView);
                builder.setCancelable(true);
                builder.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return isiData.size();
    }



    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private TextView sender, subject, contents, datetime;
        private ImageView image;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            sender = itemView.findViewById(R.id.sender);
            subject = itemView.findViewById(R.id.subject);
            contents = itemView.findViewById(R.id.contents);
            datetime = itemView.findViewById(R.id.datetime);
            image = itemView.findViewById(R.id.starred);

            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
            return false;
        }
    }
}
