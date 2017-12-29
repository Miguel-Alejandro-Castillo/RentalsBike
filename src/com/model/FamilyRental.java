package com.model;

import java.util.List;

/**
 * Created by Alejandro on 28/12/2017.
 */
public class FamilyRental extends Rental {

    private List<Rental> rentals;

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
            if(cantRentals >= 3 && cantRentals <= 5 )
                this.rentals=rentals;
            else
                throw new Exception("El alquiler familiar no tiene entre 3 y 5 alquileres ");
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

    @Override
    public double discount() {
        return 0.3;
    }

    @Override
    public double charge() {
        return this.price() * this.discount();
    }

    public void addRental(Rental rental) throws Exception{
        if(this.getRentals().size() < 5)
            this.getRentals().add(rental);
        else
            throw new Exception("No se pueden agregar mas alquileres");
    }
    public void removeRental(Rental rental) throws Exception{
         if(this.getRentals().remove(rental) && this.getRentals().size() < 3 )
                    throw new Exception("No se puede borrar ningun alquiler");
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
