package CustomClasses;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class ProgressIndicatorBar extends StackPane {
    final private ReadOnlyDoubleProperty workDone;
    final private double totalWork;

    final private ProgressBar bar  = new ProgressBar();
    final private Text text = new Text();
    final private String labelFormatSpecifier;

    final private static int DEFAULT_LABEL_PADDING = 5;

    public ProgressIndicatorBar(final ReadOnlyDoubleProperty workDone, final double totalWork, final String labelFormatSpecifier, boolean moneyFlag) {
        this.workDone  = workDone;
        this.totalWork = totalWork;
        this.labelFormatSpecifier = labelFormatSpecifier;

        syncProgress(moneyFlag);
        workDone.addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                syncProgress(moneyFlag);
            }
        });

        bar.setMaxWidth(Double.MAX_VALUE); // allows the progress bar to expand to fill available horizontal space.

        getChildren().setAll(bar, text);
    }

    // synchronizes the progress indicated with the work done.
    private void syncProgress(boolean moneyFlag) {
        if (workDone == null || totalWork == 0) {
            text.setText("");
            bar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        } else {
            if(moneyFlag){
                text.setText("$"+String.format(labelFormatSpecifier, workDone.get()));
                bar.setProgress(workDone.get() / totalWork);
            }else{
                text.setText(String.format(labelFormatSpecifier, workDone.get()));
                bar.setProgress(workDone.get() / totalWork);
            }

        }

        bar.setMinHeight(text.getBoundsInLocal().getHeight() + DEFAULT_LABEL_PADDING);
        bar.setMinWidth (text.getBoundsInLocal().getWidth()  + DEFAULT_LABEL_PADDING);
    }
}