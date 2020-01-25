package app.mtab.repositiories;

import app.mtab.models.Countrylanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryLanguageRepository extends CrudRepository<Countrylanguage, String> {
}