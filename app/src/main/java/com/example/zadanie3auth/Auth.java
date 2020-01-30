package com.example.zadanie3auth;

public class Auth {
        public String Username;
        public boolean isAdmin;
        private String Password;
        private String so1= "^%^*";
         private String so2= "^&*&";
    public Auth(String user, String passwd, Boolean admin){
        Username = user;
        Password = so1+passwd+so2;
        isAdmin = admin;
    }

    public boolean checkPass(String user, String pass){
        String passSalt = so1+pass+so2;
        if(user.equals(Username) && passSalt.equals(Password)) return true;
        else return false;
    }
}

