import java.util.Scanner;

public class Main {

    static int posicoesPreenchidas=0;
    public static void main(String[] args) {
        int numeros=0;
        int opcao;
        boolean sair=false;
        double valores [] = new double[10];
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Digite uma opção");
            System.out.println("1 - Inserir números");
            System.out.println("2 - Exibir Vetor");
            System.out.println("3 - Sair");
            opcao = s.nextInt();

            if(opcao==1){
                inseir(valores);
            }else if(opcao==2){
                exibirVetor(valores);
            }else if(opcao==3){
                sair=true;
            }else{
                System.out.println("Opção invalida.");
            }
        }while (!sair);

    }

    public static void inseir(double valores[] ){
        int novoNumero;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Digite o numero a ser inserido");
            if(posicoesPreenchidas<valores.length){
                double numero = s.nextDouble();
                if(buscarNumero(valores,numero)==0){
                    valores[posicoesPreenchidas] = numero;
                    posicoesPreenchidas++;
                }else{
                    System.out.println("O numero já esta no vetor");
                }
            }else{
                System.out.println("O vetor esta cheio");
            }
            System.out.println("Deseja inserir um novo numero?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            novoNumero=s.nextInt();
            if(novoNumero!=1 &&novoNumero!=2){
                System.out.println("Numero invalido");
            }
        }while(novoNumero==1);

    }

    public static int buscarNumero(double valores[] ,double numeroBuscado){

        for(int i=0; i<posicoesPreenchidas;i++){
            if(valores[i]==numeroBuscado){
                return 1;
            }
        }
        return 0;
    }

    public static void exibirVetor(double valores[] ){
        valores = ordenador(valores);
        for(int i =0; i<posicoesPreenchidas;i++){
            System.out.println("Posição:"+(i+1)+ " Numero:+"+valores[i]);
        }
    }

    private static double[] ordenador (double[] valores) {
        double auxiliar = 0;
        for (int i=0; i<posicoesPreenchidas; i++) {
            for (int j=0; j<posicoesPreenchidas-1; j++) {
                if (valores[j+1] < valores[j]) {
                    auxiliar = valores[j+1];
                    valores[j+1] = valores[j];
                    valores[j] = auxiliar;
                }
            }
        }
        return valores;
    }
}