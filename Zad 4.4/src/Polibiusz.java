public class Polibiusz implements Algorithm {
    private char[][] tab = new char[5][5];

    public Polibiusz(){
        char k=97;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                tab[i][j]=k;
                if(k==105){
                    k++;
                }
                k++;
            }
        }
    }

    @Override
    public String crypt(String slowo) {
        String nw = null;
        char sb;
        slowo=slowo.toLowerCase();
        for (int w = 0; w < slowo.length(); w++) {
            if(slowo.charAt(w)>=97 && slowo.charAt(w)<=122){
                if(slowo.charAt(w)=='j'){
                    sb='i';
                }
                else {
                    sb = slowo.charAt(w);
                }
                for (int i = 0; i <= 4; i++) {
                    for (int j = 0; j <= 4; j++) {
                        if (tab[i][j] == sb) {
                            nw = nw + String.valueOf(i + 1) + String.valueOf(j + 1);
                        }
                    }
                }
            }

            else{
                nw=nw+slowo.charAt(w);
            }
        }
        return nw;
    }

    @Override
    public String decrypt(String word) {
        String nw = null;
        int x, y;
        word=word.toLowerCase();
        for(int w=0; w<(word.length()); w++) {
            if(word.charAt(w) >= 48 && word.charAt(w) <= 57) {
                if (w < (word.length() - 1)) {
                    if (word.charAt(w + 1) >= 48 && word.charAt(w + 1) <= 57) {
                        x = Character.getNumericValue(word.charAt(w));
                        y = Character.getNumericValue(word.charAt(w + 1));
                        nw = nw + tab[x - 1][y - 1];
                        w++;
                    } else {
                        nw = nw + word.charAt(w);
                    }
                }
                else {
                    nw = nw + word.charAt(w);
                }
            }
            else {
                nw = nw + word.charAt(w);
            }
        }
        return nw;
    }
}