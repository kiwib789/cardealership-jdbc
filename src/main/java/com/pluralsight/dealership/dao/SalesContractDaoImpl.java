package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.SalesContract;

import java.util.List;

public class SalesContractDaoImpl implements SalesContractDao {
    @Override
    public List<SalesContract> findAllSalesContracts() {
        return List.of();
    }

    @Override
    public SalesContract findSalesContractById(int id) {
        return null;
    }

    @Override
    public void addSalesContract(SalesContract salesContract) {

    }

    @Override
    public void updateSalesContract(SalesContract salesContract) {

    }

    @Override
    public void deleteSalesContract(int id) {

    }
}
