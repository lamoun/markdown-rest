package com.lminaiev.markdown.repository;

import com.lminaiev.markdown.entity.StatisticsRecord;

import java.util.List;

/**
 * Statistics Repository
 *
 * @author Leonid Minaiev
 */
public interface StatisticsRepository {

    /**
     * Saves statistics record into storage
     * @param record record to store
     * @return record
     */
    void save(StatisticsRecord record);


    /**
     * Returns all records from storage
     * @return list of records
     */
    List<StatisticsRecord> getAllRecords();

}
