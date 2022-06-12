package com.aps.graph.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraphData {
        String timestamp;
        double actualMv;
        double setMv;
        double actualOt;
        double setOt;
        double actualCp;
        double setCp;
}
