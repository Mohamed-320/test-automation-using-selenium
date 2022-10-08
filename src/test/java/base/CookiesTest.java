package base;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import utils.CookieManager;

import static org.testng.Assert.assertFalse;

public class CookiesTest extends BaseTest {
    CookieManager cookieManager;

    /**
     * Test that comes to the main page. Don't click anywhere.
     * then,Delete one of these cookies, maybe this first one called optimizelyBuckets,
     * and then verify that this cookie does not exist anymore.
     */
    @Test
    public void testDeleteCookie() {
        Cookie cookie = getCookieManager().buildCookie("optimizelyBuckets", "%7B%TD");
        cookieManager.deleteCookie(cookie);
        assertFalse(cookieManager.isCookiePresent(cookie), "Cookie was not deleted");
    }
}
