package com.aps.graph.service;

import com.aps.graph.domain.GraphData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GraphServices {
    private final JdbcTemplate jdbcTemplate;

    public List<GraphData> getData(String furnace, String fromTime, String toTime) {
            String query = "SELECT DDATE,"+furnace+" FROM apsheat.logs_tbl where DDATE between '"+fromTime+"' and '"+toTime+"'";
            log.info(query);

            return jdbcTemplate.query(query, (rs,rowNum) -> {

                return new GraphData(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7));
            });
    }
}
