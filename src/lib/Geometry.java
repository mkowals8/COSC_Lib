package lib;

/**
 * Geometry
 */
public class Geometry {

    private static double sideLength(double[] _point1, double[] _point2) {
        return Math.sqrt(Math.pow((_point2[0] - _point1[0]),2) + Math.pow((_point2[1] - _point1[1]), 2));
    }

    public static double distanceBetween(double[] _point1, double[] _point2) {
        return sideLength(_point1, _point2);
    }

    public static int pointPosition(double[] _point1, double[] _point2, double[] _point3) {
        double result = (_point2[0] - _point1[0]) * (_point3[1] - _point1[1]) - (_point3[0] - _point1[0]) * (_point2[1] - _point1[1]);
        if (result > 0) {
            return -1;
        } else if (result < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean pointOnLine(double[] _point1, double[] _point2, double[] _point3) {
        return distanceBetween(_point1, _point3) + distanceBetween(_point2, _point3) <= distanceBetween(_point1, _point2) && pointPosition(_point1, _point2, _point3) == 0;
    }

    public static double[] intersection(double[] _line1Point1, double[] _line1Point2, double[] _line2Point1, double[] _line2Point2) {
        double result1 = _line1Point1[0] * (_line1Point1[1] - _line1Point2[1]) - _line1Point1[1] * (_line1Point1[0] - _line1Point2[0]);
        double result2 = _line2Point1[0] * (_line2Point1[1] - _line2Point2[1]) - _line2Point1[1] * (_line2Point1[0] - _line2Point2[0]);
        double[] eq1 = {(_line1Point1[1] - _line1Point2[1]), (_line1Point1[0] - _line1Point2[0]), result1};
        double[] eq2 = {(_line2Point1[1] - _line2Point2[1]), (_line2Point1[0] - _line2Point2[0]), result2};
        
        return Algebra.solveLinearEq2x2(eq1, eq2);
    }

    public static double perimeterOfTriangle(double[] _point1, double[] _point2, double[] _point3) {
        return sideLength(_point1, _point2) + sideLength(_point1, _point3) + sideLength(_point3, _point2);
    }

    public static double areaOfTriangle(double[] _point1, double[] _point2, double[] _point3) {
        double side_1 = sideLength(_point1, _point2);
        double side_2 = sideLength(_point1, _point3);
        double side_3 = sideLength(_point2, _point3);
        double s = (side_1 + side_2 + side_3) / 2;
        return Math.sqrt(s * (s - side_1) * (s - side_2) * (s - side_3));
    }

    public static boolean pointInTriangle(double[] _triV1, double[] _triV2, double[] _triV3, double[] _point) {
        double denominator = ((_triV2[1] - _triV3[1]) * (_triV1[0] - _triV3[0]) + (_triV3[0] - _triV2[0]) * (_triV1[1] - _triV3[1]));
        double a = ((_triV2[1] - _triV3[1]) * (_point[0] - _triV3[0]) + (_triV3[0] - _triV2[0]) * (_point[1] - _triV3[1])) / denominator;
        double b = ((_triV3[1] - _triV1[1]) * (_point[0] - _triV3[0]) + (_triV1[0] - _triV3[0]) * (_point[1] - _triV3[1])) / denominator;
        double c = 1 - a - b;
        return 0 <= a && a <= 1 && 0 <= b && b <= 1 && 0 <= c && c <= 1;
    }

    public static double[] findAnglesTriangle(double _a, double _b, double _c) {
        double[] angles = new double[3];
        angles[0] = Math.acos(_c * _c - _a * _a - _b * _b) / (-2 * _a * _b);
        angles[1] = Math.acos(_a * _a - _b * _b - _c * _c) / (-2 * _b * _c);
        angles[2] = Math.acos(_b * _b - _a * _a - _c * _c) / (-2 * _a * _c);
        return angles;
    }

    public static double perimeterOfCircle(double _radius) {
        return 2 * _radius * Math.PI;
    }

    public static double areaOfCircle(double _radius) {
        return Math.pow(_radius, 2) * Math.PI;
    }

    public static boolean pointInCircle(double[] _point, double[] _center, double _radius) {
        if (distanceBetween(_point, _center) <= _radius) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean circleInCircle(double[] _center1, double _radius1, double[] _center2, double _radius2) {
        if (distanceBetween(_center1, _center2) <= _radius1 - _radius2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean circleOverlap(double[] _center1, double _radius1, double[] _center2, double _radius2) {
        if (distanceBetween(_center1, _center2) <= _radius1 + _radius2) {
            return true;
        } else {
            return false;
        }
    }

    public static double perimeterOfRectangle(double[] _point1, double[] _point2, double[] _point3, double[] _point4) {
        return sideLength(_point1, _point2) + sideLength(_point2, _point3) + sideLength(_point3, _point4) + sideLength(_point4, _point1);
    }

    public static double perimeterOfRectangle(double _side1, double _side2) {
        return (2 * _side1) + (2 * _side2);
    }

    public static double areaOfRectangle(double[] _point1, double[] _point2, double[] _point3, double[] _point4) {
        return sideLength(_point1, _point2) * sideLength(_point2, _point3);
    }

    public static double areaOfRectangle(double _side1, double _side2) {
        return _side1 * _side2;
    }

    public static boolean pointInRectangle(double[] _point, double[] _rectCenter, double _height, double _width) {
        if (Math.abs(_point[0] - _rectCenter[0]) <= _width / 2 
            && Math.abs(_point[1] - _rectCenter[1]) <= _height / 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean rectInRect(double[] _rect1Center, double _rect1Height, double _rect1Width, double[] _rect2Center, double _rect2Height, double _rect2Width) {
        if (Math.abs(_rect1Center[0] - _rect2Center[0]) <= Math.abs((_rect1Width - _rect2Width) / 2) 
            && Math.abs(_rect1Center[1] - _rect2Center[1]) <= Math.abs((_rect1Height - _rect2Height) / 2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean rectOverlap(double[] _rect1Center, double _rect1Height, double _rect1Width, double[] _rect2Center, double _rect2Height, double _rect2Width) {
        if (Math.abs(_rect1Center[0] - _rect2Center[0]) <= (_rect1Width + _rect2Width) / 2 
            && Math.abs(_rect1Center[1] - _rect2Center[1]) <= (_rect1Height +  _rect2Height) / 2) {
            return true;
        } else {
            return false;
        }
    }

    public static double areaOfHexagon(double _sideLength) {
        return ((3 * Math.sqrt(3)) / 2) * Math.pow(_sideLength, 2) ;
    }

    public static double volumeOfCylinder(double _radius, double _height) {
        return areaOfCircle(_radius) * _height;
    }
}