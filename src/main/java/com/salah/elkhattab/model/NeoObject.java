package com.salah.elkhattab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author salah EL KHATTAB elkhatts@gmail.com
 * @version 1.0
 * @since 2018-04-18
 * @description This is the Near Earth Object Pojo holding information of near
 * earth Asteroid object
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeoObject {

    private String neo_reference_id;
    private String name;
    private String nasa_jpl_url;
    private double absolute_magnitude_h;
    private EstimatedDiameter estimated_diameter;
    private boolean is_potentially_hazardous_asteroid;
    private List<CloseApproachData> close_approach_data;

    /**
     *
     * @return
     */
    public String getNeo_reference_id() {
        return neo_reference_id;
    }

    /**
     *
     * @param neo_reference_id
     */
    public void setNeo_reference_id(String neo_reference_id) {
        this.neo_reference_id = neo_reference_id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getNasa_jpl_url() {
        return nasa_jpl_url;
    }

    /**
     *
     * @param nasa_jpl_url
     */
    public void setNasa_jpl_url(String nasa_jpl_url) {
        this.nasa_jpl_url = nasa_jpl_url;
    }

    /**
     *
     * @return
     */
    public double getAbsolute_magnitude_h() {
        return absolute_magnitude_h;
    }

    /**
     *
     * @param absolute_magnitude_h
     */
    public void setAbsolute_magnitude_h(double absolute_magnitude_h) {
        this.absolute_magnitude_h = absolute_magnitude_h;
    }

    /**
     *
     * @return
     */
    public EstimatedDiameter getEstimated_diameter() {
        return estimated_diameter;
    }

    /**
     *
     * @param estimated_diameter
     */
    public void setEstimated_diameter(EstimatedDiameter estimated_diameter) {
        this.estimated_diameter = estimated_diameter;
    }

    /**
     *
     * @return
     */
    public boolean isIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }

    /**
     *
     * @param is_potentially_hazardous_asteroid
     */
    public void setIs_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }

    /**
     *
     * @return
     */
    public List<CloseApproachData> getClose_approach_data() {
        return close_approach_data;
    }

    /**
     *
     * @param close_approach_data
     */
    public void setClose_approach_data(List<CloseApproachData> close_approach_data) {
        this.close_approach_data = close_approach_data;
    }

    /**
     *
     */
    public static class EstimatedDiameter {

        private Length kilometers;
        private Length meters;
        private Length miles;
        private Length feet;

        /**
         *
         * @return
         */
        public Length getKilometers() {
            return kilometers;
        }

        /**
         *
         * @param kilometers
         */
        public void setKilometers(Length kilometers) {
            this.kilometers = kilometers;
        }

        /**
         *
         * @return
         */
        public Length getMeters() {
            return meters;
        }

        /**
         *
         * @param meters
         */
        public void setMeters(Length meters) {
            this.meters = meters;
        }

        /**
         *
         * @return
         */
        public Length getMiles() {
            return miles;
        }

        /**
         *
         * @param miles
         */
        public void setMiles(Length miles) {
            this.miles = miles;
        }

        /**
         *
         * @return
         */
        public Length getFeet() {
            return feet;
        }

        /**
         *
         * @param feet
         */
        public void setFeet(Length feet) {
            this.feet = feet;
        }

        /**
         *
         */
        public static class Length {

            private double estimated_diameter_min;
            private double estimated_diameter_max;

            /**
             *
             * @return
             */
            public double getEstimated_diameter_min() {
                return estimated_diameter_min;
            }

            /**
             *
             * @param estimated_diameter_min
             */
            public void setEstimated_diameter_min(double estimated_diameter_min) {
                this.estimated_diameter_min = estimated_diameter_min;
            }

            /**
             *
             * @return
             */
            public double getEstimated_diameter_max() {
                return estimated_diameter_max;
            }

            /**
             *
             * @param estimated_diameter_max
             */
            public void setEstimated_diameter_max(double estimated_diameter_max) {
                this.estimated_diameter_max = estimated_diameter_max;
            }

            /**
             *
             * @return
             */
            @Override
            public String toString() {
                return "Length{"
                        + "estimated_diameter_min=" + estimated_diameter_min
                        + ", estimated_diameter_max=" + estimated_diameter_max
                        + '}';
            }

            /**
             *
             * @param o
             * @return
             */
            @Override
            public boolean equals(Object o) {
                boolean result = false;
                Length object = (Length) o;
                return estimated_diameter_min == object.getEstimated_diameter_min() && estimated_diameter_max == object.getEstimated_diameter_max();
            }
        }

        /**
         *
         * @return
         */
        @Override
        public String toString() {
            return "EstimatedDiameter{"
                    + "kilometers=" + kilometers
                    + ", meters=" + meters
                    + ", miles=" + miles
                    + ", feet=" + feet
                    + '}';
        }

        /**
         *
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            EstimatedDiameter object = (EstimatedDiameter) o;
            return getKilometers().equals(object.getKilometers())
                    && getMeters().equals(object.getMeters())
                    && getMiles().equals(object.getMiles())
                    && getFeet().equals(object.getFeet());
        }
    }

    /**
     *
     */
    public static class CloseApproachData {

        private String close_approach_date;
        private long epoch_date_close_approach;
        private RelativeVelocity relative_velocity;
        private MissDistance miss_distance;
        private String orbiting_body;

        /**
         *
         * @return
         */
        public String getClose_approach_date() {
            return close_approach_date;
        }

        /**
         *
         * @param close_approach_date
         */
        public void setClose_approach_date(String close_approach_date) {
            this.close_approach_date = close_approach_date;
        }

        /**
         *
         * @return
         */
        public long getEpoch_date_close_approach() {
            return epoch_date_close_approach;
        }

        /**
         *
         * @param epoch_date_close_approach
         */
        public void setEpoch_date_close_approach(long epoch_date_close_approach) {
            this.epoch_date_close_approach = epoch_date_close_approach;
        }

        /**
         *
         * @return
         */
        public RelativeVelocity getRelative_velocity() {
            return relative_velocity;
        }

        /**
         *
         * @param relative_velocity
         */
        public void setRelative_velocity(RelativeVelocity relative_velocity) {
            this.relative_velocity = relative_velocity;
        }

        /**
         *
         * @return
         */
        public MissDistance getMiss_distance() {
            return miss_distance;
        }

        /**
         *
         * @param miss_distance
         */
        public void setMiss_distance(MissDistance miss_distance) {
            this.miss_distance = miss_distance;
        }

        /**
         *
         * @return
         */
        public String getOrbiting_body() {
            return orbiting_body;
        }

        /**
         *
         * @param orbiting_body
         */
        public void setOrbiting_body(String orbiting_body) {
            this.orbiting_body = orbiting_body;
        }

        /**
         *
         */
        public static class RelativeVelocity {

            private String kilometers_per_second;
            private String kilometers_per_hour;
            private String miles_per_hour;

            /**
             *
             * @return
             */
            public String getKilometers_per_second() {
                return kilometers_per_second;
            }

            /**
             *
             * @param kilometers_per_second
             */
            public void setKilometers_per_second(String kilometers_per_second) {
                this.kilometers_per_second = kilometers_per_second;
            }

            /**
             *
             * @return
             */
            public String getKilometers_per_hour() {
                return kilometers_per_hour;
            }

            /**
             *
             * @param kilometers_per_hour
             */
            public void setKilometers_per_hour(String kilometers_per_hour) {
                this.kilometers_per_hour = kilometers_per_hour;
            }

            /**
             *
             * @return
             */
            public String getMiles_per_hour() {
                return miles_per_hour;
            }

            /**
             *
             * @param miles_per_hour
             */
            public void setMiles_per_hour(String miles_per_hour) {
                this.miles_per_hour = miles_per_hour;
            }

            /**
             *
             * @return
             */
            @Override
            public String toString() {
                return "RelativeVelocity{"
                        + "kilometers_per_second='" + kilometers_per_second + '\''
                        + ", kilometers_per_hour='" + kilometers_per_hour + '\''
                        + ", miles_per_hour='" + miles_per_hour + '\''
                        + '}';
            }

            /**
             *
             * @param o
             * @return
             */
            @Override
            public boolean equals(Object o) {
                RelativeVelocity object = (RelativeVelocity) o;
                return getKilometers_per_second().equalsIgnoreCase(object.getKilometers_per_second())
                        && getKilometers_per_hour().equalsIgnoreCase(object.getKilometers_per_hour())
                        && getMiles_per_hour().equalsIgnoreCase(object.getMiles_per_hour());
            }
        }

        /**
         *
         */
        public static class MissDistance {

            private String astronomical;
            private String lunar;
            private String kilometers;
            private String miles;

            /**
             *
             * @return
             */
            public String getAstronomical() {
                return astronomical;
            }

            /**
             *
             * @param astronomical
             */
            public void setAstronomical(String astronomical) {
                this.astronomical = astronomical;
            }

            /**
             *
             * @return
             */
            public String getLunar() {
                return lunar;
            }

            /**
             *
             * @param lunar
             */
            public void setLunar(String lunar) {
                this.lunar = lunar;
            }

            /**
             *
             * @return
             */
            public String getKilometers() {
                return kilometers;
            }

            /**
             *
             * @param kilometers
             */
            public void setKilometers(String kilometers) {
                this.kilometers = kilometers;
            }

            /**
             *
             * @return
             */
            public String getMiles() {
                return miles;
            }

            /**
             *
             * @param miles
             */
            public void setMiles(String miles) {
                this.miles = miles;
            }

            /**
             *
             * @return
             */
            @Override
            public String toString() {
                return "MissDistance{"
                        + "astronomical='" + astronomical + '\''
                        + ", lunar='" + lunar + '\''
                        + ", kilometers='" + kilometers + '\''
                        + ", miles='" + miles + '\''
                        + '}';
            }

            /**
             *
             * @param o
             * @return
             */
            @Override
            public boolean equals(Object o) {
                MissDistance object = (MissDistance) o;
                return getAstronomical().equalsIgnoreCase(object.getAstronomical())
                        && getLunar().equalsIgnoreCase(object.getLunar())
                        && getKilometers().equalsIgnoreCase(object.getKilometers())
                        && getMiles().equalsIgnoreCase(object.getMiles());

            }
        }

        /**
         *
         * @return
         */
        @Override
        public String toString() {
            return "CloseApproachData{"
                    + "close_approach_date='" + close_approach_date + '\''
                    + ", epoch_date_close_approach=" + epoch_date_close_approach
                    + ", relative_velocity=" + relative_velocity
                    + ", miss_distance=" + miss_distance
                    + ", orbiting_body='" + orbiting_body + '\''
                    + '}';
        }

        /**
         *
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            CloseApproachData object = (CloseApproachData) o;
            return getClose_approach_date().equalsIgnoreCase(object.getClose_approach_date())
                    && getOrbiting_body().equalsIgnoreCase(object.getOrbiting_body())
                    && getEpoch_date_close_approach() == object.getEpoch_date_close_approach()
                    && getRelative_velocity().equals(object.getRelative_velocity())
                    && getMiss_distance().equals(object.getMiss_distance());
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "NearEarthObject{"
                + "neo_reference_id='" + neo_reference_id + '\''
                + ", name='" + name + '\''
                + ", nasa_jpl_url='" + nasa_jpl_url + '\''
                + ", absolute_magnitude_h=" + absolute_magnitude_h
                + ", estimated_diameter=" + estimated_diameter
                + ", is_potentially_hazardous_asteroid=" + is_potentially_hazardous_asteroid
                + ", close_approach_data=" + close_approach_data
                + '}';
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        NeoObject object = (NeoObject) o;
        return getName().equalsIgnoreCase(object.getName())
                && getNeo_reference_id().equalsIgnoreCase(object.getNeo_reference_id())
                && getNasa_jpl_url().equalsIgnoreCase(object.getNasa_jpl_url())
                && getAbsolute_magnitude_h() == object.getAbsolute_magnitude_h()
                && getEstimated_diameter().equals(object.getEstimated_diameter())
                && isIs_potentially_hazardous_asteroid() == object.isIs_potentially_hazardous_asteroid()
                && getClose_approach_data().equals(object.getClose_approach_data());
    }
}
