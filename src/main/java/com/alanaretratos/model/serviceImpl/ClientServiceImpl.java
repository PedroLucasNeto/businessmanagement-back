package com.alanaretratos.model.serviceImpl;

import java.util.List;

import com.alanaretratos.model.DTO.ClientDTO;
import com.alanaretratos.model.entity.Client;
import com.alanaretratos.model.repository.ClientRepository;
import com.alanaretratos.model.service.ClientService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class ClientServiceImpl implements ClientService {

	@Inject
	ClientRepository clientRepository;

	@Override
	public void createClient(ClientDTO clientDTO) throws Exception {
		Client client = clientRepository.findById(clientDTO.getId());
		if (client.equals(null)) {
			client.setDateOfBirth(clientDTO.getDateOfBirth());
			client.setEmail(clientDTO.getEmail());
			client.setInstagram(clientDTO.getInstagram());
			client.setName(clientDTO.getName());
			client.setObservation(clientDTO.getObservation());
			client.setPhone(clientDTO.getPhone());

			client.persist();
		} else {
			throw new Exception("Couldn't create this Client");
		}

	}

	@Override
	public List<Client> listAllClients() {

		return clientRepository.findAllActivated();
	}

	@Override
	public Client getClientById(Long id) {
		Client client = clientRepository.findByIdOptional(id).orElseThrow();
		return client;
	}

	@Override
	public void updateClient(ClientDTO clientDTO) throws Exception {
		Client client = clientRepository.findByIdOptional(clientDTO.getId()).orElseThrow();
		client.setDateOfBirth(clientDTO.getDateOfBirth());
		client.setEmail(clientDTO.getEmail());
		client.setInstagram(clientDTO.getInstagram());
		client.setName(clientDTO.getName());
		client.setObservation(clientDTO.getObservation());
		client.setPhone(clientDTO.getPhone());

		client.persist();

	}

	@Override
	public void deleteClientFromDB(Long id) throws Exception {
		Client client = clientRepository.findByIdOptional(id).orElseThrow();

		clientRepository.delete(client);

	}

	@Override
	public void deleteClientFromView(Long id) throws Exception {
		Client client = clientRepository.findByIdOptional(id).orElseThrow();
		client.setStatus(UtilConstants.STATUS_DEACTIVATED);

		client.persist();
	}

}
