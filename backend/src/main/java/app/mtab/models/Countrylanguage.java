package app.mtab.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Countrylanguage {

    @Id
    private String countrycode;
    private String language;
    private Boolean is_official;
    private Double percentage;

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getOfficial() {
        return is_official;
    }

    public void setOfficial(Boolean official) {
        is_official = official;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
