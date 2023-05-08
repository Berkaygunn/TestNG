package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {


    @Test
    void EqualOrnek(){

        String s1="Merhaba";
        String s2="Merhaba";

        // Actual (oluşan) , Expected (beklenen) , Message (opsiyonel)
        Assert.assertEquals(s1,s2, "oluşan ve beklenen eşit değil");
    }

    @Test
    void notEqualOrnek(){

        String s1="Merhaba";
        String s2="Merhaba1";

        Assert.assertNotEquals(s1,s2, "Oluşan ve Beklenen eşit oldu");
    }

    @Test
    void TrueOrnek(){

        int s1=55;
        int s2=66;

       Assert.assertTrue(s1==s2, "Oluşan ve Beklenen eşit olmadı");
    }

    @Test
    void nullOrnek(){

        String s1="null";

       Assert.assertNull(s1, "Oluşan NULL olmadı");
    }

    @Test
    void direkFail(){

        int a=55;

       if (a==55)
           Assert.fail();
    }
}
