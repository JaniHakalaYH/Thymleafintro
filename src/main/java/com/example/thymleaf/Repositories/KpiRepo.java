package com.example.thymleaf.Repositories;

import com.example.thymleaf.Models.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KpiRepo extends JpaRepository<Kpi, Long> {
}
