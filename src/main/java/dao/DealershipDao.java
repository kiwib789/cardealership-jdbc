package dao;

import com.pluralsight.car.dealership.Dealership;

import java.util.List;

public interface DealershipDao {
    List<Dealership> findAllDealerships();
}
