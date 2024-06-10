package com.server.catalog.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.locationtech.jts.geom.Point;

public class CityDTO {

    private Long cityId;
    private Long population;
    private Date populationDate;
    private Double latitude;
    private Double longitude;
    private Point location;
    private Set<CityNameDTO> cityNames;
    private Set<CityTagDTO> cityTags;

    public CityDTO() {
        this.cityNames = new HashSet<>();
        this.cityTags = new HashSet<>();
    }

    // Getters and Setters
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Date getPopulationDate() {
        return populationDate;
    }

    public void setPopulationDate(Date populationDate) {
        this.populationDate = populationDate;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Set<CityNameDTO> getCityNames() {
        return cityNames;
    }

    public void setCityNames(Set<CityNameDTO> cityNames) {
        this.cityNames = cityNames;
    }

    public Set<CityTagDTO> getCityTags() {
        return cityTags;
    }

    public void setCityTags(Set<CityTagDTO> cityTags) {
        this.cityTags = cityTags;
    }

    // Inner DTO classes for CityName and CityTag
    public static class CityNameDTO {
        private String language;
        private String name;

        // Getters and Setters
        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class CityTagDTO {
        private String tagKey;
        private String tagValue;

        // Getters and Setters
        public String getTagKey() {
            return tagKey;
        }

        public void setTagKey(String tagKey) {
            this.tagKey = tagKey;
        }

        public String getTagValue() {
            return tagValue;
        }

        public void setTagValue(String tagValue) {
            this.tagValue = tagValue;
        }
    }
}
