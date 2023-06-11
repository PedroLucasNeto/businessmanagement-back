package com.alanaretratos.model.serviceImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.ClientDTOForm;
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
	public void createClient(ClientDTOForm clientDTO) throws Exception {
		Client client = new Client();

		BeanUtils.copyProperties(client, clientDTO);

		client.persist();

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
	public void updateClient(ClientDTOForm clientDTO) throws Exception {
		Client client = clientRepository.findByIdOptional((long) 1).orElseThrow();
		
		BeanUtils.copyProperties(clientDTO, client);

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
