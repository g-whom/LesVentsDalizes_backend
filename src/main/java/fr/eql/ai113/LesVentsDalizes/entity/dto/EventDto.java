package fr.eql.ai113.LesVentsDalizes.entity.dto;




public class EventDto {

    /**
     * This class reprents the type of events for wich q performance request would be associated
     */

    public class Event {

        private Long id;


        private String label;

        /**
         * the state will be used to display or hide the item in the available list
         */
        boolean available;

        //--[WIP]------------CLASS >> --- Links

        public Long getId() {
            return id;
        }

        public String getLabel() {
            return label;
        }

        public boolean isAvailable() {
            return available;
        }

        /// SETTERS ///

        public void setId(Long id) {
            this.id = id;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        /// TO_STRING ///


        @Override
        public String toString() {
            return "Event{" +
                    "id=" + id +
                    ", label='" + label + '\'' +
                    ", available=" + available +
                    '}';
        }
    }

}
