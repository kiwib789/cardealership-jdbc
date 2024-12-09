package dao;

import com.pluralsight.car.dealership.SalesContract;
import config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SalesContractImpl implements SalesContractDao{

    @Override
    public List<SalesContract> findAllSalesContracts() {

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
