import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtitles {
    private String sub;
    private int first;
    private int second;

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String getSub() {

        return sub;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }


    public Subtitles(String sub2) throws InvalidString {
        Pattern compiledPattern = Pattern.compile("\\{(\\d+)}\\{(\\d+)}");
        Matcher matcher = compiledPattern.matcher(sub2);
        if(matcher.find()){
            first=Integer.parseInt(matcher.group(1));
            second=Integer.parseInt(matcher.group(2));
            if(first>second){
                throw new InvalidString(0);
            }
            sub = sub2;
        }
        else{
            throw new InvalidString(1);
        }
    }



}
