package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private List<User> userList;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Generate a list of 20 random User objects
        generateUserList();

        recyclerView = findViewById(R.id.recyclerView);
        userAdapter = new UserAdapter(userList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness")
                        .setCancelable(false)
                        .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Random random = new Random();
                                int randomInt = random.nextInt(100000000);
                                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                                intent.putExtra("RANDOM_INT", randomInt);
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private void generateUserList() {
        userList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int id = i + 1; // Assuming IDs start from 1
            String name = generateRandomName();
            String description = generateRandomDescription();
            boolean followed = random.nextBoolean();

            User user = new User(name, description, id, followed);
            userList.add(user);
        }
    }

    private String generateRandomName() {
        String[] names = {"Name"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }

    private String generateRandomDescription() {
        String[] descriptions = {"Description"};
        Random random = new Random();
        int index = random.nextInt(descriptions.length);
        return descriptions[index];
    }
}
