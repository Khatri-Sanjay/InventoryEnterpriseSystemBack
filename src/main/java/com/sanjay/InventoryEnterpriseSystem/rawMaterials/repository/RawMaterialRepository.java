package com.sanjay.InventoryEnterpriseSystem.rawMaterials.repository;

import com.sanjay.InventoryEnterpriseSystem.rawMaterials.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {
}
