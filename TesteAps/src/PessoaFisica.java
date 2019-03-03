import java.util.Date;

public class PessoaFisica extends Pessoa {

	private String cpf;
	private Date dataNascimento;

	public PessoaFisica(String cpf) throws DocumentoInvalidoException {
		super();
		this.cpf = cpf;
		if (!validarDocumento()) {
			throw new DocumentoInvalidoException();
		}
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof PessoaFisica) {
			PessoaFisica p = (PessoaFisica) o;
			if(p.getCpf().equals(this.cpf)) {
				return true;
			}
		}
		return false;
	}

	public boolean validarDocumento() {
		if (getCpf().length() != 14) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		
		return "Nome: "+getNome()+"\nCPF: "+getCpf()+"\nData de Nascimento: "+getDataNascimento();
		
	}

	@Override
	int calcularIdade() {
		
		Date data = new Date();
		int idade = (data.getYear()+1900)-(getDataNascimento().getYear()+1900);
		
		return idade;
	}

}