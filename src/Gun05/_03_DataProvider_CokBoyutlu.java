package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_CokBoyutlu {


    @Test(dataProvider = "UserData")
    void UsernameTest(String username,String password){
        System.out.println("user =" + username+" "+password);
    }


    @DataProvider
    public Object[][] UserData(){

        Object[][] data={
                {"Nurhayat","123354"},
                {"Alper","erener"},
                {"Uğur","srersd121"},
                {"Hakan","dasds"},
        };

        return data;
    }
}
