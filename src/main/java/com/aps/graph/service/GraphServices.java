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
    private static final String FURNACE1 = "furnace1";
    private final JdbcTemplate jdbcTemplate;

    public List<GraphData> getData(String furnace, String fromTime, String toTime) {
            String query = "SELECT DDATE,"+furnace+" FROM apsheat.logs_tbl where DDATE between '"+fromTime+"' and '"+toTime+"'";
            log.info(query);

            return jdbcTemplate.query(query, (rs,rowNum) -> {

                return new GraphData(
                        rs.getString(1),
                        rs.getLong(2),
                        rs.getLong(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getLong(6)
                        ,rs.getLong(7));
            });
    }
}
