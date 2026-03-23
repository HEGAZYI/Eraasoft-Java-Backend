package Java911.P9;

import java.util.Scanner;

public class PrivateClub {
    Scanner sc = new Scanner(System.in);

    String clubName;

    Player [] players =  new Player[10];

    int count = 0;

    public PrivateClub(String clubName) {
        this.clubName = clubName;
    }

    public void addPlayer(Player player){
        System.out.println("Are you registered to any club? [yes / no]");
        String answer = sc.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            System.out.println("sorry! this is a private club!");
        }else if(answer.equalsIgnoreCase("no")){
            players[count] = player;
            System.out.println("You have added to our private club!");
            count++;
        }

    }

    public void showPlayers(){
        System.out.println("Private Club Members:");
        for(int i=0;i<count;i++){
            System.out.println(players[i].number+" , "+players[i].name);
        }
    }
}
