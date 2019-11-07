package com.example.myapplication1;

public class Message {
    private String type;
    private boolean isTrue;
    private String message;


    public Message(String message){
    this.setMessage(message);
    }

    public Message(String type, boolean isTrue){
    this.setType(type);
    this.setIsTrue(isTrue);
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message=message;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public boolean getIsTrue(){
        return isTrue;
    }

    public void setIsTrue(boolean isTrue){
        this.isTrue = isTrue;
    }





}
