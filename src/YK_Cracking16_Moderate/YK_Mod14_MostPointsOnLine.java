package YK_Cracking16_Moderate;

import YK_Common.YK_DoublePoint;
import YK_Common.YK_Line;

import java.util.HashMap;
import java.util.Map;

/*
Source: Cracking 16.14
Given a list of points, find a line with most points on it

In the book a similar execution, only also taking into consideration Invalid slope and very close slopes

Could be better tested
 */

public class YK_Mod14_MostPointsOnLine {
    private class PointsOnLine {
        YK_DoublePoint firstPoint;
        int numPoints;

        PointsOnLine(YK_DoublePoint firstPoint, int numPoints) {
            this.firstPoint = firstPoint;
            this.numPoints = numPoints;
        }

        @Override
        public String toString() {
            return "firstPoint: " + firstPoint + ", numPoints: " + numPoints;
        }
    }

    public YK_Line getLineMostPoints(YK_DoublePoint[] points) {

        YK_Line line = null;
        PointsOnLine pointsOnLine;

        HashMap<YK_Line, PointsOnLine> hashMap = new HashMap<>();

        //till - 1 from length, since need pairs
        for(int i = 0; i < (points.length - 1); i++) {
            for(int j = i + 1; j < points.length; j++) {
                line = new YK_Line(points[i], points[j]);
                System.out.println("Pair i: " + i + ", point: " + points[i] + ", j: " + j + ", point: " + points[j] + ", Line: " + line);
                if(hashMap.containsKey(line)) {
                    pointsOnLine = hashMap.get(line);

                    if (pointsOnLine.firstPoint.equals(points[i])) {
                        pointsOnLine.numPoints++;
                    }
                } else {
                    hashMap.put(line, new PointsOnLine(points[i], 2));
                }
            }
        }

        System.out.println("Hashmap size: " + hashMap.size() + ", map: " + hashMap);

        int maxNumPoints = 0;

        for(Map.Entry ent : hashMap.entrySet()) {
            if(((PointsOnLine)ent.getValue()).numPoints > maxNumPoints) {
                line = (YK_Line) ent.getKey();
                maxNumPoints = ((PointsOnLine)ent.getValue()).numPoints;
            }
        }

        return line;
    }
}
