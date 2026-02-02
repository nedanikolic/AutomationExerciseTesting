package tests.ui;

import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ProductListPage;
import tests.BaseTest;

public class ProductSearchTest extends BaseTest {
    private ProductSearchTest(){}

    HeaderPage headerPage = new HeaderPage();
    ProductListPage productListPage = new ProductListPage();

    @Test
    public void searchProduct(){
        headerPage.clickOnPLButton();
        productListPage.productSearch(properties.getValue("product"));
        productListPage.verifyProductIsFound();
    }
}
