package com.example.rooms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rooms.db.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context context;
    private List<User> users;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.UserViewHolder holder, int position) {
        holder.tvFirstName.setText(this.users.get(position).getFirstName());
        holder.tvLastName.setText(this.users.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirstName;
        TextView tvLastName;



        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
        }
    }
}
