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
        /**
         * salary : {"to":null,"from":30000,"currency":"RUR","gross":true}
         * name : Секретарь
         * insider_interview : {"id":"12345","url":"https://hh.ru/interview/12345?employerId=777"}
         * area : {"url":"https://api.hh.ru/areas/1","id":"1","name":"Москва"}
         * url : https://api.hh.ru/vacancies/8331228
         * published_at : 2013-07-08T16:17:21+0400
         * relations : []
         * employer : {"logo_urls":{"90":"https://hh.ru/employer-logo/289027.png","240":"https://hh.ru/employer-logo/289169.png","original":"https://hh.ru/file/2352807.png"},"name":"HeadHunter","url":"https://api.hh.ru/employers/1455","alternate_url":"https://hh.ru/employer/1455","id":"1455","trusted":true}
         * contacts : {"name":"Имя","email":"user@example.com","phones":[{"country":"7","city":"985","number":"000-00-00","comment":null}]}
         * response_letter_required : true
         * address : {"city":"Москва","street":"улица Годовикова","building":"9с10","description":"на проходной потребуется паспорт","lat":55.807794,"lng":37.638699,"metro_stations":[{"station_id":"6.8","station_name":"Алексеевская","line_id":"6","line_name":"Калужско-Рижская","lat":55.807794,"lng":37.638699}]}
         * sort_point_distance : 226.001293
         * alternate_url : https://hh.ru/vacancy/8331228
         * apply_alternate_url : https://hh.ru/applicant/vacancy_response?vacancyId=8331228
         * department : {"id":"HH-1455-TECH","name":"HeadHunter::Технический департамент"}
         * type : {"id":"open","name":"Открытая"}
         * id : 8331228
         * has_test : true
         * response_url : null
         * snippet : {"requirement":"Высшее образование. Опыт работы в качестве <highlighttext>секретаря<\/highlighttext>, офис-менеджера. Знание делопроизводства, документооборота. Коммуникативные навыки.","responsibility":"Документооборот (регистрация, отправка, контроль исполнения писем, ведение протоколов, отчетность). Распределение корреспонденции. Прием и распределение телефонных звонков."}
         */

        private SalaryBean salary;
        private String name;
        private InsiderInterviewBean insider_interview;
        private AreaBean area;
        private String url;
        private String published_at;
        private EmployerBean employer;
        private ContactsBean contacts;
        private boolean response_letter_required;
        private AddressBean address;
        private double sort_point_distance;
        private String alternate_url;
        private String apply_alternate_url;
        private DepartmentBean department;
        private TypeBean type;
        private String id;
        private boolean has_test;
        private Object response_url;
        private SnippetBean snippet;
        private List<?> relations;

        public SalaryBean getSalary(){
            return salary;
        }

        public void setSalary(SalaryBean salary){
            this.salary = salary;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public InsiderInterviewBean getInsider_interview(){
            return insider_interview;
        }

        public void setInsider_interview(InsiderInterviewBean insider_interview){
            this.insider_interview = insider_interview;
        }

        public AreaBean getArea(){
            return area;
        }

        public void setArea(AreaBean area){
            this.area = area;
        }

        public String getUrl(){
            return url;
        }

        public void setUrl(String url){
            this.url = url;
        }

        public String getPublished_at(){
            return published_at;
        }

        public void setPublished_at(String published_at){
            this.published_at = published_at;
        }

        public EmployerBean getEmployer(){
            return employer;
        }

        public void setEmployer(EmployerBean employer){
            this.employer = employer;
        }

        public ContactsBean getContacts(){
            return contacts;
        }

        public void setContacts(ContactsBean contacts){
            this.contacts = contacts;
        }

        public boolean isResponse_letter_required(){
            return response_letter_required;
        }

        public void setResponse_letter_required(boolean response_letter_required){
            this.response_letter_required = response_letter_required;
        }

        public AddressBean getAddress(){
            return address;
        }

        public void setAddress(AddressBean address){
            this.address = address;
        }

        public double getSort_point_distance(){
            return sort_point_distance;
        }

        public void setSort_point_distance(double sort_point_distance){
            this.sort_point_distance = sort_point_distance;
        }

        public String getAlternate_url(){
            return alternate_url;
        }

        public void setAlternate_url(String alternate_url){
            this.alternate_url = alternate_url;
        }

        public String getApply_alternate_url(){
            return apply_alternate_url;
        }

        public void setApply_alternate_url(String apply_alternate_url){
            this.apply_alternate_url = apply_alternate_url;
        }

        public DepartmentBean getDepartment(){
            return department;
        }

        public void setDepartment(DepartmentBean department){
            this.department = department;
        }

        public TypeBean getType(){
            return type;
        }

        public void setType(TypeBean type){
            this.type = type;
        }

        public String getId(){
            return id;
        }

        public void setId(String id){
            this.id = id;
        }

        public boolean isHas_test(){
            return has_test;
        }

        public void setHas_test(boolean has_test){
            this.has_test = has_test;
        }

        public Object getResponse_url(){
            return response_url;
        }

        public void setResponse_url(Object response_url){
            this.response_url = response_url;
        }

        public SnippetBean getSnippet(){
            return snippet;
        }

        public void setSnippet(SnippetBean snippet){
            this.snippet = snippet;
        }

        public List<?> getRelations(){
            return relations;
        }

        public void setRelations(List<?> relations){
            this.relations = relations;
        }

        public static class SalaryBean{
            /**
             * to : null
             * from : 30000
             * currency : RUR
             * gross : true
             */

            private Object to;
            private int from;
            private String currency;
            private boolean gross;

            public Object getTo(){
                return to;
            }

            public void setTo(Object to){
                this.to = to;
            }

            public int getFrom(){
                return from;
            }

            public void setFrom(int from){
                this.from = from;
            }

            public String getCurrency(){
                return currency;
            }

            public void setCurrency(String currency){
                this.currency = currency;
            }

            public boolean isGross(){
                return gross;
            }

            public void setGross(boolean gross){
                this.gross = gross;
            }
        }

        public static class InsiderInterviewBean{
            /**
             * id : 12345
             * url : https://hh.ru/interview/12345?employerId=777
             */

            private String id;
            private String url;

            public String getId(){
                return id;
            }

            public void setId(String id){
                this.id = id;
            }

            public String getUrl(){
                return url;
            }

            public void setUrl(String url){
                this.url = url;
            }
        }

        public static class AreaBean{
            /**
             * url : https://api.hh.ru/areas/1
             * id : 1
             * name : Москва
             */

            private String url;
            private String id;
            private String name;

            public String getUrl(){
                return url;
            }

            public void setUrl(String url){
                this.url = url;
            }

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

        public static class EmployerBean{
            /**
             * logo_urls : {"90":"https://hh.ru/employer-logo/289027.png","240":"https://hh.ru/employer-logo/289169.png","original":"https://hh.ru/file/2352807.png"}
             * name : HeadHunter
             * url : https://api.hh.ru/employers/1455
             * alternate_url : https://hh.ru/employer/1455
             * id : 1455
             * trusted : true
             */

            private LogoUrlsBean logo_urls;
            private String name;
            private String url;
            private String alternate_url;
            private String id;
            private boolean trusted;

            public LogoUrlsBean getLogo_urls(){
                return logo_urls;
            }

            public void setLogo_urls(LogoUrlsBean logo_urls){
                this.logo_urls = logo_urls;
            }

            public String getName(){
                return name;
            }

            public void setName(String name){
                this.name = name;
            }

            public String getUrl(){
                return url;
            }

            public void setUrl(String url){
                this.url = url;
            }

            public String getAlternate_url(){
                return alternate_url;
            }

            public void setAlternate_url(String alternate_url){
                this.alternate_url = alternate_url;
            }

            public String getId(){
                return id;
            }

            public void setId(String id){
                this.id = id;
            }

            public boolean isTrusted(){
                return trusted;
            }

            public void setTrusted(boolean trusted){
                this.trusted = trusted;
            }

            public static class LogoUrlsBean{
                /**
                 * 90 : https://hh.ru/employer-logo/289027.png
                 * 240 : https://hh.ru/employer-logo/289169.png
                 * original : https://hh.ru/file/2352807.png
                 */

                @SerializedName("90")
                private String _$90;
                @SerializedName("240")
                private String _$240;
                private String original;

                public String get_$90(){
                    return _$90;
                }

                public void set_$90(String _$90){
                    this._$90 = _$90;
                }

                public String get_$240(){
                    return _$240;
                }

                public void set_$240(String _$240){
                    this._$240 = _$240;
                }

                public String getOriginal(){
                    return original;
                }

                public void setOriginal(String original){
                    this.original = original;
                }
            }
        }

        public static class ContactsBean{
            /**
             * name : Имя
             * email : user@example.com
             * phones : [{"country":"7","city":"985","number":"000-00-00","comment":null}]
             */

            private String name;
            private String email;
            private List<PhonesBean> phones;

            public String getName(){
                return name;
            }

            public void setName(String name){
                this.name = name;
            }

            public String getEmail(){
                return email;
            }

            public void setEmail(String email){
                this.email = email;
            }

            public List<PhonesBean> getPhones(){
                return phones;
            }

            public void setPhones(List<PhonesBean> phones){
                this.phones = phones;
            }

            public static class PhonesBean{
                /**
                 * country : 7
                 * city : 985
                 * number : 000-00-00
                 * comment : null
                 */

                private String country;
                private String city;
                private String number;
                private Object comment;

                public String getCountry(){
                    return country;
                }

                public void setCountry(String country){
                    this.country = country;
                }

                public String getCity(){
                    return city;
                }

                public void setCity(String city){
                    this.city = city;
                }

                public String getNumber(){
                    return number;
                }

                public void setNumber(String number){
                    this.number = number;
                }

                public Object getComment(){
                    return comment;
                }

                public void setComment(Object comment){
                    this.comment = comment;
                }
            }
        }

        public static class AddressBean{
            /**
             * city : Москва
             * street : улица Годовикова
             * building : 9с10
             * description : на проходной потребуется паспорт
             * lat : 55.807794
             * lng : 37.638699
             * metro_stations : [{"station_id":"6.8","station_name":"Алексеевская","line_id":"6","line_name":"Калужско-Рижская","lat":55.807794,"lng":37.638699}]
             */

            private String city;
            private String street;
            private String building;
            private String description;
            private double lat;
            private double lng;
            private List<MetroStationsBean> metro_stations;

            public String getCity(){
                return city;
            }

            public void setCity(String city){
                this.city = city;
            }

            public String getStreet(){
                return street;
            }

            public void setStreet(String street){
                this.street = street;
            }

            public String getBuilding(){
                return building;
            }

            public void setBuilding(String building){
                this.building = building;
            }

            public String getDescription(){
                return description;
            }

            public void setDescription(String description){
                this.description = description;
            }

            public double getLat(){
                return lat;
            }

            public void setLat(double lat){
                this.lat = lat;
            }

            public double getLng(){
                return lng;
            }

            public void setLng(double lng){
                this.lng = lng;
            }

            public List<MetroStationsBean> getMetro_stations(){
                return metro_stations;
            }

            public void setMetro_stations(List<MetroStationsBean> metro_stations){
                this.metro_stations = metro_stations;
            }

            public static class MetroStationsBean{
                /**
                 * station_id : 6.8
                 * station_name : Алексеевская
                 * line_id : 6
                 * line_name : Калужско-Рижская
                 * lat : 55.807794
                 * lng : 37.638699
                 */

                private String station_id;
                private String station_name;
                private String line_id;
                private String line_name;
                private double lat;
                private double lng;

                public String getStation_id(){
                    return station_id;
                }

                public void setStation_id(String station_id){
                    this.station_id = station_id;
                }

                public String getStation_name(){
                    return station_name;
                }

                public void setStation_name(String station_name){
                    this.station_name = station_name;
                }

                public String getLine_id(){
                    return line_id;
                }

                public void setLine_id(String line_id){
                    this.line_id = line_id;
                }

                public String getLine_name(){
                    return line_name;
                }

                public void setLine_name(String line_name){
                    this.line_name = line_name;
                }

                public double getLat(){
                    return lat;
                }

                public void setLat(double lat){
                    this.lat = lat;
                }

                public double getLng(){
                    return lng;
                }

                public void setLng(double lng){
                    this.lng = lng;
                }
            }
        }

        public static class DepartmentBean{
            /**
             * id : HH-1455-TECH
             * name : HeadHunter::Технический департамент
             */

            private String id;
            private String name;

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

        public static class TypeBean{
            /**
             * id : open
             * name : Открытая
             */

            private String id;
            private String name;

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

        public static class SnippetBean{
            /**
             * requirement : Высшее образование. Опыт работы в качестве <highlighttext>секретаря</highlighttext>, офис-менеджера. Знание делопроизводства, документооборота. Коммуникативные навыки.
             * responsibility : Документооборот (регистрация, отправка, контроль исполнения писем, ведение протоколов, отчетность). Распределение корреспонденции. Прием и распределение телефонных звонков.
             */

            private String requirement;
            private String responsibility;

            public String getRequirement(){
                return requirement;
            }

            public void setRequirement(String requirement){
                this.requirement = requirement;
            }

            public String getResponsibility(){
                return responsibility;
            }

            public void setResponsibility(String responsibility){
                this.responsibility = responsibility;
            }
        }
    }
}