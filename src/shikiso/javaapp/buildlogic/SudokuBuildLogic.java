package shikiso.javaapp.buildlogic;

import java.io.IOException;

import shikiso.javaapp.computationlogic.GameLogic;
import shikiso.javaapp.persitence.LocalStorageImpl;
import shikiso.javaapp.problemdomain.IStorage;
import shikiso.javaapp.problemdomain.SudokuGame;
import shikiso.javaapp.userinterface.IUserInterfaceContract;
import shikiso.javaapp.userinterface.logic.ControlLogic;

public class SudokuBuildLogic {
	
	public static void build(IUserInterfaceContract.View userInterface) throws IOException {
		SudokuGame initialState;
		IStorage storage = new LocalStorageImpl();
		
		try {
			initialState = storage.getGameData();
		} catch(IOException e) {
			initialState = GameLogic.getNewGame();
			storage.updateGameData(initialState);
		}
		
		IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
		
		userInterface.setListener(uiLogic);
		userInterface.updateBoard(initialState);
	}
}
