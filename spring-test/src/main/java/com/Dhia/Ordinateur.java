package com.Dhia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ordinateur implements Device{

    @Autowired
    private Scren S;

    public Scren getS() {
        return S;
    }

    public void setS(Scren s) {
        S = s;
    }

    @Autowired
    public void utiliser(){
        System.out.print("I am using a computer"+ S);
    }
}
