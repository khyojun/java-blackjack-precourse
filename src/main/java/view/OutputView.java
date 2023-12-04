package view;

import com.sun.org.apache.xml.internal.serializer.OutputPropertyUtils;

public class OutputView {

    private static OutputView instance = new OutputView();


    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

}
