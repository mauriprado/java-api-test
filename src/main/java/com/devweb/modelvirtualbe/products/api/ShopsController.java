package com.devweb.modelvirtualbe.products.api;

import com.devweb.modelvirtualbe.products.domain.model.entity.Shop;
import com.devweb.modelvirtualbe.products.domain.service.ShopService;
import com.devweb.modelvirtualbe.products.mapping.ShopMapper;
import com.devweb.modelvirtualbe.products.resource.CreateShopResource;
import com.devweb.modelvirtualbe.products.resource.ShopResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Shops")
@RestController
@RequestMapping("/api/v1/shops")
public class ShopsController {
    private final ShopService shopService;
    private final ShopMapper mapper;

    public ShopsController(ShopService shopService, ShopMapper mapper) {
        this.shopService = shopService;
        this.mapper = mapper;
    }
    @GetMapping
    public List<Shop> getAllShops(){
        return shopService.getAll();
    }
    @GetMapping("{shopId}")
    public ShopResource getShopById(@PathVariable Long shopId){
        return mapper.toResource(shopService.getById(shopId));
    }
    @PostMapping
    public ShopResource createShop(@RequestBody CreateShopResource resource){
        return mapper.toResource(shopService.create(mapper.toModel(resource)));
    }
}
