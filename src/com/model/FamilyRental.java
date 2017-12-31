package com.model;

import java.util.List;

/**
 * Created by Alejandro on 28/12/2017.
 */
public class FamilyRental extends Rental {

    private List<Rental> rentals;
    private static final int SIZE_MIN_LIST_RENTALS=3;
    private static final int SIZE_MAX_LIST_RENTALS=5;

    private FamilyRental() {
    }
    public FamilyRental(List<Rental> rentals) throws Exception{
        super();
        this.setRentals(rentals);
    }

    public List<Rental> getRentals() {
        return rentals;
    }
    public void setRentals(List<Rental> rentals) throws Exception {
        if(rentals !=null && !rentals.isEmpty()){
            int cantRentals=rentals.size();
            if(cantRentals >= SIZE_MIN_LIST_RENTALS && cantRentals <= SIZE_MAX_LIST_RENTALS )
                this.rentals=rentals;
            else
                throw new Exception("El alquiler familiar no tiene entre "+SIZE_MIN_LIST_RENTALS+" y "+SIZE_MAX_LIST_RENTALS+" alquileres");
        }
        else
            throw new Exception("El alquiler familiar no posee alquileres");
    }

    @Override
    public double price() {
        double price=0;
        for (Rental rental : this.getRentals())
            price+=rental.price();
        return price;
    }

    private double discountRate(){
        return 30;
    }
    @Override
    public double discount() {
        return (this.price()*this.discountRate())/100;
    }

    @Override
    public double charge() {
        return this.price()-this.discount();
    }

    public void addRental(Rental rental) throws Exception{
        if(this.getRentals().size() < SIZE_MAX_LIST_RENTALS)
            this.getRentals().add(rental);
        else
            throw new Exception("No se puede agregar ningun alquiler");
    }
    public void removeRental(Rental rental) throws Exception{
         if(this.getRentals().contains(rental) ) {
             if (this.getRentals().size() > SIZE_MIN_LIST_RENTALS)
                 this.getRentals().remove(rental);
             else
                 throw new Exception("No se puede borrar ningun alquiler");
         }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyRental that = (FamilyRental) o;

        if (rentals != null ? !rentals.equals(that.rentals) : that.rentals != null) return false;

        return true;
    }


}
