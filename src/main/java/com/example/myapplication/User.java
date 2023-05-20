package com.example.myapplication;

import java.util.Random;

public class User {
        private String name;
        private String description;
        private int id;
        private boolean followed;

        public User(String name, String description, int id, boolean followed) {
            this.name = name;
            this.description = description;
            this.id = id;
            this.followed = followed;
        }

        // Getter methods
        public String getName() {
            return this.name;
        }

        public String getDescription() {
            return this.description;
        }

        public int getId() {
            return this.id;
        }

        public boolean isFollowed() {
            return this.followed;
        }

        // Setter methods
        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }


    }


