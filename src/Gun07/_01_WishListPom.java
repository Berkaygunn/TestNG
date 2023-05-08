package Gun07;

import Gun06._03_PlaceHolderElements;
import Utlity.BaseDriver;
import Utlity.Tools;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_WishListPom extends BaseDriver {

    @Test
    @Parameters("searchText")
    public void Test(String text){


        _03_PlaceHolderElements pom=new _03_PlaceHolderElements();

        pom.search.sendKeys(text);
        pom.searchclick.click();

        _01_WishListElements wle=new _01_WishListElements();

        int randomSecim= Tools.RandomGenerator(wle.searchResult.size());
        String wishItemText=wle.searchResult.get(randomSecim).getText();

        wle.wishBtnList.get(randomSecim).click();
        wle.wishclick.click();
        Tools.listContainsString(wle.wishTable,wishItemText);





    }
}
