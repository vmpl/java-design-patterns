package pl.vm.javaguild.designpatterns.pattern.behavioral.memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanvasOriginatorTest {
	private CanvasOriginator canvas;

	@BeforeEach
	void setUp() {
		canvas = new CanvasOriginator();
	}

	@Test
	void testDraw() {
		canvas.draw("circle");
		assertEquals(" draw:circle", canvas.getContent());
	}

	@Test
	void testFill() {
		canvas.fill("red");
		assertEquals(" fill:red", canvas.getContent());
	}

	@Test
	void testSaveAndUndo() {
		canvas.draw("circle");
		CanvasMemento memento = canvas.save();
		canvas.fill("red");
		canvas.undoToLastSave(memento);
		assertEquals(" draw:circle", canvas.getContent());
	}
}