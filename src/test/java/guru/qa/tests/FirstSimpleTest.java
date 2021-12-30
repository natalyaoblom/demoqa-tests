package guru.qa;

import org.junit.jupiter.api.*;

@DisplayName("Это наш первый простой тест")
public class FirstSimpleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll method!");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    @BeforeEach method!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    @AfterEach method!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll method!");
    }

    @DisplayName("Простой тест на assertEquals")
    @Test
    void firstTest() {
        System.out.println("Простой тест на assertEquals");
        Assertions.assertEquals(1,1);
    }

    @DisplayName("Простой тест на assertTrue")
    @Test
    void secondTest() {
        System.out.println("Простой тест на assertTrue");
        Assertions.assertTrue(7 > 6);
    }


}
