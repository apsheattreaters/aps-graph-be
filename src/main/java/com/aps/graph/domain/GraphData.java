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
        long setMv;
        long setOt;
        long setCp;
        long actualMv;
        long actualOt;
        long actualCp;
}
