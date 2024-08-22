package com.ndn.springboothello.repositry;

import com.ndn.springboothello.Email;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EmailRepositry extends JpaRepository<Email, Integer> {

}