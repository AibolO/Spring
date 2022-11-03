package com.example.sportsmaster.repositories;

import com.example.sportsmaster.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
