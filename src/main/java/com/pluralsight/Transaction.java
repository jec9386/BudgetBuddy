
    package com.pluralsight;

    import java.time.LocalDate;
    import java.time.LocalTime;

    public class Transaction {
        private LocalDate date;
        private LocalTime time;
        private String description;
        private String vendor;
        private double amount;

        public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
            this.date = date;
            this.time = time;
            this.description = description;
            this.vendor = vendor;
            this.amount = amount;
        }
        //-------------------------------------------------------------------------------------------------------------------------------------
        //GETTER AND SETTER
        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public LocalTime getTime() {
            return time;
        }

        public void setTime(LocalTime time) {
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

