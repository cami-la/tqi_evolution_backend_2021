package br.com.tqi.emprestimos.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tqi.emprestimos.dto.response.ClienteResponseDTO;
import br.com.tqi.emprestimos.entities.Cliente;
import br.com.tqi.emprestimos.repositories.ClienteRespository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRespository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<ClienteResponseDTO> findAll(){
		
		List<Cliente> clientes = repository.findAll();
		List<ClienteResponseDTO> clientesDTO = new ArrayList<>();
		
		for(Cliente c : clientes) {
			ClienteResponseDTO clienteDTO = modelMapper.map(c, ClienteResponseDTO.class);
			clientesDTO.add(clienteDTO);
		}
		
		return clientesDTO;
	}
	
		
	public ClienteResponseDTO findById(Long id) {
		
		Cliente entity = repository.findById(id).get();
		return modelMapper.map(entity, ClienteResponseDTO.class);

	}

}
