package com.example.menu.service;

import com.example.menu.domain.request.MenuRequest;
import com.example.menu.domain.response.MenuResponse;
import com.example.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    public void save(MenuRequest request){
        menuRepository.save(request.toEntity());
    }

    public Page<MenuResponse> getByStoreId(Long storeId, PageRequest request){
        return menuRepository.findByStore(
                storeId,
                request
        );
    }

}
