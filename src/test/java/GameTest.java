import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testRoundPlayer1Wins() throws NotRegisteredException {
        Game game = new Game();
        Player p1 = new Player(); p1.setName("Alice"); p1.setStrength(10);
        Player p2 = new Player(); p2.setName("Bob"); p2.setStrength(5);
        game.register(p1); game.register(p2);
        assertEquals(1, game.round("Alice", "Bob"));
    }

    @Test
    void testRoundPlayer2Wins() throws NotRegisteredException {
        Game game = new Game();
        Player p1 = new Player(); p1.setName("Alice"); p1.setStrength(5);
        Player p2 = new Player(); p2.setName("Bob"); p2.setStrength(10);
        game.register(p1); game.register(p2);
        assertEquals(2, game.round("Alice", "Bob"));
    }

    @Test
    void testRoundDraw() throws NotRegisteredException {
        Game game = new Game();
        Player p1 = new Player(); p1.setName("Alice"); p1.setStrength(10);
        Player p2 = new Player(); p2.setName("Bob"); p2.setStrength(10);
        game.register(p1); game.register(p2);
        assertEquals(0, game.round("Alice", "Bob"));
    }

    @Test
    void testRoundPlayerNotRegistered() {
        Game game = new Game();
        assertThrows(NotRegisteredException.class, () -> game.round("Alice", "Bob"));
    }

    @Test
    void testPlayerIdIsUnique() {
        Player p1 = new Player(); p1.setId(1);
        Player p2 = new Player(); p2.setId(2);
        assertNotEquals(p1.getId(), p2.getId());
    }

    @Test
    void testPlayerIdIsSetCorrectly() {
        Player p = new Player(); p.setId(5);
        assertEquals(5, p.getId());
    }

}
