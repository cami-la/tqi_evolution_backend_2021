package br.com.tqi.emprestimos.services;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tqi.emprestimos.dto.request.EmprestimoRequestDTO;
import br.com.tqi.emprestimos.dto.response.MensagemResponseDTO;
import br.com.tqi.emprestimos.entities.Emprestimo;
import br.com.tqi.emprestimos.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	
	public MensagemResponseDTO cadastrarEmprestimo(EmprestimoRequestDTO emprestimoRequestDTO) {
		String msg;
		Emprestimo emprestimo = modelMapper.map(emprestimoRequestDTO, Emprestimo.class);
		LocalDate dataLimite = LocalDate.now().plusMonths(3);
		
		if((emprestimoRequestDTO.getDataPrimeiraParcela().isBefore(dataLimite)) || 
				(emprestimoRequestDTO.getDataPrimeiraParcela().equals(dataLimite))) {
			
			msg = "Emprestimo Criado com sucesso!";
			repository.save(emprestimo);
			
			
		} else {
			msg = "Data da primeira parcela inválida!";
		}
		
		return MensagemResponseDTO.builder().mensagem(msg).build();
		
	}

}
