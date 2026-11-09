package bombastic.menu.settingsmenu;

import bombastic.Model;

public class SettingsMenuModel {

    private final Model model;

    public SettingsMenuModel(Model model) {
        this.model = model;
    }

    public void changeBackground(String image) {
        model.setBackground(image);
    }

    public void changeArena(String arena) {
        model.setArena(arena);
    }
}