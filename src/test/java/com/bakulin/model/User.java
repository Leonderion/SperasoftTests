package com.bakulin.model;

public class User {
    private String firstname;
    private String lastname;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

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
