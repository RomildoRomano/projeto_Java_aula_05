package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import entities.Empresa;
import entities.Funcionario;
import repositories.EmpresaRepository;
import repositories.EmpresaRepositoryXml;

public class EmpresaController {

	public void cadastrarEmpresa() {

		Scanner scanner = new Scanner(System.in);
		try {
			Empresa empresa = new Empresa();
			empresa.setId(UUID.randomUUID());

			System.out.print("NOME FANTASIA DA EMPRESA.....:");
			empresa.setNomeFantasia(scanner.nextLine());
			System.out.print("RAZAO SOCIAL DA EMPRESA.....:");
			empresa.setRazaoSocial(scanner.nextLine());
			System.out.print("CNPJ DA EMPRESA.....:");
			empresa.setCnpj(scanner.nextLine());
			System.out.print("QTD DE FUNCIONÁRIOS.......: ");
			Integer quantidade = Integer.parseInt(scanner.nextLine());

			if (quantidade > 0) {

				empresa.setFuncionarios(new ArrayList<Funcionario>());

				for (int i = 1; i <= quantidade; i++) {

					Funcionario funcionario = new Funcionario();
					funcionario.setId(UUID.randomUUID());

					System.out.println("\nINFORME O " + i + "° FUNCIONARIO:");

					System.out.print("NOME DO fUNCIONARIO.....:");
					funcionario.setNome(scanner.nextLine());
					System.out.print("CPF DO fUNCIONARIO.....:");
					funcionario.setCpf(scanner.nextLine());
					System.out.print("SALARIO DO fUNCIONARIO.....:");
					funcionario.setSalario(Double.parseDouble(scanner.nextLine()));

					empresa.getFuncionarios().add(funcionario);

					// exportar os dados do funcionário para XML
					EmpresaRepository empresaRepository = new EmpresaRepositoryXml();
					empresaRepository.exportar(empresa);

					System.out.println("\nEMPRESA CADASTRADA COM SUCESSO!");
				}

			}

		} catch (IllegalArgumentException e) {
			System.out.println("\"n erro de validação");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("\n Falha ao cadastrar empresa" + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
