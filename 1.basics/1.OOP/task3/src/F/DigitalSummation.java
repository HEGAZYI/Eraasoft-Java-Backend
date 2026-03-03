package F;



public class DigitalSummation {

        private long N , M ;

        public DigitalSummation(long N, long M) {
            this.N = N;
            this.M = M;
        }

        public void lastDigits(long N , long M){
             long lastDigitN = N % 10;
             long lastDigitM = M % 10;

            System.out.println(lastDigitN  + lastDigitM);
        }


}
