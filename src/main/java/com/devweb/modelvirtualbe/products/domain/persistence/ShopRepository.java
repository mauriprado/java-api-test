package com.devweb.modelvirtualbe.products.domain.persistence;

import com.devweb.modelvirtualbe.products.domain.model.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Override
    List<Shop> findAll();

    Optional<Shop> findById(Long id);
    Shop findByLogoUrl(String logoUrl);
    Shop findByName(String name);
}
