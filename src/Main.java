    import java.util.Scanner;



    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduzca la primera consonante a buscar: ");
            String c1 = scanner.nextLine();
            System.out.println("Introduzca la segunda consonante a buscar: ");
            String c2 = scanner.nextLine();
            System.out.println("Introduzca la tercera consonante a buscar: ");
            String c3 = scanner.nextLine();
            System.out.println("Introduzca la cuarta consonante a buscar: ");
            String c4 = scanner.nextLine();
            System.out.println("Introduzca la quinta consonante a buscar: ");
            String c5 = scanner.nextLine();
            System.out.println("Introduzca el texto");
            String texto = scanner.nextLine();
            String textoLargo = texto.repeat(2000);
            char[] consonantes = {
                    c1.charAt(0),
                    c2.charAt(0),
                    c3.charAt(0),
                    c4.charAt(0),
                    c5.charAt(0)
            };
            Contador contador = new Contador();
            HiloContador[] hilos = new HiloContador[5];
            for (int i = 0; i <     hilos.length; i++) {
                hilos[i] = new HiloContador(consonantes[i], textoLargo, contador);
                hilos[i].start();
            }

            for(int i = 0; i < hilos.length; i++){
                try{
                    hilos[i].join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            for(int i = 0; i < hilos.length; i++){
                System.out.println("El hilo para la consonante " + consonantes[i] + " contó " + hilos[i].getContadorLocal());

            }

            System.out.println("Total de apariciones: " + contador.getTotal());

        }

    }