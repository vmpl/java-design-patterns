package pl.vm.javaguild.designpatterns.pattern.structural.facade.company;

import lombok.extern.slf4j.Slf4j;

/**
 * CompanyDesigner is one of the office subsystem
 */
@Slf4j
class CompanyDesigner implements CompanyWorker {

    @Override
    public void goHome() {
        log.info("It was very creative day at work. Time to go back home!");
    }

    @Override
    public void goToOffice() {
        log.info("{} goes to the office at 9 AM", getName());
    }

    @Override
    public void bookHotel() {
        log.info("I need to find very stylish hotel.");
    }

    @Override
    public void bookTripInSystem() {
        log.info("Ehh, I love our system!");
    }

    @Override
    public void goToTheDestination(TransportWay transportWay) {
        log.info("{}", CompanyWorker.getTransportWayDescription(transportWay));
    }

    @Override
    public void work() {
      log.info("{} is creating great graphics.", getName());
    }

    @Override
    public String getName() {
        return "Company designer";
    }
}
