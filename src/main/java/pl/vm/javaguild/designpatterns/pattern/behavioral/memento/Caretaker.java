package pl.vm.javaguild.designpatterns.pattern.behavioral.memento;

import java.util.LinkedList;
import java.util.List;

class Caretaker {
	private final List<CanvasMemento> saveStates = new LinkedList<>();
	private final CanvasOriginator canvas;

	public Caretaker(CanvasOriginator canvas) {
		this.canvas = canvas;
	}

	// Saving state of the originator
	public void save() {
		if (saveStates.size() > 10) {
			saveStates.remove(0); // ensure only 10 states are kept
		}
		saveStates.add(canvas.save());
	}

	public void undo() {
		if (!saveStates.isEmpty()) {
			CanvasMemento memento = saveStates.remove(saveStates.size() - 1);
			canvas.undoToLastSave(memento);
		}
	}

	int savedStatesSize(){
		return saveStates.size();
	}
	// Restoring state
}