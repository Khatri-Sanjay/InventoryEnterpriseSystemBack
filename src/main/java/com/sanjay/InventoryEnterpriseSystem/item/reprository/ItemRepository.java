package com.sanjay.InventoryEnterpriseSystem.item.reprository;

import com.sanjay.InventoryEnterpriseSystem.item.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Long> {
}
