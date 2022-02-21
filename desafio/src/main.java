import java.util.Scanner;
import java.util.InputMismatchException;

public class main {
	public static void main(String[]args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {

			int opcao = -1;

			try {
				System.out.println("Informe qual questão deseja acesar:");
				System.out.println("[1] - Questão 1.");
				System.out.println("[2] - Questão 2.");
				System.out.println("[3] - Questão 3.");
				System.out.println("[0] - Sair da Avaliação.");
				opcao = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\nInvalido!\n");
				scanner.next();
			}
			
			if(opcao == 1) {
				questao01(scanner);
			}
			else if(opcao == 2) {
				questao02(scanner);
			}
			else if(opcao == 3) {
				questao03(scanner);
			}
			else if( Integer.parseInt(String.valueOf(opcao)) == 0 ) {
				break;
			}
		}
		
		System.out.println("Avaliação Finalizada!");
		
		scanner.close();
	}
	
	/**
	 * Questão 01 do desafio de programação
	 * @param scanner
	 */
	public static void questao01( Scanner scanner ) {

		int n = -1;
		String linha = "";
		Integer ctrl = 0;
		
		try {
			System.out.println("Informe o valor da base:");
			n = scanner.nextInt();
			
			ctrl = n - 1;
			
			for(int i = 1; i <= n; i++) {
				for(int x = 0; x < ctrl; x++) {
					linha += " ";
				}

				for(int y = 1; y <= i; y++) {
					linha += "*";
				}
				
				System.out.println(linha);
				linha = "";
				ctrl -= 1;
			}
			
		} catch(InputMismatchException e) {
			System.out.println("\nInvalido!\n");
			scanner.next();
		}
	}
	
	/**
	 * Questão 02 do desafio de programação
	 * @param scanner
	 */
	public static void questao02(Scanner scanner) {
		
		String senha = "";

		System.out.println("Abaixo segue as recomendações para uma senha forte.\n");
		System.out.println("1) Possui no mínimo 6 caracteres.");
		System.out.println("2) Contém no mínimo 1 digito.");
		System.out.println("3) Contém no mínimo 1 letra em minúsculo.");
		System.out.println("4) Contém no mínimo 1 letra em maiúsculo.");
		System.out.println("5) Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+");
		
		System.out.println("Obs.: Digite 0 (ZERO) para sair!\n");
		
		while(true) {

			String fraseInicial = "Digite sua senha:";
			if(senha != "" ) {
				fraseInicial = "Digite sua senha novamente:";
			}
			System.out.println(fraseInicial);
			senha = scanner.next();
			
			try {
				if( Integer.parseInt(String.valueOf(senha.charAt(0))) == 0 ) {
					break;
				}
			} catch(NumberFormatException e) {}
			
			Boolean possuiMinimoCaracter = qtdeMinimoCaracter(senha);
			Boolean possuiMinimoDigito = qtdeMinimoDigito(senha);
			Boolean possuiMinimoMinusculo = qtdeMinimoMinusculo(senha);
			Boolean possuiMinimoMaiusculo = qtdeMinimoMaiusculo(senha);
			Boolean possuiCaracterEspecial = possuiCaracterEspecial(senha);
			
			if( !possuiMinimoCaracter || !possuiMinimoDigito || !possuiMinimoMinusculo || !possuiMinimoMaiusculo || !possuiCaracterEspecial ) {
				System.out.println("\nSenha fraca, você deve seguir as recomendações abaixo para ter uma senha forte!\n");
			} else {
				// senha forte
				System.out.println("\nSenha forte!\n");
				break;
			}
			
			if( !possuiMinimoCaracter ) {
				System.out.println("1) Possui no mínimo 6 caracteres.");
			}
			if( !possuiMinimoDigito ) {
				System.out.println("2) Contém no mínimo 1 digito.");
			}
			if( !possuiMinimoMinusculo ) {
				System.out.println("3) Contém no mínimo 1 letra em minúsculo.");
			}
			if( !possuiMinimoMaiusculo ) {
				System.out.println("4) Contém no mínimo 1 letra em maiúsculo.");
			}
			if( !possuiCaracterEspecial ) {
				System.out.println("5) Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+");
			}
			
			System.out.println("\nObs.: Digite 0 (ZERO) para sair!\n");
		}
	}
	
