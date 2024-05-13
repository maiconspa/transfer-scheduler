package br.com.TransferScheduler.repository;

import br.com.TransferScheduler.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, String> {
    public List<Transfer> findAll();
    List<Transfer> findBySourceAccount(String sourceAccount);
}
