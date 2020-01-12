package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CommandManager extends Observable {

	private  List<Command> commands;
	
	private  int index;
	
	public CommandManager() {
		commands = new ArrayList<>();
		index =-1;
	}
	
	public void addCommand(Command newCommand) {
		if(index < getNumberOfCommands()-1 ) {
			for(int i =index+1; i< getNumberOfCommands(); i++) {
				commands.remove(i);
			}
		}
		commands.add(newCommand);
		increment();
	}
	
	public void increment() {
		index++;
		setChanged();
		notifyObservers();
	}
	
	public void decrement() {
		index--;
		setChanged();
		notifyObservers();
	
	}
	
	public Command getCommand() {
		return commands.get(index);
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getNumberOfCommands() {
		return commands.size();
	}
}
