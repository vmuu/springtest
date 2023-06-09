package com.itheima;

public class HelloSpring {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void show(){
        System.out.println("Hello,"+username);
    }
}
