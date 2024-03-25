package pl.vm.javaguild.designpatterns.pattern.behavioral.memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaretakerTest {
	private CanvasOriginator canvas;
	private Caretaker caretaker;

	@BeforeEach
	void setUp() {
		canvas = new CanvasOriginator();
		caretaker = new Caretaker(canvas);
	}

	@Test
	void testSaveAndUndo() {
		canvas.draw("circle");
		caretaker.save();
		canvas.fill("red");
		caretaker.undo();

		assertEquals(" draw:circle", canvas.getContent());
	}

	@Test
	void testUndoLimit() {
		for (int i = 0; i <= 12; i++) {
			canvas.draw("shape" + i);
			caretaker.save();
		}
		caretaker.undo(); // Undo the last state, should be "shape10"
		assertEquals(10, caretaker.savedStatesSize());
		assertEquals(drawShapes(12), canvas.getContent());
	}

	private String drawShapes(int size) {
		StringBuilder builder = new StringBuilder(" ");
		for (int i = 0; i <= size; i++) {
			builder.append("draw:shape").append(i);
			if (i < size) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}
}