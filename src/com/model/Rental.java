package com.model;

/**
 * Created by Alejandro on 28/12/2017.
 */
public abstract class Rental {
    public abstract  double price();
    public  double discount(){
        return 0;
    }
    public double charge() {
        return this.price();
    }
    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }
}
