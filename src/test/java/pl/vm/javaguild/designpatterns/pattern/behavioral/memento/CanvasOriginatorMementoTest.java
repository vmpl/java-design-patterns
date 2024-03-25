package pl.vm.javaguild.designpatterns.pattern.behavioral.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanvasOriginatorMementoTest {

	@Test
	void testStateCapture() {
		CanvasOriginator canvas = new CanvasOriginator();
		canvas.draw("square");
		CanvasMemento memento = canvas.save();
		assertEquals("draw:square", memento.getState());
	}
}