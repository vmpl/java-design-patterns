package pl.vm.javaguild.designpatterns.pattern.structural.facade;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import pl.vm.javaguild.designpatterns.pattern.structural.facade.company.CompanyFacade;

import java.util.LinkedList;
import java.util.List;

class CompanyTest {

	private CustomAppender appender;

	@BeforeEach
	void init() {
		appender = new CustomAppender();
	}
	@AfterEach
	void clean() {
		appender.stop();
	}
	@Test
	void should_test_whole_work_day() {

		CompanyFacade companyFacade = new CompanyFacade();
		companyFacade.workDay();

		Assertions.assertTrue(appender.logContains("Company designer is creating great graphics."));
		Assertions.assertTrue(appender.logContains("Company lawyer is protecting the company."));
		Assertions.assertTrue(appender.logContains("Company recruiter is looking for a perfect employee."));

		Assertions.assertEquals(9, appender.getLogSize());

	}

	@Test
	void should_test_delegation_trip() {
		CompanyFacade companyFacade = new CompanyFacade();
		companyFacade.delegationTrip();

		Assertions.assertTrue(appender.logContains("Ehh, I love our system!"));

		Assertions.assertEquals(9, appender.getLogSize());

	}
	private static class CustomAppender extends AppenderBase<ILoggingEvent> {

		private final List<ILoggingEvent> loggingEvents = new LinkedList<>();

		public CustomAppender() {
			((Logger) LoggerFactory.getLogger("root")).addAppender(this);
			start();
		}

		@Override
		protected void append(ILoggingEvent eventObject) {
			loggingEvents.add(eventObject);
		}

		public int getLogSize() {
			return loggingEvents.size();
		}

		public boolean logContains(String message) {
			return loggingEvents.stream()
					.map(ILoggingEvent::getFormattedMessage)
					.anyMatch(message::equals);
		}
	}

}
