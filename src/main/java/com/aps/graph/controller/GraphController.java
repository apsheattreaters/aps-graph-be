package com.aps.graph.controller;

import com.aps.graph.domain.GraphData;
import com.aps.graph.service.GraphServices;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class GraphController {
    private final GraphServices graphServices;

    @GetMapping("/data")
    public ResponseEntity<Map<String,List<GraphData>>> getTemperatureData(
            @RequestParam(name="furnace") String furnace,
            @RequestParam(name="fromTime") String fromTime,
            @RequestParam(name="toTime") String toTime,
            @RequestParam(name="interval") String interval){


        Map<String,List<GraphData>> listMap = new HashMap<>();
        List<GraphData> data = graphServices.getData(furnace, fromTime, toTime);
        List<GraphData> intervalData = Strings.isNotBlank(interval)
                ? IntStream.range(0, data.size()).filter(n->n%Integer.parseInt(interval)==0).mapToObj(data::get).collect(Collectors.toList())
                : data;
        listMap.put("data",intervalData);
        return ResponseEntity.ok(listMap);
    }
}
