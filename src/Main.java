import com.model.FamilyRental;
import com.model.RentalByDay;
import com.model.RentalByWeek;

/**
 * Created by Alejandro on 28/12/2017.
 */

public class Main {
    public static  void main(String []args) throws Exception {

        FamilyRental r1=new FamilyRental(null);
        RentalByDay r2=new RentalByDay();
        if(r2.equals(r1)){
            System.out.println("r1 es igual r2");
        }
        else
            System.out.println("son distintos");
    }
}
