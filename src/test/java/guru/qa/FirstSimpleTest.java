package guru.qa;

import org.junit.jupiter.api.*;

@DisplayName("��� ��� ������ ������� ����")
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

    @DisplayName("������� ���� �� assertEquals")
    @Test
    void firstTest() {
        System.out.println("������� ���� �� assertEquals");
        Assertions.assertEquals(1,1);
    }

    @DisplayName("������� ���� �� assertTrue")
    @Test
    void secondTest() {
        System.out.println("������� ���� �� assertTrue");
        Assertions.assertTrue(7 > 6);
    }


}
