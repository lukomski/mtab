package app.mtab.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Countryinfo { // tried to name CountryInfo, bo not loading from DB - good to know :)

    @Id
    private String _id;
    private String doc;

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
