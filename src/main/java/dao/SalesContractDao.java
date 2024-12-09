package dao;

import com.pluralsight.car.dealership.SalesContract;

import java.util.List;

public interface SalesContractDao {
    List<SalesContract> findAllSalesContracts();
    SalesContract findSalesContractById(int id);
    void addSalesContract(SalesContract salesContract);
    void updateSalesContract(SalesContract salesContract);
    void deleteSalesContract(int id);
}
