package seriesapp;

public class Series {
    private final String seriesId;
    private String seriesName;
    private int ageRestriction;
    private int numberOfEpisodes;

    public Series(String id, String name, int age, int episodes) {
        this.seriesId = id;
        this.seriesName = name;
        this.ageRestriction = age;
        this.numberOfEpisodes = episodes;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public String toString() {
        return "Series ID: " + seriesId +
               "\nSeries Name: " + seriesName +
               "\nAge Restriction: " + ageRestriction +
               "\nNumber of Episodes: " + numberOfEpisodes;
    }
}


