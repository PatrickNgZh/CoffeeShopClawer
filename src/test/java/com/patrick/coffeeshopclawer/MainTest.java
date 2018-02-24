package com.patrick.coffeeshopclawer;

import com.patrick.coffeeshopclawer.pojo.CoffeeShop;
import org.junit.Test;

/**
 * @author peicong
 * @date 2018/2/20 0020
 */
public class MainTest {

    @Test
    public void testSave() throws Exception {
        Main main = new Main();
        for (int i = 0; i < 3; i++) {
            main.save(new CoffeeShop("This is a test","test","test",
                    "test","test","test",
                    "test","test"));
        }
    }

}
