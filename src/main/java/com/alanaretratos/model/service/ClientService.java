package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.ClientDTO;
import com.alanaretratos.model.entity.Client;

import jakarta.ws.rs.PathParam;

public interface ClientService {

	void createClient(ClientDTO clientDTO) throws Exception;

	void deleteClientFromView(@PathParam("id") Long id) throws Exception;

	void updateClient(ClientDTO clientDTO) throws Exception;

	List<Client> listAllClients();

	Client getClientById(Long id);

	void deleteClientFromDB(Long id) throws Exception;
}
