package com.agnes.ScrapeIt.repository;

import com.agnes.ScrapeIt.response.ListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonListRepository extends JpaRepository<ListResponse, String> {
}
