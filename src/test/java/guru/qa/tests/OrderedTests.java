package guru.qa.tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
    @Test
    @Order(1)
    void firstTest() {
        System.out.println("test 1");
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("test 2");
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("test 3");
    }

    @Test
    @Order(4)
    void forthTest() {
        System.out.println("test 4");
    }
}
