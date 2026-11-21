
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reserva [] reserva = new Reserva[10];
        String nomeHospede;
        String tipoQuarto;
        int numeroDias;
        double valorDiaria;
        int contadorReservas = 0;
        int opcao = 0;
        do {
        System.out.println("Menu principal:\n" +
                "1 - Cadastrar Nova Reserva\n" +
                "2 - Listar Reservas\n" +
                "3 - Buscar reservas por nome do hóspede\n" +
                "4 - Ordenar Reservas por números de dias (em ordem decrescente)\n" +
                "5 - Sair");
        opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao){
            case 1:
                if (contadorReservas < reserva.length) {
                    System.out.println("Digite o nome do hospede: ");
                    nomeHospede = scanner.nextLine();
                    System.out.println("Digite o numero de dias que ficara hospedado: ");
                    numeroDias = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o tipo de quarto: ");
                    tipoQuarto = scanner.nextLine();
                    System.out.println("Digite o valor da diária: ");
                    valorDiaria = scanner.nextDouble();
                    reserva[contadorReservas] = new Reserva(nomeHospede,numeroDias,tipoQuarto,valorDiaria);
                    contadorReservas++;
                    System.out.println("Reserva cadastrada com sucesso.\n");
                }else {
                    System.out.println("Não é possivel adicionar mais reservas. (Limite de 10 atingido)");
                }
                break;
            case 2:
                if (contadorReservas > 0){
                    for (int i = 0; i < contadorReservas; i++) {
                        System.out.println(reserva[i]);
                    }
                }else {
                    System.out.println("Nenhuma reserva cadastrada.");
                }
                break;
            case 3:
                System.out.println("Digite o nome do hospede a ser buscado: ");
                String nome = scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < contadorReservas; i++) {
                    if (reserva[i].getNomeHospede().toLowerCase().contains(nome.toLowerCase())){
                        System.out.println(reserva[i]);
                        encontrado = true;
                    }
                }
                if (!encontrado){
                    System.out.println("Nome não encontrado");
                }
                break;
            case 4:
                if (contadorReservas > 0){
                Reserva auxiliar;
                for (int i = 0; i < contadorReservas; i++) {
                    for (int j = 0; j < contadorReservas - 1; j++) {
                        if (reserva[j].getNumeroDias() < reserva[j + 1].getNumeroDias()){
                            auxiliar = reserva[j];
                            reserva[j] = reserva[j + 1];
                            reserva[j+1] = auxiliar;
                        }
                    }
                }
                    for (int i = 0; i < contadorReservas; i++) {
                        System.out.println(reserva[i]);
                    }
                }else {
                    System.out.println("Nenhuma reserva cadastrada.");
                }

                break;
            case 5:
                System.out.println("Programa encerrado.");
                break;
            default:
                System.out.println("Opção invalida.");
                break;
        }
        }while (opcao != 5);
        scanner.close();

    }
}
