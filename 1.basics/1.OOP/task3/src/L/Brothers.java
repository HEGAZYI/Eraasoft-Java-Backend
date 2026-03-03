package L;

import java.util.Objects;

public class Brothers {
    private String F1 , S1 , F2 , S2 ;

    public  Brothers(String F1, String S1, String F2, String S2) {
        this.F1 = F1;
        this.S1 = S1;
        this.F2 = F2;
        this.S2 = S2;
    }

    public void CompareLName(){
        if (Objects.equals(S1, S2)){
            System.out.println("ARE Brothers");
        }else{
            System.out.println("NOT");
        }
    }
}
