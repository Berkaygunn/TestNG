package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {


    @Test
    void hardAssert()
    {
        String s1="Merhaba";

        System.out.println("Hard assert öncesi");
        Assert.assertEquals("Merhaba",s1,"Oluşan ile beklenen eşit değil.");  // test kırılıyor
        System.out.println("Hard assert sonrası");
    }

    @Test
    void softAssert()
    {
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage",strHomePage);  // true
        System.out.println("soft Assert 1");

        _softAssert.assertEquals("www.facebook.com/profile",strCartPage);  // false
        System.out.println("soft Assert 2");

        _softAssert.assertEquals("www.facebook.com/editaccountpage",strEditAccount);  // false
        System.out.println("soft Assert 3");


        _softAssert.assertAll();  // bütün assert sonuçlarını işleme koyuyor.
        System.out.println("soft AssertAll : aktiflik sonrası");
        // bu bölüm assertAll dan sonra olduğu ve öncesinde hata oluştuğu için ekrana çıkamayacak


    }
}
