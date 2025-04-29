
    package com.pluralsight;

    public class Transactions {
        private String date;
        private String time;
        private String description;
        private String vendor;
        private double amount;

        public Transactions(String date, String time, String description, String vendor, double amount) {
            this.date = date;
            this.time = time;
            this.description = description;
            this.vendor = vendor;
            this.amount = amount;
        }
        //-------------------------------------------------------------------------------------------------------------------------------------
        //GETTER AND SETTER
        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }
    //----------------------------------------------------------------------------------------------------------

        //Way I want my class to structure its instances using a method to return a string so that I can put it into transactions.csv
        public String toCSV() {
            return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
        }
    }

