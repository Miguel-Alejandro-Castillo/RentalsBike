package com.model;
import org.junit.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class FamilyRentalTest {

    private FamilyRental familyRentalWithFiveRentals;
    private FamilyRental familyRentalWithThreeRentals;
    private FamilyRental familyRental;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Este test chequea que no se cree un alquiler familiar  con un listado de alquileres  nulo
     * @throws Exception
    **/
    @Test(expected = Exception.class)
    public void testNotCreateFamilyRentalWithListRentalsNull() throws Exception {
       new FamilyRental(null);
       fail("Se creo un alquiler familiar con un listado de alquileres nulo");
    }

    /**
     * Este test chequea que no se modifique un listado de alquileres de un  alquiler familiar con null
     * @throws Exception
     **/
    @Test(expected = Exception.class)
    public void testNotModifyFamilyRentalWithListRentalsInNull() throws Exception {
        testCreateFamilyRentalWithThreeRentals();
        familyRentalWithThreeRentals.setRentals(null);
        fail("Se modifico el alquiler familiar con su listado de alquileres en nulo");
    }

    /**
     * Este test chequea que no se cree un alquiler familiar con un listado de alquileres vacio
     *
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void testNotCreateFamilyRentalWithListRentalsEmpty() throws Exception {
        new FamilyRental(new ArrayList<Rental>());
        fail("Se creo un alquiler familiar con un listado de alquileres vacio");
    }

    /**
     * Este test chequea que no se modifique un listado de alquileres de un  alquiler familiar en vacio
     * @throws Exception
     **/
    @Test(expected = Exception.class)
    public void testNotModifyFamilyRentalWithListRentalsInEmpty() throws Exception {
        testCreateFamilyRentalWithThreeRentals();
        familyRentalWithThreeRentals.setRentals(new ArrayList<Rental>());
        fail("Se modifico el alquiler familiar con su listado de alquileres en ");
    }
    /**
     * Este test chequea que se pueda crear un alquiler familiar con 5 alquileres
     *
     * @throws Exception
     */
    @Test
    public void testCreateFamilyRentalWithFiveRentals() throws Exception {
        List<Rental> rentals=new ArrayList<Rental>();
        Collections.addAll(rentals, new RentalByDay(),new RentalByHour(),new RentalByWeek(),new RentalByDay(),new RentalByWeek());
        familyRentalWithFiveRentals=new FamilyRental(rentals);
        assertEquals("la renta familiar no tiene 5 alquileres en su lista de alquileres",5,familyRentalWithFiveRentals.getRentals().size());

    }

    /**
     * Este test chequea que no se pueda agregar un alquiler a un listado de 5 alquileres de un alquiler familiar
     *
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void testNotAddRentalInFullListRentals() throws Exception {
        testCreateFamilyRentalWithFiveRentals();
        this.familyRentalWithFiveRentals.addRental(new RentalByWeek());
        fail("Se agrego un alquiler al listado de alquileres lleno del alquiler familiar");
    }

    /**
     * Este test chequea que  se pueda eliminar un alquiler de un listado de 5 alquileres de un alquiler familiar
     *
     * @throws Exception
     */
    @Test
    public void testRemoveRentalInFullListRentals() throws Exception {
        testCreateFamilyRentalWithFiveRentals();
        this.familyRentalWithFiveRentals.removeRental(new RentalByWeek());
        assertEquals("No se elimino el alquiler del listado de 5 alquileres del alquiler familiar ",4,familyRentalWithFiveRentals.getRentals().size());
    }


    /**
     * Este test chequea que se pueda crear un alquiler familiar con 3 alquileres
     *
     * @throws Exception
     */
    @Test
    public void testCreateFamilyRentalWithThreeRentals() throws Exception {
        List<Rental> rentals=new ArrayList<Rental>();
        Collections.addAll(rentals, new RentalByDay(),new RentalByHour(),new RentalByWeek());
        familyRentalWithThreeRentals=new FamilyRental(rentals);
        assertEquals("el alquiler familiar no tiene 3 alquileres en su lista de alquileres",3,familyRentalWithThreeRentals.getRentals().size());

    }

    /**
     * Este test chequea que se halla  agregado un alquiler a un listado de 3 alquileres(listado de alquileres con cantidad minima necesaria) de un alquiler familiar
     *
     * @throws Exception
     */
    @Test
    public void testAddRentalInMinimumListRentals() throws Exception {
        testCreateFamilyRentalWithThreeRentals();
        this.familyRentalWithThreeRentals.addRental(new RentalByWeek());
        assertEquals("No se agrego el alquiler al listado de 3 alquileres",4, familyRentalWithThreeRentals.getRentals().size());
    }


    /**
     * Este test chequea que no se pueda eliminar un alquiler de un listado de 3 alquileres  de un alquiler familiar
     *
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void testNotRemoveRentalInAMinimumRentalsList() throws Exception {
        testCreateFamilyRentalWithThreeRentals();
        familyRentalWithThreeRentals.removeRental(new RentalByWeek());
        fail("Se elimino un alquiler de un listado de alquileres con cantidad minima necesaria de un alquiler familiar");
    }



    /**
     * Este test chequea que se obtenga correctamente el precio total  sin descuento  de un alquiler familiar
     *
     * @throws Exception
     */
    @Test
    public void testPriceTotalWithoutDiscount() throws Exception {
        List<Rental> rentals1=new ArrayList<Rental>();
        Collections.addAll(rentals1, new RentalByDay(),new RentalByHour(),new RentalByWeek());
        FamilyRental familyRental1=new FamilyRental(rentals1);
        List<Rental> rentals2= new ArrayList<Rental>();
        Collections.addAll(rentals2, new RentalByDay(),new RentalByHour(),new RentalByWeek(),new RentalByDay(),familyRental1);
        familyRental=new FamilyRental(rentals2);
        assertEquals("El monto total sin descuento resultante no es el esperado",190.0, familyRental.price(),0);

    }

    /**
     * Este test chequea que se obtenga correctamente el valor total que se descuenta de un alquiler familiar
     *
     * @throws Exception
     */
    @Test
    public void testTotalDiscount() throws Exception {
        testPriceTotalWithoutDiscount();
        assertEquals("El monto a ser descontado resultante no es el esperado",57.0, familyRental.discount(),0);

    }

    /**
     * Este test chequea que se obtenga correctamente el precio total con descuento  de un alquiler familiar
     *
     * @throws Exception
     */
    @Test
    public void testPriceTotalWithDiscount() throws Exception {
       testPriceTotalWithoutDiscount();
        assertEquals("El monto total con descuento resultante no es el esperado",133.0, familyRental.charge(),0);

    }

}