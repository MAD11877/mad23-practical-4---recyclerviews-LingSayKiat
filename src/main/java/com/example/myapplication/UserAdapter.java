package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

import java.util.List;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageView specialImageView;
        private Button followButton;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.name);
            descriptionTextView = itemView.findViewById(R.id.description);
            specialImageView = itemView.findViewById(R.id.special_image_view);
            followButton = itemView.findViewById(R.id.follow_button);
        }

        public void bind(final User user) {
            // Set random number generated queries to the views
            Random random = new Random();
            int randomNumber_name = random.nextInt(100000000) + 1;
            int randomNumber_des = random.nextInt(100000000) + 1;
            imageView.setImageResource(android.R.drawable.sym_def_app_icon);
            nameTextView.setText(user.getName() + " " + randomNumber_name);
            descriptionTextView.setText(user.getDescription() + " " + randomNumber_des);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                    builder.setTitle("Profile");
                    builder.setMessage(user.getName() + randomNumber_name);
                    builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(itemView.getContext(), MainActivity.class);
                            intent.putExtra("USER_NAME", user.getName() + randomNumber_name);
                            intent.putExtra("USER_DESCRIPTION", user.getDescription() + " " + randomNumber_des);
                            itemView.getContext().startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Perform any action upon CLOSE button click
                        }
                    });
                    builder.show();
                }
            });

            followButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isFollowed = !user.isFollowed();
                    user.setFollowed(isFollowed);

                    // Perform any additional follow/unfollow logic here

                    // Update the UI
                    if (isFollowed) {
                        followButton.setText("Unfollow");
                    } else {
                        followButton.setText("Follow");
                    }
                }
            });
        }
    }
}
