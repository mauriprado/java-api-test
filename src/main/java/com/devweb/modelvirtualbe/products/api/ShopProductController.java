package com.devweb.modelvirtualbe.products.api;

import com.devweb.modelvirtualbe.products.domain.service.ProductService;
import com.devweb.modelvirtualbe.products.mapping.ProductMapper;
import com.devweb.modelvirtualbe.products.resource.CreateProductResource;
import com.devweb.modelvirtualbe.products.resource.ProductResource;
import com.devweb.modelvirtualbe.products.resource.UpdateProductResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="ShopProduct")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/shops/{shopId}/product")
public class ShopProductController {
    private final ProductService productService;
    private final ProductMapper mapper;

    public ShopProductController(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ProductResource> getAllProductByShopId(@PathVariable Long shopId){
        return mapper.ListToResource(productService.getAllByShopId(shopId));
    }

    @PostMapping
    public ProductResource createProduct(@PathVariable Long shopId, @RequestBody CreateProductResource resource){
        return mapper.toResource(productService.create(shopId,mapper.toModel(resource)));
    }

    @PutMapping("{productId}")
    public ProductResource updateProduct(@PathVariable Long shopId, @PathVariable Long productId, @RequestBody UpdateProductResource resource){
        return mapper.toResource(productService.update(shopId,productId,mapper.toModel(resource)));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long shopId,@PathVariable Long productId){
        return productService.delete(shopId,productId);
    }


}
