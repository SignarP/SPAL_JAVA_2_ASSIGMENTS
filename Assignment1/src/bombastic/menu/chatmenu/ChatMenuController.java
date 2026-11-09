package bombastic.menu.chatmenu;

import bombastic.State;
import java.util.function.Consumer;

public class ChatMenuController {

    private final ChatMenuModel model;
    private final ChatMenuView view;

    private final Consumer<State> changeState;

    public ChatMenuController(Consumer<State> changeState) {

        this.changeState = changeState;

        model = new ChatMenuModel();

        view = new ChatMenuView(this::openMainMenu);
    }

    private void openMainMenu() {
        changeState.accept(State.MAIN_MENU_ACTIVE);
    }

    public ChatMenuView getView() {
        return view.build();
    }
}