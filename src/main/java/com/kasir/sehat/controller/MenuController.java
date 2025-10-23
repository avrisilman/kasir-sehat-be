package com.kasir.sehat.controller;

import com.kasir.sehat.dto.MenuCategoryResponse;
import com.kasir.sehat.dto.MenuResponse;
import com.kasir.sehat.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/menu_category")
    public ResponseEntity<List<MenuCategoryResponse>> getMenuCategory() {
        List<MenuCategoryResponse> response = menuService.getMenuCategoryResponse();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/menu")
    public ResponseEntity<List<MenuResponse>> getMenuByCategory(@RequestParam("category") String category) {
        List<MenuResponse> response = menuService.getMenuResponse(category);
        return ResponseEntity.ok(response);
    }

}
