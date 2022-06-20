public class Hoja extends ArbolAbst{
    private String resultado;
    public Hoja(String resultado){
        this.resultado=resultado;
    }

    @Override
    public String toString() {
        return "Hoja{" +
                "resultado='" + resultado + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Nodo Hoja con resultado de: "+resultado.toUpperCase());
    }
}
