package com.example.dust.persondemo.bean;

public class Person {


        private String name;
        private String sex;
        private int height;
        private int weight;
        private int country;
        private int homeTown;



        private Person(String name, String sex, int height, int weight, int country, int homeTown) {
            this.name = name;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.country = country;
            this.homeTown = homeTown;
        }


        // 静态内部类
      public    static class Builder {
            private String name;
            private String sex;
            private int height;
            private int weight;
            private int country;
            private int homeTown;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder setSex(String sex) {
                this.sex = sex;
                return this;
            }

            public Builder setHeight(int height) {
                this.height = height;
                return this;
            }


            public Builder setWeight(int weight) {
                this.weight = weight;
                return this;
            }

            public Builder setCountry(int country) {
                this.country = country;
                return this;
            }

            public Builder setHomeTown(int homeTown) {
                this.homeTown = homeTown;
                return this;
            }

            public Person create() {
                return new Person(name, sex, height, weight, country, homeTown);
            }
        }

}
