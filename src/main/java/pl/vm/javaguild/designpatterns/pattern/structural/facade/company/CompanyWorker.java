package pl.vm.javaguild.designpatterns.pattern.structural.facade.company;

/**
 * CompanyOfficeWorker is one of the office subsystem
 */
 interface CompanyWorker {
    void goHome();
    void goToOffice();
    void work();
    String getName();
    void bookHotel();
    void goToTheDestination(TransportWay transportWay);
    void bookTripInSystem();

     static String getTransportWayDescription(TransportWay transportWay) {

        switch (transportWay) {
            case CAR -> {
                return "It will be a nice trip by a car.";
            }
            case PLANE -> {
                return "It will be a nice trip by a plane.";
            }
            case TRAIN -> {
                return "It will be a nice trip by a train.";
            }
            default -> {
                return "No transport provided";
            }
        }
    }
}