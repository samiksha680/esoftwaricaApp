package com.example.esoftwaricaassign3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwaricaassign3.R;
import com.example.esoftwaricaassign3.models.Student;

import java.util.List;

public class StudentAdp extends RecyclerView.Adapter<StudentAdp.UserHolder> {
    Context context;
    List<Student> details;

    public StudentAdp(Context context, List<Student> details) {

        this.context = context;
        this.details = details;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list,parent,false);
            UserHolder holderObject = new UserHolder(view);
        return holderObject;
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, final int position) {
        final Student users = details.get(position);
        holder.Name.setText(users.getName());
        holder.Gender.setText(users.getGender());
        holder.Age.setText(users.getAge());
        holder.Address.setText(users.getAddress());


        if (users.getGender().equals("male")){
            holder.images.setImageResource(R.drawable.male);
        }else if (users.getGender().equals("female")){
            holder.images.setImageResource(R.drawable.female);
        }else if (users.getGender().equals("other")){
            holder.images.setImageResource(R.drawable.other);
        }


        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.remove(users);
                notifyItemRemoved(position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return details.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder{

        TextView Name, Age, Address, Gender;
        ImageView images;
        Button Delete;
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.userName);
            Address = itemView.findViewById(R.id.userAd);
            Age = itemView.findViewById(R.id.userAge);
            Gender = itemView.findViewById(R.id.userGender);
            images = itemView.findViewById(R.id.userImage);
            Delete = itemView.findViewById(R.id.deleteUser);

        }
    }
}
