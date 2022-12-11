package com.example.khusbu.Repository;

import com.example.khusbu.Model.Deal;
import com.example.khusbu.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DealRepository extends JpaRepository<Deal,Long> {
    Optional<List<Deal>> findByEmail(String email);
}
