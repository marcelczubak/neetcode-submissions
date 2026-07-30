class CountSquares {

    // <point, frequency>
    Map<String, Integer> points;

    public CountSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        String pointString = String.valueOf(point[0]) + ',' + String.valueOf(point[1]);
        points.put(pointString, points.getOrDefault(pointString, 0)+1);
    }
    
    public int count(int[] point) {  
        int squares = 0;

        for (String diagPoint : points.keySet()) {

            String[] parts = diagPoint.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            int xDiff = Math.abs(point[0] - x);
            int yDiff = Math.abs(point[1] - y);

            if (xDiff == yDiff && xDiff != 0) {

                String topLeft = point[0] + "," + y;
                String bottomRight = x + "," + point[1];

                if (points.containsKey(topLeft) && points.containsKey(bottomRight)) {
                    squares += (points.get(topLeft) * points.get(bottomRight) * points.get(diagPoint));
                }
            }
        }
        return squares;
    }
}
