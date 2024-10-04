package com.pawan.dreambuy.repository;
import com.pawan.dreambuy.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetPackageRepository extends JpaRepository<Package,Integer> {
}
