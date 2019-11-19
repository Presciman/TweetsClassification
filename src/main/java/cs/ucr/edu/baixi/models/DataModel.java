package cs.ucr.edu.baixi.models;

public class DataModel {

    /*private String lang; //language
        //User
        private Boolean has_extended_profile;
        private long statuses_count;
        private String profile_sidebar_fill_color;*/
    //going to use
    private String category;
    private String username;
    private String fulltext;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

}
