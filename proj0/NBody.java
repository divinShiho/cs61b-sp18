import javax.sound.midi.*;
import java.io.File;

public class NBody {

    public static void main(String[] args) {

        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        int num = planets.length;
        while(t <= T) {
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for(int i = 0; i < num; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < num; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // draw the backgroud picture
            StdDraw.picture(0, 0, "images/starfield.jpg");

            // draw all the planets
            for (Planet p : planets) {
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int n = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[n];
        int i;
        for (i = 0; i < n; ++i) {
            Planet planet = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readString());
            planets[i] = planet;
        }
        return planets;
    }
}
