

import java.util.List;

public interface DealershipDao {
    List<Dealership> findAllDealerships();
    List<Dealership> findDealershipById();
}
