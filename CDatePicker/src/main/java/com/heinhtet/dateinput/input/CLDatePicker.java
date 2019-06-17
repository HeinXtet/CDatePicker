package com.heinhtet.dateinput.input;

import android.content.Context;
import android.util.AttributeSet;

import java.time.LocalDate;

public class CLDatePicker extends CDatePicker {
    private LocalDate minDate;
    private LocalDate maxDate;
    //region CONSTRUCTORS
    public CLDatePicker(Context context) {
        this(context, null);
    }

    public CLDatePicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CLDatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
