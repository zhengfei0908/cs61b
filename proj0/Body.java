public class Body {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    static final double G = 6.67e-11;

    /**
     * The first constructor
     */
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /** 
     * The second constructor
     */
    public Body (Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    /**
     * Calculate the distance between two bodies
     */
    public double calcDistance(Body b) {
        return Math.sqrt((this.xxPos - b.xxPos) * (this.xxPos - b.xxPos) + (this.yyPos - b.yyPos) * (this.yyPos - b.yyPos));
    }

    /**
     * Calculate the force
     */
    public double calcForceExertedBy(Body b) {
        double r = calcDistance(b);
        return G * mass * b.mass / (r * r);
    }

    /**
     * Calculate the force by X
     */
    public double calcForceExertedByX(Body b) {
        double r = calcDistance(b);
        double f = calcForceExertedBy(b);
        return f * (b.xxPos - this.xxPos) / r;
    }

    /**
     * Calculate the force by Y
     */
    public double calcForceExertedByY(Body b) {
        double r = calcDistance(b);
        double f = calcForceExertedBy(b);
        return f * (b.yyPos - this.yyPos) / r;
    }

    /**
     * Calculate the net force by X
     */
    public double calcNetForceExertedByX(Body[] barrays) {
        double netf = 0;
        for (Body b: barrays) {
            if (this.equals(b)) {
                continue;
            } else {
                netf += calcForceExertedByX(b);
            }
        }
        return netf;
    }

    /**
     * Calculate the net force by X
     */
    public double calcNetForceExertedByY(Body[] barrays) {
        double netf = 0;
        for (Body b: barrays) {
            if (this.equals(b)) {
                continue;
            } else {
                netf += calcForceExertedByY(b);
            }
        }
        return netf;
    }
    
    /**
     * Update the position
     */
    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    /**
     * Draw the body
     */
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
    }
}