package com.example.movieappjson;

public class MovieModelClass {
    String name;
    String id;
    String img;
    String release_date;

        public MovieModelClass(String name, String id, String img, String release_date) {
            this.name = name;
            this.id = id;
            this.img = img;
            this.release_date =release_date;
        }
    public MovieModelClass() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