	/**
	 * Retorna a quantidade de anagramas encontrados
	 * @param buscarAnagrama
	 * @param anagrama
	 * @param maxBusca
	 * @return INteger
	 */
	public static Integer validaAnagrama(String buscarAnagrama, String anagrama, Integer maxBusca) {

		Integer start = 0;
		Integer finish = buscarAnagrama.length();
		Integer finishLoop = anagrama.length() ;
		
		Integer totalAnagrama = 0;
		Integer ctrlAnagrama = -1;
		Integer ctrl = 0;
		
		char[] busca = new char[buscarAnagrama.length()];

		for (int i = 0; i < buscarAnagrama.length(); i++) {
			busca[i] = buscarAnagrama.charAt(i);
        }
		
		StringBuilder anagramaClone;
		
		while(true) {

			char[] buscaAtual = busca.clone();
			//String anagramaClone = new String(anagrama);
			anagramaClone = new StringBuilder(anagrama);
			ctrl = 0;
			// ifailuhkqq
			for (int i = 0; i < buscaAtual.length; i++) {
				for (int x = start; x < finish; x++) {
					if( buscaAtual[i] == anagramaClone.charAt(x) ) {
						buscaAtual[i] = '§';
						anagramaClone.setCharAt(x, '§');
					}
				}
	        }
			
			for (int i = 0; i < buscaAtual.length; i++) {
				if( buscaAtual[i] == '§' ) {
					ctrl += 1;
				}
	        }
			
			if( ctrl == buscaAtual.length ) {
				ctrlAnagrama += 1;
			}
			
			totalAnagrama += ctrlAnagrama;
			ctrlAnagrama = 0;
			
			if( finish < finishLoop ) {
				start += 1;
				finish += 1;
			} else {
				break;
			}
		}
		
		return totalAnagrama;
	}

	/**
	 * Questão 03 do desafio de programação
	 * @param scanner
	 */
	public static void questao03(Scanner scanner) {
		
		String anagrama;
		String buscarAnagrama = "";
		int maxBusca = 0;
		int startBusca = 0;
		int contagemTotal = 0;
		
		System.out.println("Informe uma palavra para verificar se possui anagramas:");
		anagrama = scanner.next();
		
		maxBusca = (anagrama.length() / 2) + (anagrama.length() % 2);

		while( startBusca < maxBusca ) {
			
			buscarAnagrama = anagrama.substring(0, (startBusca + 1));
			
			contagemTotal += validaAnagrama(buscarAnagrama, anagrama, maxBusca);
			
			startBusca++;
		}
		
		System.out.println("\nTotal de Anagramas: " + contagemTotal+"\n");
	}
	
	/**
	 * Valida se possui a qtde minima de caracteres aceita = 6 
	 * @param senha
	 * @return Boolean
	 */
	public static Boolean qtdeMinimoCaracter(String senha) {
		
		Integer qtdeMinimaCaracter = 6;
		Boolean possuiQtdeMinima = false;
		
		if( senha.length() >= qtdeMinimaCaracter ) {
			possuiQtdeMinima = true;
		}
		
		return possuiQtdeMinima;
	}

	/**
	 * Valida se possui a qtde de digito minimo = 1 
	 * @param senha
	 * @return Boolean
	 */
	public static Boolean qtdeMinimoDigito(String senha) {
		
		Boolean possuiQtdeMinimoDigito = false;
		
		for(int i = 0; i < senha.length(); i++) {
			if( Character.isDigit(senha.charAt(i)) ) {
				possuiQtdeMinimoDigito = true;
				break;
			}
		}

		return possuiQtdeMinimoDigito; 
	}

	/**
	 * Valida se possui a qtde minimo de letras minusculas = 1
	 * @param senha
	 * @return Boolean;
	 */
	public static Boolean qtdeMinimoMinusculo(String senha) {
		
		Boolean possuiQtdeMinimoMinusculo = false;
		
		for(int i = 0; i < senha.length(); i++) {
			if( Character.isLowerCase(senha.charAt(i)) ) {
				possuiQtdeMinimoMinusculo = true;
				break;
			}
		}

		return possuiQtdeMinimoMinusculo;
	}

	/**
	 * Valida se possui a quantidade minima de letras maiuscula = 1 
	 * @param senha
	 * @return Boolean
	 */
	public static Boolean qtdeMinimoMaiusculo(String senha) {
		Boolean possuiQtdeMinimoMaiusculo = false;
		
		for(int i = 0; i < senha.length(); i++) {
			if( Character.isUpperCase(senha.charAt(i)) ) {
				possuiQtdeMinimoMaiusculo = true;
				break;
			}
		}

		return possuiQtdeMinimoMaiusculo;
	}
	
	/**
	 * Valida se a senha informada possui algum dos caracteres especiais
	 * @param senha
	 * @return Boolean
	 */
	public static Boolean possuiCaracterEspecial(String senha) {

		char[] caracterEspecial = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};
		Boolean possuiCaracterEspecial = false;
		
		for(int s = 0; s < senha.length(); s++) {
			for(int c = 0; c < caracterEspecial.length; c++) {
				if(senha.charAt(s) == caracterEspecial[c]) {
					possuiCaracterEspecial = true;
					break;
				}
			}
		}
		
		return possuiCaracterEspecial;
	}

}