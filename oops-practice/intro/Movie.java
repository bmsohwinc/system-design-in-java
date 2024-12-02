class Movie {
    private String title;
    private int year;
    private String genre;
    
    public Movie () {
        title = "";
        year = -1;
        genre = "";
    }
    
    public Movie (String title, int year, String genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }
    
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}