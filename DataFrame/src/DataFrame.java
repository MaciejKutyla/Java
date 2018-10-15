import java.util.ArrayList;

public class DataFrame {


    protected ArrayList<ArrayList> list = new ArrayList<ArrayList>();
    protected String[] names;
    protected String[] types;


    DataFrame(String[] new_names, String[] new_types){

        names = new_names.clone();
        types = new_types.clone();
        ArrayList array_list = new ArrayList();

        for (int i =0; i<new_names.length; ++i){
            list.add(new ArrayList());
        }
    }



    public int size(){
        return list.get(1).size();
    }


    public ArrayList get(String colname){
        for(int i = 0; i < names.length; i++){
            if(colname.equals(names[i])){
                return list.get(i);
            }
        }
        return new ArrayList();
    }


    public DataFrame get(String[] cols, boolean copy){
        String[] new_type = new String[cols.length];
        for(int i=0; i<cols.length; i++){
            for(int j = 0; j< names.length; j++){
                if(cols[i].equals(names[j])){
                    new_type[i] = types[j];
                }
            }
        }
        DataFrame new_frame = new DataFrame(cols, new_type);

        for(int i=0; i<cols.length; i++){
            for(int j = 0; j< names.length; j++){
                if(cols[i].equals(names[j])){
                    if(copy) {
                        new_frame.list.add((ArrayList)list.get(j).clone());
                    } else {
                        new_frame.list.add(list.get(j));
                    }
                }
            }
        }
        return new_frame;
    }


    public DataFrame iloc(int i){
        DataFrame df = new DataFrame(new String[]{names[i]},new String[] {types[i]});
        df.list.add((ArrayList)list.get(i).clone());
        return df;
    }


    public DataFrame iloc(int from, int to){

        String[] n = new String[to-from+1];
        String[] t = new String[to-from+1];
        int i=0;
        for(int it=from; it<=to; it++,i++){
            n[i] = names[it];
            t[i] = types[it];
        }
        DataFrame df = new DataFrame(n,t);
        for(int it=from; it<=to; it++){
            df.list.add((ArrayList)list.get(it).clone());
        }
        return df;
    }
}