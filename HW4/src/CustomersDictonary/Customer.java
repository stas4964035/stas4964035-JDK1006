package CustomersDictonary;

public record Customer(int id, String phone, String name, int experience) {

    public Customer getCustomerByExperience(int experience) {
        if (experience == this.experience) {
            return this;
        }
        return null;
    }

    public String getPhoneByName(String name) {
        if (name.equals(this.name)) {
            return phone;
        }
        return null;
    }

    public Customer getCustomerById(int id) {
        if (id == this.id) {
            return this;
        }
        return null;
    }




}
