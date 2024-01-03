package repositories;

import java.io.PrintWriter;

import entities.Empresa;
import entities.Funcionario;

public class EmpresaRepositoryXml extends EmpresaRepository {

	@Override
	public void exportar(Empresa empresa) throws Exception {
		// criando um arquivo XML
		PrintWriter printWriter = new PrintWriter("c:\\temp\\empresa_" + empresa.getId() + ".xml");

		printWriter.write("<?xml version='1.0'encoding='UTF-8'?>");

		printWriter.write("<empresa>");
		printWriter.write("<id>" + empresa.getId() + "</id>");

		printWriter.write("<nomeFantasia>" + empresa.getNomeFantasia() + "</nomeFantasia>");

		printWriter.write("<razaoSocial>" + empresa.getRazaoSocial() + "</razaoSocial>");

		printWriter.write("<cnpj>" + empresa.getCnpj() + "</cnpj>");

		if (empresa.getFuncionarios() != null) {
			printWriter.write("<funcionarios>");
			for (Funcionario funcionario : empresa.getFuncionarios()) {

				printWriter.write("<funcionario>");

				printWriter.write("<id>" + funcionario.getId() + "</id>");

				printWriter.write("<nome>" + funcionario.getNome() + "</nome>");

				printWriter.write("<cpf>" + funcionario.getCpf() + "</cpf>");

				printWriter.write("<salario>" + funcionario.getSalario() + "</salario>");

				printWriter.write("</funcionario>");

			}
			printWriter.write("</funcionarios>");
		}
		printWriter.write("</empresa>");
		// salvando e fechando o arquivo
		printWriter.flush();
		printWriter.close();
	}

}
