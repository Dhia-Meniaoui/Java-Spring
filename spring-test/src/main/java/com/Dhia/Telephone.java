package com.Dhia;


import org.springframework.stereotype.Component;

@Component
public class Telephone implements Device{
    public void utiliser(){
        System.out.print("I am using a phone");
    }
}

