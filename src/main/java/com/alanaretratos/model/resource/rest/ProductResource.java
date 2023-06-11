package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.alanaretratos.model.DTO.Form.ProductDTOForm;
import com.alanaretratos.model.entity.Product;
import com.alanaretratos.model.service.ProductService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.Data;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Produtos", description = "Operações referentes aos produtos")
@Data
public class ProductResource {
	
	@Inject
	ProductService productService;
	
	@POST
	public Response createProduct(ProductDTOForm productDTO) {
		try {
			productService.createProduct(productDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getProductById(@PathParam("id") Long id) {
		Product product = new Product();
		try {
			 product = productService.getProductById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(product).build();
	}
	
	@GET
	public Response listProduct() {
		List<Product>product = new ArrayList<>();
		try {
			 product = productService.listAllProducts();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(product).build();
	}

	@PUT
	@Path("{id}")
	public Response updateProduct(ProductDTOForm productDTO, @PathParam("id") Long id) {
		try {
			productService.updateProduct(productDTO, id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteProductView(Long id) {
		try {
			productService.getProductById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deleteProductDB(Long id) {
		try {
			productService.getProductById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}
}
