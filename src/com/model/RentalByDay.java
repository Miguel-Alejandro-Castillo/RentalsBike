package com.model;

/**
 * Created by Alejandro on 28/12/2017.
 */
public class RentalByDay extends Rental {
    @Override
    public double price(){
        return 20;
    }

    @Override
    public double discount() {
        return 0;
    }

    @Override
    public double charge() {
        return this.price();
    }
    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }

}
