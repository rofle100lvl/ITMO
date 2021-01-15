package com.company;

    public abstract class Being implements  setAndGetName {
        private String name;
        @Override
        public String getName(){
            return name;
        }
        @Override
        public void setName(String s) {
            name = s;
        }
    }


