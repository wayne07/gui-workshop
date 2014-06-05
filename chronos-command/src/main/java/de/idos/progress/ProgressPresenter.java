package de.idos.progress;

public class ProgressPresenter {

    private final ProgressGui progressGui;
    private final ProgressModel model;

    public ProgressPresenter(ProgressGui progressGui, ProgressModel model) {
        this.progressGui = progressGui;
        this.model = model;
    }

    public void present() {
    }

}
