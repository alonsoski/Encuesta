import java.lang.Math;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numero=generadorDeNumero();
        System.out.println(numero);
        char[][] votos = votacion(2);
        conteo(votos);

    }

    private static void conteo(char[][] votos) {
        int hombres=0;
        int mujeresD=0;
        int mujeresA=0;
        int total= ((votos[0].length))*2;

        for (int i = 0; i <votos[0].length ; i++) {
            if (votos[0][i]=='s'){
                hombres++;
            }
            if (votos[1][i]=='n'){
                mujeresD++;
            }
            if (votos[1][i]=='s'){
                mujeresA++;
            }
        }
        double porecentajeA=((double) (hombres + mujeresA) /total)*100;



        System.out.println("la cantidad de hombres que aprueban es de:"+hombres);
        System.out.println("la cantidad de mujeres que desaprueban es de:"+mujeresD);
        System.out.println("el porcentaje de aprobacion:"+porecentajeA);
        System.out.println("personas enuestadas:"+total+"%");
    }

    private static char[][] votacion(int numero) {
        char[][] votos = new char[2][numero];
        for (int i = 0; i <votos[0].length ; i++) {
            votos[0][i]=pregunta("hombre",i);
            votos[1][i]=pregunta("mujer",i);
        }
        return votos;
    }

    private static char pregunta(String sexo, int i) {
        Scanner t = new Scanner(System.in);
        char respuesta='a';
        boolean paso=true;
        System.out.println(sexo+"n°"+(i+1));
        System.out.println("ud aprueba la gestion del gobierno?");
        System.out.println("s.-Si");
        System.out.println("n.-No");
        System.out.println("x.-No sabe");
        respuesta= validacion();
        return respuesta;
    }

    private static char validacion() {
        Scanner t = new Scanner(System.in);
        boolean paso = true;
        String respuesta;
        do {
            respuesta = t.nextLine();
            if (!(respuesta.toLowerCase().charAt(0)=='s') && !(respuesta.toLowerCase().charAt(0)=='n') && !(respuesta.toLowerCase().charAt(0)=='x')){
                paso=false;
            }else {
                paso=true;
            }

        }while (!paso);
        return respuesta.charAt(0);

    }

    private static int generadorDeNumero() {
        int numero=(int) Math.random()*10;

        return 5;
    }
}