package entities;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empresa {

	private UUID id;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private List<Funcionario> funcionarios;

	public Empresa() {
		// TODO Auto-generated constructor stub
	}

	public Empresa(UUID id, String nomeFantasia, String razaoSocial, String cnpj) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {

		Pattern pattern = Pattern.compile("^[A-Za-zÀ-Üà-ü0-9\\s]{6,100}$");
		Matcher matcher = pattern.matcher(nomeFantasia);

		if (!matcher.matches())
			throw new IllegalArgumentException("ERRO. INFORME UM NOME FANTASIA VÁLIDO DE 6 A 100 CARACTERES.");

		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {

		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		// cria um padrao
		Pattern pattern = Pattern.compile("^[A-Za-zÀ-Üà-ü0-9\\s]{6,100}$");
		// cria um comparador
		Matcher matcher = pattern.matcher(razaoSocial);

		if (!matcher.matches())
			throw new IllegalArgumentException("ERRO. INFORME UMA RAZAO SOCIAL VÁLIDA DE 6 A 100 CARACTERES.");

		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {

		Pattern pattern = Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");
		Matcher matcher = pattern.matcher(cnpj);

		if (!matcher.matches())
			throw new IllegalArgumentException("Erro.Informe o cnpj no padrão:'99.999.999/9999-99'.");

		this.cnpj = cnpj;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
