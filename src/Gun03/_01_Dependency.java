package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    // arabanın hareketi : start, drive , park , stop hareket sırası


    @Test
    void startCar(){
        System.out.println("startCar");
        //Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})  // bu testin çalışması, startCar ın hatasız çalışmasına bağla
    void driveCar(){
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"startCar","driveCar"})
    void parkCar(){
        System.out.println("parkCar");
    }

    //alwaysRun = ture bağımlılıları var ama hata çıkarsa da yine çalıştır
    @Test(dependsOnMethods = {"startCar"}, alwaysRun = true)
    void stopCar(){
        System.out.println("stopCar");
    }
}
