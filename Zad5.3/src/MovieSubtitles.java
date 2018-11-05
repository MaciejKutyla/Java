import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieSubtitles {
    private String Sub;

    private int first;
    private int second;

    public MovieSubtitles(String _sub) throws InvalidString {
        Pattern compiledPattern = Pattern.compile("\\{(\\d+)}\\{(\\d+)}");
        Matcher matcher = compiledPattern.matcher(_sub);
        if(matcher.find()){
            first=Integer.parseInt(matcher.group(1));
            second=Integer.parseInt(matcher.group(2));
            if(first>second){
                throw new InvalidString(0);
            }
            Sub=_sub;
        }
        else{
            throw new InvalidString(1);
        }
    }




}