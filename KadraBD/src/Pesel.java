public class Pesel {
    private String pesel;

    public String getPesel() {
        return pesel;
    }

    public Pesel(String _pesel){
        pesel=_pesel;}
    public boolean chceck(){
        if(pesel.length()==11){
            int suma = 0;
            int k=0;
            int value=0;
            for(int i=0; i<10; i++){
                if(k==0){
                    value=1;
                    k++;
                }
                else if(k==1){
                    value=3;
                    k++;
                }
                else if(k==2){
                    value=7;
                    k++;
                }
                else if(k==3){
                    value=9;
                    k=0;
                }
                suma=suma+value*Character.getNumericValue(pesel.charAt(i));

            }
            int x=10-suma%10;
            if(x==Character.getNumericValue(pesel.charAt(10))){
                return true;}
            if(x==10 && Character.getNumericValue(pesel.charAt(10))==0){
                return true;}}
        return false;
    }}