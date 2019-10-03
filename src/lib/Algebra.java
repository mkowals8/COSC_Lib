package lib;

/**
 * Algebra
 */
public class Algebra {

    public static double findDeterminate(double _a, double _b, double _c) {
        return Math.pow(_b, 2) - 4 * _a * _c;
    }

    public static double[] solveQuadratic(double _a, double _b, double _c) {
        double[] solution = new double[2];
        double determinate = findDeterminate(_a, _b, _c);
        solution[0] = (-_b + Math.sqrt(determinate)) / (2 * _a);
        solution[1] = (-_b - Math.sqrt(determinate)) / (2 * _a);
        return solution;
    }

    public static double[] solveLinearEq2x2(double[] _eq1, double[] _eq2) {
        double[] solution  = new double[2];
        solution[0] = (_eq1[2] * _eq2[1] - _eq1[1] * _eq2[2]) / (_eq1[0] * _eq2[1] - _eq1[1] * _eq2[0]);
        solution[1] = (_eq1[0] * _eq2[2] - _eq1[2] * _eq2[0]) / (_eq1[0] * _eq2[1] - _eq1[1] * _eq2[0]);
        return solution;
    }
}