import java.util.ArrayList;

public class Arbol extends ArbolAbst{
    private ArrayList<ArbolAbst> subArboles =new ArrayList<>();
    private ArrayList<String> atributos =new ArrayList<>();
    private String claseActual;
    public Arbol(){

    }

    @Override
    public String toString() {

        String resultado="clase que decide: "+claseActual.toUpperCase()+"{";

        for (int i = 0; i < subArboles.size(); i++) {

            resultado=resultado+"Del atributo: "+atributos.get(i).toUpperCase();

            resultado=resultado+" sale: "+subArboles.get(i);

        }

        resultado=resultado+" }";
        return resultado;
    }
    @Override
    public void imprimir(){

        System.out.println("clase que decide: "+claseActual.toUpperCase());
        System.out.println("{");
        for (int i = 0; i < atributos.size(); i++) {
            System.out.println("Del atributo: "+atributos.get(i).toUpperCase()+" sale: ");

            subArboles.get(i).imprimir();

        }
        System.out.println("}");
    }

    public Arbol(String claseActual){
        this.claseActual=claseActual;
    }

    public void setAtributos(ArrayList<String> atributos) {
        this.atributos = atributos;
    }

    public void setClaseActual(String claseActual) {
        this.claseActual = claseActual;
    }

    public void setSubArboles(ArrayList<ArbolAbst> subArboles) {
        this.subArboles = subArboles;
    }

    public ArrayList<String> getAtributos() {
        return atributos;
    }

    public String getClaseActual() {
        return claseActual;
    }

    public ArrayList<ArbolAbst> getSubArboles() {
        return subArboles;
    }

}
