package pl.vm.javaguild.designpatterns.pattern.structural.facade.company;

import lombok.extern.slf4j.Slf4j;

/**
 * CompanyLawyer is one of the office subsystem
 */
@Slf4j
class CompanyLawyer implements CompanyWorker {

    @Override
    public void goHome() {
        log.info("It was very difficult day at work. Tomorrow will be hard as well!");
    }

    @Override
    public void goToOffice() {
        log.info("{} goes to the office at 6 AM", getName());
    }

    @Override
    public void bookHotel() {
        log.info("I need to find very comfortable hotel.");
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
    log.info("{} is protecting the company.", getName());
    }

    @Override
    public String getName() {
        return "Company lawyer";
    }
}
