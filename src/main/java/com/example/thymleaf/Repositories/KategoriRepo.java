package com.example.thymleaf.Repositories;

import com.example.thymleaf.Models.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriRepo extends JpaRepository<Kategori, Long> {
}
