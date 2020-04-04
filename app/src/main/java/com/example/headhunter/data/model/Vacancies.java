package com.example.headhunter.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Vacancies{

    private List<ItemsBean> items;

    public List<ItemsBean> getItems(){
        return items;
    }

    public void setItems(List<ItemsBean> items){
        this.items = items;
    }

    public static class ItemsBean{

        private String name;
        private AreaBean area;
        private String id;
        private SnippetBean snippet;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public AreaBean getArea(){
            return area;
        }

        public void setArea(AreaBean area){
            this.area = area;
        }

        public String getId(){
            return id;
        }

        public void setId(String id){
            this.id = id;
        }

        public SnippetBean getSnippet(){
            return snippet;
        }

        public void setSnippet(SnippetBean snippet){
            this.snippet = snippet;
        }

        public static class AreaBean{

            private String name;

            public String getName(){
                return name;
            }

            public void setName(String name){
                this.name = name;
            }
        }

        public static class SnippetBean{

            private String responsibility;

            public String getResponsibility(){
                return responsibility;
            }

            public void setResponsibility(String responsibility){
                this.responsibility = responsibility;
            }
        }
    }
}