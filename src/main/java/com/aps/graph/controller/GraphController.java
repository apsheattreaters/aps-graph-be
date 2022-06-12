package com.aps.graph.controller;

import com.aps.graph.domain.GraphData;
import com.aps.graph.service.GraphServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GraphController {
    private final GraphServices graphServices;

    @GetMapping("/data")
    public ResponseEntity<Map<String,List<GraphData>>> getTemperatureData(
            @RequestParam(name="furnace") String furnace,
            @RequestParam(name="fromTime") String fromTime,
            @RequestParam(name="toTime") String toTime){
        Map<String,List<GraphData>> listMap = new HashMap<>();
        List<GraphData> data = graphServices.getData(furnace, fromTime, toTime);
        listMap.put("data", data);
        return ResponseEntity.ok(listMap);
    }
}
