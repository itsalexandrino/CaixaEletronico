import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int op, cont;
		float quantia;
		int qtdDeNotas;
		
		CaixaEletronico caixa = new CaixaEletronico();
		
		do {
			System.out.println("-----------------------------------------------------------");
			System.out.println("             CAIXA ELETRONICO - Menu Principal");
			System.out.println("-----------------------------------------------------------\n");
			System.out.println("             Modulo do Cliente             ");
			System.out.println("1 - Sacar");
			System.out.println("             Modulo do Administrador             ");
			System.out.println("2 - Repor");
			System.out.println("3 - Consultar Saldo");
			System.out.println("             Modulo de Ambos             ");
			System.out.println("4 - Fim\n");
			System.out.printf("Opcao: ");
			op = teclado.nextInt(); 
			
			switch(op) {
				case 1: 
					System.out.println("-----------------------------------------------------------");
					System.out.println("             CAIXA ELETRONICO - Saque");
					System.out.println("-----------------------------------------------------------\n");
					
					System.out.printf("Digite o valor a sacar: ");
					quantia = teclado.nextFloat();
					boolean flag = caixa.sacar(quantia);
					
					if (flag == false) {
						System.out.println("Nao existem notas suficientes no Caixa para esta quantia!\n");
					}
					else {
						System.out.printf("Saque de R$ %.2f efetuado com sucesso!\n", quantia);
						
						System.out.printf("Notas de R$ 5        : %d\n", caixa.mostraQtdTipoNotas(5));
						System.out.printf("Notas de R$ 10       : %d\n", caixa.mostraQtdTipoNotas(10));
						System.out.printf("Notas de R$ 20       : %d\n", caixa.mostraQtdTipoNotas(20));
						System.out.printf("Notas de R$ 50       : %d\n", caixa.mostraQtdTipoNotas(50));
						System.out.printf("Notas de R$ 100      : %d\n\n", caixa.mostraQtdTipoNotas(100));
                                                System.out.println("Escolha uma das segiuintes opções abaixo:");
                                                System.out.printf("1 - Continuar \t 2 - Finalizar a Operação\n>> ");
                                                cont = teclado.nextInt();
                                                if(cont==1){
                                                    op = 0;
                                                }
                                                else if(cont==2){
                                                    op = 4;
                                                }
                                                else{
                                                    System.out.println("Escolha inválida! Por favor tente novamente.");
                                                }
					}
					break;
				case 2:
					System.out.println("-----------------------------------------------------------");
					System.out.println("             CAIXA ELETRONICO - Reposicao");
					System.out.println("-----------------------------------------------------------\n");
					
					System.out.printf("Notas de R$ 5: ");
					qtdDeNotas = teclado.nextInt();
					caixa.repor(5, qtdDeNotas);
					
					System.out.printf("Notas de R$ 10: ");
					qtdDeNotas = teclado.nextInt();
					caixa.repor(10, qtdDeNotas);
					
					System.out.printf("Notas de R$ 20: ");
					qtdDeNotas = teclado.nextInt();
					caixa.repor(20, qtdDeNotas);
					
					System.out.printf("Notas de R$ 50: ");
					qtdDeNotas = teclado.nextInt();
					caixa.repor(50, qtdDeNotas);
					
					System.out.printf("Notas de R$ 100: ");
					qtdDeNotas = teclado.nextInt();
					caixa.repor(100, qtdDeNotas);
					
					System.out.println("Reposicao efetuada com sucesso!");
					break;
				case 3:
					System.out.println("-----------------------------------------------------------");
					System.out.println("             CAIXA ELETRONICO - Saldo");
					System.out.println("-----------------------------------------------------------\n");
					
					System.out.printf("Saldo atual          : R$ %.2f\n", caixa.consultarSaldo());
					System.out.printf("Qtd. de saques       : %d\n", caixa.getQtdSaques());
					System.out.printf("Total de saques      : R$ %.2f\n", caixa.getTotalSaques());
					System.out.printf("Notas de R$ 5        : %d\n", caixa.mostraQtdTipoNotas(5));
					System.out.printf("Notas de R$ 10       : %d\n", caixa.mostraQtdTipoNotas(10));
					System.out.printf("Notas de R$ 20       : %d\n", caixa.mostraQtdTipoNotas(20));
					System.out.printf("Notas de R$ 50       : %d\n", caixa.mostraQtdTipoNotas(50));
					System.out.printf("Notas de R$ 100      : %d\n", caixa.mostraQtdTipoNotas(100));
					break;
				case 4: System.out.println("Volte sempre. Obrigado!\n");
					break;
				default: System.out.println("\nOperação inválida!");
			}
		} while(op != 4);
	}

}

