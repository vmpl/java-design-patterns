package pl.vm.javaguild.designpatterns.pattern.structural.facade.company;

import java.util.List;

/**
 * CompanyOfficeFacade provides a single interface through which users can operate the
 * subsystems.
 *
 * <p> This makes the office easier to operate and cuts the dependencies from the office user to
 * the subsystems.
 */
public class CompanyFacade {

    private final List<CompanyWorker> workers;

    public CompanyFacade() {
       workers = List.of(
               new CompanyRecruiter(),
               new CompanyLawyer(),
               new CompanyDesigner());
    }

   public void workDay() {
        workers.forEach(CompanyWorker::goToOffice);
        workers.forEach(CompanyWorker::work);
        workers.forEach(CompanyWorker::goHome);

   }

   public void delegationTrip() {

        workers.forEach(CompanyWorker::bookTripInSystem);
        workers.forEach(CompanyWorker::bookHotel);
        workers.forEach(worker -> worker.goToTheDestination(TransportWay.CAR));
   }
}
