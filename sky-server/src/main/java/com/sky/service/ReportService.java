package com.sky.service;

import com.sky.result.Result;
import com.sky.vo.TurnoverReportVO;

import java.time.LocalDate;

public interface ReportService {

    // 统计营业额
    TurnoverReportVO turnoverStatistics(LocalDate begin, LocalDate end);
}
