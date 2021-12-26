package br.com.tqi.emprestimos.dto.response;

import br.com.tqi.emprestimos.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String cpf;
	
	private String rg;
	
	private Double renda;
		
	private Endereco endereco;
	

}
