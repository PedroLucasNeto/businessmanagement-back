package com.alanaretratos.model.resource.rest;

import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

public class CorsResource {

    @OPTIONS
    @Path("/*")
    public Response corsPreflight() {
        ResponseBuilder builder = Response.status(Status.NO_CONTENT);
        builder.header("Access-Control-Allow-Origin", "*");
        builder.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        builder.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
        return builder.build();
    }
}