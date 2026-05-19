package com.gabrielteodoro.trackassets.repository;

import com.gabrielteodoro.trackassets.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
}
