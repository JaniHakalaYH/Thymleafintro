package com.example.thymleaf.Repositories;

import com.example.thymleaf.Models.Kund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundRepo extends JpaRepository<Kund, Long> {
}
