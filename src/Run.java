

public class Run {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("      db      `7MM\"\"\"Mq.  `7MM\"\"\"Yp,   .g8\"\"8q.   `7MMF'      `7MMF'MMM\"\"\"AMV       db      `7MM\"\"\"Yb.     .g8\"\"8q.   `7MM\"\"\"Mq.  \n" +
                "     ;MM:       MM   `MM.   MM    Yb .dP'    `YM.   MM          MM  M'   AMV       ;MM:       MM    `Yb. .dP'    `YM.   MM   `MM. \n" +
                "    ,V^MM.      MM   ,M9    MM    dP dM'      `MM   MM          MM  '   AMV       ,V^MM.      MM     `Mb dM'      `MM   MM   ,M9  \n" +
                "   ,M  `MM      MMmmdM9     MM\"\"\"bg. MM        MM   MM          MM     AMV       ,M  `MM      MM      MM MM        MM   MMmmdM9   \n" +
                "   AbmmmqMA     MM  YM.     MM    `Y MM.      ,MP   MM      ,   MM    AMV   ,    AbmmmqMA     MM     ,MP MM.      ,MP   MM  YM.   \n" +
                "  A'     VML    MM   `Mb.   MM    ,9 `Mb.    ,dP'   MM     ,M   MM   AMV   ,M   A'     VML    MM    ,dP' `Mb.    ,dP'   MM   `Mb. \n" +
                ".AMA.   .AMMA..JMML. .JMM..JMMmmmd9    `\"bmmd\"'   .JMMmmmmMMM .JMML.AMVmmmmMM .AMA.   .AMMA..JMMmmmdP'     `\"bmmd\"'   .JMML. .JMM.\n" +
                "                                                                                                                                  ");
        System.out.println("POR RAÚL BAEZA OSUNA");
        System.out.println("Estas ante un arbolizador, su función principal es transformar listas en arboles de decisión.\n" +
                "\n" +
                "\n" +
                "Lo primero que te voy a pedir es que crees una carpeta donde quieras y me pegues la\n" +
                "dirección aquí debajo, ahí se te va a crear un archivo de texto llamado Listado.txt como \n" +
                "ejemplo (es el del ejercicio), también se te crea otro archivo con otro ejemplo, cuando\n" +
                "se te genere lo vuelves a ejecutar y ya empieza a funcionar. \n\n" +
                "Lo he programado para que puedas modificar el fichero y juguetear con él, pero tienes que \n" +
                "tener cuidado de que no puede haber líneas en blanco, las separaciones las hago por\n" +
                "espacios así que por ejemplo si quieres poner AZUL MARINO vas a tener que poner AZUL_MARINO \n" +
                "y que las columnas prescindibles, como NOMBRES, no las pongas \uF04A \n");




        Lista lista =new Lista();
        if (lista.lectorFich()==1){
            Arbol arbol;
            arbol=lista.id3();
            arbol.imprimir();
            System.out.println("Todo ha ido bien");
        }else {
            System.out.println("Vuelve a ejecutar el programa");
        }


    }
}
