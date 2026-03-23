package Java911.P9;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(1,"ahmed");
        Player p2 = new Player(2,"ali");
        Player p3 = new Player(3,"sara");

        PublicClub publicClub = new PublicClub("Public");
        publicClub.addPlayer(p1);
        publicClub.addPlayer(p2);
        publicClub.showPlayers();

        System.out.println(".............................");

        PrivateClub privateClub = new PrivateClub("Private");
        privateClub.addPlayer(p3);
        privateClub.showPlayers();
    }
}
