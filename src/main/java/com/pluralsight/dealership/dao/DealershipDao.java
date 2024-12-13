package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.Dealership;

import java.util.List;

public interface DealershipDao {
    List<Dealership> findAllDealerships();
    List<Dealership> findDealershipById();
}
