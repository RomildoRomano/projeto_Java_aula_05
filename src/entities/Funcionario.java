package entities;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcionario {

	private UUID id;
	private String nome;
	private String cpf;
	private Double salario;
	private Empresa empresa;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(UUID id, String nome, String cpf, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {

		Pattern pattern = Pattern.compile("^[A-Za-zÀ-Üà-ü\\s]{8,100}$");
		Matcher matcher = pattern.matcher(nome);

		if (!matcher.matches())
			throw new IllegalArgumentException("Erro.Informe um nome válido de 8 a 100caracteres.");

		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {

		Pattern pattern = Pattern.compile("^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$");
		Matcher matcher = pattern.matcher(cpf);

		if (!matcher.matches())
			throw new IllegalArgumentException("Erro.Informe o cpf no formato '999.999.999-99'	ou '99999999999'.");

		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {

		if (salario <= 0)
			throw new IllegalArgumentException("Erro.Informe um valor de salário maior do que zero.");

		this.salario = salario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
