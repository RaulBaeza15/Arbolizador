import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Linea{
    private ArrayList<String> linea;
    public Linea(){




    }
    public Linea(Linea line){

this.linea=line.getLinea();


    }

    public Linea(String str){

        this.linea=new ArrayList<>();
        String[] parts = str.split(" ");

        Collections.addAll(this.linea, parts);


    }
    public Linea(ArrayList<String> str){
        this.linea=new ArrayList<>(str);

    }

    @Override
    public String toString() {
        return "Linea{" +
                "" + linea +
                '}';
    }
    public Linea independizar(){
        Linea line = new Linea();
        for (String str:this.linea) {
            line.getLinea().add(str);
        }
        return line;

    }

    public ArrayList<String> getLinea() {
        return linea;
    }

    public void setLinea(ArrayList<String> linea) {
        this.linea = linea;
    }
}
