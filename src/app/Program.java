package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Dados do Funcion?rio:");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("N?vel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Sal?rio Base: ");
		double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos para este trablhador? ");
		int n = sc.nextInt();

		for (int i=1; i<=n; i++) {
			System.out.println("Entre com o contrato #" + i + ":");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Dura??o (horas): ");
			int horas = sc.nextInt();
			HoraContrato contrato = new HoraContrato(dataContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
		}

		System.out.println();
		System.out.print("Entre com o m?s e ano para calcular a renda (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda no m?s " + mesEAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));
		
		
		sc.close();

	}

}
