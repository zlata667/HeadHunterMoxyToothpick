package com.example.headhunter.data.model;

import java.util.List;

public class Country{

    private List<Region> areas;

    public List<Region> getAreas(){
        return areas;
    }

    public void setAreas(List<Region> areas){
        this.areas = areas;
    }

    public static class Region{

        private String name;
        private String id;

        public String getId(){
            return id;
        }

        public void setId(String id){
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
