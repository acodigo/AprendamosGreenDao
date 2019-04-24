package com.example.aprendamosgreendao.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aprendamosgreendao.R;
import com.example.aprendamosgreendao.models.User;

import org.w3c.dom.Text;

import java.util.List;

public class adapterUsers extends RecyclerView.Adapter<adapterUsers.Holder> {


    private List<User> listUsers;
    private Context context;

    public adapterUsers(List<User> listUsers, Context context) {
        this.listUsers = listUsers;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_user_cardview, viewGroup, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.bind(listUsers.get(i));
    }

    @Override
    public int getItemCount() {
        if (this.listUsers.isEmpty()) {
            return 0;
        }else {
            return this.listUsers.size();
        }
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView textViewUser;
        private TextView textViewName;
        private TextView textViewEmail;
        private TextView textViewAge;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.textViewUser = itemView.findViewById(R.id.tv_user_view);
            this.textViewName = itemView.findViewById(R.id.tv_name_view);
            this.textViewEmail = itemView.findViewById(R.id.tv_email_view);
            this.textViewAge = itemView.findViewById(R.id.tv_age_view);
        }

        public void bind(final User user){
            this.textViewUser.setText(user.getName());
            this.textViewName.setText(user.getFirtsName() + " " + user.getLastName());
            this.textViewEmail.setText(user.getEmail());
            this.textViewAge.setText("" + user.getAge());
        }
    }
}
