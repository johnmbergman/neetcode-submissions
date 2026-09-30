class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        final int n = position.length;
        final List<Car> cars = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort((a, b) -> Integer.compare(b.position, a.position));

        final Car frontCar = cars.get(0);
        double frontCarTime = finishTime(frontCar, target);
        int fleets = 1;
        for (int i = 1; i < n; i++) {
            final Car backCar = cars.get(i);
            double backCarTime = finishTime(backCar, target);
            if (backCarTime > frontCarTime) {
                fleets++;
                frontCarTime = backCarTime;
            }
        }

        return fleets;
    }

    private double finishTime(final Car car, final int target) {
        return (double)(target - car.position) / car.speed;
    }

    private static class Car {
        private final int position;
        private final int speed;

        private Car(final int position, final int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
