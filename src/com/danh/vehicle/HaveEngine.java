package com.danh.vehicle;

import java.time.LocalDate;

public interface HaveEngine {
    void checkEngine();

    void mantainance();

    LocalDate mantainanceDate();
}
