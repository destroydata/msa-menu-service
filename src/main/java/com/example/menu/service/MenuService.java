package com.example.menu.service;

import com.example.menu.domain.entity.Menu;
import com.example.menu.domain.request.MenuRequest;
import com.example.menu.domain.response.MenuResponse;
import com.example.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<MenuResponse> getByIds(List<Long> ids){
        List<Menu> menus = menuRepository.findByIdIn(ids);
// select * from menus where id in {};
        return menus.stream()
                .map(MenuResponse::of)
                .toList();

    }

}
