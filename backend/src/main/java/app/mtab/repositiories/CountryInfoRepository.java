package app.mtab.repositiories;

import app.mtab.models.Countryinfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryInfoRepository extends CrudRepository<Countryinfo, Long> {
}
