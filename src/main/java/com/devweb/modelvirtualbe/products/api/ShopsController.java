package com.devweb.modelvirtualbe.products.api;

import com.devweb.modelvirtualbe.products.domain.model.entity.Shop;
import com.devweb.modelvirtualbe.products.domain.service.ShopService;
import com.devweb.modelvirtualbe.products.mapping.ShopMapper;
import com.devweb.modelvirtualbe.products.resource.CreateShopResource;
import com.devweb.modelvirtualbe.products.resource.ShopResource;
import com.devweb.modelvirtualbe.products.resource.UpdateShopResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Shops")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/shops")
public class ShopsController {
    @Autowired
    ShopService shopService;
    @Autowired
    private ShopMapper mapper;

    @GetMapping
    public List<ShopResource> getAllShops() {
        return mapper.toResourceList(shopService.getAll());
    }
    @GetMapping("{shopId}")
    public ShopResource getShopById(@PathVariable("shopId") Long id) {
        return mapper.toResource(shopService.getById(id));
    }
    @PostMapping
    public ShopResource createShop(@RequestBody CreateShopResource request) {
        return mapper.toResource(shopService.create(mapper.toModel(request)));
    }
    @PutMapping("{shopId}")
    public ShopResource updateShop(@PathVariable Long shopId, @RequestBody UpdateShopResource request) {
        return mapper.toResource(shopService.update(shopId, mapper.toModel(request)));
    }
    @DeleteMapping("{shopId}")
    public ResponseEntity<?> deleteShop(@PathVariable Long shopId) {
        return shopService.delete(shopId);
    }
}
