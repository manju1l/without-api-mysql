package com.example.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.exam.model.Model;

public interface Repo extends  JpaRepository<Model, Integer> {

}
