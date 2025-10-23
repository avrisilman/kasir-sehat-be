package com.kasir.sehat.repository;

import com.kasir.sehat.entity.Menu;
import com.kasir.sehat.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByCategory(String category);
}
