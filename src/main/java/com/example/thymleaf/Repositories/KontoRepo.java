package com.example.thymleaf.Repositories;

import com.example.thymleaf.Models.Konto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KontoRepo extends JpaRepository<Konto, Long> {
}
