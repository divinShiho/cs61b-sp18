public class Planet {

    public static final double G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                    double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(this.xxPos-p.xxPos, 2) + Math.pow(this.yyPos-p.yyPos, 2));
    }

    public double calcForceExertedBy(Planet p) {
        return G * this.mass * p.mass / Math.pow(calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos-xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return  calcForceExertedBy(p) * (p.yyPos-yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double Fx = 0.0;
        for (Planet p : planets) {
            if (!p.equals(this))
                Fx += calcForceExertedByX(p);
        }
        return Fx;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double Fy = 0.0;
        for (Planet p : planets) {
            if (!p.equals(this))
                Fy += calcForceExertedByY(p);
        }
        return Fy;
    }

    public void update(double dt, double Fx, double Fy) {
        double ax = Fx / mass;
        double ay = Fy / mass;

        xxVel += dt * ax;
        yyVel += dt * ay;

        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
