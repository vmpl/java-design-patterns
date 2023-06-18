package pl.vm.javaguild.designpatterns.pattern.structural.facade.company;

import lombok.extern.slf4j.Slf4j;

/**
 * CompanyRecruiter is one of the office subsystem
 */
@Slf4j
class CompanyRecruiter implements CompanyWorker {

    @Override
    public void goHome() {
        log.info("It was very intense day at work. I go home!");
    }

    @Override
    public void goToOffice() {
        log.info("{} goes to the office at 8 AM", getName());
    }

    @Override
    public void bookHotel() {
        log.info("I need to find cheap and good hotel.");
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
        log.info("{} is looking for a perfect employee.", getName());
    }

    @Override
    public String getName() {
        return "Company recruiter";
    }
}
