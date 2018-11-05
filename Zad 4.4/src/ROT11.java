public class ROT11 implements Algorithm {
    private String alfabet="abcdefghijklmnopqrstuvwxyz";

    @Override
    public String crypt(String slowo) {
        String nw = null;
        for(int i=0; i<slowo.length(); i++){
            if((slowo.charAt(i)>=97 && slowo.charAt(i)<=122)){
                nw=nw+alfabet.charAt(((slowo.charAt(i)-97)+11)%alfabet.length());
            }
            else if(slowo.charAt(i)>=65 && slowo.charAt(i)<=90){
                nw=nw+alfabet.toUpperCase().charAt(((slowo.charAt(i)-65)+11)%alfabet.length());
            }
            else{
                nw=nw+slowo.charAt(i);
            }
        }
        return nw;
    }

    @Override
    public String decrypt(String slowo) {
        String nw = null;
        for(int i=0; i<slowo.length(); i++){
            if(slowo.charAt(i)>=97 && slowo.charAt(i)<=122){
                nw=nw+alfabet.charAt((slowo.charAt(i)-97+(alfabet.length()-11))%alfabet.length());
            }
            else if(slowo.charAt(i)>=65 && slowo.charAt(i)<=90){
                nw=nw+alfabet.toUpperCase().charAt((slowo.charAt(i)-65+(alfabet.length()-11))%alfabet.length());
            }
            else{
                nw=nw+slowo.charAt(i);
            }
        }
        return nw;
    }
}