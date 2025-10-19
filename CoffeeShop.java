public class CoffeeShop {
    public static void main(String[] args) {

        // 1. Create 3 Customers

        Customer c1 = new Customer("Joseph", 200);   // has 200 points
        Customer c2 = new Customer("Peter");          // new customer (0 points)
        Customer c3 = new Customer();                 // no name (Anonymous)

        System.out.println("\n--- [1] Initial Customer Info ---");
        c1.displayCustomerInfo();
        c2.displayCustomerInfo();
        c3.displayCustomerInfo();
        Customer.displayTotalCustomers();

        // 2. Peter's Transactions

        System.out.println("\n--- [2] Peter's Transactions ---");
        c2.addPoints(200); // pastries and beverages
        c2.addPoints(20);  // water purchase

        // 3. Redeem Rewards

        System.out.println("\n--- [3] Rewards Redemption ---");
        c1.redeemReward(); // Joseph
        c2.redeemReward(); // Peter
        c3.redeemReward(); // Anonymous

        // 4. Display Info & Total Customers

        System.out.println("\n--- [4] Updated Customer Info ---");
        c1.displayCustomerInfo();
        c2.displayCustomerInfo();
        c3.displayCustomerInfo();
        Customer.displayTotalCustomers();

        // 5. Add 4th Customer (Diane)

        System.out.println("\n--- [5] New Customer Added ---");
        Customer c4 = new Customer("Diane");
        c4.addPoints(50); // Diane earned 50 points
        c4.displayCustomerInfo();
        Customer.displayTotalCustomers();

        // 6. Static Method: Allowed Rewards Redemption

        System.out.println("\n--- [6] Allowed Rewards Redemption ---");
        Customer.getAllowedRewardsRedemption(c1);
        Customer.getAllowedRewardsRedemption(c2);
        Customer.getAllowedRewardsRedemption(c3);
        Customer.getAllowedRewardsRedemption(c4);
    }
}

// Customer Class Implementation

class Customer {
    // Instance variables
    String name;
    int points;

    // Static variable shared among all customers
    static int totalCustomers = 0;

    // Default constructor
    public Customer() {
        this.name = "Anonymous";
        this.points = 0;
        totalCustomers++;
    }

    // Parameterized constructor (name only)
    public Customer(String name) {
        this.name = name;
        this.points = 0;
        totalCustomers++;
    }

    // Parameterized constructor (name and points)
    public Customer(String name, int points) {
        this.name = name;
        this.points = points;
        totalCustomers++;
    }

    // Add points to the customer
    public void addPoints(int amount) {
        this.points += amount;
        System.out.println(this.name + " earned " + amount + " points. Total: " + this.points);
    }

    // Redeem reward if points >= 100
    public void redeemReward() {
        if (this.points >= 100) {
            int rewards = this.points / 100; // number of rewards
            this.points %= 100; // remove redeemed points
            System.out.println(this.name + " redeemed " + rewards + " free drink(s)!");
        } else {
            System.out.println(this.name + " has insufficient points to redeem a reward.");
        }
    }

    // Display customer information
    public void displayCustomerInfo() {
        System.out.println("Name: " + this.name + " | Points: " + this.points);
    }

    // Static method to display total customers
    public static void displayTotalCustomers() {
        System.out.println("Total Registered Customers: " + totalCustomers);
    }

    // Static method to show how many times a customer can redeem rewards
    public static void getAllowedRewardsRedemption(Customer c) {
        int rewards = c.points / 100;
        System.out.println(c.name + " can redeem " + rewards + " free drink(s).");
    }
}
