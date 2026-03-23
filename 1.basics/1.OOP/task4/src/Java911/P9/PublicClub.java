package Java911.P9;



public class PublicClub extends Player {
    String clubName;

    Player [] players =  new Player[10];

    int count = 0;

    public PublicClub(String clubName) {
        this.clubName = clubName;
    }

    public void addPlayer(Player player){
        players[count] = player;
        count++;
    }

    public void showPlayers(){
        System.out.println("Public Club Members:");
        for(int i=0;i<count;i++){
            System.out.println(players[i].number+" , "+players[i].name);
        }
    }


}
