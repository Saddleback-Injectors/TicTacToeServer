package edu.saddleback.cs4b.UI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ServerController
{
    @FXML
    private Button eventLogButton;

    @FXML
    private Button activeGamesButton;

    @FXML
    private Button completedGamesButton;

    @FXML
    private Button playersButton;

    @FXML
    private BorderPane viewScreen;

    /**
     * WHEN THIS METHOD IS CALLED THE 'EVENT LOG' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightEventLog()
    {
        eventLogButton.setOnMouseEntered(mouseEvent -> eventLogButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'EVENT LOG' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetEventLog()
    {
        eventLogButton.setOnMouseExited(mouseEvent -> eventLogButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ACTIVE GAMES' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightActiveGames()
    {
        activeGamesButton.setOnMouseEntered(mouseEvent -> activeGamesButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ACTIVE GAMES' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetActiveGames()
    {
        activeGamesButton.setOnMouseExited(mouseEvent -> activeGamesButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'COMPLETED GAMES' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightCompletedGames()
    {
        completedGamesButton.setOnMouseEntered(mouseEvent -> completedGamesButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'COMPLETED GAMES' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetCompletedGames()
    {
        completedGamesButton.setOnMouseExited(mouseEvent -> completedGamesButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'PLAYERS' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightPlayers()
    {
        playersButton.setOnMouseEntered(mouseEvent -> playersButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'PLAYERS' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetPlayers()
    {
        playersButton.setOnMouseExited(mouseEvent -> playersButton.setTextFill(Color.WHITE));
    }


    @FXML
    public void handleEventLogAction()
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("EventLog");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleActiveGamesAction()
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ActiveGames");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleCompletedGamesAction()
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("CompletedGames");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handlePlayersAction()
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Players");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleShowCompletedGamesAction()
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("CompletedGames");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleShowGameDetailsAction()
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ShowGameDetails");
        viewScreen.setCenter(view);
    }
}
