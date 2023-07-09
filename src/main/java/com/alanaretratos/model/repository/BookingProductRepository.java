package com.alanaretratos.model.repository;

import com.alanaretratos.model.entity.BookingProduct;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookingProductRepository implements PanacheRepository<BookingProduct> {

}
