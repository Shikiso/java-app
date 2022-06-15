package shikiso.javaapp;

import java.io.IOException;

public class SudokuApplication {
	private IUserInterfaceContract.View uiImpl;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		uiImpl = new User InterfaceImpl(primaryStage);
		try {
			SudokuBuildLogic.build(uiImpl);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
