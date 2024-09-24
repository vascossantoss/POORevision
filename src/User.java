

/**
 * The `User` class represents a user with personal details such as name, age, height, and weight.
 * It also tracks the number of `User` instances created.
 */
public class User {

    private String name;
    private int age;
    private float height;
    private float weight;

    // Static final default values
    static final String DEFAULT_NAME = "Without Name";
    static final int DEFAULT_AGE = 0;
    static final float DEFAULT_HEIGHT = 1.8f;
    static final float DEFAULT_WEIGHT = 65.0f;
    static final int MIN_IMC = 18;
    static final int MAX_IMC = 25;

    static int instanceCount = 0;

    /**
     * Default constructor that initializes the user with default values.
     */
    public User() {
        this.name = DEFAULT_NAME;
        this.age = DEFAULT_AGE;
        this.height = DEFAULT_HEIGHT;
        this.weight = DEFAULT_WEIGHT;
        instanceCount++;
    }

    /**
     * Constructor that initializes the user with the specified name and age.
     * 
     * @param name the name of the user
     * @param age the age of the user
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.height = DEFAULT_HEIGHT;
        this.weight = DEFAULT_WEIGHT;
        instanceCount++;
    }

    /**
     * Constructor that initializes the user with the specified name, age, height, and weight.
     * 
     * @param name the name of the user
     * @param age the age of the user
     * @param height the height of the user in meters
     * @param weight the weight of the user in kilograms
     */
    public User(String name, int age, float height, float weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        instanceCount++;
    }

    /**
     * Gets the name of the user.
     * 
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * 
     * @param name the new name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the user.
     * 
     * @return the age of the user
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the user.
     * 
     * @param age the new age of the user
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the height of the user.
     * 
     * @return the height of the user in meters
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the height of the user.
     * 
     * @param height the new height of the user in meters
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Gets the weight of the user.
     * 
     * @return the weight of the user in kilograms
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the user.
     * 
     * @param weight the new weight of the user in kilograms
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Returns a string representation of the user with details including name, age, height, and weight.
     * 
     * @return a string containing user details
     */
    @Override
    public String toString() {
        return "[Name: " + name + "] [Age: " + age + "] [Height: " + height + "] [Weight: " + weight + "]";
    }

    /**
     * Calculates the absolute difference in age between this user and another user.
     * 
     * @param otherUser the other user to compare with
     * @return the absolute difference in age
     * @throws IllegalArgumentException if the other user is null
     */
    public int ageDifference(User otherUser) {
        if (otherUser == null) {
            throw new IllegalArgumentException("The other user cannot be null");
        }
        return Math.abs(this.age - otherUser.getAge());
    }

    /**
     * Calculates the IMC (Body Mass Index) of the user.
     * 
     * @return the IMC value
     * @throws IllegalArgumentException if the height is zero
     */
    public float calculateBMI() {
        if (this.height == 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        return this.weight / (this.height * this.height);
    }

    /**
     * Determines the obesity level of the user based on the IMC value.
     * 
     * @return a string indicating the obesity level ("Skinny", "Healthy", or "Fat")
     */
    public String determineObesityLevel() {
        float imc = calculateBMI();
        if (imc < MIN_IMC) {
            return "Skinny";
        } else if (imc > MAX_IMC) {
            return "Fat";
        } else {
            return "Healthy";
        }
    }

    /**
     * Determines if the user is healthy based on the IMC value.
     * 
     * @return true if the IMC is within the healthy range, false otherwise
     */
    public boolean isHealthy() {
        float imc = calculateBMI();
        return (imc >= MIN_IMC && imc <= MAX_IMC);
    }

    /**
     * Compares the age of this user with another user and checks who is younger.
     * 
     * @param otherUser the other user to compare with
     * @return 1 : user is younger than otherUser | 0 : otherUser is younger than otherUser | -1 : users are the same age
     * @throws IllegalArgumentException if the other user is null
     */
    public int checkYounger(User otherUser) {
        if (otherUser == null) {
            throw new IllegalArgumentException("The other user cannot be null");
        }

        if (this.age > otherUser.getAge()) {
            return 0;
        } else if (this.age < otherUser.getAge()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Gets the total number of `User` instances created.
     * 
     * @return the number of `User` instances created
     */
    public static int getInstanceCount() {
        return instanceCount;
    }
}
