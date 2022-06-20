import com.sun.security.jgss.GSSUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lista {
    private ArrayList<Linea> lista = new ArrayList<>();
    private ArrayList<String> clases = new ArrayList<>();


    public int lectorFich(){
        int existia=1;


        System.out.println("Pon la ruta:");

        Scanner sc = new Scanner(System.in);
        String ruta="" ;
        ruta = sc.nextLine();



        try {
            String ruta2 = ruta+"\\OtroEjemplo.txt";
            ruta = ruta+"\\Listado.txt";

            String contenido2 = "Color Aroma Acidez Calidad\n" +
                    "Granate Floral Baja Excelente\n" +
                    "Ocre Frutal Baja Excelente\n" +
                    "Ocre Frutal Alta Pobre\n" +
                    "Granate Vegetal Alta Pobre\n" +
                    "Rubí Especias Baja Excelente\n" +
                    "Rubí Vegetal Media Buena\n" +
                    "Púrpura Frutal Alta Pobre\n" +
                    "Rubí Floral Media Aceptable\n" +
                    "Púrpura Especias Alta Pobre\n" +
                    "Púrpura Nueces Media Excelente\n" +
                    "Ocre Floral Baja Excelente\n" +
                    "Granate Roble Media Aceptable\n" +
                    "Rubí Floral Baja Excelente\n";

            String contenido ="Color_pelo Altura Peso Protección Resultado\n"+
                    "rubio medio delgado no se-quema\n" +
                    "rubio alto medio sí no-se-quema\n" +
                    "moreno bajo medio sí no-se-quema\n" +
                    "rubio bajo medio no se-quema\n" +
                    "pelirrojo media gordo no se-quema\n" +
                    "moreno alto gordo no no-se-quema\n" +
                    "moreno medio gordo no no-se-quema\n" +
                    "rubio bajo delgado sí no-se-quema";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido2);
                bw.close();
                System.out.println("Se ha creado");
                existia=0;

            }
            File file2 = new File(ruta2);
            // Si el archivo no existe es creado
            if (!file2.exists()) {
                file2.createNewFile();
                FileWriter fw2 = new FileWriter(file2);
                BufferedWriter bw2 = new BufferedWriter(fw2);
                bw2.write(contenido);
                bw2.close();
                System.out.println("Se ha creado otro ejemplo");


            }
            File doc = new File(ruta);
            Scanner obj = new Scanner(doc);
            String linea;
            if (!obj.hasNextLine()){
                System.out.println("No admito ficheros sin nada, dale al intro cuando lo soluciones");
                sc.nextLine();
                doc = new File(ruta);
                obj = new Scanner(doc);
            }
            linea=obj.nextLine();

            String[] parts = linea.split(" ");
            Collections.addAll(clases, parts);




            if (!obj.hasNextLine()){
                System.out.println("No admito ficheros solo con las columnas de denominacion");
                sc.nextLine();
                doc = new File(ruta);
                obj = new Scanner(doc);
            }
            while (obj.hasNextLine()){
                linea=obj.nextLine();

                lista.add(new Linea(linea));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return existia;

    }

    public ArrayList<String> getClases() {
        return clases;
    }
    public ArrayList<String> getClasesIndependiente() {

        ArrayList<String> clasesIndependiente=new ArrayList<>();
        for (String str:clases             ) {
            clasesIndependiente.add(str);
        }
        return clases;
    }

    public void setClases(ArrayList<String> clases) {
        this.clases = clases;
    }

    public Lista(Lista lista){
        for (String str:lista.getClases()            ) {
            this.clases.add(str);

        }
        for (Linea linea:lista.getLista()             ) {
            this.lista.add(linea);

        }

    }

    public Lista() {

    }

    @Override
    public String toString() {
        return "Lista{" +
                "" + lista +
                '}';
    }

    public ArrayList<Linea> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Linea> lista) {
        this.lista = lista;
    }
    public double entropiaConjunto(){
        double res=0;
        if (lista.size()!=1) {


            double numElementosDistintos=numElementosDistintos(lista.get(0).getLinea().size()-1);
            double numElementosTotales= lista.size();
            double numAparicionDeElemento;
            double pc;
            for (int i = 0; i < numElementosDistintos; i++) {
                numAparicionDeElemento=numAparicionDeElemento(lista.get(0).getLinea().size()-1,i);

                pc=numAparicionDeElemento/numElementosTotales;
                res=res-    pc*(Math.log(pc)/Math.log(numElementosDistintos));

            }
        }




        return res;
    }
    public int numElementosDistintos(int columna){

        ArrayList<String >apariciones=new ArrayList<>();
        for (Linea linea:lista) {
            if (!apariciones.contains(linea.getLinea().get(columna))){
                apariciones.add(linea.getLinea().get(columna));
            }
        }

        return apariciones.size();
    }
    public int numAparicionDeElemento(int columna,int posicion){

        ArrayList<String >apariciones=new ArrayList<>();
        ArrayList<String >todas=new ArrayList<>();
        for (Linea linea:lista) {
            if (!apariciones.contains(linea.getLinea().get(columna))){
                apariciones.add(linea.getLinea().get(columna));
            }
            todas.add(linea.getLinea().get(columna));
        }
        int total=todas.size();
        while (todas.contains(apariciones.get(posicion))){
            todas.remove(apariciones.get(posicion));
        }
        total=total-todas.size();

        return total;
    }
    public double entropiaMedia(int columna){

        double res=0;
        double numElementosTotales= lista.size();
        int numElementosDistintos= numElementosDistintos(columna);
        for (int i = 0; i < numElementosDistintos; i++) {
            res=res+(numAparicionDeElemento(columna,i)/numElementosTotales)*entropiaSubConjunto( columna, i);

        }
        return res;
    }

    public double entropiaSubConjunto(int columna,int posicion){

        double res=0;
        double numAparicionDeElemento=numAparicionDeElemento(columna,posicion);


        double numResultadosDistintos=numElementosDistintos(lista.get(0).getLinea().size()-1);

        double pvc;
        double numElementosCValeV;
        for (int i = 0; i < numResultadosDistintos; i++) {

            numElementosCValeV=numElementosCValeV(columna,posicion,i);

            pvc=numElementosCValeV/numAparicionDeElemento;
            if (pvc!=0){
                res=res-    pvc*(Math.log(pvc)/Math.log(numResultadosDistintos));
            }


        }
        return res;
    }
    public String elemento(int columna,int posicion){

        ArrayList<String >apariciones=new ArrayList<>();

        for (Linea linea:lista) {
            if (!apariciones.contains(linea.getLinea().get(columna))){
                apariciones.add(linea.getLinea().get(columna));
            }

        }

        return apariciones.get(posicion);
    }
    public int numElementosCValeV(int columna,int posicion,int resultado){

        int total=0;
        for (Linea linea:lista             ) {

            if(linea.getLinea().get(columna).equals(elemento(columna, posicion))&&linea.getLinea().get(lista.get(0).getLinea().size()-1).equals(elemento(lista.get(0).getLinea().size()-1, resultado))){
                total++;
            }

        }

        return total;
    }
    public int columnaMenorEntropia(){
        double menorEntropia=entropiaMedia(0);
        int menorCol=0;
        for (int i = 0; i < lista.get(0).getLinea().size()-1; i++) {
            if (menorEntropia>entropiaMedia(i)){
                menorEntropia=entropiaMedia(i);
                menorCol=i;
            }

        }

        return menorCol;
    }

    public Arbol id3(){
        Arbol arbol = new Arbol();

        if(entropiaConjunto()!=0){
            int columnaEliminar=columnaMenorEntropia();
            int numElementosDistintos =numElementosDistintos(columnaEliminar);

            arbol.setClaseActual(clases.get(columnaEliminar) );



            for (int i = 0; i < numElementosDistintos; i++) {


                if (entropiaSubConjunto(columnaEliminar,i)!=0){
                    Lista lista =new Lista();
                    lista.setClases(new ArrayList<>(getClases()));

                    for (Linea line:this.lista                         ) {
                        if (line.getLinea().get(columnaEliminar).equals(elemento(columnaEliminar,i))){
                            lista.getLista().add(new Linea(line.getLinea()));



                        }
                    }
                    lista.getClases().remove(columnaEliminar);


                    for (int j = 0; j < lista.getLista().size(); j++) {

                        lista.getLista().get(j).getLinea().remove(columnaEliminar);

                    }


                    arbol.getAtributos().add(elemento(columnaEliminar,i));
                    arbol.getSubArboles().add(lista.id3());


                }else{
                    arbol.getSubArboles().add(new Hoja(resultadoElemento(columnaEliminar,i)));
                    arbol.getAtributos().add(elemento(columnaEliminar,i));
                }
            }
        }
    return arbol;
    }
    public String resultadoElemento(int columna, int posicion){
        ArrayList<String >apariciones=new ArrayList<>();
        ArrayList<String >aparicionesAsociadas=new ArrayList<>();
        for (Linea linea:lista) {
            if (!apariciones.contains(linea.getLinea().get(columna))){
                if (!apariciones.contains(linea.getLinea().get(columna))){
                    apariciones.add(linea.getLinea().get(columna));
                    aparicionesAsociadas.add(linea.getLinea().get(lista.get(0).getLinea().size()-1));
                }
            }
        }
        return aparicionesAsociadas.get(posicion);
    }
}
