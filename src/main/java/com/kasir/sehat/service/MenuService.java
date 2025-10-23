package com.kasir.sehat.service;

import com.kasir.sehat.dto.MenuCategoryResponse;
import com.kasir.sehat.dto.MenuResponse;
import com.kasir.sehat.entity.Menu;
import com.kasir.sehat.entity.MenuCategory;
import com.kasir.sehat.repository.MenuCategoryRepository;
import com.kasir.sehat.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuCategoryRepository menuCategoryRepository;
    private final ModelMapper modelMapper;

    public List<MenuCategoryResponse> getMenuCategoryResponse() {
        List<MenuCategory> menus = menuCategoryRepository.findAll();
        return menus.stream()
                .map(menu -> modelMapper.map(menu, MenuCategoryResponse.class))
                .collect(Collectors.toList());
    }

    public List<MenuResponse> getMenuResponse(String category) {
        List<Menu> menus = menuRepository.findAllByCategory(category);
        return menus.stream()
                .map(menu -> modelMapper.map(menu, MenuResponse.class))
                .collect(Collectors.toList());
    }

}
