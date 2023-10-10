import service.WortService;

import static org.junit.jupiter.api.Assertions.*;

public class Test {
    private WortService service = new WortService();

    @org.junit.jupiter.api.Test
    public void test1(){
        assertTrue(service.validateUserInput("https://cdn.pixabay.com/photo/2013/07/13/10/51/football-157930_1280.png", "ball"));
    }

    @org.junit.jupiter.api.Test
    public void test2(){
        assertFalse(service.validateUserInput("https://cdn.pixabay.com/photo/2013/07/13/10/51/football-157930_1280.png", "hund"));
    }
}
