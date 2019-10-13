package com.bakulin.model;

public class User {

    private String firstname;
    private String lastname;
    private String gender;
    private String dayOfBirth;
    private String mouthOfBirth;
    private String yearOfBirth;
    private String state;
    private String country;
    private String email;
    private String password;
    private String company;
    private String address;
    private String addresstwo;
    private String city;
    private String postcode;
    private String additional;
    private String phonehome;
    private String phonemobile;
    private String alias;

    public static Builder newEntity() {
        return new User().new Builder();
    }

    public String getFirstname() { return firstname; }

    public String getLastname() { return lastname; }

    public String getGender() { return gender; }

    public String getDayOfBirth() { return dayOfBirth; }

    public String getMouthOfBirth() { return mouthOfBirth; }

    public String getYearOfBirth() { return yearOfBirth; }

    public String getState() { return state; }

    public String getCountry() { return country; }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password; }

    public String getCompany() { return company; }

    public String getAddress() {
        return address;
    }

    public String getAddresstwo() {
        return addresstwo;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getAdditional() {
        return additional;
    }

    public String getPhonehome() {
        return phonehome;
    }

    public String getPhonemobile() {
        return phonemobile;
    }

    public String getAlias() {
        return alias;
    }

    public class Builder {
        private Builder() {}
        public Builder withFirstname(String firstname) { User.this.firstname = firstname; return this; }
        public Builder withLastname(String lastname) { User.this.lastname = lastname; return this; }
        public Builder withGender(String gender) { User.this.gender = gender; return this; }
        public Builder withDayOfBirth(String dayOfBirth) { User.this.dayOfBirth = dayOfBirth; return this; }
        public Builder withMouthOfBirth(String mouthOfBirth) { User.this.mouthOfBirth = mouthOfBirth; return this; }
        public Builder withYearOfBirth(String yearOfBirth) { User.this.yearOfBirth = yearOfBirth; return this; }
        public Builder withCountry(String country) { User.this.country = country; return this; }
        public Builder withState(String state) { User.this.state = state; return this; }
        public Builder withEmail(String email) { User.this.email = email; return this; }
        public Builder withPassword(String password) { User.this.password = password; return this; }
        public Builder withCompany(String company) { User.this.company = company; return this; }
        public Builder withAddress(String address) { User.this.address = address; return this; }
        public Builder withAddresstwo(String addresstwo) { User.this.addresstwo = addresstwo; return this; }
        public Builder withCity(String city) { User.this.city = city; return this; }
        public Builder withPostcode(String postcode) { User.this.postcode = postcode; return this; }
        public Builder withAdditional(String additional) { User.this.additional = additional; return this; }
        public Builder withPhonehome(String phonehome) { User.this.phonehome = phonehome; return this; }
        public Builder withPhonemobile(String phonemobile) { User.this.phonemobile = phonemobile; return this; }
        public Builder withAlias(String alias) { User.this.alias = alias; return this; }

        public User build() { return User.this; }
    }
}
