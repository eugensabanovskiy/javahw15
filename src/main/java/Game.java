import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player p1 = findPlayerByName(playerName1);
        Player p2 = findPlayerByName(playerName2);

        if (p1 == null || p2 == null) {
            throw new NotRegisteredException("Player not registered");
        }

        if (p1.getStrength() > p2.getStrength()) return 1;
        if (p1.getStrength() < p2.getStrength()) return 2;
        return 0;
    }

    private Player findPlayerByName(String name) {
        return players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

}


