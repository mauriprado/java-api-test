package com.devweb.modelvirtualbe.products.api;

import com.devweb.modelvirtualbe.products.domain.model.entity.Favorite;
import com.devweb.modelvirtualbe.products.domain.service.FavoriteService;
import com.devweb.modelvirtualbe.products.mapping.FavoriteMapper;
import com.devweb.modelvirtualbe.products.resource.CreateFavoriteResource;
import com.devweb.modelvirtualbe.products.resource.FavoriteResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Favorites")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/favorites")
public class FavoritesController {
    private final FavoriteService favoriteService;
    private final FavoriteMapper mapper;
    public FavoritesController(FavoriteService favoriteService, FavoriteMapper mapper) {
        this.favoriteService = favoriteService;
        this.mapper = mapper;
    }
    @GetMapping
    public List<Favorite> getAllFavorites(){
        return favoriteService.getAll();
    }
    @GetMapping("{favoritesId}")
    public FavoriteResource getFavoritesId(@PathVariable Long favoritesId){
        return mapper.toResource(favoriteService.getById(favoritesId));
    }
    @GetMapping("/user/{userId}")
    public List<Favorite> getFavoriteByUserId(@PathVariable Long userId){
        return favoriteService.getFavoriteByUserId(userId);
    }
    @PostMapping
    public FavoriteResource createFavorite(@RequestBody CreateFavoriteResource resource){
        return mapper.toResource(favoriteService.create(mapper.toModel(resource)));
    }
    @DeleteMapping("{favoriteId}")
    public ResponseEntity<?> deleteShop(@PathVariable Long favoriteId){
        return favoriteService.delete(favoriteId);
    }
}
