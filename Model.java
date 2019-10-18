package lab1;

/**
 *
 * @author Elen
 */

// Friend Douglas helped me;

public class Model {

    private String firstName;
    private String lastName;
    private int height;
    private double weight;
    private boolean canTravel;
    private boolean smokes;

    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;
    public long weightKg;
    public String feetAndInches;
    public int inches;
    public int feet;
    public long kilograms;
    public double pounds;



    /**
     * @param f
     * @param l
     * @param h
     * @param w
     * @param t
     * @param s
     */
    public Model(String f, String l, int h, double w, boolean t, boolean s) {
        setFirstName(f);
        setLastName(l);
        setHeight(h);
        setWeight(w);
        this.canTravel = t;
        this.smokes = s;
    }

    /**
     * @param f
     * @param l
     * @param h
     * @param w
     */
    public Model(String f, String l, int h, double w) {
        setFirstName(f);
        setLastName(l);
        setHeight(h);
        setWeight(w);
        this.canTravel = true;
        this.smokes = false;
    }

    /**
     *
     */
    public Model() {

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String f) {
        if (f.length() >= 3 && f.length() < 20) {
            this.firstName = f;
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String l) {
        if (l.length() >= 3 && l.length() < 20) {
            this.lastName = l;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int h) {
        if (height >= 24 && height < 84) {
            this.height = h;
        }
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double w) {
        if (weight >= 80 && weight > 280) {
            this.weight = w;
        }
    }

    public boolean getCanTravel() {
        return this.canTravel;
    }

    public void setCanTravel(boolean t) {
        this.canTravel = t;
    }

    public boolean getSmokes() {
        return this.smokes;
    }

    public void setSmokes(boolean s) {
        this.smokes = s;
    }

    public void printDetails() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Height: " + this.getHeight() + "inches");
        System.out.println("Weight: " + this.getWeight() + "pounds");
        if (canTravel == true) {
            System.out.println("Does travel");
        } else {
            System.out.println("Does not travel");
        }
        if (smokes == true) {
            System.out.println("Does smoke");
        } else {
            System.out.println("Does not smoke");
        }
    }

    public String getHeightInFeetAndInches() {
        int feet = Math.round(getHeight()) / INCHES_PER_FOOT;
        int inches = Math.round(getHeight()) % INCHES_PER_FOOT;
        return this.feetAndInches;
    }

    public long getWeightKg() {
        double weightKg = Math.round(getWeight()) / POUNDS_PER_KG;
        return this.weightKg;
    }

    public void setWeight(long kilograms) {
        this.weightKg = kilograms;
    }

    public void setWeightPo(double pounds) {
        this.weight = pounds;
    }

    public void setHeightFeedInc(int feet, int inches) {
        this.feetAndInches = feet + "." + inches;
    }

    public void setHeightInc(int inches) {
        this.height = inches;
    }
    public int calculatePayDollarsPerHour() {
        int dollars = BASE_RATE_DOLLARS_PER_HOUR;
        if (getHeight() > TALL_INCHES) {
            dollars += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (getWeight() < THIN_POUNDS) {
            dollars += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (canTravel) {
            dollars += TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        if (smokes) {
            dollars -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }
        return dollars;
    }
}
