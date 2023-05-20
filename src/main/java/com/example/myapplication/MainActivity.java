package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User("MAD", "I am a software engineer", 1, false);

        Button followButton = findViewById(R.id.follow_button);
        Button messageButton = findViewById(R.id.message_button);
        TextView nameTextView = findViewById(R.id.HelloWorld);
        TextView blockTextView = findViewById(R.id.BlockText); // Find the BlockText TextView

        Intent intent = getIntent();
        String name = intent.getStringExtra("USER_NAME");
        String description = intent.getStringExtra("USER_DESCRIPTION");

        nameTextView.setText(name);
        blockTextView.setText(description); // Set the description in the TextView

        int randomInt = intent.getIntExtra("RANDOM_INT", -1);
        if (randomInt != -1) {
            name = name + " " + randomInt;
        }

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.isFollowed()) {
                    followButton.setText("Follow");
                    user.setFollowed(false);
                } else {
                    followButton.setText("Unfollow");
                    user.setFollowed(true);
                }
            }
        });

        // Set an OnClickListener for the Message button
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to launch the MessageGroup activity
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });
    }
}


