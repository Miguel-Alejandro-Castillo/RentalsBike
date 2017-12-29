package com.model;

/**
 * Created by Alejandro on 28/12/2017.
 */
public class RentalByWeek extends Rental{
    @Override
    public double price() {
        return 60;
    }

    @Override
    public double discount() {
        return 1;
    }
    @Override
    public double charge() {
        return this.price() * this.discount();
    }

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }


}
