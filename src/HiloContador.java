    public class HiloContador  extends Thread{
        private char c;
        private String texto;
        private Contador contadorComparte;
        private int contadorLocal;

        public HiloContador(char c, String texto, Contador contadorComparte){
            this.c = c;
            this.texto = texto;
            this.contadorComparte = contadorComparte;
            this.contadorLocal = 0;

        }

        @Override
        public void run(){
            for(int i = 0; i < texto.length(); i++){
                if(texto.charAt(i) == c){
                    contadorLocal++;
                    contadorComparte.sumar(1);
                }

                }
            }

            public int getContadorLocal(){
            return contadorLocal;
            }
        }
